package main.java.de.avankziar.citytree.spigot.interfaces.guirelevant;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class GuiUser //Zum Handlen der GUIs
{
	private Player player;
	private Gui.Type oldGui;
	private Gui.Type newGui;
	private double gleitPunktZahl;
	private int ganzZahl;
	private boolean wahrheitsWert;
	private int cityID;//Zwischenspeicher für städteid
	private int districtID;
	private int propertyID;
	private int zoneID;
	private int teleportID;
	private ArrayList<String> targets;
	private Location first;
	private Location second;
	private int listIndexPlace;
	private ArrayList<Integer> ownCities; //Eigenge Städte
	private ArrayList<Integer> barkerFromCity; //Eigenge Städte
	private ArrayList<Integer> ownDisticts; //Als Districtlord zugehörige Districte
	private ArrayList<Integer> ownProperties; //Als Property supremelandlord, landlord und roommate
	
	public static ArrayList<GuiUser> allGuiUser;
	public static ArrayList<GuiUser> chatEditor;
	
	public GuiUser(Player player, Gui.Type oldGui, Gui.Type newGui, double gleitPunktZahl, int ganzZahl, boolean wahrheitsWert,
			ArrayList<String> targets, Location first, Location second, int listIndexPlace,
			ArrayList<Integer> ownCities, ArrayList<Integer> barkerFromCity, 
			ArrayList<Integer> ownDistricts, ArrayList<Integer> ownProperties,
			int cityID, int districtID, int propertyID, int zoneID, int teleportID)
	{
		setPlayer(player);
		setOldGui(oldGui);
		setNewGui(newGui);
		setGleitpunktzahl(gleitPunktZahl);
		setGanzzahl(ganzZahl);
		setWahrheitswert(wahrheitsWert);
		setTargets(targets);
		setFirst(first);
		setSecond(second);
		setListIndexPlace(listIndexPlace);
		setOwnCities(ownCities);
		setOwnDisticts(ownDistricts);
		setOwnProperties(ownProperties);
		setCityID(cityID);
		setDistrictID(districtID);
		setPropertyID(propertyID);
		setZoneID(zoneID);
		setTeleportID(teleportID);
	}
	
	public static GuiUser getGuiUser(Player player)
	{
		GuiUser gu = null;
		for(GuiUser guiUser : allGuiUser)
		{
			if(guiUser.getPlayer().getName().equals(player.getName()))
			{
				gu = guiUser;
				break;
			}
		}
		return gu;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public double getGleitpunktzahl()
	{
		return gleitPunktZahl;
	}

	public void setGleitpunktzahl(double gleitPunktZahl)
	{
		this.gleitPunktZahl = gleitPunktZahl;
	}

	public int getGanzzahl()
	{
		return ganzZahl;
	}

	public void setGanzzahl(int ganzZahl)
	{
		this.ganzZahl = ganzZahl;
	}

	public boolean isWahrheitswert()
	{
		return wahrheitsWert;
	}

	public void setWahrheitswert(boolean wahrheitsWert)
	{
		this.wahrheitsWert = wahrheitsWert;
	}

	public Gui.Type getOldGui()
	{
		return oldGui;
	}

	public void setOldGui(Gui.Type oldGui)
	{
		this.oldGui = oldGui;
	}

	public Gui.Type getNewGui()
	{
		return newGui;
	}

	public void setNewGui(Gui.Type newGui)
	{
		this.newGui = newGui;
	}

	public ArrayList<Integer> getOwnCities()
	{
		return ownCities;
	}

	public void setOwnCities(ArrayList<Integer> ownCities)
	{
		this.ownCities = ownCities;
	}
	
	public ArrayList<Integer> getOwnDisticts()
	{
		return ownDisticts;
	}

	public void setOwnDisticts(ArrayList<Integer> ownDisticts)
	{
		this.ownDisticts = ownDisticts;
	}

	public ArrayList<Integer> getOwnProperties()
	{
		return ownProperties;
	}

	public void setOwnProperties(ArrayList<Integer> ownProperties)
	{
		this.ownProperties = ownProperties;
	}

	public ArrayList<Integer> getBarkerFromCity()
	{
		return barkerFromCity;
	}

	public void setBarkerFromCity(ArrayList<Integer> barkerFromCity)
	{
		this.barkerFromCity = barkerFromCity;
	}

	public ArrayList<String> getTargets()
	{
		return targets;
	}

	public void setTargets(ArrayList<String> targets)
	{
		this.targets = targets;
	}

	public Location getFirst()
	{
		return first;
	}

	public void setFirst(Location first)
	{
		this.first = first;
	}

	public Location getSecond()
	{
		return second;
	}

	public void setSecond(Location second)
	{
		this.second = second;
	}

	public int getListIndexPlace()
	{
		return listIndexPlace;
	}

	public void setListIndexPlace(int listIndexPlace)
	{
		this.listIndexPlace = listIndexPlace;
	}

	public int getCityID()
	{
		return cityID;
	}

	public void setCityID(int cityID)
	{
		this.cityID = cityID;
	}

	public int getDistrictID()
	{
		return districtID;
	}

	public void setDistrictID(int districtID)
	{
		this.districtID = districtID;
	}

	public int getPropertyID()
	{
		return propertyID;
	}

	public void setPropertyID(int propertyID)
	{
		this.propertyID = propertyID;
	}

	public int getZoneID()
	{
		return zoneID;
	}

	public void setZoneID(int zoneID)
	{
		this.zoneID = zoneID;
	}

	public int getTeleportID()
	{
		return teleportID;
	}

	public void setTeleportID(int teleportID)
	{
		this.teleportID = teleportID;
	}

}
