package com.altitudemc.ctd.gadgetexample.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.altitudemc.ctd.gadgetapi.core.Gadget;
import com.altitudemc.ctd.gadgetapi.core.GadgetAPI;
import com.altitudemc.ctd.gadgetexample.core.GadgetExampleMain;
import com.altitudemc.ctd.gadgetexample.utils.InventoryUtil;
import com.altitudemc.ctd.gadgetexample.utils.ItemUtil;

public class PlayerInteract implements Listener {

	private GadgetExampleMain plugin;

	public PlayerInteract(GadgetExampleMain plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void playerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		GadgetAPI gadgetAPI = plugin.getGadgetAPI();
		ItemStack item = p.getItemInHand();
		Gadget gadget;
		
		if (ItemUtil.isValidItem(item) && ItemUtil.hasClickedItem(p, item, e.getAction())) {
			if (item.equals(ItemUtil.makeGadgetSelectorItem())) {
				p.openInventory(InventoryUtil.makeGadgetSelector(gadgetAPI));
			} else if (gadgetAPI.isGadget(item)) {
				gadget = gadgetAPI.getGadget(item);
				gadget.useGadget(p);
			}
		}
	}
}
