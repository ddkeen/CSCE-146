/*
 * David Keen
 * 2/21/20
 * CSCE 146H
 * Homework 03
 */
import java.util.Scanner;
//main method for the RobotCommandSimulator
public class RobotCommandSimulatorFrontEnd {
	
	public static void main(String[] args) {
		//String to check if the user wants to run another simulation
		String run = "";
		//runs simulations while the user does not enter "quit"
		while(!(run.equalsIgnoreCase("quit")))
		{
			//create the robotCommandSimulator
			RobotCommandSimulator rob = new RobotCommandSimulator();
			//create the scanner
			Scanner key = new Scanner(System.in);
			//front end output
			System.out.println("Welcome to the Robot Simulator");
			System.out.println("Enter file for the Board");
			//user enters board file and the board array is then filled
			String boardFile = key.nextLine();
			rob.readBoard(boardFile);
			System.out.println("Enter file for Robot Commands");
			//user enters command file and the commands are entered into the queue
			String commandsFile = key.nextLine();
			rob.readCommands(commandsFile);
			//reset robot position to (0,0)
			rob.resetRobot();
			//print the board at the start
			rob.printBoard();
			System.out.println("Simulation Begin");
			//count of commands
			int command=0;
			//run the next command and move the robot if the robot has not crashed and there are commands remaining in the queue
			while(rob.hasNotCrashed() && rob.hasMoreCommands())
			{
				System.out.println("Command " + command);
				command++;
				rob.move();
				//print if the last move didn't result in a crash
				if(rob.hasNotCrashed())
					rob.printBoard();
			}
			//simulation is over, user has option to run another or exit by entering "quit"
			System.out.println("Simulation end");
			System.out.println("Quit? Enter quit to exit or enter anything else to run another simulation");
			run  = key.next();
		}
		//End of simiulation
		System.out.println("Adios Amigo");
	}

}
