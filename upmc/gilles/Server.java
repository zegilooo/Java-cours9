package upmc.gilles;

import java.net.*;
import java.io.*;


/**
 * Hello world!
 *
 */
public class Server 
{
	private final static int PORT= 2348;
	
	public Server() 
	{
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
    	new Server();
    }
}
