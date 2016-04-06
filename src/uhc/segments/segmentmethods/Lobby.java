package uhc.segments.segmentmethods;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Score;

import static uhc.Uhcmain.getInstance;
import uhc.Uhcmain;
import uhc.events.TeamSetup;
import uhc.inventory.JoinTeam;
import uhc.score.ScoreManager;
import uhc.segments.MainSegments;

public class Lobby implements Listener {
	public static int secondlobbytimer = 59;
	public static int minutelobbytimer = 2;
	public static String lobbytimestamp = "";
	public static String lobbytimestamplog = "";
	public static int lobbyrepeatingtask;
	public static ArrayList<Player> onlineplayers = new ArrayList<Player>();
	public static ArrayList<Player> spectators = new ArrayList<Player>();

	public static void init() {

		Bukkit.broadcastMessage("Lobby Starting");

		if (secondlobbytimer >= 1) {
			if (secondlobbytimer <= 9){
			lobbytimestamp = minutelobbytimer + ":0" + secondlobbytimer;
			lobbytimestamplog = lobbytimestamp;
			secondlobbytimer--;
			}
			else {
				lobbytimestamp = minutelobbytimer + ":" + secondlobbytimer;
				lobbytimestamplog = lobbytimestamp;
				secondlobbytimer--;
				}
			}
		
		if (secondlobbytimer == 0) {
			lobbytimestamp = minutelobbytimer + ":00";
			minutelobbytimer--;
			lobbytimestamplog = lobbytimestamp;
			secondlobbytimer = 59;
		}

		for (Player p : Bukkit.getOnlinePlayers()) {
			p.setScoreboard(ScoreManager.statusboard);
		}

		Lobby.lobbytimestamplog = Lobby.lobbytimestamp;

		JoinTeam.GivePlayersVotingItem();


		lobbyrepeatingtask = Uhcmain.plugin.getServer().getScheduler()
				.scheduleSyncRepeatingTask(getInstance(), new Runnable() {
					public void run() {

						JoinTeam.GivePlayersVotingItem();
						
						if (secondlobbytimer >= 1) {
							if (secondlobbytimer <= 9){
							lobbytimestamp = minutelobbytimer + ":0" + secondlobbytimer;
							lobbytimestamplog = lobbytimestamp;
							secondlobbytimer--;
							}
							else {
								lobbytimestamp = minutelobbytimer + ":" + secondlobbytimer;
								lobbytimestamplog = lobbytimestamp;
								secondlobbytimer--;
								}
							}
						
						if (secondlobbytimer == 0 && minutelobbytimer > 0) {
							lobbytimestamp = minutelobbytimer + ":00";
							secondlobbytimer = 59;
							minutelobbytimer--;
							lobbytimestamplog = lobbytimestamp;
							
						}
						

						if (minutelobbytimer == 0 && secondlobbytimer == 0) {
							if (Bukkit.getOnlinePlayers().size() <= 0) {
								Bukkit.broadcastMessage(Uhcmain.formatDefault
										+ "Not enough players. Restarting Lobby.");
								secondlobbytimer = 59;
								minutelobbytimer = 2;
							}
							if (Bukkit.getOnlinePlayers().size() > 0) {
								MainSegments.segment++;
								MainSegments.paused = 0;

								Uhcmain.plugin.getServer().getScheduler()
										.cancelTask(lobbyrepeatingtask);

								for (Player player : Bukkit.getOnlinePlayers()) {
									player.getInventory().clear();
								}

								Random random = new Random();

								Location teleportLocation = null;
								Location wotTeleportLocation = null;

								ArrayList<Player> opwoteam = TeamSetup.opwoteam;
								ArrayList<Player> log = TeamSetup.log;
								ArrayList<Player> plank = TeamSetup.plank;
								ArrayList<Player> stone = TeamSetup.stone;
								ArrayList<Player> cobble = TeamSetup.cobble;
								ArrayList<Player> coalore = TeamSetup.coalore;
								ArrayList<Player> coal = TeamSetup.coal;
								ArrayList<Player> ironore = TeamSetup.ironore;
								ArrayList<Player> iron = TeamSetup.iron;
								ArrayList<Player> goldore = TeamSetup.goldore;
								ArrayList<Player> gold = TeamSetup.gold;
								ArrayList<Player> diamondore = TeamSetup.diamondore;
								ArrayList<Player> diamond = TeamSetup.diamond;
								ArrayList<Player> emeraldore = TeamSetup.emeraldore;
								ArrayList<Player> emerald = TeamSetup.emerald;
								ArrayList<Player> netherstar = TeamSetup.netherstar;
								ArrayList<Player> obsidean = TeamSetup.obsidian;
								ArrayList<Player> cake = TeamSetup.cake;
								ArrayList<Player> glass = TeamSetup.glass;
								ArrayList<Player> lapisblock = TeamSetup.lapisblock;
								ArrayList<Player> redstoneblock = TeamSetup.redstoneblock;
								

								Bukkit.getServer().createWorld(
										new WorldCreator("survivalworld"));
								World world = Bukkit.getServer().createWorld(
										new WorldCreator("survivalworld"));
								world.setBiome(0, 0, Biome.PLAINS);
								world.setDifficulty(Difficulty.HARD);
								
								
								world.setAutoSave(false);
								

								for (Player player : Bukkit.getOnlinePlayers()) {
									player.addPotionEffect(new PotionEffect(
											PotionEffectType.DAMAGE_RESISTANCE,
											1200, 600));
								}

								for (Player player : opwoteam) {
									int rxwo = random.nextInt(2000) + 1 - 1000;
									int rzwo = random.nextInt(2000) + 1 - 1000;
									int rywo = world.getHighestBlockYAt(rxwo,
											rzwo) + 5;

									wotTeleportLocation = (new Location(world,
											rxwo, rywo, rzwo));
									
									wotTeleportLocation.getChunk().load();
									
									player.teleport(wotTeleportLocation);
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));

									for (Player player : log) {
										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : plank) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : stone) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : cobble) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : coalore) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : coal) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : ironore) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : iron) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : goldore) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : gold) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : diamondore) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : diamond) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : emeraldore) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : emerald) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : netherstar) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : obsidean) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : cake) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : glass) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : lapisblock) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}
								{
									int rx = random.nextInt(2000) + 1 - 1000;
									int rz = random.nextInt(2000) + 1 - 1000;
									int ry = world.getHighestBlockYAt(rx, rz);

									teleportLocation = (new Location(world, rx,
											ry, rz));
									for (Player player : redstoneblock) {

										
										teleportLocation.getChunk().load();
										
										player.teleport(teleportLocation);
									}
								}

							}
						}

					}
				}, 0, 20);

	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();
		if (inventory.getName().equals("Select Your Team!")) {
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
					|| clicked.getType() == Material.LAPIS_BLOCK) {
				event.setCancelled(true);
				player.updateInventory();
			} else {
				event.setCancelled(true);
				player.updateInventory();
			}
		}
		if (inventory.equals(player.getInventory())) {
			event.setCancelled(true);
			player.updateInventory();
		}

	}

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();

		ItemStack chooseteam = new ItemStack(Material.SLIME_BALL);
		ItemMeta chooseteamname = chooseteam.getItemMeta();
		chooseteamname.setDisplayName(Uhcmain.formatDefault
				+ "Choose Your Team!");
		chooseteam.setItemMeta(chooseteamname);

		if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event
				.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (player.getItemInHand().getType() == Material.SLIME_BALL)
				&& (player.getItemInHand().equals(chooseteam))) {
			JoinTeam.InventoryCreate();
			player.openInventory(JoinTeam.teamselection);

		}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		if (MainSegments.segment == 1) {

			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		if (MainSegments.segment == 1) {

			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent event) {
		if (MainSegments.segment == 1) {

			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onVehicleDamageEvent(VehicleDamageEvent event) {
		if (MainSegments.segment == 1) {
			Entity damager = event.getAttacker();
			if (damager instanceof Player) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if (MainSegments.segment == 1) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onVehicleEntityCollsionEvent(VehicleEntityCollisionEvent event) {
		if (MainSegments.segment == 1) {

			Entity collider = event.getEntity();
			if (collider instanceof Player) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onVehicleEnterEvent(VehicleEnterEvent event) {
		if (MainSegments.segment == 1) {
			Entity enterer = event.getEntered();
			if (enterer instanceof Player) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onPlayerBedEnterEvent(PlayerBedEnterEvent event) {
		if (MainSegments.segment == 1) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onEntityInteractEvent(EntityInteractEvent event) {
		if (MainSegments.segment == 1) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onInteract1(PlayerInteractEvent event) {
		if (MainSegments.segment == 1) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onTakeDamage(EntityDamageEvent event) {

		if (MainSegments.segment == 1) {
			event.setCancelled(true);

			Entity player = event.getEntity();
			if (player instanceof Player) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onSaturationChange(FoodLevelChangeEvent event) {
		HumanEntity player = event.getEntity();
		if (player instanceof Player) {
			if (MainSegments.segment == 1) {
				event.setCancelled(true);
			}
		}
	}
}