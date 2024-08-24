package com.george.codeAbbey;

import java.util.*;

public class SortWithIndexesProgram {
	/*** TASK: 
	   * You are given an array of numbers. It should be sorted first(in strictly increasing order) and then for each value its initial 
	index should be printed(indexes start from 1). 
	For example, suppose we have an array: 50 98 17 79 which after sorting becomes 17 50 79 98. Now:
	17 was at 3-rd place initially;
	50 was at 1-st place initially;
	79 was at 4-th place initially;
	98 was at 2-nd place initially.
	So we print: 3 1 4 2.
	--------------------------------
	 *** INPUT FORMAT:
	   * There will be two lines where first line will contain an integer -N- representing the length of the array and the second line will 
	contain -N- integers separated by space that represents the values of the array. 
	--------------------------------
	 *** OUTPUT FORMAT:
	   * The output should contain the initial indexes of the array members after they were reorder by sorting.
	--------------------------------
	 *** SAMPLE INPUT: 
	   4
	   50 98 17 79
	--------------------------------
	 *** SAMPLE OUTPUT: 
	   3 1 4 2 
	----------------------------------------------------------------------------------------------------------------------------------------*/
	
	public static void main(String[] args) {
		// Creating a Scanner object:
		Scanner scanner = new Scanner(System.in);
		
		// Taking the length of the array from stdin:
		int length = scanner.nextInt();
		
		//Moving the cursor to the next line:
		scanner.nextLine();
		
		Integer[] ints = new Integer[length];
		
		// Populating the created -ints[]- array with integers from stdin:
		for(int i = 0; i < length; i++) {
			ints[i] = scanner.nextInt();
		}
		
		// Printing the result:
		sortAndPrintInitIndexes(ints);
		
		// Closing the scanner:
		scanner.close();
	}
	
	public static void sortAndPrintInitIndexes(Integer[] array) {
		/* Creating a map implemented by TreeMap class to insert the elements from the given array with their indexes in natural 
		sorted order.*/
		Map<Integer, Integer> sortedArray = new TreeMap<>();
		
		/** Iterating through every element and add it into the created TreeMap, with its -index + 1- as indexes in the array starts from 
		zero and we need to start from 1: */
		for(int i = 0; i < array.length; i++) {
			sortedArray.put(array[i], i + 1);
		}
		
		// Iterating through every entry of the map and print the value of the keys as in SAMPLE OUTPUT:
		for(Map.Entry<Integer, Integer> entry : sortedArray.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}
}
