import java.util.Random;
public class BubbleSort {

	public static final int RAND_RANGE = 100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int [5];
		Random r = new Random(); //Fix the seed = new Random(SEED_VALUE);
		for(int i =0; i<a.length; i++)
		{
			a[i] = r.nextInt(RAND_RANGE);
		}
		printArray(a);
		//Sort it using bubble sort
		 boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i= 0; i <a.length-1;i++)
			{
				if(a[i] > a[i+1])
				{
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		printArray(a);

	}
	public static void printArray(int[] cat)
	{
		for(int i : cat) //For-each loop
			System.out.println(i);
		System.out.println();
			
	}

}
