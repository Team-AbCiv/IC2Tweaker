package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
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
        CraftTweakerActions.apply(new SimpleIC2RecipeAction(Recipes.blockcutter, IC2RecipeInputs.of(input), data, CraftTweakerMC.getItemStack(output)));
    }

    @ZenMethod
    public static void removeRecipe(IItemStack output, IItemStack... input) {
        ItemStack nativeOutput = CraftTweakerMC.getItemStack(output);
        ItemStack[] nativeInputs = CraftTweakerMC.getItemStacks(input);
        CraftTweakerActions.apply(new SimpleIC2RecipeRemovalAction(Recipes.blockcutter, nativeOutput, nativeInputs));
    }

}
