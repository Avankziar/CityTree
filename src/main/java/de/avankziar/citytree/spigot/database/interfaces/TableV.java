package main.java.de.avankziar.citytree.spigot.database.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.TeleportLocation;

public interface TableV
{
	default boolean existV(CityTree plugin, Object object) 
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT `id` FROM `" + plugin.getMysqlInterface().tableNameV
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
	
	default boolean createV(CityTree plugin, Object object) 
	{
		if(!(object instanceof TeleportLocation))
		{
			return false;
		}
		TeleportLocation tl = (TeleportLocation) object;
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) {
			try 
			{
				String sql = "INSERT INTO `" + plugin.getMysqlInterface().tableNameV
						+ "`(`name`, `server`, `onylserverstaff`, `onlycitystaff`, `location`) " 
						+ "VALUES(?, ?, ?, ?, ?)";
				preparedStatement = conn.prepareStatement(sql);
		        preparedStatement.setString(1, tl.getName());
		        preparedStatement.setString(2, tl.getServer());
		        preparedStatement.setBoolean(3, tl.isOnlyServerStaff());
		        preparedStatement.setBoolean(4, tl.isOnlyCityStaff());
		        preparedStatement.setString(5, plugin.getInterfaceConverter().getLocationCoding(tl.getLocation()));
		        
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
	
	default boolean updateDataV(CityTree plugin, Object object) 
	{
		if(!(object instanceof TeleportLocation))
		{
			return false;
		}
		TeleportLocation tl = (TeleportLocation) object;
		PreparedStatement preparedUpdateStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{
				String data = "UPDATE `" + plugin.getMysqlInterface().tableNameV
						+ "` SET `name` = ?, `server` = ?, `onylserverstaff` = ?, `onlycitystaff` = ?, `location` = ?" 
						+ " WHERE `id` = ?";
				preparedUpdateStatement = conn.prepareStatement(data);
				preparedUpdateStatement.setString(1, tl.getName());
		        preparedUpdateStatement.setString(2, tl.getServer());
		        preparedUpdateStatement.setBoolean(3, tl.isOnlyServerStaff());
		        preparedUpdateStatement.setBoolean(4, tl.isOnlyCityStaff());
		        preparedUpdateStatement.setString(5, plugin.getInterfaceConverter().getLocationCoding(tl.getLocation()));
		        preparedUpdateStatement.setInt(6, tl.getId());
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
	
	default Object getDataV(CityTree plugin, Object object)
	{
		PreparedStatement preparedUpdateStatement = null;
		ResultSet result = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		if (conn != null) 
		{
			try 
			{			
				String sql = "SELECT * FROM `" + plugin.getMysqlInterface().tableNameV
						+ "` WHERE `id` = ? LIMIT 1";
		        preparedUpdateStatement = conn.prepareStatement(sql);
		        preparedUpdateStatement.setInt(1, (int) object);
		        
		        result = preparedUpdateStatement.executeQuery();
		        while (result.next()) 
		        {
		        	return new TeleportLocation((int) object, result.getString("name"), result.getString("server"), 
		        			result.getBoolean("onlyCityStaff"), result.getBoolean("onlyServerStaff"),
		        			plugin.getInterfaceConverter().getLocationEncoding(result.getString("location")));
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
	
	default boolean deleteDataV(CityTree plugin, Object object)
	{
		PreparedStatement preparedStatement = null;
		Connection conn = plugin.getDatabaseHandler().getConnection();
		try 
		{
			String sql = "DELETE FROM `" + plugin.getMysqlInterface().tableNameV + "` WHERE `id` = ?";
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
