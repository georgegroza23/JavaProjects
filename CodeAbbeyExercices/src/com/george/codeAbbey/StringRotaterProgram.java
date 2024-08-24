package com.george.codeAbbey;

import java.util.Scanner;

public class StringRotaterProgram{
	/*** TASK: 
	   * Given a String, rotate that string by -k- characters. To rotate String by -k- characters means to cut this -k- characters from the 
	beginning and place them to the end. If -k- is a negative number, than cut the -k- characters from the end and placed them to the front.
	----------------------------------------
	*** INPUT FORMAT: 
	  * First line will contain an integer -N- that represent the number of test-cases. The following -N- lines will contain an integer -k- 
	that represents the number of characters that must be rotated, followed by a string -s- on which roation should be made. 
	----------------------------------------
	*** OUTPUT FORMAT:
	  * The output should contain the strings rotated in accordance to the above rules separated by space.
	----------------------------------------
	*** SAMPLE INPUT: 
	  2
	  3 forwhomthebelltolls
	  -6 verycomplexnumber
	----------------------------------------
	*** SAMPLE OUTPUT: 
	  whomthebelltollsfor numberverycomplex
	----------------------------------------------------------------------------------------------------------------------------------------*/
	 
	public static void main(String[] args) {
		// Creating a Scanner object:
		Scanner scanner = new Scanner(System.in);
		
		//Taking the number of test-cases from stdin and moving the cursor to the next line:
		int testCases = scanner.nextInt();
		//scanner.nextLine();
		
		// Iterating through every test-case and reading the String and the number of characters that we need to rotate from input:
		for(int i = 1; i <= testCases; i++) {
			int charsToRotate = scanner.nextInt();
			String givenString = scanner.next();
			
			/** Printing the result as in SAMPLE OUTPUT: */
		    // System.out.println(rotateString(givenString, charsToRotate) +  " ");
			
			try {
			    rotateStringWithoutConcat(givenString, charsToRotate);
			} catch (NullPointerException e) {
				System.out.println(e);
			}
		}
		
		// Closing the scanner:
		scanner.close();
	}

	/** 1. Method to rotate a given String by -k- characters using concatenation: */
	public static String rotateString(String str, int k)  {
		/** Storing the length if the given String into a variable -length-*/
		int length = str.length();
		
		/** Checking if the -k- is negative or positive:*/
		if(k > 0) {
			/** If -k- is positive, we cut the given String from -k- and we concatenate it with the remaining substring(the substring that 
			starts from -index[0]- at ends at -index[k]-: */
			str = str.substring(k).concat(str.substring(0, k));
		} else {
			/** If -k- is negative, we first make the k positive and than we cut the given String from -index[length - k]- and we concatenate 
			it with the remaining substring(the substring that starts from -index[0]- and ends at -index[length - k]-: */
			k = k - (k * 2);
			str = str.substring(length - k).concat(str.substring(0, length - k));
		}
		
		// Returning the resulted String:
		return str;
	} 
	
	
	/** 2. Method that we are going to use inside @rotateStringWithoutConcat() method: */
	private static void reverse(char[] array, int start, int end) {
		while(start < end) {
			char temp =  array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
			
		}
	}
	
	/** 2.1 Method to rotate a given String by @k characters without using concatenation: */
	public static void rotateStringWithoutConcat(String str, int k) {
		//  Checking if the String is null or blank:
		if(str == null) {
			throw new NullPointerException("Given string cannot be null!");
		} else if(str.isBlank()) {
			System.out.println(str);
		}
		
		// Converting the given string into char array:
		char[] array = str.toCharArray();
		
		// Finding the length of the given string:
		int length = str.length();
		

		/** Cheking if @k is greater than the @length or negative: */
		if(k > length) {
			k = k % length;
		} else if (k < 0) {
			k = k + length;
		}
		
		/** Calling the created @reverse(char[], int, int) method:*/
		reverse(array, 0, k - 1);
		reverse(array, k, length - 1);
		reverse(array, 0, length - 1);
		
		// Printing the result:
		for(char c : array) {
			System.out.print(c);
		}
	}
}
