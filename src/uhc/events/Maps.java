package uhc.events;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import uhc.Uhcmain;

public class Maps {
	 public static void unloadMap(String mapname){
	        if(Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(mapname), false)){
	            Uhcmain.plugin.getLogger().info("Successfully unloaded " + mapname);
	        }else{
	        	Uhcmain.plugin.getLogger().severe("COULD NOT UNLOAD " + mapname);
	        }
	    }
	    //Loading maps (MUST BE CALLED AFTER UNLOAD MAPS TO FINISH THE ROLLBACK PROCESS)
	    public static void loadMap(String mapname){
	        Bukkit.getServer().createWorld(new WorldCreator(mapname));
	    }
	 
	    //Maprollback method, because were too lazy to type 2 lines
	    public static void rollback(String mapname){
	        unloadMap(mapname);
	        loadMap(mapname);
	    }
}
