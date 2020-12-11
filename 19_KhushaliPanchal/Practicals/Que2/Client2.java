package Assign2.que1;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class Client2{
	public static void main(String args[]) throws Exception{
		Socket s=new Socket("127.0.0.1",1234);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Password : ");
		String msg=sc.nextLine();
		String encrypted = encryption(msg);
		
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		out.writeUTF(encrypted);
		s.close();
	}
	public static String encryption(String msg)
	{
		String encrypted="";
		char ch;
		for(int i=0;i<msg.length();i++)
		{
			ch = msg.charAt(i);
			if(ch > 'a' && ch < 'z')
			{
				ch = (char)(ch + 3);
				if(ch > 'z')
				{
					ch = (char)(ch - 'z' + 'a'-1);
				}
				encrypted= encrypted + ch;
			}
			else if(ch >= 'A' && ch <= 'Z')
			{
				ch = (char)(ch + 3);
				if(ch > 'Z')
				{
					ch = (char)(ch - 'Z' + 'A' - 1);
				}
				encrypted = encrypted + ch;
			}
			else
			{
				encrypted = encrypted + ch;
			}
		}
		return encrypted;
	}
	
}