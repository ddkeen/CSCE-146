/*
 * David Keen
 * 1/31/20
 * CSCE 146H
 * Homework 01
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Showcase {
	//showdown is the number of prizes a uer has to guess the price of
	//numPrizes is the number of prizes in the file and how many that can be chosen
	public static final int showdown = 5;
	public static final int numPrizes =50;
	private Prize [] showcase;
	private Prize[] prizeList;
	//Populates the Prize List by Reading from the file
	public Showcase() throws FileNotFoundException
	{
		showcase = new Prize[showdown];
		prizeList = new Prize[numPrizes];
		populatePrizeList("prizeList.txt");
	}
//Populates the showcase by getting 5 random Prizes from the prize list of 50, can have duplicates
	public void populateShowcase()
	{
		Random rand = new Random();
		for(int i =0; i<showdown; i++)
		{
			int index = rand.nextInt(numPrizes);
			showcase[i] = prizeList[index];
		}
	}
	//populates prize list by reading from file
	public void populatePrizeList(String fileName) throws FileNotFoundException
	{
		try
		{
			Scanner scan = new Scanner(new File(fileName));
			//i is the index
			int i=0;
			while (scan.hasNextLine())
			{
				String fileLine = scan.nextLine();
				//split Lines into two string, first is prize name second is price
				String[] splitLines = fileLine.split("\t");
				String name = "";
				double price = 0;
				//if zero or more than 1 tab then the line is formatted incorrectly, skip to the next one
				if(splitLines.length!=2)
					continue;
				name = splitLines[0];
				//must make the number a double so parse it from string
				price = Double.parseDouble(splitLines[1]);
				//create a prize and add it to the next index in prizelist
				Prize aPrize = new Prize(price,name);
				prizeList[i] = aPrize;
				//increment the index
				i++;
			}
			scan.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(Exception e)
		{
			System.out.println("File formatted Incorrectly");
		}		
	}
	//method to get the total cost of the items in  the showcase
	public double getTotalCost()
	{
		double cost =0;
		for(int i = 0; i<showcase.length;i++)
			cost+=showcase[i].getPrice();
		return cost;
			
	}
	//print all the prizes in the showcase without price  
	public void printShowcase()
	{
		for(int i = 0; i<showcase.length;i++)
			System.out.println(showcase[i].getName());
	}
		
			
	
	
}
