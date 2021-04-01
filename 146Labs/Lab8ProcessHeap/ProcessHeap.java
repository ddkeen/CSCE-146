/*
 * David Keen
 * CSCE 146H
 * 4/8/20
 * Lab8 Process Heap
 */
public class ProcessHeap {
	//array of Processes
	private Process[] heap;
	//default size is 2^8 -1
	public static final int DEF_SIZE =127;
	//number of Processes in our heap
	private int size; //last null index 
	//constructors
	public ProcessHeap()
	{
		init(DEF_SIZE);
	}
	public ProcessHeap(int s)
	{
		init(s);
	}
	//make sure size is >0
	public void init(int s)
	{
		if(s>0)
		{
			heap = new Process[s];
			this.size = 0;
		}
		else
			init(DEF_SIZE);
	}
	//add from last element in breadth order
	public void add(Process p)
	{
		//full array
		if(size >= heap.length)
			return;
		//last null element is now filled with element in Parameter
		heap[size] = p;
		//BUBBLEUP
		bubbleup();
		//increase our size to go to the next null element
		size++;
	}
	//put suff in the right order again starting from the last element
	private void bubbleup()
	{
		//index of the thing we just put in the array
		int index = this.size;
		//while we aren't at the head and our values parent > greater than the thing we're trynna add in the right place
		while(index >0 && 
			heap[(index-1)/2].compareTo(heap[index])<0)
		{
			//we swap them values and change our index to the parent cuz that's where we are now
			Process temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	//just seeing what's at our root/head
	public Process peek()
	{
		return heap[0];
	}
	//remove from the root
	public Process remove()
	{
		//make sure we ain't null
		if(peek() ==null)
			return null;
		//returning the head later
		Process ret = peek();
		//head is now equal to what was in the last element
		heap[0] = heap[size-1];
		//now that element is empty and we decrease the size
		heap[size-1] = null;
		size--;
		//BUBBLEDOWN
		bubbledown();
		//return what we just removed
		return ret;
	}
	private void bubbledown() {
		//start at the head index
		int index =0;
		//while we have at least one child
		while (index*2+1 <size)
		{
			//this is for whichever index is the biggest out of the children 
			int bigIndex =index*2+1;
			//if we have a right child and its value is greater than the left child, change our big index
			if(index*2+2 < size &&
					heap[index*2+2].compareTo(heap[index*2+1])>0)
				bigIndex = index*2+2;
			//if our parent is less than the bigger child, swap em
			if(heap[index].compareTo(heap[bigIndex])<0)
			{
				Process temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			//if not we gucci so break out of this loop iteration and do it again
			else
				break;
			//change our index
			index = bigIndex;
		}
	}
	//print entire heap from head
	public void printHeap()
	{
		for(Process p : heap)
		{
			if(p == null)
				break;
			System.out.println(p);
		}
	}
	//check if our head is null which would mean our heap is empty
	public boolean isEmpty()
	{
		return heap[0] == null;
	}
	
	
	
}
