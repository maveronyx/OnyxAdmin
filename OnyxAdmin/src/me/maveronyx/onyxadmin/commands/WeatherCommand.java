package me.maveronyx.onyxadmin.commands;

import java.util.List;

import me.maveronyx.onyxadmin.OnyxAdmin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;

public class WeatherCommand extends AbstractCommand {
	
	private Configuration config = OnyxAdmin.instance.getConfig();
	
	@Override public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {
			if (sender.hasPermission("onyxadmin.weather")) {
				List<World> thisWorld = Bukkit.getServer().getWorlds();
				
				for(World world: thisWorld){
					setWeather(world, args[0], null);
				}
				
			} else {
				sender.sendMessage("You don't have the right permissions to use that command");
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Change the weather type
	 * 
	 * @param world
	 * @param type
	 * @param message
	 */
	public void setWeather(World world, String type, String message) {
		if (type.matches("(?i)rain|raining")) {
			world.setStorm(true);

			if (config.getBoolean("messages.enabled"))
				Bukkit.getServer().broadcast(config.getString("messages.admin.world.weather") + " " + type.toUpperCase(), "onyxadmin.weather");
		} else if (type.matches("(?i)storm")) {
			world.setThundering(true); //With recent update, only need to set thundering to make it rain too

			if (config.getBoolean("messages.enabled"))
				Bukkit.getServer().broadcast(config.getString("messages.admin.world.weather") + " " + type.toUpperCase(), "onyxadmin.weather");
		} else if (type.matches("(?i)sun|sunny")) {
			world.setStorm(false);

			if (config.getBoolean("messages.enabled"))
				Bukkit.getServer().broadcast(config.getString("messages.admin.world.weather") + " " + type.toUpperCase(), "onyxadmin.weather");
		}

	}
}
