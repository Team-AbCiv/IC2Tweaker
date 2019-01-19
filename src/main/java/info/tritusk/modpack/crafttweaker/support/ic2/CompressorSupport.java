package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.Compressor")
@ZenRegister
public final class CompressorSupport {

    @ZenMethod
    public static void addRecipe(IItemStack output, IIngredient input) {
        CraftTweakerAPI.apply(new SimpleIC2RecipeAction(Recipes.compressor, IC2RecipeInputs.of(input), null, CraftTweakerMC.getItemStack(output)));
    }

}
