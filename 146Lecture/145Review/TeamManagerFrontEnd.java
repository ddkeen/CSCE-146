import java.util.Scanner;
public class TeamManagerFrontEnd{
	
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		TeamManager tm = new TeamManager();
		System.out.println("Welcome to the Team Management System!");
		boolean quit = false;
		while(!quit)
		{
			printOptions();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				insert(tm);
				break;
				
			case 2:
				delete(tm);
				break;
				
			case 9:
				System.out.println("Good Bye");
				System.exit(0);
				break;
				
				default:
					System.out.println("Incorrect option");
			}
			tm.print();
		}
	}
	//Print user option
	public static void printOptions()
	{
		System.out.println("Choose fron the following options\n"
						+ "Enter 1: To Add a Person\n"
						+ "Enter 2: To Remove a Person\n"
						+ "Enter 9: To Quit");
	}
	//Adds a person to the team
	public static void insert(TeamManager tm)
	{
		System.out.println("Is this person a:\n"
				+ "1: Undergraduate Student\n"
				+ "2: Graduate Student\n"
				+ "3: Faculty Member\n"
				+ "4: Other\n");
		int choice = keyboard.nextInt();
		keyboard.hasNextLine();
		switch(choice)
		{
		case 1:
			tm.add(makeUndergrad());
			break;
		case 2:
			tm.add(makeGrad());
			break;
		case 3:
			tm.add(makeFaculty());
			break;
		case 4:
			tm.add(makePerson());
			break;
		default:
			System.out.println("Incorrect Option");
		}
	}
	
	//Remove a person to the team
	public static void delete(TeamManager tm)
	{
		System.out.println("Is this person a:\n"
				+ "1: Undergraduate Student\n"
				+ "2: Graduate Student\n"
				+ "3: Faculty Member\n"
				+ "4: Other\n");
		int choice = keyboard.nextInt();
		keyboard.hasNextLine();
		switch(choice)
		{
		case 1:
			tm.delete(makeUndergrad());
			break;
		case 2:
			tm.delete(makeGrad());
			break;
		case 3:
			tm.delete(makeFaculty());
			break;
		case 4:
			tm.delete(makePerson());
			break;
		default:
			System.out.println("Incorrect Option");
		}
	}
	//Create an Undergraduate based on input from the user
	public static Undergraduate makeUndergrad()
	{
		System.out.println("Enter the student's name (no spaces), id, and level");
		String aName = keyboard.next();
		int anID = keyboard.nextInt();
		int aLevel = keyboard.nextInt();
		//FixUP
		keyboard.nextLine();
		return new Undergraduate(aName,anID,aLevel);
	}
	//create a graduate with user input
	public static Graduate makeGrad()
	{
		System.out.println("Eneter the student's name (no spaces), id, and advisor");
		String aName = keyboard.next();
		int anID = keyboard.nextInt();
		keyboard.nextLine();
		String adv = keyboard.nextLine();
		return new Graduate(aName, anID, adv);
	}
	
	//create a faculty
	public static Faculty makeFaculty()
	{
		System.out.println("Enter the faculty's name (no spaces), salary, and title");
		String aName = keyboard.next();
		double aSal = keyboard.nextDouble();
		//FixUP
		keyboard.nextLine();
		String aTitle = keyboard.nextLine();
		return new Faculty(aName, aSal, aTitle);
	}
	//create a person
	public static Person makePerson()
	{
		System.out.println("Enter the person's name");
		return new Person (keyboard.next());
	}
}