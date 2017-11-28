package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class BinaryTreeSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(BinaryTreeSort.class, classes);
	}
}
