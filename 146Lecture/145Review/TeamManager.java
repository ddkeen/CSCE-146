import java.util.Scanner;
import java.io.*;
public class TeamManager {
	private Person[] team;
	public static final int DEF_SIZE = 30;
	//Constructors
	public TeamManager()
	{
		init(DEF_SIZE);
	}
	public TeamManager(int size)
	{
		init(size);
	}
	//Only called by Constructors to set the size
	private void init(int size)
	{
		if(size<=0)
			init(DEF_SIZE);
		team = new Person[size];
	}
	//Adds a person if not already fulll
	public void add(Person p)
	{
		if(team[team.length-1] != null)//Full array
			grow();
		for(int i = 0; i<team.length;i++)
		{
			if(team[i] == null)
			{	
				team[i] = p;
				break;
			}
		}
	}
	private void grow()
	{
		int newSize = team.length+1;
		Person[] newArray = new Person[newSize];
		for (int i = 0; i<team.length; i++)
			newArray[i] = team[i];
		team = newArray;
	}
	//Removes person if found
	public void delete(Person p)
	{
		int rmIndex = insert(p);
		if(rmIndex == -1)//Person not found
			return;
		for (int i = rmIndex; i<team.length-1; i++)
			team[i] = team[i+1];//shift everything over by one idex
		team[team.length-1] = null;
	}
	//returns idex if person if found or -1
	private int insert(Person p)
	{
		int rmIndex = -1;
		for(int i = 0; i<team.length; i++)
			if(team[i].equals(p))
				return i;
		return rmIndex;
	}
	
	public boolean contains(Person p)
	{
		return insert(p) != -1;
	}
	//prints all information about the people
	public void print()
	{
		for (Person p : team)
		{
			if(p==null)
				break;
			System.out.println(p);
		}
	}
	public static final String DELIM ="\t";
	public void printToFile(String aName)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new File(aName));
			//Write the Header
			//fileWriter.println("Num People" + DELIM + team.length);
			for(Person p: team)
			{
				if(p == null)
					break;
				String pStr = "";
				if(p.getClass().equals("Undergraduate"))
				{
					Undergraduate u = (Undergraduate)p;
					pStr = u.getClass()+DELIM+u.getName()+DELIM+u.getID()+DELIM+u.getLEvel();
				}
				//TODO rest of the types
				fileWriter.println(pStr);
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void readFromFile(String aFilename)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFilename));
			//Read the Header
			/*
			String fileLine = fileScanner.nextLine();
			String[] splitLine = fileLine.split(DELIM);
			//Split the line
			if(splitLine.length != 2)
				return;
			int size = Integer.parseInt(splitLine[1]);
			init(size);
			*/
			/*
			int count = 0;
			while(fileScanner.hasNextLine())
			{
				count++;
				fileScanner.nextLine();//Moves cursor down the file
			}
			if(count <= 0)
				return;
			init(count);
			fileScanner = new Scanner(new File(aFilename));//Reset Cursor to the Beginning
			*/ 
			while (fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split(DELIM);
				if(splitLine[0].contentEquals("Person"))
				{
					Person p = new Person(splitLine[1]);
					add(p);
				}
				else if (splitLine[0].equals("Undergraduate"))
				{
					String name = splitLine[1];
					int id = Integer.parseInt(splitLine[2]);
					int level = Integer.parseInt(splitLine[3]);
					add(new Undergraduate(name,id,level));
				}

			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
