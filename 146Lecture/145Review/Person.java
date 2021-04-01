//Step 1. Define the class
public class Person {
	//Step 2. Instance Variables - scope must be private
	private String name;
	//Step 3. Constructors
	public Person() //Default
	{
		this.name = "none";
	}
	public Person(String aName)
	{
		this.setName(aName);
	}
	//Step 4. Accesssors
	public String getName()
	{
		return this.name;
	}
	//Step 5. Mutators
	public void setName(String aName)
	{
		this.name = aName;
	}
	//Step 6. Other Useful methods
	public String toString()
	{
		return "Name: "+this.name;
	}
	public boolean equals(Person aPerson)
	{
		// always check if null
		return aPerson != null  && 
				this.name.equals(aPerson.getName());
	}

}
