package com.george.codeAbbey;

import java.util.ArrayList;
import java.util.Scanner;

public class NeumannsRandomGeneratorProgram {
	/*** Random numbers are often used in programming games and scientific reserches, but also they could be useful in business aplications 
	to generate unique user keys, passwords etc. 
	   * The following is one of the earliest methods for producing sequence of seemingly independed numbers: 
	   ---
	   1. Choose some initial values with 4 digits(in range 0000-9999); 
	   2. Multiply it by itself to get value consisting of 8 digits; 
	   3. Truncate first two and last two digits; 
	   4. New value will consist of 4 digits and it is the next value in the sequence; 
	   5. Repeat from step 2, to get more values.
	   ---EXAMPLE---
	   1. 5761 							- let it be the first number; 
	   2. 5761 * 5761 = 33189121		- multiplying the number by itself 
	   3. 33(1891)21 = 1891				- truncating the first and last two digits; 
	   4. 1891 							- next number in the sequence; 
	   5. 1891 * 1891 = 3575881  		- repeating step 2; 
	   6. 03(5758)81 = 5758				- repeating step 3 and adding a leanding zero as the number from step 2 didin't have 8 digits.
	   7. 5758 							- third number in sequence.
	   ---
	   * Sooner or later each sequence will come to a kind of loop. For example:
	   - 0001 -> 0000 -> 0000 						---> came to loop after 2 iterations;
	   - 4100 -> 8100 -> 6100 -> 2100 -> 4100 		---> came to loop after 4 iterations. 
	--------------------------------------------------
	*** TASK: 
	  * You will be given initial numbers for several sequences. For each of them report the number of iterations needed to come to repetaion. 
	--------------------------------------------------
	*** INPUT FORMAT: 
	  * First line will contain an integer @N that represesnt the number of initial values. Next line will contain @N values separated by 
	space. 
	--------------------------------------------------
	*** OUTPUT FORMAT: 
	  * The ouput should contain the number of iteration needed for an initial number to come to repetion, for each sequence, separated by 
	space. 
	--------------------------------------------------
	*** SAMPLE INPUT: 
	  3
	  0001 4100 5761 
    --------------------------------------------------
	*** SAMPLE OUTPUT: 
	  2 4 88 
	----------------------------------------------------------------------------------------------------------------------------------------*/
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= testCases; i++) {
			int initialValue = scanner.nextInt();
			
			System.out.print(getNumberOfIteration(initialValue) + " ");
		}
		
		scanner.close();
	}

	public static int getNumberOfIteration(int initialValue) {
		/** Creating variable @count to store the number of iterations:*/
		int count = 0;
		
		/** Creating a @temp variable to store the result of initial value raised to the power of two: */
		int temp = initialValue * initialValue;
		
		/** Creating a list to store @initialValue and all the previous values generated: */
		ArrayList<Integer> previousValues = new ArrayList<>();
		previousValues.add(initialValue);
		
		while(true) {
			/** Getting the number of digits found @temp variable*/
			int numberOfDigits = String.valueOf(temp).length();
			
			/** Creating @leaadingZeros variable to store the necessary leading zeros for the numbers that are not of 8 digits:*/
			String leadingZeros = "";
			
			/** Checking if the @temp is of 8 digits or less: */
			if(numberOfDigits < 8) {
				/** If number of digits is less than 8 than append leading zeros at the beginning of the @temp variable:*/
				for(int i = numberOfDigits; i < 8; i++) {
					// Getting the necessary leading zeros required for the number to have 8 digits:
					leadingZeros += "0";
				}
				
				/** Updating @leadingZeros variable by appending at the end of it the @temp variable:*/
				leadingZeros = leadingZeros + temp;
				
				/** Getting the next 4 digits number in the sequence by removing the first and last 2 digits from @leadingZeros variable: */
				temp = Integer.valueOf(leadingZeros.substring(2, 6));
			} else {
				/** If number of digits is exactly of 8 digits than just remove the last and first two digits from @temp variable: */
				temp /= 100;
				temp %= 10000;
			}
			
			boolean flag = false;
			
			/** Cheacking if the @temp variable equals any of the previous values saved in @previousValues list and set flag to true
			if it does: */
			for(int i = 0; i < previousValues.size(); i++) {
				if(temp == previousValues.get(i)) {
					flag = true;
				} 
			}
			
			/** If @temp doesn't equal any of the previous values than we add @temp into the @previousValues list, we raised it to the power
			of 2 and we increment the count by one: */
			previousValues.add(temp);
			temp *= temp;
			count++;
		
			/** If @temp equals any of the previous values the flag would have been setted to true and so we will break the loop: */
			if(flag) {
				break;
			}
		}
		
		// Returning the total number of iterations counted:
		return count;
	}
}
