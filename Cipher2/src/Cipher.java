import java.util.Scanner;
import java.util.Random;

public class Cipher {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz ";

	public static void main(String[] args) {

		boolean finished = false;
		while (!finished) {
			System.out.println("Enter the text you would like to encrypt, or type 'exit':");
			Scanner scan = new Scanner(System.in);
			if (scan.hasNext("exit")) {
				finished = true;
				System.out.println("Program ended, thank you.");
			} else {
				String decryptedString = scan.nextLine();
				char[] cipher = createCipher();
				String lowercaseString = decryptedString.toLowerCase();
				char[] decryptedArray = lowercaseString.toCharArray();
				String encryptedString = encrypt(cipher, decryptedArray);
				System.out.println("The encrypted phrased is: " + encryptedString);
				char[] encryptedArray = encryptedString.toCharArray();
				System.out.println("The decrypted phrased is: " + decrypt(cipher, encryptedArray));
			}
		}
	}

	public static char[] createCipher() {

		char[] cipher = ALPHABET.toCharArray();
		if (cipher != null) {
			Random generator = new Random();
			for (int index = 0; index < cipher.length; index++) {
				int otherIndex = generator.nextInt(cipher.length);
				char temp = cipher[index];
				cipher[index] = cipher[otherIndex];
				cipher[otherIndex] = temp;
			}
		}
		return cipher;
	}

	public static String encrypt(char[] cipher, char[] characterArray) {

		for (int letterIndex = 0; (letterIndex < characterArray.length); letterIndex++) {
			for (int index = 0; (index < ALPHABET.toCharArray().length); index++) {
				if (characterArray[letterIndex] == ALPHABET.toCharArray()[index]) {
					characterArray[letterIndex] = cipher[index];
					break;
				}
			}
		}
		String encryptedString = new String(characterArray);
		return encryptedString;
	}

	public static String decrypt(char[] cipher, char[] characterArray) {
		for (int letterIndex = 0; (letterIndex < characterArray.length); letterIndex++) {
			for (int index = 0; (index < cipher.length); index++) {
				if (characterArray[letterIndex] == cipher[index]) {
					characterArray[letterIndex] = ALPHABET.toCharArray()[index];
					break;
				}
			}
		}
		String decryptedString = new String(characterArray);
		return decryptedString;
	}
}
