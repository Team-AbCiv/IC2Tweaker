package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.WeightedItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.ScrapBox")
@ZenRegister
public final class ScrapBoxSupport {

    @ZenMethod
    public static void addDrop(WeightedItemStack weightedItem) {
        ScrapBoxSupport.addDrop(weightedItem.getStack(), weightedItem.getChance());
    }

    @ZenMethod
    public static void addDrop(IItemStack item, float chance) {
        Recipes.scrapboxDrops.addDrop(CraftTweakerMC.getItemStack(item), chance);
    }
}
