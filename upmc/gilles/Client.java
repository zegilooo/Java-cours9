package upmc.gilles;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {

	private final static int PORT= 2349;
	
	public static void main(String[] args) {
		try (
				Socket connection = new Socket ("127.0.0.1", PORT);
				PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));		
				Scanner sc = new Scanner(System.in);		
			) 
			{
				System.out.println("Veuillez saisir un mot :");
				String msg = sc.nextLine();
				out.println(msg);
				String msg2 = in.readLine();
				System.out.println(msg2);

			} catch (ConnectException e1) {
				System.out.println(" ConnectException héhéhéhé");
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
	}

}
