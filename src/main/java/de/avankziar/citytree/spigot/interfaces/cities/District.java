package main.java.de.avankziar.citytree.spigot.interfaces.cities;

import java.util.ArrayList;
import org.bukkit.Location;

public class District 
{
	private int idcity;
	private int id;
	private String name;
	private ArrayList<DistrictLord> districtLord; //cooldown um das geld nicht kurzfrist auf 0 zu setzen
	private Location first;
	private Location second;
	private SecurityLevel securityLevel;
	private ArrayList<Integer> districproperties;
	public static ArrayList<District> AllDistrict;
	
	public District(int idcity, int id, String name,
			ArrayList<DistrictLord> districLord, Location first, Location second, 
			SecurityLevel securityLevel, ArrayList<Integer> districtproperties)
	{
		setIdcity(idcity);
		setId(id);
		setName(name);
		setDistrictLord(districLord);
		setFirst(first);
		setSecond(second);
		setSecurityLevel(securityLevel);
		setDistricproperties(districtproperties);
	}

	public int getIdcity()
	{
		return idcity;
	}

	public void setIdcity(int idcity)
	{
		this.idcity = idcity;
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

	public ArrayList<Integer> getDistricproperties()
	{
		return districproperties;
	}

	public void setDistricproperties(ArrayList<Integer> districproperties)
	{
		this.districproperties = districproperties;
	}

	public ArrayList<DistrictLord> getDistrictLord()
	{
		return districtLord;
	}

	public void setDistrictLord(ArrayList<DistrictLord> districtLord)
	{
		this.districtLord = districtLord;
	}
	
	public SecurityLevel getSecurityLevel()
	{
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevel securityLevel)
	{
		this.securityLevel = securityLevel;
	}

	public enum SecurityLevel
	{
		LOW, 
		/*
		 * Spieler die nicht zugehörig zum District sind,
		 * können auf alle Knöpfe, Druckplatten und alle Kisten benutzen
		 */
		MEDIUM,
		/*
		 * Spieler die nicht zugehörig zum District sind,
		 * können nur Holz Knopfe und Druckplatten, sowie RedstoneKisten benutzen.
		 * DistrictLords und CoOWner und Owner sind ausgenommen.
		 */
		HIGH,
		/*
		 * Spieler die nicht zugehörig zum District sind,
		 * können nicht im District benutzen.
		 */
	}
}
