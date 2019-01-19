package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.Recipes;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.BlastFurnace")
@ZenRegister
public final class BlastFurnaceSupport {

    @ZenMethod
    public static void addRecipe(IItemStack[] outputs, IIngredient input, int totalFluidCost, int time) {
        NBTTagCompound data = new NBTTagCompound();
        data.setInteger("fluid", totalFluidCost);
        data.setInteger("duration", time);
        CraftTweakerAPI.apply(new SimpleIC2RecipeAction(Recipes.blastfurnace, IC2RecipeInputs.of(input), data, CraftTweakerMC.getItemStacks(outputs)));
    }

}
