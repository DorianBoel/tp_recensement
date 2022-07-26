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

/**
 * Singleton class containing all registered 
 * geographic census data stored in lists.
 * 
 * @author DorianBoel
 */
public class Census {

	/**
	 * The single instance this class can possess.
	 */
	private static Census singleInstance = null;
	
	/**
	 * A list containing all registered city instances.
	 */
	private List<City> cityList = new ArrayList<>();
	
	/**
	 * A list containing all registered department instances.
	 */
	private List<Department> departmentList = new ArrayList<>();
	
	/**
	 * A list containing all registered city instances.
	 */
	private List<Region> regionList = new ArrayList<>();
	
	/**
	 * Constructor for {@link #Census}.
	 * Initiates each list of geographic instances.
	 * 
	 * @throws FileNotFoundException If any one of the instance
	 * lists fails to load.
	 */
	private Census() throws FileNotFoundException {
		initiateCityList();
		initiateDepartmentList();
		initiateRegionList();
	}
	
	/**
	 * Returns the single instance of this class, 
	 * or initiates one if none exist.
	 * 
	 * @return The single instance of this class
	 * @throws FileNotFoundException If the instance fails to
	 * be constructed.
	 */
	public static Census getInstance() throws FileNotFoundException {
		if (singleInstance == null) {        	
			singleInstance = new Census();
		}
		return singleInstance;
	}
	
	/**
	 * Parses through and creates
	 * a {@link recensement.entities.instanced.City City}
	 * instance for each CSV data record before adding
	 * it to the city list.
	 * 
	 * @throws FileNotFoundException If the CSV data is not accessible.
	 */
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
	
	/**
	 * Creates a {@link recensement.entities.instanced.Department Department}
	 * instance for each unique department code
	 * within the list of city entries before adding
	 * it to the department list.
	 */
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
	
	/**
	 * Creates a {@link recensement.entities.instanced.Region Region}
	 * instance for each unique region code
	 * within the list of department entries before adding
	 * it to the region list.
	 */
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

	/**
	 * Getter for {@link #cityList}.
	 * 
	 * @return The list of city instances
	 */
	public List<City> getCityList() {
		return this.cityList;
	}
	
	/**
	 * Getter for {@link #departmentList}.
	 * 
	 * @return The list of department instances
	 */
	public List<Department> getDepartmentList() {
		return this.departmentList;
	}
	
	/**
	 * Getter for {@link #regionList}.
	 * 
	 * @return The list of region instances
	 */
	public List<Region> getRegionList() {
		return regionList;
	}
	
}
