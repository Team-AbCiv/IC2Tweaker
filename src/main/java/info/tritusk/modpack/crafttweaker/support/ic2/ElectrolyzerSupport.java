package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import ic2.api.recipe.IElectrolyzerRecipeManager;
import ic2.api.recipe.Recipes;
import net.minecraft.util.EnumFacing;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;

import java.util.ArrayList;
import java.util.List;

@ModOnly("ic2")
@ZenClass("mods.ic2.Electrolyzer")
@ZenRegister
public final class ElectrolyzerSupport {

    public static void addRecipe(ILiquidStack[] outputs, ILiquidStack input, int power, @Optional(valueLong = 200L) int time) {
        List<IElectrolyzerRecipeManager.ElectrolyzerOutput> actualOutputs = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            if (outputs[i] != null) {
                actualOutputs.add(new IElectrolyzerRecipeManager.ElectrolyzerOutput(outputs[i].getName(), outputs[i].getAmount(), EnumFacing.byIndex(i)));
            }
        }
        Recipes.electrolyzer.addRecipe(input.getName(), input.getAmount(), power, time, actualOutputs.toArray(new IElectrolyzerRecipeManager.ElectrolyzerOutput[0]));
    }

}
