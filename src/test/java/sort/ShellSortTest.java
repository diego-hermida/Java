package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class ShellSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(ShellSort.class, classes);
	}
}
