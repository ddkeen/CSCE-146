
public class CustomerService {

	private Queue<String> waitlist;
	
	public CustomerService()
	{
		waitlist = new Queue<String>();
	}
	
	public void addCustomer(String s)
	{
		waitlist.add(s);
	}
	public String serveCustomer()
	{
		return waitlist.remove();
	}
	public String emptyQueue()
	{
		String ret = "";
		while(waitlist.remove()!=null)
		{
			ret = ret + waitlist.remove() + ", ";
		}
		return ret;
	}
	public static void main(String[] args) {
		CustomerService cs = new CustomerService();
		cs.addCustomer("James");
		cs.addCustomer("Stephanie");
		cs.addCustomer("Abbie");
		cs.addCustomer("Kyle");
		System.out.println(cs.serveCustomer());
		System.out.println(cs.serveCustomer());
		cs.addCustomer("Lincoln");cs.addCustomer("Andy");
		System.out.println(cs.serveCustomer());
		System.out.println(cs.emptyQueue());
		System.out.println(cs.emptyQueue());
		
	}
	
	
}
