package main.java.de.avankziar.citytree.spigot.commands;

import org.bukkit.entity.Player;

import main.java.de.avankziar.citytree.spigot.CityTree;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class CommandHandler
{
	private CityTree plugin;
	private String language;
	
	public CommandHandler(CityTree plugin)
	{
		this.plugin = plugin;
		language = plugin.getYamlHandler().get().getString("language");
	}
	
	public boolean noPerms(Player player, String perms)
	{
		if(!player.hasPermission(perms))
		{
			player.sendMessage(plugin.getUtility().tl(plugin.getYamlHandler().getL().getString(language+".path")));
			return true;
		}
		return false;
	}
	
	public boolean rightArgs(Player player, String[] args, String command, int i)
    {
    	if(args.length!=i)
    	{
    		TextComponent msg = plugin.getUtility().tcl(plugin.getYamlHandler().getL().getString(language+".path"));
			msg.setClickEvent( new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
			player.spigot().sendMessage(msg);
			return true;
    	} else
    	{
    		return false;
    	}
    }
	
	public boolean rightArgs(Player player, String[] args, String command, int a, int b)
    {
    	if(args.length>=a && args.length<=b)
    	{
    		TextComponent msg = plugin.getUtility().tcl(plugin.getYamlHandler().getL().getString(language+".path"));
			msg.setClickEvent( new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
			player.spigot().sendMessage(msg);
			return true;
    	} else
    	{
    		return false;
    	}
    }
}
