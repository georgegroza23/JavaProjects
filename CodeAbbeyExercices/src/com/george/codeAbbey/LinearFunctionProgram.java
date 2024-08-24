package com.george.codeAbbey;

import java.util.Scanner;

public class LinearFunctionProgram {

	/* A linear function is defined by the folowing ecuation: 
	 y = a * x + b - where a and b are some constants.
	 -
	 * The task is to determine a and b by two points belonging to the fuction. 
	 -
	 INPUT FORMAT
	 The first line will contain the number of test cases. The following lines will contain the test cases themselves. Each test-case will contain 
	 4 integers(x1, y1, x2, y2). See the sample input for a better understanding.
	 -
	 OUTPUT FORMAT
	 The output should be integers enclosed in paranthesis separated by space. See the sample output for a better understanding.
	 -
	 SAMPLE INPUT
	 2	- number of test cases;
	 0 0 1 1 - first test-case that follows the pattern (x1 y1 x2 y2) 
	 1 0 0 1 - second test-case that follows the pattern (x1 y1 x2 y2) 
	 -
	 SAMPLE OUTPUT
	 (1 0)-the output for the first test-case (-1 1)-the output for the second test-case 
	 */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		int result[] = new int[2];
		
		while(testCases != 0) {
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			
			result = findingAandB(x1, y1, x2, y2);
			System.out.print("(" + result[0] + " " + result[1] + ")");
	
			testCases--;
		}
		
		
		
		scanner.close();
	}

	public static int[] findingAandB(int x1, int y1, int x2, int y2) {
		int[] aAndb = new int[2];
		
		/* Linear function formula -> y = a * x + b. 
		 
		 FINDING (a)
		 * To find (a), you need two points. The first point is represented by first two integers (x1 y1) the second point is represented by the next
		 two integers (x2 y2).
		 (x1 y1) - (1 2) -> first point with 1 and 2 as given values for x1 and y1.
		 (x2 y2) - (2 4) -> second point with 2 and 4 as given values for x2 and y2.
		 
		 * The formula for finding (a) is: a = y2 - y1 / x2 - x1. 
		 * Replacing the x and y with the given values: a = 4 - 2 / 2 - 1 
		 												a = 2 / 1 
		 												a = 2.*/ 
		int a = (y2 - y1) / (x2 - x1);
		aAndb[0] = a;
		
		/* FINDING (b)
		 * To find (b), you need to choose from one of the two points, (x1 y1) or (x2 y2). It doesn't matter wich point you choose as the result will be 
		 the same. 
		 * After that, you need to replace x and y in the linear function formula with the integers that represents x and y from the point you chosed. 
		 * After replacing x and y with the coresponding integers you will have everything you need in the resulted ecuation to find (b). 
		 - Resulted ecuation after replacing x and y with the integers from second point (x2 y2) and (a) with 2(the result from previous example): 
		 y = a * x + b becomes 4 = 2 * 2 + b 
		 					   4 = 4 + b
		 					   4 - 4 = b
		 					   0 = b or b = 0.
		 So (a, b ) for (x1 y1) or (x2 y2) are (2 0) */
		int b = y1 - (a * x1);
		aAndb[1] = b;
		
		return aAndb;
	}
	
}
