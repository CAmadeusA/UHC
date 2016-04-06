package uhc.segments.segmentmethods;

import static uhc.Uhcmain.getInstance;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import uhc.Uhcmain;
import uhc.score.ScoreManager;
import uhc.segments.MainSegments;

public class Immunity {
	
	public static int immunitytimer = 30;
	public static String immunitytimestamp = "";
	public static String immunitytimestamplog = "";
	public static int immunityrepeatingtask;
	
	public static void init() {
		
		if (immunitytimer >= 1) {

			if (immunitytimer < 60) {
				int immunitytimer0 = (immunitytimer);
				if (immunitytimer0 >= 10) {
					Immunity.immunitytimestamp = "00:"
							+ (immunitytimer);
				} else if (immunitytimer0 <= 9) {
					Immunity.immunitytimestamp = "00:0"
							+ (immunitytimer);
				}
			}
			immunitytimer--;
		}

				
		
		for (Player p : Bukkit.getOnlinePlayers()) {			
			p.setScoreboard(ScoreManager.statusboard);
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,600,10));
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 600));
		}

		Immunity.immunitytimestamplog = Immunity.immunitytimestamp;

		immunitytimer--;
		
	
		

		immunityrepeatingtask = Uhcmain.plugin.getServer().getScheduler()
				.scheduleSyncRepeatingTask(getInstance(), new Runnable() {
					public void run() {

						if (immunitytimer >= 1) {

							if (immunitytimer < 60) {
								int immunitytimer0 = (immunitytimer);
								if (immunitytimer0 >= 10) {
									Immunity.immunitytimestamp = "00:"
											+ (immunitytimer);
								} else if (immunitytimer0 <= 9) {
									Immunity.immunitytimestamp = "00:0"
											+ (immunitytimer);
								}
							}
							immunitytimer--;
						}

						
						if (immunitytimer == 0) {
						immunitytimer--;

						MainSegments.segment++;
						MainSegments.paused = 0;

						Uhcmain.plugin.getServer().getScheduler()
								.cancelTask(immunityrepeatingtask);
												
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.removePotionEffect(PotionEffectType.ABSORPTION);
							p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						}
						
						}
					}
				}, 0, 20);

	}
}
