package recensement.services;

import java.util.List;
import java.util.Scanner;

import recensement.entities.Census;
import recensement.entities.exceptions.CancelSearchException;
import recensement.entities.exceptions.NoResultsException;
import recensement.entities.instanced.City;
import recensement.entities.instanced.Department;
import recensement.entities.instanced.Region;
import recensement.services.secondary.SecondaryService;
import recensement.services.secondary.specific.DisplayService;
import recensement.utils.comparators.CityPopulationComparator;
import recensement.utils.comparators.DepartmentPopulationComparator;
import recensement.utils.comparators.RegionNameComparator;
import recensement.utils.comparators.RegionPopulationComparator;

/**
 * Non-instantiable class containing all primary methods
 * called directly from the main app method.
 *
 * @author DorianBoel
 */
public final class MainService {

	/**
	 * Don't let anyone instantiate this class.
	 */
	private MainService() {}
	
	/**
	 * Displays the main menu.
	 */
	public static void displayMenu() {
		DisplayService.displayMessage("menu");
	}
	
	/**
	 * Displays a message stating a received user input is 
	 * not recognized as a valid option.
	 */
	public static void defaultOption() {
		DisplayService.displayMessage("invalid");
	}
	
	/**
	 * Displays the app startup message and the main menu.
	 */
	public static void start() {
		DisplayService.displayMessage("start");
		displayMenu();
	}
	
	/**
	 * Displays the program exit message
	 */
	public static void exit() {
		DisplayService.displayMessage("exit");
	}
	
	/**
	 * Displays the top 10 most populated
	 * cities in the entire list
	 * 
	 * @param census The list containing the city census data
	 */
	public static void displayCityTop10(Census census) {
		System.out.println("Les 10 villes de France les plus peuplées:");
		List<City> cities = SecondaryService.copyListSorted(census.getCityList(), new CityPopulationComparator());
		DisplayService.displayList(cities);
		DisplayService.displayMessage("menu-opt");
	}
	
	/**
	 * Displays the top 10 most populated
	 * departments in the entire list
	 * 
	 * @param census A {@link recensement.entities.Census Census}
	 * instance containing all city data
	 */
	public static void displayDepartmentTop10(Census census) {
		DisplayService.displayMessage("department-top-10");
		List<Department> departments = SecondaryService.copyListSorted(census.getDepartmentList(), new DepartmentPopulationComparator());
		DisplayService.displayList(departments);
		DisplayService.displayMessage("menu-opt");
	}
	
	/**
	 * Displays the top 10 most populated
	 * regions in the entire list
	 * 
	 * @param census A {@link recensement.entities.Census Census}
	 * instance containing all city data
	 */
	public static void displayRegionTop10(Census census) {
		DisplayService.displayMessage("region-top-10");
		List<Region> regions = SecondaryService.copyListSorted(census.getRegionList(), new RegionPopulationComparator());
		DisplayService.displayList(regions);
		DisplayService.displayMessage("menu-opt");
	}
	
	/**
	 * Asks the user to input a city name
	 * then displays the list of matching cities
	 * with their respective info.<br>
	 * (city name, city code, region, total population)
	 * 
	 * @param census A {@link recensement.entities.Census Census}
	 * instance containing all city data
	 * @param scanner The main prompt {@link java.util.Scanner Scanner}
	 * @throws CancelSearchException If the user cancels the search when prompted.
	 * @throws NoResultsException If the list of matching cities is empty.
	 */
	public static void displayCityPopulation(Census census, Scanner scanner) throws CancelSearchException, NoResultsException {
		List<City> results = SecondaryService.searchCity(census.getCityList(), scanner);
		try {
			if (results.size() == 0) {
				throw new NoResultsException();
			}
			SecondaryService.displayCityResults(results);
		} catch(NoResultsException e) {
			DisplayService.displayMessage("no-result");
			displayCityPopulation(census, scanner);
		}
	}
	
	/**
	 * Asks the user to input a department code
	 * then displays the info of the corresponding
	 * department.
	 * (department code, population)
	 * 
	 * @param census A {@link recensement.entities.Census Census}
	 * instance containing all city data
	 * @param scanner The main prompt {@link java.util.Scanner Scanner}
	 * @throws CancelSearchException If the user cancels the search when prompted.
	 */
	public static void displayDepartmentPopulation(Census census, Scanner scanner) throws CancelSearchException {
		Department department = SecondaryService.searchDepartment(census.getDepartmentList(), scanner);
		try {
			if (department == null) {
				throw new NoResultsException();
			}
			DisplayService.displayMessage("display-string", department.toString());
			DisplayService.displayMessage("menu-opt-2");
		} catch(NoResultsException e) {
			DisplayService.displayMessage("no-department");
			displayDepartmentPopulation(census, scanner);
		}
	}
	
	/**
	 * Asks the user to select a region from 
	 * the list of regions then displays the info 
	 * of the selected region.
	 * (region name, region code, population)
	 * 
	 * @param census  A {@link recensement.entities.Census Census}
	 * instance containing all city data
	 * @param scanner The main prompt {@link java.util.Scanner Scanner}
	 * @param displayList Boolean value determining whether or not
	 * to display the region list initially
	 * @throws CancelSearchException If the user cancels the search when prompted.
	 * @throws NumberFormatException If the user input cannot be parsed as a an integer.
	 * @throws NoResultsException If the submitted number is out of bounds in the list of regions.
	 */
	public static void displayRegionPopulation(Census census, Scanner scanner, boolean displayList) throws NumberFormatException, CancelSearchException, NoResultsException {
		List<Region> regions = SecondaryService.copyListSorted(census.getRegionList(), new RegionNameComparator());
		if (displayList) {
			SecondaryService.displayRegionList(regions);
		}
		String regionSelect = SecondaryService.selectRegion(scanner);
		try {
			int index = Integer.parseInt(regionSelect) - 1;
			if (index < 0 || index >= regions.size()) {
				throw new NoResultsException();
			}
			DisplayService.displayMessage("display-string", regions.get(index).toString());
			DisplayService.displayMessage("menu-opt-3");
		} catch(NumberFormatException | NoResultsException e) {
			defaultOption();
			displayRegionPopulation(census, scanner, false);
		}
	}
	
	/**
	 * Asks the user to input a department code
	 * then displays the top 10 most populated cities
	 * in the corresponding department.
	 * 
	 * @param census A {@link recensement.entities.Census Census}
	 * instance containing all city data
	 * @param scanner The main prompt {@link java.util.Scanner Scanner}
	 * @throws CancelSearchException If the user cancels the search when prompted.
	 */
	public static void displayDepartmentCityTop10(Census census, Scanner scanner) throws CancelSearchException {
		Department department = SecondaryService.searchDepartment(census.getDepartmentList(), scanner);
		try {
			if (department == null) {
				throw new NoResultsException();
			}
			List<City> cities = SecondaryService.copyListSorted(department.getCities(), new CityPopulationComparator());
			DisplayService.displayMessage("department-cities", department.getCode());
			DisplayService.displayList(cities);
			DisplayService.displayMessage("menu-opt-6");
		} catch(NoResultsException e) {
			DisplayService.displayMessage("no-department");
			displayDepartmentCityTop10(census, scanner);
		}
	}
	
	/**
	 * Asks the user to select a region from 
	 * the list of regions then displays the top 10
	 * most populated cities within that region.
	 * 
	 * @param census A {@link recensement.entities.Census Census}
	 * instance containing all city data
	 * @param scanner The main prompt {@link java.util.Scanner Scanner}
	 * @param displayList Boolean value determining whether or not
	 * to display the region list initially
	 * @throws CancelSearchException If the user cancels the search when prompted.
	 * @throws NumberFormatException If the user input cannot be parsed as a an integer.
	 * @throws NoResultsException If the submitted number is out of bounds in the list of regions.
	 */
	public static void displayRegionCityTop10(Census census, Scanner scanner, boolean displayList) throws CancelSearchException, NumberFormatException, NoResultsException {
		List<Region> regions = SecondaryService.copyListSorted(census.getRegionList(), new RegionNameComparator());
		if (displayList) {
			SecondaryService.displayRegionList(regions);
		}
		String regionSelect = SecondaryService.selectRegion(scanner);
		try {
			int index = Integer.parseInt(regionSelect) - 1;
			if (index < 0 || index >= regions.size()) {
				throw new NoResultsException();
			} 
			Region region = regions.get(index);
			List<City> cities = SecondaryService.copyListSorted(region.getCities(), new CityPopulationComparator());
			DisplayService.displayMessage("region-cities", region.getName());
			DisplayService.displayList(cities);
			DisplayService.displayMessage("menu-opt-7");
		} catch(NumberFormatException | NoResultsException e) {
			defaultOption();
			displayRegionCityTop10(census, scanner, false);
		}
	}
	
}
