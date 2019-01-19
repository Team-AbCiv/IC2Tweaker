package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.Macerator")
@ZenRegister
public final class MaceratorSupport {

    @ZenMethod
    public static void addRecipe(IItemStack output, IIngredient input) {
        Recipes.macerator.addRecipe(IC2RecipeInputs.of(input), null, false, CraftTweakerMC.getItemStack(output));
    }
}
