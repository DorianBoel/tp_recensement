package recensement.entities.instanced;

import java.util.ArrayList;
import java.util.List;

import recensement.entities.GeographicEntity;
import recensement.utils.NumUtils;

public class Department extends GeographicEntity {

	// Instance attributes
	private String regionCode;
	private List<City> cities = new ArrayList<>();
	
	// Constructor
	public Department(String code, String regionCode, List<City> list) {
		super(code);
		this.regionCode = regionCode;
		this.cities.addAll(list);
	}
	
	//Instance methods
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

	// Getters
	public String getRegionCode() {
		return this.regionCode;
	}

	public List<City> getCities() {
		return this.cities;
	}

	// Setters
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
}
