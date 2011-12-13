package me.maveronyx.onyxadmin;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Server;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class PlayerWrapper implements Player {
	protected Player base;
	
	public PlayerWrapper(Player base){
		this.base = base;
	}
	
	public Player getBase(){ return base; }
	
	//////////

	@Override public GameMode getGameMode() {
		return base.getGameMode();
	}
	
	@Override public PlayerInventory getInventory() {
		return base.getInventory();
	}

	@Override public ItemStack getItemInHand() {
		return base.getItemInHand();
	}

	@Override public String getName() {
		return base.getName();
	}

	@Override public int getSleepTicks() {
		return base.getSleepTicks();
	}

	@Override public boolean isSleeping() {
		return base.isSleeping();
	}

	@Override public void setGameMode(GameMode mode) {
		base.setGameMode(mode);
	}

	@Override public void setItemInHand(ItemStack item) {
		base.setItemInHand(item);
	}

	@Override public void damage(int amount) {
		base.damage(amount);
	}

	@Override public void damage(int amount, Entity source) {
		base.damage(amount, source);
	}

	@Override public double getEyeHeight() {
		return base.getEyeHeight();
	}

	@Override public double getEyeHeight(boolean ignoreSneaking) {
		return base.getEyeHeight(ignoreSneaking);
	}

	@Override public Location getEyeLocation() {
		return base.getEyeLocation();
	}

	@Override public int getHealth() {
		return base.getHealth();
	}

	@Override public Player getKiller() {
		return base.getKiller();
	}

	@Override public int getLastDamage() {
		return base.getLastDamage();
	}

	@Override public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
		return base.getLastTwoTargetBlocks(transparent, maxDistance);
	}

	@Override public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
		return base.getLineOfSight(transparent, maxDistance);
	}

	@Override public int getMaxHealth() {
		return base.getMaxHealth();
	}

	@Override public int getMaximumAir() {
		return base.getMaximumAir();
	}

	@Override public int getMaximumNoDamageTicks() {
		return base.getMaximumNoDamageTicks();
	}

	@Override public int getNoDamageTicks() {
		return base.getNoDamageTicks();
	}

	@Override public int getRemainingAir() {
		return base.getRemainingAir();
	}

	@Override public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
		return base.getTargetBlock(transparent, maxDistance);
	}

	@Override public Vehicle getVehicle() {
		return base.getVehicle();
	}

	@Override public boolean isInsideVehicle() {
		return base.isInsideVehicle();
	}

	@Override public boolean leaveVehicle() {
		return base.leaveVehicle();
	}

	@Override public void setHealth(int health) {
		base.setHealth(health);
	}

	@Override public void setLastDamage(int damage) {
		base.setLastDamage(damage);
	}

	@Override public void setMaximumAir(int ticks) {
		base.setMaximumAir(ticks);
	}

	@Override public void setMaximumNoDamageTicks(int ticks) {
		base.setMaximumNoDamageTicks(ticks);
	}

	@Override public void setNoDamageTicks(int ticks) {
		base.setNoDamageTicks(ticks);
	}

	@Override public void setRemainingAir(int ticks) {
		base.setRemainingAir(ticks);
	}

	@Override public Arrow shootArrow() {
		return base.shootArrow();
	}

	@Override public Egg throwEgg() {
		return base.throwEgg();
	}

	@Override public Snowball throwSnowball() {
		return base.throwSnowball();
	}

	@Override public boolean eject() {
		return base.eject();
	}

	@Override public int getEntityId() {
		return base.getEntityId();
	}

	@Override public float getFallDistance() {
		return base.getFallDistance();
	}

	@Override public int getFireTicks() {
		return base.getFireTicks();
	}

	@Override public EntityDamageEvent getLastDamageCause() {
		return base.getLastDamageCause();
	}

	@Override public Location getLocation() {
		return base.getLocation();
	}

	@Override public int getMaxFireTicks() {
		return base.getMaxFireTicks();
	}

	@Override public List<Entity> getNearbyEntities(double x, double y, double z) {
		return base.getNearbyEntities(x, y, z);
	}

	@Override public Entity getPassenger() {
		return base.getPassenger();
	}

	@Override public Server getServer() {
		return base.getServer();
	}

	@Override public int getTicksLived() {
		return base.getTicksLived();
	}

	@Override public UUID getUniqueId() {
		return base.getUniqueId();
	}

	@Override public Vector getVelocity() {
		return base.getVelocity();
	}

	@Override public World getWorld() {
		return base.getWorld();
	}

	@Override public boolean isDead() {
		return base.isDead();
	}

	@Override public boolean isEmpty() {
		return base.isEmpty();
	}

	@Override public void remove() {
		base.remove();
	}

	@Override public void setFallDistance(float distance) {
		base.setFallDistance(distance);
	}

	@Override public void setFireTicks(int ticks) {
		base.setFireTicks(ticks);
	}

	@Override public void setLastDamageCause(EntityDamageEvent event) {
		base.setLastDamageCause(event);
	}

	@Override public boolean setPassenger(Entity passenger) {
		return base.setPassenger(passenger);
	}

	@Override public void setTicksLived(int value) {
		base.setTicksLived(value);
	}

	@Override public void setVelocity(Vector velocity) {
		base.setVelocity(velocity);
	}

	@Override public boolean teleport(Location location) {
		return base.teleport(location);
	}

	@Override public boolean teleport(Entity destination) {
		return base.teleport(destination);
	}

	@Override public boolean teleport(Location location, TeleportCause cause) {
		return base.teleport(location, cause);
	}

	@Override public boolean teleport(Entity destination, TeleportCause cause) {
		return base.teleport(destination, cause);
	}

	@Override public PermissionAttachment addAttachment(Plugin plugin) {
		return base.addAttachment(plugin);
	}

	@Override public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		return base.addAttachment(plugin, ticks);
	}

	@Override public PermissionAttachment addAttachment(Plugin plugin, String name,
			boolean value) {
		return base.addAttachment(plugin, name, value);
	}

	@Override public PermissionAttachment addAttachment(Plugin plugin, String name,
			boolean value, int ticks) {
		return base.addAttachment(plugin, name, value, ticks);
	}

	@Override public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return base.getEffectivePermissions();
	}

	@Override public boolean hasPermission(String name) {
		return base.hasPermission(name);
	}

	@Override public boolean hasPermission(Permission perm) {
		return base.hasPermission(perm);
	}

	@Override public boolean isPermissionSet(String name) {
		return base.isPermissionSet(name);
	}

	@Override public boolean isPermissionSet(Permission perm) {
		return base.isPermissionSet(perm);
	}

	@Override public void recalculatePermissions() {
		base.recalculatePermissions();
	}

	@Override public void removeAttachment(PermissionAttachment attachment) {
		base.removeAttachment(attachment);
	}

	@Override public boolean isOp() {
		return base.isOp();
	}

	@Override public void setOp(boolean value) {
		base.setOp(value);
	}

	@Override public void sendMessage(String message) {
		base.sendMessage(message);
	}

	@Override public Player getPlayer() {
		return base.getPlayer();
	}

	@Override public boolean isBanned() {
		return base.isBanned();
	}

	@Override public boolean isOnline() {
		return base.isOnline();
	}

	@Override public boolean isWhitelisted() {
		return base.isWhitelisted();
	}

	@Override public void setBanned(boolean banned) {
		base.setBanned(banned);
	}

	@Override public void setWhitelisted(boolean value) {
		base.setWhitelisted(value);
	}

	@Override public Map<String, Object> serialize() {
		return base.serialize();
	}

	@Override public void awardAchievement(Achievement achievement) {
		base.awardAchievement(achievement);
	}

	@Override public void chat(String msg) {
		base.chat(msg);
	}

	@Override public InetSocketAddress getAddress() {
		return base.getAddress();
	}

	@Override public Location getBedSpawnLocation() {
		return base.getBedSpawnLocation();
	}

	@Override public Location getCompassTarget() {
		return base.getCompassTarget();
	}

	@Override public String getDisplayName() {
		return base.getDisplayName();
	}

	@Override public float getExhaustion() {
		return base.getExhaustion();
	}

	@Override public float getExp() {
		return base.getExp();
	}

	@Override @Deprecated public int getExperience() {
		return base.getExperience();
	}

	@Override public int getFoodLevel() {
		return base.getFoodLevel();
	}

	@Override public int getLevel() {
		return base.getLevel();
	}

	@Override public String getPlayerListName() {
		return base.getPlayerListName();
	}

	@Override public long getPlayerTime() {
		return base.getPlayerTime();
	}

	@Override public long getPlayerTimeOffset() {
		return base.getPlayerTimeOffset();
	}

	@Override public float getSaturation() {
		return base.getSaturation();
	}

	@Override public int getTotalExperience() {
		return base.getTotalExperience();
	}

	@Override public void giveExp(int amount) {
		base.giveExp(amount);
	}

	@Override public void incrementStatistic(Statistic statistic) {
		base.incrementStatistic(statistic);
	}

	@Override public void incrementStatistic(Statistic statistic, int amount) {
		base.incrementStatistic(statistic, amount);
	}

	@Override public void incrementStatistic(Statistic statistic, Material material) {
		base.incrementStatistic(statistic, material);
	}

	@Override public void incrementStatistic(Statistic statistic, Material material, int amount) {
		base.incrementStatistic(statistic, material, amount);
	}

	@Override public boolean isPlayerTimeRelative() {
		return base.isPlayerTimeRelative();
	}

	@Override public boolean isSleepingIgnored() {
		return base.isSleepingIgnored();
	}

	@Override public boolean isSneaking() {
		return base.isSneaking();
	}

	@Override public boolean isSprinting() {
		return base.isSprinting();
	}

	@Override public void kickPlayer(String message) {
		base.kickPlayer(message);
	}

	@Override public void loadData() {
		base.loadData();
	}

	@Override public boolean performCommand(String command) {
		return base.performCommand(command);
	}

	@Override public void playEffect(Location loc, Effect effect, int data) {
		base.playEffect(loc, effect, data);
	}

	@Override public void playNote(Location loc, byte instrument, byte note) {
		base.playNote(loc, instrument, note);
	}

	@Override public void playNote(Location loc, Instrument instrument, Note note) {
		base.playNote(loc, instrument, note);
	}

	@Override public void resetPlayerTime() {
		base.resetPlayerTime();
	}

	@Override public void saveData() {
		base.saveData();
	}

	@Override public void sendBlockChange(Location loc, Material material, byte data) {
		base.sendBlockChange(loc, material, data);
	}

	@Override public void sendBlockChange(Location loc, int material, byte data) {
		base.sendBlockChange(loc, material, data);
	}

	@Override public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
		return base.sendChunkChange(loc, sx, sy, sz, data);
	}

	@Override public void sendMap(MapView map) {
		base.sendMap(map);
	}

	@Override public void sendRawMessage(String message) {
		base.sendRawMessage(message);
	}

	@Override public void setCompassTarget(Location loc) {
		base.setCompassTarget(loc);
	}

	@Override public void setDisplayName(String name) {
		base.setDisplayName(name);
	}

	@Override public void setExhaustion(float value) {
		base.setExhaustion(value);
	}

	@Override public void setExp(float exp) {
		base.setExp(exp);
	}

	@Override @Deprecated public void setExperience(int exp) {
		base.setExperience(exp);
	}

	@Override public void setFoodLevel(int value) {
		base.setFoodLevel(value);
	}

	@Override public void setLevel(int level) {
		base.setLevel(level);
	}

	@Override public void setPlayerListName(String name) {
		base.setPlayerListName(name);
	}

	@Override public void setPlayerTime(long time, boolean relative) {
		base.setPlayerTime(time, relative);
	}

	@Override public void setSaturation(float value) {
		base.setSaturation(value);
	}

	@Override public void setSleepingIgnored(boolean isSleeping) {
		base.setSleepingIgnored(isSleeping);
	}

	@Override public void setSneaking(boolean sneak) {
		base.setSneaking(sneak);
	}

	@Override public void setSprinting(boolean sprinting) {
		base.setSprinting(sprinting);
	}

	@Override public void setTotalExperience(int exp) {
		base.setTotalExperience(exp);
	}

	@Override @Deprecated public void updateInventory() {
		base.updateInventory();
	}

	@Override public long getFirstPlayed() {
		return base.getFirstPlayed();
	}

	@Override public long getLastPlayed() {
		return base.getLastPlayed();
	}

	@Override public boolean hasPlayedBefore() {
		return base.hasPlayedBefore();
	}

}
