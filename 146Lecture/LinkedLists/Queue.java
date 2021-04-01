import java.util.LinkedList;
public class Queue <T>{
	
	private LinkedList <T> list;
	
	public Queue() {
		list = new LinkedList<T>();
	}
	public void add (T item) {
		list.addFirst(item);
	}
	public T remove() {
		return list.removeLast();
	}
	

}
