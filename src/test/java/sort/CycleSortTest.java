package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class CycleSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(CycleSort.class, classes);
	}
}
