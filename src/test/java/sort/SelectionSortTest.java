package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class SelectionSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(SelectionSort.class, classes);
	}
}
