package me.maveronyx.onyxadmin;

import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

/**
 * This is a wrapper on the bukkit Player interface. This class will store any
 * custom information about the player that we might want to store, like if the
 * player is frozen.
 * @author timpittman
 */
public class OnyxPlayer extends PlayerWrapper implements YamlSerializeable {
	
	//Insert metadata below
	
	private int warnings = 0;
	private boolean frozen = false; 
	
	//Insert metadata above
	//Insert methods for metadata below
	
	public int getWarningNumber() {return warnings;}
	public void incrementWarnings() {warnings++;}
	public void setWarningNumber(int warnings) {this.warnings = warnings;}
	
	public boolean isFrozen() {return frozen;}
	public void setFrozen(boolean frozen) {this.frozen = frozen;}
	
	//Insert methods for metadata above
	
	public OnyxPlayer(Player player){
		super(player);
	}
	
	public Configuration getSerialized(){
		//TODO serlialize this class to a Yaml file, which will be saved.
		return null;
	}
}
