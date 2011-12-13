package me.maveronyx.onyxadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Logger;

import me.maveronyx.onyxadmin.commands.BanCommand;
import me.maveronyx.onyxadmin.commands.FreezeCommand;
import me.maveronyx.onyxadmin.commands.KickCommand;
import me.maveronyx.onyxadmin.commands.TimeCommand;
import me.maveronyx.onyxadmin.commands.UnbanCommand;
import me.maveronyx.onyxadmin.commands.WarnCommand;
import me.maveronyx.onyxadmin.commands.WeatherCommand;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class OnyxAdmin extends JavaPlugin {

	private static final Logger log = Logger.getLogger("Minecraft");
	public static OnyxAdmin instance = null;
	
	private Config conf;

	private OnyxAdminText chat;
	private boolean messagesEnabled = true;
	private PluginManager pm;
	private HashSet<String> burning = new HashSet<String>();
	public ArrayList<String> frozenPlayers = new ArrayList<String>();
	public HashMap<String, Integer> warnedPlayers = new HashMap<String, Integer>();
	
	//private OnyxAdminCommandExecutor commandExecutor;
	
	private final OnyxAdminPlayerListener playerListener = new OnyxAdminPlayerListener(this);

	@Override
	public void onEnable() {
		//if (instance == null)
			instance = this;
		
		// Get the config
		conf = new Config(this);

		log.info("[OnyxAdmin] Starting...");
		log.info("[OnyxAdmin] Registering events...");

		// Get the plugin manager
		pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener,
				Event.Priority.Normal, this);

		//commandExecutor = new OnyxAdminCommandExecutor(this);
		getCommand("warn").setExecutor(new WarnCommand());
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("unban").setExecutor(new UnbanCommand());
		getCommand("freeze").setExecutor(new FreezeCommand());
		getCommand("setWeather").setExecutor(new WeatherCommand());
		getCommand("setTime").setExecutor(new TimeCommand());
		//getCommand("burnplayer").setExecutor(new BurnCommand());
		//getCommand("explodeplayer").setExecutor(new ExplodeCommand());
		//getCommand("give").setExecutor(new GiveCommand());
		//getCommand("take").setExecutor(new TakeCommand());
		//getCommand("toggletnt").setExecutor(new ToggleTntCommand());
		//getCommand("removetnt").setExecutor(new RemoveTntCommand());
		//getCommand("tp").setExecutor(new TpCommand());
		//getCommand("tpall").setExecutor(new TpAllCommand());
		//getCommand("togglebuild").setExecutor(new ToggleBuildCommand());
		
		log.info("[OnyxAdmin] Done!");
	}

	@Override
	public void onDisable() {

		// Check if messages should be broadcasted
		// if(messagesEnabled){
		// chat.broadcastServer("Plugin shutting down. Bye guys");
		// }
		conf.saveConfig();

		log.info("[OnyxAdmin] Shutting down...");
		log.info("[OnyxAdmin] Done!");
	}

	public OnyxPlayer getOnyxPlayer(Player sender) {
		//TODO pull the OnyxPlayer from a list of current players!
		return new OnyxPlayer(sender);
	}

}
