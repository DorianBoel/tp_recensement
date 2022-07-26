package recensement.utils.comparators;

import java.util.Comparator;

import recensement.entities.instanced.City;

/**
 * Comparator class used to sort {@link City cities}
 * using their total populations.
 * 
 * @author DorianBoel
 */
public class CityPopulationComparator implements Comparator<City> {

	/**
	 * Constructor for {@link #CityPopulationComparator()}.
	 * Creates a new CityPopulationComparator.
	 */
	public CityPopulationComparator() {}

	
	/**
	 * Compares the population values of two given cities.
	 * 
	 * @param city1 The first city to compare
	 * @param city2 The second city to compare
	 * @return An integer value based on the comparison result
	 */
	@Override
	public int compare(City city1, City city2) {
		return Integer.compare(city1.getPopulation(), city2.getPopulation()) * -1;
	}

}
