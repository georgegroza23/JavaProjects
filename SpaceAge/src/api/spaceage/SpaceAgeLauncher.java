package api.spaceage;

public class SpaceAgeLauncher {

	public static void main(String[] args) {
		double ageInSeconds = 1_000_000_000;
		SpaceAge spaceAge = new SpaceAge(ageInSeconds);
		
		System.out.println(spaceAge.calculateSpaceAge(Planet.EARTH));
	}
}
