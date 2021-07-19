package main.java.de.avankziar.citytree.spigot.interfaces;

import org.bukkit.Location;

public class TeleportLocation 
{
	private int id;
	private String name;
	private String server;
	private boolean onlyServerStaff;
	private boolean onlyCityStaff;
	private Location location;
	
	public TeleportLocation(int id, String name, String server, boolean onlyCityStaff, boolean onlyServerStaff, Location location)
	{
		setId(id);
		setName(name);
		setServer(server);
		setOnlyCityStaff(onlyCityStaff);
		setOnlyServerStaff(onlyServerStaff);
		setLocation(location);
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
	
	public Location getLocation()
	{
		return location;
	}
	
	public void setLocation(Location location)
	{
		this.location = location;
	}

	public String getServer()
	{
		return server;
	}

	public void setServer(String server)
	{
		this.server = server;
	}

	public boolean isOnlyServerStaff()
	{
		return onlyServerStaff;
	}

	public void setOnlyServerStaff(boolean onlyServerStaff)
	{
		this.onlyServerStaff = onlyServerStaff;
	}

	public boolean isOnlyCityStaff()
	{
		return onlyCityStaff;
	}

	public void setOnlyCityStaff(boolean onlyCityStaff)
	{
		this.onlyCityStaff = onlyCityStaff;
	}
}
