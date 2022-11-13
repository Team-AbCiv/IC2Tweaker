package info.tritusk.modpack.crafttweaker.support.ic2;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.item.ElectricItem;
import ic2.api.item.ICustomDamageItem;
import ic2.core.item.ItemGradualInt;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

import java.lang.reflect.Field;

@ModOnly("ic2")
@ZenExpansion("crafttweaker.item.IItemStack")
@ZenRegister
public final class IC2ExtendedItemProperties {

    @ZenMethod
    @ZenGetter("ic2Charge")
    public static double getIC2Charge(IItemStack value) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        return ElectricItem.manager.getCharge(nativeItemStack);
    }

    @ZenMethod
    @ZenGetter("ic2Energy")
    public static double getIC2Energy(IItemStack value) {
        return getIC2Charge(value);
    }

    @ZenMethod
    @ZenGetter("ic2MaxCharge")
    public static double getIC2MaxCharge(IItemStack value) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        return ElectricItem.manager.getMaxCharge(nativeItemStack);
    }

    @ZenMethod
    @ZenGetter("ic2MaxEnergy")
    public static double getIC2MaxEnergy(IItemStack value) {
        return getIC2MaxCharge(value);
    }

    @ZenMethod
    @ZenSetter("ic2Charge")
    public static void setIC2Charge(IItemStack value, double charge) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        double current = ElectricItem.manager.getCharge(nativeItemStack);
        if (current < charge) {
            // Current EU < target EU, adding the missing
            ElectricItem.manager.charge(nativeItemStack, charge - current, 1, true, false);
        } else if (current > charge) {
            // Current EU > target EU, subtract the surplus
            ElectricItem.manager.discharge(nativeItemStack, current - charge, 1, true, false, false);
        }
    }

    @ZenMethod
    @ZenSetter("ic2MaxEnergy")
    public static void setIC2Energy(IItemStack value, double charge) {
        setIC2Charge(value, charge);
    }

    @ZenMethod
    @ZenGetter("ic2Damage")
    public static int getIC2Damage(IItemStack value) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        Item nativeItem = nativeItemStack.getItem();
        if (nativeItem instanceof ICustomDamageItem) {
            return ((ICustomDamageItem) nativeItem).getCustomDamage(nativeItemStack);
        }
        return -1;
    }

    @ZenMethod
    @ZenSetter("ic2Damage")
    public static void setIC2Damage(IItemStack value, int damage) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        Item nativeItem = nativeItemStack.getItem();
        if (nativeItem instanceof ICustomDamageItem) {
            ((ICustomDamageItem) nativeItem).setCustomDamage(nativeItemStack, damage);
        }
    }

    @ZenMethod
    @ZenGetter("ic2MaxDamage")
    public static int getIC2MaxDamage(IItemStack value) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        Item nativeItem = nativeItemStack.getItem();
        if (nativeItem instanceof ICustomDamageItem) {
            return ((ICustomDamageItem) nativeItem).getMaxCustomDamage(nativeItemStack);
        }
        return -1;
    }

    @ZenMethod
    @ZenSetter("ic2MaxDamage")
    public static void setIC2MaxDamage(IItemStack value, int maxDamage) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        Item nativeItem = nativeItemStack.getItem();
        if (nativeItem instanceof ItemGradualInt) {
            if (ic2ItemGradualIntMaxDamage != null) {
                try {
                    ic2ItemGradualIntMaxDamage.set(nativeItem, maxDamage);
                } catch (Exception e) {
                    CraftTweakerAPI.logError("IC2ExtendedItemProperties.setIC2MaxDamage is called on ItemGradualInt, but failed with exception. "
                            + "Please consider reporting back to IC2Tweaker.", e);
                }
            } else {
                CraftTweakerAPI.logError("IC2ExtendedItemProperties.setIC2MaxDamage is called on ItemGradualInt, but we do not have access to IC2 internal. "
                        + "This may be an error, please consider reporting back to IC2Tweaker.");
            }
        } else {
            CraftTweakerAPI.logWarning("IC2ExtendedItemProperties.setIC2MaxDamage is called on unsupported item type '"
                    + nativeItem.getClass().getName() + "', ignoring");
        }
    }

    private static Field ic2ItemGradualIntMaxDamage;

    static {
        try {
            ic2ItemGradualIntMaxDamage = ItemGradualInt.class.getDeclaredField("maxDamage");
            ic2ItemGradualIntMaxDamage.setAccessible(true);
        } catch (Exception ignored) {
        }
    }
}
