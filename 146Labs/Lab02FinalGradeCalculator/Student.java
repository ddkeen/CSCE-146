/*
 * David Keen
 * CSCE 146H 
 * 1/31/20
 * Lab 02 
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Student {
	//lots of private instance variables
	private double labSum;
	private double labCount;
	private double labRSum;
	private double labRCount;
	private double hwSum;
	private double hwCount;
	private double exam01;
	private double exam02;
	private double finalExam;
	
	//constructor that sets all values to 0
	public Student() 
	{
		this.labSum = 0;
		this.labCount = 0;
		this.labRSum = 0;
		this.labRCount = 0;
		this.hwSum = 0;
		this.hwCount = 0;
		this.exam01 = 0;
		this.exam02 = 0;
		this.finalExam = 0;
	}
	//getters that cat calculate averages by dividing sum by count
	public double getLabAverage()
	{
		return labSum/labCount;
	}
	public double getLabReportAverage()
	{
		return labRSum/labRCount;
	}
	public double getHomeworkAverage()
	{
		return hwSum/hwCount;
	}
	//get methods for exams - not really needed
	public double getExam01() {
		return exam01;
	}
	public double getExam02() {
		return exam02;
	}
	public double getFinalExam() {
		return finalExam;
	}
	//gets numeric grade by calling get methods and adding their weighted values to the grade, 
	//it also calculates the two highest test scores and adds their values with a .3 weight
	public double getGradeNumeric()
	{
		double grade = 0;
		grade += getLabAverage()*.10;
		grade+= getLabReportAverage()*.10;
		grade += getHomeworkAverage()*.20;
		if(getExam01()>=getExam02())
		{
			grade += exam01*.3;
			if(getExam02()>=getFinalExam())
				grade+=exam02*.3;
			else
				grade+=finalExam*.3;
		}
		else
		{
			grade+=exam02*.3;
			if(getExam01()>=getFinalExam())
				grade+=exam01*.3;
			else
				grade+=finalExam*.3;
		}
		return grade;
		
	}
	//Calculates a letter grade based on the 4.0 scale,using the adjusted grade, no minuses
	public String getGradeLetter()
	{
		if(getGradeRounded()>=90)
			return "A";
		else if(getGradeRounded()>=85)
			return "B+";
		else if(getGradeRounded()>=80)
			return "B";
		else if(getGradeRounded()>=75)
			return "C+";
		else if(getGradeRounded()>=70)
			return "C";
		else if(getGradeRounded()>=65)
			return "D+";
		else if(getGradeRounded()>=60)
			return "D";
		return "F";
	}
	//rounds grade to nearest whole number
	public int getGradeRounded()
	{
		return (int) Math.ceil(getGradeNumeric());
	}
	//reads the grade file using a scanner and delimiter of the tab and new line
	public void readGradeFile(String fileName) throws FileNotFoundException
	{
		try
		{
			Scanner scan = new Scanner(new File(fileName));
			//while still lines in the file
			while (scan.hasNextLine())
			{
				String fileLine = scan.nextLine();
				//split into two sections, before tab is assignment type and after is the grade
				String[] splitLines = fileLine.split("\t");
				//if there is multiple tabs or no tabs in a line that line was not formatted correctly, this skips to the next line
				if(splitLines.length!=2)
					continue;
				String type = "";
				int grade = 0;		
				//assignment type is the first value in the splitLines array
				type = splitLines[0];
				//must parse int becasue when reading from a file it is a string
				grade = Integer.parseInt(splitLines[1]);
				//determine which type of assingment it is and adds to the count and adds the grade
				if(type.equals("LAB"))
				{
					labCount++;
					labSum += grade;
				}
				else if(type.equals("LAB REPORT"))
				{
					labRCount++;
					labRSum += grade;
				}
				else if(type.equals("HOMEWORK"))
				{
					hwCount++;
					hwSum += grade;
				}
				else if(type.equals("EXAM 1"))
					exam01 = grade;
				else if(type.equals("EXAM 2"))
					exam02 = grade;
				else if(type.equals("FINAL"))
					finalExam = grade;
				}
			//close scanner
			scan.close();
		}
		//catch blocks for Exceptions
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(Exception e)
		{
			System.out.println("File formatted Incorrectly");
		}		
		
			
	}
	//toString method
	public String toString() {
		return "Lab Average: " + getLabAverage() + "\nLab Report Average: " + getLabReportAverage()
				+ "\nHomework Average: " + getHomeworkAverage() + "\nExam 1: " + getExam01() + "\nExam 2: "
				+ getExam02() + "\nFinal Exam: " + getFinalExam() + "\nRaw Total: " + getGradeNumeric()
				+ "\nAdjusted: "+ getGradeRounded() + "\nGrade: " + getGradeLetter();
	}
	
	 
	
	

}
