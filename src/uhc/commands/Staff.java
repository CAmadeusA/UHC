package uhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import uhc.Uhcmain;
import uhc.segments.MainSegments;
import uhc.segments.segmentmethods.EndGame;
import uhc.segments.segmentmethods.Immunity;
import uhc.segments.segmentmethods.LiveGame;
import uhc.segments.segmentmethods.Lobby;
import uhc.segments.segmentmethods.PreEndgame;
import uhc.segments.segmentmethods.Pregame;

public class Staff implements CommandExecutor {
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		 Player player = (Player) sender;
		 
		
		 if (player.isOp()) {
			 if (cmd.getName().equalsIgnoreCase("NextSegment")) {
				 if (MainSegments.segment == 1) {
					 Lobby.minutelobbytimer = 0;
					 Lobby.secondlobbytimer = 0;
					 
				 }
				 if (MainSegments.segment == 2) {
					 Pregame.pregametimer = 0;
					 
				 }
				 if (MainSegments.segment == 3) {
					 Immunity.immunitytimer = 0;
					 
				 }
				 if (MainSegments.segment == 4) {
					 LiveGame.minutelivegametimer = 0;
					 LiveGame.secondlivegametimer = 11;
					 
					 
				 }
				 if (MainSegments.segment == 5) {
					 PreEndgame.preendgametimer = 0;
					 
				 }
				 if (MainSegments.segment == 6) {
					EndGame.minuteendgametimer = 0;
					EndGame.secondendgametimer = 0;
					 
				 }
				 if (MainSegments.segment == 7) {
					 
					 player.sendMessage(Uhcmain.formatDefault + "You cannot cancel cleanup.");
					 
				 }
			 }
			 
			 if (cmd.getName().equalsIgnoreCase("ForceCleanup")) {
				 MainSegments.segment = 7;
				 player.sendMessage(Uhcmain.formatDefault +  "You forced cleanup.");
			 }
		 }
		 
		 return false;
		 
	 }
}
