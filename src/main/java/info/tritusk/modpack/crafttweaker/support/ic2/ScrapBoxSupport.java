package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.WeightedItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.IScrapboxManager;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@ModOnly("ic2")
@ZenClass("mods.ic2.ScrapBox")
@ZenRegister
public final class ScrapBoxSupport {

    @ZenMethod
    public static void addDrop(WeightedItemStack weightedItem) {
        CraftTweakerActions.apply(new AddScrapBoxDropAction(weightedItem));
    }

    @ZenMethod
    public static void addDrop(IItemStack item, float chance) {
        CraftTweakerActions.apply(new AddScrapBoxDropAction(item, chance));
    }

    @ZenMethod
    public static void removeDrop(IItemStack item) {
        CraftTweakerActions.apply(new RemoveScrapBoxDropAction(item));
    }

    private static final class AddScrapBoxDropAction implements IAction {

        private final float weight;
        private final ItemStack item;

        AddScrapBoxDropAction(WeightedItemStack weightedItem) {
            this(weightedItem.getStack(), weightedItem.getChance());
        }

        AddScrapBoxDropAction(IItemStack item, float weight) {
            this.item = CraftTweakerMC.getItemStack(item);
            this.weight = weight;
        }

        @Override
        public void apply() {
            //Recipes.scrapboxDrops.addDrop(this.item, this.weight);
            Impl.entriesToAdd.add(new AbstractMap.SimpleImmutableEntry<>(this.item, this.weight));
        }

        @Override
        public String describe() {
            return null;
        }
    }

    private static final class RemoveScrapBoxDropAction implements IAction {

        private final ItemStack item;

        RemoveScrapBoxDropAction(IItemStack item) {
            this.item = CraftTweakerMC.getItemStack(item);
        }

        @Override
        public void apply() {
            Impl.entriesToRemove.add(this.item);
        }

        @Override
        public String describe() {
            return null;
        }
    }

    static final class Impl {
        static List<Map.Entry<ItemStack, Float>> entriesToAdd = new ArrayList<>();
        static List<ItemStack> entriesToRemove = new ArrayList<>();

        static void rebuildScrapBoxPool() {
            IScrapboxManager manager = Recipes.scrapboxDrops;
            List<Map.Entry<ItemStack, Float>> rebuilt = new ArrayList<>();
            float originalTopChance = getOriginalTopChance();
            outer: for (Map.Entry<ItemStack, Float> entry : manager.getDrops().entrySet()) {
                for (Iterator<ItemStack> itr = entriesToRemove.iterator(); itr.hasNext();) {
                    ItemStack toCheck = itr.next();
                    if (toCheck.isItemEqual(entry.getKey())) {
                        itr.remove();
                        continue outer;
                    }
                }
                rebuilt.add(new AbstractMap.SimpleImmutableEntry<>(entry.getKey(), entry.getValue() * originalTopChance));
            }
            rebuilt.addAll(entriesToAdd);
            rebuilt.sort(Map.Entry.<ItemStack, Float>comparingByValue().reversed());

            boolean cleared = false;
            try {
                cleared = resetScrapBoxPool(manager);
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }

            if (cleared) {
                for (Map.Entry<ItemStack, Float> entry : rebuilt) {
                    manager.addDrop(entry.getKey(), entry.getValue());
                }
            }
        }

        static float getOriginalTopChance() {
            try {
                Field topChance = Class.forName("ic2.core.recipe.ScrapboxRecipeManager$Drop").getDeclaredField("topChance");
                topChance.setAccessible(true);
                return topChance.getFloat(null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        static boolean resetScrapBoxPool(IScrapboxManager manager) throws Exception {
            Field pool = Class.forName("ic2.core.recipe.ScrapboxRecipeManager").getDeclaredField("drops");
            pool.setAccessible(true);
            List<? super Object> fresh = new ArrayList<>();
            pool.set(manager, fresh); // Though types are erased anyway

            Field topChance = Class.forName("ic2.core.recipe.ScrapboxRecipeManager$Drop").getDeclaredField("topChance");
            topChance.setAccessible(true);
            topChance.setFloat(null, 0F);

            return true;
        }
    }
}
