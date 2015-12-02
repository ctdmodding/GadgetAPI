package com.altitudemc.ctd.gadgetexample.core;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.altitudemc.ctd.gadgetapi.core.GadgetAPI;
import com.altitudemc.ctd.gadgetexample.gadgets.TheFlashGadget;
import com.altitudemc.ctd.gadgetexample.listeners.inventory.InventoryClick;
import com.altitudemc.ctd.gadgetexample.listeners.player.PlayerInteract;
import com.altitudemc.ctd.gadgetexample.listeners.player.PlayerJoin;
import com.altitudemc.ctd.gadgetexample.listeners.world.BlockPlace;

/**
 * GadgetAPI Example plugin
 * 
 * @author ctd
 * @version 1.0
 *
 */
public class GadgetExampleMain extends JavaPlugin {
	
	private GadgetAPI gadgetAPI;
	
	public void onEnable() {
		gadgetAPI = new GadgetAPI(this);
		registerGadgets();
		registerListeners();
	}
	
	public GadgetAPI getGadgetAPI() {
		return gadgetAPI;
	}
	
	private void registerListeners() {
		PluginManager pm = this.getServer().getPluginManager();

		pm.registerEvents(new PlayerInteract(this), this);
		pm.registerEvents(new InventoryClick(this), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new BlockPlace(this), this);
	}
	
	private void registerGadgets() {
		gadgetAPI.registerGadget(new TheFlashGadget(this));
	}
}
