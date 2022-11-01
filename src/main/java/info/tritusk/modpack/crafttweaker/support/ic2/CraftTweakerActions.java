package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;

final class CraftTweakerActions {

    // To anyone who is looking at this:
    // you need to add -Dic2-tweaker.debug=true in your JVM arguments to enable this debug flag.
    private static final boolean DEBUG = Boolean.getBoolean("ic2-tweaker.debug");

    static void apply(IAction action) {
        if (DEBUG) {
            CraftTweakerAPI.apply(action);
        } else {
            action.apply();
        }
    }
}
