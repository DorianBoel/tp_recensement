package recensement.utils.comparators;

import java.util.Comparator;

import recensement.entities.instanced.Department;

public class DepartmentPopulationComparator implements Comparator<Department> {

	// Constructor
	public DepartmentPopulationComparator() {
		
	}

	// Instance methods
	@Override
	public int compare(Department department1, Department department2) {
		return Integer.compare(department1.getPopulation(), department2.getPopulation()) * -1;
	}

}
