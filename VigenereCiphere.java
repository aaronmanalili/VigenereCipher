package vigenerecipher;
import java.util.Scanner;

// CSIT 460-01 Vigenere Cipher by Aaron Manalili

public class VigenereCipher {

	static String createKey(String input, String keyword) 
	{
		int a = input.length();
		
		for(int i = 0; ; i++) 
		{
			if (a == i) 
			{
				i = 0;
				
				if(keyword.length() == input.length() || keyword.length() > input.length()) 
				{
					break;
				}
			}
			
			keyword += (keyword.charAt(i));
		}
		
		return keyword;
	}
	
	public static String Encryption(String input, String keyword) 
	{
		String messageCiphered = "";
		
		for(int i = 0; i < input.length(); i++) 
		{
			int convert = (input.charAt(i) + keyword.charAt(i)) % 26;
			convert += 'A';
			messageCiphered += (char)(convert);
		}
		return messageCiphered;
	}
	
	public static String Decryption(String messageCiphered, String keyword) 
	{
		String messageDeciphered = messageCiphered.toUpperCase();
		for(int i = 0; i < messageCiphered.length() && i < keyword.length(); i++) 
		{
			int c = (messageCiphered.charAt(i) - keyword.charAt(i) + 26) % 26;
			messageCiphered += (char)(c);
		}
		return messageDeciphered;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input, keyword;
		System.out.println("Enter input: ");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		
		System.out.println("Enter in a string keyword: ");
		@SuppressWarnings("resource")
		Scanner myKeyWord = new Scanner(System.in);
		keyword = myKeyWord.nextLine();
		
		System.out.println("Message of the user before encryption: " + input);
		System.out.println("The keyword is: " + keyword);
		
		System.out.println("The user inputed a message: " + input + ". By encrypting with shift cipher, the corresponding Encrypted message is: " + Encryption(input, keyword));
		
		System.out.println("The encrypted message is: " + Encryption(input, keyword) + ". By deciphering with shift cipher, the corresponding Decrypted message is: " + Decryption(input, keyword));
	}

}
