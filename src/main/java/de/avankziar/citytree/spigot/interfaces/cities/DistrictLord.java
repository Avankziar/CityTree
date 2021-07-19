package main.java.de.avankziar.citytree.spigot.interfaces.cities;

import java.util.ArrayList;

public class DistrictLord
{
	private String uuid;
	private ArrayList<Integer> district;
	private double salary;
	private long cooldown; //SalaryCooldown
	
	public DistrictLord(String uuid, ArrayList<Integer> district, double salary, long cooldown)
	{
		setUuid(uuid);
		setDistrict(district);
		setSalary(salary);
		setCooldown(cooldown);
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	public ArrayList<Integer> getDistrict()
	{
		return district;
	}

	public void setDistrict(ArrayList<Integer> district)
	{
		this.district = district;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public long getCooldown()
	{
		return cooldown;
	}

	public void setCooldown(long cooldown)
	{
		this.cooldown = cooldown;
	}

}
