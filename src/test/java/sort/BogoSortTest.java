package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class BogoSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(BogoSort.class, classes);
	}
}