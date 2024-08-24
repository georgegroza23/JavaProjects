package com.george.codeAbbey;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciSequenceProgram {
	/*** A Fibonacci Sequence is generated as following: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, where first values are 0 and 1 and the next value 
	will always be the sum of the previous two numbers like: 3rd value = 3rd value - 1 + 3rd value - 2. So if our first values are 0 and 1 then 
	the next value will be 0 + 1 = 1 and so we now have sequence 0, 1, 1. If we want to continue and find the next value in the sequence we 
	continue to sum the previous to values which now are 1 and 1 and so the next value will be 2. 
	-------------------------------------------
	*** TASK: 
	  * You will be given several Fibonacci numbers. The task is to tell their indices in the sequence. For example, if the sequence is 
	0 1 1 2 3 5 8 13 21 34 55 and the fibonacci number that was given is @34, than the answer should be @9 as the sequence start from first @1 
	and the index of @34 is @9. 
	-------------------------------------------
	*** INPUT FORMAT: 
	  * First line will contain an integer @N that represents the amount of fibonacci numbers that will be given to you. The next @N lines will 
	contain the fibonacci numbers itselfs, each on new line. 
	@Note: Values could be of hundred or more digits long.
	-------------------------------------------
	*** OUTPUT FORMAT: 
	  * The output should contain their indices in the sequence, on a single line separated by space. 
	-------------------------------------------
	*** SAMPLE INPUT: 
	  5 
	  610
	  34
	  0
	  1346269
	  10946
	-------------------------------------------
	*** SAMPLE OUTPUT: 
	  15 9 0 31 21
	----------------------------------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= testCases; i++) {
			String fiboNumber = scanner.nextLine();
			
			System.out.print(getIndexOfFiboNumber(fiboNumber) + " ");
		}
		
		scanner.close();
	}

	/** Method to get the index of a fibonacci number: */
	public static int getIndexOfFiboNumber(String fibo) {
		/** Creating @count variable to keep track of the third number index:*/
		int count = 0;
		
		/** Converting the given number in string format into @BigInteger number:  */
		BigInteger fibonacci = new BigInteger(fibo);
		
		/** Checking if the given number is a negative number and if it is return zero: */
		if(fibonacci.compareTo(BigInteger.ZERO) == -1) {
			return 0;
		}
		
		/** Initializing the first to numbers in the sequence - @n1 and @n2 - witn 0 and 1: */
		BigInteger n1 = BigInteger.ZERO;
		BigInteger n2 = BigInteger.ONE;
		
		/** Initializing the 3rd number in the sequence, @n3, also with 0; */
		BigInteger n3 = BigInteger.ZERO;
		
		/** For-loop to iterate until @n3 equals @fibonacci: */
		for(; n3.compareTo(fibonacci) != 0; n3 = n2.add(n1)) {
			n1 = n2;
			n2 = n3;
			count++;
		}
		
		/** Return @count which represents the index of the given number: */
		return count;
	}
	
}
