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

public class MainService {

	// Class methods
	public static void displayMenu() {
		DisplayService.displayMessage("menu");
	}
	
	public static void defaultOption() {
		DisplayService.displayMessage("invalid");
	}
	
	public static void start() {
		DisplayService.displayMessage("start");
		displayMenu();
	}
	
	public static void exit() {
		DisplayService.displayMessage("exit");
	}
	
	public static void displayCityTop10(Census census) {
		System.out.println("Les 10 villes de France les plus peuplées:");
		List<City> cities = SecondaryService.copyListSorted(census.getCityList(), new CityPopulationComparator());
		DisplayService.displayList(cities);
		DisplayService.displayMessage("menu-opt");
	}
	
	public static void displayDepartmentTop10(Census census) {
		DisplayService.displayMessage("department-top-10");
		List<Department> departments = SecondaryService.copyListSorted(census.getDepartmentList(), new DepartmentPopulationComparator());
		DisplayService.displayList(departments);
		DisplayService.displayMessage("menu-opt");
	}
	
	public static void displayRegionTop10(Census census) {
		DisplayService.displayMessage("region-top-10");
		List<Region> regions = SecondaryService.copyListSorted(census.getRegionList(), new RegionPopulationComparator());
		DisplayService.displayList(regions);
		DisplayService.displayMessage("menu-opt");
	}
	
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
