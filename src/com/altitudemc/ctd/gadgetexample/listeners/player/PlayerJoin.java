package com.altitudemc.ctd.gadgetexample.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.altitudemc.ctd.gadgetexample.utils.ItemUtil;

public class PlayerJoin implements Listener {

	public PlayerJoin() {}

	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		p.getInventory().setItem(1, ItemUtil.makeGadgetSelectorItem());
		
	}
}
