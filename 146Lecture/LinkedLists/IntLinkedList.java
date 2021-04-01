
public class IntLinkedList {
	//Internal classes
	//Inacessible outside of this class
	private class ListNode
	{
		private int data;
		private ListNode link;
		private ListNode curr;//Current item of interest, outside pointer
		public ListNode(int aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;//First element in the Linked list
	private ListNode curr; //Current information pointer
	private ListNode prev;//One item behind previous
	
	public IntLinkedList()
	{
		head = curr = prev = null;
	}
	//Add to end of the list
	public void add(int aData)
	{
		//Create the node
		ListNode newNode = new ListNode(aData, null);
		{
			if(head == null)//Empty List
			{
				head = curr = newNode;
				return;
			}
		}
		ListNode temp = head;
		while(temp.link != null)//pointing to something
			temp = temp.link;
		temp.link  = newNode;
	}
		
//		ListNode temp;
//		for(temp = head; temp.link!=null; temp = temp.link);
//		temp.link = newNode;
	
	public void addAfterCurrent(int aData)
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(aData, curr.link);
		curr.link = newNode;
	}
	
	public void print()
	{
		for(ListNode temp = head; temp!=null; temp = temp.link)
			System.out.println(temp.data);
		
	}
	public int getCurrent()
	{
		if(curr == null)
			return -1;
		return curr.data;
	}
	public void setCurrent(int aData)
	{
		if(curr != null)
			curr.data = aData;
	}
	public void gotoNext()
	{
		if(curr != null)
			prev = curr;
			curr = curr.link;
	}
	public void resetCurrent()
	{
		prev = null;
		curr = head;
	}
	public void deleteCurrent()
	{
		if(curr == null)
			return;
		if(curr == head)//current is the first element
		{
			head = head.link;
			curr = head;
		}
		else//somewhere in the middle
		{
			prev.link = curr.link;
			curr = curr.link;
		}
	}
	
	
	 
	
}
