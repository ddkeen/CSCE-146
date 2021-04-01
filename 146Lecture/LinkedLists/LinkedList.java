
public class LinkedList {
	
	public class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data = data;
		
		}
	}
	
	public Node head;
	public Node tail;
	
	public LinkedList() {
		head = tail = null;
	}
	
	public int countOdd()
	{
		int count =0;
		Node temp = head;
		while (temp.next != null)
		{
			if(temp.data % 2 == 1)
			{
				count++;
			}
			temp = temp.next;
		}
		return count;
	}
	public void addInOrder(int val)
	{
		Node temp = head;
		if(head == null)
		{
			Node newNode = new Node(val);
			head = newNode;
		}
		while (temp.next!= null)
		{
			if(temp.data>val)
			{
				Node newNode = new Node(val);
				newNode.next = head;
				head = newNode;
				return;
			}
			else
			{
				if(temp.data<val && temp.next.data<val)
				{
					temp = temp.next;
				}
				else
				{
					Node newNode = new Node(val);
					newNode.next = temp.next;
					temp.next = newNode;
					return;
				}
			}
			
		}
	}

}
