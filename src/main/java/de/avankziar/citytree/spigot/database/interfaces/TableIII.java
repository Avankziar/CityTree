package main.java.de.avankziar.citytree.spigot.database.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.Property;
import main.java.de.avankziar.citytree.spigot.interfaces.settings.CityTreeSettings;

public interface TableIII
{
	default boolean existIII(CityTree plugin, Object object) 
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT `id` FROM `" + plugin.getMysqlInterface().tableNameIII
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
	
	default boolean createIII(CityTree plugin, Object object) 
	{
		if(!(object instanceof Property))
		{
			return false;
		}
		Property p = (Property) object;
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) {
			try 
			{
				String sql = "INSERT INTO `" + plugin.getMysqlInterface().tableNameIII
						+ "`(`idcity`, `iddistrict`, `name`, `status`, `newstatus`, `securitylevel`," 
						+ " `supremelandlord`, `landlord`, `roommate`, `location_first`, `location_second`," 
						+ " `warp`, `rentprice`, `buyprice`, `newprice`, `minimumrenttime`,"
						+ " `vacanttime`, `renttime`, `debts`, `restoration`, `zones`,"
						+ " `listtype`, `blacklist`, `whitelist`) " 
						+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
				preparedStatement = conn.prepareStatement(sql);
		        preparedStatement.setInt(1, p.getIdcity());
		        preparedStatement.setInt(2, p.getIddistrict());
		        preparedStatement.setString(3, p.getName());
		        preparedStatement.setString(4, p.getStatus().name());
		        preparedStatement.setString(5, p.getNewStatus().name());
		        preparedStatement.setString(6, p.getSecurityLevel().name());
		        preparedStatement.setString(7, p.getSupremelandlord());
		        preparedStatement.setString(8, plugin.getInterfaceConverter().getArrayStringCoding(p.getLandlord()));
		        preparedStatement.setString(9, plugin.getInterfaceConverter().getArrayStringCoding(p.getRoommate()));
		        preparedStatement.setString(10, plugin.getInterfaceConverter().getLocationCoding(p.getFirst()));
		        preparedStatement.setString(11, plugin.getInterfaceConverter().getLocationCoding(p.getSecond()));
		        preparedStatement.setInt(12, p.getWarp());
		        preparedStatement.setDouble(13, p.getRentprice());
		        preparedStatement.setDouble(14, p.getBuyprice());
		        preparedStatement.setDouble(15, p.getNewprice());
		        preparedStatement.setLong(16, p.getMinimumrenttime());
		        preparedStatement.setLong(17, p.getVacanttime());
		        preparedStatement.setLong(18, p.getRenttime());
		        preparedStatement.setDouble(19, p.getDebts());
		        preparedStatement.setString(20, p.getRestoration());
		        preparedStatement.setString(21, plugin.getInterfaceConverter().getIntArrayCoding(p.getZones()));
		        preparedStatement.setString(22, p.getListType().name());
		        preparedStatement.setString(23, plugin.getInterfaceConverter().getArrayStringCoding(p.getBlackList()));
		        preparedStatement.setString(24, plugin.getInterfaceConverter().getArrayStringCoding(p.getWhiteList()));
		        
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
	
	default boolean updateDataIII(CityTree plugin, Object object) 
	{
		if(!(object instanceof Property))
		{
			return false;
		}
		Property p = (Property) object;
		PreparedStatement preparedUpdateStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{
				String data = "UPDATE `" + plugin.getMysqlInterface().tableNameIII
						+ "` SET `idcity` = ?, `iddistrict` = ?, `name` = ?, `status` = ?, `newstatus` = ?, `securitylevel` = ?,"
						+ " `supremelandlord` = ?, `landlord` = ?, `roommate` = ?, `location_first` = ?, `location_second` = ?,"
						+ " `warp` = ?, `rentprice` = ?, `buyprice` = ?, `newprice` = ?, `minimumrenttime` = ?,"
						+ " `vacanttime` = ?, `renttime` = ?, `debts` = ?, `restoration` = ?, `zones` = ?,"
						+ " `listtype` = ?, `blacklist` = ?, `whitelist` = ?" 
						+ " WHERE `id` = ?";
				preparedUpdateStatement = conn.prepareStatement(data);
				preparedUpdateStatement.setInt(1, p.getIdcity());
				preparedUpdateStatement.setInt(2, p.getIddistrict());
				preparedUpdateStatement.setString(3, p.getName());
				preparedUpdateStatement.setString(4, p.getStatus().name());
				preparedUpdateStatement.setString(5, p.getNewStatus().name());
				preparedUpdateStatement.setString(6, p.getSecurityLevel().name());
				preparedUpdateStatement.setString(7, p.getSupremelandlord());
				preparedUpdateStatement.setString(8, plugin.getInterfaceConverter().getArrayStringCoding(p.getLandlord()));
				preparedUpdateStatement.setString(9, plugin.getInterfaceConverter().getArrayStringCoding(p.getRoommate()));
				preparedUpdateStatement.setString(10, plugin.getInterfaceConverter().getLocationCoding(p.getFirst()));
				preparedUpdateStatement.setString(11, plugin.getInterfaceConverter().getLocationCoding(p.getSecond()));
				preparedUpdateStatement.setInt(12, p.getWarp());
				preparedUpdateStatement.setDouble(13, p.getRentprice());
				preparedUpdateStatement.setDouble(14, p.getBuyprice());
				preparedUpdateStatement.setDouble(15, p.getNewprice());
				preparedUpdateStatement.setLong(16, p.getMinimumrenttime());
				preparedUpdateStatement.setLong(17, p.getVacanttime());
				preparedUpdateStatement.setLong(18, p.getRenttime());
				preparedUpdateStatement.setDouble(19, p.getDebts());
				preparedUpdateStatement.setString(20, p.getRestoration());
				preparedUpdateStatement.setString(21, plugin.getInterfaceConverter().getIntArrayCoding(p.getZones()));
				preparedUpdateStatement.setString(22, p.getListType().name());
				preparedUpdateStatement.setString(23, plugin.getInterfaceConverter().getArrayStringCoding(p.getBlackList()));
				preparedUpdateStatement.setString(24, plugin.getInterfaceConverter().getArrayStringCoding(p.getWhiteList()));
				preparedUpdateStatement.setInt(25, p.getId());
				
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
	
	default Object getDataIII(CityTree plugin, Object object)
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT * FROM `" + plugin.getMysqlInterface().tableNameIII
						+ "` WHERE `id` = ? LIMIT 1";
		        preparedUpdateStatement = conn.prepareStatement(sql);
		        preparedUpdateStatement.setInt(1, (int) object);
		        
		        result = preparedUpdateStatement.executeQuery();
		        while (result.next()) 
		        {
		        	return new Property(result.getInt("idcity"), result.getInt("iddistrict"), (int) object,
		        			result.getString("name"), Property.Status.valueOf(result.getString("status")),
		        			Property.Status.valueOf(result.getString("newstatus")), 
		        			Property.SecurityLevel.valueOf(result.getString("securitylevel")),
		        			result.getString("supremelandlord"), 
		        			plugin.getInterfaceConverter().getArrayStringEncoding(result.getString("landlord")),
		        			plugin.getInterfaceConverter().getArrayStringEncoding(result.getString("roommate")), 
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location_first")),
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location_second")),
		        			result.getInt("warp"), result.getDouble("rentprice"), result.getDouble("buyprice"),
		        			result.getDouble("newprice"), result.getLong("minimumrenttime"), result.getLong("vacanttime"),
		        			result.getLong("renttime"), result.getDouble("debts"), 
		        			result.getString("restoration"), 
		        			plugin.getInterfaceConverter().getIntArrayEncoding(result.getString("zones")), 
		        			CityTreeSettings.ListType.valueOf(result.getString("listtype")),
		        			plugin.getInterfaceConverter().getArrayStringEncoding(result.getString("blacklist")),
		        			plugin.getInterfaceConverter().getArrayStringEncoding(result.getString("whitelist")));
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
	
	default boolean deleteDataIII(CityTree plugin, Object object)
	{
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		try 
		{
			String sql = "DELETE FROM `" + plugin.getMysqlInterface().tableNameIII + "` WHERE `id` = ?";
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
