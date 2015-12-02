package com.altitudemc.ctd.gadgetapi.core;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * This class represents a Gadget
 * 
 * @author ctd
 * @version 1.0
 * 12 Dec, 2015
 */
public abstract class Gadget {
	
	private final int COOL_DOWN_TIME;
	private String name;
	private ItemStack displayItem;
	
	/**
	 * Gadget constructor
	 * 
	 * @param name the name
	 * @param COOL_DOWN_TIME the cool down time
	 * @param displayItem the display item
	 */
	public Gadget(String name, final int COOL_DOWN_TIME, ItemStack displayItem) {
		this.name = name;
		this.COOL_DOWN_TIME = COOL_DOWN_TIME;
		this.displayItem = displayItem.clone();
	}
	
	/**
	 * Get the name of the Gadget
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the cool down of the Gadget
	 * 
	 * @return the cool down
	 */
	public int getCoolDownTime() {
		return COOL_DOWN_TIME;
	}
	
	/**
	 * Get the display item of the Gadget
	 * 
	 * @return the display item
	 */
	public ItemStack getDisplayItem() {
		return displayItem;
	}
	
	/**
	 * Apply the Gadget's use to the player
	 * 
	 * @param player the Player that used the Gadget
	 */
	public abstract void useGadget(Player player);
}

