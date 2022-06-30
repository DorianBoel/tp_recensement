package recensement;

import java.util.Comparator;

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
