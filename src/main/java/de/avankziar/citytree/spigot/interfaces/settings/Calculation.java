package main.java.de.avankziar.citytree.spigot.interfaces.settings;

public class Calculation
{
	private Type type;
	private double baseMoneyValue;
	private double valueOne;
	private double valueTwo;
	
	public Calculation(Type type, double baseMoneyValue, double valueOne, double valueTwo)
	{
		setType(type);
		setBaseMoneyValue(baseMoneyValue);
		setValueOne(valueOne);
		setValueTwo(valueTwo);
	}
	
	public double getEndValue(int nextamount, Type type, double baseMoneyValue, double valueOne, double valueTwo)
	{
		double endValue = 0.0;
		if(type == Type.NOCHANGE)
		{
			return baseMoneyValue;
		} else if(type == Type.LINEAR)
		{
			return endValue = nextamount*baseMoneyValue;
		} else if(type == Type.FORMULA)
		{
			return endValue = baseMoneyValue+Math.pow(valueOne, (nextamount/valueTwo));
		}
		return endValue;
	}
	
	public Type getType()
	{
		return type;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public double getBaseMoneyValue()
	{
		return baseMoneyValue;
	}

	public void setBaseMoneyValue(double baseMoneyValue)
	{
		this.baseMoneyValue = baseMoneyValue;
	}

	public double getValueOne()
	{
		return valueOne;
	}

	public void setValueOne(double valueOne)
	{
		this.valueOne = valueOne;
	}

	public double getValueTwo()
	{
		return valueTwo;
	}

	public void setValueTwo(double valueTwo)
	{
		this.valueTwo = valueTwo;
	}
	
	public enum Type
	{
		//x = baseMoneyValue
		NOCHANGE, //Es kostet immer betrag x
		LINEAR, //Es kostet immer y = n*x
		FORMULA; //Es kostet y = x+valueOne^(n/valueTwo)
	}
}
