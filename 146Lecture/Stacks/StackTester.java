
public class StackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackI<String> aStack = new ArrayStack<String>();
		
		for(int i = 0; i<10; i++)
		{
			aStack.push(i+"String");
			System.out.println(aStack.peek());
		}
		
		for(int i = 0; i<10; i++)
			System.out.println(aStack.pop());
	}

}
