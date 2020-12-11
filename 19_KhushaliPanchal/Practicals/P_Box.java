import java.util.Scanner;
class P_Box{
	public String doEncryption(String s){
		byte p[]=new byte[8];
		byte pTemp[]=new byte[8];
		pTemp=s.getBytes();
		p[0]=pTemp[4];
		p[1]=pTemp[0];
		p[2]=pTemp[5];
		p[3]=pTemp[7];
		p[4]=pTemp[1];
		p[5]=pTemp[3];
		p[6]=pTemp[2];
		p[7]=pTemp[6];
		return(new String(p));
	}
	public String doDecryption(String s){
		byte p[]=new byte[8];
		byte pTemp[]=new byte[8];
		pTemp=s.getBytes();
		p[0]=pTemp[1];
		p[1]=pTemp[4];
		p[2]=pTemp[6];
		p[3]=pTemp[5];
		p[4]=pTemp[0];
		p[5]=pTemp[2];
		p[6]=pTemp[7];
		p[7]=pTemp[3];
		return(new String(p));
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnterString(Only 8 Characters) : ");
		String plaintext=sc.nextLine();
		P_Box p_box=new P_Box();
		System.out.println("Encrypted Text : " + p_box.doEncryption(plaintext));
		System.out.println("Decrypted Text : " + p_box.doDecryption(p_box.doEncryption(plaintext)));
	}
}
