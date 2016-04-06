package uhc;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

import uhc.commands.Staff;
import uhc.events.JoinLeave;
import uhc.events.Spectation;
import uhc.events.TeamSetup;
import uhc.events.UHCHearts;
import uhc.inventory.JoinTeam;
import uhc.score.ScoreManager;
import uhc.segments.MainSegments;
import uhc.segments.segmentmethods.LiveGame;
import uhc.segments.segmentmethods.Lobby;

public class Uhcmain extends JavaPlugin {
	public static Plugin plugin;
	public static String formatDefault = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "UHC" + ChatColor.DARK_GRAY + "]" + ChatColor.WHITE + " ";
	public static ProtocolManager protocolManager;


	public void onEnable() {
		plugin = this;
		getLogger().info("Creating Universe");
		getLogger().info("Creating Planets");
		getLogger().info("Creating life from primordial ooz");
		getLogger().info("Creating Kittens");
		getLogger().info("Importing database from alien spaceship");
		getLogger().info("Plugin Initializing based on kitty power!");
		getLogger().info("Plugin Enabled Version 0.069");

		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Lobby(), this);
		pm.registerEvents(new JoinTeam(), this);
		pm.registerEvents(new TeamSetup(), this);
		pm.registerEvents(new LiveGame(), this);
		pm.registerEvents(new JoinLeave(), this);
		pm.registerEvents(new Spectation(), this);
		
		ScoreManager.init();
		MainSegments.init();
		
		getCommand("NextSegment").setExecutor(new Staff());
		getCommand("ForceCleanup").setExecutor(new Staff());

	    protocolManager = ProtocolLibrary.getProtocolManager();
	   

		

	}

	public void loadCommands() {
		
	}
	
	public void onDisable() {
	}

	public static Plugin getInstance() {
		return plugin;
	}
}
