
public class IntLLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a  = new int[10];
		IntLinkedList iList = new IntLinkedList();
		for(int i = 0; i<a.length;i++)
		{
			a[i] = i;
			//Todo Add to the Linked List
			iList.add(i);
		}
		int thing = a[4];
		for(int i=0;i<5;i++)
			iList.gotoNext();
		int thing2 = iList.getCurrent();
	
		a[4] = 2;
		iList.setCurrent(2);
		
		iList.deleteCurrent();
	
	
	
	
	}

}
		