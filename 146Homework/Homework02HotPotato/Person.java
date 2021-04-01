/*
 * David Keen
 * 2/7/20
 * CSCE 146H
 * Homework 02 Hot Potato
 */
//Person class to be added to a Cirular Linked List for the Hot Potato Game
public class Person {
	//private instance variables, name, countdown, and IsIn
	private String name;
	private int countdown;
	//I did not need IsIn for the HotPotato Game because instead of checking if the person was still in the game I simply removed them from the Linked List
	private boolean IsIn;
	
	//Parameterized Constructor
	public Person(String aName, int aCountdown)
	{
		name = aName;
		countdown = aCountdown;
		IsIn =true;
	}
	//get and set Methods
	public String getName() {
		return name;
	}

	public int getCountdown() {
		return countdown;
	}

	public boolean isIsIn() {
		return IsIn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountdown(int countdown) {
		this.countdown = countdown;
	}

	public void setIsIn(boolean isIn) {
		IsIn = isIn;
	}

	

}
