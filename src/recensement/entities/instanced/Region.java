package recensement.entities.instanced;

import java.util.ArrayList;
import java.util.List;

import recensement.entities.GeographicEntity;
import recensement.utils.NumUtils;

public class Region extends GeographicEntity {

	// Instance attributes
	private String name;
	private List<Department> departments = new ArrayList<>();
	
	// Constructor
	public Region(String name, String code, List<Department> departments) {
		super(code);
		this.name = name;
		this.departments.addAll(departments);
	}
	
	// Instance methods
	@Override
	public int getPopulation() {
		int population = 0;
		for (Department department : this.departments) {
			population += department.getPopulation();
		}
		return population;
	}
	
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

	// Getters
	public String getName() {
		return this.name;
	}

	public List<Department> getDepartments() {
		return this.departments;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
}
