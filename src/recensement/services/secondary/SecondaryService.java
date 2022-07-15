package recensement.services.secondary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import recensement.entities.GeographicEntity;
import recensement.entities.exceptions.CancelSearchException;
import recensement.entities.instanced.City;
import recensement.entities.instanced.Department;
import recensement.entities.instanced.Region;
import recensement.services.secondary.specific.DisplayService;
import recensement.services.secondary.specific.PromptService;
import recensement.services.secondary.specific.SearchService;

/**
 * Non-instanciable class containing
 * intermediate service methods called by 
 * the main service.
 * 
 * @author DorianBoel
 */
public final class SecondaryService {
	
	/**
	 * Don't let anyone instantiate this class.
	 */
	private SecondaryService() {}
	
	/**
	 * Asks the user for city name input and submits it to the
	 * {@link recensement.entities.services.specific.SearchService SearchService}.
	 * Then returns the list of matching cities.
	 * 
	 * @param cityList A full list of {@link recensement.entities.instanced.City City} instances
	 * @param scanner The main prompt {@link java.util.Scanner Scanner}
	 * @return A list containing the {@link recensement.entities.instanced.City City} results
	 * @throws CancelSearchException If the user submits an input with no non-whitespace characters.
	 */
	public static List<City> searchCity(List<City> cityList, Scanner scanner) throws CancelSearchException {
		DisplayService.displayMessage("city-prompt");
		String searchTerm = PromptService.acceptInput(scanner);
		if (searchTerm.strip().equals("")) {
			throw new CancelSearchException();
		}
		return SearchService.findCityByName(searchTerm, cityList);
	}
	
	/**
	 * Allows the user to input a department code and submits it to the
	 * {@link recensement.entities.services.specific.SearchService SearchService}.
	 * Then returns the matching department.
	 * 
	 * @param cityList A full list of {@link recensement.entities.instanced.Department Department} instances
	 * @param scanner The main prompt {@link java.util.Scanner Scanner}
	 * @return A {@link recensement.entities.instanced.Department Department} matching the submitted code
	 * @throws CancelSearchException If the user submits an input with no non-whitespace characters.
	 */
	public static Department searchDepartment(List<Department> departmentList, Scanner scanner) throws CancelSearchException {
		DisplayService.displayMessage("department-prompt");
		String departmentCode = PromptService.acceptInput(scanner);
		if (departmentCode.strip().equals("")) {
			throw new CancelSearchException();
		}
		return SearchService.findDepartment(departmentCode, departmentList);
	}
	
	/**
	 * Allows the user to input a number 
	 * corresponding to a region in the region menu.
	 * 
	 * @param scanner The main prompt {@link java.util.Scanner Scanner}
	 * @return The submitted user input if it isn't empty
	 * @throws CancelSearchException If the user submits an input with no non-whitespace characters.
	 */
	public static String selectRegion(Scanner scanner) throws CancelSearchException {
		String regionSelect = PromptService.acceptInput(scanner); 
		if (regionSelect.strip().equals("")) {
			throw new CancelSearchException();
		}
		return regionSelect;
	}
	
	/**
	 * Displays the region select menu by
	 * iterating through the region list.
	 * 
	 * @param regionList A list containing all registered 
	 * {@link recensement.entities.instanced.Region Region} instances
	 */
	public static void displayRegionList(List<Region> regionList) {
		DisplayService.displayMessage("region-prompt");
		for (int i = 0; i < regionList.size(); i++) {				
			DisplayService.displayListLine(i + 1, regionList.get(i).getName());
		}
		DisplayService.displayMessage("display-string", "");
	}
	
	/**
	 * Displays the results of a city search query.
	 * If the list contains more than one result,
	 * displays a list of all resulting cities,
	 * or only the first ten results in alphabetical
	 * order if there are more than 10 results.
	 * Otherwise displays the single city result.
	 * 
	 * @param results A list of {@link recensement.entities.instanced.City City} instances
	 * containing the results of a city search
	 */
	public static void displayCityResults(List<City> results) {
		if (results.size() == 1) {
			DisplayService.displayMessage("display-string", results.get(0).toString());
			DisplayService.displayMessage("menu-opt-1");
			return;
		}
		int resultsLimit = results.size() > 10 ? 10 : results.size();
		DisplayService.displayMessage("results-total", String.valueOf(results.size()));
		if (results.size() > 10) {
			DisplayService.displayMessage("first-10");
		}
		DisplayService.displayList(results, resultsLimit);
		DisplayService.displayMessage("menu-opt-1");
	}
	
	/**
	 * Creates a copy of a given list of
	 * {@link GeographicEntity GeographicEntities}
	 * then sorts its contents using the given 
	 * {@link java.util.Comparator Comparator}.
	 * 
	 * @param <T> A type extending the {@link GeographicEntity GeographicEntity}
	 * abstract class (city, department or region)
	 * @param list A list of {@link GeographicEntity GeographicEntities} to be copied
	 * @param comparator A {@link java.util.Comparator Comparator} determining
	 * how the copied list must be sorted
	 * @return The newly created sorted list
	 */
	public static <T extends GeographicEntity> List<T> copyListSorted(List<T> list, Comparator<T> comparator) {
		List<T> copy = new ArrayList<>(list);
		Collections.sort(copy, comparator);
		return copy;
	}
	
}
