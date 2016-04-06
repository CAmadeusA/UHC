package uhc.segments;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import uhc.Uhcmain;
import uhc.events.TeamSetup;
import uhc.segments.segmentmethods.Cleanup;
import uhc.segments.segmentmethods.EndGame;
import uhc.segments.segmentmethods.Immunity;
import uhc.segments.segmentmethods.LiveGame;
import uhc.segments.segmentmethods.Lobby;
import uhc.segments.segmentmethods.PreEndgame;
import uhc.segments.segmentmethods.Pregame;

public class MainSegments {
	public static final int lobby = 1;
	public static final int pregame = 2;
	public static final int immunity = 3;
	public static final int livegame = 4;
	public static final int preendgame = 5;
	public static final int endgame = 6;
	public static final int cleanup = 7;

	public static int paused = 0;
	public static int segment = 1;
	
	public static ArrayList<Player> opwoteam = new ArrayList<Player>();


	public static void init() {

		Uhcmain.plugin
				.getServer()
				.getScheduler()
				.scheduleSyncRepeatingTask(Uhcmain.getInstance(),
						new Runnable() {
							public void run() {

								if (paused == 1) {

								}

								else if (paused == 0) {

									if (segment == 1) {
										paused = 1;
										Lobby.init();
									}
									if (segment == 2) {
										paused = 1;
										Pregame.init();
									}
									if (segment == 3) {
										paused = 1;
										Immunity.init();
									}
									if (segment == 4) {
										paused = 1;
										LiveGame.init();
									}
									if (segment == 5) {
										paused = 1;
										PreEndgame.init();
									}
									if (segment == 6) {
										paused = 1;
										EndGame.init();
									}
									if (segment == 7) {
										paused = 1;
										Cleanup.init();
									}

									for (Player player : Bukkit
											.getOnlinePlayers()) {
										if (!(opwoteam.contains(player))) {
											if (!(TeamSetup.log.contains(player)
													|| TeamSetup.plank
															.contains(player)
													|| TeamSetup.cobble
															.contains(player)
													|| TeamSetup.coalore
															.contains(player)
													|| TeamSetup.coal
															.contains(player)
													|| TeamSetup.ironore
															.contains(player)
													|| TeamSetup.iron
															.contains(player)
													|| TeamSetup.goldore
															.contains(player)
													|| TeamSetup.gold
															.contains(player)
													|| TeamSetup.diamondore
															.contains(player)
													|| TeamSetup.diamond
															.contains(player)
													|| TeamSetup.emeraldore
															.contains(player)
													|| TeamSetup.emerald
															.contains(player)
													|| TeamSetup.netherstar
															.contains(player)
													|| TeamSetup.obsidian
															.contains(player)
													|| TeamSetup.cake
															.contains(player)
													|| TeamSetup.glass
															.contains(player)
													|| TeamSetup.lapisblock
															.contains(player))) {
												
												opwoteam.add(player);

											}
										}
									}

								}

							}
						}, 0, 20);
	}

}
