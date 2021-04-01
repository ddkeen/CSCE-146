/*
 * David Keen
 * 1//24/20
 * CSCE 146H
 * Lab 01
 */
public class WordHelper {
	
	//Method to Sort wordList by number of vowels
	public static String[] sortByVowels(String[] words)
	{
		//create a new array, the same length of the array given
		String[] sorted = copy(words);
		//bubble sort using a while loop that will go through the list again if there was a swap. If there were no swaps, the list is sorted
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for (int i = 0; i<sorted.length-1; i++)
			{
				if(countVowels(sorted[i])>countVowels(sorted[i+1]))
				{
					String temp = sorted[i];
					sorted[i] = sorted[i+1];
					sorted[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		//returns new array
		return sorted;	
	}
	//sorts method by number of consonants
	public static String[] sortByConsonants(String[] words)
	{
		//new array same length of given array
		String[] sorted = copy(words);
		//another bubble sort
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for (int i = 0; i<sorted.length-1; i++)
			{
				if(countConsonants(sorted[i])>countConsonants(sorted[i+1]))
				{
					String temp = sorted[i];
					sorted[i] = sorted[i+1];
					sorted[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		//retrun new array
		return sorted;	
	}
	//sort array by number of letters or length
	public static String[] sortByLength(String[] words)
	{
		//new array
		String[] sorted = copy(words);
		//bubble sort
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for (int i = 0; i<sorted.length-1; i++)
			{
				if(sorted[i].length()>sorted[i+1].length())
				{
					String temp = sorted[i];
					sorted[i] = sorted[i+1];
					sorted[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		//return new array
		return sorted;	
	}
	//method to test if a one character string is a vowel, used in count vowels.
	public static boolean isVowel(String a)
	{
		if (a.equalsIgnoreCase("a") ||
				a.equalsIgnoreCase("e") ||
				a.equalsIgnoreCase("i") ||
				a.equalsIgnoreCase("o") ||
				a.equalsIgnoreCase("u") ||
				a.equalsIgnoreCase("y"))
			return true;
		return false;
	}
	//counts each vowel in the word by calling on isVowel
	public static int countVowels(String s)
	{
		int count = 0;
		String a = "";
		//goes through each character in the string by making it a substring
		for(int i =0; i<s.length();i++)
		{
			a = s.substring(i,i+1);
			if(isVowel(a))
				count++;
		}
		return count;
	}
	//counts consonants by using the same format as countVowels, but uses !isVowel instead
	public static int countConsonants(String s)
	{
		int count = 0;
		String a = "";
		for(int i =0; i<s.length();i++)
		{
			a = s.substring(i,i+1);
			if(!(isVowel(a)))
				count++;
		}
		return count;
	}
	//copies words in original array so you aren't changing the original itself
	public static String[] copy(String[] strings)
	{
		String[] copied = new String[strings.length];
		for(int i=0; i<strings.length; i++)
		{
			copied[i] = strings[i];
		}
		return copied;
		
	}
}
