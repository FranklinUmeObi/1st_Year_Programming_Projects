/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: i have the right method definition
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: My method reads the words from the "words.txt" file.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: It returns the contents from "words.txt" in an ArrayList

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: i have the right method definition
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: My method reads the words provided

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment:  i have the right method definition
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: My method compares each word in the array with the rest of the words in the list.
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: Exits the loop when a non-unique word is found
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: Returns true is all the words are unique and false otherwise

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: I have the correct method definition
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: since i used an arrayList i used the .contains() function
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: my method returns true if the word is found

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: I have the correct method definition
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: My method loops through the length of a words comparing characters at the same position in both words searching for one difference

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: I have the correct method definition
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Asks the user for input and calls isWordChain

 Total Mark out of 100 (Add all the previous marks):100
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
  
public class WordLinks {

	public static void main(String[] args) 
	{
		boolean finished = false ;
		
		Scanner scan = new Scanner(System.in) ;
		scan.useDelimiter(", ") ;
		scan.useDelimiter("\n") ;
		do
		{
			ArrayList<String> dictionary = new ArrayList<String>();
			ArrayList<String> userList = new ArrayList<String>();
			readDictionary(dictionary) ;
			System.out.println("Enter a comma separated list of words (or an empty list to quit):");
			String theUsersInput = scan.nextLine() ;
			if(theUsersInput.isEmpty())
				{
				finished = true ;
				break ;
				}
			readWordList(theUsersInput, userList) ;
			if(isWordChain(userList, dictionary))System.out.println(":)  This is a valid chain of words from Lewis Carroll's word-links game.") ;
			else System.out.println(":(  This isn't a valid chain of words from Lewis Carroll's word-links game.") ;
		}while(!finished) ;	
	}

	public static void readDictionary(ArrayList<String> dictionary)
	{
		try {
			FileReader fileReader = new FileReader("C:\\eclipse-workspace\\WordLinks\\src\\words.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);  
			boolean endOfFile = false;
	        while(!endOfFile)
	        {
	        	String dictionaryLine = bufferedReader.readLine();
	        	if (dictionaryLine != null) 
	        	{
	        		String[] dictionaryData = dictionaryLine.split("\n");
	        		String word = dictionaryData[0] ;
	        		dictionary.add(word);
	        	} 
	        	else 
	        	{
	        		endOfFile = true;
	        	}
	        }
	        
	        bufferedReader.close();    
	        fileReader.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void readWordList(String userInput, ArrayList<String> userList)
	{
		String[] arrayOfString = userInput.split(", ");
		for (int i = 0 ; i < arrayOfString.length ; i++)
		{
			String aWord = arrayOfString[i] ;
			userList.add(aWord) ;
//			System.out.println(userList.get(i));
		}
	}
	
	public static boolean isUniqueList(ArrayList<String> usersList)
	{
		int inconsistancy = 0 ;
		for (int i = 0; i < usersList.size() - 1; i++) 
		{
			int next = i + 1 ;
			if(usersList.get(i).equals(usersList.get(next))) 
				{
				inconsistancy = 1 ;
				break ;
				}
		}
		if(inconsistancy == 0) return true ;
		else return false ;
		
	}
	
	public static boolean isEnglishWord(String wordToCheck, ArrayList<String> dictionary)
	{
		if(dictionary.contains(wordToCheck)) return true ;
		else return false ;
	}
	
	public static boolean isDifferentByOne(String firstWord, String secondWord)
	{
		char[] word1= firstWord.toCharArray();
		char[] word2= secondWord.toCharArray();
		if(word1.length != word2.length) return false ;
		int difference = 0 ;
		for (int i = 0; i < word2.length; i++) 
		{
			if(word1[i] != word2[i]) difference++ ; 
		}
		
		if(difference != 1) return false ;
		else return true ;
	}
	
	public static boolean isWordChain(ArrayList<String> usersList, ArrayList<String> dictionary)
	{
		if(!isUniqueList(usersList)) return false ;
		for (int i = 0; i < usersList.size(); i++) 
		{
			if(!isEnglishWord(usersList.get(i), dictionary)) return false ;
		}
		for (int i = 0; i < usersList.size() - 1 ; i++ )
		{
			if(!isDifferentByOne(usersList.get(i), usersList.get(i+1))) return false ;
		}
		return true ;
	}
	
}
