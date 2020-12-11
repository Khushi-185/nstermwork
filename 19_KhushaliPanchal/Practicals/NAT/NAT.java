//package Assign2.que4;
import java.util.*;
import java.io.*;
import java.net.*;

public class NAT
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket ds=new ServerSocket(1233);
		Socket sk=ds.accept();
		BufferedReader br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		while(true)
		{			
			String s;
			s=br.readLine();			
			if(s.equalsIgnoreCase("exit"))
			{
				System.out.println("Exiting!");				
				Socket sk1=new Socket("127.0.0.1",1234);
				Socket sk2=new Socket("127.0.0.1",1235);				
				DataOutputStream dos1=new DataOutputStream(sk1.getOutputStream());
				DataOutputStream dos2=new DataOutputStream(sk2.getOutputStream());
				dos1.writeBytes(s+"\n");
				dos2.writeBytes(s+"\n");
				break;
			}
			else
			{
				System.out.println("Number successfully received by Firewall: "+s);
				int pn=checkString(s);
				Socket sk1=new Socket("127.0.0.1",pn);
				DataOutputStream dos=new DataOutputStream(sk1.getOutputStream());
				dos.writeBytes(s+"\n");
			}
		}
	}
	
	public static int checkString(String s)
	{
		int n=Integer.parseInt(s);
		if(n%2==0)
		{
			System.out.println(n+" is Even Number and forwarded to 1234");
			return 1234;
		}
		else
		{
			System.out.println(n+" is ODD Number and forwarded to 1235");
			return 1235;
		}
	}
}
