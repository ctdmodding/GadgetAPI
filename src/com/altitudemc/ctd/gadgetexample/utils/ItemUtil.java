package com.altitudemc.ctd.gadgetexample.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {
	
	public static ItemStack makeItem(Material material, String displayName) {
        return makeItem(material, displayName, null);
    }
	
	public static ItemStack makeItem(Material material, String displayName, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta im = item.getItemMeta();

        im.setDisplayName(ChatUtil.colorize(displayName));
        
        if (lore != null)
        	im.setLore(lore);
        
        item.setItemMeta(im);
        
        return item;
    }

	public static ItemStack makeGadgetSelectorItem() {
		return makeItem(Material.CHEST, "&a&lGadgets &7(Right-Click)");
	}
	
	public static ItemStack makeTheFlashGadgetItem() {
		List<String> lore = new ArrayList<String>();
		lore.add(ChatUtil.colorize("&7Allows you to run/fly faster for 15 seconds!"));
		lore.add(" ");
		lore.add(ChatUtil.colorize("&cCooldown: 1 Minute"));

		return makeItem(Material.REDSTONE_TORCH_ON, "&a&lThe Flash Gadget&7 (Right-Click)", lore);
	}

	public static ItemStack makeGadgetReset() {
		List<String> lore = new ArrayList<String>();
		lore.add(ChatUtil.colorize("&7Resets the current gadget in-hand"));

		return makeItem(Material.TRIPWIRE_HOOK, "&cGadget Reset", null);
	}
	
	public static boolean hasClickedItem(Player p, ItemStack itemStack, Action action) {
		if (p.getItemInHand().equals(itemStack)
                && (action == Action.RIGHT_CLICK_AIR
                || (action == Action.LEFT_CLICK_AIR || (action == Action.RIGHT_CLICK_BLOCK
                || (action == Action.LEFT_CLICK_BLOCK))))) {
			return true;
        } else {
        	return false;
        }
	}
	
	public static boolean isValidItem(ItemStack item) {
		if (item.equals(null) || item.getType().equals(null) || item.getType().equals(Material.AIR))
			return false;
		
		return true;
	}
}
