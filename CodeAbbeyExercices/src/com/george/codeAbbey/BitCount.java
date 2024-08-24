package com.george.codeAbbey;

import java.util.Scanner;


@SuppressWarnings("unused")
public class BitCount {
	/*** TASK: 
	   * Write a program wich counts the number of non-zero bits in a given value. It will be used 32 bit integer values so there should be 
	from 0  to 32 non-zero bits. 
	----------------------------------
	*** INPUT DATA: 
	  * There will be two lines where first line will contain an integer, @n, that represents the number of values to process and the next 
	line will contain @n values separated by space. 
	----------------------------------
	*** OUTPUT DATA: 
	  * The output should contain the number of set bits for each value, separated by space. 
	----------------------------------
	*** INPUT SAMPLE: 
	  3
	  1 100 -1
	----------------------------------
	*** OUTPUT SAMPLE: 
	  1 3 32 
	---------------------------------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		
		for(int i = 1; i <= testCases; i++) {
			int numberOfBits = countSetBits(scanner.nextInt());
			
			System.out.print(numberOfBits + " ");
		}
		
		scanner.close();
	}

	public static int countSetBits(int decimal) {
		int count  = 0;
		
		if(decimal < 0) {
			// Kernighan's Algorithm
			while(decimal < 0) {
				decimal = decimal & (decimal - 1);
				count++;
			} 
		} else {
			while(decimal > 0) {
				decimal = decimal & (decimal - 1);
				count++;
			}
		}
		
		return count;
	}
	
}
