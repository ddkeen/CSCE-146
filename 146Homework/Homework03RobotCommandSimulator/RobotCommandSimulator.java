import java.io.File;
import java.util.Scanner;

/*
 * David Keen
 * 2/21/20
 * CSCE 146H
 * Homework 03
 */
//an implementation of this class is used in RobotCommandSimulatorFrontEnd
//this class uses a queue form the class GenLLQueue
public class RobotCommandSimulator {
	//the baord size is always 10x10
	public static final int BOARD_SIZE = 10;
	//the command file has several lines conatining "Move" followed by a space, followed by a directional command. 
	//The space is our delimeter for reading the file
	public static final String DELIM = " ";
	//the board is a 2 dimensional array of Strings
	private String[][] board;
	//commands put in a Linked List Queue of Strings
	private GenLLQueue commands;
	//coordinates for the robot shown with an "O"
	private int xPos;
	private int yPos;
	//whether the robot has run into an X or out of bounds
	private boolean hasNotCrashed;
	
	//default constructor that sets robot position to (0,0), instantiates the 10 x 10 board array and String LL Queue, and sets hasNotCrashed to true
	public RobotCommandSimulator()
	{
		board = new String[BOARD_SIZE][BOARD_SIZE];
		xPos = 0;
		yPos = 0;
		hasNotCrashed = true;
		commands = new GenLLQueue<String>();
	}
	//reads in the board from file, sets the array to picture this file one String at a time
	public void readBoard(String aFilename)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFilename));
			//double for loop
			for(int i = 0; i<BOARD_SIZE; i++)	
			{
				//each line in the file is a continuous string of length 10
				String str = fileScanner.nextLine();
				for(int j = 0; j<BOARD_SIZE; j++)
				{
					//make a new String of length 1 to be placed into its corresponding spot in the array
					String s = str.substring(j,j+1);
					board[i][j] = s;
				}
			}
		
		}
		//catch if the file is formatted correctly or not found
		catch(Exception e)
		{
			System.out.println("FILE FORMATTED INCORRECTLY OR NOT FOUND");
		}
	}
	//reads in the commands from file and puts the directional commands in the String Queue
	public void readCommands(String aFilename)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFilename));
			//the amount of commands in the file is not known so we use a while loop
			while (fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				//split the line using the space delimeter and put the second element in the queue becasue it is the command
				//the first line in the splitLine array is just the word "move"
				String[] splitLine = fileLine.split(DELIM);
					commands.enqueue(splitLine[1]);
			}
		}
		//catch if the file is formatted correctly or not found
		catch(Exception e)
		{
			System.out.println("FILE FORMATTED INCORRECTLY OR NOT FOUND");
		}
	}
	//move the robot one space
	public void move()
	{
		//keep track of previous position so it can be set back to _
		int prevX = xPos;
		int prevY = yPos;
		//dequeue a command 
		String comm = (String) commands.dequeue();
		//find which directional command it is and change position variable accordingly
		if(comm.equalsIgnoreCase("up"))
			yPos--;
		else if(comm.equalsIgnoreCase("down"))
			yPos++;
		else if(comm.equalsIgnoreCase("left"))
			xPos--;
		else if(comm.equalsIgnoreCase("right"))
			xPos++;
		//only four possible commands, all others result in a return without a movement.
		else
		{
			System.out.println("Invalid Command from the Queue!");
			return;
		}	
		//test if move puts robot out of bounds
		if(xPos>9 || xPos<0 || yPos>9 || yPos<0)
		{
			System.out.println("CRASH!");
			hasNotCrashed = false;
			return;
		}
		//test if move puts robot in an X space
		if(board[yPos][xPos].equals("X"))
		{
			System.out.println("CRASH!");
			hasNotCrashed = false;
			return;
		}
		//change current position to "O" in the array
		board[yPos][xPos] = "O";
		//Change previous position to "_"
		board[prevY][prevX]	= "_";
	}
	//print the board using a for each loop
	public void printBoard()
	{
		for(String[] str : board)
		{
			for(String s: str)
				System.out.print(s);
			System.out.println();
		}
		System.out.println();
	}
	//reset the robot to the (0,0) position for the start of each new set of commands
	public void resetRobot()
	{
		board[0][0] = "O";
	}
	//check if there are any more elements in the queue
	public boolean hasMoreCommands()
	{
		return commands.peek()!=null;
	}
	//return whether the robot has not crashed
	public boolean hasNotCrashed()
	{
		return hasNotCrashed;
	}

}
