package uhc.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import uhc.Uhcmain;
import uhc.segments.MainSegments;

public class JoinTeam implements Listener {

	public static Inventory teamselection = Bukkit.createInventory(null, 36, "Select Your Team!");
	
	public static void InventoryCreate() {
	
		if (MainSegments.segment == 1) {
			
			ItemStack chooseteam = new ItemStack(Material.SLIME_BALL);
		    ItemMeta chooseteamname = chooseteam.getItemMeta();
		    chooseteamname.setDisplayName(Uhcmain.formatDefault + "Choose Your Team!");
		    chooseteam.setItemMeta(chooseteamname);
		    

		    ItemStack woodlog = new ItemStack(Material.LOG);
		    ItemMeta woodlogname = woodlog.getItemMeta();
		    woodlogname.setDisplayName("Wood-Log Team!");
		    woodlog.setItemMeta(woodlogname);
		    teamselection.setItem(1, woodlog);
			
		    ItemStack woodplank = new ItemStack(Material.WOOD);
		    ItemMeta woodplankname = woodplank.getItemMeta();
		    woodplankname.setDisplayName("Wood-Plank Team!");
		    woodplank.setItemMeta(woodplankname);
		    teamselection.setItem(2, woodplank);
			
		    ItemStack stone = new ItemStack(Material.STONE);
		    ItemMeta stonename = stone.getItemMeta();
		    stonename.setDisplayName("Stone Team!");
		    stone.setItemMeta(stonename);
		    teamselection.setItem(3, stone);
			
		    ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);
		    ItemMeta cobblestonename = cobblestone.getItemMeta();
		    cobblestonename.setDisplayName("Cobblestone Team!");
		    cobblestone.setItemMeta(cobblestonename);
			teamselection.setItem(4, cobblestone);
		    
		    ItemStack coalore = new ItemStack(Material.COAL_ORE);
		    ItemMeta coalorename = coalore.getItemMeta();
		    coalorename.setDisplayName("Coal-Ore Team!");
		    coalore.setItemMeta(coalorename);
		    teamselection.setItem(5, coalore);
			
		    ItemStack coal = new ItemStack(Material.COAL);
		    ItemMeta coalname = coal.getItemMeta();
		    coalname.setDisplayName("Coal Team!");
		    coal.setItemMeta(coalname);
		    teamselection.setItem(6, coal);
			
		    ItemStack ironore = new ItemStack(Material.IRON_ORE);
		    ItemMeta ironorename = ironore.getItemMeta();
		    ironorename.setDisplayName("Iron-Ore Team!");
		    ironore.setItemMeta(ironorename);
		    teamselection.setItem(7, ironore);
			
		    ItemStack iron = new ItemStack(Material.IRON_INGOT);
		    ItemMeta ironname = iron.getItemMeta();
		    ironname.setDisplayName("Iron Team!");
		    iron.setItemMeta(ironname);
		    teamselection.setItem(10, iron);
			
		    ItemStack goldore = new ItemStack(Material.GOLD_ORE);
		    ItemMeta goldorename = goldore.getItemMeta();
		    goldorename.setDisplayName("Gold-Ore Team!");
		    goldore.setItemMeta(goldorename);
		    teamselection.setItem(11, goldore);
			
		    ItemStack gold = new ItemStack(Material.GOLD_INGOT);
		    ItemMeta goldname = gold.getItemMeta();
		    goldname.setDisplayName("Gold Team!");
		    gold.setItemMeta(goldname);
		    teamselection.setItem(12, gold);
			
		    ItemStack diamondore = new ItemStack(Material.DIAMOND_ORE);
		    ItemMeta diamondorename = diamondore.getItemMeta();
		    diamondorename.setDisplayName("Diamond-Ore Team!");
		    diamondore.setItemMeta(diamondorename);
		    teamselection.setItem(13, diamondore);
			
		    ItemStack diamond = new ItemStack(Material.DIAMOND);
		    ItemMeta diamondname = diamond.getItemMeta();
		    diamondname.setDisplayName("Diamond Team!");
		    diamond.setItemMeta(diamondname);
		    teamselection.setItem(14, diamond);
			
		    ItemStack emeraldore = new ItemStack(Material.EMERALD_ORE);
		    ItemMeta emeraldorename = emeraldore.getItemMeta();
		    emeraldorename.setDisplayName("Emerald-Ore Team");
		    emeraldore.setItemMeta(emeraldorename);
		    teamselection.setItem(15, emeraldore);
			
		    ItemStack emerald = new ItemStack(Material.EMERALD);
		    ItemMeta emeraldname = emerald.getItemMeta();
		    emeraldname.setDisplayName("Emerald Team!");
		    emerald.setItemMeta(emeraldname);
		    teamselection.setItem(16, emerald);
			
		    ItemStack netherstar = new ItemStack(Material.NETHER_STAR);
		    ItemMeta netherstarname = netherstar.getItemMeta();
		    netherstarname.setDisplayName("Nether-Star Team!");
		    netherstar.setItemMeta(netherstarname);
		    teamselection.setItem(20, netherstar);
			
		    ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
		    ItemMeta obsidianname = obsidian.getItemMeta();
		    obsidianname.setDisplayName("Obsidian Team");
		    obsidian.setItemMeta(obsidianname);
		    teamselection.setItem(21, obsidian);
			
		    ItemStack cake = new ItemStack(Material.CAKE);
		    ItemMeta cakename = cake.getItemMeta();
		    cakename.setDisplayName("Cake Team!");
		    cake.setItemMeta(cakename);
		    teamselection.setItem(22, cake);
			
		    ItemStack glass = new ItemStack(Material.GLASS);
		    ItemMeta glassname = glass.getItemMeta();
		    glassname.setDisplayName("Glass Team!");
		    glass.setItemMeta(glassname);
		    teamselection.setItem(23, glass);
			
		    ItemStack lapis = new ItemStack(Material.LAPIS_BLOCK);
		    ItemMeta lapisname = lapis.getItemMeta();
		    lapisname.setDisplayName("Lapis-Lazuli Block Team!");
		    lapis.setItemMeta(lapisname);
		    teamselection.setItem(24, lapis);
		    
		    ItemStack redstoneblock = new ItemStack(Material.REDSTONE_BLOCK);
		    ItemMeta redstoneblockname = redstoneblock.getItemMeta();
		    redstoneblockname.setDisplayName("Redstone Block Team!");
		    redstoneblock.setItemMeta(redstoneblockname);
		    teamselection.setItem(25, redstoneblock);
		    
		    ItemStack magmacream = new ItemStack(Material.MAGMA_CREAM);
		    ItemMeta magmacreamname = magmacream.getItemMeta();
		    magmacreamname.setDisplayName("Leave Team");
		    magmacream.setItemMeta(magmacreamname);
		    teamselection.setItem(35, magmacream);
			
			
		    
			
			
		}
		else if (!(MainSegments.segment == 1)) {
		}
	}
	public static void GivePlayersVotingItem() {
		if (MainSegments.segment == 1) {

			
			ItemStack chooseteam = new ItemStack(Material.SLIME_BALL);
		    ItemMeta chooseteamname = chooseteam.getItemMeta();
		    chooseteamname.setDisplayName(Uhcmain.formatDefault + "Choose Your Team!");
		    chooseteam.setItemMeta(chooseteamname);
		    
		    for (Player player : Bukkit.getOnlinePlayers()) {
			if (!(player.getInventory().contains(Material.SLIME_BALL))) {
				
				player.getInventory().setItem(8, chooseteam);
				Bukkit.broadcastMessage("The Giving Team Choice Item Registers.");
				
			}
			if (player.getInventory().contains(chooseteam)){
				
			}
		    	
		    	
			}
			
		}
		else if (!(MainSegments.segment == 1)) {
			
		}
	}
	
}
