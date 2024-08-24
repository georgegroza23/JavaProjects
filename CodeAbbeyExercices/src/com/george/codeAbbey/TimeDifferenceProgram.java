package com.george.codeAbbey;

import java.util.Scanner;

public class TimeDifferenceProgram {
	/* In this task there are given several pairs of timestamps. We suppose that both dates in the pairs are always in the same month, so
	only number of day will be given. Calculate the difference between timestamps in each pair.
	
	* INPUT FORMAT
	- The first line contains number of test-cases. The next lines will contain the test-cases themselves. 
	Each test-case contains 8 numbers - 4 numbers for each timestamp: day1 hour1 min1 sec1 day2 hour2 min2 sec2. 
	
	* OUTPUT FORMAT
	- For each test case the output must be as follows: (day hour minutes seconds)
	
	* SAMPLE/EXAMPLE 
	- Input Data
    - Number of test-cases:
	  3
	- First 4 numbers represent the first timestamp and the next 4 numbers represent the second timestamp:
	  1 0 0 0 2 3 4 5 
	  5 3 23 22 24 4 20 45 
	  8 4 6 47 9 11 51 13
	  
	* Output Data
	- (1 3 4 5) (19 0 57 23) (1 7 44 26) -> In the paranthesis is the result of each test-case that represent the time difference between the
	two given timestamps. */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] timestamps = new int[8];
		
		int testCases = scanner.nextInt();
		
		scanner.nextLine();
		while(testCases != 0) {
			for(int i = 0; i < timestamps.length; i++) {
				timestamps[i] = scanner.nextInt();
			}
			
			String resultedDifference = calculateTimeDifference(timestamps);
			
			System.out.print("(" + resultedDifference + ") ");
			
			testCases--;
		}
		
		scanner.close();
	}

	public static String calculateTimeDifference(int[] timestamps) {
		String timeDifference = "";
		
		// Extracting the days, hours, minutes and seconds for first timestamp from timestamps[] array:
		int timestamp1_Days = timestamps[0];
		int timestamp1_Hours = timestamps[1];
		int timestamp1_Minutes = timestamps[2];
		int timestamp1_Seconds = timestamps[3];
		
		//Extracting the days, hours, minutes and seconds for second timestamp from timestamps[] array:
		int timestamp2_Days = timestamps[4];
		int timestamp2_Hours = timestamps[5];
		int timestamp2_Minutes = timestamps[6];
		int timestamp2_Seconds = timestamps[7];
		
		//Calculating the number of seconds in a minute, hour and day.
		int secondsInMinute = 60;
		int secondsInHour = secondsInMinute * 60;
		int secondsInDay = secondsInHour * 24;
		
		/*Converting the timestamp's days, hours and minutes into seconds and then add them to obtain a single integer that represent the total
		of seconds in that timestamp. */
		int totalSecondsInTimestamp1 = (secondsInDay * timestamp1_Days) + (secondsInHour * timestamp1_Hours) 
				+ (secondsInMinute * timestamp1_Minutes) + timestamp1_Seconds;
		
		int totalSecondsInTimestamp2 = (secondsInDay * timestamp2_Days) + (secondsInHour * timestamp2_Hours) 
				+ (secondsInMinute * timestamp2_Minutes) + timestamp2_Seconds;
		
		// Calculating the difference in seconds between the two timestamps.
		int differenceInSeconds = totalSecondsInTimestamp2 - totalSecondsInTimestamp1;
		
		/* CONVERTING THE DIFFERENCE IN SECONDS BACK INTO DAYS, HOURS AND MINUTES. */
		
		// Extracting the number of days and add them into String variable: 
		int numberOfDays = differenceInSeconds / secondsInDay;
		timeDifference += numberOfDays + " ";
		
		// Getting the remaining seconds:
		int remainingSeconds = differenceInSeconds % secondsInDay;
		
		// Extracting the number of hours and add them into String variable: 
		int numberOfHours = remainingSeconds / secondsInHour;
		timeDifference += numberOfHours + " ";
		
		// Updating the remainig seconds:
		remainingSeconds %= secondsInHour;
		
		// Extracting the number of minutes and add them into String variable:
		int numberOfMinutes = remainingSeconds / 60;
		timeDifference += numberOfMinutes + " ";
		
		//Updating the remaining seconds:
		remainingSeconds %= secondsInMinute;
		
		//Adding the remaining seconds into String variable:
		timeDifference += remainingSeconds;
		
		return timeDifference;
	}
}
