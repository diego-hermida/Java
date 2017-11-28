package sort;

import org.junit.Before;

import sort.util.GenericSortTest;

public class CocktailShakerSortTest extends GenericSortTest {

	@Before
	public void setUp() {
		final TestClasses[] classes = { TestClasses.ALL };
		setSortingAlgorithm(CocktailShakerSort.class, classes);
	}
}