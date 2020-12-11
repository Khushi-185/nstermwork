package Assign2.que3;
import java.util.*;
import java.io.*;
import java.net.*;
public class ClientFirewall
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Socket socket = new Socket("127.0.0.1",5000);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		String number = "";
		System.out.println("Enter String:");
		number = sc.nextLine();
		out.writeBytes(number + "\n");
		System.out.println(number + " sent to forwerder:");
		socket.close();
	}
}