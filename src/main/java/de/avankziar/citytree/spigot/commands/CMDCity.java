package main.java.de.avankziar.citytree.spigot.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.Gui;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.GuiUser;

public class CMDCity implements CommandExecutor
{
	private CityTree plugin;
	
	public CMDCity(CityTree plugin)
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
			GuiUser guiUser = GuiUser.getGuiUser(player);
			if(guiUser==null)
			{
				return false;
			}
			guiUser.setNewGui(Gui.Type.CITYTREE_MAIN);
			Gui gui = Gui.getGui(Gui.Type.CITYTREE_MAIN);
			player.openInventory(gui.getInventory());
			return true;
		} else
		{
			return false;
		}
	}
	
}
