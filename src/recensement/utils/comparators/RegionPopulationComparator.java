package recensement.utils.comparators;

import java.util.Comparator;

import recensement.entities.instanced.Region;

/**
 * Comparator class used to sort {@link Region regions}
 * using their total populations.
 * 
 * @author DorianBoel
 */
public class RegionPopulationComparator implements Comparator<Region> {

	/**
	 * Constructor for {@link #RegionPopulationComparator()}.
	 * Creates a new RegionPopulationComparator.
	 */
	public RegionPopulationComparator() {}

	/**
	 * Compares the population values of two given regions.
	 * 
	 * @param region1 The first region to compare
	 * @param region2 The second region to compare
	 * @return An integer value based on the comparison result
	 */
	@Override
	public int compare(Region region1, Region region2) {
		return Integer.compare(region1.getPopulation(), region2.getPopulation()) * -1;
	}

}
