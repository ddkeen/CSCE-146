import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;
public class SocketServer {
	private GenLL<Socket> connections;
	private Thread connectionThread;
	private ServerSocket socket;
	private QueueI<String>	msgQ;
	public static final int PORT = 5280;
	public static final int MAX_USERS = 1;
	public static final int MAX_Q_SIZE = 10;
	public static final Semaphore MUTEX = new Semaphore(MAX_USERS);
	
	public SocketServer()
	{
		init();
	}
	private void init()
	{
		try
		{
			connections = new GenLL<Socket>();
			msgQ = new LLQueue<String>();
			socket = new ServerSocket(PORT);
			connectionThread = new Thread()
			{
				public void run()//Overridden the method run built in Thread
				{
					while (true)
					{
						try
						{
							Socket newS = socket.accept();
							System.out.println("Incoming connection");
							while(!MUTEX.tryAcquire());
							connections.add(newS);
							BufferedWriter writer = new BufferedWriter(
									new OutputStreamWriter(newS.getOutputStream()));
							for(String s = msgQ.peek(); msgQ.dequeue()!= null; msgQ.dequeue())
							{
								writer.write(s);
								writer.newLine();
							}
							writer.flush();
							MUTEX.release();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			};
			connectionThread.start();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void serverRun()
	{
		BufferedReader buffR;
		while (true)
		{
			try 
			{
				if(!MUTEX.tryAcquire())
				{
					Thread.sleep(100);
					continue;
				}
				for(Socket sock : connections)
				{
					buffR = new BufferedReader(new InputStreamReader(sock.getInputStream()));
					if(!buffR.ready())
						continue;
					String line = buffR.readLine();
					msgQ.enqueue(line);
					//TODO send to all clients
					for(Socket sock2 : connections)
					{
						if(sock == sock2)
							continue;
						BufferedWriter writer = new BufferedWriter(
								new OutputStreamWriter(sock2.getOutputStream()));
						writer.write(line);
						writer.newLine();
						writer.flush();
					}
				}
				MUTEX.release();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
