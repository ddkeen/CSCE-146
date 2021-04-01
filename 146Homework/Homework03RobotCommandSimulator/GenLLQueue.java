/*
 * David Keen
 * 2/21/20
 * CSCE 146H
 * Homework 03
 */
//Generic LL Queue class for the Robot Command Simulator
public class GenLLQueue<T> {
	//internal class
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	//private instance variables
	private ListNode head;
	private ListNode tail;
	private int size;
	//constructor
	public GenLLQueue()
	{
		head = tail = null;
		size = 0;
	}
	//add an element to the queue
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head==null)
		{
			head = newNode;
			tail = head;
			size = 1;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
		size++;
	}
	//remove an element from the queue
	public T dequeue()
	{
		if(head == null)
			return null;
		T ret = head.data;
		head = head.link;
		size--;
		return ret;
	}
	//return the head element in the queue if not null
	public T peek()
	{	if(head == null)
			return null;
		return head.data;
	}
	//return the size of the queue
	public int size()
	{
		return this.size;
	}
	//print the elements in the queue
	public void print()
	{
		for(ListNode temp = head; temp!=null; temp=temp.link)
			System.out.println(temp.data);
	}
}
