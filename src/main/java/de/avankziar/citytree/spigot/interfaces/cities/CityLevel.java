package main.java.de.avankziar.citytree.spigot.interfaces.cities;

import java.util.ArrayList;

import main.java.de.avankziar.citytree.spigot.interfaces.settings.Cost;

public class CityLevel //Die werden als erstes von der Config vorgeladen
{
	private String name;
	private int level;
	private Cost costs;
	private ArrayList<CityExtension.Type> neededCityExtension;
	private ArrayList<CityExtension.Type> availableCityExtension;
	private Cost costPerBlock;
	private double maximumArea;
	private int maximumDistricts;
	private int maximumProperties;
	private int maximumTeleports;
	private int maximumAdvertisement;
	
	public CityLevel(String name, int level, Cost costs,
			ArrayList<CityExtension.Type> neededCityExtension, ArrayList<CityExtension.Type> availableCityExtension,
			int maximumDistricts, int maximumProperties, int maximumTeleports, double maximumArea, int maximumAdvertisement,
			Cost costPerBlock)
	{
		setName(name);
		setLevel(level);
		setCosts(costs);
		setAvailableCityExtension(availableCityExtension);
		setNeededCityExtension(neededCityExtension);
		setMaximumDistricts(maximumDistricts);
		setMaximumProperties(maximumProperties);
		setMaximumTeleports(maximumTeleports);
		setMaximumArea(maximumArea);
		setCostPerBlock(costPerBlock);
		setMaximumAdvertisement(maximumAdvertisement);
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<CityExtension.Type> getAvailableCityExtension()
	{
		return availableCityExtension;
	}

	public void setAvailableCityExtension(ArrayList<CityExtension.Type> availableCityExtension)
	{
		this.availableCityExtension = availableCityExtension;
	}

	public int getMaximumDistricts()
	{
		return maximumDistricts;
	}

	public void setMaximumDistricts(int maximumDistricts)
	{
		this.maximumDistricts = maximumDistricts;
	}

	public int getMaximumProperties()
	{
		return maximumProperties;
	}

	public void setMaximumProperties(int maximumProperties)
	{
		this.maximumProperties = maximumProperties;
	}

	public int getMaximumTeleports()
	{
		return maximumTeleports;
	}

	public void setMaximumTeleports(int maximumTeleports)
	{
		this.maximumTeleports = maximumTeleports;
	}

	public double getMaximumArea()
	{
		return maximumArea;
	}

	public void setMaximumArea(double maximumArea)
	{
		this.maximumArea = maximumArea;
	}

	public int getMaximumAdvertisement()
	{
		return maximumAdvertisement;
	}

	public void setMaximumAdvertisement(int maximumAdvertisement)
	{
		this.maximumAdvertisement = maximumAdvertisement;
	}

	public Cost getCosts()
	{
		return costs;
	}

	public void setCosts(Cost costs)
	{
		this.costs = costs;
	}

	public ArrayList<CityExtension.Type> getNeededCityExtension()
	{
		return neededCityExtension;
	}

	public void setNeededCityExtension(ArrayList<CityExtension.Type> neededCityExtension)
	{
		this.neededCityExtension = neededCityExtension;
	}

	public Cost getCostPerBlock()
	{
		return costPerBlock;
	}

	public void setCostPerBlock(Cost costPerBlock)
	{
		this.costPerBlock = costPerBlock;
	}

}
