package com.george.codeAbbey;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class SavingsCalculatorProgram <T extends Comparable<T>> {
	/*** Joel wants to buy a boat which cost $10000. However, he currently has only $1000. One of the ways to increase money is to put them 
	into bank account and wait. For example, if account is increased by 8% each year:
	year	money
	0		1000
	1		1080
	2		1166.4
	3 		1259.71
	4		1360.40
	...............
	29		9316.82
	30		10062.16
	then Joel will enough money in 30 years.
	------------------------------------------------
	*** TASK: 
	  * Help Joel to calculate how many years he needs to wait depending on given starting amount of money @S, required sum @R and bank 
	interest rate @P. 
	------------------------------------------------
	*** INPUT DATA: 
	  * First line will contain an integer @N representing the number of test-cases. The next @N lines will contain three numbers separated 
	 by space as @S @R @P. 
	------------------------------------------------
	*** OUTPUT DATA: 
	  * Should contain numbers of years to wait for each case, separated by space. 
	------------------------------------------------
	*** SAMPLE INPUT: 
	  2
	  @S  	 @R	 	 @P
	  1000 	 10000 	 8
	  50 	 100	 25 
	------------------------------------------------
	*** SAMPLE OUTPUT: 
	  30 4 
	---------------------------------------------------------------------------------------------------------------------------------------*/
	
	/** @MAIN METHOD: */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		
		for(int i = 1; i <= testCases; i++) {
			double s = scanner.nextDouble();
			double r = scanner.nextDouble();
			int p = scanner.nextInt();
			
			System.out.print(calculateYearsToSave(s, r, p) + " ");
		}
		
		scanner.close();
		
	}

	/** @METHOD to calculate the necessary years to save for reaching the needed money: */
	public static int calculateYearsToSave(double actualMoney, double neededMoney, int interestRate) {
		int yearsPassed  = 0;
		
		while(actualMoney < neededMoney) {
			actualMoney += actualMoney * interestRate / 100;
			
			/** Rounding down each result by 2 decimal places using @BigDecimal.class */
			actualMoney = BigDecimal.valueOf(actualMoney).setScale(2,RoundingMode.DOWN).doubleValue();
			
			yearsPassed++;
		}
		
		return yearsPassed;
	}
}
