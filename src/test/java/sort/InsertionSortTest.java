package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class InsertionSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(InsertionSort.class, classes);
	}
}
