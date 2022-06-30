package recensement;

public class City extends GeographicEntity {

	// Instance attributes
	private String name, departmentCode, regionName, regionCode;
	private int population;
	
	//Constructor
	public City(String name, String code, String departmentCode, String regionName, String regionCode, int population) {
		super(code);
		this.name = name;
		this.departmentCode = departmentCode;
		this.regionName = regionName;
		this.regionCode = regionCode;
		this.population = population;
	}
	
	// Instance methods
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
	
	// Getters
	public String getName() {
		return this.name;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public String getRegionCode() {
		return this.regionCode;
	}

	@Override
	public int getPopulation() {
		return this.population;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
}
