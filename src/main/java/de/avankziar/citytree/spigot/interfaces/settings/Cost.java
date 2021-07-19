package main.java.de.avankziar.citytree.spigot.interfaces.settings;

import java.util.LinkedHashMap;

import org.bukkit.Material;

public class Cost
{
	private double moneyCost;
	private LinkedHashMap<Material, Double> materialCost;
	private int expCost;
	
	public Cost(double moneyCost, LinkedHashMap<Material, Double> materialCost, int expCost)
	{
		setmoneyCost(moneyCost);
		setmaterialCost(materialCost);
		setexpCost(expCost);
	}
	
	public double getmoneyCost()
	{
		return moneyCost;
	}
	public void setmoneyCost(double moneyCost)
	{
		this.moneyCost = moneyCost;
	}
	public int getexpCost()
	{
		return expCost;
	}
	public void setexpCost(int expCost)
	{
		this.expCost = expCost;
	}

	public LinkedHashMap<Material, Double> getmaterialCost()
	{
		return materialCost;
	}

	public void setmaterialCost(LinkedHashMap<Material, Double> materialCost)
	{
		this.materialCost = materialCost;
	}

}
