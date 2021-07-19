package main.java.de.avankziar.citytree.spigot.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import main.java.de.avankziar.citytree.spigot.CityTree;

public class CMDCityAdmin implements CommandExecutor
{
	private CityTree plugin;
	
	public CMDCityAdmin(CityTree plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if(!(sender instanceof Player))
		{
			return false;
		}
		Player player = (Player)sender;
		if(args.length==0)
		{
			if(!player.hasPermission("citytree.cmd.city"))
			{
				return false;
			}
			//TODO
			return true;
		} else
		{
			return false;
		}
	}
}
