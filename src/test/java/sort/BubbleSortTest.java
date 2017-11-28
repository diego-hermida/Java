package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class BubbleSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(BubbleSort.class, classes);
	}
}