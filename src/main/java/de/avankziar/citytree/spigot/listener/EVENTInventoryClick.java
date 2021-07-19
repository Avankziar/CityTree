package main.java.de.avankziar.citytree.spigot.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import main.java.de.avankziar.citytree.spigot.CityTree;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.Gui;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.GuiFunction;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.GuiUser;

public class EVENTInventoryClick implements Listener
{
	private CityTree plugin;
	
	public EVENTInventoryClick(CityTree plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		if(event.getClickedInventory()==null)
		{
			return;
		}
		if(event.getClickedInventory().getType()==InventoryType.PLAYER)
		{
			return;
		}
		if(event.getCurrentItem()==null)
		{
			return;
		}
		final String title = event.getCurrentItem().getItemMeta().getDisplayName();
		GuiUser guiUser = GuiUser.getGuiUser(player);
		if(guiUser==null)
		{
			return;
		}
		Gui gui = Gui.getGui(guiUser.getNewGui());
		if(gui==null)
		{
			return;
		}
		event.setCancelled(true);
		ClickType clickType = event.getClick();
		if(clickType != ClickType.DROP && clickType != ClickType.LEFT && clickType != ClickType.RIGHT 
				&& clickType != ClickType.SHIFT_LEFT && clickType != ClickType.SHIFT_RIGHT)
		{
			return;
		}
		int slot = event.getSlot();
		GuiFunction guiFunction = null;
		for(GuiFunction gf : gui.getGuiFunction())
		{
			if(gf.getSlot()==slot)
			{
				guiFunction = gf;
				break;
			}
		}
		if(guiFunction == null)
		{
			return;
		}
		if(clickType == ClickType.LEFT)
		{
			if(guiFunction.getLeftFunction() == GuiFunction.Type.NONE)
			{
				return;
			}
			plugin.getGuiHandler().guiInteractionHandler(guiUser, gui, guiFunction, guiFunction.getLeftFunction(), title);
		} else if(clickType == ClickType.RIGHT)
		{
			if(guiFunction.getRightFunction() == GuiFunction.Type.NONE)
			{
				return;
			}
			plugin.getGuiHandler().guiInteractionHandler(guiUser, gui, guiFunction, guiFunction.getRightFunction(), title);
		} else if(clickType == ClickType.SHIFT_LEFT)
		{
			if(guiFunction.getShiftLeftFunction() == GuiFunction.Type.NONE)
			{
				return;
			}
			plugin.getGuiHandler().guiInteractionHandler(guiUser, gui, guiFunction, guiFunction.getShiftLeftFunction(), title);
		} else if(clickType == ClickType.SHIFT_RIGHT)
		{
			if(guiFunction.getShiftRightFunction() == GuiFunction.Type.NONE)
			{
				return;
			}
			plugin.getGuiHandler().guiInteractionHandler(guiUser, gui, guiFunction, guiFunction.getShiftRightFunction(), title);
		} else if(clickType == ClickType.DROP)
		{
			if(guiFunction.getDropFunction() == GuiFunction.Type.NONE)
			{
				return;
			}
			plugin.getGuiHandler().guiInteractionHandler(guiUser, gui, guiFunction, guiFunction.getDropFunction(), title);
		}
	}
}
