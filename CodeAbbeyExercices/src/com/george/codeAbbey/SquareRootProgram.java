package com.george.codeAbbey;

import java.util.Scanner;

public class SquareRootProgram {
	/*** Many mathematical problems are solved in programming not precisely, but approximately, by several computations of the result, each 
	of which is more and more close to the goal. 
	  ** We can approximate calculation of the square root using HERON's METHOD: 
	   * To find square root -r- of a value -v-, first choose any reasonable approximation. We use -r = 1- for this example;
	   * Calculate -d- as the result of division -v- by -r- i.e. -d = v / r-;
	   * Check the difference between -r- and -d-. If it's small enough for your purpose,than stop and return -r-;
	   * Calculate the average between -r- and -d- and use it as the next step approximation, i.e. r{new} = (r + d) / 2;
	   * Proceed with the new approximation from the step 2.
	  
	  ** METHOD EXAMPLE for sqrt(10).
	   * Step 1:
	   r = 1
	   Applying -d = v / r-: d = 10 / 1 = 10
	   Check the difference between -r- and -d-: abs(r - d) = abs(1 - 10) = 9 -> the difference is bit to much as 9 * 9 != 10;
	   Calculating the average between -r- and -d- and using the result as next approximation: r = (r + d) / 2 = (1 + 10) / 2 = 11 / 2 = 5.5;
	   
	   * Step 2:
	   r = 5.5
	   d = 10 / 5.5 = 1.8182
	   abs(r - d) = abs(5.5 - 1.8182) = 3.6818 -> again to much so we move to next sub-step:
	   r = (r + d) / 2 = (5.5 + 1.8182) / 2 = 3.6591
	   
	   * Step 3:
	   r = 3.6591
	   d = 10 / 3.6591 = 2.7329
	   abd(r - d) = (3.6591 - 2.7329) = 0.9262
	   r = (3.6591 + 2.7329) / 2 = 3.196
	   r = 3.196 is a reasonably well approximation as the exact value is 3.1623 which whould have got it if we had moved on with the steps.
	----------------------------------------
	 *** TASK: 
	   * You are given values -X- for which to perform calculations and number of steps -N- to perform. Use -r = 1- at the beginning, and 
	and output resulting approximation(after N steps).
	----------------------------------------
	 *** INPUT FORMAT:
	   * First line will contain and integer -T- that will represent the number of test-cases. Next -T- lines will contain test-cases 
	themselves, each containing the value -X- for which the square root should be calculated and -N- the number of calculations steps.
	----------------------------------------
	 *** OUTPUT FORMAT: 
	   * The output should contain the calculated approximations for each case, separated by space. 
	----------------------------------------
	 *** SAMPLE INPUT: 
	   3
	   150 0
	   5 1
	   10 3
	----------------------------------------
	 *** SAMPLE OUTPUT: 
	   1 3 3.196 
	----------------------------------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		// Creating a Scanner object:
		Scanner scanner = new Scanner(System.in);
		
		// Taking the number of test-cases from input:
		int testCases = scanner.nextInt();
		// Moving the cursor to the next line:
		scanner.nextLine();
		
		// Iterating through every given test-case and printing the result using the created method:
		for(int i = 1; i <= testCases; i++) {
			// Reading the value and the number of steps from input:
			int value = scanner.nextInt();
			int steps = scanner.nextInt();
			
			approximateSqrtInGivenSteps(value, steps);
		}
		
		// Closing the scanner:
		scanner.close();
	}

	// Method to approximate the sqrt of a given value, in a given number of steps:
	public static void approximateSqrtInGivenSteps(int value, int steps) {
		//Setting the initial approximation of root equaled with 1:
		double root = 1;
		
		// If the given steps equals 0 than we print the -root- as int and we end the method using -return- keyword:
		if(steps == 0) {
			System.out.println((int) root);
			return;
		} else {
			//Else. we iterate through every given step and approximate the root for given value as follows:
			for(int i = 1; i <= steps; i++) {
				double d = value / root;
				root = (root + d) / 2;
			}
		}
		
		// Once iteration are finished, we return the resulted approximation of root as in given SAMPLE OUTPUT:
		if(String.valueOf(root).endsWith("0")) {
			System.out.print((int) root + " ");
		} else {
			System.out.printf("%3.7f ", root);
		}
		
	}
}
