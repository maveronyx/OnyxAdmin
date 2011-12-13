package me.maveronyx.onyxadmin.commands;

import java.util.Set;

import me.maveronyx.onyxadmin.OnyxAdmin;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

public class UnbanCommand extends AbstractCommand {
	
	private Configuration config = OnyxAdmin.instance.getConfig();
	
	@Override public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {

			if (args[0].equalsIgnoreCase("*")) {
				if (sender.hasPermission("onyxadmin.unban.all")) {
					// All online players
					Set<OfflinePlayer> targets = Bukkit.getServer().getBannedPlayers();

					if (!targets.isEmpty()) {
						for (OfflinePlayer target : targets) {
							unbanPlayer(target, sender);

							if (config.getBoolean("messages.enabled")) {
								sender.sendMessage(config.getString("messages.admin.all.unbanned"));
							}
						}
					}
				} else {
					sender.sendMessage("You don't have the right permissions to use that command");
				}
				return true;

			} else {
				if (sender.hasPermission("onyxadmin.unban.player")) {
					// Single player
					Player target = Bukkit.getServer().getPlayer(args[0]);

					if (target != null && target.isBanned()) {
						unbanPlayer(target, sender);
					} else {
						if (config.getBoolean("messages.enabled")) {
							sender.sendMessage(config.getString("messages.admin.player.unbanned"));
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
	 * Unban a player
	 * 
	 * @param player
	 * @param sender
	 */
	public void unbanPlayer(OfflinePlayer player, CommandSender sender) {

		if (player.getName() != sender.getName() && player.isBanned()) {
			player.setBanned(false);
			if (config.getBoolean("messages.enabled"))
				Bukkit.getServer().broadcast(config.getString("messages.admin.player.unban") + " " + player.getName(), "onyxadmin.unban");
		}
	}
}
