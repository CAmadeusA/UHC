package uhc.segments.segmentmethods;

import static uhc.Uhcmain.getInstance;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import uhc.Uhcmain;
import uhc.segments.MainSegments;

public class EndGame {
	public static int secondendgametimer = 30;
	public static int minuteendgametimer = 2;
	public static String endgametimestamp = "";
	public static String endgametimestamplog = "";
	public static int endgamerepeatingtask;

	public static void init() {

		endgamerepeatingtask = Uhcmain.plugin.getServer().getScheduler()
				.scheduleSyncRepeatingTask(getInstance(), new Runnable() {
					
					Player player = Lobby.onlineplayers.iterator().next().getPlayer();
					
					public void run() {
						if (secondendgametimer >= 1) {
							if (secondendgametimer <= 9){
							endgametimestamp = minuteendgametimer + ":0" + secondendgametimer;
							endgametimestamplog = endgametimestamp;
							secondendgametimer--;
							}
							else {
								endgametimestamp = minuteendgametimer + ":" + secondendgametimer;
								endgametimestamplog = endgametimestamp;
								secondendgametimer--;
								}
							}
						
						if (secondendgametimer == 0) {
							endgametimestamp = minuteendgametimer + ":00";
							minuteendgametimer--;
							endgametimestamplog = endgametimestamp;
							secondendgametimer = 59;
						}
											
						if (minuteendgametimer == 0 && secondendgametimer == 0 || Lobby.onlineplayers.size() == 1) {
							
							Bukkit.broadcastMessage(Uhcmain.formatDefault + player.getName() + " has won the uhc.");
							
							MainSegments.segment++;
							MainSegments.paused = 0;

							Uhcmain.plugin.getServer().getScheduler()
									.cancelTask(endgamerepeatingtask);
						}

					}
				}, 0, 20L);
	}
}
