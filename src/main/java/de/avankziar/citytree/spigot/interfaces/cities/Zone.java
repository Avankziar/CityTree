package main.java.de.avankziar.citytree.spigot.interfaces.cities;

import java.util.ArrayList;

import org.bukkit.Location;

public class Zone
{
	private int propertyID;
	private int ID;
	private ArrayList<ZoneLord> zoneLord;
	private Location first;
	private Location second;
	
	public Zone(int propertyID, int ID, ArrayList<ZoneLord> zoneLord,
			Location first, Location second)
	{
		setPropertyID(propertyID);
		setID(ID);
		setZoneLord(zoneLord);
		setFirst(first);
		setSecond(second);
	}

	public int getPropertyID()
	{
		return propertyID;
	}

	public void setPropertyID(int propertyID)
	{
		this.propertyID = propertyID;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public ArrayList<ZoneLord> getZoneLord()
	{
		return zoneLord;
	}

	public void setZoneLord(ArrayList<ZoneLord> zoneLord)
	{
		this.zoneLord = zoneLord;
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

}
