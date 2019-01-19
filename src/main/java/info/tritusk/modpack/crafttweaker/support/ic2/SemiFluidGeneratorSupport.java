package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.SemiFluidGenerator")
@ZenRegister
public final class SemiFluidGeneratorSupport {

    @ZenMethod
    public static void addFluid(ILiquidStack liquid, double powerOutput) {
        Recipes.semiFluidGenerator.addFluid(liquid.getName(), liquid.getAmount(), powerOutput);
    }

}
