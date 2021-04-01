/*
 * David Keen
 * CSCE 146H
 * 1/31/20
 * Lab02
 */
import java.io.*;
import java.util.Scanner;
public class Grader {

	//This is the main method that simply reads in the file and populates the assignment categories with grades,
	//then prints the averages of those weighted categories, then prints the Raw, Adjusted, and Letter Grade according,
	//to the grade criteria. Keeps reading new student grade files until user enters "quit"
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println("Welcome to the Grader Program");
		System.out.println("Enter a file name or " + "quit " + "to exit" );
		String fileName = key.nextLine();
		System.out.println();
		while(!(fileName.equals("quit")))
		{
			Student jj = new Student();
			jj.readGradeFile(fileName);
			System.out.println(jj.toString());
			System.out.println();
			System.out.println("Enter a file name or " + "quit " + "to exit" );
			fileName = key.nextLine();
			System.out.println();
		}
		System.out.println("Goodbye");
		key.close();

	}

}
