//Queue Regular Array Version (FIFO)
public class ArrayQueue<T> implements QueueI<T>{
		private T[] queue;
		private int tailIndex;//First null element so last element tailIndex-1
		public static final int DEF_SIZE = 100;
		public ArrayQueue()
		{
			init(DEF_SIZE);
		}
		public ArrayQueue(int size)
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
			if(queue[queue.length-1] != null)//Full Queue
				return;
			queue[tailIndex] = aData;
			tailIndex++;
		}
		
		public T dequeue()
		{
			T ret = queue[0];
			//Shift
			for(int i=0; i<tailIndex; i++)
				queue[i] = queue[i+1];
			tailIndex--;
			return ret;
		}
		public T peek()
		{
			return queue[0];
		}
		public void print()
		{
			for(int i = 0; i<tailIndex;i++)
				System.out.println(queue[i]);
		}

}
