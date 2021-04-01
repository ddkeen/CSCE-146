/*
 * David Keen
 * CSCE 146H
 * 2/14/20
 * Lab 04 Process Queue Simulator
 */
public class ProcessScheduler {
	//private instance variables
	private LinkedListQueue<Process4> Processes;
	private Process4 currentProcess;
	//default constructor
	public ProcessScheduler()
	{
		Processes = new LinkedListQueue<Process4>();
		currentProcess = Processes.peek();
	}
	//return current Process
	public Process4 getCurrentProcess()
	{
		return currentProcess;
	}
	//sets the current process if the current process is null or it adds it to the process queue
	public void addProcess(Process4 p)
	{
		if(currentProcess == null)
		{
			currentProcess = p;
		}
		else
		{
			Processes.enqueue(p);
		}
	}
	//dequeues from the process queue and sets that to the current process.
	public void runNextProcess()
	{
		Process4 temp = Processes.dequeue();
		currentProcess = temp;
	}
	//current process is cancelled and is replaced by the first element on the process queue
	public void cancelCurrentProcess()
	{
		currentProcess = Processes.peek();
		Processes.dequeue();
	}
	//print all of the elements from the process queue.
	public void printProcessQueue()
	{
		Processes.print();
	}
	

}
