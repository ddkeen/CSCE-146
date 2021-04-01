/*
 * David Keen
 * CSCE 146H
 * EXAM 02 QUESTION 1
 */
public class SearchAlgorithm {
	//Do not alter------------------------------------------
	public static double[] doubleArray = {0,1,2,3,4,5,6,7,8,9,10};
	//------------------------------------------------------
	public static boolean search(double[] a, double target)
	{
		int min = 0;
		int max = a.length-1;
		return searchRecur(a,target,min,max);
	}
	public static boolean searchRecur(double[] a, double target, int min, int max)
	{
		if(min > max)
			return false;
		int mid = (max+min)/2;
		if(a[mid] == target)
			return true;
		else
		{
			if(a[mid]>target)
				return searchRecur(a,target,min,mid-1);
			else
				return searchRecur(a,target,mid+1,max); 
		
		}
	}
}
