import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
class RSA{
	public KeyPairGenerator keygenerator;
	public KeyPair myKey;
	Cipher c;
	public RSA() throws Exception{ 
		keygenerator = KeyPairGenerator.getInstance("RSA");
		keygenerator.initialize(1024) ;
		myKey = keygenerator.generateKeyPair();
		c = Cipher.getInstance("RSA");
	
	}
	public byte[] doEncryption(String s) throws Exception {
		c.init(Cipher.ENCRYPT_MODE,myKey.getPublic());
		byte[] text = s.getBytes();
		byte[] textEncrypted = c.doFinal(text);
		return(textEncrypted);
	}
	public String doDecryption(byte[] s)throws Exception{
		c.init(Cipher.DECRYPT_MODE,myKey.getPrivate());
		byte[] textDecrypted = c.doFinal(s);
		return(new String(textDecrypted));
	}
	
	public static void main(String[] argv) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Plain Text:");
		String text = sc.nextLine();
		RSA d=new RSA();
		byte[] str=d.doEncryption(text);
		System.out.println("Encrypted String : "+str);
		System.out.println("Decrypted String : "+d.doDecryption(str));
		
	}
}
