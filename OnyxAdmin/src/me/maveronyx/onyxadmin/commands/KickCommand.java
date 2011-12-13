package me.maveronyx.onyxadmin.commands;

import me.maveronyx.onyxadmin.OnyxAdmin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

public class KickCommand extends AbstractCommand {
	
	private Configuration config = OnyxAdmin.instance.getConfig();
	
	@Override public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {
			if (args[0].equals("*")) {
				if (sender.hasPermission("onyxadmin.kick.all")) {
					// All online players
					Player[] targets = Bukkit.getServer().getOnlinePlayers();

					if (targets.length > 0) {
						for (Player target : targets) {
							if (canBePunished(target)) {
								kickPlayer(target, sender, config.getString("messages.player.kick"));
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

				if (sender.hasPermission("onyxadmin.kick.player")) {
					// Single player
					Player target = Bukkit.getServer().getPlayer(args[0]);

					if (target != null && canBePunished(target)) {
						kickPlayer(target, sender, config.getString("messages.player.kick"));
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
	 * Kick a player
	 * 
	 * @param player
	 * @param sender
	 * @param message
	 */
	public void kickPlayer(Player player, CommandSender sender, String message) {
		if (player.isOnline() && player.getName() != sender.getName()) {
			player.kickPlayer(message);
			if (config.getBoolean("messages.enabled"))
				Bukkit.getServer().broadcast(config.getString("messages.admin.player.kick") + " " + player.getDisplayName(), "onyxadmin.kick");
		}
	}
}
