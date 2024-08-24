package com.george.codeAbbey;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleInArrayProgram {
	/*** TASK: 
	   * Given an integer array, we are to iterate through all pairs of neighbor elements starting from beginning - and swap member of each 
	pair where first element is greater than second. For example, lets consider a small array of elements 1 4 3 2 6 5, marking wich pairs are 
	swapped and which are not: 
	(1 4) 3 2 6 5 - pass 
	1 (4 3) 2 6 5 - swap 
	1 3 (4 2) 6 5 - swap 
	1 3 2 (4 6) 5 - pass 
	1 3 2 4 (6 5) - swap
	1 3 2 4 5 6 - end 
	-------------------------------------
	*** INPUT FORMAT:
	  * There will be a single line that contains a sequence integers separated by space that represents the elements of an array. 
	-------------------------------------
	*** OUTPUT FORMAT:
	  * The output should contain two values; number of performed swaps and -checksum- of the array after processing separated by space. 
	-------------------------------------
	*** SAMPLE INPUT:
	  1 4 3 2 6 5
	-------------------------------------
	*** SAMPLE OUTPUT:
	  3 5242536 -> where 3 is the number of swaps and 5242536 is checksum of the array.
	-------------------------------------
	/*** CHECKSUM: 
	   * Checksums are small values calculated from big amount of data to check whether the data is consistent or it contains error. 
	   * We can calculate the checksum of next array; -a = {3, 1, 4, 1, 5, 9}- using the following steps:
	1. Choose some arbitratry number (primes are good) as seed like -113-;
	2. Choose some big number as the limit for checksum like -10.000.007-;
	3. Initialize -result- value to -0-;
	4. Initialize array index to the start of the array - the start of the array is a[0];
	5. Add the member pointed by -index(a[0])- to -result(0)-;
	6. Multiply -result- by -seed-;
	7. If the result is bigger than the -limit-, divide the  -result- by -limit- using modulo operator;
	8. Increment -index- to point to the next element of the array;
	9. If array is not exhausted repeat the steps starting from step 4.
	--------------------------------------
	*** EXAMPLE OF CALCULATING THE CHECKSUM:
	  a = {3, 1, 4, 1, 5, 9};
	  seed = 113;
	  limit = 10.000.007;
	  result = 0;
	  ----------------------
	  result = (result + a[0]) * seed = (0 + 3) * 113 = 339;
	 
	  result = (result + a[1]) * seed = (339 + 1) * 113 = 38420;
	  
	  result = (result + a[2]) * seed = (38420 + 4) * 113 = 4341912;
	  
	  result = (result + a[3]) * seed = (4341912 + 1) * 113 = 490636169 -> from here result will be bigger that the chosed -limit-;
	  result = result % limit = 490636169 % 10000007 = 635826;
	  
	  result = (result + a[4]) * 113 = (635826 + 5) * 113 = 71848903;
	  result = result % limit = 71848903 % 10000007 = 1848854;
	  
	  result = (result + a[5]) * 113 = (1848854 + 9) * 113 = 208921519;
	  result = result % limit = 208921519 % 10000007 = 8921379; -> CHECKSUM OF THE ARRAY. 
	----------------------------------------------------------------------------------------------------------------------------------------*/
	
	public static void main(String[] args) {
		// Creating a Scanner object:
		Scanner scanner = new Scanner(System.in);
		
		// Creating a List to store the elements from stdin:
		List<Integer> array = new ArrayList<Integer>(); 
		
		// Populating the List with numbers from stdin:
		while(scanner.hasNext()) {
			array.add(scanner.nextInt());
		}
		
		// Converting the List into Array:
		Integer[] convertedList = new Integer[array.size()];
		array.toArray(convertedList);
		
		// Printing the result as in OUTPUT SAMPLE:
		System.out.print(countPerformedSwaps(convertedList) + " " + calculateChecksum(convertedList));
		
		// Closing the scanner:
		scanner.close();
	}

	// 1. Method to count the performed swaps:
	public static int countPerformedSwaps(Integer[] array) {
		// Creating a variable count to store the number of swaps:
		int count = 0;
		
		// Iterating through every element of the array:
		for(int i = 0; i < array.length - 1; i++) {
			// Checking if the element of index -i- is greater the next element:
			if(array[i] > array[i + 1]) {
				// If the element at index -i- is greater than we do the swaping and increase the count:
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
				count++;
			}
		}
		
		// Return the total number of swapings made in the given array:
		return count;
	}
	
	// 2. Mehtod to calculate the checksum:
	public static String calculateChecksum(Integer[] array) {
		/** Creating -result-, -seed- and -limit- variables:*/
		String result = "0";
		int seed = 113;
		int limit = 10000007;
		
		// Iterating through the given array and applying the logic described at the beginning of the class:
		for(int i = 0; i < array.length; i++) {
			result = (Long.valueOf(result) + array[i]) * seed + "";
			if(Long.valueOf(result) > limit) {
				result = Long.valueOf(result) % limit + "";
			}
			
		}
		
		/** Returning the result that represents the -checksum-:*/
		return result;
	}
}
