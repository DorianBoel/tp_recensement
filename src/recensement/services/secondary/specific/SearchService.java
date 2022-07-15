package recensement.services.secondary.specific;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import recensement.entities.instanced.City;
import recensement.entities.instanced.Department;
import recensement.utils.StringUtils;
import recensement.utils.comparators.CityNameComparator;

/**
 * Non-instanciable class containing methods used to
 * search through lists of registered census data for
 * matching results based on a given search term.
 * 
 * @author DorianBoel
 */
public final class SearchService {
	
	/**
	 * Don't let anyone instantiate this class.
	 */
	private SearchService() {}
	
	/**
	 * Searches in the city data list for
	 * any cities whose name matches the given
	 * search term.
	 * First searches for an exact match, then searches for any
	 * city name starting with the search term.
	 * Then returns a list containing all matching results
	 * 
	 * @param term The term to find within the existing city names.
	 * @param list The list of cities to search in
	 * @return A list containing all city instances with
	 * name matching the search term
	 */
	public static List<City> findCityByName(String term, List<City> list) {
		List<City>
			exactMatch = new ArrayList<>(),
			startMatch = new ArrayList<>(),
			resultList = new ArrayList<>()
		;
		String termSanit = StringUtils.sanitize(term);
		for (City city : list) {
			if (StringUtils.matchName(termSanit, city.getName(), "exact")) {
				exactMatch.add(city);
				continue;
			}
			if (StringUtils.matchName(termSanit, city.getName(), "start")) {
				startMatch.add(city);
			}
		}
		Collections.sort(startMatch, new CityNameComparator());
		resultList.addAll(exactMatch);
		resultList.addAll(startMatch);
		return resultList;
	}
	
	/**
	 * Searches in the department list and returns the
	 * department whose code matches the given code.
	 * 
	 * @param code The code of the department to find
	 * @param list The list of department to search in
	 * @return The department matching the given code,
	 * or null if no match was found.
	 */
	public static Department findDepartment(String code, List<Department> list) {
		String codeS = code.strip();
		if (codeS.length() == 1) {
			codeS = 0 + codeS;
		}
		for (Department department : list) {
			if (codeS.equals(department.getCode())) {
				return department;
			}
		}
		return null;
	}
	
}
