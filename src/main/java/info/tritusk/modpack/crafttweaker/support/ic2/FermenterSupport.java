package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.Recipes;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.Fermenter")
@ZenRegister
public final class FermenterSupport {

    @ZenMethod
    public static void addRecipe(ILiquidStack output, ILiquidStack input, int heat) {
        CraftTweakerActions.apply(new FermentationAction(CraftTweakerMC.getLiquidStack(input), CraftTweakerMC.getLiquidStack(output), heat));
    }

    private static final class FermentationAction implements IAction {

        private final FluidStack input, output;
        private final int heat;

        FermentationAction(FluidStack input, FluidStack output, int heat) {
            this.input = input;
            this.output = output;
            this.heat = heat;
        }

        @Override
        public void apply() {
            Recipes.fermenter.addRecipe(this.input.getFluid().getName(), input.amount, heat, output.getFluid().getName(), output.amount);
        }

        @Override
        public String describe() {
            return null;
        }
    }

}
