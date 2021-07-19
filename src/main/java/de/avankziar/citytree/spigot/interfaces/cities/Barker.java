package main.java.de.avankziar.citytree.spigot.interfaces.cities;

public class Barker //Markschreier
{
	
	private String uuid; //Player uuid
	private int usage; //Werbung anzahl pro tag
	private int alreadyUsed; //Werbung pro tag genutzt
	private double salary; //Gehalt pro genutze Werbung
	private long cooldown; //SalaryCooldown
	
	public Barker(String uuid, int usage, int alreadyUsed, double salary, long cooldown)
	{
		setUuid(uuid);
		setUsage(usage);
		setAlreadyUsed(alreadyUsed);
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

	public int getUsage()
	{
		return usage;
	}

	public void setUsage(int usage)
	{
		this.usage = usage;
	}

	public int getAlreadyUsed()
	{
		return alreadyUsed;
	}

	public void setAlreadyUsed(int alreadyUsed)
	{
		this.alreadyUsed = alreadyUsed;
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
