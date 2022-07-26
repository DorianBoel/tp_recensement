package recensement.utils.comparators;

import java.util.Comparator;

import recensement.entities.instanced.Department;

/**
 * Comparator class used to sort {@link Department departments}
 * using their total populations.
 * 
 * @author DorianBoel
 */
public class DepartmentPopulationComparator implements Comparator<Department> {

	/**
	 * Constructor for {@link #DepartmentPopulationComparator()}.
	 * Creates a new DepartmentPopulationComparator.
	 */
	public DepartmentPopulationComparator() {}

	/**
	 * Compares the population values of two given departments.
	 * 
	 * @param department1 The first department to compare
	 * @param department2 The second department to compare
	 * @return An integer value based on the comparison result
	 */
	@Override
	public int compare(Department department1, Department department2) {
		return Integer.compare(department1.getPopulation(), department2.getPopulation()) * -1;
	}

}
