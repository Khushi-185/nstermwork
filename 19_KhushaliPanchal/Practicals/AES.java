import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Scanner;
class AES{
	private byte[] key;
	AES(){
		key="kHFlksfddsaKHBDS".getBytes();
	}
	private byte[] encrypt(String plainText) throws Exception{
		SecretKeySpec sKey = new SecretKeySpec(key,"AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE,sKey);
		return cipher.doFinal(plainText.getBytes());
	}
	private byte[] decrypt(String cipherText) throws Exception{
		SecretKeySpec sKey=new SecretKeySpec(key,"AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE,sKey);
		return cipher.doFinal(cipherText.getBytes());
	}
	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Plain Text : ");
		String plainText=sc.nextLine();
		AES aes=new AES();
		String cipherText=new String(aes.encrypt(plainText));
		System.out.println("Encrypted Text : " + cipherText);
		System.out.println("Decrypted Text : " + new String(aes.decrypt(cipherText)));
	}
}
