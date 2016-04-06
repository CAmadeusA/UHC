package uhc.segments.segmentmethods;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.util.FileUtil;

import uhc.Uhcmain;
import uhc.events.Maps;
import uhc.segments.MainSegments;

public class Cleanup {
	public static void init() {
		
		Lobby.minutelobbytimer = 2;
		Lobby.onlineplayers.clear();
		Lobby.secondlobbytimer = 59;
		Lobby.spectators.clear();
		
		Pregame.pregametimer = 30;
		
		Immunity.immunitytimer = 30;
		
		LiveGame.minutelivegametimer = 44;
		LiveGame.secondlivegametimer = 59;
		
		PreEndgame.preendgametimer = 10;
		
		EndGame.secondendgametimer = 30;
		EndGame.minuteendgametimer = 2;
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.kickPlayer("The Game has Ended");
		}
		
		{
	        if(Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld("survivalworld"), false)){
	            Uhcmain.plugin.getLogger().info("Successfully unloaded " + "survivalworld");
	        }else{
	        	Uhcmain.plugin.getLogger().severe("COULD NOT UNLOAD " + "survivalworld");
	        }
	    }
		
        Bukkit.getServer().createWorld(new WorldCreator("survivalworld"));
        Bukkit.getServer().createWorld(new WorldCreator("survivalworld")).setAutoSave(false);
        Bukkit.getServer().createWorld(new WorldCreator("survivalworld")).setTime(0);
 		
		Bukkit.broadcastMessage("This is Cleanup");
		MainSegments.segment = 1;
		MainSegments.paused = 0;
	}
}
