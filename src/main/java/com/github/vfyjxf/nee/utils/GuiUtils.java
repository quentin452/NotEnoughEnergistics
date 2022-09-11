package com.github.vfyjxf.nee.utils;

import appeng.client.gui.implementations.GuiCraftConfirm;
import appeng.client.gui.implementations.GuiCraftingTerm;
import appeng.client.gui.implementations.GuiPatternTerm;
import appeng.container.implementations.ContainerPatternTerm;
import appeng.helpers.IContainerCraftingPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * @author vfyjxf
 */
public class GuiUtils {

    private static Class<?> guiPatternTermExClass;
    private static Class<?> containerPatternTermExClass;
    private static Class<?> guiWirelessCraftingTerminalClass;
    private static Class<?> containerWirelessCraftingTerminalClass;
    private static Class<?> wirelessContainerCraftConfirmClass;
    private static Class<?> wirelessGuiCraftConfirmClass;
    private static Class<?> wctContainerCraftingConfirmClass;
    private static Class<?> wirelessTerminalGuiObjClass;

    static {
        try {
            guiPatternTermExClass = Class.forName("appeng.client.gui.implementations.GuiPatternTermEx");
        } catch (ClassNotFoundException ignored) {}
        try {
            containerPatternTermExClass = Class.forName("appeng.container.implementations.ContainerPatternTermEx");
        } catch (ClassNotFoundException ignored) {}
        try {
            guiWirelessCraftingTerminalClass = Class.forName("net.p455w0rd.wirelesscraftingterminal.client.gui.GuiWirelessCraftingTerminal");
        } catch (ClassNotFoundException ignored) {}
        try {
            containerWirelessCraftingTerminalClass = Class.forName("net.p455w0rd.wirelesscraftingterminal.common.container.ContainerWirelessCraftingTerminal");
        } catch (ClassNotFoundException ignored) {}
        try {
            wirelessContainerCraftConfirmClass = Class.forName("net.p455w0rd.wirelesscraftingterminal.common.container.ContainerCraftConfirm");
        } catch (ClassNotFoundException ignored) {}
        try {
            wirelessGuiCraftConfirmClass = Class.forName("net.p455w0rd.wirelesscraftingterminal.client.gui.GuiCraftConfirm");
        } catch (ClassNotFoundException ignored) {}
        try {
            wctContainerCraftingConfirmClass = Class.forName("com.github.vfyjxf.nee.container.WCTContainerCraftingConfirm");// TODO isn't it in the same mod ?????
        } catch (ClassNotFoundException ignored) {}
        try {
            wirelessTerminalGuiObjClass = Class.forName("net.p455w0rd.wirelesscraftingterminal.helpers.WirelessTerminalGuiObject");
        } catch (ClassNotFoundException ignored) {}
    }

    public static boolean isPatternTermExGui(GuiScreen container) {
        if (guiPatternTermExClass != null) {
            return guiPatternTermExClass.isInstance(container);
        }
        return false;
    }

    public static boolean isPatternTermExContainer(Container container) {
        if (containerPatternTermExClass != null) {
            return containerPatternTermExClass.isInstance(container);
        }
        return false;
    }

    public static boolean isGuiWirelessCrafting(GuiScreen gui) {
        if (guiWirelessCraftingTerminalClass != null) {
            return guiWirelessCraftingTerminalClass.isInstance(gui);
        }
        return false;
    }

    public static boolean isWirelessCraftingTermContainer(Container container) {
        if (containerWirelessCraftingTerminalClass != null) {
            return containerWirelessCraftingTerminalClass.isInstance(container);
        }
        return false;
    }

    public static boolean isContainerWirelessCraftingConfirm(Container container) {
        if (wirelessContainerCraftConfirmClass != null) {
            return wirelessContainerCraftConfirmClass.isInstance(container);
        }
        return false;
    }

    public static boolean isWirelessGuiCraftConfirm(GuiScreen gui) {
        if (wirelessGuiCraftConfirmClass != null) {
            return wirelessGuiCraftConfirmClass.isInstance(gui);
        }
        return false;
    }

    public static boolean isWCTContainerCraftingConfirm(Container container) {
        if (wctContainerCraftingConfirmClass != null) {
            return wctContainerCraftingConfirmClass.isInstance(container);
        }
        return false;
    }

    public static boolean isWirelessTerminalGuiObject(Object guiObj) {
        if (wirelessTerminalGuiObjClass != null) {
            return wirelessTerminalGuiObjClass.isInstance(guiObj);
        }
        return false;
    }

    public static boolean isCraftingSlot(Slot slot) {
        if (slot == null) {
            return false;
        }
        Container container = Minecraft.getMinecraft().thePlayer.openContainer;
        if (!(container instanceof ContainerPatternTerm) && !GuiUtils.isPatternTermExContainer(container)) {
            return false;
        }
        IContainerCraftingPacket cct = (IContainerCraftingPacket) container;
        IInventory craftMatrix = cct.getInventoryByName("crafting");
        return craftMatrix.equals(slot.inventory);
    }

    public static boolean isGuiCraftingTerm(GuiScreen guiScreen) {
        return guiScreen instanceof GuiCraftingTerm || isGuiWirelessCrafting(guiScreen);
    }

    public static boolean isPatternTerm(GuiScreen guiScreen) {
        return guiScreen instanceof GuiPatternTerm || isPatternTermExGui(guiScreen);
    }

    public static boolean isGuiCraftConfirm(GuiScreen gui) {
        return gui instanceof GuiCraftConfirm || isWirelessGuiCraftConfirm(gui);
    }
}
