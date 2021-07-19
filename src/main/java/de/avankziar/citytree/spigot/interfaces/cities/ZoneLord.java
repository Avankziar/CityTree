package main.java.de.avankziar.citytree.spigot.interfaces.cities;

import java.util.ArrayList;

public class ZoneLord
{
	private String uuid;
	private ArrayList<Integer> zone;
	
	public ZoneLord(String uuid, ArrayList<Integer> zone)
	{
		setUuid(uuid);
		setZone(zone);
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	public ArrayList<Integer> getZone()
	{
		return zone;
	}

	public void setZone(ArrayList<Integer> zone)
	{
		this.zone = zone;
	}

}
