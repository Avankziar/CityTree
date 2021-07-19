package main.java.de.avankziar.citytree.spigot.interfaces.cities;

import java.util.ArrayList;

import org.bukkit.Location;

import main.java.de.avankziar.citytree.spigot.interfaces.settings.CityTreeSettings;

public class Property 
{
	private int idcity;
	private int iddistrict;
	private int id;
	private String name;
	private Property.Status status;
	private Property.Status newStatus;
	private SecurityLevel securityLevel;
	private String supremelandlord; //Der Spieler (uuid), der defakto landlords rausschmeißen kann
	private ArrayList<String> landlord; //Spieler (uuid) die das Zahlen, aka Mietpreis/Anzahl Spieler
										//Anzahl landlords durch config bestimmbar
	private ArrayList<String> roommate; //Spieler (uuid) die auch darin leben, aber nix zahlen
										//Anzahl roommate durch config bestimmbar

	//mysqlcreate für Log für die, die gezahlt haben und die nicht gezahlt haben
	//hook mit vconemy um ein log anzulegen, was du für das gs gezahlt hast.
	
	private Location first;
	private Location second;
	private int warp;
	private double rentprice;
	private double buyprice;
	private double newprice;
	private long minimumrenttime; //Minimal Mietzeitraum in millisekunden
	private long vacanttime; //Zeitraum ab wann das gs geräumt werden muss, configminimum
	private long renttime; //Zeit ab wann gemietet oder gekauft wurde
	private double debts;
	private String restoration; //Alles was in Citylevelcost ist
	private ArrayList<Integer> zones;
	private CityTreeSettings.ListType listType;
	private ArrayList<String> blackList;
	private ArrayList<String> whiteList;
	public static ArrayList<Property> AllProperties;
	
	public Property(int idcity, int iddistrict, int id, String name, Property.Status status, Property.Status newStatus,
			SecurityLevel securityLevel, String supremelandlord, ArrayList<String> landlord,
			ArrayList<String> roommate,
			Location first, Location second, int warp,
			double rentprice, double buyprice, double newprice, long minimumrenttime, long vacanttime, long renttime, 
			double debts, String restoration, ArrayList<Integer> zones, 
			CityTreeSettings.ListType listType, ArrayList<String> blackList, ArrayList<String> whiteList)
	{
		setIdcity(idcity);
		setIddistrict(iddistrict);
		setId(id);
		setName(name);
		setStatus(status);
		setNewStatus(newStatus);
		setSecurityLevel(securityLevel);
		setSupremelandlord(supremelandlord);
		setLandlord(landlord);
		setRoommate(roommate);
		setFirst(first);
		setSecond(second);
		setWarp(warp);
		setRentprice(rentprice);
		setBuyprice(buyprice);
		setNewprice(newprice);
		setMinimumrenttime(minimumrenttime);
		setVacanttime(vacanttime);
		setRenttime(renttime);
		setDebts(debts);
		setRestoration(restoration);
		setZones(zones);
		setListType(listType);
		setBlackList(blackList);
		setWhiteList(whiteList);
	}
	
	public int getIdcity()
	{
		return idcity;
	}
	public void setIdcity(int idcity)
	{
		this.idcity = idcity;
	}
	public int getIddistrict()
	{
		return iddistrict;
	}
	public void setIddistrict(int iddistrict)
	{
		this.iddistrict = iddistrict;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Property.Status getStatus()
	{
		return status;
	}

	public void setStatus(Property.Status status)
	{
		this.status = status;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSupremelandlord()
	{
		return supremelandlord;
	}
	public void setSupremelandlord(String supremelandlord)
	{
		this.supremelandlord = supremelandlord;
	}
	public ArrayList<String> getLandlord()
	{
		return landlord;
	}
	public void setLandlord(ArrayList<String> landlord)
	{
		this.landlord = landlord;
	}
	public ArrayList<String> getRoommate()
	{
		return roommate;
	}
	public void setRoommate(ArrayList<String> roommate)
	{
		this.roommate = roommate;
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
	public int getWarp()
	{
		return warp;
	}
	public void setWarp(int warp)
	{
		this.warp = warp;
	}
	public double getRentprice()
	{
		return rentprice;
	}
	public void setRentprice(double rentprice)
	{
		this.rentprice = rentprice;
	}
	public double getBuyprice()
	{
		return buyprice;
	}
	public void setBuyprice(double buyprice)
	{
		this.buyprice = buyprice;
	}
	public long getMinimumrenttime()
	{
		return minimumrenttime;
	}
	public void setMinimumrenttime(long minimumrenttime)
	{
		this.minimumrenttime = minimumrenttime;
	}
	public long getVacanttime()
	{
		return vacanttime;
	}
	public void setVacanttime(long vacanttime)
	{
		this.vacanttime = vacanttime;
	}
	public long getRenttime()
	{
		return renttime;
	}
	public void setRenttime(long renttime)
	{
		this.renttime = renttime;
	}

	public String getRestoration()
	{
		return restoration;
	}

	public void setRestoration(String restoration)
	{
		this.restoration = restoration;
	}
	
	public enum Status
	{
		VACANT, TERMINATED, RENTABLEandBUYABLE, RENTABLE, BUYABLE, RENTED, BOUGHT,
		//Vakant, gekündigt, Mietundkauf, mietbar, kaufbar, gemietet, gekauft
		
		FARMOPEN, FARMCLOSE, SPECIAL
		//Farmopen=Offene Farm für alle, Farmclosed=Farm nur für Stadtmitglieder, Special=Spezialebauten
	}
	
	public enum SecurityLevel
	{
		LOW, 
		/*
		 * Landlords und Roommate
		 * können auf alle Knöpfe, Druckplatten und alle Kisten benutzen
		 */
		MEDIUM,
		/*
		 * Landlords und Roommate
		 * können nur Holz Knopfe und Druckplatten, sowie RedstoneKisten benutzen.
		 */
		HIGH,
		/*
		 * Landlords und Roommate
		 * können nichts im Property benutzen.
		 */
	}

	public ArrayList<Integer> getZones()
	{
		return zones;
	}

	public void setZones(ArrayList<Integer> zones)
	{
		this.zones = zones;
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

	public SecurityLevel getSecurityLevel()
	{
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevel securityLevel)
	{
		this.securityLevel = securityLevel;
	}

	public double getDebts()
	{
		return debts;
	}

	public void setDebts(double debts)
	{
		this.debts = debts;
	}

	public Property.Status getNewStatus()
	{
		return newStatus;
	}

	public void setNewStatus(Property.Status newStatus)
	{
		this.newStatus = newStatus;
	}

	public double getNewprice()
	{
		return newprice;
	}

	public void setNewprice(double newprice)
	{
		this.newprice = newprice;
	}
}
