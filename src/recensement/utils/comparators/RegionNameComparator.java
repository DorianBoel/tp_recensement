package recensement.utils.comparators;

import java.util.Comparator;

import recensement.entities.instanced.Region;
import recensement.utils.StringUtils;

/**
 * Comparator class used to sort {@link Region regions}
 * by alphabetical order using their names.
 * 
 * @author DorianBoel
 */
public class RegionNameComparator implements Comparator<Region> {

	/**
	 * Constructor for {@link #RegionNameComparator()}.
	 * Creates a new RegionNameComparator.
	 */
	public RegionNameComparator() {}

	/**
	 * Compares the names of two given regions, ignoring diacritics.
	 * 
	 * @param region1 The first region to compare
	 * @param region2 The second region to compare
	 * @return An integer value based on the comparison result
	 */
	@Override
	public int compare(Region region1, Region region2) {
		return StringUtils.stripAccents(region1.getName()).compareTo(StringUtils.stripAccents(region2.getName()));
	}

}
