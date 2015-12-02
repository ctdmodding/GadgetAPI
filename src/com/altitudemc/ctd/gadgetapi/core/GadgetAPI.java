package com.altitudemc.ctd.gadgetapi.core;

import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * API for managing Gadgets
 * 
 * @author ctd
 * @version 1.0
 * 12 Dec, 2015
 */
public class GadgetAPI {
	
	private JavaPlugin plugin;
	private HashSet<UUID> cooldownList; 
	private HashSet<Gadget> gadgets;
	
	/**
	 * API constructor
	 * @param plugin the main plugin
	 */
	public GadgetAPI(JavaPlugin plugin) {
		this.plugin = plugin;
		gadgets = new HashSet<Gadget>();
		cooldownList = new HashSet<UUID>();
	}
	
	/**
	 * Register the Gadget in the HashSet
	 * @param gadget the gadget to register
	 */
	public void registerGadget(Gadget gadget) {
		gadgets.add(gadget);
	}
	
	/**
	 * Get the Gadgets
	 * 
	 * @return the HashSet of Gadgets
	 */
	public HashSet<Gadget> getGadgets() {
		return gadgets;
	}
	
	/**
	 * Get a Gadget by name
	 * 
	 * @param name the name to check
	 * @return the Gadget or null if not found
	 */
	public Gadget getGadget(String name) {
		for (Gadget gadget : gadgets) {
			if (gadget.getName().equalsIgnoreCase(name))
				return gadget;
		}
		
		return null;
	}
	
	/**
	 * Get a Gadget by DisplayName
	 * 
	 * @param item
	 * @return
	 */
	public Gadget getGadget(ItemStack item) {
		for (Gadget gadget : gadgets) {
			if (gadget.getDisplayItem().equals(item))
				return gadget;
		}
		
		return null;
	}
	
	/**
	 * Check if the passed in ItemStack is used by
	 * a registered Gadget
	 * 
	 * @param item the ItemStack to check
	 * @return true if found
	 */
	public boolean isGadget(ItemStack item) {
		for (Gadget gadget : gadgets) {
			if (gadget.getDisplayItem().isSimilar(item))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Set a cooldown for a Player
	 * 
	 * @param player the player to set
	 * @param time the amount of time to set (seconds)
	 */
	public void setCooldown(final Player player, int time) {
		cooldownList.add(player.getUniqueId());

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				removeCooldown(player);
			}
		}, time * 20);
    }

	/**
	 * Remove a cooldown for a player
	 * 
	 * @param player the player's cooldown to remove
	 */
    public void removeCooldown(Player player) {
        cooldownList.remove(player.getUniqueId());
    }

    /**
     * Check if a player has a cooldown
     * 
     * @param player the player to check
     * @return true if found
     */
    public boolean hasCooldown(Player player) {
        if(cooldownList.contains(player.getUniqueId())) {
            return true;
        }
        
        return false;
    }
}
