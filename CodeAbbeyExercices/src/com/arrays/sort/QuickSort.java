package com.arrays.sort;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {14, 12, 15, 22, 29, 44, 45, 35};
		
		quickSort(arr);
		
		Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
	}
	
	private static void swap(int[]arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	private static int getPivotIndex(int start, int end) {
		int pivotIndex = new Random().nextInt(end - start + 1) + start;
		
		return pivotIndex;
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivotIndex = getPivotIndex(start, end);
		int pivot = arr[pivotIndex];
		swap(arr, pivotIndex, end);
		
		int i = start - 1;
		for(int j = start; j < end; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i + 1, end);
		
		return i + 1;
	}
	
	private static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int partitionPoint = partition(arr, start, end);
			quickSort(arr, start, partitionPoint - 1);
			quickSort(arr, partitionPoint + 1, end);
		}
	}
	
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length -1);
	}
}
