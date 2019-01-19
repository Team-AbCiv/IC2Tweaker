package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;

final class IC2RecipeInputs {

    static IRecipeInput of(IItemStack item) {
        return Recipes.inputFactory.forStack(CraftTweakerMC.getItemStack(item));
    }

    static IRecipeInput of(IIngredient ingredient) {
        // TODO Dealing with null
        if (ingredient instanceof IItemStack) {
            return IC2RecipeInputs.of((IItemStack)ingredient);
        } else if (ingredient instanceof IOreDictEntry) {
            return Recipes.inputFactory.forOreDict(((IOreDictEntry)ingredient).getName(), ingredient.getAmount());
        } else {
            // Fallback to the universal solution if we can't take any shortcut
            return new CraftTweakerIngredientInput(ingredient);
        }
    }
}
