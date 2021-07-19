package main.java.de.avankziar.citytree.spigot;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.de.avankziar.citytree.spigot.commands.CMDCity;
import main.java.de.avankziar.citytree.spigot.commands.CMDCityAdmin;
import main.java.de.avankziar.citytree.spigot.commands.CMDCreateCityBlock;
import main.java.de.avankziar.citytree.spigot.commands.CommandHandler;
import main.java.de.avankziar.citytree.spigot.database.MysqlInterface;
import main.java.de.avankziar.citytree.spigot.database.MysqlSetup;
import main.java.de.avankziar.citytree.spigot.database.YamlHandler;
import main.java.de.avankziar.citytree.spigot.handler.GuiHandler;
import main.java.de.avankziar.citytree.spigot.handler.InterfaceConverter;
import main.java.de.avankziar.citytree.spigot.handler.PermissionHandler;
import main.java.de.avankziar.citytree.spigot.listener.EVENTChatEditor;
import main.java.de.avankziar.citytree.spigot.listener.EVENTCloseInventory;
import main.java.de.avankziar.citytree.spigot.listener.EVENTInventoryClick;
import main.java.de.avankziar.citytree.spigot.listener.EVENTJoin;

public class CityTree extends JavaPlugin
{
	public static Logger log;
	public static String pluginName = "CityTree";
	private static YamlHandler yamlHandler;
	private static MysqlSetup databaseHandler;
	private static MysqlInterface mysqlinterface;
	private static BackgroundTask backgroundtask;
	private static Utility utility;
	private static CommandHandler commandHandler;
	private static InterfaceConverter interfaceconverter;
	private static GuiHandler guihandler;
	private static PermissionHandler permissionHandler;
	
	public void onEnable()
	{
		log = getLogger();
		yamlHandler = new YamlHandler(this);
		utility = new Utility(this);
		commandHandler = new CommandHandler(this);
		guihandler = new GuiHandler(this);
		interfaceconverter = new InterfaceConverter(this);
		permissionHandler = new PermissionHandler();
		if(yamlHandler.get().getString("mysql.status").equalsIgnoreCase("true"))
		{
			mysqlinterface = new MysqlInterface(this);
			databaseHandler = new MysqlSetup(this);
		} else
		{
			log.severe("MySQL is not set in the Plugin "+pluginName+"!");
			Bukkit.getPluginManager().getPlugin(pluginName).getPluginLoader().disablePlugin(this);
			return;
		}
		CommandSetup();
		ListenerSetup();
		//this.getServer().getMessenger().registerIncomingPluginChannel(this, "punisher:punisherout", new PluginListener(this));
	    //this.getServer().getMessenger().registerOutgoingPluginChannel(this, "punisher:punisherin");
	}
	
	public void onDisable()
	{
		Bukkit.getScheduler().cancelTasks(this);
		HandlerList.unregisterAll(this);
		if(yamlHandler.get().getString("mysql.status").equalsIgnoreCase("true"))
		{
			if (databaseHandler.getConnection() != null) 
			{
				//backgroundtask.onShutDownDataSave();
				databaseHandler.closeConnection();
			}
		}
		
		log.info(pluginName + " is disabled!");
	}
	
	public YamlHandler getYamlHandler() 
	{
		return yamlHandler;
	}
	
	public MysqlSetup getDatabaseHandler() 
	{
		return databaseHandler;
	}
	
	public MysqlInterface getMysqlInterface()
	{
		return mysqlinterface;
	}
	
	public BackgroundTask getBackgroundTask()
	{
		return backgroundtask;
	}
	
	public Utility getUtility()
	{
		return utility;
	}
	
	public InterfaceConverter getInterfaceConverter()
	{
		return interfaceconverter;
	}
	
	public GuiHandler getGuiHandler()
	{
		return guihandler;
	}
	
	public CommandHandler getCommandHandler()
	{
		return commandHandler;
	}
	
	public PermissionHandler getPermissionHandler()
	{
		return permissionHandler;
	}
	
	public void CommandSetup()
	{
		getCommand("city").setExecutor(new CMDCity(this));
		getCommand("cityadmin").setExecutor(new CMDCityAdmin(this));
		getCommand("createcityblock").setExecutor(new CMDCreateCityBlock(this));
	}
	
	public void ListenerSetup()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EVENTChatEditor(), this);
		pm.registerEvents(new EVENTInventoryClick(this), this);
		pm.registerEvents(new EVENTJoin(this), this);
		pm.registerEvents(new EVENTCloseInventory(), this);
	}
}
