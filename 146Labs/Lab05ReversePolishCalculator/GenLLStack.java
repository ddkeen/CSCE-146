/*
 * David Keen
 * 2/21/20
 * CSCE 146H
 * Lab05
 */
//Generic Linked List class used for Lab 05 and the Reverse Polish Calcultor
public class GenLLStack<T> implements StackInterface<T>{
	//private class ListNode
	private class ListNode{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	//private instance varibales
	private ListNode head;
	private int size;
	//contructor
	public GenLLStack()
	{
		head = null;
		size = 0;
	}
	//add to the stack
	public void push(T data)
	{
		ListNode newNode = new ListNode(data, head);
		head = newNode;
		size++;	
	}
	//remove from the stack
	public T pop()
	{
		T ret  = head.data;
		head = head.link;
		size--;
		return ret;
	}
	//return the first value in the stack
	public T peek()
	{
		if(head == null)
			return null;
		return head.data;
	}
	//print all elements in the stack
	public void print()
	{
		for(ListNode temp = head; temp!=null;temp = temp.link)
			System.out.println(temp.data);
	}
	//return the size of the stack
	public int size()
	{
		return size;
	}
}
