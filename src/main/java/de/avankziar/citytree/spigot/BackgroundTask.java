package main.java.de.avankziar.citytree.spigot;

public class BackgroundTask 
{
	private CityTree plugin;
	
	public BackgroundTask(CityTree plugin)
	{
		this.plugin = plugin;
		loadCitys(); //=> aus mysql
		loadDistricts(); //=> aus mysql
		loadProperties(); //=> aus mysql
	}
	
	private void loadCitys()
	{
		
	}
	
	private void loadDistricts()
	{
		
	}
	
	private void loadProperties()
	{
		
	}
}
