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
@ZenClass("mods.ic2.SemiFluidGenerator")
@ZenRegister
public final class SemiFluidGeneratorSupport {

    @ZenMethod
    public static void addFluid(ILiquidStack liquid, double powerOutput) {
        CraftTweakerActions.apply(new SemiFluidGeneratorFuelAction(liquid, powerOutput));
    }

    private static final class SemiFluidGeneratorFuelAction implements IAction {

        private final FluidStack fluid;
        private final double power;

        SemiFluidGeneratorFuelAction(ILiquidStack liquid, double power) {
            this.fluid = CraftTweakerMC.getLiquidStack(liquid);
            this.power = power;
        }

        @Override
        public void apply() {
            Recipes.semiFluidGenerator.addFluid(this.fluid.getFluid().getName(), this.fluid.amount, (long) this.power);
        }

        @Override
        public String describe() {
            return null;
        }
    }

}
