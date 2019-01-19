package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.recipe.ICannerEnrichRecipeManager;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ic2")
@ZenClass("mods.ic2.Canner")
@ZenRegister
public final class CannerSupport {

    @ZenMethod
    public static void addBottleRecipe(IItemStack output, IIngredient container, IIngredient filler) {
        CraftTweakerActions.apply(new BottleAction(container, filler, output));
    }

    @ZenMethod
    public static void addEnrichRecipe(ILiquidStack output, ILiquidStack input, IIngredient additive) {
        CraftTweakerActions.apply(new EnrichAction(input, additive, output));
    }

    private static final class BottleAction implements IAction {

        private final IRecipeInput container, filler;
        private final ItemStack output;

        BottleAction(IIngredient container, IIngredient filler, IItemStack output) {
            this.container = IC2RecipeInputs.of(container);
            this.filler = IC2RecipeInputs.of(filler);
            this.output = CraftTweakerMC.getItemStack(output);
        }

        @Override
        public void apply() {
            Recipes.cannerBottle.addRecipe(this.container, this.filler, this.output, false);
        }

        @Override
        public String describe() {
            return null;
        }
    }

    private static final class EnrichAction implements IAction {

        private final FluidStack input, output;
        private final IRecipeInput additive;

        EnrichAction(ILiquidStack input, IIngredient additive, ILiquidStack output) {
            this.input = CraftTweakerMC.getLiquidStack(input);
            this.additive = IC2RecipeInputs.of(additive);
            this.output = CraftTweakerMC.getLiquidStack(output);
        }

        @Override
        public void apply() {
            Recipes.cannerEnrich.addRecipe(new ICannerEnrichRecipeManager.Input(this.input, this.additive), this.output, null, false);
        }

        @Override
        public String describe() {
            return null;
        }
    }

}
