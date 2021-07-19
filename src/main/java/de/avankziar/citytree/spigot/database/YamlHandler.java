package main.java.de.avankziar.citytree.spigot.database;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import main.java.de.avankziar.citytree.spigot.CityTree;

public class YamlHandler 
{
	private CityTree plugin;
	private File config = null;
	private YamlConfiguration cfg = new YamlConfiguration();
	private File language = null;
	private YamlConfiguration lgg = new YamlConfiguration();
	private File guis = null;
	private YamlConfiguration gui = new YamlConfiguration();
	private File enumsList = null;
	private YamlConfiguration enl = new YamlConfiguration();
	
	public YamlHandler(CityTree plugin) 
	{
		this.plugin = plugin;
		mkdir();
		loadYamls();
	}
	
	public YamlConfiguration get()
	{
		return cfg;
	}
	
	public YamlConfiguration getL()
	{
		return lgg;
	}
	
	public YamlConfiguration getGui()
	{
		return gui;
	}
	
	public YamlConfiguration getE()
	{
		return enl;
	}
	
	private void mkdir() 
	{
		config = new File(plugin.getDataFolder(), "config.yml");
		if(!config.exists()) 
		{
			CityTree.log.info("Create config.yml...");
			plugin.saveResource("config.yml", false);
		}
		language = new File(plugin.getDataFolder(), "language.yml");
		if(!language.exists()) 
		{
			CityTree.log.info("Create language.yml...");
			plugin.saveResource("language.yml", false);
		}
		guis = new File(plugin.getDataFolder(), "gui.yml");
		if(!language.exists()) 
		{
			CityTree.log.info("Create gui.yml...");
			plugin.saveResource("gui.yml", false);
		}
		enumsList = new File(plugin.getDataFolder(), "enumslist.yml");
		if(!enumsList.exists()) 
		{
			CityTree.log.info("Create enumslist.yml...");
			plugin.saveResource("enumslist.yml", false);
		}
	}
	
	public void saveConfig() 
	{
	    try 
	    {
	    	CityTree.log.info("Save config.yml...");
	        cfg.save(config);
	    } catch (IOException e) 
	    {
	    	CityTree.log.severe("Could not save the config.yml! Error: " + e.getMessage());
			e.printStackTrace();
	    }
	}
	
	public void saveLanguage() 
	{
	    try 
	    {
	    	CityTree.log.info("Save language.yml...");
	        lgg.save(language);
	    } catch (IOException e) 
	    {
	    	CityTree.log.severe("Could not save the language.yml! Error: " + e.getMessage());
			e.printStackTrace();
	    }
	}
	
	public void saveGui() 
	{
	    try 
	    {
	    	CityTree.log.info("Save Gui.yml...");
	        gui.save(guis);
	    } catch (IOException e) 
	    {
	    	CityTree.log.severe("Could not save the gui.yml! Error: " + e.getMessage());
			e.printStackTrace();
	    }
	}
	
	public void saveEnumsList() 
	{
	    try 
	    {
	    	CityTree.log.info("Save enumslist.yml...");
	        gui.save(guis);
	    } catch (IOException e) 
	    {
	    	CityTree.log.severe("Could not save the enumslist.yml! Error: " + e.getMessage());
			e.printStackTrace();
	    }
	}
	
	public void loadYamls() 
	{
		try 
		{
			CityTree.log.info("Load config.yml...");
			cfg.load(config);
		} catch (IOException | InvalidConfigurationException e) {
			CityTree.log.severe("Could not load the config file! You need to regenerate the config! Error: " + e.getMessage());
			e.printStackTrace();
		}
		try 
		{
			CityTree.log.info("Load language.yml...");
			lgg.load(language);
		} catch (IOException | InvalidConfigurationException e) {
			CityTree.log.severe("Could not load the language file! You need to regenerate the language! Error: " + e.getMessage());
			e.printStackTrace();
		}
		try 
		{
			CityTree.log.info("Load gui.yml...");
			gui.load(guis);
		} catch (IOException | InvalidConfigurationException e) {
			CityTree.log.severe("Could not load the gui file! You need to regenerate the gui! Error: " + e.getMessage());
			e.printStackTrace();
		}
		try 
		{
			CityTree.log.info("Load enumslist.yml...");
			enl.load(enumsList);
		} catch (IOException | InvalidConfigurationException e) {
			CityTree.log.severe("Could not load the enumslist file! You need to regenerate the enumslist! Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
