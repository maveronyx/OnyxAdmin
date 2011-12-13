package me.maveronyx.onyxadmin.commands;

import me.maveronyx.onyxadmin.OnyxAdmin;
import me.maveronyx.onyxadmin.OnyxPlayer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

public class WarnCommand extends AbstractCommand {
	
	private Configuration config = OnyxAdmin.instance.getConfig();

	@Override public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {
			if (args[0].equals("*")) {
				if (sender.hasPermission("onyxadmin.warn.all")) {
					
					// All online players
					Player[] targets = Bukkit.getServer().getOnlinePlayers();

					log.info("Players online: " + targets + " " + targets.length);
					
					if (targets.length > 0) {
						for (Player target : targets) {
							OnyxPlayer op = OnyxAdmin.instance.getOnyxPlayer(target);
							if (canBePunished(op)) {
								warnPlayer(op, sender, config.getString("messages.player.warned"));
							} else {
								log.info("No targets found");
								if (config.getBoolean("messages.enabled")) {
									sender.sendMessage(config.getString("messages.admin.player.offline"));
								}
							}
						}
					}
				} else {
					sender.sendMessage("You don't have the right permissions to use that command");
				}
				return true;

			} else {
				if (sender.hasPermission("onyxadmin.warn.player")) {
					Configuration config = OnyxAdmin.instance.getConfig();
					
					// Single player
					OnyxPlayer target = OnyxAdmin.instance.getOnyxPlayer(Bukkit.getServer().getPlayer(args[0]));

					if (target != null && canBePunished(target)) {
						warnPlayer(target, sender, config.getString("messages.player.warned"));
					} else {
						if (config.getBoolean("messages.enabled")) {
							sender.sendMessage(config.getString("messages.admin.player.offline"));
						}
					}
				} else {
					sender.sendMessage("You don't have the right permissions to use that command");
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds to the warning counter of a specific player. If limit is reached, a
	 * message is prompted to users with the proper permissions.
	 * 
	 * @param player
	 * @param sender
	 * @param message
	 */
	private void warnPlayer(OnyxPlayer player, CommandSender sender, String message) {
		player.incrementWarnings();
		if (config.getBoolean("messages.enabled") 
				&& message != null && !message.isEmpty()) {
			player.sendMessage(message + " " + player.getWarningNumber()+"/3 times"); //TODO make format configurable
		}
		if (player.getWarningNumber() > 3){ //TODO make number configurable
			Bukkit.getServer().broadcast(config.getString("messages.admin.player.maxwarnings")+
					" " + player.getDisplayName(), "onyxadmin.warn");
		}
		
	}


}
