package me.maveronyx.onyxadmin.commands;

import java.util.List;

import me.maveronyx.onyxadmin.OnyxAdmin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;

public class TimeCommand extends AbstractCommand {
	
	private Configuration config = OnyxAdmin.instance.getConfig();
	
	@Override public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {
			if (sender.hasPermission("onyxadmin.time")) {
				List<World> thisWorld = Bukkit.getServer().getWorlds();
				
				for(World world: thisWorld){
					setTime(world, args[0], null);
				}
				
			} else {
				sender.sendMessage("You don't have the right permissions to use that command");
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Change the time
	 * 
	 * @param world
	 * @param type
	 * @param message
	 */
	public void setTime(World world, String type, String message) {

		if (type.matches("(?i)day")) {
			world.setTime(0);

			if (config.getBoolean("messages.enabled"))
				Bukkit.getServer().broadcast(config.getString("messages.admin.world.time") + " " + type.toUpperCase(), "onyxadmin.weather");
		} else if (type.matches("(?i)night")) {
			world.setTime(12000);

			if (config.getBoolean("messages.enabled"))
				Bukkit.getServer().broadcast(config.getString("messages.admin.world.time") + " " + type.toUpperCase(), "onyxadmin.weather");
		} 

	}
}
