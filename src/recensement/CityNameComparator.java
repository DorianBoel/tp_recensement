package recensement;

import java.util.Comparator;

public class CityNameComparator implements Comparator<City> {

	// Constructor
	public CityNameComparator() {
		
	}

	// Instance methods
	@Override
	public int compare(City city1, City city2) {
		return StringUtils.stripAccents(city1.getName()).compareTo(StringUtils.stripAccents(city2.getName()));
	}

}
