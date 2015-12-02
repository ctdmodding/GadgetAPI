package com.altitudemc.ctd.gadgetexample.listeners.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.altitudemc.ctd.gadgetapi.core.Gadget;
import com.altitudemc.ctd.gadgetapi.core.GadgetAPI;
import com.altitudemc.ctd.gadgetexample.core.GadgetExampleMain;
import com.altitudemc.ctd.gadgetexample.utils.ChatUtil;
import com.altitudemc.ctd.gadgetexample.utils.InventoryUtil;
import com.altitudemc.ctd.gadgetexample.utils.ItemUtil;

public class InventoryClick implements Listener {

	private GadgetExampleMain plugin;

	public InventoryClick(GadgetExampleMain plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void PlayerClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		GadgetAPI gadgetAPI = plugin.getGadgetAPI();
		
		if (e.getInventory().getName().equals(InventoryUtil.makeGadgetSelector(gadgetAPI).getName()) &&
				ItemUtil.isValidItem(e.getCurrentItem())) {
			Gadget gadget;
			ItemStack item = e.getCurrentItem();
			
			if (gadgetAPI.isGadget(item)) {
				gadget = gadgetAPI.getGadget(item);
				p.getInventory().setItem(0, gadget.getDisplayItem());
				p.sendMessage(ChatUtil.colorize(String.format("&bYou have recieved a(n) %s gadget", gadget.getName())));
				p.updateInventory();
			} else if (item.equals(ItemUtil.makeGadgetReset())) {
				p.getInventory().setItem(0, new ItemStack(Material.AIR));
				p.updateInventory();
				p.sendMessage(ChatUtil.colorize("&cYour gadget has been reset!"));
			}
			
			e.setCancelled(true);
			p.closeInventory();
		}
	}
}
