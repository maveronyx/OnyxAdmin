package me.maveronyx.onyxadmin.commands;

import java.util.logging.Logger;

import me.maveronyx.onyxadmin.OnyxAdmin;
import me.maveronyx.onyxadmin.OnyxPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class AbstractCommand implements CommandExecutor {
	protected static final Logger log = Logger.getLogger("Minecraft");
	
	@Override public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		log.info("[OnyxAdmin] Command " + command.getName() + " called");
		
		if (sender instanceof Player){
			OnyxPlayer op = OnyxAdmin.instance.getOnyxPlayer((Player)sender);
			return this.executeCommand(op, sender, command, label, args);
		} else {
			return this.executeCommand(sender, command, label, args);
		}
	}
	
	public boolean executeCommand(OnyxPlayer player, CommandSender sender, Command command, String label, String[] args) {
		return this.executeCommand(sender, command, label, args);
	}
	public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("This command is not designed for console use.");
		return true;
	}
	
	
	/**
	 * Check if player can be used as target
	 * @param player
	 * @return
	 */
	protected boolean canBePunished(Player player) {
		if (player == null) return false;
		if (!player.isOnline()) return false;
		if (player.isBanned()) return false;
		if (player.isOp()) return false;
		return true;
	}
}
