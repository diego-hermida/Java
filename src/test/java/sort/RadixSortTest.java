package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class RadixSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.INTEGER };
		setSortingAlgorithm(RadixSort.class, classes);
	}
}
