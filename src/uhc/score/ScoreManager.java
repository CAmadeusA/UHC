package uhc.score;

import static uhc.Uhcmain.getInstance;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import java.util.TimeZone;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import uhc.Uhcmain;
import uhc.segments.MainSegments;
import uhc.segments.segmentmethods.Immunity;
import uhc.segments.segmentmethods.LiveGame;
import uhc.segments.segmentmethods.Lobby;
import uhc.segments.segmentmethods.PreEndgame;
import uhc.segments.segmentmethods.Pregame;

public class ScoreManager {

	public static Uhcmain plugin;

	private static final Calendar cal = Calendar.getInstance(TimeZone
			.getTimeZone("America/Chicago"));

	static ScoreboardManager sbm = Bukkit.getScoreboardManager();
	public final static Scoreboard statusboard = sbm.getNewScoreboard();
	public final static Objective statusobj = statusboard.registerNewObjective(
			"Status", "dummy");

	public HashMap<String, Score> timescores = new HashMap<String, Score>();

	public static int scrmngr = 2;
	public static String timeString;
	public static String dateString;
	public static String timeStringLog;
	public static String dateStringLog;
	public static String onlineplayers;
	public static String sspectators;
	public static String onlineplayerslog;
	public static String spectatorslog;
	public static int hour;
	public static int minute;
	public static int second;
	public static int day;
	public static int month;
	public static int onpl = (Bukkit.getOnlinePlayers().size() - Lobby.spectators
			.size());
	public static int spctrs = (Lobby.spectators.size());

	public static void init() {

		cal.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
		ScoreboardManager sbm = Bukkit.getScoreboardManager();
		final Scoreboard statusboard = sbm.getNewScoreboard();
		final Objective statusobj = statusboard.registerNewObjective("Status",
				"dummy");
		statusobj.setDisplaySlot(DisplaySlot.SIDEBAR);
		statusobj.setDisplayName("MCGamer-UHC");

		for (Player p : Bukkit.getOnlinePlayers()) {
			p.setScoreboard(statusboard);
		}

		hour = cal.get(Calendar.HOUR_OF_DAY);

		minute = cal.get(Calendar.MINUTE);

		second = cal.get(Calendar.SECOND);

		if (hour == 0) {
			timeString = "12" + ": " + minute + ": " + second + " AM CST";
		} else if (hour < 12) {
			timeString = hour + ": " + minute + ": " + second + " AM CST";
		} else if (hour == 12) {
			timeString = hour + ": " + minute + ": " + second + " PM CST";
		} else {
			timeString = hour - 12 + ": " + minute + ": " + second + "PM CST";
		}

		day = cal.get(Calendar.DAY_OF_MONTH);

		month = cal.get(Calendar.MONTH);
		month++;

		Score timename = statusobj.getScore(ChatColor.GOLD + ""
				+ ChatColor.BOLD + "Time:");
		timename.setScore(20);

		Score time = statusobj.getScore(timeString);
		time.setScore(19);

		dateString = (day + "/" + month + "/" + "2015");

		Score datename = statusobj.getScore(ChatColor.GOLD + ""
				+ ChatColor.BOLD + "Day: ");
		datename.setScore(18);

		Score date = statusobj.getScore(dateString);
		date.setScore(17);

		timeStringLog = timeString;
		dateStringLog = dateString;

		onlineplayers = ChatColor.GOLD + "Playing: " + ChatColor.RESET + onpl;
		sspectators = ChatColor.GOLD + "Spectators: " + ChatColor.RESET
				+ Lobby.spectators.size();

		Score playersonl = statusobj.getScore(onlineplayers);
		playersonl.setScore(16);

		Score spectators = statusobj.getScore(sspectators);
		spectators.setScore(15);

		onlineplayerslog = onlineplayers;
		spectatorslog = sspectators;

		// insert more scoreboard stuff here later //
		scrmngr = 0;

		int statustask = Uhcmain.plugin.getServer().getScheduler()
				.scheduleSyncRepeatingTask(getInstance(), new Runnable() {
					public void run() {

						if (MainSegments.segment == 1) {
							statusobj.setDisplayName(ChatColor.BOLD + "Lobby "
									+ ChatColor.RESET + ChatColor.GOLD
									+ Lobby.lobbytimestamp);
						}
						if (MainSegments.segment == 2) {
							statusobj
									.setDisplayName(ChatColor.BOLD
											+ "Pre-Game " + ChatColor.RESET
											+ ChatColor.GOLD
											+ Pregame.pregametimestamp);
						}
						if (MainSegments.segment == 3) {
							statusobj.setDisplayName(ChatColor.BOLD
									+ "Immunity " + ChatColor.RESET
									+ ChatColor.GOLD
									+ Immunity.immunitytimestamp);
						}
						if (MainSegments.segment == 4) {
							statusobj.setDisplayName(ChatColor.BOLD
									+ "LiveGame " + ChatColor.RESET
									+ ChatColor.GOLD
									+ LiveGame.livegametimestamp);
						}
						if (MainSegments.segment == 5) {
							statusobj.setDisplayName(ChatColor.BOLD
									+ "PreEndGame " + ChatColor.RESET
									+ ChatColor.GOLD
									+ PreEndgame.preendgametimestamp);
						}

						cal.setTimeInMillis(System.currentTimeMillis());

						hour = cal.get(Calendar.HOUR_OF_DAY);

						minute = cal.get(Calendar.MINUTE);

						second = cal.get(Calendar.SECOND);

						if (hour == 0) {
							if (minute >= 10) {
								timeString = hour + ":" + minute + ":" + second
										+ " AM CST";
							}
							if (minute < 10) {
								timeString = hour + ":0" + minute + ":"
										+ second + "AM CST";
							}
						} else if (hour < 12) {
							if (minute >= 10) {
							timeString = hour + ":" + minute + ":" + second
									+ " AM CST";
							}
							if (minute < 10 ) {
								timeString = hour + ":0" + minute + ":" + second
										+ " AM CST";
							}
						} else if (hour == 12) {
							if (minute >= 10) {
								timeString = hour + ":" + minute + ":" + second
									+ " PM CST";
							}
							if (minute < 10) {
								timeString = hour + ":0" + minute + ":" + second
										+ " PM CST";
							}
						} else {
							if (minute >= 10) {
								timeString = hour - 12 + ":" + minute + ":" + second
									+ " PM CST";
							}
							if (minute < 10) {
								timeString = hour - 12 + ":0" + minute + ":" + second
										+ " PM CST";
							}
						}

						onpl = (Bukkit.getOnlinePlayers().size() - Lobby.spectators
								.size());
						spctrs = (Lobby.spectators.size());

						onlineplayers = ChatColor.GOLD + "Playing: "
								+ ChatColor.RESET + onpl;
						sspectators = ChatColor.GOLD + "Spectators: "
								+ ChatColor.RESET + spctrs;

						statusboard.resetScores(timeStringLog);
						Score time = statusobj.getScore(timeString);
						time.setScore(19);
						timeStringLog = timeString;

						day = cal.get(Calendar.DAY_OF_MONTH);
						month = cal.get(Calendar.MONTH);
						month++;

						statusboard.resetScores(dateStringLog);
						Score date = statusobj.getScore(dateString);
						date.setScore(17);
						dateStringLog = dateString;

						statusboard.resetScores(onlineplayerslog);
						Score playersonl = statusobj.getScore(onlineplayers);
						playersonl.setScore(16);
						onlineplayerslog = onlineplayers;

						statusboard.resetScores(spectatorslog);
						Score spectators = statusobj.getScore(sspectators);
						spectators.setScore(15);
						spectatorslog = sspectators;

						for (Player p : Bukkit.getOnlinePlayers()) {
							p.setScoreboard(statusboard);

						}

					}

				}, 0, 20);

	}

}
