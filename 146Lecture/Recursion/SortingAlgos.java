
public class SortingAlgos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {9,8,7,6,5,4,3,2,1,0};
	}
	public static void selectionSort(int[] a)
	{
		for(int i=0; i<a.length;i++)
		{
			int smallIndex =i;
			for(int j=smallIndex+1;j<a.length;j++)
			{
				if(a[smallIndex] > a[j])//Found a smaller value
					smallIndex =j;
			}
			if(i != smallIndex)//We found a smaller one
			{
				//Swap
				int temp = a[i];
				a[i] = a[smallIndex];
				a[smallIndex] = temp;
			}
		}
	}
	public static void bubbleSort(int[] a)
	{
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i=0;i<a.length-1;i++)
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
	}
	public static void mergeSort(int[] a)
	{
		int size = a.length;
		if(size < 2)//already sorted if 1 value
			return;
		int mid = size /2;
		int leftSize = mid;
		int rightSize = size - mid;//either the same size or off by 1
		int[] left = new int[leftSize]; //make two new arrays, by cutting the big array in half
		int[] right = new int[rightSize];
		for(int i=0; i<mid; i++)//populates both arrays
			left[i] = a[i];
		for(int i=mid; i<size;i++)
			right[i-mid] = a[i];
		mergeSort(left);//Splits and splits until 1 value
		mergeSort(right);//Splits other array
		merge(left, right, a);
	}
	public static void merge(int[] left, int[] right, int[] a)
	{
		int leftSize = left.length;
		int rightSize = right.length;
		int i=0;//left index
		int j=0;//right index
		int k =0;//combined index for a
		while(i < leftSize && j < rightSize)
		{
			if(left[i] <= right[j])
			{
				a[k] = left[i];
				i++;
				k++;
			}
			else
			{
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while(i<leftSize)
		{
			a[k] = left[i];
			i++;
			k++;
		}
		while(j<rightSize)
		{
			a[k] = right[j];
			j++;
			k++;
		}	
	}
	//memorize for test
	public static void quickSort(int[] a, int left, int right)
	{
		//partition
		int index = partition(a, left, right);
		if(left<index-1)
			quickSort(a,left,index-1);
		if(right > index)
			quickSort(a,index,right);
	}
	public static int partition(int[] a, int left, int right)
		{
			int i = left;
			int j = right;
			int pivot = a[(left+right)/2];//middle value
			while (i<=j)
			{
				while(a[i] < pivot)
					i++;
				while (a[j] > pivot)
					j--;
				if(i <= j)
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
				}
		}
			return i;
	
		}
}
