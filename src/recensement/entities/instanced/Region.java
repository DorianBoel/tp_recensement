package recensement.entities.instanced;

import java.util.ArrayList;
import java.util.List;

import recensement.entities.GeographicEntity;
import recensement.utils.NumUtils;

/**
 * Represents a single region of France.
 * 
 * @author DorianBoel
 */
public class Region extends GeographicEntity {

	/**
	 * The full name of the region.
	 */
	private String name;
	
	
	/**
	 * The list of departments the 
	 * region contains.
	 */
	private List<Department> departments = new ArrayList<>();
	
	
	/**
	 * Constructor for {@link #Region}.
	 * 
	 * Creates a new region with the given characteristics
	 * and complete list of departments.
	 *
	 * @param name The region's name
	 * @param code The region's unique 
	 * standardized 2-digit code
	 * @param departments The list of departments the
	 * region contains
	 */
	public Region(String name, String code, List<Department> departments) {
		super(code);
		this.name = name;
		this.departments.addAll(departments);
	}
	
	/**
	 * Gets the total population for the region
	 * by calculating the sum of
	 * all population values from the
	 * {@link #departments department list}.
	 * 
	 * @return The total population of the region
	 */
	@Override
	public int getPopulation() {
		int population = 0;
		for (Department department : this.departments) {
			population += department.getPopulation();
		}
		return population;
	}
	
	/**
	 * Gets the list of all of this region's cities by
	 * joining the city list of each department in the
	 * {@link #departments department list}.
	 * 
	 * @return The list of all cities this region contains
	 */
	public List<City> getCities() {
		List<City> list = new ArrayList<>();
		for (Department department : this.departments) {
			list.addAll(department.getCities());
		}
		return list;
	}
	
	@Override
	public String toString() {
		return 
			this.name + " (" + this.code + "), "
			+ NumUtils.format(this.getPopulation()) + " habitants"
		;
	}

	/**
	 * Getter for {@link #name}.
	 * 
	 * @return This region's official name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for {@link #departments}.
	 * 
	 * @return The list of this region's departments
	 */
	public List<Department> getDepartments() {
		return this.departments;
	}

	/**
	 * Setter for {@link #name}
	 * 
	 * @param name The new name to replace
	 * the current one
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
