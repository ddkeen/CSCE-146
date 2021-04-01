
public class Faculty extends Person {
	//Instance Variables
	private double salary;
	private String title;
	//Constructors
	public Faculty()
	{
		super();
		this.salary = 0.0;
		this.title = "none yet";
	}
	public Faculty(String aName, double aSalary, String aTitle)
	{
		super(aName);
		this.setSalary(aSalary);
		this.setTitle(aTitle);
	}
	
	public double getSalary()
	{
		return salary;
	}
	public String getTitle()
	{
		return title;
	}
	
	public void setSalary(double salary)
	{
		if(salary <0.0)
			this.salary = 0.0;
		else
			this.salary = salary;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String toString()
	{
		return super.toString()+
				"Salary: "+this.salary+"\nTitle: " + this.title+"\n";
	}
	public boolean equals(Faculty aFac)
	{
		return super.equals(aFac) &&
				this.salary == aFac.getSalary() &&
				this.title.equals(aFac.getTitle());
	}
}
