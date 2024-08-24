package com.george.codeAbbey;

import java.util.Scanner;

public class PalindromesProgram {
	/*** A word or a whole phrase which has the same sequence of letters in both directions is called palindrome. The following are a few 
	examples: - Stats 
	 		  - Amore, Roma 
	 		  - No x in Nixon 
	 		  - Was it a cat I saw?
	The case of the letters, punctuations and spaces are ignored. 
	--------------------------------------------------------------
	*** TASK: 
	  * Determine whether the given phrase is palindrome or not.
	--------------------------------------------------------------
	*** INPUT FORMAT: 
	  * The first line will contain an integer @T that represents the number of test-cases. The @N following lines will contain eihter a 
	phrase or a word that has to be tested. 
	--------------------------------------------------------------
	*** OUTPUT FORMAT:
	  * The output should contain a single letter separated by space for each phrase: @Y if is a palindrome or @N if is not a palindrome.
	--------------------------------------------------------------
	*** SAMPLE OUTPUT:
	  3
	  Stars
	  O, a kak Uwakov lil vo kawu kakao!
	  Some men interpret nine memos
	--------------------------------------------------------------
	*** SAMPLE OUTPUT:
	  N Y Y 
	----------------------------------------------------------------------------------------------------------------------------------------*/
	
	public static void main(String[] args) {
		// Creating a Scanner object:
		Scanner scanner = new Scanner(System.in);
		
		// Taking the number of test-cases from input and moving cursor to the next line:
		int testCases = scanner.nextInt();
		scanner.nextLine();
		
		// Looping through the test-cases and checking if the given word or phrase is palindrome or not:
		for(int i = 1; i <= testCases; i++) {
			// Taking the word or phrase from the input:
			String inputText = scanner.nextLine();
			
			// Checking the @inputText and returning the answer as required:
			System.out.print(checkIfPalindrome(inputText)? "Y " : "N ");
		}
		
		// Closing the Scanner:
		scanner.close();
	}

	// Creating method to reverse a String:
	public static String reverseString(String str) {
		// Checking if the String is null
		if(str == null) {
			System.out.println("The given String must not be null!");
		} 
		
		// Creating a variable @reversed of type String that will store the reversed string.
		String reversed = "";
		
		// Reversing the characters from the given String:
		for(int i = str.length() - 1; i >= 0; i--) {
			reversed += str.charAt(i);
		}
		
		// Returning the reversed string:
		return reversed;
	}
	
	// Method to check if a given string is either a palindrom or not:
	public static boolean isPalindrome(String str) {
		// Checking if the given string is null:
		if(str == null) {
			System.out.println("The given string cannot be null!");
		}
		
		// Replacing all white-spaces and punctuations in the given string:
		String updatedStr = str.replaceAll("[\\s+\\W+]", "");
		
		// Reversing the @updatedStr:
		String updatedStrReversed = reverseString(updatedStr);
		
		// Checking if they are equal and returning the result:
		return updatedStr.equalsIgnoreCase(updatedStrReversed);
	}
	
	// Straight forward method to solve the exercice:
	public static boolean checkIfPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		
		String startingChar = "";
		String endingChar = "";
		
		while(start < end) {
			startingChar = str.charAt(start) + "";
			endingChar = str.charAt(end) + "";
			
			if(startingChar.matches("\\W+")) {
				start++;
			} else if (endingChar.matches("\\W+")) {
				end--;
			} else {
				if(startingChar.equalsIgnoreCase(endingChar)) {
					start++;
					end--;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
}
