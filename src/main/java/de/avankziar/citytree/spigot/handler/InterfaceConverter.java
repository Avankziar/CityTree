package main.java.de.avankziar.citytree.spigot.handler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.Barker;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.CityExtension;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.CityLevel;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.CityStockpile;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.DistrictLord;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.ZoneLord;
import main.java.de.avankziar.citytree.spigot.interfaces.settings.Cost;

public class InterfaceConverter
{
	private CityTree plugin;
	//alt + 230 = µ
	//alt + 506 = ·
	//alt + 519 = •
	//alt + 542 = ▲
	public InterfaceConverter(CityTree plugin)
	{
		this.plugin = plugin;
	}
	
	public String getArrayStringCoding(ArrayList<String> array)
	{
		
		String a = "";
		for(String s : array)
		{
			a += s+"µ";
		}
		return a.substring(0,a.length()-1);
	}
	
	public ArrayList<String> getArrayStringEncoding(String s)
	{
		ArrayList<String> array = new ArrayList<>();
		String[] a = s.split("µ");
		for(String b : a)
		{
			array.add(b);
		}
		return array;
	}
	
	public String getLocationCoding(Location loc)
	{
		if(loc == null)
		{
			return "none";
		}
		String worldname = loc.getWorld().getName();
		double X = loc.getX();
		double Y = loc.getY();
		double Z = loc.getZ();
		float Yaw = loc.getYaw();
		float Pitch = loc.getPitch();
		String s =  worldname+","+X+","+Y+","+Z+","+Yaw+","+Pitch;
		return s;
	}
	
	public Location getLocationEncoding(String s)
	{
		if(s.equals("none"))
		{
			return null;
		}
		String[] dataArray = s.split(",");
		String worldName = dataArray[0];
		double x = Double.parseDouble(dataArray[1]);
		double y = Double.parseDouble(dataArray[2]);
		double z = Double.parseDouble(dataArray[3]);
		float yaw = Float.parseFloat(dataArray[4]);
		float pitch = Float.parseFloat(dataArray[5]);
		Location loc = new Location(Bukkit.getWorld(worldName),x,y,z,yaw,pitch);
		return loc;
	}
	
	public String getIntArrayCoding(ArrayList<Integer> array)
	{
		String a = "";
		for(int i : array)
		{
			a += i+"µ";
		}
		return a.substring(0,a.length()-1);
	}
	
	public ArrayList<Integer> getIntArrayEncoding(String s)
	{
		ArrayList<Integer> array = new ArrayList<>();
		String[] a = s.split("µ");
		for(String b : a)
		{
			array.add(Integer.parseInt(b));
		}
		return array;
	}
	
	public String getTypeArrayCoding(ArrayList<CityExtension.Type> array)
	{
		String a = "";
		for(CityExtension.Type t : array)
		{
			a += t+"µ";
		}
		return a.substring(0,a.length()-1);
	}
	
	public ArrayList<CityExtension.Type> getTypeArrayEncoding(String s)
	{
		ArrayList<CityExtension.Type> array = new ArrayList<>();
		String[] a = s.split("µ");
		for(String b : a)
		{
			array.add(CityExtension.Type.valueOf(b));
		}
		return array;
	}
	
	public String getDistrictLordArrayCoding(ArrayList<DistrictLord> array)
	{
		String a = "";
		for(DistrictLord t : array)
		{
			a += t.getUuid()+"µ"+t.getSalary()+"µ"+t.getCooldown()+"·";
			for(int i : t.getDistrict())
			{
				a += i+"µ";
			}
			a.substring(0,a.length()-1);
			a += "•";
		}
		return a.substring(0,a.length()-1);
	}
	
	public ArrayList<DistrictLord> getDistrictLordArrayEncoding(String s)
	{
		ArrayList<DistrictLord> array = new ArrayList<>();
		ArrayList<Integer> districts = new ArrayList<>();
		String[] a = s.split("•");
		for(String z : a)
		{
			String[] b = z.split("·");
			String[] c = b[0].split("µ");
			String[] d = b[1].split("µ");
			
			for(String e : d)
			{
				districts.add(Integer.parseInt(e));
			}
			array.add(new DistrictLord(c[0], districts, Double.parseDouble(c[1]), Long.parseLong(c[2])));
		}
		return array;
	}
	
	public String getCostCoding(Cost cost)
	{
		String a = "";
		a += cost.getmoneyCost()+"µ"+cost.getexpCost()+"·";
		for(Material mat : cost.getmaterialCost().keySet())
		{
			a += mat.name()+"•"+cost.getmaterialCost().get(mat)+"µ";
		}
		return a.substring(0,a.length()-1);
	}
	
	public Cost getCostEncoding(String s)
	{
		String[] a = s.split("·");
		String[] b = a[0].split("µ");
		String[] c = a[1].split("µ");
		LinkedHashMap<Material, Double> materialCost = new LinkedHashMap<>();
		for(String d : c)
		{
			String[] e = d.split("•");
			materialCost.put(Material.valueOf(e[0]), Double.parseDouble(e[1]));
		}
		return new Cost(Double.parseDouble(b[0]), materialCost, Integer.parseInt(b[1]));
	}
	
	public String getStockPileCoding(CityStockpile stockPile)
	{
		String a = "";
		a += stockPile.getBankAccount()+"µ"+stockPile.getPlayerexp()+"µ";
		for(Material mat : stockPile.getItemsIst().keySet())
		{
			a += mat.name()+"·"+stockPile.getItemsIst().get(mat)+"•";
		}
		a = a.substring(0,a.length()-1);
		a += "µ";
		for(Material mat : stockPile.getItemsSoll().keySet())
		{
			a += mat.name()+"·"+stockPile.getItemsSoll().get(mat)+"•";
		}
		return a.substring(0,a.length()-1);
	}
	
	public CityStockpile getStockPileEncoding(String s)
	{
		String[] a = s.split("µ");
		LinkedHashMap<Material, Double> itemIst = new LinkedHashMap<>();
		LinkedHashMap<Material, Double> itemSoll = new LinkedHashMap<>();
		String[] b = a[2].split("•");
		String[] c = a[3].split("•");
		for(String d : b)
		{
			String[] e = d.split("·");
			itemIst.put(Material.valueOf(e[0]), Double.parseDouble(e[1]));
		}
		for(String d : c)
		{
			String[] e = d.split("·");
			itemSoll.put(Material.valueOf(e[0]), Double.parseDouble(e[1]));
		}
		return new CityStockpile(Double.parseDouble(a[0]), itemIst, itemSoll, Integer.parseInt(a[1]));
	}
	
	public String getBarkerArrayCoding(ArrayList<Barker> array)
	{
		String a = "";
		for(Barker t : array)
		{
			a += t.getUuid()+"µ"+t.getUsage()+"µ"+t.getAlreadyUsed()+"µ"+t.getSalary()+"µ"+t.getCooldown()+"·";
		}
		return a.substring(0,a.length()-1);
	}
	
	public ArrayList<Barker> getBarkerArrayEncoding(String s)
	{
		ArrayList<Barker> array = new ArrayList<>();
		String[] a = s.split("·");
		for(String b : a)
		{
			String[] c = b.split("µ");
			array.add(new Barker(c[0], Integer.parseInt(c[1]), Integer.parseInt(c[2]),
					Double.parseDouble(c[3]), Long.parseLong(c[4])));
		}
		return array;
	}
	
	public String getZoneLordCoding(ArrayList<ZoneLord> array)
	{
		String a = "";
		for(ZoneLord zl : array)
		{
			a += zl.getUuid()+"µ";
			for(int i : zl.getZone())
			{
				a += i+"·";
			}
			a.substring(0,a.length()-1);
			a += "•";
		}
		return a.substring(0,a.length()-1);
	}
	
	public ArrayList<ZoneLord> getZoneLordEncoding(String s)
	{
		ArrayList<ZoneLord> array = new ArrayList<>();
		String[] a = s.split("•");
		for(String b : a)
		{
			String[] c = b.split("µ");
			String[] d = c[1].split("·");
			ArrayList<Integer> zone = new ArrayList<>();
			for(String e : d)
			{
				zone.add(Integer.parseInt(e));
			}
			array.add(new ZoneLord(c[0], zone));
		}
		return array;
	}
	
	public ArrayList<CityLevel> getCityLevels()
	{
		YamlConfiguration yml = plugin.getYamlHandler().get();
		String ID = "city";
		ArrayList<CityLevel> list = new ArrayList<>();
		int i = 0;
		while(i<Integer.MAX_VALUE)
		{
			int level = i;
			//----------
			if(yml.get(ID+".levelsReplacer.level"+i)==null)
			{
				break;
			}
			String name = yml.getString(ID+".levelsReplacer.level"+i);
			//----------
			if(yml.get(ID+".levelsCost.level"+i)==null)
			{
				break;
			}
			double moneyCost = 0.0;
			int expCost = 0;
			LinkedHashMap<Material, Double> materialCost = new LinkedHashMap<Material, Double>();
			ArrayList<CityExtension.Type> neededCityExtension = new ArrayList<>();
			for(String st : yml.getStringList(ID+".levelsCost.level"+i))
			{
				if(st.contains(";"))
				{
					String[] s = st.split(";");
					if(s[0].equalsIgnoreCase("money"))
					{
						moneyCost = Double.parseDouble(s[1]);
					} else if(s[0].equalsIgnoreCase("exp"))
					{
						expCost = Integer.parseInt(s[1]);
					} else if(s[0].equalsIgnoreCase("extension")) 
					{
						CityExtension.Type type = CityExtension.Type.valueOf(s[1]);
						neededCityExtension.add(type);
					} else
					{
						Material mat = Material.valueOf(s[0]);
						double a = Double.parseDouble(s[1]);
						materialCost.put(mat, a);
					}
				}
			}
			Cost costs = new Cost(moneyCost, materialCost, expCost);
			//---------
			double maximumArea = 0.0;
			if(yml.get(ID+".expansions.maxarea.level"+i)==null)
			{
				break;
			}
			double d = Double.parseDouble(yml.getString(ID+".expansions.maxarea.level"+i));
			if(d==-1.0)
			{
				maximumArea = Double.MAX_VALUE;
			} else
			{
				maximumArea = d;
			}
			if(yml.get(ID+".expansions.costPerBlock.level"+i)==null)
			{
				break;
			}
			double money = 0.0;
			int exp = 0;
			LinkedHashMap<Material, Double> materials = new LinkedHashMap<Material, Double>();
			for(String st : yml.getStringList(ID+".expansions.costPerBlock.level"+i))
			{
				if(st.contains(";"))
				{
					String[] s = st.split(";");
					if(s[0].equalsIgnoreCase("money"))
					{
						money = Double.parseDouble(s[1]);
					} else if(s[0].equalsIgnoreCase("exp"))
					{
						exp = Integer.parseInt(s[1]);
					} else
					{
						Material mat = Material.valueOf(s[0]);
						double a = Double.parseDouble(s[1]);
						materials.put(mat, a);
					}
				}
			}
			Cost costPerBlock = new Cost(money, materials, exp);
			//----------
			if(yml.get(ID+".availableextensions.level"+i)==null)
			{
				break;
			}
			ArrayList<CityExtension.Type> availableCityExtension = new ArrayList<CityExtension.Type>();
			for(String s : yml.getStringList(ID+".availableextensions.level"+i))
			{
				if(CityExtension.Type.valueOf(s)!=null)
				{
					availableCityExtension.add(CityExtension.Type.valueOf(s));
				}
			}
			//---------
			List<CityExtension.Type> extensionsCosts = new ArrayList<CityExtension.Type>(EnumSet.allOf(CityExtension.Type.class));
			ArrayList<CityExtension> cityExtensionCost = new ArrayList<CityExtension>();
			for(CityExtension.Type cet : extensionsCosts)
			{
				if(yml.getString(ID+".extensionsCosts."+cet.name())!=null)
				{
					String namecet = cet.name();
					if(yml.get(ID+".extensionReplacer"+cet.name())!=null)
					{
						namecet = yml.getString(ID+".extensionReplacer."+cet.name());
					}
					double moneycet = 0.0;
					int expcet = 0;
					LinkedHashMap<Material, Double> materialscet = new LinkedHashMap<Material, Double>();
					for(String st : yml.getStringList(ID+".extensionsCosts."+cet.name()))
					{
						if(st.contains(";"))
						{
							String[] s = st.split(";");
							if(s[0].equalsIgnoreCase("money"))
							{
								moneycet = Double.parseDouble(s[1]);
							} else if(s[0].equalsIgnoreCase("exp"))
							{
								expcet = Integer.parseInt(s[1]);
							} else
							{
								Material mat = Material.valueOf(s[0]);
								double a = Double.parseDouble(s[1]);
								materialscet.put(mat, a);
							}
							CityExtension ce = new CityExtension(namecet, cet, new Cost(moneycet, materialscet, expcet));
							cityExtensionCost.add(ce);
						}
					}
				}
			}
			//--------
			int maximumAdvertisement = 0;
			if(yml.get(ID+".maxadvertisement.level"+i)==null)
			{
				break;
			}
			maximumAdvertisement = Integer.parseInt(yml.getString(ID+".maxadvertisement.level"+i));
			//--------
			if(yml.get(ID+".teleports.maximumAmount.level"+i)==null)
			{
				break;
			}
			int maximumTeleports = Integer.parseInt(yml.getString(ID+".teleports.maximumAmount.level"+i));
			if(yml.get(ID+".districts.maximumAmount.level"+i)==null)
			{
				break;
			}
			int maximumDistricts = Integer.parseInt(yml.getString(ID+".districts.maximumAmount.level"+i));
			if(yml.get(ID+".properties.maximumAmount.level"+i)==null)
			{
				break;
			}
			int maximumProperties = Integer.parseInt(yml.getString(ID+".properties.maximumAmount.level"+i));
			//---------
			CityLevel cl = new CityLevel(name, level, costs, neededCityExtension, availableCityExtension,
					maximumDistricts, maximumProperties, maximumTeleports, maximumArea, maximumAdvertisement,
					costPerBlock);
			list.add(cl);
			i++;
		}
		return list;
	}
	
	public ArrayList<CityExtension> getCityExtension()
	{
		return null;
	}

}
