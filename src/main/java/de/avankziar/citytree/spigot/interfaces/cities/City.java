package main.java.de.avankziar.citytree.spigot.interfaces.cities;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;

import main.java.de.avankziar.citytree.spigot.interfaces.settings.CityTreeSettings;
import main.java.de.avankziar.citytree.spigot.interfaces.settings.Cost;

public class City 
{
	private int id;
	private String name;
	private ArrayList<String> lore; //Item Beschreibung
	private String creator; //uuid
	private String owner; //uuid
	private int cityLevel;
	private SecurityLevel securityLevel;
	private Location center;
	private Location first;
	private Location second; 
	private ArrayList<Integer> districts;
	private ArrayList<Integer> properties;
	private ArrayList<Integer> teleportLocations;
	private ArrayList<CityExtension.Type> cityExtension;
	private long createTime; //Wann die Stadt erstellt wurde
	private ArrayList<String> coOwner;
	private ArrayList<DistrictLord> districtLords;
	private Cost totalCost; //Gesamt preis der bis dato gezahl wurde
	private CityStockpile stockPile; //Was bisher an Kosten gespeicher für die nächste Stadtstufe
	private Material icon; 
	private ArrayList<Barker> barkers; //Marktschreier
	private ArrayList<String> advertisement; //werbung
	private boolean canLevelUp; //per config abzufragen
	private CityTreeSettings.ListType listType;
	private ArrayList<String> blackList;
	private ArrayList<String> whiteList;
	private int currentlyDistrictAmount; //Momentan District
	private int currentlyPropertyAmount;
	private int currentlyTeleportAmount;
	private int currentlyAdvertisementAmount;
	private double debts;
	
	public static ArrayList<City> allCity;
	
	public City(int id, String name, ArrayList<String> lore, Material icon, String creator, String owner, int citylevel,
			SecurityLevel securityLevel, Location center, Location first, Location second,
			ArrayList<Integer> districts, ArrayList<Integer> properties,
			ArrayList<Integer> teleportlocations, ArrayList<CityExtension.Type> cityextension,
			long createtime, ArrayList<String> coowner, ArrayList<DistrictLord> districtlords, Cost totalCost,
			CityStockpile stockPile, ArrayList<Barker> barkers, ArrayList<String> advertisement, 
			boolean canLevelUp, CityTreeSettings.ListType listType, ArrayList<String> blackList, ArrayList<String> whiteList,
			int currentlyDistrictAmount, int currentlyPropertyAmount, int currentlyTeleportAmount,int currentlyAdvertisementAmount,
			double debts)
	{
		setId(id);
		setName(name);
		setLore(lore);
		setCreator(creator);
		setOwner(owner);
		setCityLevel(citylevel);
		setSecurityLevel(securityLevel);
		setCenter(center);
		setFirst(first);
		setSecond(second);
		setDistricts(districts);
		setProperties(properties);
		setTeleportLocations(teleportlocations);
		setCityExtension(cityextension);
		setCreateTime(createtime);
		setCoOwner(coowner);
		setDistrictLords(districtlords);
		setTotalCost(totalCost);
		setStockPile(stockPile);
		setBarkers(barkers);
		setAdvertisement(advertisement);
		setIcon(icon);
		setCanLevelUp(canLevelUp);
		setListType(listType);
		setBlackList(blackList);
		setWhiteList(whiteList);
		setCurrentlyDistrictAmount(currentlyDistrictAmount);
		setCurrentlyPropertyAmount(currentlyPropertyAmount);
		setCurrentlyTeleportAmount(currentlyTeleportAmount);
		setCurrentlyAdvertisementAmount(currentlyAdvertisementAmount);
		setDebts(debts);
	}
	
	public static City getCity(int id)
	{
		City c = null;
		for(City ci : allCity)
		{
			if(ci.getId()==id)
			{
				c = ci;
				break;
			}
		}
		return c;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getCreator()
	{
		return creator;
	}
	public void setCreator(String creator)
	{
		this.creator = creator;
	}
	public String getOwner()
	{
		return owner;
	}
	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public Location getCenter()
	{
		return center;
	}
	public void setCenter(Location center)
	{
		this.center = center;
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
	public ArrayList<Integer> getDistricts()
	{
		return districts;
	}
	public void setDistricts(ArrayList<Integer> districts)
	{
		this.districts = districts;
	}
	public ArrayList<Integer> getProperties()
	{
		return properties;
	}
	public void setProperties(ArrayList<Integer> properties)
	{
		this.properties = properties;
	}

	public Material getIcon()
	{
		return icon;
	}

	public void setIcon(Material icon)
	{
		this.icon = icon;
	}
	
	public ArrayList<Barker> getBarkers()
	{
		return barkers;
	}

	public void setBarkers(ArrayList<Barker> barkers)
	{
		this.barkers = barkers;
	}
	
	public ArrayList<String> getAdvertisement()
	{
		return advertisement;
	}

	public void setAdvertisement(ArrayList<String> advertisement)
	{
		this.advertisement = advertisement;
	}

	public boolean isCanLevelUp()
	{
		return canLevelUp;
	}

	public void setCanLevelUp(boolean canLevelUp)
	{
		this.canLevelUp = canLevelUp;
	}

	public int getCityLevel()
	{
		return cityLevel;
	}

	public void setCityLevel(int cityLevel)
	{
		this.cityLevel = cityLevel;
	}

	public ArrayList<Integer> getTeleportLocations()
	{
		return teleportLocations;
	}

	public void setTeleportLocations(ArrayList<Integer> teleportLocations)
	{
		this.teleportLocations = teleportLocations;
	}

	public ArrayList<CityExtension.Type> getCityExtension()
	{
		return cityExtension;
	}

	public void setCityExtension(ArrayList<CityExtension.Type> cityExtension)
	{
		this.cityExtension = cityExtension;
	}

	public long getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(long createTime)
	{
		this.createTime = createTime;
	}

	public ArrayList<String> getCoOwner()
	{
		return coOwner;
	}

	public void setCoOwner(ArrayList<String> coOwner)
	{
		this.coOwner = coOwner;
	}

	public ArrayList<DistrictLord> getDistrictLords()
	{
		return districtLords;
	}

	public void setDistrictLords(ArrayList<DistrictLord> districtLords)
	{
		this.districtLords = districtLords;
	}

	public Cost getTotalCost()
	{
		return totalCost;
	}

	public void setTotalCost(Cost totalCost)
	{
		this.totalCost = totalCost;
	}

	public ArrayList<String> getLore()
	{
		return lore;
	}

	public void setLore(ArrayList<String> lore)
	{
		this.lore = lore;
	}
	
	public enum SecurityLevel
	{
		LOWEST, 
		/*
		 * Spieler die nicht zugehörig zum City sind,
		 * können auf alle Knöpfe, Druckplatten und alle Kisten benutzen
		 */
		LOW,
		/*
		 * Spieler die nicht zugehörig zum City sind,
		 * können nur Holz Knopfe & Druckplatten und Holztüre,
		 * sowie RedstoneKisten benutzen. Sowie alles andere auch(Ambosse, etc)
		 */
		MEDIUM,
		/*
		 * Spieler die nicht zugehörig zum City sind,
		 * können nur Holz Knopfe und Druckplatten, sowie RedstoneKisten benutzen. Sowie alles andere auch(Werkbank, etc)
		 * KEINE AMBOSSE!
		 */
		HIGH,
		/*
		 * Spieler die nicht zugehörig zum City sind,
		 * können nur Holz Knopfe und Druckplatten, sowie RedstoneKisten benutzen.
		 */
		VERYHIGH,
		/*
		 * Spieler die nicht zugehörig zum District sind,
		 * können nicht im District benutzen.
		 */
	}

	public CityTreeSettings.ListType getListType()
	{
		return listType;
	}

	public void setListType(CityTreeSettings.ListType listType)
	{
		this.listType = listType;
	}

	public ArrayList<String> getBlackList()
	{
		return blackList;
	}

	public void setBlackList(ArrayList<String> blackList)
	{
		this.blackList = blackList;
	}

	public ArrayList<String> getWhiteList()
	{
		return whiteList;
	}

	public void setWhiteList(ArrayList<String> whiteList)
	{
		this.whiteList = whiteList;
	}

	public int getCurrentlyDistrictAmount()
	{
		return currentlyDistrictAmount;
	}

	public void setCurrentlyDistrictAmount(int currentlyDistrictAmount)
	{
		this.currentlyDistrictAmount = currentlyDistrictAmount;
	}

	public int getCurrentlyPropertyAmount()
	{
		return currentlyPropertyAmount;
	}

	public void setCurrentlyPropertyAmount(int currentlyPropertyAmount)
	{
		this.currentlyPropertyAmount = currentlyPropertyAmount;
	}

	public int getCurrentlyTeleportAmount()
	{
		return currentlyTeleportAmount;
	}

	public void setCurrentlyTeleportAmount(int currentlyTeleportAmount)
	{
		this.currentlyTeleportAmount = currentlyTeleportAmount;
	}

	public int getCurrentlyAdvertisementAmount()
	{
		return currentlyAdvertisementAmount;
	}

	public void setCurrentlyAdvertisementAmount(int currentlyAdvertisementAmount)
	{
		this.currentlyAdvertisementAmount = currentlyAdvertisementAmount;
	}

	public CityStockpile getStockPile()
	{
		return stockPile;
	}

	public void setStockPile(CityStockpile stockPile)
	{
		this.stockPile = stockPile;
	}

	public double getDebts()
	{
		return debts;
	}

	public void setDebts(double debts)
	{
		this.debts = debts;
	}

	public SecurityLevel getSecurityLevel()
	{
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevel securityLevel)
	{
		this.securityLevel = securityLevel;
	}
}
