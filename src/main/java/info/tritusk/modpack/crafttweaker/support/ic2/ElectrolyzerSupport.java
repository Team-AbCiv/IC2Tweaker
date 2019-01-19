package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.IElectrolyzerRecipeManager;
import ic2.api.recipe.Recipes;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;

import java.util.ArrayList;

@ModOnly("ic2")
@ZenClass("mods.ic2.Electrolyzer")
@ZenRegister
public final class ElectrolyzerSupport {

    public static void addRecipe(ILiquidStack[] outputs, ILiquidStack input, int power, @Optional(valueLong = 200L) int time) {
        CraftTweakerActions.apply(new AddElectrolyzerRecipeAction(input, power, time, outputs));
    }

    private static final class AddElectrolyzerRecipeAction implements IAction {

        private final FluidStack input;
        private final int power, time;
        private final IElectrolyzerRecipeManager.ElectrolyzerOutput[] outputs;

        AddElectrolyzerRecipeAction(ILiquidStack input, int power, int time, ILiquidStack[] outputs) {
            this.input = CraftTweakerMC.getLiquidStack(input);
            this.power = power;
            this.time = time;
            ArrayList<IElectrolyzerRecipeManager.ElectrolyzerOutput> actualOutputs = new ArrayList<>(6);
            for (int i = 0; i < outputs.length && i < 6; i++) {
                if (outputs[i] != null) {
                    actualOutputs.add(new IElectrolyzerRecipeManager.ElectrolyzerOutput(outputs[i].getName(), outputs[i].getAmount(), EnumFacing.byIndex(i)));
                }
            }
            this.outputs = actualOutputs.toArray(new IElectrolyzerRecipeManager.ElectrolyzerOutput[0]);
        }

        @Override
        public void apply() {
            Recipes.electrolyzer.addRecipe(this.input.getFluid().getName(), this.input.amount, this.power, this.time, this.outputs);
        }

        @Override
        public String describe() {
            return null;
        }
    }

}
