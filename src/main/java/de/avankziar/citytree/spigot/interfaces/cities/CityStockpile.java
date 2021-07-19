package main.java.de.avankziar.citytree.spigot.interfaces.cities;

import java.util.LinkedHashMap;

import org.bukkit.Material;

public class CityStockpile
{
	private double bankAccount;
	private LinkedHashMap<Material, Double> itemsIst; //Momentan Anzahl von Material
	//log per mysql
	private LinkedHashMap<Material, Double> itemsSoll; //Gebrauchter maximal wert von Material
	private int playerexp;
	
	public CityStockpile(double bankAccount, LinkedHashMap<Material, Double> itemIst,
			LinkedHashMap<Material, Double> itemSoll, int playerexp)
	{
		setBankAccount(bankAccount);
		setItemsIst(itemIst);
		setItemsSoll(itemSoll);
		setPlayerexp(playerexp);
	}

	public int getPlayerexp()
	{
		return playerexp;
	}

	public void setPlayerexp(int playerexp)
	{
		this.playerexp = playerexp;
	}

	public LinkedHashMap<Material, Double> getItemsIst()
	{
		return itemsIst;
	}

	public void setItemsIst(LinkedHashMap<Material, Double> itemsIst)
	{
		this.itemsIst = itemsIst;
	}

	public LinkedHashMap<Material, Double> getItemsSoll()
	{
		return itemsSoll;
	}

	public void setItemsSoll(LinkedHashMap<Material, Double> itemsSoll)
	{
		this.itemsSoll = itemsSoll;
	}

	/**
	 * @return the bankAccount
	 */
	public double getBankAccount()
	{
		return bankAccount;
	}

	/**
	 * @param bankAccount the bankAccount to set
	 */
	public void setBankAccount(double bankAccount)
	{
		this.bankAccount = bankAccount;
	}
}
