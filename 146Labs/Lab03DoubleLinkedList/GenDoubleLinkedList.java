
/*
 * David Keen
 * 2/7/20
 * CSCE 146H 
 * Lab03
 */
//Linked List but each node has two links, previous and next
public class GenDoubleLinkedList <T> {
	
	//ListNode internal class
	private class ListNode
	{
		//private instance variables
		private T data;
		private ListNode nextLink;
		private ListNode prevLink;
		
		//default constructor
		public ListNode()
		{
			data = null;
			nextLink = null;
			prevLink = null;
		}
		//parameterized constructor
		public ListNode(T aData, ListNode aNextLink, ListNode aPrevLink)
		{
			data = aData;
			nextLink = aNextLink;
			prevLink = aPrevLink;
		}
		
	}

	//private instance variables head and curr
	private ListNode head; //first element in the list
	private ListNode curr; //current item of interest to be used outside of this class
	
	//default constructor, set current to head
	public GenDoubleLinkedList()
	{
		head = null;
		curr = head;
	}
	//returns the data in the current node if not null
	public T getCurrent()
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	//set the current node's data
	public void setCurrent(T aData)
	{
		if(curr != null)
			curr.data = aData;
	}
	//move current to the next node
	public void goToNext() 
	{
		if (curr.nextLink != null)
		{
			curr = curr.nextLink;
		}
	}
	//move current to the previous node
	public void goToPrev()
	{
		if(curr.prevLink !=null)
		{
			curr = curr.prevLink;
		}
	}
	//test if there are more listnodes in the linkedlist
	public boolean moreToIterate()
	{
		return curr.nextLink != null;
	}
	//reset the current to the head
	public void resetCurrent()
	{
		curr = head;
	}
	//insert a new node
	public void insert(T aData) 
	{
		//create the new node
		ListNode newNode = new ListNode(aData, null, null);
		//if head is null, there is an empty list, so insert at the head
		if(head==null)
		{
			head = curr = newNode;
			return;
		}
		//else, create a temporary listnode that goes through the list until it reaches the end, then 
		//set that temp listnode to the new Node
		ListNode temp = head;
		while(temp.nextLink != null)
			temp = temp.nextLink;
		temp.nextLink = newNode;
		newNode.prevLink=temp;
	}
	//insert a node after the current listnode, this can be anywhere in the list
	public void insertAfterCurrent(T aData)
	{
		//you cannot insert a node after the current if the current is null
		if(curr == null)
			return;
		//create the new node
		ListNode newNode = new ListNode(aData,curr.nextLink,curr);
		//the link after curr becomes the new node
		curr.nextLink = newNode;
	}
	//delete the current node by cutting off links to that node and setting curent to a different node
	public void deleteCurrent()
	{
		//check if current is equal to null
		if(curr==null)
			return;
		if(curr == head )//current is at the head
		{
			//move head to the next link
			head  = head.nextLink;
			head.prevLink = null; //cut off the previous link that is the current from the list
			curr = head; // current is now the head
			return;
		}
		else //not the head and not null
		{
			curr.prevLink.nextLink=curr.nextLink; //make current's previous link's next link equal to current's next link 
			if(curr.nextLink!=null)//if current isn't at the end of the list
				curr.nextLink.prevLink=curr.prevLink;//make current's nextlink's previous link equal to current's previous link
			curr=curr.nextLink;//move current to the next link
		}
	}
	public void print()
	{
		//temporary node
		ListNode temp = head;
		//move throught the list
		while(temp!=null)
		{
			//print data
			System.out.println(temp.data);
			//move tothe next link
			temp = temp.nextLink;
		}
	}
	
	public boolean contains(T aData)
	{
		//temporary node
		ListNode temp = head;
		//move thorugh the lsit
		while(temp!=null)
		{
			//check if temp's data is equal to the parameterized data
			if(temp.data == aData)
				return true;
			//move to the next link
			temp = temp.nextLink;
		}
		return false;	
	}
	
}
