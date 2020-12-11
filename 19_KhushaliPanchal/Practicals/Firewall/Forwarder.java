package Assign2.que3;
import java.io.*;
import java.net.*;
import java.util.*;

public class Forwarder
{
	public static void main(String args[])throws Exception
	{
		int number = 0;
		String msg = null;
		ServerSocket server = new ServerSocket(5000);
		Socket socket = server.accept();
		BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String str = null;
		str = input.readLine();
		System.out.println("Recieved From Client:");
		System.out.println(str);
		
		server.close();
		socket.close();
		Socket socket1 = new Socket("127.0.0.1",4000);
		DataOutputStream out = new DataOutputStream(socket1.getOutputStream());
		if(!str.contains("Terrorist"))
		{
			System.out.println("This text is safe");
			out.writeBytes(str);
		}
		else
		{
			System.out.println("This Text cannot forwarded");
		}
		
		socket1.close();
	}

}