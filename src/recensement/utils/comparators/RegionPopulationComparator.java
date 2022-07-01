package recensement.utils.comparators;

import java.util.Comparator;

import recensement.entities.instanced.Region;

public class RegionPopulationComparator implements Comparator<Region> {

	// Constructor
	public RegionPopulationComparator() {
		
	}

	// Instance methods
	@Override
	public int compare(Region region1, Region region2) {
		return Integer.compare(region1.getPopulation(), region2.getPopulation()) * -1;
	}

}
