package org.util.numberconverter;

import java.util.HashMap;
import java.util.Map;

public class NumberToWordsConverter {
	// FIELDS:
    private static final long MIN_RANGE = 0L;
    private static final long MAX_RANGE = 999_999_999_999L;
    
    private Map<Integer, String> zeroToNine;
    private Map<Integer, String> tenToNineteen;
    private Map<Integer, String> tenMultiples;
    private Map<Integer, String> numberMagnitude;
    
	// CONSTRUCTORS:
	public NumberToWordsConverter() {
	    zeroToNine = new HashMap<>();
	    tenToNineteen = new HashMap<>();
	    tenMultiples = new HashMap<>();
	    numberMagnitude = new HashMap<>();
	    
	    populateZeroToNineMap();
	    populateTenToNineteenMap();
	    populateTenMultiplesMap();
	    populateNumberMagnitudeMap();
	}
	
	/* Populating zeroToNine map: */
	private void populateZeroToNineMap() {
        zeroToNine.put(0, "");
        zeroToNine.put(1, "one");
        zeroToNine.put(2, "two");
        zeroToNine.put(3, "three");
        zeroToNine.put(4, "four");
        zeroToNine.put(5, "five");
        zeroToNine.put(6, "six");
        zeroToNine.put(7, "seven");
        zeroToNine.put(8, "eight");
        zeroToNine.put(9, "nine");
	}
	
	/* Populating tenToNineteen map: */
	private void populateTenToNineteenMap() {
	    tenToNineteen.put(10, "ten");
	    tenToNineteen.put(11, "eleven");
	    tenToNineteen.put(12, "twelve");
	    tenToNineteen.put(13, "thirteen");
	    tenToNineteen.put(14, "fourteen");
	    tenToNineteen.put(15, "fifteen");
	    tenToNineteen.put(16, "sixteen");
	    tenToNineteen.put(17, "seventeen");
	    tenToNineteen.put(18, "eighteen");
	    tenToNineteen.put(19, "nineteen");
	}
	
	/* Populating tenMultiples map: */
	private void populateTenMultiplesMap() {
	    tenMultiples.put(2, "twenty");
	    tenMultiples.put(3, "thirty");
	    tenMultiples.put(4, "forty");
	    tenMultiples.put(5, "fifty");
	    tenMultiples.put(6, "sixty");
	    tenMultiples.put(7, "seventy");
	    tenMultiples.put(8, "eighty");
	    tenMultiples.put(9, "ninety");
	}
	
	/* Populate numberLenght map: */
	private void populateNumberMagnitudeMap() {
	    numberMagnitude.put(100, "hundred");
	    numberMagnitude.put(1_000, "thousand");
	    numberMagnitude.put(1_000_000, "million");
	    numberMagnitude.put(1_000_000_000, "billion");
	}
	
	/**
	 * Converts a given long number into words and prints it. 
	 * 
	 * @param number long number that has to be converted into words; 
	 * @return the passed number into corresponding words;
	 * @throws IllegalArgumentException if the passed number is a negative number or is greater than 999_999_999_999.*/
	public String printNumberInWords(long number) throws IllegalArgumentException {
	    if (number == 0) {
	        return "zero";
	    }
	    
	    return this.convertNumberToWord(number);
	}
	
	private String convertNumberToWord(long number) throws IllegalArgumentException {
	    if (number < MIN_RANGE || number > MAX_RANGE) {
	        throw new IllegalArgumentException("Number out of range exception! Number must not be less than 0 or greater than 999_999_999_999");
	    }
	    
	    int numberLength = String.valueOf(number).length();
	    if (numberLength < 4) {
	        return convertThreeDigitNumberToWord(number);
	    }
	    
	    int magnitude = (numberLength % 3 == 0) ? (int)(Math.pow(10, numberLength - 3)) 
	                                             : (int)(Math.pow(10, numberLength - (numberLength % 3)));
	    long digitsToConvert = number / magnitude;
	    long remainingDigits = number % magnitude;
	    String digitsConvertedToWord = (convertThreeDigitNumberToWord(digitsToConvert) + " " + numberMagnitude.get(magnitude)).trim();
	    
	    return (digitsConvertedToWord + " " + convertNumberToWord(remainingDigits)).trim();
	}
	
	private String convertThreeDigitNumberToWord(long number) {
	    String numberToString = String.valueOf(number);
	    int numberLength = numberToString.length();
	    
	    if (numberLength < 3) {
	        return convertTwoDigitNumberToWord((int) number);
	    }
	    
	    int magnitude = 100;
	    int firstDigit = Integer.valueOf(numberToString.substring(0, 1));
	    int lastDigits = Integer.valueOf(numberToString.substring(1, 3));
	    
	    return (zeroToNine.get(firstDigit) + " " + numberMagnitude.get(magnitude) + " " + convertTwoDigitNumberToWord(lastDigits)).trim();
	}
	
	private String convertTwoDigitNumberToWord(long number) {
	    String numberToString = String.valueOf(number);
	    
	    if (numberToString.length() < 2) {
	        return convertOneDigitNumberToWord((int) number);
	    }
	    
	    int firstDigit = Integer.valueOf(numberToString.substring(0, 1));
	    int secondDigit = Integer.valueOf(numberToString.substring(1, 2));
	    
	    String numberConverted =  ((number >= 10) && (number <= 19)) ? tenToNineteen.get((int) number)
	                                                                 : tenMultiples.get(firstDigit) + "-" + zeroToNine.get(secondDigit);
	    
	    char numberConvertedLastChar = numberConverted.charAt(numberConverted.length() - 1);                                                    
	    if (numberConvertedLastChar == '-') {
	        numberConverted = numberConverted.replace(numberConvertedLastChar, ' ');
	    }
	    
	    return numberConverted.trim();
	}
	
	private String convertOneDigitNumberToWord(long number) {
	    return zeroToNine.get((int) number);
	}
}
