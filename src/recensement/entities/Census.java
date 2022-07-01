package recensement.entities;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import recensement.entities.instanced.City;
import recensement.entities.instanced.Department;
import recensement.entities.instanced.Region;
import recensement.services.secondary.specific.FileAccess;

public class Census {

	// Class attributes
	private static Census singleInstance = null;
	
	//Instance attributes
	private List<City> cityList = new ArrayList<>();
	private List<Department> departmentList = new ArrayList<>();
	private List<Region> regionList = new ArrayList<>();
	
	// Constructor
	private Census() throws FileNotFoundException {
		this.initiateCityList();
		this.initiateDepartmentList();
		this.initiateRegionList();
	}
	
	//Class methods
	public static Census getInstance() throws FileNotFoundException {
		if (singleInstance == null) {        	
			singleInstance = new Census();
		}
		return singleInstance;
	}
	
	// Instance methods
	private void initiateCityList() throws FileNotFoundException {
		if (this.cityList.size() == 0) {
			List<String> lines = FileAccess.getLines();
			for (int i = 1; i < lines.size(); i++) {
				String[] lineData = lines.get(i).split(";");
				String 
					cityName = lineData[6],
					cityCode = lineData[5],
					departmentCode = lineData[2],
					regionName = lineData[1],
					regionCode = lineData[0]
				;
				int population = Integer.parseInt(lineData[9].replace(" ", ""));
				this.cityList.add(new City(cityName, cityCode, departmentCode, regionName, regionCode, population));
			}	
		}
	}
	
	private void initiateDepartmentList() {
		if (this.departmentList.size() == 0) {
			Set<String> codeSet = new HashSet<>();
			for (City city : cityList) {
				codeSet.add(city.getDepartmentCode());
			}
			for (String code : codeSet) {
				String regionCode = null;
				List<City> cities = new ArrayList<>();
				for (City city : cityList) {
 					if (city.getDepartmentCode().equals(code)) {
 						if (regionCode == null) {
 							regionCode = city.getRegionCode();
 						}
						cities.add(city);
					}
				}
				this.departmentList.add(new Department(code, regionCode, cities));
			}
		}
	}
	
	private void initiateRegionList() {
		if (this.regionList.size() == 0) {
			Set<String> codeSet = new HashSet<>();
			for (Department department : departmentList) {
				codeSet.add(department.getRegionCode());
			}
			for (String code : codeSet) {
				String regionName = null;
				List<Department> departments = new ArrayList<>();
				for (Department department : departmentList) {
 					if (department.getRegionCode().equals(code)) {
 						if (regionName == null) {
 							regionName = department.getCities().get(0).getRegionName();
 						}
						departments.add(department);
					}
				}
				this.regionList.add(new Region(regionName, code, departments));
			}
		}
	}

	// Getters
	public List<City> getCityList() {
		return this.cityList;
	}
	
	public List<Department> getDepartmentList() {
		return this.departmentList;
	}
	
	public List<Region> getRegionList() {
		return regionList;
	}
	
}
