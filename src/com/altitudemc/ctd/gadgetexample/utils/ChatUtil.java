package com.altitudemc.ctd.gadgetexample.utils;

import org.bukkit.ChatColor;

public class ChatUtil {

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
