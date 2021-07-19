package main.java.de.avankziar.citytree.spigot.database.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Material;
import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.City;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.City.SecurityLevel;
import main.java.de.avankziar.citytree.spigot.interfaces.settings.CityTreeSettings.ListType;

public interface TableI
{	
	default boolean existI(CityTree plugin, Object object) 
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT `id` FROM `" + plugin.getMysqlInterface().tableNameI 
						+ "` WHERE `id` = ? LIMIT 1";
		        preparedUpdateStatement = conn.prepareStatement(sql);
		        preparedUpdateStatement.setObject(1, object);
		        
		        result = preparedUpdateStatement.executeQuery();
		        while (result.next()) 
		        {
		        	return true;
		        }
		    } catch (SQLException e) 
			{
				  CityTree.log.warning("Error: " + e.getMessage());
				  e.printStackTrace();
		    } finally 
			{
		    	  try 
		    	  {
		    		  if (result != null) 
		    		  {
		    			  result.close();
		    		  }
		    		  if (preparedUpdateStatement != null) 
		    		  {
		    			  preparedUpdateStatement.close();
		    		  }
		    	  } catch (Exception e) {
		    		  e.printStackTrace();
		    	  }
		      }
		}
		return false;
	}
	
	default boolean createI(CityTree plugin, Object object) 
	{
		if(!(object instanceof City))
		{
			return false;
		}
		City c = (City) object;
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) {
			try 
			{
				String sql = "INSERT INTO `" + plugin.getMysqlInterface().tableNameI 
						+ "`(`city_name`, `lore`, `creator`, `owner`," + 
						" `city_level`, `securitylevel`, `location_center`, `location_first`, `location_second`," + 
						" `district`, `property`, `teleportslocation`, `city_extension`," + 
						" `createtime`, `coowner`, `districtlord`, `totalcost`, `stockpile`, `icon`," + 
						" `barker`, `advertisement`, `canlevelup`, `listtype`, `blacklist`," + 
						" `whitelist`, `currentlydistrictamount`, `currentlypropertytamount`," + 
						" `currentlyteleportamount`, `currentlyadvertisementamount`, `debts`) " 
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				preparedStatement = conn.prepareStatement(sql);
		        preparedStatement.setString(1, c.getName());
		        preparedStatement.setString(2, plugin.getInterfaceConverter().getArrayStringCoding(c.getLore()));
		        preparedStatement.setString(3, c.getCreator());
		        preparedStatement.setString(4, c.getOwner());
		        preparedStatement.setInt(5, c.getCityLevel());
		        preparedStatement.setString(6, c.getSecurityLevel().name());
		        preparedStatement.setString(7, plugin.getInterfaceConverter().getLocationCoding(c.getCenter()));
		        preparedStatement.setString(8, plugin.getInterfaceConverter().getLocationCoding(c.getFirst()));
		        preparedStatement.setString(9, plugin.getInterfaceConverter().getLocationCoding(c.getSecond()));
		        preparedStatement.setString(10, plugin.getInterfaceConverter().getIntArrayCoding(c.getDistricts()));
		        preparedStatement.setString(11, plugin.getInterfaceConverter().getIntArrayCoding(c.getProperties()));
		        preparedStatement.setString(12, plugin.getInterfaceConverter().getIntArrayCoding(c.getTeleportLocations()));
		        preparedStatement.setString(13, plugin.getInterfaceConverter().getTypeArrayCoding(c.getCityExtension()));
		        preparedStatement.setLong(14, c.getCreateTime());
		        preparedStatement.setString(15, plugin.getInterfaceConverter().getArrayStringCoding(c.getCoOwner()));
		        preparedStatement.setString(16, plugin.getInterfaceConverter().getDistrictLordArrayCoding(c.getDistrictLords()));
		        preparedStatement.setString(17, plugin.getInterfaceConverter().getCostCoding(c.getTotalCost()));
		        preparedStatement.setString(18, plugin.getInterfaceConverter().getStockPileCoding(c.getStockPile()));
		        preparedStatement.setString(19, c.getIcon().name());
		        preparedStatement.setString(20, plugin.getInterfaceConverter().getBarkerArrayCoding(c.getBarkers()));
		        preparedStatement.setString(21, plugin.getInterfaceConverter().getArrayStringCoding(c.getAdvertisement()));
		        preparedStatement.setBoolean(22, c.isCanLevelUp());
		        preparedStatement.setString(23, c.getListType().name());
		        preparedStatement.setString(24, plugin.getInterfaceConverter().getArrayStringCoding(c.getBlackList()));
		        preparedStatement.setString(25, plugin.getInterfaceConverter().getArrayStringCoding(c.getWhiteList()));
		        preparedStatement.setInt(26, c.getCurrentlyDistrictAmount());
		        preparedStatement.setInt(27, c.getCurrentlyPropertyAmount());
		        preparedStatement.setInt(28, c.getCurrentlyTeleportAmount());
		        preparedStatement.setInt(29, c.getCurrentlyAdvertisementAmount());
		        preparedStatement.setDouble(30, c.getDebts());
		        
		        preparedStatement.executeUpdate();
		        return true;
		    } catch (SQLException e) 
			{
				  CityTree.log.warning("Error: " + e.getMessage());
				  e.printStackTrace();
		    } finally 
			{
		    	  try 
		    	  {
		    		  if (preparedStatement != null) 
		    		  {
		    			  preparedStatement.close();
		    		  }
		    	  } catch (Exception e) 
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }
		}
		return false;
	}
	
	default boolean updateDataI(CityTree plugin, Object object) 
	{
		if(!(object instanceof City))
		{
			return false;
		}
		City c = (City) object;
		PreparedStatement preparedUpdateStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{
				String data = "UPDATE `" + plugin.getMysqlInterface().tableNameI
						+ "` SET `city_name` = ?, `lore` = ?, `creator` = ?, `owner` = ?,"
						+ " `city_level` = ?, `securitylevel` = ?, `location_center` = ?,"
						+ " `location_first` = ?, `location_second` = ?,"
						+ " `district` = ?, `property` = ?, `teleportslocation` = ?, `city_extension` = ?,"
						+ " `createtime` = ?, `coowner` = ?, `districtlord` = ?, `totalcost` = ?, `stockpile` = ?,"
						+ " `icon` = ?,"
						+ " `barker` = ?, `advertisement` = ?, `canlevelup` = ?, `listtype` = ?, `blacklist` = ?,"
						+ " `whitelist` = ?, `currentlydistrictamount` = ?, `currentlypropertytamount` = ?,"
						+ " `currentlyteleportamount` = ?, `currentlyadvertisementamount` = ?, `debts` = ?" 
						+ " WHERE `id` = ?";
				preparedUpdateStatement = conn.prepareStatement(data);
				preparedUpdateStatement.setString(1, c.getName());
				preparedUpdateStatement.setString(2, plugin.getInterfaceConverter().getArrayStringCoding(c.getLore()));
				preparedUpdateStatement.setString(3, c.getCreator());
				preparedUpdateStatement.setString(4, c.getOwner());
				preparedUpdateStatement.setInt(5, c.getCityLevel());
				preparedUpdateStatement.setString(6, c.getSecurityLevel().name());
				preparedUpdateStatement.setString(7, plugin.getInterfaceConverter().getLocationCoding(c.getCenter()));
				preparedUpdateStatement.setString(8, plugin.getInterfaceConverter().getLocationCoding(c.getFirst()));
				preparedUpdateStatement.setString(9, plugin.getInterfaceConverter().getLocationCoding(c.getSecond()));
				preparedUpdateStatement.setString(10, plugin.getInterfaceConverter().getIntArrayCoding(c.getDistricts()));
				preparedUpdateStatement.setString(11, plugin.getInterfaceConverter().getIntArrayCoding(c.getProperties()));
				preparedUpdateStatement.setString(12, plugin.getInterfaceConverter().getIntArrayCoding(c.getTeleportLocations()));
				preparedUpdateStatement.setString(13, plugin.getInterfaceConverter().getTypeArrayCoding(c.getCityExtension()));
				preparedUpdateStatement.setLong(14, c.getCreateTime());
				preparedUpdateStatement.setString(15, plugin.getInterfaceConverter().getArrayStringCoding(c.getCoOwner()));
				preparedUpdateStatement.setString(16, plugin.getInterfaceConverter().getDistrictLordArrayCoding(c.getDistrictLords()));
				preparedUpdateStatement.setString(17, plugin.getInterfaceConverter().getCostCoding(c.getTotalCost()));
				preparedUpdateStatement.setString(18, plugin.getInterfaceConverter().getStockPileCoding(c.getStockPile()));
				preparedUpdateStatement.setString(19, c.getIcon().name());
				preparedUpdateStatement.setString(20, plugin.getInterfaceConverter().getBarkerArrayCoding(c.getBarkers()));
				preparedUpdateStatement.setString(21, plugin.getInterfaceConverter().getArrayStringCoding(c.getAdvertisement()));
				preparedUpdateStatement.setBoolean(22, c.isCanLevelUp());
				preparedUpdateStatement.setString(23, c.getListType().name());
				preparedUpdateStatement.setString(24, plugin.getInterfaceConverter().getArrayStringCoding(c.getBlackList()));
				preparedUpdateStatement.setString(25, plugin.getInterfaceConverter().getArrayStringCoding(c.getWhiteList()));
				preparedUpdateStatement.setInt(26, c.getCurrentlyDistrictAmount());
				preparedUpdateStatement.setInt(27, c.getCurrentlyPropertyAmount());
				preparedUpdateStatement.setInt(28, c.getCurrentlyTeleportAmount());
				preparedUpdateStatement.setInt(29, c.getCurrentlyAdvertisementAmount());
				preparedUpdateStatement.setDouble(30, c.getDebts());
				preparedUpdateStatement.setInt(31, c.getId());
				
				preparedUpdateStatement.executeUpdate();
				return true;
			} catch (SQLException e) {
				CityTree.log.warning("Error: " + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (preparedUpdateStatement != null) {
						preparedUpdateStatement.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
        return false;
	}
	
	default Object getDataI(CityTree plugin, Object object)
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT * FROM `" + plugin.getMysqlInterface().tableNameI 
						+ "` WHERE `id` = ? LIMIT 1";
		        preparedUpdateStatement = conn.prepareStatement(sql);
		        preparedUpdateStatement.setInt(1, (int) object);
		        
		        result = preparedUpdateStatement.executeQuery();
		        while (result.next()) 
		        {
		        	return new City((int) object, result.getString("city_name"), 
		        			plugin.getInterfaceConverter().getArrayStringEncoding(result.getString("lore")),
		        			Material.valueOf(result.getString("icon")), result.getString("creator"), 
		        			result.getString("owner"), result.getInt("city_level"),
		        			SecurityLevel.valueOf(result.getString("securitylevel")),
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location_center")), 
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location_first")), 
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location_second")), 
		        			plugin.getInterfaceConverter().getIntArrayEncoding(result.getString("district")), 
		        			plugin.getInterfaceConverter().getIntArrayEncoding(result.getString("property")), 
		        			plugin.getInterfaceConverter().getIntArrayEncoding(result.getString("teleportslocation")), 
		        			plugin.getInterfaceConverter().getTypeArrayEncoding(result.getString("city_extension")), 
		        			Long.parseLong(result.getString("createtime")), 
		        			plugin.getInterfaceConverter().getArrayStringEncoding(result.getString("coowner")), 
		        			plugin.getInterfaceConverter().getDistrictLordArrayEncoding(result.getString("districtlord")), 
		        			plugin.getInterfaceConverter().getCostEncoding(result.getString("totalcost")), 
		        			plugin.getInterfaceConverter().getStockPileEncoding(result.getString("stockpile")), 
		        			plugin.getInterfaceConverter().getBarkerArrayEncoding(result.getString("barker")), 
		        			plugin.getInterfaceConverter().getArrayStringEncoding(result.getString("advertisement")), 
		        			result.getBoolean("canlevelup"), ListType.valueOf(result.getString("listtype")), 
		        			plugin.getInterfaceConverter().getArrayStringEncoding(result.getString("blacklist")), 
		        			plugin.getInterfaceConverter().getArrayStringEncoding(result.getString("whitelist")), 
		        			result.getInt("currentlydistrictamount"), result.getInt("currentlypropertyamount"), 
		        			result.getInt("currentlyteleportamount"), result.getInt("currentlyadvertisementamount"), 
		        			result.getDouble("debts"));
		        }
		    } catch (SQLException e) 
			{
				  CityTree.log.warning("Error: " + e.getMessage());
				  e.printStackTrace();
		    } finally 
			{
		    	  try 
		    	  {
		    		  if (result != null) 
		    		  {
		    			  result.close();
		    		  }
		    		  if (preparedUpdateStatement != null) 
		    		  {
		    			  preparedUpdateStatement.close();
		    		  }
		    	  } catch (Exception e) {
		    		  e.printStackTrace();
		    	  }
		      }
		}
		return null;
	}
	
	default boolean deleteDataI(CityTree plugin, Object object)
	{
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		try 
		{
			String sql = "DELETE FROM `" + plugin.getMysqlInterface().tableNameI + "` WHERE `id` = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setObject(1, object);
			preparedStatement.execute();
			return true;
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			try {
				if (preparedStatement != null) 
				{
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
