/*
 * David Keen
 * 2/7/20
 * CSCE 146H
 * Homework 02 Hot Potato
 */
import java.util.Scanner;
//Main method for the Hot Potato Game
public class HotPotatoGame {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Hot Potato Game!");
		
		String play = "yes";
		//while loop that runs the game as long as the user wants to play again
		while (!(play.equalsIgnoreCase("quit")))
		{
			//create new potato that has a countdown timer
			Potato pot = new Potato();
			System.out.println("Enter the number of players (2 or more required).");
			//create a Scanner
			Scanner key = new Scanner(System.in);
			//user input for number of players
			int num = key.nextInt();
			//make sure number of players is at least two
			if(num<2)
			{
				System.out.println("You need at least two players, we will make you a game with two");
				num=2;
			}
			key.nextLine();
			//create new CircularLinkedList
			CircularLinkedList<Person> game = new CircularLinkedList<Person>();
			//for loop that adds a Player for the number of players previously entered in the Scanner
			for(int i = 1; i<=num; i++)
			{
				System.out.println("Enter player " + i+"'s name");
				String name = key.nextLine();
				//create a new Person and add them to the linked List
				Person p = new Person(name,0);
				game.add(p);
			}
			//keep playing the game and resetting the potato when someone gets out until there is only one person in the linked list remaining
			while (game.moreThanOne())
			{
				System.out.println();
				System.out.println(game.getCurrent().getName()+ ", Enter a number from 1-10 corresponding to the number of seconds to hold the potato");
				//decrease the potato timer with a number from 1-10 from user input
				int tick = key.nextInt();
				key.nextLine();
				//if user enters a number outside of 1-10, it will be 10
				if(tick<1 || tick>10)
				{
					System.out.println("The number must be between 1 and 10, we'll assume you meant ten");
					tick = 10;
				}
				game.getCurrent().setCountdown(tick);
				//decrease timer
				pot.decreaseTimer(game.getCurrent().getCountdown());
				//if potato has run out of time, the current player is eliminated and removed from the list
				//potato timer is reset
				if(pot.getTime()<=0)
				{
					System.out.println("HOT POTATO!!!" + game.getCurrent().getName()+ " has been eliminated");
					game.removeCurrent();
					pot.resetTimer();
				}
				//if potato timer still has timer, the current player is safe and remains in the list, current moves to next ListNode
				else
				{
					System.out.println(game.getCurrent().getName()+ " is safe for now");
					game.gotoNext();
				}
			}
			//excecutes when there is only 1 ListNode left in the List (1Player)
			System.out.println();
			System.out.println(game.getCurrent().getName()+" WINS!!!");
			//user option to play again with a new amount of players
			System.out.println("Would you like to continue? Press ENTER to continue or enter \"quit\" to quit");
			play = key.nextLine();
		}
		//end of program
		System.out.println("Thanks for Playing! Goodbye.");
		

	}
}
