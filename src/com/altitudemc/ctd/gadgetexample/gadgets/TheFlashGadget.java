package com.altitudemc.ctd.gadgetexample.gadgets;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.altitudemc.ctd.gadgetapi.core.Gadget;
import com.altitudemc.ctd.gadgetapi.core.GadgetAPI;
import com.altitudemc.ctd.gadgetexample.core.GadgetExampleMain;
import com.altitudemc.ctd.gadgetexample.utils.ChatUtil;
import com.altitudemc.ctd.gadgetexample.utils.ItemUtil;

public class TheFlashGadget extends Gadget {

	private GadgetExampleMain plugin;

	public TheFlashGadget(GadgetExampleMain plugin) {
		super("The Flash", 60, ItemUtil.makeTheFlashGadgetItem());
		
		this.plugin = plugin;
	}

	@Override
	public void useGadget(Player player) {
		GadgetAPI gadgetAPI = plugin.getGadgetAPI();
		
		if (!gadgetAPI.hasCooldown(player)) {
			PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 15 * 20, 3);
			speed.apply(player);
			gadgetAPI.setCooldown(player, getCoolDownTime());
		} else {
			player.sendMessage(ChatUtil.colorize("&cYou must wait for your cooldown to complete!"));
		}
	}
}
