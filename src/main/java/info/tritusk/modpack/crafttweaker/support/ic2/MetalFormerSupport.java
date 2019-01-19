package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.MetalFormer")
@ZenRegister
public final class MetalFormerSupport {

    @ZenMethod
    public static void addCuttingRecipe(IItemStack output, IIngredient input) {
        Recipes.metalformerCutting.addRecipe(IC2RecipeInputs.of(input), null, false, CraftTweakerMC.getItemStack(output));
    }

    @ZenMethod
    public static void addExtrudingRecipe(IItemStack output, IIngredient input) {
        Recipes.metalformerExtruding.addRecipe(IC2RecipeInputs.of(input), null, false, CraftTweakerMC.getItemStack(output));
    }

    @ZenMethod
    public static void addRollingRecipe(IItemStack output, IIngredient input) {
        Recipes.metalformerRolling.addRecipe(IC2RecipeInputs.of(input), null, false, CraftTweakerMC.getItemStack(output));
    }
}
