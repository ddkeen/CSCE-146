/*
 * David Keen
 * 2/21/20
 * CSCE 146H
 * Lab05
 */
//main method for the reverse polish calulator calss that uses a Generic Linked List
import java.util.Scanner;
public class ReversePolishCalculatorFrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		//create the calculator
		ReversePolishCalculator rpCal = new ReversePolishCalculator();
		boolean quit = false;
		//run while the user doesn't want to quit
		while(quit == false)
		{
			//user enters a reverse polish string or chooses to quit
			System.out.println("Enter a reverse polish expression or \"quit\" to quit");
			String input = keyboard.nextLine();
			//exits the program because the user chose to quit
			if(input.equalsIgnoreCase("quit"))
			{
				System.out.println("Goodbye");
				break;
			}
			//calculates the result of the expression that the user gave.
			System.out.println(rpCal.calculate(input));
		}
			
	}

}