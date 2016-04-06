package uhc.segments.segmentmethods;

import static uhc.Uhcmain.getInstance;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import uhc.Uhcmain;
import uhc.score.ScoreManager;
import uhc.segments.MainSegments;

public class LiveGame implements Listener {
	public static int secondlivegametimer = 59;
	public static int minutelivegametimer = 44;
	public static String livegametimestamp = "";
	public static String livegametimestamplog = "";
	public static int livegamerepeatingtask;
	
	public static void init() {
		
		LiveGame.livegametimestamplog = LiveGame.livegametimestamp;

		

		livegamerepeatingtask = Uhcmain.plugin.getServer().getScheduler()
				.scheduleSyncRepeatingTask(getInstance(), new Runnable() {
					public void run() {

						if (secondlivegametimer >= 1) {
							if (secondlivegametimer <= 9){
							livegametimestamp = minutelivegametimer + ":0" + secondlivegametimer;
							livegametimestamplog = livegametimestamp;
							secondlivegametimer--;
							}
							else {
								livegametimestamp = minutelivegametimer + ":" + secondlivegametimer;
								livegametimestamplog = livegametimestamp;
								secondlivegametimer--;
								}
							}
						
						if (secondlivegametimer == 0) {
							livegametimestamp = minutelivegametimer + ":00";
							minutelivegametimer--;
							livegametimestamplog = livegametimestamp;
							secondlivegametimer = 59;
						}
											
						if (minutelivegametimer == 0 && secondlivegametimer == 10) {

						MainSegments.segment++;
						MainSegments.paused = 0;

						Uhcmain.plugin.getServer().getScheduler()
								.cancelTask(livegamerepeatingtask);
						
						
						}
						if (Lobby.onlineplayers.size() < 10 && minutelivegametimer > 15) { 
							secondlivegametimer = 59;
							minutelivegametimer = 14;
							Bukkit.broadcastMessage(Uhcmain.formatDefault + "There are less than 10 Players left.");
							Bukkit.broadcastMessage(Uhcmain.formatDefault + "The time has been reduced to 15 minutes until the deathmatch.");
							for (Player player : Bukkit.getOnlinePlayers()) {
								player.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 1L, 1L);
							}
						
						}
						if (Lobby.onlineplayers.size() == 3) {

							MainSegments.segment++;
							MainSegments.paused = 0;

							Uhcmain.plugin.getServer().getScheduler()
									.cancelTask(livegamerepeatingtask);
						}
					}
				}, 0, 20L);

	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (player instanceof Player) {
			if (Lobby.onlineplayers.contains(player)) {
				Lobby.onlineplayers.remove(player);
			}
			if (!(Lobby.spectators.contains(player))) {
				Lobby.spectators.add(player);
			}
		}
	}
	
}
