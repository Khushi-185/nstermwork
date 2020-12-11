package Assign2.que3;
import java.io.*;
import java.util.*;
import java.net.*;

public class ServerFireWall
{
	public static void main(String args[])throws Exception
	{
		int num = 0,temp;
		ServerSocket server = new ServerSocket(4000);
		Socket socket = server.accept();
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String received = null;
		received = input.readLine();
		num = Integer.parseInt(received);
		System.out.println("Successfully Recieved");
		System.out.println(num);
		server.close();
		socket.close();
		
	}
}