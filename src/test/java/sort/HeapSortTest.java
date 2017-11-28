package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class HeapSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(HeapSort.class, classes);
	}
}
