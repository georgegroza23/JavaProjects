package com.george.codeAbbey;

import java.util.Scanner;

public class CollatzSequenceProgram {
	/** This one is one of the most misterious math problem of the last century because its statement its extremely and because the proof is still
	unknown. It is also a good programming exercice for beginners. 
	  * Suppose we select some initial number -X- and then build the sequence of values by the following rules:
		- if -x- is even than the value after x will be the result of x / 2 . 
		- if -x- is odd than the value after x will be the result of 3 * x + 1. 
	  * What will be noticed is that if -x- is odd sequence grows and if it is even sequence decreases. For example, with -x = 15- will have:
	15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 - after the sequence reaches 1 it enters the loop 1 4 2 1 4 2 1.... 
	  * The intrigue is in the fact that any starting number -x- gives the sequence that sooner or later reaches 1. Though this -Collatz Conjecture- 
	was expressed in 1937, up to now no one could find a proof that is really so for any -x-.  	
	-------------------------------------
	 ** GIVEN TASK:
	  * For a given number -x- calculate how many steps are necessary to come to 1. 
	-------------------------------------
	 ** INPUT FORMAT: 
	  * There will be only two lines where the first line conatains an integer that represents the number of test-cases and the second line will 
	contain the values for wich calculation should be performed. 
	-------------------------------------
	 ** OUTPUT FORMAT: 
	  * Should contain the same amount of results, each of them being the count of steps for getting -Collatz Sequence- to 1. 
	-------------------------------------
	 ** SAMPLE INPUT:
	 3
	 2 15 97 
	-------------------------------------
	 ** SAMPLE OUTPUT: 
	 1 17 118 
	---------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	public static void main(String[] args) {
		// Creating a Scanner object:
		Scanner scanner = new Scanner(System.in);
		
		// Taking the number of test-cases from stdin:
		int testCases = scanner.nextInt();
		// Moving the cursor to the next line:
		scanner.nextLine();
		
		// For loop to count the number of steps for every given -testCase-:
		for(int i = 1; i <= testCases; i++) {
			// Taking the testCase from stdind:
			int testCase = scanner.nextInt();
			
			// Printing the result according to the given SAMPLE OUTPUT:
			System.out.printf("%d ", countSteps(testCase));
		}
		
		// Closing the scanner:
		scanner.close();
	}
	
	public static int countSteps(int x) {
		// Creating a variable count to keep track of the steps:
		int count = 0;
		
		// While loop to execute one of the two operations as long as x not equals 1:
		while(x != 1) {
			// Checking if x is even or odd:
			if(x % 2 == 0) {
				// If is even we update x by dividing it with two:
				x = x /= 2;
			} else {
				// If is odd we update x by multiplying it with 3 and than add it with 1:
				x = x * 3 + 1;
			}
			
			// Incrementing the -count- by one:
			count++; 
		}
		
		// Returning the count that represents the number of steps required for the given number to reach 1:
		return count; 
	}

}
