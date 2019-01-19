package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
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
@ZenClass("mods.ic2.OreWasher")
@ZenRegister
public final class OreWasherSupport {

    @ZenMethod
    public static void addRecipe(IItemStack[] outputs, IIngredient input, @Optional(valueLong = 1000L) int water) {
        NBTTagCompound data = new NBTTagCompound();
        data.setInteger("amount", water);
        CraftTweakerAPI.apply(new SimpleIC2RecipeAction(Recipes.oreWashing, IC2RecipeInputs.of(input), data, CraftTweakerMC.getItemStacks(outputs)));
    }

}
