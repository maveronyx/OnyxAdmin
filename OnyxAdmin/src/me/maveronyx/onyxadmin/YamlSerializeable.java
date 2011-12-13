package me.maveronyx.onyxadmin;

import org.bukkit.configuration.Configuration;

/**
 * Classes that implement this method can serialize and deserialize themselves into a Yaml object.
 * @author timpittman
 */
public interface YamlSerializeable {
	public Configuration getSerialized();
}
