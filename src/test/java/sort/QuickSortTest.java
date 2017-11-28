package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class QuickSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(QuickSort.class, classes);
	}
}
