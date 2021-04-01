/*
 * David Keen
 * CSCE 146H
 * 2/14/20
 * Lab 04 Process Queue Simulator
 */
public class LinkedListQueue<T> {
	//internal class ListNode
	private class ListNode
	{
		//private instance variables
		private T data;
		private ListNode link;
		//default constructor
		public ListNode()
		{
			data = null;
			link = null;
		}
		//parameterized construcotr
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	//private instance variables
	private ListNode head;//first element
	private ListNode tail;//last element
	//default constructor
	public LinkedListQueue()
	{
		head = tail = null;
	}
	//adds data to the end of the queue
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		//empty list
		if(head==null)
		{
			head = newNode;
			tail = head;
			return;
		}
		tail.link=newNode;
		tail = tail.link;
	}
	//removes an item from the queue and returns its value
	public T dequeue()
	{
		T temp = head.data;
		head = head.link;
		return temp;
	}
	//returns first element in the queue
	public T peek()
	{
		if(head == null)
			return null;
		return head.data;
	}
	//prints out the entire queue
	public void print()
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
//		ListNode temp = head;
//		while(temp!=null)
//		{
//			System.out.println(temp.data);
//			temp = temp.link;
//		}
	}
		
	

}
