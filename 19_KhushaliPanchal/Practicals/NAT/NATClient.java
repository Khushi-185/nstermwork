//package Assign2.que4;
import java.util.*;
import java.io.*;
import java.net.*;

public class NATClient
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		Socket ds=new Socket("127.0.0.1",1233);
		DataOutputStream dos=new DataOutputStream(ds.getOutputStream());
		String s;
		while(true)
		{
			s="";
			System.out.println("Enter Number: ");
			s=sc.nextLine();
			dos.writeBytes(s+"\n");
			if(s.equalsIgnoreCase("exit"))
			{
				System.out.println("Exiting!");
				break;
			}
			System.out.println("String: "+s+" sent Successfully!");
		}
	}
}
