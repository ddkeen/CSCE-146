//ArrayLists take hella longer than Arrays
import java.util.*;
public class ArrayListsVersusArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 1000;
		long arTimes = 0;
		for(int i = 0; i<SIZE; i++)
		{
			Random r  = new Random(i);
			long start = System.nanoTime();
			int[] a = new int[SIZE];
			for(int j = 0; j < SIZE; j++)
				a[j] = r.nextInt(SIZE);
			boolean hasSwapped = true;
			while(hasSwapped)
			{
				hasSwapped = false;
				for(int j=0; j<SIZE-1;j++)
					if(a[j] > a[j+1])
					{
						hasSwapped = true;
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}
			}
			long end = System.nanoTime();
			arTimes += (end-start);
		}
		long arAvg = arTimes / SIZE;
		System.out.println("Array time " + arAvg);
		
		long alTimes = 0;
		for(int i = 0; i<SIZE;i++)
		{
			Random r = new Random(i);
			long start = System.nanoTime();
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(int j=0;j<SIZE;j++)
				al.add(r.nextInt(SIZE));
			boolean hasSwapped = true;
			while(hasSwapped)
			{
				hasSwapped = false;
				for(int j=0;j<SIZE-1;j++)
				{
					if(al.get(j)>al.get(j+1))
					{
						hasSwapped = true;
						int temp = al.get(j);
						al.set(j, al.get(j+1));
						al.set(j+1, temp);
					}
				}
			}
			long end = System.nanoTime();
			alTimes += (end-start);
		}
		long alAvg = alTimes / SIZE;
		System.out.println("Array List Time " + alAvg);
		
	}

}
