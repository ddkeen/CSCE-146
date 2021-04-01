//T is a variable for types - object types
import java.util.Iterator;
public class GenLL <T> implements Iterable<T>{
	//Internal Class
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
	private class ListIterator implements Iterator<T>
	{
		private ListNode iCurr;
		public ListIterator(ListNode head)
		{
			iCurr = head;
		}
		public boolean hasNext()
		{
			return iCurr != null;
		}
		public T next()
		{
			T ret = iCurr.data;
			iCurr = iCurr.link;
			return ret;
		}
	} 
	public Iterator <T> iterator()
	{
		return new ListIterator(head);
	}
	
	private ListNode head; //first element in the list
	private ListNode curr; //current item of interest to be used outside of this class
	private ListNode prev; //One node behind current
	
	public GenLL()
	{
		head = prev = curr = null;
	}
	public T getCurrent()
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	public void setCurrent(T aData)
	{
		if(curr != null)
			curr.data = aData;
	}
	public void gotoNext()
	{
		if (curr != null)
		{
			//prev = curr;
			curr = curr.link;
		}
	}
	public void resetCurrent()
	{
		curr = head;
	}
	public boolean hasMore()
	{
		return curr != null;
	}
	
	//public void goToPrevious() move curr to previous, move previous to head, move preious forward until previous.link = curr
	public void add(T aData) //THIS IS ON THE TEST
	{
		ListNode newNode = new ListNode(aData, null);
		if(head==null)
		{
			head = curr = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}
	public void removeCurrent()
	{
		if(curr != null && prev != null)//not the head
		{
			prev.link =curr.link;
			curr = curr.link;
		}
		else if(curr != null && prev == null)//current is at the head
		{
			//curr = curr.link; WRONG
			head  = head.link;
			curr = head;	
		}
	}
	public void addAfterCurrent(T aData)
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(aData,curr.link );
		curr.link = newNode;
	}
	public void print()
	{
		ListNode temp = head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public void add(int index, T value) 
	{
		//temp to iterate through linked list
		ListNode temp = head;
		//while loop to check each value to see if the new one is a duplicate
		while(temp.link != null)
		{
			//return if equal, then go to the next node
			if(temp.data.equals(value))
			{
				return;
			}
			temp = temp.link;
		}
		//if index==0, we are at the head, so make a newNode with its link as the head, and change head to newNode
		if(index == 0)
		{
			ListNode newNode = new ListNode(value,head);
			head = newNode;
			return;
		}
		//move temp back to the start to iterate again
		temp = head;
		//start at 1 because index is at least one
		int start = 1;
		//go through the list
		while(temp!=null)
		{
			//if we're at the specified index, make a node with its link temp.link, and set temp's link to the newNode
			if(start == index)
			{
				ListNode newNode = new ListNode(value,temp.link);
				temp.link = newNode;
			}
			//iterate start and temp
			start++;
			temp = temp.link;
		}

	}
	
}

//public static void main(String[] args)
//{
//	GenLL<String> sLL = new GenLL<String>();
//	for(int i = 0; i<10; i++)
//		sLL.add(aData);
//}
	











