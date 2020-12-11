import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.util.*;
import java.util.Base64;
import java.util.Base64;;

public class DES {

	private static Cipher ecipher;
	private static Cipher dcipher;

	private static SecretKey key;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			key = KeyGenerator.getInstance("DES").generateKey();

			ecipher = Cipher.getInstance("DES");
			dcipher = Cipher.getInstance("DES");
			
			ecipher.init(Cipher.ENCRYPT_MODE, key);
			dcipher.init(Cipher.DECRYPT_MODE, key);
			System.out.println("Enter Plain Text:");
			String text = sc.nextLine();
			String encrypted = encrypt(text);
			String decrypted = decrypt(encrypted);
			System.out.println("Decrypted: " + decrypted);

		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		

	}

	public static String encrypt(String str) 
	{
		try {
		byte[] utf8 = str.getBytes("UTF8");
		byte[] enc = ecipher.doFinal(utf8);
		enc = Base64.getEncoder().encode(enc);
		String str1 = Base64.getEncoder().encodeToString(enc);
		System.out.println("Encrypted String.\n" + str1);
		return new String(enc);
		}catch (Exception e) {e.printStackTrace();}

		return null;

    }

	public static String decrypt(String str) 
	{
		try {
			byte[] dec = Base64.getDecoder().decode(str.getBytes());
			byte[] utf8 = dcipher.doFinal(dec);

			return new String(utf8, "UTF8");
			}catch (Exception e) {e.printStackTrace();}
			return null;
	}

}