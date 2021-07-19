package main.java.de.avankziar.citytree.spigot.handler;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.City;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.District;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.Property;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.Zone;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.Gui;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.GuiFunction;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.GuiUser;

public class GuiHandler 
{
	private CityTree plugin;
	private String language;
	
	public GuiHandler(CityTree plugin)
	{
		this.plugin = plugin;
		language = plugin.getYamlHandler().get().getString("language");
	}
	
	public enum Type
	{
		ADMIN, OWNER, NONE;
	}
	
	public String replacer(Object object, String s)
	{
		if(object instanceof City)
		{
			
		}
		if(object instanceof District)
		{
			
		}
		if(object instanceof Property)
		{
			
		}
		if(object instanceof Zone)
		{
			
		}
		if(object instanceof OfflinePlayer)
		{
			
		}
		if(object instanceof GuiUser) 
		{
			GuiUser gu = (GuiUser) object;
			s.replace("%userinteger%", String.valueOf(gu.getGanzzahl()))
			.replace("%userdouble%", String.valueOf(gu.getGleitpunktzahl()));
		}
		return s.replace("%version%", plugin.getDescription().getVersion());
	}
	
	public ArrayList<String> replacer(Object object, ArrayList<String> array)
	{
		if(object instanceof City)
		{
			City c = (City) object;
			for(String s : array)
			{
				int i = array.indexOf(s);
				s.replace("%version%", plugin.getDescription().getVersion())
				.replace("%%", c.getAdvertisement().toString()) //TODO Converter Schreiben
				.replace("%%", c.getBarkers().toString()) //TODO Converter Schreiben
				.replace("%%", c.getBlackList().toString())
				.replace("%%", plugin.getInterfaceConverter().getLocationCoding(c.getCenter()))
				.replace("%%", ((City) object).getCityExtension().toString())
				.replace("%%", String.valueOf(((City) object).getCityLevel()))
				.replace("%%", String.valueOf(((City) object).getCityLevel())) //TODO Converter schreiben
				.replace("%%", ((City) object).getCoOwner().toString()) //TODO ...
				.replace("%%", String.valueOf(((City) object).getCreateTime()))
				.replace("%%", ((City) object).getCreator())
				.replace("%%", String.valueOf(((City) object).getCurrentlyAdvertisementAmount()))
				.replace("%%", String.valueOf(((City) object).getCurrentlyDistrictAmount()))
				.replace("%%", String.valueOf(((City) object).getCurrentlyPropertyAmount()))
				.replace("%%", String.valueOf(((City) object).getCurrentlyTeleportAmount()))
				.replace("%%", String.valueOf(((City) object).getDebts()))
				.replace("%%", ((City) object).getDistrictLords().toString()) //TODO
				.replace("%%", ((City) object).getDistricts().toString()) //TODO 
				.replace("%%", plugin.getInterfaceConverter().getLocationCoding(((City) object).getFirst()))
				.replace("%%", ((City) object).getIcon().name())
				.replace("%id%", String.valueOf(((City) object).getId()))
				.replace("%%", ((City) object).getListType().name())
				//.replace("%%", ((City) object).getLore()) //nope
				.replace("%%", ((City) object).getName())
				.replace("%%", ((City) object).getOwner())
				.replace("%%", ((City) object).getProperties().toString()) //TODO
				.replace("%%", plugin.getInterfaceConverter().getLocationCoding(((City) object).getSecond()))
				.replace("%%", ((City) object).getSecurityLevel().name())
				.replace("%%", ((City) object).getStockPile().toString()) //TODO Converter, der pro zeile ersetzt und nicht alles in einer zeile
				.replace("%%", ((City) object).getTeleportLocations().toString()) //TODO
				.replace("%%", ((City) object).getTotalCost().toString()) //TODO
				.replace("%%", ((City) object).getWhiteList().toString())
				.replace("%%", String.valueOf(((City) object).isCanLevelUp()));
				i++;
			}
		}
		if(object instanceof District)
		{
			
		}
		if(object instanceof Property)
		{
			
		} if(object instanceof Zone)
		{
			
		}
		if(object instanceof OfflinePlayer)
		{
			
		}
		if(object instanceof GuiUser) 
		{
			
		}
		return array;
	}
	
	public void loadingSimpleGui(YamlConfiguration yml, Gui.Type guiType)
	{
		String language = plugin.getYamlHandler().get().getString("language");
		String ID = language+"."+guiType.name();
		if(plugin.getUtility().isNull(yml, ID, true))
		{
			return;
		}
		if(plugin.getUtility().isNull(yml, ID+".title", true))
		{
			return;
		}
		String title = yml.getString(ID+".title");
		Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, title);
		ArrayList<GuiFunction> guiFunction = new ArrayList<>();
		int i = 0;
		while(i<=54)
		{
			if(yml.getString(ID+".inventory."+i)!=null)
			{
				ItemStack is = plugin.getUtility().createItemFromYaml(yml, ID+".inventory."+i, 1);
				inventory.setItem(i, is);
			}
			
			GuiFunction.Type none = GuiFunction.Type.NONE;
			GuiFunction.Type left = none;
			if(!plugin.getUtility().isNull(yml, ID+".inventory."+i+".function.left", false))
			{
				left = GuiFunction.Type.valueOf(yml.getString(ID+".inventory."+i+".function.left"));
			}
			
			GuiFunction.Type right = none;
			if(!plugin.getUtility().isNull(yml, ID+".inventory."+i+".function.right", false))
			{
				right = GuiFunction.Type.valueOf(yml.getString(ID+".inventory."+i+".function.right"));
			}
			
			GuiFunction.Type shiftleft = none;
			if(!plugin.getUtility().isNull(yml, ID+".inventory."+i+".function.shiftleft", false))
			{
				shiftleft = GuiFunction.Type.valueOf(yml.getString(ID+".inventory."+i+".function.shiftleft"));
			}
			
			GuiFunction.Type shiftright = none;
			if(!plugin.getUtility().isNull(yml, ID+".inventory."+i+".function.shiftright", false))
			{
				shiftright = GuiFunction.Type.valueOf(yml.getString(ID+".inventory."+i+".function.shiftright"));
			}
			
			GuiFunction.Type drop = none;
			if(!plugin.getUtility().isNull(yml, ID+".inventory."+i+".function.drop", false))
			{
				drop = GuiFunction.Type.valueOf(yml.getString(ID+".inventory."+i+".function.drop"));
			}
			
			Gui.Type guiTypeII = Gui.Type.NONE;
			if(!plugin.getUtility().isNull(yml, ID+".inventory."+i+".function.guitype", false))
			{
				guiTypeII = Gui.Type.valueOf(yml.getString(ID+".inventory."+i+".function.guitype"));
			}
			int integer = 0;
			if(!plugin.getUtility().isNull(yml, ID+".inventory."+i+".function.int", false))
			{
				integer = Integer.parseInt(yml.getString(ID+".inventory."+i+".function.int"));
			}
			
			double doubles = 0.0;
			if(!plugin.getUtility().isNull(yml, ID+".inventory."+i+".function.double", false))
			{
				doubles = Double.parseDouble(yml.getString(ID+".inventory."+i+".function.double"));
			}
			
			GuiHandler.Type guiHandlerType = GuiHandler.Type.NONE;
			if(!plugin.getUtility().isNull(yml, ID+".inventory."+i+".secruity", false))
			{
				guiHandlerType = GuiHandler.Type.valueOf(yml.getString(ID+".inventory."+i+".secruity"));
			}
			
			GuiFunction gf = new GuiFunction(i, left, right, shiftleft,	shiftright, drop,
					guiTypeII, guiHandlerType, integer, doubles);
			guiFunction.add(gf);
			i++;
		}
		
		Gui gui = new Gui(title, Gui.Type.CITY_MAIN, inventory, guiFunction);
		Gui.allGui.add(gui);
	}
	
	public boolean guiInteractionHandler(GuiUser guiUser, Gui gui, GuiFunction guiFunction,
			GuiFunction.Type guiFunctionType, String title)
	{
		switch(guiFunctionType)
		{
		case NONE:
			return false;
		case SWITCH:
			return switchAction(guiUser, gui, guiFunction, title);
		case DIRECTLOCATION:
		case BACK:
		case NEXTPAGE:
		case PREVIOUSPAGE:
		case ADD_INTEGER:
			return integerDoubleAction(guiUser, gui, guiFunction, title);
		case REMOVE_INTEGER:
			return integerDoubleAction(guiUser, gui, guiFunction, title);
		case ADD_DOUBLE:
			return integerDoubleAction(guiUser, gui, guiFunction, title);
		case REMOVE_DOUBLE:
			return integerDoubleAction(guiUser, gui, guiFunction, title);
		case ACCEPT:
			return acceptAction(guiUser, gui, guiFunction, title);
		case ADD_PLAYER:
		case REMOVE_PLAYER:
		case TELEPORT:
		case CITYLEVELRISE:
		case CHATEDITOR:
		case ADD_SURVEYING:
		case REMOVE_SURVEYING:
		}
		return false;
	}
	
	public boolean switchAction(GuiUser guiUser, Gui gui, GuiFunction guiFunction, String title)
	{
		Gui newgui = null;
		int index = 0;
		int slot = 0;
		int page = 0;
		int id = 0;
		City city = null;
		Inventory inv = null;
		guiUser.setOldGui(guiUser.getNewGui());
		switch(guiFunction.getGuiType())
		{
		case CITY_GLOBALLIST:
			newgui = Gui.getGui(guiFunction.getGuiType());
			index = 0+guiUser.getListIndexPlace();
			slot = 0;
			page = index/44;
			inv = Bukkit.createInventory(null, InventoryType.CHEST, 
					newgui.getTitle().replace("%page%", String.valueOf(page)));
			inv.setContents(newgui.getInventory().getContents());
			while(slot<=44)
			{
				if(City.allCity.size()<(index+1))
				{
					break;
				} else
				{
					if(City.allCity.get(index)!=null)
					{
						ItemStack is = inv.getItem(slot);
						city = City.allCity.get(index);
						is.setType(city.getIcon());
						is.getItemMeta().setDisplayName(plugin.getUtility().tl(replacer(city, is.getItemMeta().getDisplayName())));
						is.getItemMeta().setLore(plugin.getUtility().tl(replacer(city, city.getLore())));
						guiUser.setListIndexPlace(index);
					}
				}
				index++;
				slot++;
			}
			guiUser.setNewGui(guiFunction.getGuiType());
			guiUser.getPlayer().getOpenInventory().getTopInventory().setContents(inv.getContents());
			guiUser.getPlayer().updateInventory();
			return true;
		
		case CITY_MAIN:
			
			newgui = Gui.getGui(guiFunction.getGuiType());
			city = City.getCity(Integer.parseInt(plugin.getUtility().removeColor(title)));
			if(city == null)
			{
				city = City.getCity(guiUser.getCityID());
			}
			id = city.getId();
			inv = Bukkit.createInventory(null, InventoryType.CHEST, 
					replacer(city, title));
			inv.setContents(newgui.getInventory().getContents());
			slot = 0;
			Type playerType = Type.NONE;
			if(guiUser.getOwnCities().contains(city.getId()))
			{
				playerType = Type.OWNER;
			}
			if(guiUser.getPlayer().hasPermission(plugin.getPermissionHandler().getStaffByPass()))
			{
				playerType = Type.ADMIN;
			}
			while(slot<=53)
			{
				if(inv.getItem(slot)!=null)
				{
					Type type = Type.valueOf(plugin.getYamlHandler().getGui().getString(
							language+"."+guiFunction.getGuiType().name()+".inventory."+slot+".security"));
					if(playerType == Type.ADMIN || type == playerType || type == Type.NONE)
					{
						ItemStack is = inv.getItem(slot);
						is.getItemMeta().setDisplayName(replacer(city, is.getItemMeta().getDisplayName()));
						is.getItemMeta().setLore(replacer(city, (ArrayList<String>) is.getItemMeta().getLore()));
					} else
					{
						inv.remove(inv.getItem(slot));
					}
				}
				slot++;
			}
			guiUser.setCityID(id);
			guiUser.setNewGui(guiFunction.getGuiType());
			guiUser.getPlayer().getOpenInventory().getTopInventory().setContents(inv.getContents());
			guiUser.getPlayer().updateInventory();
		case CITY_OWNLIST:
			newgui = Gui.getGui(guiFunction.getGuiType());
			index = 0+guiUser.getListIndexPlace();
			slot = 0;
			page = index/44;
			inv = Bukkit.createInventory(null, InventoryType.CHEST, 
					newgui.getTitle().replace("%page%", String.valueOf(page)));
			inv.setContents(newgui.getInventory().getContents());
			while(slot<=44)
			{
				if(guiUser.getOwnCities().size()<(index+1))
				{
					break;
				} else
				{
					if(guiUser.getOwnCities().get(index)!=null)
					{
						ItemStack is = inv.getItem(slot);
						City c = City.getCity(guiUser.getOwnCities().get(index));
						is.setType(c.getIcon());
						is.getItemMeta().setDisplayName(plugin.getUtility().tl(replacer(c, is.getItemMeta().getDisplayName())));
						is.getItemMeta().setLore(plugin.getUtility().tl(replacer(c, c.getLore())));
						guiUser.setListIndexPlace(index);
					}
				}
				index++;
				slot++;
			}
			guiUser.setNewGui(guiFunction.getGuiType());
			guiUser.getPlayer().getOpenInventory().getTopInventory().setContents(inv.getContents());
			guiUser.getPlayer().updateInventory();
			return true;
		case CITY_BUYEXPANSION:
			newgui = Gui.getGui(guiFunction.getGuiType());
			slot = 0;
			inv = Bukkit.createInventory(null, InventoryType.CHEST, 
					replacer(guiUser, newgui.getTitle()));
			inv.setContents(newgui.getInventory().getContents());
			city = City.getCity(guiUser.getCityID());
			while(slot<=53)
			{
				if(inv.getItem(slot)!=null)
				{
					ItemStack is = inv.getItem(slot);
					is.getItemMeta().setDisplayName(plugin.getUtility().tl(
							replacer(guiUser, is.getItemMeta().getDisplayName())));
					is.getItemMeta().setLore(replacer(city, (ArrayList<String>) is.getItemMeta().getLore()));
				}
				slot++;
			}
			guiUser.setNewGui(guiFunction.getGuiType());
			guiUser.getPlayer().getOpenInventory().getTopInventory().setContents(inv.getContents());
			guiUser.getPlayer().updateInventory();
			return true;
		case CITY_BUYDISTRICT:
			newgui = Gui.getGui(guiFunction.getGuiType());
			slot = 0;
			inv = Bukkit.createInventory(null, InventoryType.CHEST, 
					replacer(guiUser, newgui.getTitle()));
			inv.setContents(newgui.getInventory().getContents());
			city = City.getCity(guiUser.getCityID());
			while(slot<=53)
			{
				if(inv.getItem(slot)!=null)
				{
					ItemStack is = inv.getItem(slot);
					is.getItemMeta().setDisplayName(plugin.getUtility().tl(
							replacer(guiUser, is.getItemMeta().getDisplayName())));
					is.getItemMeta().setLore(replacer(city, (ArrayList<String>) is.getItemMeta().getLore()));
				}
				slot++;
			}
			guiUser.setNewGui(guiFunction.getGuiType());
			guiUser.getPlayer().getOpenInventory().getTopInventory().setContents(inv.getContents());
			guiUser.getPlayer().updateInventory();
			return true;
		}
		return false;
	}
	
	public boolean integerDoubleAction(GuiUser guiUser, Gui gui, GuiFunction guiFunction, String title)
	{
		Gui newgui = Gui.getGui(guiFunction.getGuiType());
		int slot = 0;
		Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, 
				replacer(guiUser, newgui.getTitle()));
		inv.setContents(newgui.getInventory().getContents());
		while(slot<=53)
		{
			if(inv.getItem(slot)!=null)
			{
				ItemStack is = inv.getItem(slot);
				is.getItemMeta().setDisplayName(plugin.getUtility().tl(
						replacer(guiUser, is.getItemMeta().getDisplayName())));
			}
			slot++;
		}
		guiUser.setNewGui(guiFunction.getGuiType());
		guiUser.getPlayer().getOpenInventory().getTopInventory().setContents(inv.getContents());
		guiUser.getPlayer().updateInventory();
		return true;
	}
	
	public boolean acceptAction(GuiUser guiUser, Gui gui, GuiFunction guiFunction, String title) //TODO
	{
		return true;
	}
	
	/*
	 * public void guiClickAction(GuiUser guiUser, Gui gui, GuiFunction guiFunction, GuiFunction.Type guiFunctionType)
	{
		Player player = guiUser.getPlayer();
		switch(guiFunctionType)
		{
		default:
			return;
		case NONE:
			return;
		case SWITCH:
			//Aka nächste Seite oder vorherige Seite
			if(guiUser.getNewGui() == guiFunction.getGuiType())
			{
				if(player.getOpenInventory().getTopInventory()==null)
				{
					return;
				}
				if(player.getOpenInventory().getTopInventory().getType()!=InventoryType.CHEST)
				{
					return;
				}
				int mysqlValue = 0;
				if(guiFunction.getGuiType() == GuiType.CITY_GLOBALLIST)
				{
					//TODO aus City.AllCity die id rausholen
				} else if(guiFunction.getGuiType() == GuiType.CITY_PERSONALLIST)
				{
					//TODO aus 
				} else if(guiFunction.getGuiType() == GuiType.PROPERTY_GLOBALLIST)
				{
					
				} else if(guiFunction.getGuiType() == GuiType.PROPERTY_PERSONALLIST)
				{
					
				}
				int id = 1;
				int start = 0;
				while(start<35)
				{
					if(player.getOpenInventory().getTopInventory().getItem(start)==null)
					{
						if(id<=0)
						{
							id = 1;
						}
						break;
					}
					if(player.getOpenInventory().getTopInventory().getItem(start).hasItemMeta())
					{
						if(player.getOpenInventory().getTopInventory().getItem(start).getItemMeta().hasDisplayName())
						{
							String[] name = player.getOpenInventory().getTopInventory().getItem(start)
									.getItemMeta().getDisplayName().split(" ");
							id = Integer.parseInt(name[0]);
						}
					}
				}
				
			}
			return;
		case ADD_INTEGER:
			return;
		case REMOVE_INTEGER:
			return;
		case ADD_DOUBLE:
			return;
		case REMOVE_DOUBLE:
			return;
		}
	}
	 */
}
