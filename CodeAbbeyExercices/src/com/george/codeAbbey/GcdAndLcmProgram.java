package com.george.codeAbbey;

import java.util.Scanner;

public class GcdAndLcmProgram {
	/*** Greatest Common Divisor or GCD of -a- and -b- is such an integer value -c- that both -a- and -b- are divisible by it - and also is 
	the largest value. 
	-------------------------------------------
	 *** Least Common Multiple or LCM of -a- and -b- is such an integer d that devides both of them - and is the smallest of them all. 
	It can be found with the following rule: -lcm(a, b) = a * b / gcd(a, b)-. 
	-------------------------------------------
	 *** TASK:
	   * Find the GCD and LCM of the given pairs. 
	-------------------------------------------
	 *** INPUT FORMAT: 
	   * First line will contain an integer N that represent the number of test-cases and the next N lines will contain pairs of two integers 
	 -a b- for wich you need to find the GCD(greatest common divisor) and LCM(least common multiple). 
	-------------------------------------------
	 *** OUTPUT FORMAT:
	    * The output should contain the LCM and GCD for every given pairs, surrounded by brackets  and separated by space. 
	-------------------------------------------
	 *** SAMPLE INPUT: 
	   2
	   2 3 
	   4 10 
	-------------------------------------------
	 *** SAMPLE OUPUT: 
	   (1 6) (2 20)  
	----------------------------------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		// Creating a scanner object:
		Scanner scanner = new Scanner(System.in);
		
		// Taking the number of test-cases from stdin:
		int testCases = scanner.nextInt();
		
		//Moving the cursor to the next line:
		scanner.nextLine();
		
		// Iterating through every testCase:
		for(int i = 1; i <= testCases; i++) {
			// Reading a and b from stdin:
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			//Printing the result as shown in the SAMPLE OUTPUT:
			System.out.printf("(%d %d) ", findGCD(a, b), findLCM(a, b));
		}
		
		// Closing the scanner:
		scanner.close(); 
		
	}

	// Recursive method to find GCD:
	public static int findGCD(int a, int b) {
		/** LOGIC USED TO FIND GCD:
		  * First we find which is the bigger number between -a- and -b-.
		  * Suppose -a- is the bigger number:
		  - we devide -a- with -b- using modulo and store the remainder into a variable; 
		  - the remainder will become the smaller number and the previous smaller number will become the bigger number.
		  - we repeat to devide the bigger number at smaller number using modulo until reamainder will equal zero.
		  - when remainder will equal zero we return the smaller number wich represent the GCD. 
		  
		  MODEL:
		  Suppose a(bigger number) = 1824 and b(smaller number) = 336:
		  remainder = 1824 % 336 = 144. -> now the remainder is the smaller number and previous smaller number 336 becomes the bigger number:
		  remainder = 336 % 144 = 48 -> same as above
		  remainder = 144 % 48 = 0 -> as now the remainder equals zero, we return the smaller number wich is 48 that also represent the GCD.
		------------------------------------------------------------------------------------------------------------------------------------*/
		
		//Finding which one of the two given number is the smaller and the bigger one:
		int biggerNumber = a > b? a : b;
		int smallerNumber = a < b? a : b;
		
		// Base case for the recursive method to stop calling itself and return the desired result:
		if(biggerNumber % smallerNumber == 0) {
			return smallerNumber;
		}
		
		int remainder = biggerNumber % smallerNumber;
		biggerNumber = smallerNumber;
		smallerNumber = remainder;
		
		// Calling the method recursively:
		return findGCD(biggerNumber, smallerNumber);
	}
	
	// Method to find LCM:
	public static int findLCM(int a, int b) {
		// Formula for find LCM: lcm(a, b) = a * b / gcd(a, b).
		return  a * b / findGCD(a, b);
	}
}
