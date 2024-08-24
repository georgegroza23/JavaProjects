package com.george.codeAbbey;

import java.util.Scanner;

public class LinearCongruentialGenerator {
	/*** TASK: 
	   * Use the following formula @Xnext = (A * @Xcurrent + C) % M to get the value of @Nth member of the sequence. 
	------------------------
	*** INPUT DATA: 
	  * The first line will contain an integer @n that represents the number of test-cases. The next @n lines will contain 5 integers 
	separarted by space, in the following form: A C M Xcurrent N, where A, C and M are as in the above formula and @N is the number of a 
	member that we should calculate. 
	------------------------
	**** OUTPUT DATA:
	   * The output should contain the @Nth member's value for each test-case, separated by space. 
	------------------------
	*** INPUT SAMPLE: 
	  2
	  A		C	 M	  Xcurrent 	 N 
	  3		7	 12	  1			 2
	  2		3	 15	  8			 10
	-------------------------
	*** OUTPUT SAMPLE: 
	  1 11
	---------------------------------------------------------------------------------------------------------------------------------------*/
	/** @MAIN */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		
		for(int i = 1; i <= testCases; i++) {
			int A = scanner.nextInt();
			int C = scanner.nextInt();
			int M = scanner.nextInt();
			int Xcurrent = scanner.nextInt();
			int N = scanner.nextInt();
			
			System.out.print(getNthMemberValue(A, C, M, Xcurrent, N) + " ");
		}
		
		scanner.close();
	}

	/** Recursive method @getNthMemberValue(int A, int C, int M, int currentValue, int N): */
	public static int getNthMemberValue(int A, int C, int M, int currentValue, int member) {
		// BASE CASE: 
		if(member < 1) {
			return currentValue;
		}
		
		currentValue = (A * currentValue + C) % M;
		member--;
		
		return getNthMemberValue(A, C, M, currentValue, member);
	}
}
