package recensement;

import java.util.Comparator;

public class CityPopulationComparator implements Comparator<City> {

	// Constructor
	public CityPopulationComparator() {
		
	}

	// Instance methods
	@Override
	public int compare(City city1, City city2) {
		return Integer.compare(city1.getPopulation(), city2.getPopulation()) * -1;
	}

}
