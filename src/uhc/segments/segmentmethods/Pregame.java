package uhc.segments.segmentmethods;

import static uhc.Uhcmain.getInstance;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.World.Environment;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

import uhc.Uhcmain;
import uhc.inventory.JoinTeam;
import uhc.score.ScoreManager;
import uhc.segments.MainSegments;

public class Pregame {

	public static int pregametimer = 30;
	public static String pregametimestamp = "";
	public static String pregametimestamplog = "";
	public static int pregamerepeatingtask;

	public static void init() {
		
		World world = Bukkit.getWorld("survivalworld");
		int worldx = Bukkit.getWorld("survivalworld").getSpawnLocation().getBlockX();
		int worldy = Bukkit.getWorld("survivalworld").getSpawnLocation().getBlockY();
		int worldz = Bukkit.getWorld("survivalworld").getSpawnLocation().getBlockZ();
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!(player.getWorld().equals(player))) {
				
				Random random = new Random();
				
				int rx = random.nextInt(2000) + 1 - 1000;
				int rz = random.nextInt(2000) + 1 - 1000;
				int ry = world.getHighestBlockYAt(rx, rz);

				Location teleportLocation = (new Location(world, rx,
						ry, rz));
				
				player.teleport(teleportLocation);
				player.sendMessage(Uhcmain.formatDefault + "An error occured and you were unable to be teleported. Teleporting you now.");
			}
		}
		
		Bukkit.broadcastMessage("Pregame Starting");

		if (pregametimer > 120) {
			Pregame.pregametimestamp = "2:" + (pregametimer - 120);
		}
		if (pregametimer < 120 && pregametimer > 60) {
			Pregame.pregametimestamp = "1:" + (pregametimer - 60);
		}
		if (pregametimer < 60) {
			Pregame.pregametimestamp = "0:" + (pregametimer);
		}
		

		for (Player p : Bukkit.getOnlinePlayers()) {			
			p.setScoreboard(ScoreManager.statusboard);
			
			p.setHealth(20);
			p.setFoodLevel(20);
			
			Bukkit.broadcastMessage("Player is in: " + p.getWorld().getName());
		}

		Pregame.pregametimestamplog = Pregame.pregametimestamp;

		pregametimer--;
		
	
		

		pregamerepeatingtask = Uhcmain.plugin.getServer().getScheduler()
				.scheduleSyncRepeatingTask(getInstance(), new Runnable() {
					public void run() {

						if (pregametimer >= 1) {

							if (pregametimer < 60) {
								int pregametimer0 = (pregametimer);
								if (pregametimer0 >= 10) {
									Pregame.pregametimestamp = "00:"
											+ (pregametimer);
								} else if (pregametimer0 <= 9) {
									Pregame.pregametimestamp = "00:0"
											+ (pregametimer);
								}
							}
							pregametimer--;
						}

						
						if (pregametimer == 0) {
						pregametimer--;

						MainSegments.segment++;
						MainSegments.paused = 0;

						Uhcmain.plugin.getServer().getScheduler()
								.cancelTask(pregamerepeatingtask);

						for (Player player : Bukkit.getOnlinePlayers()) {
							player.getInventory().clear();
						}
						
						}
					}
				}, 0, 20);

	}

}
