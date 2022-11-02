package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import ic2.api.recipe.IBasicMachineRecipeManager;
import ic2.core.recipe.BasicMachineRecipeManager;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

final class SimpleIC2RecipeRemovalAction implements IAction {

    private static Method removeRecipeImpl;

    static {
        try {
            removeRecipeImpl = BasicMachineRecipeManager.class.getDeclaredMethod("removeRecipe", ItemStack.class, Collection.class);
        } catch (Exception ignored) {
            // No-op
        }
    }

    private final IBasicMachineRecipeManager manager;
    private final ItemStack input;
    private final Collection<ItemStack> output;

    SimpleIC2RecipeRemovalAction(IBasicMachineRecipeManager manager, ItemStack input, ItemStack... output) {
        this.manager = manager;
        this.input = input;
        this.output = Arrays.asList(output);
    }

    @Override
    public void apply() {
        if (removeRecipeImpl != null) {
            try {
                removeRecipeImpl.invoke(this.manager, this.input, this.output);
            } catch (Exception e) {
                CraftTweakerAPI.logError("Recipe removal failed because an error occurred while doing so. Please report this back to IC2Tweaker.", e);
            }
        } else {
            CraftTweakerAPI.logError("Recipe removal failed because we cannot find the internal method to remove the recipe. Please report this back to IC2Tweaker.");
        }
    }

    @Override
    public String describe() {
        return String.format(Locale.ENGLISH, "Remove Recipe[%s -> %s] to %s", this.input, this.output.toString(), this.manager);
    }
}
