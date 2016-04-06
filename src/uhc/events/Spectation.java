package uhc.events;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import uhc.Uhcmain;
import uhc.segments.segmentmethods.Lobby;

public class Spectation implements Listener {
    
    
	@EventHandler
	public void moveEvent(PlayerMoveEvent event) {

		for (Player player : Lobby.onlineplayers) {
			for (Player spectators : Lobby.spectators) {
				if (player.canSee(spectators)) {
					player.hidePlayer(spectators);
				}
				if (!(spectators.canSee(player))) {

					spectators.showPlayer(player);
				}

				spectators.setAllowFlight(true);
				spectators.setGameMode(GameMode.CREATIVE);
				spectators.setFlying(true);
				spectators.setFoodLevel(20);
				spectators.setSaturation(2000);
				spectators.setHealth(20);
				
				spectators.setGameMode(GameMode.SPECTATOR);

				spectators.getInventory().clear();


				
				
			}

		}

	}

	@EventHandler
	public void chatEvent(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		if (Lobby.spectators.contains(player)) {
			event.setCancelled(true);
			for (Player spectators : Lobby.spectators) {
				spectators.sendMessage(ChatColor.GRAY + "[Spectator] "
						+ ChatColor.ITALIC + player.getName().toString()
						+ ChatColor.RESET + ": " + message);
			}

		}
		if (Lobby.onlineplayers.contains(player)) {
			event.setCancelled(true);
			for (Player p : Bukkit.getOnlinePlayers()) {
				p.sendMessage(ChatColor.DARK_GREEN + "[Alive] "
						+ player.getName().toString() + ChatColor.RESET + ": "
						+ message);
			}
		}
	}
	@EventHandler
	public void deathEvent(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (player instanceof Player) {
			Lobby.spectators.add(player);
		}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();

		if (Lobby.spectators.contains(player)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (Lobby.spectators.contains(player)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();
		if (Lobby.spectators.contains(player)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onVehicleDamageEvent(VehicleDamageEvent event) {
		Entity damager = event.getAttacker();
		if (damager instanceof Player) {
			if (Lobby.spectators.contains(damager)) {
				event.setCancelled(true);
			}
		}

	}

	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player) {
			Entity damager = event.getDamager();
			if (Lobby.spectators.contains(damager)) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onVehicleEntityCollsionEvent(VehicleEntityCollisionEvent event) {
		Entity collider = event.getEntity();
		if (event.getEntity() instanceof Player) {
			if (Lobby.spectators.contains(collider)) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onVehicleEnterEvent(VehicleEnterEvent event) {
		Entity enterer = event.getEntered();
		if (event.getEntered() instanceof Player) {
			if (Lobby.spectators.contains(enterer)) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onPlayerBedEnterEvent(PlayerBedEnterEvent event) {
		Player enterer = event.getPlayer();
		if (Lobby.spectators.contains(enterer)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onEntityInteractEvent(EntityInteractEvent event) {
		Entity entity = event.getEntity();
		if (Lobby.spectators.contains(entity)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player interacter = event.getPlayer();

		if (Lobby.spectators.contains(interacter)) {
			if (event.getAction() == Action.RIGHT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_AIR
					|| event.getAction() == Action.LEFT_CLICK_AIR
					|| event.getAction() == Action.LEFT_CLICK_BLOCK) {
				
				event.setCancelled(true);
				Player nextplayer = (Player) Lobby.onlineplayers.iterator().next();
				if (nextplayer != null) {
				interacter.teleport(Lobby.onlineplayers.iterator().next());
				}
				
				
			}
		}
	}
}
