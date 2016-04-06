package uhc.segments.segmentmethods;

import static uhc.Uhcmain.getInstance;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.Chunk;

import uhc.Uhcmain;
import uhc.segments.MainSegments;

public class PreEndgame {

	public static int preendgametimer = 10;
	public static String preendgametimestamp = "";
	public static String preendgametimestamplog = "";
	public static int preendgamerepeatingtask;

	public static void init() {

		PreEndgame.preendgametimestamplog = PreEndgame.preendgametimestamp;

		preendgamerepeatingtask = Uhcmain.plugin.getServer().getScheduler()
				.scheduleSyncRepeatingTask(getInstance(), new Runnable() {
					public void run() {

						if (preendgametimer == 10) {
							preendgametimestamp = "00:" + preendgametimer;

							Bukkit.getServer()
									.broadcastMessage(
											Uhcmain.formatDefault
													+ "The deathmatch will begin in "
													+ preendgametimestamp
													+ " seconds!");

							Bukkit.getServer().getWorld("survivalworld")
									.regenerateChunk(0, 0);

							Chunk zz = Bukkit.getWorld("survivalworld")
									.getChunkAt(0, 0);
							zz.load();

							preendgametimer--;

						}
						if (preendgametimer < 10) {
							preendgametimestamp = "00:0" + preendgametimer;
							Bukkit.getServer()
									.broadcastMessage(
											Uhcmain.formatDefault
													+ "The deathmatch will begin in "
													+ preendgametimestamp
													+ " seconds!");

							preendgametimer--;
						}

						if (preendgametimer == 0) {

							MainSegments.segment++;
							MainSegments.paused = 0;

							Uhcmain.plugin.getServer().getScheduler()
									.cancelTask(preendgamerepeatingtask);

							int hy = Bukkit.getServer()
									.getWorld("survivalworld")
									.getHighestBlockYAt(0, 0);

							Location dm = new Location(Bukkit.getServer()
									.getWorld("survivalworld"), 0, hy, 0);

							for (Player player : Bukkit.getOnlinePlayers()) {

								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ "The Server is loading your teleport for your best experience, please be patient.");
								dm.getChunk().load();
								boolean isLoaded = dm.getChunk().isLoaded();
								while (!isLoaded) {
									isLoaded = dm.getChunk().isLoaded();
								}

								player.teleport(dm);
							}

						}
					}
				}, 0, 20L);
	}
}
