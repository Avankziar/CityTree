package main.java.de.avankziar.citytree.spigot.listener;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.database.MysqlInterface;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.Barker;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.City;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.District;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.DistrictLord;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.Property;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.GuiUser;

public class EVENTJoin implements Listener
{
	private CityTree plugin;
	
	public EVENTJoin(CityTree plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		ArrayList<Integer> ownCities = new ArrayList<Integer>();
		ArrayList<Integer> barkerFromCity = new ArrayList<Integer>();
		ArrayList<Integer> ownDistricts = new ArrayList<Integer>();
		ArrayList<Integer> ownProperties = new ArrayList<Integer>();
		for(City city : City.allCity)
		{
			int id = city.getId();
			for(Barker barker : city.getBarkers())
			{
				if(barker.getUuid().equals(player.getUniqueId().toString()))
				{
					barkerFromCity.add(id);
				}
			}
			for(String coOwner : city.getCoOwner())
			{
				if(coOwner.equals(player.getUniqueId().toString()))
				{
					ownCities.add(id);
				}
			}
			if(city.getOwner().equals(player.getUniqueId().toString()))
			{
				ownCities.add(id);
			}
		}
		for(District district : District.AllDistrict)
		{
			for(DistrictLord dl : district.getDistrictLord())
			{
				if(dl.getUuid().equals(player.getUniqueId().toString()))
				{
					ownDistricts.add(district.getId());
				}
			}
		}
		for(Property property : Property.AllProperties)
		{
			if(property.getSupremelandlord().equals(player.getUniqueId().toString()))
			{
				ownProperties.add(property.getId());
			}
			for(String s : property.getLandlord())
			{
				if(s.equals(player.getUniqueId().toString()))
				{
					ownProperties.add(property.getId());
				}
			}
			for(String s : property.getRoommate())
			{
				if(s.equals(player.getUniqueId().toString()))
				{
					ownProperties.add(property.getId());
				}
			}
		}
		GuiUser guiUser = (GuiUser) plugin.getMysqlInterface()
				.getData(MysqlInterface.Type.PLAYER, player.getUniqueId().toString());
		guiUser.setBarkerFromCity(barkerFromCity);
		guiUser.setOwnCities(ownCities);
		guiUser.setOwnDisticts(ownDistricts);
		guiUser.setOwnProperties(ownProperties);
		GuiUser.allGuiUser.add(guiUser);
	}
}
