package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.ISemiFluidFuelManager;
import ic2.api.recipe.Recipes;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.lang.reflect.Method;

@ModOnly("ic2")
@ZenClass("mods.ic2.SemiFluidGenerator")
@ZenRegister
public final class SemiFluidGeneratorSupport {

    @ZenMethod
    public static void addFluid(ILiquidStack liquid, double powerOutput) {
        CraftTweakerActions.apply(new SemiFluidGeneratorFuelAction(liquid, powerOutput));
    }

    private static final class SemiFluidGeneratorFuelAction implements IAction {

        /*
         * Before 2.8.216-ex122 (exclusive), the method signature was addFluid(String, int, double)
         * which means "fluid type", "fluid consumption per tick (unit mB/tick)", "power output per
         * tick (unit EU/tick)".
         * After 2.8.216-ex122 (inclusive), the method signature was changed to addFluid(String, long,
         * long) which means "fluid type", "power output per 1 mB fluid (unit EU/mB)", "power output
         * per tick (unit EU/tick)".
         * We can only compile against one of the method. We chose to compile against newer method,
         * and provide backward compatibility via reflection.
         */
        private static Method oldSemiFluidGeneratorAddFluidPrior215;

        static {
            try {
                oldSemiFluidGeneratorAddFluidPrior215 = ISemiFluidFuelManager.class.getDeclaredMethod("addFluid", String.class, int.class, double.class);
            } catch (Exception ignored) {
                // This means that we are not on old versions.
            }
        }

        private final FluidStack fluid;
        private final double power;

        SemiFluidGeneratorFuelAction(ILiquidStack liquid, double power) {
            this.fluid = CraftTweakerMC.getLiquidStack(liquid);
            this.power = power;
        }

        @Override
        public void apply() {
            if (oldSemiFluidGeneratorAddFluidPrior215 != null) {
                try {
                    oldSemiFluidGeneratorAddFluidPrior215.invoke(Recipes.semiFluidGenerator,
                            this.fluid.getFluid().getName(), this.fluid.amount, this.power);
                } catch (Exception e) {
                    CraftTweakerAPI.logError("Failed to add new fuel for Semi-fluid Generator using legacy method. "
                            + "Please report back to IC2Tweaker.", e);
                }
            } else {
                long mbPerTick = (long) (this.power / this.fluid.amount);
                Recipes.semiFluidGenerator.addFluid(this.fluid.getFluid().getName(), mbPerTick, (long) this.power);
            }
        }

        @Override
        public String describe() {
            return null;
        }
    }

}
