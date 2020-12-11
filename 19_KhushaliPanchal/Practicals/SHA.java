import java.util.Scanner;
import java.math.*;
import java.security.*;
class SHA{
	private String doEncryption(String text) throws Exception{
		MessageDigest md=MessageDigest.getInstance("SHA-1");
		byte[] msg=md.digest(text.getBytes());
		BigInteger bigInt=new BigInteger(1,msg);
		String hashValue=bigInt.toString(16);
		while(hashValue.length()<32)
			hashValue+=0+hashValue;
		return hashValue;
	}
	public static void main(String args[]) throws Exception{
		SHA sha=new SHA();
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter Message: ");
		String text=sc.nextLine();
		System.out.print("\nHash Text: " + sha.doEncryption(text));
	}
}
