package com.george.codeAbbey;

import java.util.Arrays;
import java.util.Scanner;

public class SmoothingTheWeatherProgram {
	/*** Little Merlin wants to become a meteorologist. He measures the temperature of the air each hours so that after several days he has 
	a long sequence of values. However, his instruments are not ideal so the measurements are not exact - they randomly jump up and down by 
	several degrees from the real value. Observing this, Merlin decided to make his data more smooth. To achieve this he only needs every 
	value to be substituted by the average of it and its two neighbours. 
	For example, if we have a sequence of 5 value like 3 5 6 4 5, then: 
	- the second value @5 will be substituted by the result of 3 + 5 + 6 / 3;
	- the third value @6 will be substituted by the result of 5 + 6 + 4 / 3; 
	- the fourth value @4 will be substituted by the result of 6 + 4 + 5 / 3; 
	- By agreement, the first and last values will remain unchanged. 
	---------------------------------------
	*** TASK: 
	  * You have to write the program which helps Little Merlin in this whimsical algorithm of digital signal processing. 
	---------------------------------------
	*** INPUT DATA: 
	  * First line will contain an integer @N that represents the length of the sequence. The next following line will contain @N float 
	numbers separated by space which represent the sequence itself. 
	--------------------------------------- 
	*** OUTPUT DATA: 
	  * The output should contain the processed sequence. All values should be calculated to precission 1e-7(10 ^ -7). 
	---------------------------------------
	*** SAMPLE INPUT: 
	  7
	  32.6 31.2 35.2 37.4 44.9 42.1 44.1 
	---------------------------------------
	*** SAMPLE OUTPUT: 
	  32.6 33 34.6 39.1666666667 41.4666666667 43.7 44.1
	----------------------------------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sequenceLength = scanner.nextInt();
		
		/** Main sequence:*/
		double[] mainSequence = new double[sequenceLength];
		
		/** Populating @mainSequence array with data from input: */
		for(int i = 0; i < sequenceLength; i++) {
			double data = scanner.nextDouble();
			mainSequence[i] = data;
		}

		scanner.close();
		
		/** Smoothing the sequence: */
		double[] smoothedSequence = subtituteSequenceValues(mainSequence);
		
		/** Printing the new data stored in @smoothedSequence: */
		Arrays.stream(smoothedSequence).forEach(d -> System.out.print(d + " "));
	}

	/** @Method to substitute values in a given sequence: */
	public static double[] subtituteSequenceValues(double[] sequence) {
		/** Getting the length of the given @sequence:*/
		int length = sequence.length;
		
		/** Creatting @substitutedValues array of type double to store the susbtituted values from @sequence:*/
		double[] substitutedValues = new double[length];
		
		/** We keep the first and last values from @sequence as they will remain unchanged:*/
		substitutedValues[0] = sequence[0];
		substitutedValues[length - 1] = sequence[length - 1];
		
		/** Iterating through remaining elements in @sequence and apply the algorithm for smoothing the data:*/
		for(int i = 1; i < sequence.length - 1; i++) {
			substitutedValues[i] = (sequence[i - 1] + sequence[i] + sequence[i + 1]) / 3;
		}
		
		
		return substitutedValues;
	}
}
