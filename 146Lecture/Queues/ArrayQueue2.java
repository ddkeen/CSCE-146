//Queue Circluar Array Version (FIFO)
public class ArrayQueue2<T> implements QueueI<T>{
		private T[] queue;
		private int headIndex;
		private int tailIndex;//First null element so last element tailIndex-1
		public static final int DEF_SIZE = 100;
		public ArrayQueue2()
		{
			init(DEF_SIZE);
		}
		public ArrayQueue2(int size)
		{
			init(size);
		}
		private void init(int size)
		{
			if(size <= 0)
			{
				init(DEF_SIZE);
				return;
			}
			queue = (T[]) (new Object[size]); //have to typecast
		}
		
		public void enqueue(T aData)
		{
			if(queue[tailIndex] != null && headIndex == tailIndex)//Full Queue
				return;
			queue[tailIndex] = aData;
			tailIndex=(tailIndex+1)%queue.length;
		}
		
		public T dequeue()
		{
			T ret = queue[headIndex];
			//Shift
			headIndex = (headIndex+1)%queue.length;
			return ret;
		}
		public T peek()
		{
			return queue[headIndex];
		}
		public void print()
		{
			System.out.println(queue[headIndex]);
			for(int i = (headIndex+1)%queue.length; i!=tailIndex; i=(i+1)%queue.length) //printing in circular arrays
				System.out.println(queue[i]);
		}

}
