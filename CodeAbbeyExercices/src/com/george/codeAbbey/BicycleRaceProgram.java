package com.george.codeAbbey;

import java.util.Scanner;

public class BicycleRaceProgram {
	/*** Two bicyclist start moving from different cities heading to meet eachother somewhere in the middle. The road is laid in straight line 
	between two cities. 
	-------------------------------------------
	*** TASK: 
	  * You will be given the distance, @s(in km), between two cities and speed values for two bicyclist, @A and @B. The task is to find their 
	meeting point(its distance from the first of cities).  
	-------------------------------------------
	*** INPUT DATA: 
	  * The first line will contain an integer @N that represents the number of test-cases. The next @N lines will have 3 values separated 
	by space, in the form of @s @A @B.
	-------------------------------------------
	*** OUTPUT DATA: 
	  * The output should contain the distance between first city and rendezvous point(i.e. distance traveled by the first cyclist before they
	 meet), separated with spaces. 
	-------------------------------------------
	*** SAMPLE INPUT: 
	  2 
	  10 1 1
	  20 1 2
	  50 15 18 
	-------------------------------------------
	*** SAMPLE OUTPUT: 
	  5 6.66666667 22.72727272
    ----------------------------------------------------------------------------------------------------------------------------------------*/

	/** @MAIN METHOD: */
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		int testCases = scanner.nextInt();
		
		for(int i = 1; i <= testCases; i++) {
			double s = scanner.nextDouble();
			double A = scanner.nextDouble();
			double B = scanner.nextDouble();
			
			System.out.print(findMeetingPoint(s, A, B) + " ");
		}
		
		scanner.close();
	}

	/** @METHOD to find the point where both bycicle will meet: */
	public static double findMeetingPoint(double s, double a, double b) {
		/** Calculating the estimated time arrival:*/
		double eta = s / (a + b);
		
		/** The meetting point will be calclutated by multiplying @eta with the speed rate of first cyclist - @a: */
		return  eta * a;
	}
}
