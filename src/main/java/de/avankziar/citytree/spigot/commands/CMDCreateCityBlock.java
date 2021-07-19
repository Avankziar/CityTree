package main.java.de.avankziar.citytree.spigot.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import main.java.de.avankziar.citytree.spigot.CityTree;

public class CMDCreateCityBlock implements CommandExecutor
{
	private CityTree plugin;
	
	public CMDCreateCityBlock(CityTree plugin)
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
		String language = plugin.getYamlHandler().get().getString("language");
		if(args.length==1) 
		{
			if(plugin.getCommandHandler().noPerms(player, "citytree.cmd.createcityblock"))
			{
				return false;
			}
			if (!args[0].matches("[0-9]+"))
			{
				plugin.getCommandHandler().rightArgs(player, args, "/createcityblock <player> <amount>", 2, 3);
				return false;
			}
			int amount = Integer.parseInt(args[0]);
			if(amount<=0)
			{
				amount = 1;
			}
			if(amount>64)
			{
				amount = 64;
			}
			ItemStack is = plugin.getUtility().createItemFromYaml(plugin.getYamlHandler().get(), "city.item", amount);
			if(!plugin.getUtility().hasAvaliableSlot(player, 1))
			{
				player.sendMessage(plugin.getUtility().tl(
						plugin.getYamlHandler().getL().getString(language+".cmdcreatecityblock.msg01")));
				return false;
			}
			player.getInventory().addItem(is);
			player.sendMessage(plugin.getUtility().tl(
					plugin.getYamlHandler().getL().getString(language+".cmdcreatecityblock.msg02")));
			return true;
		} else
		{
			plugin.getCommandHandler().rightArgs(player, args, "/createcityblock <player>", 2, 3);
			return false;
		}
	}

}
