package com.altitudemc.ctd.gadgetexample.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import com.altitudemc.ctd.gadgetapi.core.Gadget;
import com.altitudemc.ctd.gadgetapi.core.GadgetAPI;

public class InventoryUtil {

	public static Inventory makeGadgetSelector(GadgetAPI gadgetAPI) {
		int slot = 0;
		final Inventory inv = Bukkit.createInventory(null, 45, ChatUtil.colorize("&7Gadget Selector"));
		
		for (Gadget gadget : gadgetAPI.getGadgets()) {
			inv.setItem(slot++, gadget.getDisplayItem());
			if (slot == 40)
				slot++;
		}
		
		inv.setItem(40, ItemUtil.makeGadgetReset());

		return inv;
	}
}
