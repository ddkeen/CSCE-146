/*
 * David Keen
 * 1/24/20
 * CSCE 146H
 * Homework 00
 */
//My game has the player move first each time. To have the CPU move first after a player win, just delete the if(!emptyboard) statement in line 47
//To have a random player move first I could have just done a random number 0 or 1, if 0, player moves, if 1, CPU moves. After each turn that number is just incremented or subtracted by 1 so the other player can move
import java.util.Scanner;
public class TicTacToeFrontEnd {

	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		int numWins = 0;
		boolean play = true;
		boolean emptyboard = false;
		TicTacToe game = new TicTacToe();
		System.out.println("Welcome to Tic Tac Toe Tourney!  How many games can you win in a row?");
		while(play)
		{
			//Player's Turn
			game.playerTurn();
			emptyboard = false;
			//Check if the player has won, if so, the number of wins increases, the board is reset, and they play again
			if(game.checkVictory())
			{
				game.printBoard();
				System.out.println("You Win!");
				numWins++;
				game.reset();
				//this tells us if the board is blank. The user always gets to start the match.
				emptyboard=true;
				System.out.println("The computer demands a rematch");
			}
			//Checks if the board is full after the players Turn, Since there is an odd number of spaces and the player always goes first, this can only happen after the players turn
			//If there is a full board, the board is reset and they play again
			if(game.checkCAT())
			{
				game.printBoard();
				System.out.println("This game has ended in a tie");
				game.reset();
				emptyboard=true;
				System.out.println("The computer demands a rematch");
			}
			//Only executes if there is not a blank board because that means the player already went. If it is a blank board then a game has just ended and the player moves first.
			if(!emptyboard)
			{
				//CPU's Turn
				game.CPUTurn();
				//Checks if the CPU has won, if so, it prints out the number of player wins in a row and allows the user to play again or quit
				if(game.checkVictory())
				{
					System.out.println("You lost but you won " + numWins + " in a row");
					System.out.println("Would you like to play again? Enter yes or no:");
					String again = keyboard.next();
					//if the user doesn't type yes, the boolean won is changed to false which will exit the while loop
					if(!(again.equalsIgnoreCase("yes")))
					{
						play = false;
						System.out.println("Thanks for Playing!");
					}
					//if the player wants to play again, the board is reset and their number of wins goes back to 0
					else
					{
						game.reset();
						numWins = 0;
					}
				}
			}
			
		}
		

	}

}
