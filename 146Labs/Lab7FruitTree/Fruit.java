//must be made comparable to put in the BinarySearchTree
public class Fruit implements Comparable<Fruit>{
	private double weight;
	private String type;
	//2 contructors
	public Fruit()
	{
		this.weight = 1.0;
		this.type = "none";
	}
	public Fruit(String aType, double aWeight)
	{
		this.setType(aType);
		this.setWeight(aWeight);
	}
	//getters
	public String getType()
	{
		return this.type;
	}
	public double getWeight()
	{
		return this.weight;
	}
	//setter check for valid input
	public void setType(String aType)
	{
		if(aType == null)
		{
			this.type = "none";
			return;
		}
		this.type = aType;
	}
	public void setWeight(double aWeight)
	{
		if(aWeight<=0)
		{
			setWeight(1.0);
			return;
		}
		this.weight = aWeight;
	}
	//to String
	public String toString()
	{
		return this.type + " " + this.weight;
	}
	//lets your compare the weights
	public int compareTo(Fruit aFruit)
	{
		if(aFruit == null)
			return 0;
		if(this.weight > aFruit.getWeight())
			return 1;
		else if(this.weight < aFruit.getWeight())
			return -1;
		else
			return 0;
	}

}
