import java.util.Scanner;
import java.math.*;
import java.security.*;
class MD5{
	private String doEncryption(String text) throws Exception{
		MessageDigest md=MessageDigest.getInstance("MD5");
		byte[] msg=md.digest(text.getBytes());
		BigInteger bigInt=new BigInteger(1,msg);
		String hashValue=bigInt.toString(16);
		while(hashValue.length()<32)
			hashValue+=0+hashValue;
		return hashValue;
	}
	public static void main(String args[]) throws Exception{
		MD5 MD5=new MD5();
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter Message: ");
		String text=sc.nextLine();
		System.out.print("\nHash Text: " + MD5.doEncryption(text));
	}
}
