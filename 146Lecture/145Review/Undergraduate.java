
public class Undergraduate extends Student{
	
	private int level;
	
	public Undergraduate()
	{
		super();
		level = 1;
	}
	public Undergraduate(String aName, int anID, int aLevel)
	{
		super(aName,anID);
		setLevel(aLevel);
	}
	
	public int getLEvel()
	{
		return level;
	}
	
	public void setLevel(int aLevel)
	{
		if((1<= aLevel) && (aLevel <=4))
			level = aLevel;
		else
			level = 1;
	}
	
	public String toString()
	{
		return super.toString()+
				"Level: "+this.level+"\n";
	}
	public boolean equals(Undergraduate otherUndergraduate)
	{
		return equals((Student)otherUndergraduate) &&
				(this.level == otherUndergraduate.level)
;	}

}
