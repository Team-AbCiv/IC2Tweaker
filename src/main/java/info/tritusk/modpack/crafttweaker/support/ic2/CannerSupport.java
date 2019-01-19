package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.ICannerEnrichRecipeManager;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.Canner")
@ZenRegister
public final class CannerSupport {

    @ZenMethod
    public static void addBottleRecipe(IItemStack output, IIngredient container, IIngredient filler) {
        Recipes.cannerBottle.addRecipe(IC2RecipeInputs.of(container), IC2RecipeInputs.of(filler), CraftTweakerMC.getItemStack(output), false);
    }

    @ZenMethod
    public static void addEnrichRecipe(ILiquidStack output, ILiquidStack input, IIngredient additive) {
        Recipes.cannerEnrich.addRecipe(new ICannerEnrichRecipeManager.Input(CraftTweakerMC.getLiquidStack(input), IC2RecipeInputs.of(additive)), CraftTweakerMC.getLiquidStack(output), null, false);
    }

}
