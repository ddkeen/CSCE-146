/*
 * David Keen
 * 1/24/20
 * CSCE 146H
 * Homework 00
 */

import java.util.Random;
import java.util.Scanner;
public class TicTacToe {
	
	public static Scanner keyboard = new Scanner(System.in);
	Random rand = new Random();
	private char[][] board;
	//Standard tic tac toe board is 3x3
	public static final int SIZE =3;
	//Constructor
	public TicTacToe()
	{
		initializeBoard(SIZE);
	}
	//initialize the 3x3 board, make empty spaces '-' instead of null
	public void initializeBoard(int size)
	{
		
		this.board = new char[size][size];
		for(int i = 0; i<board.length; i++)
			for(int j = 0; j<board[i].length; j++)
				board[i][j] = '-';
	}
	//print the board
	public void printBoard()
	{
		for(int i = 0; i<board.length; i++)
		{
			for(int j = 0; j<board[i].length; j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
		
	}
	//add an X to the board for the players turn
	public void addX(int row, int col)
	{
		board[row][col] = 'X';
	}
	//add a O to the board for the CPU turn
	public void addO(int row, int col)
	{
		board[row][col] = 'O';
	}
	//Player's Turn
	public void playerTurn()
	{
		int row = -1;
		int col = -1;
		printBoard();
		System.out.println("It's your turn to place an \"X\". Row then Column. The top left corner is 0 0, the bottom right is 2 2");
		//while loop to ensure user enters valid coordinates
		while(row<0 || row>2 || col<0 || col>2 || board[row][col]=='X' || board[row][col] =='O' )
				{
					System.out.println("Enter you coordinates");
					row = keyboard.nextInt();
					col = keyboard.nextInt();
				}
		addX(row,col);
	}
	//CPU's Turn
	public void CPUTurn()
	{
		boolean placed = false;
		System.out.println("Computer's Turn: ");
		//while loop to make sure the random space is empty
		while(!placed)
		{
			int row = rand.nextInt(3);
			int col = rand.nextInt(3);
			if(board[row][col]=='-')
			{
				addO(row,col);
				placed = true;
			}
		}
	}
	//checks victory by either side 
	public boolean checkVictory()
	{
		for(int i = 0; i< board.length;i++)
			if(checkHorizontal(i))
				return true;
		for(int j = 0; j<board.length;j++)
			if(checkVertical(j))
				return true;
		if(checkDiagonal())
			return true;
		return false;
	}
	//checks for a horizontal victory
	public boolean checkHorizontal(int i)
	{
		boolean xRow = true;
		boolean oRow = true;
		for(int j = 0; j<board[i].length;j++)
			if(board[i][j]!='X')
				xRow = false;
		for(int j = 0; j<board[i].length;j++)
			if(board[i][j]!='O')
				oRow = false;
		if(xRow || oRow)
			return true;
		return false;
	}
	//checks for a vertical victory
	public boolean checkVertical(int j)
	{
		boolean xCol = true;
		boolean oCol = true;
		for(int i = 0; i<board.length;i++)
			if(board[i][j]!='X')
				xCol = false;
		for(int i = 0; i<board.length;i++)
			if(board[i][j]!='O')
				oCol = false;
		if(xCol || oCol)
			return true;
		return false;	
	}
	//checks for a diagonal victory
	public boolean checkDiagonal()
	{
		boolean xDi1 = true;
		boolean oDi1 = true;
		for(int i = 0; i<board.length; i++)
			if(board[i][i]!='X')
				xDi1 = false;
		for(int i = 0; i<board.length; i++)
			if(board[i][i]!='O')
				oDi1 = false;
		boolean xDi2 = true;
		boolean oDi2 = true;
		int j =2;
		for(int i = 0; i<board.length; i++)
		{
			if(board[i][j]!='X')
				xDi2 = false;
			j--;
		}
		int k =2;
		for(int i = 0; i<board.length; i++)
		{
			if(board[i][k]!='O')
				oDi2 = false;
			k--;
		}
		if(xDi1 || xDi2 || oDi1 || oDi2)
			return true;
		return false;
	}
	//checks if the board is full
	public boolean checkCAT()
	{
		for(int i = 0; i<board.length; i++)
			for(int j = 0; j<board[i].length; j++)
				if(board[i][j]=='-')
					return false;
		return true;
	}
	//resets board to all '-'
	public void reset()
	{
		for(int i = 0; i<board.length; i++)
			for(int j = 0; j<board[i].length; j++)
				board[i][j] = '-';
	}
	

}
