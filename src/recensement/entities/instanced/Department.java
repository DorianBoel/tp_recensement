package recensement.entities.instanced;

import java.util.ArrayList;
import java.util.List;

import recensement.entities.GeographicEntity;
import recensement.utils.NumUtils;

/**
 * Represents a single departmental subdivision of France.
 * 
 * @author DorianBoel
 */
public class Department extends GeographicEntity {

	// Instance attributes
	/**
	 * The numerical code of the region the department
	 * belongs to. 
	 */
	private String regionCode;
	
	/**
	 * The list of all cities the
	 * department contains.
	 */
	private List<City> cities = new ArrayList<>();
	
	
	/**
	 * Constructor for {@link #Department}.
	 * 
	 * Creates a new department with the given characteristics
	 * and complete list of cities.
	 *
	 * @param code The department's unique standardized 2-digits code.
	 * @param regionCode The code of the region which contains 
	 * the department
	 * @param list The complete list of cities within the department
	 */
	public Department(String code, String regionCode, List<City> list) {
		super(code);
		this.regionCode = regionCode;
		this.cities.addAll(list);
	}
	
	/**
	 * Gets the total population for the department
	 * by calculating the sum of the
	 * {@link City#population population} values 
	 * of each city in the department's city list.
	 * 
	 * @return The total population of the department
	 */
	@Override
	public int getPopulation() {
		int population = 0;
		for (City city : this.cities) {
			population += city.getPopulation();
		}
		return population;
	}
	
	@Override
	public String toString() {
		return 
			"Département " + this.getCode() + ", " 
			+ NumUtils.format(this.getPopulation()) + " habitants"
		;
	}

	/**
	 * Getter for {@link #regionCode}.
	 * 
	 * @return The code of the region this department
	 * belongs to
	 */
	public String getRegionCode() {
		return this.regionCode;
	}

	/**
	 * Getter for {@link #cities}.
	 * 
	 * @return The list of this department's cities
	 */
	public List<City> getCities() {
		return this.cities;
	}

	/**
	 * Setter for {@link #regionCode}.
	 * 
	 * @return The new region code to replace
	 * the current one
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
}
