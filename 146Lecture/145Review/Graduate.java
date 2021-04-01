
public class Graduate extends Student{
	
	private String advisor;
	
	public Graduate()
	{
		super();
		this.advisor = "none yet";
	}
	public Graduate(String aName, int anID, String anAdvisor)
	{
		super(aName,anID);
		setAdvisor(anAdvisor);
	}
	
	public String getAdvisor()
	{
		return advisor;
	}
	
	public void setAdvisor(String advisor)
	{
		this.advisor = advisor;
	}
	
	public String toString()
	{
		return super.toString()+
				"Advisor: "+this.advisor+"\n";
	}
	public boolean equals(Graduate aGrad)
	{
		return super.equals(aGrad) &&
				this.advisor.equals(aGrad.getAdvisor());
		
	}
}

