package me.maveronyx.onyxadmin.commands;

import me.maveronyx.onyxadmin.OnyxAdmin;
import me.maveronyx.onyxadmin.OnyxPlayer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

public class FreezeCommand extends AbstractCommand {
	
	private Configuration config = OnyxAdmin.instance.getConfig();
	
	@Override public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {

			if (args[0].equals("*")) {
				if (sender.hasPermission("onyxadmin.freeze.all")) {
					// All online players
					Player[] targets = Bukkit.getServer().getOnlinePlayers();

					if (targets.length > 0) {
						for (Player target : targets) {
							OnyxPlayer op = OnyxAdmin.instance.getOnyxPlayer(target);
							if (canBePunished(target)) {
								freezePlayer(op, sender, config.getString("messages.player.frozen"));
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
				if (sender.hasPermission("onyxadmin.freeze.player")) {
					// Single player
					Player target = Bukkit.getServer().getPlayer(args[0]);
					
					OnyxPlayer op = OnyxAdmin.instance.getOnyxPlayer(target);

					if (target != null && canBePunished(target)) {
						freezePlayer(op, sender, config.getString("messages.player.freeze"));
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
	 * Freeze a player
	 * 
	 * @param player
	 * @param sender
	 * @param message
	 */
	public void freezePlayer(OnyxPlayer player, CommandSender sender, String message) {
		if (player.isOnline() && player.getName() != sender.getName()) {
			player.setFrozen(!player.isFrozen());
			
			if (!config.getBoolean("messages.enabled")) return;
			if (player.isFrozen()){
				Bukkit.getServer().broadcast(config.getString("messages.admin.player.frozen") + " " + player.getDisplayName(), "onyxadmin.freeze");
			} else {
				Bukkit.getServer().broadcast(config.getString("messages.admin.player.unfrozen") + " " + player.getDisplayName(), "onyxadmin.freeze");
			}
		}
	}
}
