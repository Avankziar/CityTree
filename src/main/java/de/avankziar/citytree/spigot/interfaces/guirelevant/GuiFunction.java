package main.java.de.avankziar.citytree.spigot.interfaces.guirelevant;

import main.java.de.avankziar.citytree.spigot.handler.GuiHandler;

public class GuiFunction //Wenn man auf einen Slot klick um direkt die Funktion zu kennen
{
	private int slot;
	private GuiFunction.Type leftFunction;
	private GuiFunction.Type rightFunction;
	private GuiFunction.Type shiftLeftFunction;
	private GuiFunction.Type shiftRightFunction;
	private GuiFunction.Type dropFunction; //Taste q, ürsprünglich zum droppen von items
	private Gui.Type guiType;
	private GuiHandler.Type guiHandlerType;
	private int ganzZahl;
	private double gleitPunktZahl;
	
	public GuiFunction(int slot, GuiFunction.Type leftFunction, GuiFunction.Type rightFunction,
			GuiFunction.Type shiftLeftFunction, GuiFunction.Type shiftRightFunction, GuiFunction.Type dropFunction,
			Gui.Type guiType, GuiHandler.Type guiHandlerType, int ganzZahl, double gleitPunktZahl)
	{
		setSlot(slot);
		setLeftFunction(leftFunction);
		setRightFunction(rightFunction);
		setShiftLeftFunction(shiftLeftFunction);
		setShiftRightFunction(shiftRightFunction);
		setDropFunction(dropFunction);
		setGuiType(guiType);
		setGanzZahl(ganzZahl);
		setGleitPunktZahl(gleitPunktZahl);
		
	}

	public int getSlot()
	{
		return slot;
	}

	public void setSlot(int slot)
	{
		this.slot = slot;
	}

	public GuiFunction.Type getLeftFunction()
	{
		return leftFunction;
	}

	public void setLeftFunction(GuiFunction.Type leftFunction)
	{
		this.leftFunction = leftFunction;
	}

	public GuiFunction.Type getRightFunction()
	{
		return rightFunction;
	}

	public void setRightFunction(GuiFunction.Type rightFunction)
	{
		this.rightFunction = rightFunction;
	}

	public GuiFunction.Type getDropFunction()
	{
		return dropFunction;
	}

	public void setDropFunction(GuiFunction.Type dropFunction)
	{
		this.dropFunction = dropFunction;
	}

	public Gui.Type getGuiType()
	{
		return guiType;
	}

	public void setGuiType(Gui.Type guiType)
	{
		this.guiType = guiType;
	}

	public int getGanzZahl()
	{
		return ganzZahl;
	}

	public void setGanzZahl(int ganzZahl)
	{
		this.ganzZahl = ganzZahl;
	}

	public double getGleitPunktZahl()
	{
		return gleitPunktZahl;
	}

	public void setGleitPunktZahl(double gleitPunktZahl)
	{
		this.gleitPunktZahl = gleitPunktZahl;
	}

	public GuiFunction.Type getShiftLeftFunction()
	{
		return shiftLeftFunction;
	}

	public void setShiftLeftFunction(GuiFunction.Type shiftLeftFunction)
	{
		this.shiftLeftFunction = shiftLeftFunction;
	}

	public GuiFunction.Type getShiftRightFunction()
	{
		return shiftRightFunction;
	}

	public void setShiftRightFunction(GuiFunction.Type shiftRightFunction)
	{
		this.shiftRightFunction = shiftRightFunction;
	}
	
	public GuiHandler.Type getGuiHandlerType()
	{
		return guiHandlerType;
	}

	public void setGuiHandlerType(GuiHandler.Type guiHandlerType)
	{
		this.guiHandlerType = guiHandlerType;
	}

	public enum Type //Was bei welchem Slot ausgeführt werden soll
	{
		NONE,
		//None, ist nichts,
		
		SWITCH, NEXTPAGE, PREVIOUSPAGE, BACK,
		//Switch Gui
		
		DIRECTLOCATION,
		//Schnellzugriff auf city ect, wo man gerade Steht
		
		ADD_INTEGER, REMOVE_INTEGER, ADD_DOUBLE, REMOVE_DOUBLE, ACCEPT,
		//All ADD and Remove open the same gui new 
		
		CHATEDITOR, ADD_SURVEYING, REMOVE_SURVEYING,
		//surveying = Vermesserliste, um districte ect punkte zu setzten.
		
		ADD_PLAYER, REMOVE_PLAYER,

		TELEPORT, CITYLEVELRISE, ADD_NEW, DELETE,
		//Add-new um neue districte/propertys/teleports etc anzulegen, DELETE für städte, districte, etc 
		
		CHANGE_LOCATION,
		
	}
}