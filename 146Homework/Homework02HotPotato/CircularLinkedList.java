/*
 * David Keen
 * 2/7/20
 * CSCE 146H
 * Homework 02 Hot Potato
 */
public class CircularLinkedList <T>{
	//ListNode Class
	private class ListNode
	{
		private T data;
		private ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
		
	}
	//private instance variables and constructor
	private ListNode head; //first element in the list
	private ListNode curr; //current item of interest to be used outside of this class
	private ListNode prev; //One node behind current
	private ListNode tail;//last element in the list	I didn't use a tail for Hot Potato
	public CircularLinkedList()
	{
		head = prev = curr = null;
	}
	//retun current ListNode's data
	public T getCurrent()
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	//set current ListNode's data
	public void setCurrent(T aData)
	{
		if(curr != null)
			curr.data = aData;
	}
	//move current to the next ListNode
	public void gotoNext()
	{
		if (curr != null)
		{
			prev = curr;
			curr = curr.link;
		}
	}
	//reset the current to the head
	public void resetCurrent()
	{
		curr = head;
	}
	//checks if there are more values in the list
	public boolean hasMore()
	{
		return curr != null;
	}
	//checks if the current ListNode is not pointing to itself, meaning there is more than one ListNode, this is used for preventing an infiniste loop
	public boolean moreThanOne()
	{
		if(curr.link!=curr)
			return true;
		return false;
	}
	
	//add Data to the list in the form of a new ListNode
	public void add(T aData) 
	{
		ListNode newNode = new ListNode(aData, head); // end points back to the head
		if(head==null)
		{
			head = newNode;
			curr = head;
			head.link = head;
			return;
		}
		
		ListNode temp = head;
		//if only one element in the list, head points to the new node
		if(head.link == head)
		{
			head.link = newNode;
		}
		//else moves through the list until it reaches the end where the link would point back to the head, adds listnode
		else
		{
			while(temp.link != head) 
				temp = temp.link;
			tail = newNode;
			temp.link = tail;
			
		}
	}
	//removes current ListNode 
	public void removeCurrent()
	{
		
			prev.link = curr.link;
			curr = curr.link;


	}
	//adds after the currrent ListNode
	public void addAfterCurrent(T aData)
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(aData,curr.link );
		curr.link = newNode;
	}
	//Prints list without going into an infinite loop
	public void print()
	{
		ListNode temp = head;
		while(temp.link!=head)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
}
	
