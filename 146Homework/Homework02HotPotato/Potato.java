/*
 * David Keen
 * 2/7/20
 * CSCE 146H
 * Homework 02 Hot Potato
 */

//Potato Class to be used for the Hot Potato Game
import java.util.Random;
public class Potato {
	//Max amount of time is 180 seconds
	public static final int MAX_TIME = 180;
	//All a potato needs is a timer
	private int timer;
	//need random class to get a random number of seconds
	Random rand = new Random();
	//Constructor
	public Potato()
	{
		//set the timer to a random int
		timer = rand.nextInt(MAX_TIME)+1;
	}
	//decrease timer by a number 1-10 in the game
	public void decreaseTimer(int time)
	{
		timer = timer - time;
	}
	//get method for the time used for testing purposes
	public int getTime()
	{
		return timer;
	}
	//reset timer used to reset the timer when a player is removed from the list after a hot potato
	public void resetTimer()
	{
		timer = rand.nextInt(180)+1;
	}

}
