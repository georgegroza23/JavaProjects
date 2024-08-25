package api.spaceage;

 enum Planet {
	MERCURY(0.2408467, 365.25 * 0.2408467),
	VENUS(0.61519726, 365.25 * 0.61519726),
	EARTH(1.0, 365.25 * 1.0),
	MARS(1.8808158, 365.25 * 1.8808158),
	JUPITER(11.862615, 365.25 * 11.862615),
	SATURN(29.447498, 365.25 * 29.447498),
	URANUS(84.016846, 365.25 * 84.016846),
	NEPTUNE(164.79132, 365.25 * 164.79132);
	
	private double orbitalPeriod;
	private double daysInAYear;
	
	private Planet(double orbitalPeriod, double daysInAYear) {
		this.orbitalPeriod = orbitalPeriod;
		this.daysInAYear = daysInAYear;
	}
	
	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
	public double getDaysInAYear() {
		return daysInAYear;
	}
}
