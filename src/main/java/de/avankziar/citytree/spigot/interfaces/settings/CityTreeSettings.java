package main.java.de.avankziar.citytree.spigot.interfaces.settings;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.CityExtension;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.CityLevel;

public class CityTreeSettings
{
	private static CityTreeSettings cityTreeSettings;
	private CityTree plugin;
	
	private String server;
	private boolean canCreateCity;
	private int maximumCitysAmount;
	private double taxation;
	private double baseTaxtionPerProperty;
	private LevelUpType levelUpType;
	private ItemStack cityCreateBlock;
	
	private ArrayList<CityLevel> cityLevels;
	private ArrayList<CityExtension> cityExtension;
	
	private double distanceBetweenCities;
	private Vector createSetting;
	private double edgeRatio;
	
	private Calculation teleportCalculation;
	private int baseFreeTeleport;
	
	private Calculation districtCalculation;
	private int baseFreeDistrict;
	
	private Calculation propertiesCalculation;
	private double rentalChargesMulti;
	private long minimumTerminationTime;
	private LinkedHashMap<Long, Double> terminationValue;
	private int baseFreeProperties;
	private double minimalPropertyVolume;
	private int maximumLandLord;
	private int maximumRoommate;
	private int maximumZone;
	
	private Calculation advertisementCalculation;
	private int baseFreeAdvertisement;
	private int barkerMaximumAdvertisment;
	
	public CityTreeSettings(CityTree plugin)
	{
		this.plugin = plugin;
		createCityTreeSettings(plugin.getYamlHandler().get());
	}
	
	private CityTreeSettings(String server, boolean canCreateCity, int maximumCitysAmount, double taxation, double baseTaxtionPerProperty, 
			LevelUpType levelUpType, ItemStack cityCreateBlock, ArrayList<CityLevel> cityLevels, ArrayList<CityExtension> cityExtension,
			double distanceBetweenCities, Vector createSetting, double edgeRatio, Calculation teleportCalculation, 
			int baseFreeTeleport, Calculation districtCalculation, int baseFreeDistrict, Calculation propertiesCalculation,
			double rentalChargesMulti, long minimumTerminationTime, LinkedHashMap<Long, Double> terminationValue,
			int baseFreeProperties, double minimalPropertyVolume, int maximumLandLord, int maximumRoommate,
			int maximumZone, Calculation advertisementCalculation, int baseFreeAdvertisement, int barkerMaximumAdvertisment)
	{
		setServer(server);
		setCanCreateCity(canCreateCity);
		setMaximumCitysAmount(maximumCitysAmount);
		setTaxation(taxation);
		setBaseTaxtionPerProperty(baseTaxtionPerProperty);
		setLevelUpType(levelUpType);
		setCityCreateBlock(cityCreateBlock);
		setCityLevels(cityLevels);
		setCityExtension(cityExtension);
		
		setDistanceBetweenCities(distanceBetweenCities);
		setCreateSetting(createSetting);
		setEdgeRatio(edgeRatio);
		
		setTeleportCalculation(teleportCalculation);
		setBaseFreeTeleport(baseFreeTeleport);
		setDistrictCalculation(districtCalculation);
		setBaseFreeDistrict(baseFreeDistrict);
		
		setPropertiesCalculation(propertiesCalculation);
		setRentalChargesMulti(rentalChargesMulti);
		setMinimumTerminationTime(minimumTerminationTime);
		setTerminationValue(terminationValue);
		setBaseFreeProperties(baseFreeProperties);
		setMinimalPropertyVolume(minimalPropertyVolume);
		setMaximumLandLord(maximumLandLord);
		setMaximumRoommate(maximumRoommate);
		setMaximumZone(maximumZone);
		
		setAdvertisementCalculation(advertisementCalculation);
		setBaseFreeAdvertisement(baseFreeAdvertisement);
		setBarkerMaximumAdvertisment(barkerMaximumAdvertisment);
	}
	
	public void createCityTreeSettings(YamlConfiguration yml)
	{
		String server = yml.getString("server");
		boolean canCreateCity = Boolean.parseBoolean(yml.getString("canCreateCitys"));
		int maximumCitysAmount = Integer.parseInt(yml.getString("city.maximumAmount"));
		double taxation = Double.parseDouble(yml.getString("city.tax"));
		double baseTaxationPerProperty = Double.parseDouble(yml.getString("city.basetaxperproperty"));
		LevelUpType levelUpType = LevelUpType.valueOf(yml.getString("city.levelUp"));
		ItemStack cityCreateBlock = plugin.getUtility().createItemFromYaml(yml, "city.item", 1);
		
		ArrayList<CityLevel> cityLevels = plugin.getInterfaceConverter().getCityLevels();
		ArrayList<CityExtension> cityExtension = plugin.getInterfaceConverter().getCityExtension();
		
		double distanceBetweenCities = Double.parseDouble(yml.getString("city.expansions.distanceBetweenCities"));
		Vector createSetting = new Vector(
				Double.parseDouble(yml.getString("city.createSetting.x")),
				Double.parseDouble(yml.getString("city.createSetting.y")), 
				Double.parseDouble(yml.getString("city.createSetting.z")));
		String ratioRaw = yml.getString("city.expansions.edgeRatio");
		double edgeRatio = 0.0;
		if(ratioRaw.contains(":"))
		{
			String[] s = ratioRaw.split(":");
			if(s.length==2)
			{
				double valueA = Double.parseDouble(s[0]);
				double valueB = Double.parseDouble(s[1]);
				if(valueA==1.0 || valueB==1.0)
				{
					if(valueA==1.0) {edgeRatio = valueB;}
					else {edgeRatio = valueA;}
				} else
				{
					edgeRatio = Math.max(valueA,valueB)/Math.min(valueA, valueB);
				}
			}
		}
		
		Calculation teleportCalculation = new Calculation(
				Calculation.Type.valueOf(yml.getString("city.teleports.calculationType")),
				Double.parseDouble(yml.getString("city.teleports.baseMoneyValue")),
				Double.parseDouble(yml.getString("city.teleports.valueOne")),
				Double.parseDouble(yml.getString("city.teleports.valueTwo")));
		int baseFreeTeleport = Integer.parseInt(yml.getString("city.teleports.baseFreeValue"));
		
		Calculation districtCalculation = new Calculation(
				Calculation.Type.valueOf(yml.getString("city.districts.calculationType")),
				Double.parseDouble(yml.getString("city.districts.baseMoneyValue")),
				Double.parseDouble(yml.getString("city.districts.valueOne")),
				Double.parseDouble(yml.getString("city.districts.valueTwo")));
		int baseFreeDistrict = Integer.parseInt(yml.getString("city.districts.baseFreeValue"));
		
		Calculation propertiesCalculation = new Calculation(
				Calculation.Type.valueOf(yml.getString("city.properties.calculationType")),
				Double.parseDouble(yml.getString("city.properties.baseMoneyValue")),
				Double.parseDouble(yml.getString("city.properties.valueOne")),
				Double.parseDouble(yml.getString("city.properties.valueTwo")));
		double rentalChargesMulti = Double.parseDouble(yml.getString("city.properties.rentalchargesmulti"));
		long minimumTerminationTime = Long.parseLong(yml.getString("city.properties.terminationtime"));
		LinkedHashMap<Long, Double> terminationValue = new LinkedHashMap<>();
		for(String s : yml.getStringList("city.properties.terminationvalue"))
		{
			if(s.contains(";"))
			{
				String[] a = s.split(";");
				if(a.length==2)
				{
					Long l = Long.parseLong(a[0])*1000*60*60*24; //Tage
					Double d = Double.parseDouble(a[1]);
					terminationValue.put(l, d);
				}
			}
		}
		int baseFreeProperties = Integer.parseInt(yml.getString("city.properties.baseFreeValue"));
		double minimalPropertyVolume = Double.parseDouble(yml.getString("city.properties. minimalVolume"));
		int maximumLandLord = Integer.parseInt(yml.getString("city.properties.maximumlandlord"));
		int maximumRoommate = Integer.parseInt(yml.getString("city.properties.maximumroommate"));
		int maximumZone = Integer.parseInt(yml.getString("city.properties.maximumzone"));
		
		Calculation advertisementCalculation = new Calculation(
				Calculation.Type.valueOf(yml.getString("city.advertisement.calculationType")),
				Double.parseDouble(yml.getString("city.advertisement.baseMoneyValue")),
				Double.parseDouble(yml.getString("city.advertisement.valueOne")),
				Double.parseDouble(yml.getString("city.advertisement.valueTwo")));
		int baseFreeAdvertisement = Integer.parseInt(yml.getString("city.advertisement.baseFreeValue"));
		int barkerMaximumAdvertisment = Integer.parseInt(yml.getString("city.advertisment.barkermaximumamount"));
		
		cityTreeSettings = new CityTreeSettings(server, canCreateCity, maximumCitysAmount, taxation, baseTaxationPerProperty, 
				levelUpType, cityCreateBlock, cityLevels, cityExtension, distanceBetweenCities, createSetting, edgeRatio,
				teleportCalculation, baseFreeTeleport, districtCalculation, baseFreeDistrict, propertiesCalculation,
				rentalChargesMulti, minimumTerminationTime, terminationValue, baseFreeProperties, minimalPropertyVolume,
				maximumLandLord, maximumRoommate, maximumZone, advertisementCalculation, baseFreeAdvertisement,
				barkerMaximumAdvertisment);
	}
	
	public static CityTreeSettings getSettings()
	{
		return cityTreeSettings;
	}
	
	public enum LevelUpType
	{
		STAFF, //Teammitglieder müssen das Levelup freischalten 
		ALWAYS; //Man kann immer Level uppen
	}
	
	public enum ListType
	{
		BLACKLIST, WHITELIST;
	}

	public static CityTreeSettings getCityTreeSettings()
	{
		return cityTreeSettings;
	}

	public static void setCityTreeSettings(CityTreeSettings cityTreeSettings)
	{
		CityTreeSettings.cityTreeSettings = cityTreeSettings;
	}

	public CityTree getPlugin()
	{
		return plugin;
	}

	public void setPlugin(CityTree plugin)
	{
		this.plugin = plugin;
	}

	public boolean isCanCreateCity()
	{
		return canCreateCity;
	}

	public void setCanCreateCity(boolean canCreateCity)
	{
		this.canCreateCity = canCreateCity;
	}

	public int getMaximumCitysAmount()
	{
		return maximumCitysAmount;
	}

	public void setMaximumCitysAmount(int maximumCitysAmount)
	{
		this.maximumCitysAmount = maximumCitysAmount;
	}

	public double getTaxation()
	{
		return taxation;
	}

	public void setTaxation(double taxation)
	{
		this.taxation = taxation;
	}

	public LevelUpType getLevelUpType()
	{
		return levelUpType;
	}

	public void setLevelUpType(LevelUpType levelUpType)
	{
		this.levelUpType = levelUpType;
	}

	public ItemStack getCityCreateBlock()
	{
		return cityCreateBlock;
	}

	public void setCityCreateBlock(ItemStack cityCreateBlock)
	{
		this.cityCreateBlock = cityCreateBlock;
	}

	public ArrayList<CityLevel> getCityLevels()
	{
		return cityLevels;
	}

	public void setCityLevels(ArrayList<CityLevel> cityLevels)
	{
		this.cityLevels = cityLevels;
	}

	public ArrayList<CityExtension> getCityExtension()
	{
		return cityExtension;
	}

	public void setCityExtension(ArrayList<CityExtension> cityExtension)
	{
		this.cityExtension = cityExtension;
	}

	public double getDistanceBetweenCities()
	{
		return distanceBetweenCities;
	}

	public void setDistanceBetweenCities(double distanceBetweenCities)
	{
		this.distanceBetweenCities = distanceBetweenCities;
	}

	public Vector getCreateSetting()
	{
		return createSetting;
	}

	public void setCreateSetting(Vector createSetting)
	{
		this.createSetting = createSetting;
	}

	public double getEdgeRatio()
	{
		return edgeRatio;
	}

	public void setEdgeRatio(double edgeRatio)
	{
		this.edgeRatio = edgeRatio;
	}

	public Calculation getTeleportCalculation()
	{
		return teleportCalculation;
	}

	public void setTeleportCalculation(Calculation teleportCalculation)
	{
		this.teleportCalculation = teleportCalculation;
	}

	public int getBaseFreeTeleport()
	{
		return baseFreeTeleport;
	}

	public void setBaseFreeTeleport(int baseFreeTeleport)
	{
		this.baseFreeTeleport = baseFreeTeleport;
	}

	public Calculation getDistrictCalculation()
	{
		return districtCalculation;
	}

	public void setDistrictCalculation(Calculation districtCalculation)
	{
		this.districtCalculation = districtCalculation;
	}

	public int getBaseFreeDistrict()
	{
		return baseFreeDistrict;
	}

	public void setBaseFreeDistrict(int baseFreeDistrict)
	{
		this.baseFreeDistrict = baseFreeDistrict;
	}

	public Calculation getPropertiesCalculation()
	{
		return propertiesCalculation;
	}

	public void setPropertiesCalculation(Calculation propertiesCalculation)
	{
		this.propertiesCalculation = propertiesCalculation;
	}

	public long getMinimumTerminationTime()
	{
		return minimumTerminationTime;
	}

	public void setMinimumTerminationTime(long minimumTerminationTime)
	{
		this.minimumTerminationTime = minimumTerminationTime;
	}

	public LinkedHashMap<Long, Double> getTerminationValue()
	{
		return terminationValue;
	}

	public void setTerminationValue(LinkedHashMap<Long, Double> terminationValue)
	{
		this.terminationValue = terminationValue;
	}

	public int getBaseFreeProperties()
	{
		return baseFreeProperties;
	}

	public void setBaseFreeProperties(int baseFreeProperties)
	{
		this.baseFreeProperties = baseFreeProperties;
	}

	public double getMinimalPropertyVolume()
	{
		return minimalPropertyVolume;
	}

	public void setMinimalPropertyVolume(double minimalPropertyVolume)
	{
		this.minimalPropertyVolume = minimalPropertyVolume;
	}

	public int getMaximumLandLord()
	{
		return maximumLandLord;
	}

	public void setMaximumLandLord(int maximumLandLord)
	{
		this.maximumLandLord = maximumLandLord;
	}

	public int getMaximumRoommate()
	{
		return maximumRoommate;
	}

	public void setMaximumRoommate(int maximumRoommate)
	{
		this.maximumRoommate = maximumRoommate;
	}

	public Calculation getAdvertisementCalculation()
	{
		return advertisementCalculation;
	}

	public void setAdvertisementCalculation(Calculation advertisementCalculation)
	{
		this.advertisementCalculation = advertisementCalculation;
	}

	public double getRentalChargesMulti()
	{
		return rentalChargesMulti;
	}

	public void setRentalChargesMulti(double rentalChargesMulti)
	{
		this.rentalChargesMulti = rentalChargesMulti;
	}

	public int getMaximumZone()
	{
		return maximumZone;
	}

	public void setMaximumZone(int maximumZone)
	{
		this.maximumZone = maximumZone;
	}

	public double getBaseTaxtionPerProperty()
	{
		return baseTaxtionPerProperty;
	}

	public void setBaseTaxtionPerProperty(double baseTaxtionPerProperty)
	{
		this.baseTaxtionPerProperty = baseTaxtionPerProperty;
	}

	public int getBaseFreeAdvertisement()
	{
		return baseFreeAdvertisement;
	}

	public void setBaseFreeAdvertisement(int baseFreeAdvertisement)
	{
		this.baseFreeAdvertisement = baseFreeAdvertisement;
	}

	public int getBarkerMaximumAdvertisment()
	{
		return barkerMaximumAdvertisment;
	}

	public void setBarkerMaximumAdvertisment(int barkerMaximumAdvertisment)
	{
		this.barkerMaximumAdvertisment = barkerMaximumAdvertisment;
	}

	public String getServer()
	{
		return server;
	}

	public void setServer(String server)
	{
		this.server = server;
	}
}
