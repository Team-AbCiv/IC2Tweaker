package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.Arrays;
import java.util.List;

final class CraftTweakerIngredientInput implements IRecipeInput {

    private final IIngredient ingredient;

    private transient ItemStack[] cachedNativeItemStacks = null;

    CraftTweakerIngredientInput(IIngredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean matches(ItemStack item) {
        return this.ingredient.matches(CraftTweakerMC.getIItemStack(item));
    }

    @Override
    public int getAmount() {
        return this.ingredient.getAmount();
    }

    @Override
    public List<ItemStack> getInputs() {
        return Arrays.asList(this.toNatives());
    }

    @Override
    public Ingredient getIngredient() {
        return Ingredient.fromStacks(this.toNatives());
    }

    private ItemStack[] toNatives() {
        if (this.cachedNativeItemStacks == null) {
            this.cachedNativeItemStacks = CraftTweakerMC.getItemStacks(this.ingredient.getItems());
            for (ItemStack item : this.cachedNativeItemStacks) {
                item.setCount(this.ingredient.getAmount());
            }
        }
        return this.cachedNativeItemStacks;
    }

}
