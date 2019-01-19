package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.WeightedItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.concurrent.Callable;

@ModOnly("ic2")
@ZenClass("mods.ic2.ScrapBox")
@ZenRegister
public final class ScrapBoxSupport {

    @ZenMethod
    public static void addDrop(WeightedItemStack weightedItem) {
        CraftTweakerAPI.apply(new AddScrapBoxDropAction(weightedItem));
    }

    @ZenMethod
    public static void addDrop(IItemStack item, float chance) {
        CraftTweakerAPI.apply(new AddScrapBoxDropAction(item, chance));
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
            Recipes.scrapboxDrops.addDrop(this.item, this.weight);
        }

        @Override
        public String describe() {
            return null;
        }
    }
}
