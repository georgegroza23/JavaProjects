package com.george.codeAbbey;

import java.util.Scanner;

public class PythagoreanTheoremProgram {
	/*** A triangle is called right when one of its three angles is right angle(equal to 90 degree). For this type of triangle, phytagorean
	theorem works. The theorem states that the length of hypotenuse is determined by the length of legs - where legs of such triangle are 
	represented by the sides adjacent to the right angle - with simple formula: c^2 = a^2 + b^2.
	-------------------------------------------------
	*** TASK: 
	  * Write a program which could determine whether a traingle is right, acute or obtuze:
	  - for acute triangle its longest side is shorter than hypotenuse should be;
	  - for obtuze triangle its longest side is longer than hypotenuse should be.
	-------------------------------------------------
	*** INPUT FORMAT: 
	  * First line contain an integer @T that represents the number of test-cases. Next @T lines contain 3 space separated integers that 
	represent the legs of a triangle where the bigger integer will represent @c leg. For simplicity, the largest value will always be the 
	last of the 3 integers.
	-------------------------------------------------
	*** OUTPUT FORMAT: 
	  * The output should have one of the letter; @R - right, @A - acute or @O - obtuze for each of triangles. Letters should be separated 
	by space. 
	-------------------------------------------------
	*** SAMPLE INPUT: 
	  3 
	  6 8 9
	  9 12 15
	  16 12 22
	-------------------------------------------------
	*** SAMPLE OUPUT: 
	  A R O
	----------------------------------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= testCases; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			
			System.out.print(getTypeOfTriangle(a, b, c) + " ");
		}
		
		scanner.close();
	}

	public static String getTypeOfTriangle(int a, int b, int c) {
		// Checking if any of the given integers are negative:
		if(a < 0 || b < 0 || c < 0) {
			System.out.println("The integers in the argument list cannot be negative!");
		}
		
		/** Creating a variable @type to store the triangle type:*/
		String type = "";
		
		// Calculating the square for every given integer:
		a = a * a;
		b = b * b;
		c = c * c;
		
		if(c == a + b) {
			type = "R";
		} else if(c < a + b) {
			type =  "A";
		} else {
			type = "O";
		}
		
		return type;
	}
}
