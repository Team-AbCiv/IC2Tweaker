package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.Fermenter")
@ZenRegister
public final class FermenterSupport {

    @ZenMethod
    public static void addRecipe(ILiquidStack output, ILiquidStack input, int heat) {
        Recipes.fermenter.addRecipe(input.getName(), input.getAmount(), heat, output.getName(), output.getAmount());
    }

}
