package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class CountingSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(CountingSort.class, classes);
	}
}
