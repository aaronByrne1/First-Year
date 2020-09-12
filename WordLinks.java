/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:]
- Comment: 
- My method reads the words from the "words.txt" file. [Mark out of 5:]
- Comment: yes with filereader and buffered reader
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: Does this exactly

2. readWordList
- I have the correct method definition [Mark out of 5:5 ]
- Comment: All my methods do what theyre required to do
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
- Comment:  yes splits them with the split function

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment:  has a nested loop to look at each word and compare them all 
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: yes
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: yes it breaks
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: yes

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: yes
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: yes

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:]
- Comment: yes does it char by char

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: yes gets all the boolean values

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: yes
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: yes

 Total Mark out of 100 (Add all the previous marks): 100
*/


import java.io.*;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class WordLinks {

	public static ArrayList <String> readDictionary() throws FileNotFoundException{
		BufferedReader bufferedReader;
		ArrayList<String> dictionary = new ArrayList<String>();

		FileReader fileReader = new FileReader("words.txt");
		bufferedReader = new BufferedReader(fileReader);


		try {
			String nextWord = bufferedReader.readLine();
			while(nextWord != null){
				dictionary.add(nextWord);
				nextWord =  bufferedReader.readLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return dictionary;
	}

	public static String[] readWordList(String list) {
		String[] wordList=list.split(",");

		return wordList;
	}

	public static boolean isUniqueList(String wordList[]) {
		boolean uniqueWord=true;
		for(int i=0; i<wordList.length;i++) {
			String word = wordList[i];
			for(int index=0; index<wordList.length;index++) {
				String word2 = wordList[index];
				if(Objects.equals(word, word2)&& i!=index) {
					i=wordList.length;
					index=wordList.length;
					uniqueWord=false;
				}
				else {
					uniqueWord=true;
				}

			}
		}
		return uniqueWord;
	}
	public static boolean isEnglishWord(String word, ArrayList <String> dictionary) {
		String[] array = dictionary.toArray(new String[dictionary.size()]);
		if(Arrays.binarySearch(array, word) >= 0)
		{
			return true;
		}
		else {
			return false;
		}

	}
	public static boolean isDifferentByOne(String wordOne, String wordTwo) {
		int count=0;
		for(int i=0; i<wordOne.length();i++) {
			if(wordOne.length()!=wordTwo.length()||wordOne.charAt(i)!=wordTwo.charAt(i)) {
				count++;
			}
		}
		if (count>1) {
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean isWordChain(String wordList[], ArrayList <String> dictionary) {
		boolean wordChain=false;
		boolean uniqueWord=isUniqueList(wordList);
		boolean englishWord=false;
		for(int i=0;i<wordList.length;i++) {
			englishWord=isEnglishWord(wordList[i],dictionary);
		}
		boolean diffByOne=false;
		for(int i =1;i<wordList.length;i++) {
			diffByOne=isDifferentByOne(wordList[i-1],wordList[i]);

			if(englishWord&&uniqueWord&&diffByOne==true) {
				wordChain=true;
				break;
			}
		}

		return wordChain;

	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList <String> dictionary=new ArrayList<String>();
		try {
			dictionary = readDictionary();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		String list="";
		String[] wordList;
		boolean quit=false;
		do {
			
			System.out.println("Enter a comma separated list of words (or an empty list to quit): ");

			list =scanner.nextLine();


			wordList= readWordList(list);
			
			if (Objects.equals(wordList[0], "")) {
				
				break;
				
			}
			boolean wordChain=isWordChain(wordList, dictionary);

			if(wordChain == true) {
				System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
			}
			else if(wordChain==false) {
				System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
			}

		}
		while(quit==false);
		System.out.println("You Quit.");
	
	}
	
	

}
