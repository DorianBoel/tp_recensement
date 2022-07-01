package recensement.utils.comparators;

import java.util.Comparator;

import recensement.entities.instanced.Region;
import recensement.utils.StringUtils;

public class RegionNameComparator implements Comparator<Region> {

	// Constructor
	public RegionNameComparator() {
		
	}

	// Instance methods
	@Override
	public int compare(Region region1, Region region2) {
		return StringUtils.stripAccents(region1.getName()).compareTo(StringUtils.stripAccents(region2.getName()));
	}

}
