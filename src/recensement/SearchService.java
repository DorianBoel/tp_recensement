package recensement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchService {
	
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
