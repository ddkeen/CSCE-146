/*
 * David Keen
 * CSCE146 H01
 * 1/17/20
 */
import java.util.Random;

public class MineArray {
	//default values for a 10x10 array with 10 mines
	public static final int DEF_SIZE = 10;
	public static final int NUM_MINES = 10;
	public static final String EMPTY_SPACE = "-";
	public static final String MINE_SPACE = "*";
	//private instance variables
	private String [][] field;
	private int width;
	private int height;
	private int numMines;
	//default constructor
	public MineArray()
	{
		init(DEF_SIZE, DEF_SIZE, NUM_MINES);
	}
	//parameterized constructor
	public MineArray(int sizeRow, int sizeCol, int numberOfMines)
	{
		init(sizeRow, sizeCol, numberOfMines);
	}
	//initializer method to set private instance variables and check if the parameters are valid, if not it creates the default array
	public void init(int sizeRow, int sizeCol, int numberOfMines)
	{
		if(sizeRow<=0 || sizeCol<=0 || numberOfMines > sizeRow*sizeCol)
			init(DEF_SIZE, DEF_SIZE, NUM_MINES);
		width = sizeRow;
		height = sizeCol;
		numMines = numberOfMines;
		field = new String[sizeRow][sizeCol];
	}
	//acessor methods
	public int getwidth()
	{
		return this.width;
	}
	public int getheight()
	{
		return this.height;
	}
	public int getNumMines()
	{
		return this.numMines;
	}
	//resets all the values in the array to "-"
	public void reset()
	{
		for(int row = 0; row<field.length;row++)
			for(int col = 0; col<field[row].length;col++)
				{
					field[row][col] = EMPTY_SPACE;
				}
	}
	//adds a mine to the array at a random index, if the index of the array already has a mine, the method is called again
	public void addMine()
	{
		Random rand = new Random();
		int row = rand.nextInt(getwidth());
		int col = rand.nextInt(getheight());
		if(field[row][col].equals(MINE_SPACE))
			addMine();
		field[row][col] = MINE_SPACE;
	}
	//calls the method addMine for the number of mines that should be in the array be calling the getNumMines accessor method
	public void placeMines()
	{
		int count = 0;
		while (count<getNumMines())
		{
			addMine();
			count++;
		}
			
	}
	//method to check if there is a mine at index row, col. This method is used in the increment method that is used for counting adjacent squares
	public boolean checkMine(int row, int col)
	{
		return(field[row][col].equals(MINE_SPACE));
			
	}
	//prints the array
	public void print()
	{
		for(String[] row: field)
		{
			for(String mine: row)
				System.out.print(mine);
			System.out.println();
		}
	}
	//increment method that is used to add 1 to a count in the countAdjacentSquares method if there is a mine in an adjacent space
	public int increment(int row, int col)
	{ 
		if(checkMine(row,col))
			return 1;
		return 0;
			
	}
	//if there isn't a mine in the space, this method counts all the adjacent squares with mines at index row,col.
	public int countAdjacentSquares(int row, int col)
	{
		int count = 0;
		//mine in this space, no count needed
		if(field[row][col].equals(MINE_SPACE))
			return -1;
		//1st row
		if(row == 0)
		{
			//top left corner
			if(col==0)
			{
				count+=increment(row,col+1);
				count+=increment(row+1,col);
				count+=increment(row+1,col+1);
			}
			//top right corner
			else if(col==getheight()-1)
			{
				count+=increment(row,col-1);
				count+=increment(row+1,col);
				count+=increment(row+1,col-1);
			}
			//top edge 
			else
			{
				count+=increment(row,col+1);
				count+=increment(row+1,col);
				count+=increment(row+1,col+1);
				count+=increment(row,col-1);
				count+=increment(row+1,col-1);
			}
		}
		//last row
		else if(row == getwidth()-1)
		{
			//bottom left corner
			if(col==0)
			{
				count+=increment(row,col+1);
				count+=increment(row-1,col);
				count+=increment(row-1,col+1);
			}
			//bottom right corner
			else if(col==getheight()-1)
			{
				count+=increment(row,col-1);
				count+=increment(row-1,col);
				count+=increment(row-1,col-1);
			}
			//bottom edge
			else
			{
				count+=increment(row,col+1);
				count+=increment(row-1,col);
				count+=increment(row-1,col+1);
				count+=increment(row,col-1);
				count+=increment(row-1,col-1);
			}
		}
		//left edge
		else if(col==0)
		{
			count+=increment(row+1,col);
			count+=increment(row-1,col);
			count+=increment(row-1,col+1);
			count+=increment(row,col+1);
			count+=increment(row+1,col+1);
		}
		//right edge
		else if (col==getheight()-1)
		{
			count+=increment(row,col-1);
			count+=increment(row-1,col);
			count+=increment(row-1,col-1);
			count+=increment(row+1,col-1);
			count+=increment(row+1,col);
		}
		//interior point
		else
		{
			count+=increment(row,col+1);
			count+=increment(row-1,col);
			count+=increment(row-1,col+1);
			count+=increment(row,col-1);
			count+=increment(row-1,col-1);
			count+=increment(row+1,col);
			count+=increment(row+1,col+1);
			count+=increment(row+1,col-1);
		}
		return count;
		
		
	}
	//gives numeric values to all the values in the array that aren't mines by counting the number of adjacent mines with the menthod countAdjacentSquares
	public void mineCount()
	{
		for(int row = 0; row<field.length;row++)
			for(int col = 0; col<field[row].length;col++)
				if(countAdjacentSquares(row,col)!=-1)
						field [row][col] = String.valueOf(countAdjacentSquares(row,col));
	}

	

}
