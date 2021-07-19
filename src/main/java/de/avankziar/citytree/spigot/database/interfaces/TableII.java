package main.java.de.avankziar.citytree.spigot.database.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.District;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.District.SecurityLevel;

public interface TableII
{
	default boolean existII(CityTree plugin, Object object) 
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT `id` FROM `" + plugin.getMysqlInterface().tableNameII
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
	
	default boolean createII(CityTree plugin, Object object) 
	{
		if(!(object instanceof District))
		{
			return false;
		}
		District d = (District) object;
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) {
			try 
			{
				String sql = "INSERT INTO `" + plugin.getMysqlInterface().tableNameII
						+ "`(`idcity`, `name`, `districtlord`, `location_first`, `location_second`,"
						+ " `securitylevel`, `districtproperties`) " 
						+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
				preparedStatement = conn.prepareStatement(sql);
		        preparedStatement.setInt(1, d.getIdcity());
		        preparedStatement.setString(2, d.getName());
		        preparedStatement.setString(3, plugin.getInterfaceConverter().getDistrictLordArrayCoding(d.getDistrictLord()));
		        preparedStatement.setString(4, plugin.getInterfaceConverter().getLocationCoding(d.getFirst()));
		        preparedStatement.setString(5, plugin.getInterfaceConverter().getLocationCoding(d.getSecond()));
		        preparedStatement.setString(6, d.getSecurityLevel().name());
		        preparedStatement.setString(7, plugin.getInterfaceConverter().getIntArrayCoding(d.getDistricproperties()));
		        
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
	
	default boolean updateDataII(CityTree plugin, Object object) 
	{
		if(!(object instanceof District))
		{
			return false;
		}
		District d = (District) object;
		PreparedStatement preparedUpdateStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{
				String data = "UPDATE `" + plugin.getMysqlInterface().tableNameII
						+ "` SET `idcity` = ?, `name` = ?, `districtlord` = ?, `location_first` = ?, `location_second` = ?,"
						+ " `securitylevel` = ?, `districtproperties` = ?" 
						+ " WHERE `id` = ?";
				preparedUpdateStatement = conn.prepareStatement(data);
				preparedUpdateStatement.setInt(1, d.getIdcity());
				preparedUpdateStatement.setString(2, d.getName());
				preparedUpdateStatement.setString(3, plugin.getInterfaceConverter().getDistrictLordArrayCoding(d.getDistrictLord()));
				preparedUpdateStatement.setString(4, plugin.getInterfaceConverter().getLocationCoding(d.getFirst()));
				preparedUpdateStatement.setString(5, plugin.getInterfaceConverter().getLocationCoding(d.getSecond()));
				preparedUpdateStatement.setString(6, d.getSecurityLevel().name());
				preparedUpdateStatement.setString(7, plugin.getInterfaceConverter().getIntArrayCoding(d.getDistricproperties()));
				preparedUpdateStatement.setInt(8, d.getId());
				
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
	
	default Object getDataII(CityTree plugin, Object object)
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT * FROM `" + plugin.getMysqlInterface().tableNameII 
						+ "` WHERE `id` = ? LIMIT 1";
		        preparedUpdateStatement = conn.prepareStatement(sql);
		        preparedUpdateStatement.setInt(1, (int) object);
		        
		        result = preparedUpdateStatement.executeQuery();
		        while (result.next()) 
		        {
		        	return new District(result.getInt("idcity"),
		        			(int) object,
		        			result.getString("name"),
		        			plugin.getInterfaceConverter().getDistrictLordArrayEncoding(result.getString("districtlord")),
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location_first")),
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location_second")),
		        			SecurityLevel.valueOf(result.getString("securitylevel")), 
		        			plugin.getInterfaceConverter().getIntArrayEncoding(result.getString("districtproperties")));
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
	
	default boolean deleteDataII(CityTree plugin, Object object)
	{
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		try 
		{
			String sql = "DELETE FROM `" + plugin.getMysqlInterface().tableNameII + "` WHERE `id` = ?";
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
