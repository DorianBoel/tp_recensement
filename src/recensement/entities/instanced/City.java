package recensement.entities.instanced;

import recensement.entities.GeographicEntity;
import recensement.utils.NumUtils;

/**
 * Represents a single city/town of France.
 * 
 * @author DorianBoel
 */
public class City extends GeographicEntity {

	/**
	 * The city's official full name.
	 */
	private String name;
	
	/**
	 * The numerical code referring to the department
	 * the city belongs to.
	 */
	private String departmentCode;
	
	/**
	 * The name of the region the city belongs to.
	 */
	private String regionName;
	
	/**
	 * The numerical code of the region the city
	 * belongs to.
	 */
	private String regionCode;
	
	/**
	 * The total number of people
	 * inhabiting the city.
	 */
	private int population;
	
	/**
	 * Constructor for {@link #City}.
	 * 
	 * Creates a new city with the given characteristics. 
	 *
	 * @param name The city's name
	 * @param code The city's standardized 3-digits code.
	 * Must be unique within a given department
	 * @param departmentCode The code of the department which
	 * contains the city 
	 * @param regionName The name of the region which contains the city
	 * @param regionCode The code of the region which conatins the city
	 * @param population The city's total population
	 */
	public City(String name, String code, String departmentCode, String regionName, String regionCode, int population) {
		super(code);
		this.name = name;
		this.departmentCode = departmentCode;
		this.regionName = regionName;
		this.regionCode = regionCode;
		this.population = population;
	}
	
	
	/**
	 * Gets the full city code comprised of
	 * the 2-digit department code and the city's
	 * 3-digit code within its department.
	 * 
	 * @return The full 5-digit city code
	 */
	public String getFullCityCode() {
		return this.departmentCode + this.code;
	}
	
	@Override
	public String toString() {
		return
			this.name + " (" + this.getFullCityCode() + "), "
			+ this.regionName + " (" + this.regionCode + "), "
			+ NumUtils.format(this.population) + " habitants"
		;
	}
	
	/**
	 * Getter for {@link #name}.
	 * 
	 * @return This city's official name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for {@link #departmentCode}.
	 * 
	 * @return The unique code of the department 
	 * this city belongs to
	 */
	public String getDepartmentCode() {
		return this.departmentCode;
	}

	/**
	 * Getter for {@link #regionName}.
	 * 
	 * @return The name of the region this city
	 * belongs to
	 */
	public String getRegionName() {
		return this.regionName;
	}

	/**
	 * Getter for {@link #regionCode}.
	 * 
	 * @return The unique code of the region this city
	 * belongs to
	 */
	public String getRegionCode() {
		return this.regionCode;
	}

	/**
	 * Getter for {@link #population}.
	 * 
	 * @return This city's total population in number of inhabitants
	 */
	@Override
	public int getPopulation() {
		return this.population;
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

	/**
	 * Setter for {@link #departmentCode}
	 * 
	 * @param departmentCode The new department code to replace
	 * the current one
	 */
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/**
	 * Setter for {@link #regionName}
	 * 
	 * @param departmentCode The new region name to replace
	 * the current one
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * Setter for {@link #regionCode}
	 * 
	 * @param departmentCode The new region code to replace
	 * the current one
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	/**
	 * Setter for {@link #population}
	 * 
	 * @param departmentCode The new population value to replace
	 * the current one
	 */
	public void setPopulation(int population) {
		this.population = population;
	}
	
}
