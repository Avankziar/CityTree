package main.java.de.avankziar.citytree.spigot;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class Utility 
{
	private CityTree plugin;
	private String language;
	private ArrayList<String> chatEditor;
	
	public Utility(CityTree plugin)
	{
		this.plugin = plugin;
		language = plugin.getYamlHandler().get().getString("language");
		setChatEditor(new ArrayList<String>());
	}

	public ArrayList<String> getChatEditor()
	{
		return chatEditor;
	}

	public void setChatEditor(ArrayList<String> chatEditor)
	{
		this.chatEditor = chatEditor;
	}

	public String tl(String path)
	{
		return ChatColor.translateAlternateColorCodes('&', path);
	}
	
	public ArrayList<String> tl(ArrayList<String> path)
	{
		for(String s : path)
		{
			tl(s);
		}
		return path;
	}
	
	public TextComponent tc(String s)
	{
		return new TextComponent(s);
	}
	
	public TextComponent tcl(String s)
	{
		return new TextComponent(ChatColor.translateAlternateColorCodes('&', s));
	}
	
	public String removeColor(String msg)
	{
		String a = msg.replaceAll("&0", "").replaceAll("&1", "").replaceAll("&2", "").replaceAll("&3", "").replaceAll("&4", "").replaceAll("&5", "")
				.replaceAll("&6", "").replaceAll("&7", "").replaceAll("&8", "").replaceAll("&9", "")
				.replaceAll("&a", "").replaceAll("&b", "").replaceAll("&c", "").replaceAll("&d", "").replaceAll("&e", "").replaceAll("&f", "")
				.replaceAll("&k", "").replaceAll("&l", "").replaceAll("&m", "").replaceAll("&n", "").replaceAll("&o", "").replaceAll("&r", "")
				.replaceAll("&A", "").replaceAll("&B", "").replaceAll("&C", "").replaceAll("&D", "").replaceAll("&E", "").replaceAll("&F", "")
				.replaceAll("&K", "").replaceAll("&L", "").replaceAll("&M", "").replaceAll("&N", "").replaceAll("&O", "").replaceAll("&R", "")
				.replaceAll("§0", "").replaceAll("§1", "").replaceAll("&2", "").replaceAll("§3", "").replaceAll("§4", "").replaceAll("§5", "")
				.replaceAll("§6", "").replaceAll("§7", "").replaceAll("§8", "").replaceAll("§9", "")
				.replaceAll("§a", "").replaceAll("§b", "").replaceAll("§c", "").replaceAll("§d", "").replaceAll("§e", "").replaceAll("§f", "")
				.replaceAll("§k", "").replaceAll("§l", "").replaceAll("§m", "").replaceAll("§n", "").replaceAll("§o", "").replaceAll("§r", "")
				.replaceAll("§A", "").replaceAll("§B", "").replaceAll("§C", "").replaceAll("§D", "").replaceAll("§E", "").replaceAll("§F", "")
				.replaceAll("§K", "").replaceAll("§L", "").replaceAll("§M", "").replaceAll("§N", "").replaceAll("§O", "").replaceAll("§R", "");
		return a;
	}
	
	public void sendMessage(Player p, String path)
	{
		p.spigot().sendMessage(tc(tl(path)));
	}
	
	public boolean isNull(YamlConfiguration yml, String path, boolean consoleoutput)
	{
		if(yml.get(path)==null)
		{
			if(consoleoutput)
			{
				CityTree.log.severe("Error in gui.yml! Path: "+path);
			}
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack createItemFromYaml(YamlConfiguration yml, String ID, int amount)
	{
		ItemStack is = null;
		if(isNull(plugin.getYamlHandler().getGui(), ID+".material", true))
		{
			return null;
		}
		Material mat = Material.matchMaterial(yml.getString(ID+".material"));
		is = new ItemStack(mat);
		ItemMeta im = is.getItemMeta();
		if(isNull(plugin.getYamlHandler().getGui(), ID+".name", true))
		{
			return null;
		}
		String name = yml.getString(ID+".name");
		im.setDisplayName(tl(name));
		ArrayList<String> itf = null;
		if(yml.getStringList(ID+".itemflag") != null)
		{
			itf = (ArrayList<String>) yml.getStringList(ID+".itemflag");
			for(int i = 0 ; i < itf.size() ; i++)
			{
				ItemFlag it = ItemFlag.valueOf(itf.get(i));
				im.addItemFlags(it);
			}
		}
		ArrayList<String> ech = null;
		if(yml.getStringList(ID+".enchantments") != null)
		{
			ech = (ArrayList<String>) yml.getStringList(ID+".enchantments");
			for(int i = 0 ; i < ech.size() ; i++)
			{
				String[] a = ech.get(i).split(";");
				String b = a[0].toUpperCase();
				Enchantment eh = EnchantmentWrapper.getByName(b);
				int d = Integer.parseInt(a[1]);
				if(eh!=null)
				{
					im.addEnchant(eh, d, true);	
				}
			}
		}
		ArrayList<String> desc = null;
		if(yml.getStringList(ID+".lore") != null)
		{
			desc = (ArrayList<String>) yml.getStringList(ID+".lore");
		}
		ItemStack iss = null;
		im.setLore(desc);
		is.setItemMeta(im);
		if(isNull(plugin.getYamlHandler().getGui(), ID+".amount", true))
		{
			return null;
		}
		is.setAmount(amount);
		iss = is;
		return iss;
	}
	
	public boolean hasAvaliableSlot(Player player, int freeslots)
	{
		Inventory inv = player.getInventory();
		int check = 0;
		for (ItemStack item: inv.getContents()) 
		{
			if(item == null) 
			{
				check++;
			}
		}
		if(check>=freeslots)
		{
			return true;
		} else 
		{
			return false;
		}
	}
}
