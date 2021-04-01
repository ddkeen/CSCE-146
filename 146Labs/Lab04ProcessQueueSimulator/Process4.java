/*
 * David Keen
 * CSCE 146H
 * 2/14/20
 * Lab 04 Process Queue Simulator
 */
public class Process4 {
	//private instance variables
	private String name;
	private double completionTime;

	//default constructor
	public Process4()
	{
		setName("No Name");
		setCompletionTime(0.0);
	}
	//parameterized constructor
	public Process4(String aName, double aTime)
	{
		setName(aName);
		setCompletionTime(aTime);
	}

	//get and set methods
	public String getName()
	{
		return name;
	}
	public void setName(String aName)
	{
		
		name = aName;
	}
	public double getCompletionTime()
	{
		return completionTime;
	}
	//sets completion time and makes sure aTime is a positive value or changes it to 0.0
	public void setCompletionTime(double aTime)
	{
		if(aTime<0) //invalid
			this.completionTime = 0.0;
		else 
			this.completionTime=aTime;
	}
	//To String
	public String toString()
	{
		return "Process Name: " + this.name + " Completion Time: " + this.completionTime;
	}

}
