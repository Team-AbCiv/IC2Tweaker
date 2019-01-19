package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.Recycler")
@ZenRegister
public final class RecyclerSupport {

    @ZenMethod
    public static void addBlacklist(IItemStack item) {
        Recipes.recyclerBlacklist.add(IC2RecipeInputs.of(item));
    }

    @ZenMethod
    public static void addBlacklist(IIngredient ingredient) {
        Recipes.recyclerBlacklist.add(IC2RecipeInputs.of(ingredient));
    }
}
