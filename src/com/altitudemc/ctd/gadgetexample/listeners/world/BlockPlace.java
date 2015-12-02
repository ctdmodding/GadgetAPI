package com.altitudemc.ctd.gadgetexample.listeners.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.altitudemc.ctd.gadgetapi.core.GadgetAPI;
import com.altitudemc.ctd.gadgetexample.core.GadgetExampleMain;

public class BlockPlace implements Listener {

	private GadgetExampleMain plugin;

	public BlockPlace(GadgetExampleMain plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void blockPlace(BlockPlaceEvent event) {
		GadgetAPI gadgetAPI = plugin.getGadgetAPI();
		
		if (gadgetAPI.isGadget(event.getItemInHand())) {
			event.setCancelled(true);
		}
	}
}
 