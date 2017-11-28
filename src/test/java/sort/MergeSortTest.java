package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class MergeSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(MergeSort.class, classes);
	}
}