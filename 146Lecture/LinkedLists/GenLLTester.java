
public class GenLLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenLL<Integer> iLL = new GenLL <Integer>(); //Must use objects types for Generic Linked Lists
		
		//GenLL<int> iLL = new GenLL<int>(); // cannot use a generic linked list of primitive types
		
		GenLL<String> sLL = new GenLL<String>();
		
		for(int i=0; i<10; i++)
		{
			iLL.add(i);
			sLL.add(i+"Thing");
			sLL.add(0,i+"");
		}
		iLL.print();
		sLL.print();

		for(int i: iLL)
		{
			System.out.println(i);
		}
		for(String s: sLL)
		{
			System.out.println(s);
		}
	}

}
