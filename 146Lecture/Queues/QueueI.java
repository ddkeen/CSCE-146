
public interface QueueI<T>  {	//extends Iterable<T>
	public void enqueue(T aData); //Add
	public T dequeue();//Return and remove Head
	public T peek();//Return head but do not remove
	public void print();

}
