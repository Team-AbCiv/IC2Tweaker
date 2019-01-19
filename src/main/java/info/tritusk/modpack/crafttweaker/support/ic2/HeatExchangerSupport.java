package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidDefinition;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.ILiquidHeatExchangerManager;
import ic2.api.recipe.Recipes;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.HeatExchanger")
@ZenRegister
public final class HeatExchangerSupport {

    @ZenMethod
    public static void addFluidCoolDown(ILiquidStack output, ILiquidStack input, int heat) {
        CraftTweakerActions.apply(new HeatExchangeAction(Recipes.liquidCooldownManager, CraftTweakerMC.getLiquidStack(input), CraftTweakerMC.getLiquidStack(input), heat));
    }

    @ZenMethod
    public static void addFluidCoolDown(ILiquidDefinition output, ILiquidDefinition input, int heat) {
        CraftTweakerActions.apply(new HeatExchangeAction(Recipes.liquidCooldownManager, CraftTweakerMC.getFluid(input), CraftTweakerMC.getFluid(input), heat));
    }

    @ZenMethod
    public static void addFluidHeatUp(ILiquidStack output, ILiquidStack input, int heat) {
        CraftTweakerActions.apply(new HeatExchangeAction(Recipes.liquidHeatupManager, CraftTweakerMC.getLiquidStack(input), CraftTweakerMC.getLiquidStack(input), heat));
    }

    @ZenMethod
    public static void addFluidHeatUp(ILiquidDefinition output, ILiquidDefinition input, int heat) {
        CraftTweakerActions.apply(new HeatExchangeAction(Recipes.liquidHeatupManager, CraftTweakerMC.getFluid(input), CraftTweakerMC.getFluid(input), heat));
    }

    private static final class HeatExchangeAction implements IAction {

        private final ILiquidHeatExchangerManager manager;
        private final Fluid input, output;
        private final int heat;

        HeatExchangeAction(ILiquidHeatExchangerManager manager, FluidStack input, FluidStack output, int heat) {
            this(manager, input.getFluid(), output.getFluid(), heat);
        }

        HeatExchangeAction(ILiquidHeatExchangerManager manager, Fluid input, Fluid output, int heat) {
            this.manager = manager;
            this.input = input;
            this.output = output;
            this.heat = heat;
        }

        @Override
        public void apply() {
            this.manager.addFluid(this.input.getName(), this.output.getName(), heat);
        }

        @Override
        public String describe() {
            return null;
        }
    }

}
