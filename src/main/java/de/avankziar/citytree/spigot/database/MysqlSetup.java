package main.java.de.avankziar.citytree.spigot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import main.java.de.avankziar.citytree.spigot.CityTree;

public class MysqlSetup 
{
	private CityTree plugin;
	private Connection conn = null;
	
	public MysqlSetup(CityTree plugin) 
	{
		this.plugin = plugin;
		connectToDatabase();
		setupDatabase0();
		setupDatabaseI();
		setupDatabaseII();
		setupDatabaseIII();
		setupDatabaseIV();
	}
	
	//Datenbank I = Citys
	//Datenbank II = Distrikte
	//Datenbank III = Propertys
	//Datenbanek IV = TeleportLocation
	
	public void connectToDatabase() 
	{
		CityTree.log.info("Connecting to the database...");
		try {
       	 	//Load Drivers
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            properties.setProperty("user", plugin.getYamlHandler().get().getString("mysql.user"));
            properties.setProperty("password", plugin.getYamlHandler().get().getString("mysql.password"));
            properties.setProperty("autoReconnect", plugin.getYamlHandler().get().getString("mysql.autoReconnect"));
            properties.setProperty("verifyServerCertificate", plugin.getYamlHandler().get().getString("mysql.verifyServerCertificate"));
            properties.setProperty("useSSL", plugin.getYamlHandler().get().getString("mysql.sslEnabled"));
            properties.setProperty("requireSSL", plugin.getYamlHandler().get().getString("mysql.sslEnabled"));
            //Connect to database
            conn = DriverManager.getConnection("jdbc:mysql://" + plugin.getYamlHandler().get().getString("mysql.host") 
            		+ ":" + plugin.getYamlHandler().get().getString("mysql.port") + "/" + plugin.getYamlHandler().get().getString("mysql.databaseName"), properties);
           
          } catch (ClassNotFoundException e) {
        	  CityTree.log.severe("Could not locate drivers for mysql! Error: " + e.getMessage());
            return;
          } catch (SQLException e) {
        	  CityTree.log.severe("Could not connect to mysql database! Error: " + e.getMessage());
            return;
          }
		CityTree.log.info("Database connection successful!");
	}
	
	public void setupDatabase0() 
	{
		if (conn != null) 
		{
			PreparedStatement query = null;
		      try 
		      {	        
		        String data = "CREATE TABLE IF NOT EXISTS `" + plugin.getMysqlInterface().tableName0
		        		+ "` (id int AUTO_INCREMENT PRIMARY KEY,"
		        		+ " player_uuid char(36) NOT NULL UNIQUE,"
		        		+ " player_name varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
		        		+ " player_quicklist TEXT);";
		        query = conn.prepareStatement(data);
		        query.execute();
		      } catch (SQLException e) 
		      {
		        e.printStackTrace();
		        CityTree.log.severe("Error creating tables! Error: " + e.getMessage());
		      } finally {
		    	  try {
		    		  if (query != null) 
		    		  {
		    			  query.close();
		    		  }
		    	  } catch (Exception e) 
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }
		}
	}
	
	public void setupDatabaseI() 
	{
		if (conn != null) 
		{
			PreparedStatement query = null;
		      try 
		      {	        
		        String data = "CREATE TABLE IF NOT EXISTS `" + plugin.getMysqlInterface().tableNameI
		        		+ "` (id int AUTO_INCREMENT PRIMARY KEY,"
		        		+ " city_name TEXT, lore TEXT, creator char(36) NOT NULL, owner char(36) NOT NULL,"
		        		+ " city_level INT, securitylevel TEXT, location_center MEDIUMTEXT, location_first MEDIUMTEXT, location_second MEDIUMTEXT,"
		        		+ " district TEXT, property TEXT, teleportslocation TEXT, city_extension MEDIUMTEXT,"
		        		+ " createtime BIGINT, coowner TEXT, districtlord MEDIUMTEXT, totalcost MEDIUMTEXT, stockpile MEDIUMTEXT,"
		        		+ " icon TEXT, barker MEDIUMTEXT, advertisement MEDIUMTEXT, canlevelup BOOLEAN, listtype TEXT,"
		        		+ " blacklist MEDIUMTEXT, whitelist MEDIUMTEXT, currentlydistrictamount INT, currentlypropertytamount INT, "
		        		+ " currentlyteleportamount INT, currentlyadvertisementamount INT, debts DOUBLE);";
		        query = conn.prepareStatement(data);
		        query.execute();
		      } catch (SQLException e) 
		      {
		        e.printStackTrace();
		        CityTree.log.severe("Error creating tables! Error: " + e.getMessage());
		      } finally {
		    	  try {
		    		  if (query != null) 
		    		  {
		    			  query.close();
		    		  }
		    	  } catch (Exception e) 
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }
		}
	}
	
	public void setupDatabaseII() 
	{
		if (conn != null) 
		{
			PreparedStatement query = null;
		      try 
		      {	        
		        String data = "CREATE TABLE IF NOT EXISTS `" + plugin.getMysqlInterface().tableNameII
		        		+ "` (id int AUTO_INCREMENT PRIMARY KEY,"
		        		+ " idcity INT, name TEXT, districtlord MEDIUMTEXT, MEDIUMlocation_first TEXT, location_second MEDIUMTEXT,"
		        		+ " securitylevel TEXT, districtproperties TEXT);";
		        query = conn.prepareStatement(data);
		        query.execute();
		      } catch (SQLException e) 
		      {
		        e.printStackTrace();
		        CityTree.log.severe("Error creating tables! Error: " + e.getMessage());
		      } finally {
		    	  try {
		    		  if (query != null) 
		    		  {
		    			  query.close();
		    		  }
		    	  } catch (Exception e) 
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }
		}
	}
	
	public void setupDatabaseIII() 
	{
		if (conn != null) 
		{
			PreparedStatement query = null;
		      try 
		      {	        
		        String data = "CREATE TABLE IF NOT EXISTS `" + plugin.getMysqlInterface().tableNameIII 
		        		+ "` (id int AUTO_INCREMENT PRIMARY KEY,"
		        		+ " idcity INT, iddistrict INT, name TEXT, status TEXT, newstatus TEXT, securitylevel TEXT,"
		        		+ " supremelandlord TEXT, landlord MEDIUMTEXT, roommate MEDIUMTEXT, location_first TEXT, location_second TEXT,"
		        		+ " warp INT, rentprice DOUBLE, buyprice DOUBLE, newprice DOUBLE, minimumrenttime BIGINT,"
		        		+ " vacanttime BIGINT, renttime BIGINT, debts DOUBLE, restoration MEDIUMTEXT, zones MEDIUMTEXT,"
		        		+ " listtype TEXT, blacklist TEXT, whitelist TEXT);";
		        query = conn.prepareStatement(data);
		        query.execute();
		      } catch (SQLException e) 
		      {
		        e.printStackTrace();
		        CityTree.log.severe("Error creating tables! Error: " + e.getMessage());
		      } finally {
		    	  try {
		    		  if (query != null) 
		    		  {
		    			  query.close();
		    		  }
		    	  } catch (Exception e) 
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }
		}
	}
	
	public void setupDatabaseIV() 
	{
		if (conn != null) 
		{
			PreparedStatement query = null;
		      try 
		      {	        
		        String data = "CREATE TABLE IF NOT EXISTS `" + plugin.getMysqlInterface().tableNameIV
		        		+ "` (id int AUTO_INCREMENT PRIMARY KEY,"
		        		+ " propertyid INT, zonelord MEDIUMTEXT, location_first TEXT, location_second TEXT);";
		        query = conn.prepareStatement(data);
		        query.execute();
		      } catch (SQLException e) 
		      {
		        e.printStackTrace();
		        CityTree.log.severe("Error creating tables! Error: " + e.getMessage());
		      } finally {
		    	  try {
		    		  if (query != null) 
		    		  {
		    			  query.close();
		    		  }
		    	  } catch (Exception e) 
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }
		}
	}
	
	public void setupDatabaseV() 
	{
		if (conn != null) 
		{
			PreparedStatement query = null;
		      try 
		      {	        
		        String data = "CREATE TABLE IF NOT EXISTS `" + plugin.getMysqlInterface().tableNameV
		        		+ "` (id int AUTO_INCREMENT PRIMARY KEY,"
		        		+ " name TEXT, server TEXT, onylserverstaff BOOLEAN, onlycitystaff BOOLEAN, location TEXT);";
		        query = conn.prepareStatement(data);
		        query.execute();
		      } catch (SQLException e) 
		      {
		        e.printStackTrace();
		        CityTree.log.severe("Error creating tables! Error: " + e.getMessage());
		      } finally {
		    	  try {
		    		  if (query != null) 
		    		  {
		    			  query.close();
		    		  }
		    	  } catch (Exception e) 
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }
		}
	}
	
	public Connection getConnection() 
	{
		checkConnection();
		return conn;
	}
	
	public void checkConnection() 
	{
		try {
			if (conn == null) {
				CityTree.log.warning("Connection failed. Reconnecting...");
				reConnect();
			}
			if (!conn.isValid(3)) 
			{
				CityTree.log.warning("Connection is idle or terminated. Reconnecting...");
				reConnect();
			}
			if (conn.isClosed() == true) 
			{
				CityTree.log.warning("Connection is closed. Reconnecting...");
				reConnect();
			}
		} catch (Exception e) 
		{
			CityTree.log.severe("Could not reconnect to Database! Error: " + e.getMessage());
		}
	}
	
	public boolean reConnect() 
	{
		try 
		{            
            long start = 0;
			long end = 0;
			
		    start = System.currentTimeMillis();
		    CityTree.log.info("Attempting to establish a connection to the MySQL server!");
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            properties.setProperty("user", plugin.getYamlHandler().get().getString("mysql.user"));
            properties.setProperty("password", plugin.getYamlHandler().get().getString("mysql.password"));
            properties.setProperty("autoReconnect", plugin.getYamlHandler().get().getString("mysql.autoReconnect"));
            properties.setProperty("verifyServerCertificate", plugin.getYamlHandler().get().getString("mysql.verifyServerCertificate"));
            properties.setProperty("useSSL", plugin.getYamlHandler().get().getString("mysql.sslEnabled"));
            properties.setProperty("requireSSL", plugin.getYamlHandler().get().getString("mysql.sslEnabled"));
            //properties.setProperty("useUnicode", "true");
            //properties.setProperty("characterEncoding", "utf8");
            //properties.setProperty("characterSetResults", "utf8");
            //properties.setProperty("connectionCollation", "utf8mb4_unicode_ci");
            conn = DriverManager.getConnection("jdbc:mysql://" + plugin.getYamlHandler().get().getString("mysql.host") + ":" 
            		+ plugin.getYamlHandler().get().getString("mysql.port") + "/" + plugin.getYamlHandler().get().getString("mysql.databaseName"), properties);
		    end = System.currentTimeMillis();
		    CityTree.log.info("Connection to MySQL server established!");
		    CityTree.log.info("Connection took " + ((end - start)) + "ms!");
            return true;
		} catch (Exception e) {
			CityTree.log.severe("Error re-connecting to the database! Error: " + e.getMessage());
			return false;
		}
	}
	
	public void closeConnection() 
	{
		try 
		{
			CityTree.log.info("Closing database connection...");
			conn.close();
			conn = null;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
