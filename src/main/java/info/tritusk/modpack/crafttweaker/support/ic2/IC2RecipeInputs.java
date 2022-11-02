package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.IngredientOr;
import crafttweaker.api.item.IngredientStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;

import java.util.Arrays;

final class IC2RecipeInputs {

    static IRecipeInput of(IItemStack item) {
        return Recipes.inputFactory.forStack(CraftTweakerMC.getItemStack(item));
    }

    static IRecipeInput of(IItemStack item, int amount) {
        return Recipes.inputFactory.forStack(CraftTweakerMC.getItemStack(item), amount);
    }

    static IRecipeInput of(IIngredient ingredient) {
        return of(ingredient, -1);
    }

    static IRecipeInput of(IIngredient ingredient, int amount) {
        // TODO Dealing with null
        if (ingredient instanceof IItemStack) {
            if (amount < 0) {
                return IC2RecipeInputs.of((IItemStack) ingredient);
            } else {
                return IC2RecipeInputs.of((IItemStack) ingredient, amount);
            }
        } else if (ingredient instanceof IOreDictEntry) {
            if (amount < 0) {
                amount = ingredient.getAmount();
            }
            return Recipes.inputFactory.forOreDict(((IOreDictEntry)ingredient).getName(), amount);
        } else if (ingredient instanceof IngredientStack) {
            IIngredient actual = (IIngredient) ingredient.getInternal();
            int amountOverride = ingredient.getAmount();
            return IC2RecipeInputs.of(actual, amountOverride);
        } else if (ingredient instanceof IngredientOr) {
            IIngredient[] elements = (IIngredient[]) ingredient.getInternal();
            IRecipeInput[] inputs = new IRecipeInput[elements.length];
            for (int i = 0; i < elements.length; i++) {
                inputs[i] = IC2RecipeInputs.of(elements[i]);
            }
            return Recipes.inputFactory.forAny(Arrays.asList(inputs));
        } else {
            // Fallback to the universal solution if we can't take any shortcut
            return new CraftTweakerIngredientInput(ingredient);
        }
    }
}
