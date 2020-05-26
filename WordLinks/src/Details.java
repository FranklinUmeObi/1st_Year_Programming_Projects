/*
Word-links (also known as Doublets or Word Ladders) is a puzzle game based on words 
invented by Lewis Carroll [see Wikipedia webpage: Word ladder]
 [see Wolfram Blog: The Longest Word Ladder Puzzle Ever]. 
 A word-links puzzle begins with two given words (called the first and last words) 
 which are usually semantically related. To solve the puzzle a player must find a 
 chain of words which link the first word to the last word, in such away that, two 
 adjacent words in the list of words (i.e., words which are side by side in the list) 
 are of the same length and differ by one letter only.

For example, a chain of words linking the word "smile" (the first word) to the word "tears" (the last word) is:

smile, stile, stale, stare, stars, sears, tears

A chain of words linking the word "gimlet" to the word "theeing" is:

gimlets, giblets, gibbets, gibbers, libbers, limbers, lumbers, 
cumbers, cambers, campers, carpers, carters, barters, batters, 
butters, putters, puttees, putties, patties, parties, parries, 
carries, carrier, currier, curlier, burlier, bullier, bullies, 
bellies, jellies, jollies, collies, collins, colling, coaling, 
coaming, foaming, flaming, flaking, fluking, fluxing, flexing, 
fleeing, freeing, treeing, theeing

Write a Java program which will allow a user to enter a list of words separated by 
commas (,) and which will determine whether the entered list of words is a valid 
chain of words for Lewis Carroll's Word-links game. Your program should terminate 
only when the user enters an empty list. Your program must implement and use (at least) 
the following static methods:

readDictionary() 
which reads all the English words within the file "words.txt" (attached below) 
and which returns all the read words as an array or an ArrayList of String 
values (objects). The file "words.txt" contains 658964 English words 
arranged in alphabetic order and the line separator in the file is "\n". 

readWordList() 
which reads a comma (,) separated String of words from the standard input 
and which returns the list represented as an array or an ArrayList of 
String values (objects).

isUniqueList() 
takes an array or an ArrayList of String values and which determines whether
list contains unique String values, i.e., no two String values at different 
locations in the array are equal.
 
isEnglishWord() 
which takes a String value and which determines whether the String value is an
English word. [Hint: Use the binarySearch function (static method) from the library
class Arrays (which contains static methods for manipulating arrays) to search for 
the String value in the array of Strings formed from reading the file "words.txt".]

isDifferentByOne() 
which takes two Strings and which determines whether the two Strings are of the same 
length and differ by exactly one character only.

isWordChain() 
which takes a list of words (represented as an array or an ArrayList of Strings) and 
which determines whether the list of words is a valid chain of words for Lewis Carroll's 
word-links game.

Example input and output from the program is as follows:

Enter a comma separated list of words (or an empty list to quit):   smile, stile, stale, stare, stars, sears, tears 

This is a valid chain of words from Lewis Carroll's word-links game.

Enter a comma separated list of words (or an empty list to quit):
*/