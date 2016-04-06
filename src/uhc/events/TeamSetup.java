package uhc.events;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import uhc.Uhcmain;
import uhc.segments.MainSegments;

public class TeamSetup implements Listener {

	public static ArrayList<Player> log = new ArrayList<Player>();
	public static ArrayList<Player> plank = new ArrayList<Player>();
	public static ArrayList<Player> stone = new ArrayList<Player>();
	public static ArrayList<Player> cobble = new ArrayList<Player>();
	public static ArrayList<Player> coalore = new ArrayList<Player>();
	public static ArrayList<Player> coal = new ArrayList<Player>();
	public static ArrayList<Player> ironore = new ArrayList<Player>();
	public static ArrayList<Player> iron = new ArrayList<Player>();
	public static ArrayList<Player> goldore = new ArrayList<Player>();
	public static ArrayList<Player> gold = new ArrayList<Player>();
	public static ArrayList<Player> diamondore = new ArrayList<Player>();
	public static ArrayList<Player> diamond = new ArrayList<Player>();
	public static ArrayList<Player> emeraldore = new ArrayList<Player>();
	public static ArrayList<Player> emerald = new ArrayList<Player>();
	public static ArrayList<Player> netherstar = new ArrayList<Player>();
	public static ArrayList<Player> obsidian = new ArrayList<Player>();
	public static ArrayList<Player> cake = new ArrayList<Player>();
	public static ArrayList<Player> glass = new ArrayList<Player>();
	public static ArrayList<Player> lapisblock = new ArrayList<Player>();
	public static ArrayList<Player> redstoneblock = new ArrayList<Player>();

	public static ArrayList<Player> opwoteam = MainSegments.opwoteam;

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();
		if (inventory.getName().equals("Select Your Team!")) {

			if (clicked.getType() == Material.MAGMA_CREAM) {
				if (log.contains(player)) {
					log.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (plank.contains(player)) {
					plank.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");

				}
				if (stone.contains(player)) {
					stone.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");

				}
				if (cobble.contains(player)) {
					cobble.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (coalore.contains(player)) {
					coalore.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (coal.contains(player)) {
					coal.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (ironore.contains(player)) {
					ironore.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (iron.contains(player)) {
					iron.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (goldore.contains(player)) {
					goldore.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (gold.contains(player)) {
					gold.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (diamondore.contains(player)) {
					diamondore.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (diamond.contains(player)) {
					diamond.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (emeraldore.contains(player)) {
					emeraldore.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (emerald.contains(player)) {
					emerald.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (netherstar.contains(player)) {
					netherstar.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (obsidian.contains(player)) {
					obsidian.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (cake.contains(player)) {
					cake.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (glass.contains(player)) {
					glass.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (lapisblock.contains(player)) {
					lapisblock.remove(player);
					player.sendMessage(Uhcmain.formatDefault
							+ "You left the team.");
				}
				if (redstoneblock.contains(player)) {
					redstoneblock.remove(player);
					player.sendMessage(Uhcmain.formatDefault + "You left the team.");
				}

			}
			if (clicked.getType() == Material.LOG
					|| clicked.getType() == Material.WOOD
					|| clicked.getType() == Material.STONE
					|| clicked.getType() == Material.COBBLESTONE
					|| clicked.getType() == Material.COAL_ORE
					|| clicked.getType() == Material.COAL
					|| clicked.getType() == Material.IRON_ORE
					|| clicked.getType() == Material.IRON_INGOT
					|| clicked.getType() == Material.GOLD_ORE
					|| clicked.getType() == Material.GOLD_INGOT
					|| clicked.getType() == Material.DIAMOND_ORE
					|| clicked.getType() == Material.DIAMOND
					|| clicked.getType() == Material.EMERALD_ORE
					|| clicked.getType() == Material.EMERALD
					|| clicked.getType() == Material.NETHER_STAR
					|| clicked.getType() == Material.OBSIDIAN
					|| clicked.getType() == Material.CAKE
					|| clicked.getType() == Material.GLASS
					|| clicked.getType() == Material.LAPIS_BLOCK
					|| clicked.getType() == Material.REDSTONE_BLOCK) {

				if (log.contains(player) || plank.contains(player)
						|| cobble.contains(player) || coalore.contains(player)
						|| coal.contains(player) || ironore.contains(player)
						|| iron.contains(player) || goldore.contains(player)
						|| gold.contains(player) || diamondore.contains(player)
						|| diamond.contains(player)
						|| emeraldore.contains(player)
						|| emerald.contains(player)
						|| netherstar.contains(player)
						|| obsidian.contains(player) || cake.contains(player)
						|| glass.contains(player)
						|| lapisblock.contains(player)
						|| redstoneblock.contains(player)) {
					player.sendMessage(Uhcmain.formatDefault
							+ "You are already on a team, please leave a team before attempting to join another.");
				}

				else if (!((log.contains(player) || plank.contains(player)
						|| cobble.contains(player) || coalore.contains(player)
						|| coal.contains(player) || ironore.contains(player)
						|| iron.contains(player) || goldore.contains(player)
						|| gold.contains(player) || diamondore.contains(player)
						|| diamond.contains(player)
						|| emeraldore.contains(player)
						|| emerald.contains(player)
						|| netherstar.contains(player)
						|| obsidian.contains(player) || cake.contains(player)
						|| glass.contains(player) || lapisblock
							.contains(player) || redstoneblock.contains(player)))) {

					if (clicked.getType() == Material.LOG) {
						if (log.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (log.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Wood log team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Wood Log Team. Rejoin if needed.");
								log.clear();
							}
							if (log.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (log.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Wood Log team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ log.get(0).getName());
								log.add(player);
								opwoteam.remove(player);
							}
							if (log.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Wood Log team.");
								log.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.WOOD) {
						if (plank.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (plank.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Wood Plank team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Plank Team. Rejoin if needed.");
								plank.clear();
							}
							if (plank.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (plank.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Wood Plank team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ plank.get(0).getName());
								plank.add(player);
								opwoteam.remove(player);
							}
							if (plank.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Wood Plank team.");
								plank.add(player);
								opwoteam.remove(player);

							}

						}
					}
					if (clicked.getType() == Material.STONE) {
						if (stone.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (stone.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Stone team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Stone Team. Rejoin if needed.");
								stone.clear();
							}
							if (stone.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (stone.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Stone team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ stone.get(0).getName());
								stone.add(player);
								opwoteam.remove(player);

							}
							if (stone.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Stone team.");
								stone.add(player);
								opwoteam.remove(player);

							}

						}
					}
					if (clicked.getType() == Material.COBBLESTONE) {
						if (cobble.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (cobble.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Cobblestone team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Cobblestone Team. Rejoin if needed.");
								cobble.clear();
							}
							if (cobble.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (cobble.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Cobblestone team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ cobble.get(0).getName());
								cobble.add(player);
								opwoteam.remove(player);

							}
							if (cobble.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Cobblestone team.");
								cobble.add(player);
								opwoteam.remove(player);

							}

						}
					}
					if (clicked.getType() == Material.COAL_ORE) {
						if (coalore.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (coalore.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Coal-Ore team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Coal-Ore Team. Rejoin if needed.");
								coalore.clear();
							}
							if (coalore.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (coalore.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Coal-Ore team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ coalore.get(0).getName());
								coalore.add(player);
								opwoteam.remove(player);
							}
							if (coalore.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Coal-Ore team.");
								coalore.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.COAL) {
						if (coal.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (coal.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Coal team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Coal Team. Rejoin if needed.");
								coal.clear();
							}
							if (coal.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (coal.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Coal team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ coal.get(0).getName());
								coal.add(player);
								opwoteam.remove(player);
							}
							if (coal.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Coal team.");
								coal.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.IRON_ORE) {
						if (ironore.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (ironore.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Iron-Ore team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Iron-Ore Team. Rejoin if needed.");
								ironore.clear();
							}
							if (ironore.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (ironore.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Iron-Ore team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ ironore.get(0).getName());
								ironore.add(player);
								opwoteam.remove(player);
							}
							if (ironore.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Iron-Ore team.");
								ironore.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.IRON_INGOT) {
						if (iron.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (iron.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Iron team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Iron Team. Rejoin if needed.");
								iron.clear();
							}
							if (iron.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (iron.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Iron team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ iron.get(0).getName());
								iron.add(player);
								opwoteam.remove(player);
							}
							if (iron.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Iron team.");
								iron.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.GOLD_ORE) {
						if (goldore.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (goldore.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Gold-Ore team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Gold-Ore Team. Rejoin if needed.");
								goldore.clear();
							}
							if (goldore.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (goldore.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Gold-Ore team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ goldore.get(0).getName());
								goldore.add(player);
								opwoteam.remove(player);
							}
							if (goldore.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Gold-Ore team.");
								goldore.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.GOLD_INGOT) {
						if (gold.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (gold.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Gold team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Gold Team. Rejoin if needed.");
								gold.clear();
							}
							if (gold.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (gold.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Gold team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ gold.get(0).getName());
								gold.add(player);
								opwoteam.remove(player);
							}
							if (gold.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Gold team.");
								gold.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.DIAMOND_ORE) {
						if (diamondore.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (diamondore.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Diamond-Ore team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Diamond-Ore Team. Rejoin if needed.");
								diamondore.clear();
							}
							if (diamondore.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (diamondore.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Diamond-Ore team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ diamondore.get(0).getName());
								diamondore.add(player);
								opwoteam.remove(player);
							}
							if (diamondore.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Diamond-Ore team.");
								diamondore.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.DIAMOND) {
						if (diamond.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (diamond.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Diamond team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Diamond Team. Rejoin if needed.");
								diamond.clear();
							}
							if (diamond.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (diamond.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the diamond team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ diamond.get(0).getName());
								diamond.add(player);
								opwoteam.remove(player);
							}
							if (diamond.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the diamond team.");
								diamond.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.EMERALD_ORE) {
						if (emeraldore.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (emeraldore.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Emerald-Ore team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Emerald-Ore Team. Rejoin if needed.");
								emeraldore.clear();
							}
							if (emeraldore.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (emeraldore.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Wood Log team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ emeraldore.get(0).getName());
								emeraldore.add(player);
								opwoteam.remove(player);
							}
							if (emeraldore.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Wood Log team.");
								emeraldore.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.EMERALD) {
						if (emerald.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (emerald.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Emerald team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Emerald Team. Rejoin if needed.");
								emerald.clear();
							}
							if (emerald.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (emerald.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Emerald team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ emerald.get(0).getName());
								emerald.add(player);
								opwoteam.remove(player);
							}
							if (emerald.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Emerald team.");
								emerald.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.NETHER_STAR) {
						if (netherstar.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (netherstar.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Nether-Star team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Nether-Star Team. Rejoin if needed.");
								netherstar.clear();
							}
							if (netherstar.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (netherstar.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Nether-Star team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ netherstar.get(0).getName());
								netherstar.add(player);
								opwoteam.remove(player);
							}
							if (netherstar.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Nether-Star team.");
								netherstar.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.OBSIDIAN) {
						if (obsidian.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (obsidian.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Obsidian team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Obsidian Team. Rejoin if needed.");
								obsidian.clear();
							}
							if (obsidian.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (obsidian.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Obsidian team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ obsidian.get(0).getName());
								obsidian.add(player);
								opwoteam.remove(player);
							}
							if (obsidian.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Obsidian team.");
								obsidian.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.CAKE) {
						if (cake.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (cake.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Cake team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Cake Team. Rejoin if needed.");
								cake.clear();
							}
							if (cake.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (cake.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Cake team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ cake.get(0).getName());
								cake.add(player);
								opwoteam.remove(player);
							}
							if (cake.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Cake team.");
								cake.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.GLASS) {
						if (glass.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (glass.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Glass team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Glass Team. Rejoin if needed.");
								glass.clear();
							}
							if (glass.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (glass.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Glass team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ glass.get(0).getName());
								glass.add(player);
								opwoteam.remove(player);
							}
							if (glass.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Glass  team.");
								glass.add(player);
								opwoteam.remove(player);
							}

						}
					}
					if (clicked.getType() == Material.LAPIS_BLOCK) {
						if (lapisblock.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (lapisblock.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Lapis Block team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Lapis Block Team. Rejoin if needed.");
								lapisblock.clear();
							}
							if (lapisblock.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (lapisblock.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Lapis Block team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ lapisblock.get(0).getName());
								lapisblock.add(player);
								opwoteam.remove(player);
							}
							if (lapisblock.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Lapis Block team.");
								lapisblock.add(player);
								opwoteam.remove(player);
							}
						}
					}
					if (clicked.getType() == Material.REDSTONE_BLOCK) {
						if (redstoneblock.contains(player)) {
							player.sendMessage(Uhcmain.formatDefault
									+ "You are already on this team.");
						} else {
							if (redstoneblock.size() > 2) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Redstone Block team is broken.");
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ ChatColor.RED
										+ "Reseting Redstone Block Team. Rejoin if needed.");
								redstoneblock.clear();
							}
							if (redstoneblock.size() == 2) {
								player.sendMessage(Uhcmain.formatDefault
										+ "This team is full. Please join another.");
							}
							if (redstoneblock.size() == 1) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You've joined the Redstone Block team.");
								player.sendMessage(Uhcmain.formatDefault
										+ "Your other teammate is "
										+ redstoneblock.get(0).getName());
								redstoneblock.add(player);
								opwoteam.remove(player);
							}
							if (redstoneblock.isEmpty()) {
								player.sendMessage(Uhcmain.formatDefault
										+ "You are the first one the Redstone Block team.");
								redstoneblock.add(player);
								opwoteam.remove(player);
							}
						}
					}
				}

				player.updateInventory();
			} else {

				player.updateInventory();
			}
		}

	}

}
