package org.util.numberconverter;

import java.util.Scanner;

public class NumberConverterLauncher {
	
	public static void main(String[] args) {
		NumberToWordsConverter numberToWordsConverter = new NumberToWordsConverter();
		
		try(Scanner scanner = new Scanner(System.in);) {
			System.out.println("Choose a number to convert into corresponding words...");
			long number = scanner.nextLong();
			
			System.out.println(numberToWordsConverter.printNumberInWords(number));
		} catch (IllegalArgumentException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
}
