package uhc.events;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import uhc.Uhcmain;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.Packets;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketListener;

public class UHCHearts extends PacketAdapter {

	ProtocolManager protocolManager = Uhcmain.protocolManager;

	PacketContainer uhcheart = new PacketContainer(PacketType.Play.Server.LOGIN);


		/**
		 * listens for login packets to edit
		 *
		 * @param bukkitPlugin
		 *            the plugin
		 */
		UHCHearts(Plugin bukkitPlugin) {
			// listen for login packets on the normal priority
			super(bukkitPlugin, ListenerPriority.NORMAL,
					PacketType.Play.Server.LOGIN);
		}

		@Override
		public void onPacketSending(PacketEvent event) {
			// if its a login packet write the first boolean to true (hardcore
			// flag)
			if (event.getPacketType().equals(PacketType.Play.Server.LOGIN)) {
				event.getPacket().getBooleans().write(0, true);
			}
		
	}
}
