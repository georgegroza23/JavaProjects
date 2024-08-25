package api.spaceage;

/**
 * Program to calculate the age of a person on different planets in our Solar system. 
 * The age has to be given in seconds.
 * The value for total days in one earth year used in this program is 365.25.*/

public class SpaceAge {
	private static final double SECONDS_IN_DAY = 86400.0;
	private double ageInSeconds;
	
	public SpaceAge(double ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}
	
	public double getAgeInSeconds() {
		return ageInSeconds;
	}
	
	/**
	 * Converts the given age in years into seconds.
	 * 
	 * @param ageInYears the age given in years
  	 * @return age coverted into seconds*/
	public static double convertYearsInSeconds(double ageInYears) {
		return SECONDS_IN_DAY * 365.25 * ageInYears;
	}
	
	public double calculateSpaceAge(Planet planet) {
		switch(planet) {
		case MERCURY:
			return calculateAgeOnMercury();
		case VENUS:
			return calculateAgeOnVenus();
		case EARTH:
			return calculateAgeOnEarth();
		case MARS:
			return calculateAgeOnMars();
		case JUPITER:
			return calculateAgeOnJupiter();
		case SATURN:
			return calculateAgeOnSaturn();
		case URANUS:
			return calculateAgeOnUranus();
		case NEPTUNE:
			return calculateAgeOnNeptune();
		}
		
		return 0.0;
	}
	
	private double calculateAgeOnMercury() {
		double secondsInMercuryYear = SECONDS_IN_DAY * Planet.MERCURY.getDaysInAYear();
		
		return ageInSeconds / secondsInMercuryYear;
	}
	
	private double calculateAgeOnVenus() {
		double secondsInVenusYear = SECONDS_IN_DAY * Planet.VENUS.getDaysInAYear();
		
		return ageInSeconds / secondsInVenusYear;
	}
	
	private double calculateAgeOnEarth() {
		double secondsInEarthYear = SECONDS_IN_DAY * Planet.EARTH.getDaysInAYear();
		
		return ageInSeconds / secondsInEarthYear;
	}
	
	private double calculateAgeOnMars() {
		double secondsInMarsYear = SECONDS_IN_DAY * Planet.MARS.getDaysInAYear();
		
		return ageInSeconds / secondsInMarsYear;
	}
	
	private double calculateAgeOnJupiter() {
		double secondsInJupiterYear = SECONDS_IN_DAY * Planet.JUPITER.getDaysInAYear();
		
		return ageInSeconds / secondsInJupiterYear;
	}
	
	private double calculateAgeOnSaturn() {
		double secondsInSaturnYear = SECONDS_IN_DAY * Planet.SATURN.getDaysInAYear();
		
		return ageInSeconds / secondsInSaturnYear;
	}
	
	private double calculateAgeOnUranus() {
		double secondsInUranusYear = SECONDS_IN_DAY * Planet.URANUS.getDaysInAYear();
		
		return ageInSeconds / secondsInUranusYear;
	}
	
	private double calculateAgeOnNeptune() {
		double secondsInNeptuneYear = SECONDS_IN_DAY * Planet.NEPTUNE.getDaysInAYear();
		
		return ageInSeconds / secondsInNeptuneYear;
	}
}
