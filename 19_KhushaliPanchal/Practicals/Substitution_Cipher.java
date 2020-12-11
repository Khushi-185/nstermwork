import java.util.Scanner;
class Substitution_Cipher{
	Scanner sc;
	String plain_text,cipher_text,decrypted_text;
	int shift;
	Substitution_Cipher(){
		sc=new Scanner(System.in);
		cipher_text="";
		decrypted_text="";
		shift=0;
	}
	void getData(){
		System.out.print("Enter Plain Text : ");
		plain_text=sc.nextLine();
		plain_text=plain_text.trim();
		System.out.print("\nEnterShift : ");
		shift=sc.nextInt();
	}
	void encryptData(){
		char ch;
		for(int i=0;i<plain_text.length();i++){
			ch=plain_text.charAt(i);
			if(ch>='A' &&ch<='Z'){
				ch=(char)(ch+shift);
				if(ch>'Z'){
					ch=(char)(ch-'Z'+'A'-1);
				}
				cipher_text=cipher_text+ch;
			}
			else if(ch>='a' &&ch<='z'){
				ch=(char)(ch+shift);
				if(ch>'z'){
					ch=(char)(ch-'z'+'a'-1);
				}
				cipher_text=cipher_text+ch;
			}
		}
		System.out.println("Cipher Text  :  "+cipher_text);
	}
	void decryptData(){
		char ch;
		for(int i=0;i<cipher_text.length();i++){
			ch=cipher_text.charAt(i);
			if(ch>='A' &&ch<='Z'){
				ch=(char)(ch-shift);
				if(ch<'A'){
					ch=(char)(ch-'A'+'Z'+1);
				}
				decrypted_text=decrypted_text+ch;
			}
			else if(ch>='a' &&ch<='z'){
				ch=(char)(ch+shift);
				if(ch<'a'){
					ch=(char)(ch-'a'+'z'+1);
				}
				decrypted_text=decrypted_text+ch;
			}
		}
		System.out.println("Decrypted Text  :  "+decrypted_text);
	}
	public static void main(String args[]){
		Substitution_Cipher cc=new Substitution_Cipher();
		cc.getData();
		cc.encryptData();
		cc.decryptData();
	}
}	
