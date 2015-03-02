package upmc.gilles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection implements Runnable{
	private final static int PORT= 2349;
	private Socket socket;
	public Connection (Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try (	
				ServerSocket server = new ServerSocket(PORT);
				Socket connection = server.accept();	
				PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			) 
			{
		    	String msg;
		    	while((msg = in.readLine())!=null){
			    	out.println("Server read : "+msg);
		    	}
		    	connection.close();
	
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
    public static void main( String[] args ) 
    {
    	Socket socket = null;
    	Thread t = new Thread (new Connection (socket));
    	t.start ();
    }

}
