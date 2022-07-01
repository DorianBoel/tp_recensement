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

public class SecondaryService {
	
	public static List<City> searchCity(List<City> cityList, Scanner scanner) throws CancelSearchException {
		DisplayService.displayMessage("city-prompt");
		String searchTerm = PromptService.acceptInput(scanner);
		if (searchTerm.strip().equals("")) {
			throw new CancelSearchException();
		}
		return SearchService.findCityByName(searchTerm, cityList);
	}
	
	public static Department searchDepartment(List<Department> departmentList, Scanner scanner) throws CancelSearchException {
		DisplayService.displayMessage("department-prompt");
		String departmentCode = PromptService.acceptInput(scanner);
		if (departmentCode.strip().equals("")) {
			throw new CancelSearchException();
		}
		return SearchService.findDepartment(departmentCode, departmentList);
	}
	
	public static String selectRegion(Scanner scanner) throws CancelSearchException {
		String regionSelect = PromptService.acceptInput(scanner); 
		if (regionSelect.strip().equals("")) {
			throw new CancelSearchException();
		}
		return regionSelect;
	}
	
	public static void displayRegionList(List<Region> regionList) {
		DisplayService.displayMessage("region-prompt");
		for (int i = 0; i < regionList.size(); i++) {				
			DisplayService.displayListLine(i + 1, regionList.get(i).getName());
		}
		DisplayService.displayMessage("display-string", "");
	}
	
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
	
	public static <T extends GeographicEntity> List<T> copyListSorted(List<T> list, Comparator<T> comparator) {
		List<T> copy = new ArrayList<>(list);
		Collections.sort(copy, comparator);
		return copy;
	}
	
}
