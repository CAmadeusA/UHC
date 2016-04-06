package uhc.events;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;

import uhc.Uhcmain;
import uhc.segments.MainSegments;
import uhc.segments.segmentmethods.Lobby;

public class JoinLeave implements Listener {
	
	ProtocolManager protocolManager = Uhcmain.protocolManager;
	PacketContainer uhcheart = new PacketContainer(PacketType.Play.Server.LOGIN);
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
			
		event.getPlayer().getInventory().clear();
		event.getPlayer().getInventory().setArmorContents(null);
		
		if (MainSegments.segment == 2) {
			Player player = event.getPlayer();
			player.kickPlayer("You Cannot Join in pre-game.");
			event.setJoinMessage(null);
		
		}
		if (MainSegments.segment == 5 || MainSegments.segment == 6) {
			Player player = event.getPlayer();
			player.kickPlayer("You Cannot Join in the end-game.");
			event.setJoinMessage(null);
		}
		
		if (MainSegments.segment == 1) {

		Player player = event.getPlayer();
		Bukkit.getServer().createWorld(new WorldCreator("lobby"));
		World lobby = Bukkit.getServer().createWorld(new WorldCreator("lobby"));

		int hy = lobby.getHighestBlockYAt(lobby.getSpawnLocation()) + 5;

		Location lobbyloc = new Location(lobby,
				(lobby.getSpawnLocation().getX()), hy,
				(lobby.getSpawnLocation().getZ()));
		
		player.getInventory().clear();
		
		player.setHealth(20L);
		
		player.setFoodLevel(20);		

		player.teleport(lobbyloc);
		
		player.setGameMode(GameMode.SURVIVAL);

		ArrayList<Player> opwoteam = TeamSetup.opwoteam;

		opwoteam.add(player);
		
		Lobby.onlineplayers.add(player);
		}
		
		if (MainSegments.segment == 3 || MainSegments.segment == 4 || MainSegments.segment == 6) {
			Player player = event.getPlayer();
			Bukkit.getServer().createWorld(new WorldCreator("world"));
			World world = Bukkit.getServer().createWorld(new WorldCreator("world"));
			int hy = world.getHighestBlockYAt(world.getSpawnLocation()) + 5;
			Location worldloc = new Location (world, world.getSpawnLocation().getX(), hy, world.getSpawnLocation().getZ());
			
			player.getInventory().clear();
			player.setHealth(20L);
			player.setFoodLevel(20);
			player.teleport(worldloc);
			
			Lobby.spectators.add(player);
			

		}

	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		
		Player player = event.getPlayer();
		if (player instanceof Player) {
			
			if (Lobby.onlineplayers.contains(player)) {
				Lobby.onlineplayers.remove(player);
			}
			
			if (Lobby.spectators.contains(player)) {
				Lobby.spectators.contains(player);
			}
			
			if (TeamSetup.log.contains(player)) {
				TeamSetup.log.remove(player);
			}
			if (TeamSetup.plank.contains(player)) {
				TeamSetup.plank.remove(player);

			}
			if (TeamSetup.stone.contains(player)) {
				TeamSetup.stone.remove(player);

			}
			if (TeamSetup.cobble.contains(player)) {
				TeamSetup.cobble.remove(player);
	
			}
			if (TeamSetup.coalore.contains(player)) {
				TeamSetup.coalore.remove(player);
	
			}
			if (TeamSetup.coal.contains(player)) {
				TeamSetup.coal.remove(player);
			
			}
			if (TeamSetup.ironore.contains(player)) {
				TeamSetup.ironore.remove(player);
				
			}
			if (TeamSetup.iron.contains(player)) {
				TeamSetup.iron.remove(player);
				
			}
			if (TeamSetup.goldore.contains(player)) {
				TeamSetup.goldore.remove(player);
				
			}
			if (TeamSetup.gold.contains(player)) {
				TeamSetup.gold.remove(player);
				
			}
			if (TeamSetup.diamondore.contains(player)) {
				TeamSetup.diamondore.remove(player);
				
			}
			if (TeamSetup.diamond.contains(player)) {
				TeamSetup.diamond.remove(player);
				
			}
			if (TeamSetup.emeraldore.contains(player)) {
				TeamSetup.emeraldore.remove(player);
				
			}
			if (TeamSetup.emerald.contains(player)) {
				TeamSetup.emerald.remove(player);
				
			}
			if (TeamSetup.netherstar.contains(player)) {
				TeamSetup.netherstar.remove(player);
				
			}
			if (TeamSetup.obsidian.contains(player)) {
				TeamSetup.obsidian.remove(player);
				
			}
			if (TeamSetup.cake.contains(player)) {
				TeamSetup.cake.remove(player);
				
			}
			if (TeamSetup.glass.contains(player)) {
				TeamSetup.glass.remove(player);
				
			}
			if (TeamSetup.lapisblock.contains(player)) {
				TeamSetup.lapisblock.remove(player);
				
			}
			if (TeamSetup.redstoneblock.contains(player)) {
				TeamSetup.redstoneblock.remove(player);
			}
			if (Lobby.onlineplayers.contains(player)) {
				Lobby.onlineplayers.remove(player);
			}
			if (Lobby.spectators.contains(player)) {
				Lobby.spectators.remove(player);
			}
			
			player.getInventory().clear();
			player.getInventory().setArmorContents(null);
		}
		
	}
	@EventHandler
	public void onKick(PlayerKickEvent event) {
		
		Player player = event.getPlayer();
		if (player instanceof Player) {
			
			if (Lobby.onlineplayers.contains(player)) {
				Lobby.onlineplayers.remove(player);
			}
			
			if (Lobby.spectators.contains(player)) {
				Lobby.spectators.contains(player);
			}
			
			if (TeamSetup.log.contains(player)) {
				TeamSetup.log.remove(player);
			}
			if (TeamSetup.plank.contains(player)) {
				TeamSetup.plank.remove(player);

			}
			if (TeamSetup.stone.contains(player)) {
				TeamSetup.stone.remove(player);

			}
			if (TeamSetup.cobble.contains(player)) {
				TeamSetup.cobble.remove(player);
	
			}
			if (TeamSetup.coalore.contains(player)) {
				TeamSetup.coalore.remove(player);
	
			}
			if (TeamSetup.coal.contains(player)) {
				TeamSetup.coal.remove(player);
			
			}
			if (TeamSetup.ironore.contains(player)) {
				TeamSetup.ironore.remove(player);
				
			}
			if (TeamSetup.iron.contains(player)) {
				TeamSetup.iron.remove(player);
				
			}
			if (TeamSetup.goldore.contains(player)) {
				TeamSetup.goldore.remove(player);
				
			}
			if (TeamSetup.gold.contains(player)) {
				TeamSetup.gold.remove(player);
				
			}
			if (TeamSetup.diamondore.contains(player)) {
				TeamSetup.diamondore.remove(player);
				
			}
			if (TeamSetup.diamond.contains(player)) {
				TeamSetup.diamond.remove(player);
				
			}
			if (TeamSetup.emeraldore.contains(player)) {
				TeamSetup.emeraldore.remove(player);
				
			}
			if (TeamSetup.emerald.contains(player)) {
				TeamSetup.emerald.remove(player);
				
			}
			if (TeamSetup.netherstar.contains(player)) {
				TeamSetup.netherstar.remove(player);
				
			}
			if (TeamSetup.obsidian.contains(player)) {
				TeamSetup.obsidian.remove(player);
				
			}
			if (TeamSetup.cake.contains(player)) {
				TeamSetup.cake.remove(player);
				
			}
			if (TeamSetup.glass.contains(player)) {
				TeamSetup.glass.remove(player);
				
			}
			if (TeamSetup.lapisblock.contains(player)) {
				TeamSetup.lapisblock.remove(player);
				
			}
			if (TeamSetup.redstoneblock.contains(player)) {
				TeamSetup.redstoneblock.remove(player);
			}
			if (Lobby.onlineplayers.contains(player)) {
				Lobby.onlineplayers.remove(player);
			}
			if (Lobby.spectators.contains(player)) {
				Lobby.spectators.remove(player);
			}
			
			event.setLeaveMessage("");
			
			player.getInventory().clear();
			player.getInventory().setArmorContents(null);
			

			
			
			
		}
		
	}
	
	
	
	
}
