package com.george.codeAbbey;

import java.util.Scanner;

public class BubbleSortProgram {
	/*** Sorting is reordering according to some simple rules based on comparison. Suppose we are given an array: a = [3, 1, 4, 5, 9, 2, 6] and we want 
	its elements to be reordered in non-decreasing order - if one element is placed earlier(to the left) than the other - we can be sure the first 
	element is either less or equal to second. Mathematically speaking, for any indexes i and j if i < j than a[i] <= a[j]. 
	--------------------------------------------
	  ** BUBBLE SORT is one of the simplest method to perfom such reordering and it can be implemented as follows:
	   - Take a -pass- through array, examining all pairs of adjacent elements;
	   - If for any pair with indexes -i- and -i + 1- the condition -a[i] <= a[i + 1]- does not hold, -swap- these two elements;
	   - Repeat such passes through array until the new pass don't do any swaps. 
	--------------------------------------------
	 *** TASK: 
	   * Implement the described version of bubble sort. Count the number of passes and swaps made before the given array to become ordered. 
	--------------------------------------------
	 *** INPUT FORMAT:
	   * There will be two lines: first line will contain an integer -N- that represents the array size and the second line will contain -N- integeres 
	separated by space that represents the array itself. 
	--------------------------------------------
	 *** OUTPUT FORMAT:
	   * The output should contain two values separated by space: the left value represents the number of passes and the right value the number of 
	swaps made till the array became ordered. 
	--------------------------------------------
	 *** SAMPLE INPUT:
	   8
	   3 1 4 1 5 9 2 6
	--------------------------------------------
	 *** SAMPLE OUTPUT: 
	   5(number of passes) 8(number of swaps) 
	---------------------------------------------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int arrayLength = scanner.nextInt();
		scanner.nextLine();
		
		int[] array = new int[arrayLength];
		
		for(int i = 0; i < arrayLength; i++) {
			array[i] = scanner.nextInt();
		}
		
		sortArrayWithBubbleSort(array);
		
		scanner.close();
	}
	
	public static void sortArrayWithBubbleSort(int[] array) {
		int numberOfPasses = 0;
		int numberOfSwaps = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] >= array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					numberOfSwaps++;
				} else {
					numberOfPasses = i;
				}
			}
		}
		
		System.out.println(numberOfPasses + " " + numberOfSwaps);
	}
}
