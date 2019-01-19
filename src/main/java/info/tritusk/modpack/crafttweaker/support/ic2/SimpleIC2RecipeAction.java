package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.IAction;
import ic2.api.recipe.IBasicMachineRecipeManager;
import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Locale;

final class SimpleIC2RecipeAction implements IAction {

    private final IBasicMachineRecipeManager manager;
    private final IRecipeInput input;
    private final NBTTagCompound data;
    private final ItemStack[] output;

    SimpleIC2RecipeAction(IBasicMachineRecipeManager manager, IRecipeInput input, @Nullable NBTTagCompound data, ItemStack... output) {
        this.manager = manager;
        this.input = input;
        this.data = data;
        this.output = output;
    }

    @Override
    public void apply() {
        this.manager.addRecipe(this.input, this.data, false, this.output);
    }

    @Override
    public String describe() {
        return String.format(Locale.ENGLISH, "Add Recipe[%s, %s -> %s] to %s", this.input, this.data, Arrays.deepToString(this.output), this.manager);
    }
}
