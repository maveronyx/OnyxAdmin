package me.maveronyx.onyxadmin;

import org.bukkit.configuration.file.FileConfigurationOptions;


public class Config {
	/* (suggested by Tustin)
	 * This whole class is already implemented in bukkit's Configuration class. We don't need
	 * to reinvent the wheel.
	 */

	private OnyxAdmin plugin;

	private FileConfigurationOptions config;
	
	public Config(OnyxAdmin instance){
		plugin = instance;
		initConfig();
	}
	
	private void initConfig(){
		/* TODO (suggested by Tustin)
		 * This method can be replaced, in the latest versions of bukkit, by supplying a 
		 * config.yml IN the jar file and calling the Configuration.copyDefaults() method.
		 */
		
		addDefault("messages.enabled", true);
		addDefault("messages.player.warn", "Warning");
		addDefault("messages.player.kick", "Kicked player");
		addDefault("messages.player.ban", "Banned player");
		addDefault("messages.player.unban", "Unbanned player");
		addDefault("messages.player.frozen", "Froze player");
		addDefault("messages.player.unfrozen", "Unfroze player");
		addDefault("messages.player.mute", "Muted player");
		addDefault("messages.player.unmute", "Unmuted player");
		addDefault("messages.player.warned", "You've been warned");
		
		addDefault("messages.admin.player.offline", "Cannot perform that action. Player is offline.");
		addDefault("messages.admin.player.maxwarnings", "The following player has been warned multiple times");
		addDefault("messages.admin.admin.unbanned", "All players have been unbanned");
		
		addDefault("messages.admin.world.weather", "Weather changed to");
		addDefault("messages.admin.world.time", "Time changed to ");
		
		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
	}
	
	public void reloadConfig(){
		plugin.reloadConfig();
	}
	
	public void saveConfig(){
		plugin.saveConfig();
	}
	
	private void addDefault(String path, Object value){
		plugin.getConfig().addDefault(path, value);
	}
	
	
}