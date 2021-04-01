
public class Student extends Person{
	//Instance Variables
	private int id;//Must be nonNegative
	//Constructors
	public Student()
	{
		super(); //Call's person's constructor
		this.id = 0;
	}
	public Student(String aName, int anID)//Parameterized
	{
		super(aName);//super's param constructor
		this.setID(anID);//call to mutator to set values
	}
	//Accessors
	public int getID()
	{
		return this.id;
	}
	//Mutators
	public void setID(int anID)
	{
		if(anID <=0)
			this.id = 0;
		else
			this.id = anID;
	}
	//helper methods
	public boolean equals(Student aStudent)
	{
		return aStudent != null &&
				super.equals(aStudent) &&
				this.id == aStudent.getID();
	}
	
	public String toString()
	{
		return super.toString()+
				"\nStudent Number: " + this.id + " \n";
	}

}
