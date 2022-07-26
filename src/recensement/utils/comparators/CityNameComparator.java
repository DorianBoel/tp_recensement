package recensement.utils.comparators;

import java.util.Comparator;

import recensement.entities.instanced.City;
import recensement.utils.StringUtils;

/**
 * Comparator class used to sort {@link City cities}
 * by alphabetical order using their names.
 * 
 * @author DorianBoel
 */
public class CityNameComparator implements Comparator<City> {

	/**
	 * Constructor for {@link #CityNameComparator}.
	 * Creates a new CityNameComparator.
	 */
	public CityNameComparator() {}

	/**
	 * Compares the names of two given cities, ignoring diacritics.
	 * 
	 * @param city1 The first city to compare
	 * @param city2 The second city to compare
	 * @return An integer value based on the comparison result
	 */
	@Override
	public int compare(City city1, City city2) {
		return StringUtils.stripAccents(city1.getName()).compareTo(StringUtils.stripAccents(city2.getName()));
	}

}
