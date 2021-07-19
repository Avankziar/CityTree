package main.java.de.avankziar.citytree.spigot.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.Gui;
import main.java.de.avankziar.citytree.spigot.interfaces.guirelevant.GuiUser;

public class EVENTCloseInventory implements Listener
{
	
	public EVENTCloseInventory()
	{
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void onCloseInventory(InventoryCloseEvent event)
	{
		Player player = (Player) event.getPlayer();
		GuiUser guiUser = GuiUser.getGuiUser(player);
		if(!GuiUser.chatEditor.contains(guiUser))
		{
			guiUser.setListIndexPlace(0);
			guiUser.setNewGui(Gui.Type.NONE);
			guiUser.setOldGui(Gui.Type.NONE);
			guiUser.setCityID(0);
			guiUser.setDistrictID(0);
			guiUser.setPropertyID(0);
			guiUser.setZoneID(0);
			guiUser.setTeleportID(0);
		}
	}

}
