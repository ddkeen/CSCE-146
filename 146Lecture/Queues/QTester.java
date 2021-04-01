
public class QTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//QueueI<String> sQ = new QueueI<String>(); //can't use new with interfaces
		//QueueI<String> sQ = new ArrayQueue<String>();
		
		QueueI<String> sQ = new LLQueue<String>();
		
		
		
		for(int i = 0; i<10; i++)
			sQ.enqueue("Stringy Dingy" + i); 
		sQ.print();
		
		for(int i =0; i<10; i++)
			System.out.println(sQ.dequeue());
		

	}

}
