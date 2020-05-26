/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5: 5
        Comment:  I used easy-to-understand meaningful variable names formatted properly

 2. Did I indent the code appropriately?

        Mark out of 5: 5
        Comment:  I indented the code appropriately

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20
        Comment:  I wrote the createCipher function correctly or in the way that made the most sense anyways

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:   20
        Comment:	I wrote the encrypt function correctly or in the way that made the most sense anyways

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:   20
        Comment: I wrote the decrypt function correctly or in the way that made the most sense anyways

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25: 	25  
        Comment:I wrote it properly

 7. How well did I complete this self-assessment?

        Mark out of 5: 5
        Comment: I answered truthfully

 Total Mark out of 100 (Add all the previous marks): 100

*/ 

import java.util.Scanner;
import java.util.Random;

public class Cipher {
	
	public static final String[] ALL_CHARACTERS = {"a","b","c","d","e","f","g","h","i","j","k","l",
			"m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "} ;
	public static final String ALL_CHARACTERS_STRING = "abcdefghijklmnopqrstuvwxyz " ;
	public static final int TOTAL_CHARACTERS = 27 ;

	public static void main(String[] args) 
	{
		boolean finished = false ;
		System.out.print("Welcome to the 'Encryption Software'  ") ;
		do
		{
			char[] cipher = createCipher(ALL_CHARACTERS_STRING).clone() ;
			System.out.print("\nWhat sentance would you like to encrypt? Only letters and space can be used: ") ;
			Scanner scan = new Scanner(System.in) ;
			String stringToEncrypt = scan.nextLine() ;
			System.out.print("-" + encrypt(stringToEncrypt, cipher) + "-") ;
			String newString = encrypt(stringToEncrypt, cipher) ;
			letterChart(stringToEncrypt, cipher) ;
			System.out.print( " \nto give : " + decrypt(newString, cipher)) ;
			System.out.print( "\nWould you like to encrypt another sentance? respond Y/N : ") ;
			if(scan.hasNext("N"))
			{
				finished = true ;
				System.out.print("Thank you for using the program") ;
			}
			else if(scan.hasNext("Y"))
			{
				finished = false ;
			}
			else
			{
				System.out.print("Not a Valid Input, program is closing.") ;
			}
		}while (!finished) ;
	}
	public static char[] createCipher(String allChars)
	{
		char[] chars = allChars.toCharArray();
		char[] cipher = chars.clone() ;
		randomiseOrder( cipher ) ;
		return cipher ;
	}
	public static String encrypt(String stringToEncrypt, char[] cipher)
	{
		String lowercaseString = stringToEncrypt.toLowerCase();
		char[] stringInCharacters = lowercaseString.toCharArray();
		char[] listOfChars = ALL_CHARACTERS_STRING.toCharArray();
		for (int indexString = 0; indexString < stringInCharacters.length; indexString++ )
		    {
				for (int index = 0; index < TOTAL_CHARACTERS ; index++ )
			 	{
					if (stringInCharacters[indexString] == listOfChars[index]) 
					{
						stringInCharacters[indexString] = cipher[index];
						break;
					}
			 	}
		    }
		String cipheredString = new String(stringInCharacters) ;
		return cipheredString ;
	}
	public static String decrypt(String stringToDecrypt, char[]cipher)
	{
		char[] stringInCharacters = stringToDecrypt.toCharArray();
		char[] listOfChars = ALL_CHARACTERS_STRING.toCharArray();
		for (int indexString = 0; indexString < stringInCharacters.length; indexString++ )
		    {
				for (int index = 0; index < TOTAL_CHARACTERS ; index++ )
			 	{
					if (stringInCharacters[indexString] == cipher[index]) 
					{
						stringInCharacters[indexString] = listOfChars[index];
						break;
					}
			 	}
		    }
		String cipheredString = new String(stringInCharacters) ;
		return cipheredString ;
	}
	public static void letterChart(String stringToEncrypt, char[]cipher)
	{
		System.out.print( "\nThe following decryption was used {") ;
		for (int index=0; index< cipher.length; index++ )
	    {
			System.out.print(ALL_CHARACTERS[index] + "=" + cipher[index] + ", " ) ;
	    }
	}
	//This following function rearranges the characters in a random order thus creating a cipher
	//This following function is the property of Ken, Trinity College Dublin
	public static void randomiseOrder( char[] array )
	{
	  if (array!=null)
	  {
	    Random generator = new Random();
	    for (int index=0; index<array.length; index++ )
	    {
	      int otherIndex = generator.nextInt(array.length);
	      char temp = array[index];
	      array[index] = array[otherIndex];
	      array[otherIndex] = temp;
	    }
	  }
	}
	
}
