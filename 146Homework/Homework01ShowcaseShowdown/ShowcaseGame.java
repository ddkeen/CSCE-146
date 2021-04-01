/*
 * David Keen
 * 1/31/20
 * CSCE 146H
 * Homework 01
 */
import java.io.*;
import java.util.Scanner;
public class ShowcaseGame {
	
	public static void main(String[] args) throws FileNotFoundException {
		String play = "yes";
		//runs while the user doesn't enter no, signaling they would want to quit
		while(!(play.equalsIgnoreCase("no")))
		{
			Scanner scan = new Scanner(System.in);
			//create the showcase and populate prizelist
			Showcase game = new Showcase();
			//populate the showcase
			game.populateShowcase();
			//front end for the user
			System.out.println("Welcome to the Showcase Showdown!");
			System.out.println("Your prizes are:");
			System.out.println();
			//print prizes in shocase
			game.printShowcase();
			System.out.println();
			System.out.println("You must guess the total cost of all within $2000 and without going over: ");
			//user enters guess
			System.out.println("Enter your guess: ");
			double guess = scan.nextDouble();
			scan.nextLine();
			System.out.println("You guessed $" + guess + " and the actual price is $" + game.getTotalCost());
			//if statements to determine if the user guessed correctly
			if(guess>game.getTotalCost())
				System.out.println("I'm sorry but you busted and went over!");
			else if(guess<(game.getTotalCost()-2000))
				System.out.println("You guessed too low!");
			else if(guess==game.getTotalCost())
				System.out.println("YOU GUESSED THE EXACT PRICE! WOW!");
			else
				System.out.println("Your guess was under and close enough: YOU WIN!");
			//option to quit and exit loop
			System.out.println("Would you like to play again? Enter no to quit: ");
			play = scan.nextLine();
			System.out.println();
			System.out.println();
		}
		//end of program
		System.out.println("Goodbye!");
		

	}

}
