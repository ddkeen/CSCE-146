//Array Based Version of a Stack
public class ArrayStack<T> implements StackI<T>	 {
	private T[] stack;
	public static int DEF_SIZE = 100;
	private int headIndex;//First null element, last element is 1 minus this
	public ArrayStack()
	{
		init(DEF_SIZE);
	}
	public ArrayStack(int size)
	{
		init(size);
	}
	public void init(int size)
	{
		if(size <= 0)
		{
			init(DEF_SIZE);
			return;
		}
		headIndex = 0;
		stack = (T[]) new Object[size];
	}
	//add new element
	public void push(T aData)
	{
		if(stack[stack.length-1] != null)
			return;
		stack[headIndex] = aData;
		headIndex++;
		
	}
	public T pop()
	{
		if(headIndex == 0)
			return null;
		T ret = stack[headIndex-1];
		headIndex--;
		return ret;
		//--headIndex vs headIndex--
		//first happens immediately, the other happens after everything else
	}
	public T peek()
	{
		return stack[headIndex-1];
	}
	public void print()
	{
		for(int i = headIndex-1; i>=0; i--)
			System.out.println(stack[i]);
	}
		
	

}
