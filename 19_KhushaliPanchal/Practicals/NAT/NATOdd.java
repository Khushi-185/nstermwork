import java.util.*;
//package Assign2.que4;

import java.io.*;
import java.net.*;

public class NATOdd
{
	public static void main(String args[]) throws IOException
	{
			ServerSocket ds=new ServerSocket(1235);	
		while(true)
		{
			String es="";
			Socket sk=ds.accept();
			BufferedReader br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
			es=br.readLine();
			if(es.equalsIgnoreCase("exit"))
			{
				System.out.println("Exiting!");
				break;
			}
			System.out.println("Odd number: "+es+" successfully received!");	
		}		
	}
}
