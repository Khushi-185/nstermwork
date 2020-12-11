 import java.util.*;
public class Ceaser_Cipher
{
	public static String encryption(String msg, int shift)
	{
		String encrypted="";
		char ch;
		for(int i=0;i<msg.length();i++)
		{
			ch = msg.charAt(i);
			if(ch > 'a' && ch < 'z')
			{
				ch = (char)(ch + shift);
				if(ch > 'z')
				{
					ch = (char)(ch - 'z' + 'a'-1);
				}
				encrypted= encrypted + ch;
			}
			else if(ch >= 'A' && ch <= 'Z')
			{
				ch = (char)(ch + shift);
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
	
	public static String decryption(String encrypted,int shift)
	{
		String decrypted="";
		char ch;
		for(int i=0;i<encrypted.length();i++)
		{
			ch = encrypted.charAt(i);
			if(ch > 'a' && ch < 'z')
			{
				ch = (char)(ch - shift);
				if(ch > 'z')
				{
					ch = (char)(ch + 'z' - 'a'+1);
				}
				decrypted= decrypted + ch;
			}
			else if(ch >= 'A' && ch <= 'Z')
			{
				ch = (char)(ch - shift);
				if(ch > 'Z')
				{
					ch = (char)(ch + 'Z' - 'A' + 1);
				}
				decrypted = decrypted + ch;
			}
			else
			{
				decrypted = decrypted + ch;
			}
		}
		return decrypted;
	}
	public static void main(String args[])
	{
		String msg,encrypted="",decrypted="";
		int shift = 3;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter text in plain text.");
		msg = sc.next();
		
		encrypted = encryption(msg,shift);
		System.out.println("Encrypted Message: " + encrypted);
		
		decrypted=decryption(encrypted,shift);
		System.out.println("Decrypted Message: " + decrypted);
	}
}