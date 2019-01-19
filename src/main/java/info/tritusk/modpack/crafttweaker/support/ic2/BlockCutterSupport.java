package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.Recipes;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.BlockCutter")
@ZenRegister
public final class BlockCutterSupport {

    @ZenMethod
    public static void addRecipe(IItemStack output, IIngredient input, @Optional int minHardness) {
        NBTTagCompound data = new NBTTagCompound();
        data.setInteger("hardness", minHardness);
        Recipes.blockcutter.addRecipe(IC2RecipeInputs.of(input), data, false, CraftTweakerMC.getItemStack(output));
    }

}
