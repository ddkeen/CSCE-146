/*
 * David Keen
 * CSCE 146H
 * 4/8/20
 * Lab8 Process Heap
 */
public class ProcessSimulator {
	public static void main(String[]args)
	{
		final int HEAP_SIZE = 100;
		ProcessHeap heap = new ProcessHeap(HEAP_SIZE);
		//Make initial heap
		heap.add(new Process("a",10,50));
		heap.add(new Process("b",5,20));
		heap.add(new Process("c",20,18));
		heap.add(new Process("d",18,29));
		heap.add(new Process("e",33,23));
		heap.add(new Process("f",1,15));
		heap.add(new Process("g",16,5));
		
		System.out.println("The current heap is:");
		heap.printHeap();
		
		System.out.println("Starting simulation");
		//Simulation
		final int SIM_TIME = 250;
		Process currProcess = null;
		double currProcessTime = 0.0;
		for(int i=0;i<SIM_TIME;i++)
		{
			if(currProcess == null)
			{
				if(heap.isEmpty())
				{
					System.out.println("Waiting for new processes");
					
				}
				else
				{
					currProcess = (Process)heap.remove();
					System.out.println("Process: "+currProcess.toString()+" is starting");
					currProcessTime = currProcess.getTime();
				}
			}
			else if(currProcessTime>0.0)
			{
				currProcessTime--;
			}
			else
			{
				System.out.println("Process: "+currProcess.toString()+" has ended");
				currProcess = null;
			}
			
			//New process added
			if(i%50 == 0 && i!=0)
			{
				Process randomProcess = new Process("Random Process "+i,i/5,i/5); 
				heap.add(randomProcess);
				System.out.println("Random process added! "+randomProcess.toString());
			}
		}
		System.out.println("Simulation time has expired");
	}
}
