package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Locale;

@ModOnly("ic2")
@ZenClass("mods.ic2.Recycler")
@ZenRegister
public final class RecyclerSupport {

    @ZenMethod
    public static void addBlacklist(IItemStack item) {
        CraftTweakerAPI.apply(new RecyclingBlacklistAction(IC2RecipeInputs.of(item)));
    }

    @ZenMethod
    public static void addBlacklist(IIngredient ingredient) {
        CraftTweakerAPI.apply(new RecyclingBlacklistAction(IC2RecipeInputs.of(ingredient)));
    }

    private static final class RecyclingBlacklistAction implements IAction {

        private final IRecipeInput in;

        private RecyclingBlacklistAction(IRecipeInput in) {
            this.in = in;
        }

        @Override
        public void apply() {
            Recipes.recyclerBlacklist.add(this.in);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Blacklist %s from recycling", this.in);
        }
    }
}
