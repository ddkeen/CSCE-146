/*
 * David Keen
 * 3/25/20
 * CSCE 146H
 * Lab06
 */
//Program to test if Binary Search or Linear Search is more efficient
import java.util.Random;
public class LinearSearchVsBinarySearch {
	public static final int MAX_TESTS = 20;
	public static final int ARRAY_SIZE = 1000;
	//counts per test
	public static int linearCount = 0;
	public static int binaryCount = 0;
	//total count
	public static int tLinearCount = 0;
	public static int tBinaryCount = 0;
	//main method
	public static void main(String[] args) 
	{
		//test 20 times
		for(int i=0; i<MAX_TESTS; i++)
		{
			System.out.println("TEST: " + (i+1));
			test();
			System.out.println("----------------------------------------");
		}
		//after all tests are over, print out the average number of checks for each tests to see which is more efficient
		int aLin = tLinearCount/MAX_TESTS;
		int aBin = tBinaryCount/MAX_TESTS;
		System.out.println("RESULTS");
		System.out.println("Average number of Linear Search Checks: " +aLin);
		System.out.println("Average number of Binary Search Cehcks: " +aBin);

	}
	
	public static void test()
	{
		//reset counts for each new test
		linearCount=0;
		binaryCount=0;
		//get a random sorted array of 1000 integers 0-999
		int[] arr = genRandomSortedArray();
		Random rand = new Random();
		//get a random target value 0-999 to look for
		int target = rand.nextInt(ARRAY_SIZE);
		//search the array using each search method and also count the number of checks
		boolean foundLin = linSearch(arr,target);
		boolean foundBin = binSearch(arr,target,0,ARRAY_SIZE-1);
		//both will be true or both will be false
		System.out.println("Searching using linear search. Found?");
		System.out.println(foundLin);
		System.out.println("Searching using binary search. Found?");
		System.out.println(foundBin);
		//print out the number of checks for each search method and add them to the total for each
		System.out.println("Linear Checks: " + linearCount);
		System.out.println("Binary Checks: " + binaryCount);
		tLinearCount += linearCount;
		tBinaryCount += binaryCount;

	}
	
	public static int[] genRandomSortedArray()
	{
		int[] ret = new int[ARRAY_SIZE];
		Random r = new Random();
		//random array of 1000 with elements 0-999 random
		for(int j=0; j<ARRAY_SIZE; j++)
		{
			ret[j] = r.nextInt(ARRAY_SIZE);
		}
		//sort the array
		quickSort(ret,0,ret.length-1);
		return ret;
	}
	public static void quickSort(int[] a, int start, int end)
	{
		//partition
		int index = partition(a, start, end);
		//recursively call quicksort
		if(start<index-1)
			quickSort(a,start,index-1);
		if(end > index)
			quickSort(a,index,end);
	}
	public static int partition(int[] a, int start, int end)
		{
			int i = start;
			int j = end;
			int pivot = a[(start+end)/2];//middle value
			//move i and j until they cross over each other
			while (i<=j)
			{
				while(a[i] < pivot)
					i++;
				while (a[j] > pivot)
					j--;
				//swap values not in order
				if(i <= j)
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
		}
			return i;
	
		}
	public static boolean linSearch(int[] a, int value)
	{
		//search for the target value one by one
		for(int i=0;i<a.length;i++)
		{
			linearCount++;
			if(a[i] == value)
				return true;
		}
		return false;
	}
	
	public static boolean binSearch(int[] a, int value, int min, int max)
	{
		//false if not found
		if(min > max)
			return false;
		//divide array into two parts and recursively call binSearch for whichever half the number is in
		int mid = (max+min)/2;
		binaryCount++;
		if(a[mid] == value)
			return true;
		else
		{
			if(a[mid]>value)
				return binSearch(a,value,min,mid-1);
			else
				return binSearch(a,value,mid+1,max); 
		}
	}
		

}
