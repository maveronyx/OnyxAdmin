package me.maveronyx.onyxadmin;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * Class for all the admin commands
 * 
 * @author Jimmy
 * 
 */
public class AdminCommands {

	private HashMap<String, Integer> warnedPlayers;
	private OnyxAdmin plugin;
	private FileConfiguration config;

	/**
	 * Initialize the class
	 * 
	 * @param config
	 */
	public AdminCommands(OnyxAdmin instance, FileConfiguration config) {
		this.config = config;
		plugin = instance;
		warnedPlayers = instance.warnedPlayers;
	}
	
	


}
