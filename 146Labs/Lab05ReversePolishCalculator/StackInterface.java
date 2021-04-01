/*
 * Written By JJ Shepherd
 */
//Stack interface to be used in the GenLLStack class for Lab05
public interface StackInterface<T> {
	public void push(T data);
	public T pop();
	public T peek();
	public void print();
}