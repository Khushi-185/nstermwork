package Assign2.que1;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.sql.*;
class Server{
	public static void main(String args[]) throws Exception{
		ServerSocket ss=new ServerSocket(1234);
		Socket s=ss.accept();
		
		System.out.print("From Client : ");
		DataInputStream in=new DataInputStream(s.getInputStream());
		String encrypted = in.readUTF();
		String decrypted = decryption(encrypted);
		String finalResult = checkPassword(decrypted);
		if(finalResult.equals(decrypted))
			System.out.println("Password Matched");
		else
			System.out.println("Password doesn't Matched");
			
		s.close();
		ss.close();
	}
	public static String decryption(String encrypted)
	{
		String decrypted="";
		char ch;
		for(int i=0;i<encrypted.length();i++)
		{
			ch = encrypted.charAt(i);
			if(ch > 'a' && ch < 'z')
			{
				ch = (char)(ch - 3);
				if(ch > 'z')
				{
					ch = (char)(ch + 'z' - 'a'+1);
				}
				decrypted= decrypted + ch;
			}
			else if(ch >= 'A' && ch <= 'Z')
			{
				ch = (char)(ch - 3);
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
	
	public static String checkPassword(String decrypted)throws Exception
	{
		String pwd = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ns","root","");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from password where pws ='" + decrypted +"';");
		while(rs.next()){
			pwd = rs.getString("pws");
		}
		return pwd;
	}
	
}