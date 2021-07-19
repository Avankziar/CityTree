package main.java.de.avankziar.citytree.spigot.database.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.cities.Zone;

public interface TableIV
{
	default boolean existIV(CityTree plugin, Object object) 
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT `id` FROM `" + plugin.getMysqlInterface().tableNameIV
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
	
	default boolean createIV(CityTree plugin, Object object) 
	{
		if(!(object instanceof Zone))
		{
			return false;
		}
		Zone z = (Zone) object;
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) {
			try 
			{
				String sql = "INSERT INTO `" + plugin.getMysqlInterface().tableNameIV
						+ "`(`propertyid`, `zonelord`, `location_first`, `location_second`) " 
						+ "VALUES(?, ?, ?, ?)";
				preparedStatement = conn.prepareStatement(sql);
		        preparedStatement.setInt(1, z.getPropertyID());
		        preparedStatement.setString(2, plugin.getInterfaceConverter().getLocationCoding(z.getFirst()));
		        preparedStatement.setString(3, plugin.getInterfaceConverter().getLocationCoding(z.getSecond()));
		        preparedStatement.setString(4, plugin.getInterfaceConverter().getZoneLordCoding(z.getZoneLord()));
		        
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
	
	default boolean updateDataIV(CityTree plugin, Object object) 
	{
		if(!(object instanceof Zone))
		{
			return false;
		}
		Zone z = (Zone) object;
		PreparedStatement preparedUpdateStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{
				String data = "UPDATE `" + plugin.getMysqlInterface().tableNameIV
						+ "` SET `propertyid` = ?, `zonelord` = ?, `location_first` = ?, `location_second` = ?" 
						+ " WHERE `id` = ?";
				preparedUpdateStatement = conn.prepareStatement(data);
				preparedUpdateStatement.setInt(1, z.getPropertyID());
		        preparedUpdateStatement.setString(2, plugin.getInterfaceConverter().getLocationCoding(z.getFirst()));
		        preparedUpdateStatement.setString(3, plugin.getInterfaceConverter().getLocationCoding(z.getSecond()));
		        preparedUpdateStatement.setString(4, plugin.getInterfaceConverter().getZoneLordCoding(z.getZoneLord()));
		        preparedUpdateStatement.setInt(5, z.getID());
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
	
	default Object getDataIV(CityTree plugin, Object object)
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT * FROM `" + plugin.getMysqlInterface().tableNameIV
						+ "` WHERE `id` = ? LIMIT 1";
		        preparedUpdateStatement = conn.prepareStatement(sql);
		        preparedUpdateStatement.setInt(1, (int) object);
		        
		        result = preparedUpdateStatement.executeQuery();
		        while (result.next()) 
		        {
		        	return new Zone(result.getInt("propertyid"), (int) object,
		        			plugin.getInterfaceConverter().getZoneLordEncoding(result.getString("zonelord")),
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location_first")),
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location_second")));
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
	
	default boolean deleteDataIV(CityTree plugin, Object object)
	{
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		try 
		{
			String sql = "DELETE FROM `" + plugin.getMysqlInterface().tableNameIV + "` WHERE `id` = ?";
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
