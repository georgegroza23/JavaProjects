package com.george.codeAbbey;

import java.util.Scanner;

public class TriangleArea {
	/*** TASK:
	   * Write a program wich uses @x and @y coordinates of triangle vertices to calculate the area of a triangle. 
	---------------------------------
	*** INPUT DATA: 
	  * First line will contain an integer @n that represents the number of triangle to process. The next @n lines will contain 
	six space-separated doubles in order x1 y1 x2 y2 x3 y3, describing three vertices of a triangle.
	---------------------------------
	*** OUTPUT DATA:
	  * The output should contain the areas of triangle separated by space.
	---------------------------------
	*** INPUT SAMPLE:
	  3
	  x1  	y1  	x2  	y2  	x3     y3
	  1   	3   	9   	5   	6      0   			-> First Triangle
	  1   	0   	0   	1   	10000  10000		-> Second Triangle
	  7886 	5954 	9953 	2425 	6250   2108			-> Third Triangle
	--------------------------------
	*** OUTPUT SAMPLE:
	  17 999.5 6861563 
	--------------------------------
	*** FORMULA: 
	  * For solving the problem I will use the following approach:
	x1 y1 	   x1 y1	 
	x2 y2	=  x2 y2  = ((x1 * y2) + (x2 * y3) + (x3 * y1) - (x1 * y3) - (x3 * y2) - (x2 * y1))	/ 2
	x3 y3      x3 y3  = ((1 * 5) + (9 * 0) + (6 * 3) - (1 * 0) - (6 * 5) - (9 * 3)) / 2
	           x1 y1  = (5 + 0 + 18 - 0 - 30 - 27) / 2
	                  = (-34) / 2
	                  = Math.abs((-34) / 2)
	                  = 17. 
	----------------------------------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTriangles = scanner.nextInt();
		
		for(int i = 1; i <= numberOfTriangles; i++) {
			double x1 = scanner.nextDouble(), y1 = scanner.nextDouble(); // Vertex A
			double x2 = scanner.nextDouble(), y2 = scanner.nextDouble(); // Vertex B
			double x3 = scanner.nextDouble(), y3 = scanner.nextDouble(); // Vertex C
			
			double result = calculateAreaOfTriangle(x1, y1, x2, y2, x3, y3);
			
			System.out.print(result + " ");
		}
		
		scanner.close();
	}

	public static double calculateAreaOfTriangle(double... vertices) {
		double result = 0.0;
		
		/** Extracting the coordinates for each vertex of a triangle: */
		double x1 = vertices[0], y1 = vertices[1]; // Vertex A
		double x2 = vertices[2], y2 = vertices[3]; // Vertex B
		double x3 = vertices[4], y3 = vertices[5]; // Vertex C
		
		/** Calculating the result using the approach described at FORMULA descriprion:*/
		result = ((x1 * y2) + (x2 * y3) + (x3 * y1) - (x1 * y3) - (x3 * y2) - (x2 * y1)) / 2;
		
		/** Using @Math.abs() method to always return a positive result:*/
		return Math.abs(result);
	}
}
