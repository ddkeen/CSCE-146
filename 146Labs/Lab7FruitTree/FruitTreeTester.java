/*
 * David Keen
 * 4/1/20
 * CSCE 146H
 * Lab 07 Fruit Tree
 */
import java.io.File;
import java.util.Scanner;
public class FruitTreeTester {

	public static void main(String[] args) 
	{
		//foront end and make a Scanner to read the file name
		System.out.println("Welcome to the fruit tree!\nPlease enter a Fruit File Name");
		Scanner key = new Scanner(System.in);
		String fileName = key.nextLine();
		System.out.println("Populating tree file");
		//make tree
		GenericBinarySearchTree<Fruit> tree = new GenericBinarySearchTree<Fruit>();
		//read the fiile contents and populate the tree
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split("\t");
				if(splitLine.length == 2)
				{
					String type = splitLine[0];
					double weight = Double.parseDouble(splitLine[1]);
					Fruit fruit = new Fruit(type,weight);
					tree.add(fruit);
					
				}
			}
			//ALWAYS CLOSE
			fileScanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//print in all 3 orders, remove an element and print in order again
		System.out.println("In-Order Traveral");
		tree.printInOrder();
		System.out.println("Pre-Order Traveral");
		tree.printPreOrder();
		System.out.println("Post-Order Traveral");
		tree.printPostOrder();
		System.out.println("Deleting Apple	0.4859854312170728");
		tree.remove(new Fruit("Apple" ,0.4859854312170728));
		System.out.println("In-Order Traveral");
		tree.printInOrder();
	}

}
