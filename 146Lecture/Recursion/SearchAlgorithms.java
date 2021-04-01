
public class SearchAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] b = {0,1,2,3,4,5,6,7,8,9,};
	}
	public static boolean seqSearchIter(int[] a, int value)
	{
		for(int i=0;i<a.length;i++)
			if(a[i] == value)
				return true;
		return false;
	}
	public static boolean seqSearchRecur(int[] a, int value, int index)
	{
		if(a[index]==value)
			return true;
		else
		{
			index++;
			if(index>= a.length)
				return false;
			return seqSearchRecur(a,value,index);
		}
	}
	public static boolean binSearchRecur(int[] a, int value, int min, int max)
	{
		if(min > max)
			return false;
		int mid = (max-min)/2;
		if(a[mid] == value)
			return true;
		else
		{
			if(a[mid]>value)
				return binSearchRecur(a,value,min,mid-1);
			else
				return binSearchRecur(a,value,mid+1,max); 
		}
	}

}
