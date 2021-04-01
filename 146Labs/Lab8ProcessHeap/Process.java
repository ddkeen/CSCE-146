/*
 * David Keen
 * CSCE 146H
 * 4/8/20
 * Lab8 Process Heap
 */
//implement comparable so we can use this in a heap
public class Process implements Comparable<Process>{
	//private instance variables
	private int priority;
	private double time;
	private String name;
	//default and parameterized constructor
	public Process()
	{
		priority = 0;
		time =0.0;
		name = "none";
	}
	public Process(String n, int p, double t)
	{
		setPriority(p);
		setTime(t);
		setName(n);
	}
	//accessor methods
	public int getPriority()
	{
		return this.priority;
	}
	public double getTime()
	{
		return this.time;
	}
	public String getName()
	{
		return this.name;
	}
	//set methods that check for valid values
	public void setPriority(int p)
	{
		if(p >= 0)
			this.priority =p;
		else
			this.priority =0;
	}
	public void setTime(double t)
	{
		if(t >= 0.0)
			this.time =t;
		else
			this.time =0.0;
	}
	public void setName(String n)
	{
		if(n == null)
			this.name = "none";
		else
			this.name = n;

	}
	//to String
	public String toString()
	{
		return "Name: "+this.name+ " Time: "+this.time+" Priority: "+this.priority;
	}
	//gotta have that compare since we implemented comparable
	public int compareTo(Process p)
	{
		if(p == null)
			return 0;
		if(this.priority<p.getPriority())
			return -1;
		else if(this.priority>p.getPriority())
			return 1;
		else
			return 0;
	}
	

}
