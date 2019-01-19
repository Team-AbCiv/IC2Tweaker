package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;

final class CraftTweakerActions {

    private static final boolean DEBUG = Boolean.getBoolean("ic2-tweaker.debug");

    static void apply(IAction action) {
        if (DEBUG) {
            CraftTweakerAPI.apply(action);
        } else {
            action.apply();
        }
    }
}
