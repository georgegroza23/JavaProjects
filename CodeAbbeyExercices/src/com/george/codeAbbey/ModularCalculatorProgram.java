package com.george.codeAbbey;

import java.math.BigInteger;
import java.util.Scanner;

public class ModularCalculatorProgram {
	/*** This task provides practice for core property of remainder taking operation in arithmetic - persisting of the remainder over addition and 
	multiplication. This important property is often used for checking results of calculations in competitive programing, in calculation checksums 
	and escpecially for encryption. 
	----------------------------------
	*** INPUT FORMAT: 
	  * First line will contain the initial integer number. 
	  * The next following lines will contain describing operations in form of -sign value- where sign is either -+- or -*- and value is an integer. 
	  * Last line will be in the same form but with -%- as sign followed by an integer by wich the result should be divided to get the remainder. 
	----------------------------------
	*** OUTPUT FORMAT: 
	  * The output will consist of one integer that should be the result of all operations applied sequentially -starting with the initial number-, 
	divided by the last number from the last line. 
	----------------------------------
	*** SAMPLE INTPUT: 
	  5
	  + 3
	  * 7
	  + 10
	  * 2
	  * 3
	  + 1
	  % 11
	----------------------------------
	*** SAMPLE OUTPUT: 
	  1 
	----------------------------------
	*** OUTPUT EXPLAINED:
	  The output 1 was obtained as followed:
	  - we first add 5 with 3 to get the result 8;
	  - we multiply 8 by 7 and get the result 56;
	  - we add 56 with 10 and get the result 66;
	  - we multiply 66 by 2 and get the result 132;
	  - we multiply 132 by 3 and get the result 396;
	  - we add the resuslt with 1 and get 397.
	  - lastly, we devide the result 397 by 11 using modulo -%- operator and obtain the result and also the remainder 1 wich is our output. 
	  1 = ((((5 + 3) * 7) + 10) * 2 * 3 + 1) % 11  
	---------------------------------------------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		// Creating object of type Scanner:
		Scanner scanner = new Scanner(System.in);
		
		// Reading initial number from input:
		BigInteger initialNumber = scanner.nextBigInteger();
		// Moving the cursor to the next line:
		scanner.nextLine();
		
		BigInteger result  = null;
		while(scanner.hasNextLine()) {
			String symbol = scanner.next();
			BigInteger number = scanner.nextBigInteger();
			
			if(symbol.equals("*")) {
				result = initialNumber.multiply(number);
			} else if(symbol.equals("+")) {
				result = initialNumber.add(number);
			} else {
				result = initialNumber.mod(number);
			}
			
			initialNumber = result;
		
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			} else {
				break;
			}
		}
		
		System.out.println(result);
		
		// Closing Scanner:
		scanner.close();
	}
}
