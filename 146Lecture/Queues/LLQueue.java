//Queue Linked List version (FIFO)
import java.util.Iterator;
public class LLQueue<T> implements QueueI<T> {
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data= aData;
			link = aLink;
		}
	}
	private class ListIterator implements Iterator<T>
	{
		ListNode iCurr;
		public ListIterator(ListNode aHead)
		{
			iCurr = aHead;
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
	public Iterator<T> iterator()
	{
		return new ListIterator(head);
	}
	private ListNode head;//First element
	private ListNode tail;//Last Element
	private int size;
	public LLQueue()
	{
		head = tail = null;
		size = 0;
	}
	public void enqueue(T aData)
	{
		//Make the new link
		ListNode newNode = new ListNode(aData, null);
		if(head == null)//empty list
		{
			head = newNode;
			tail = head;
			size  = 1;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
		size++;
	}
	public T dequeue()
	{
		if(head==null)
			return null;
		T ret = head.data;
		head = head.link;
		size--;
		return ret;
	}
	public T peek()
	{
		if(head==null)
			return null;
		return head.data;
	}
	public void print()
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
	public int size()
	{
		return this.size; 
	}

}
