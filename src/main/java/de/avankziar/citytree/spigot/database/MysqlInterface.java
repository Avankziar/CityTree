package main.java.de.avankziar.citytree.spigot.database;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.database.interfaces.Table0;
import main.java.de.avankziar.citytree.spigot.database.interfaces.TableI;
import main.java.de.avankziar.citytree.spigot.database.interfaces.TableII;
import main.java.de.avankziar.citytree.spigot.database.interfaces.TableIII;
import main.java.de.avankziar.citytree.spigot.database.interfaces.TableIV;
import main.java.de.avankziar.citytree.spigot.database.interfaces.TableV;

public class MysqlInterface implements Table0, TableI, TableII, TableIII, TableIV, TableV
{
	public enum Type
	{
		PLAYER, CITY, DISTRICT, PROPERTY, ZONE, TELEPORTLOCATION;
		//TODO Noch die Logtabellen
	}
	private CityTree plugin;
	public String tableName0; //Spieler
	public String tableNameI; //City
	public String tableNameII; //District
	public String tableNameIII; //Property
	public String tableNameIV; //Zone
	public String tableNameV; //TeleportLocation
	
	public MysqlInterface(CityTree plugin) 
	{
		this.plugin = plugin;
		this.tableName0 = plugin.getYamlHandler().get().getString("mysql.tableName0");
		this.tableNameI = plugin.getYamlHandler().get().getString("mysql.tableNameI");
		this.tableNameII = plugin.getYamlHandler().get().getString("mysql.tableNameII");
		this.tableNameIII = plugin.getYamlHandler().get().getString("mysql.tableNameIII");
		this.tableNameIV = plugin.getYamlHandler().get().getString("mysql.tableNameIV");
		this.tableNameV = plugin.getYamlHandler().get().getString("mysql.tableNameV");
	}
	
	public boolean exist(Type type, Object object)
	{
		switch(type)
		{
		case PLAYER:
			return Table0.super.exist0(plugin, object);
		case CITY:
			return TableI.super.existI(plugin, object);
		case DISTRICT:
			return TableII.super.existII(plugin, object);
		case PROPERTY:
			return TableIII.super.existIII(plugin, object);
		case ZONE:
			return TableIV.super.existIV(plugin, object);
		case TELEPORTLOCATION:
			return TableV.super.existV(plugin, object);
		}
		return false;
	}
	
	public boolean create(Type type, Object object)
	{
		switch(type)
		{
		case PLAYER:
			return Table0.super.create0(plugin, object);
		case CITY:
			return TableI.super.createI(plugin, object);
		case DISTRICT:
			return TableII.super.createII(plugin, object);
		case PROPERTY:
			return TableIII.super.createIII(plugin, object);
		case ZONE:
			return TableIV.super.createIV(plugin, object);
		case TELEPORTLOCATION:
			return TableV.super.createV(plugin, object);
		}
		return false;
	}
	
	public boolean updateData(Type type, Object object)
	{
		switch(type)
		{
		case PLAYER:
			return Table0.super.updateData0(plugin, object);
		case CITY:
			return TableI.super.updateDataI(plugin, object);
		case DISTRICT:
			return TableII.super.updateDataII(plugin, object);
		case PROPERTY:
			return TableIII.super.updateDataIII(plugin, object);
		case ZONE:
			return TableIV.super.updateDataIV(plugin, object);
		case TELEPORTLOCATION:
			return TableV.super.updateDataV(plugin, object);
		}
		return false;
	}
	
	public Object getData(Type type, Object object)
	{
		switch(type)
		{
		case PLAYER:
			return Table0.super.getData0(plugin, object);
		case CITY:
			return TableI.super.getDataI(plugin, object);
		case DISTRICT:
			return TableII.super.getDataII(plugin, object);
		case PROPERTY:
			return TableIII.super.getDataIII(plugin, object);
		case ZONE:
			return TableIV.super.getDataIV(plugin, object);
		case TELEPORTLOCATION:
			return TableV.super.getDataV(plugin, object);
		}
		return false;
	}
	
	public boolean deleteData(Type type, Object object)
	{
		switch(type)
		{
		case PLAYER:
			return Table0.super.deleteData0(plugin, object);
		case CITY:
			return TableI.super.deleteDataI(plugin, object);
		case DISTRICT:
			return TableII.super.deleteDataII(plugin, object);
		case PROPERTY:
			return TableIII.super.deleteDataIII(plugin, object);
		case ZONE:
			return TableIV.super.deleteDataIV(plugin, object);
		case TELEPORTLOCATION:
			return TableV.super.deleteDataV(plugin, object);
		}
		return false;
	}
}
