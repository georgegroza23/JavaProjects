package com.arrays.sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		Integer[] ints = {25, 33, 44, 99, 81, 35, 22};
		String[] names = {"Bob", "Sam", "Dean", "Castiel", "Crowley", "John", "Zariel"};
		Double[] doubles = {0.23, .23, 000.0000, 25.32, 45.23, 89.0, 25363.2156, .25364};
		
		mergeSort(ints);
		mergeSort(names);
		mergeSort(doubles);
		
		Arrays.stream(ints).forEach(i -> System.out.print(i + " "));
		System.out.println();
		Arrays.stream(names).forEach(n -> System.out.print(n + " "));
		System.out.println();
		Arrays.stream(doubles).forEach(d -> System.out.print(d + " "));
	}
	
	public static <T extends Comparable<T>> void mergeSort(T[] inputArray) {
		int length = inputArray.length;
		
		// Base case:
		if(length <= 1) {
			return;
		}
		
		int midIndex = length / 2;
		T[] leftArray = Arrays.copyOfRange(inputArray, 0, midIndex);
		T[] rigthArray = Arrays.copyOfRange(inputArray, midIndex, length);
		
		mergeSort(leftArray);
		mergeSort(rigthArray);
		
		merge(inputArray, leftArray, rigthArray);
	}
	
	private static <T extends Comparable<T>> void merge(T[] merged, T[] leftArray, T[] rigthArray) {
		int leftSize = leftArray.length;
		int rigthSize = rigthArray.length;
		
		int leftIterator = 0, rigthIterartor = 0, mergedIterator = 0;
		while(leftIterator < leftSize && rigthIterartor < rigthSize) {
			if(leftArray[leftIterator].compareTo(rigthArray[rigthIterartor]) <= 0) {
				merged[mergedIterator] = leftArray[leftIterator];
				leftIterator++;
			} else {
				merged[mergedIterator] = rigthArray[rigthIterartor];
				rigthIterartor++;
			}
			mergedIterator++;
		}
		
		while(leftIterator < leftSize) {
			merged[mergedIterator] = leftArray[leftIterator];
			leftIterator++;
			mergedIterator++;
		}
		
		while(rigthIterartor < rigthSize) {
			merged[mergedIterator] = rigthArray[rigthIterartor];
			rigthIterartor++;
			mergedIterator++;
		}
	}
}
