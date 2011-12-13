package me.maveronyx.onyxadmin;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class OnyxAdminCommandExecutor implements CommandExecutor {
	private static final Logger log = Logger.getLogger("Minecraft");

	private HashMap<String, Integer> commandMap = new HashMap<String, Integer>();
	private AdminCommands adminCommands;
	private OnyxAdmin plugin;
	private FileConfiguration config;

	public OnyxAdminCommandExecutor(OnyxAdmin instance) {

		plugin = instance;
		config = instance.getConfig();
		adminCommands = new AdminCommands(plugin, config);

		// Register all commands and map them
		commandMap.put("warn", 1);
		commandMap.put("kick", 2);
		commandMap.put("ban", 3);
		commandMap.put("freeze", 4);
		commandMap.put("setWeather", 5);
		commandMap.put("setTime", 6);
		commandMap.put("unban", 7);
		// commandMap.put("burnplayer", 8);
		// commandMap.put("explodeplayer", 9);
		// commandMap.put("give", 10);
		// commandMap.put("take", 11);
		// commandMap.put("toggletnt", 12);
		// commandMap.put("removetnt", 13);
		// commandMap.put("tp", 14);
		// commandMap.put("tpall", 15);
		// commandMap.put("togglebuild", 16);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			
			String cmd = command.getName().toLowerCase();

			log.info("[OnyxAdmin] Command " + cmd + " called");

			if (commandMap.containsKey(cmd)) {
				/* TODO (as suggested by Tustin)
				 * We have a commandMap here. Instead of mapping from a string to an integer, which
				 * is then used in a switch statement, use Object Oriented programming to its fullest:
				 * Map strings to Command Objects, which get a executeCommand() method called on them.
				 * Copy all the code below into those individual command objects, along with their
				 * respective methods in AdminCommands, and now the code is easier to read, manage, and
				 * is slightly faster (though the first two are more important in the long run).
				 */
				Integer commandId = commandMap.get(cmd);

				switch (commandId) {
				case 1:

					

				case 2:
					

				case 3:
					

				case 4:
					
					
				case 5:
					
					
					
				case 6:
					
					
				case 7:
				}
				}
			}
		
		return false;
	}

}
