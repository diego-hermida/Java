package sort.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;

import sort.Sorteable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class GenericSortTest {

	/**
	 * Any sorting scenario lasting more than 2 minutes will be automatically
	 * aborted.
	 */
	private static final int TEST_TIMEOUT = 120000;

	/**
	 * Constants used for testing.
	 */
	private static final int POSITIVE_INT = 1;
	private static final int NEGATIVE_INT = -1;
	private static final int IDENTITY_INT = 0;
	private static final double POSITIVE_DOUBLE = 1.0;
	private static final double NEGATIVE_DOUBLE = -1.0;
	private static final double IDENTITY_DOUBLE = 0.0;
	private static final int MAX_STRING_SIZE = 32;
	private static final String POSITIVE_STRING = "ABCDEFabcdefg";
	private static final String IDENTITY_STRING = "";
	private static final String CHARACTER_SET = "abcdefghijklmnopqrstuvwxyz"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final ExamResult IDENTITY_OBJECT = new ExamResult(5.0,
			"John Doe", false);

	/**
	 * Size of lists
	 */
	private static final int SHORT_LIST_SIZE = 10;
	private static final int MEDIUM_LIST_SIZE = 1000;
	private static final int LARGE_LIST_SIZE = 100000;

	/**
	 * Sorting algorithm instances. The sorting algorithm will be tested with:
	 * Integers, Doubles, Strings and custom Objects.
	 */
	private Sorteable<Integer> sortingAlgorithmForIntegers;
	private Sorteable<Double> sortingAlgorithmForDoubles;
	private Sorteable<String> sortingAlgorithmForStrings;
	private Sorteable<ExamResult> sortingAlgorithmForObjects;

	/**
	 * Random generator. Single instance for all tests.
	 */
	private final Random random = new Random();

	/**
	 * Lists to be sorted. Lists are duplicated, since algorithms sort in-place.
	 */
	private List<Integer> integerElements;
	private List<Double> doubleElements;
	private List<String> stringElements;
	private List<ExamResult> objectElements;
	private List<Integer> integerElementsCopy;
	private List<Double> doubleElementsCopy;
	private List<String> stringElementsCopy;
	private List<ExamResult> objectElementsCopy;

	/**
	 * Allows the GenericSortTest to skip some classes. For example, if an
	 * algorithm is only suitable for Integers, <code>TestClasses.INTEGER</code>
	 * should be passed as a parameter at the <code>setSortingAlgorithm</code>
	 * method.
	 */
	public enum TestClasses {
		INTEGER, DOUBLE, STRING, OBJECT, ALL;
	}

	/**
	 * Wraps the size of a list, using the constants defined at the top of this
	 * class. The actual size can be retrieved by calling the
	 * <code>getValue</code> method.
	 */
	private enum ListSize {
		EMPTY, SHORT, MEDIUM, LARGE;

		/**
		 * Retrieves the size of a list, depending on the <code>ListSize</code>
		 * instance.
		 *
		 * @return An <code>int</code>.
		 */
		public int getValue() {
			return equals(EMPTY) ? 0
					: (equals(SHORT) ? GenericSortTest.SHORT_LIST_SIZE
							: (equals(MEDIUM) ? GenericSortTest.MEDIUM_LIST_SIZE
									: GenericSortTest.LARGE_LIST_SIZE));
		}
	}

	/**
	 * Wraps value equivalence classes.
	 */
	private enum ValueTypes {
		SAME_POSITIVE, SAME_NEGATIVE, RANDOM_POSITIVE, RANDOM_NEGATIVE, RANDOM, IDENTITY;
	}

	@Rule
	/**
	 * Prints an error message to <code>stderr</code> if test failed, and a line
	 * separator if the test has succeeded.
	 */
	public TestWatcher watchman = new TestWatcher() {
		@Override
		protected void failed(final Throwable e,
				final Description description) {
			final String message = (e.toString().length() > 5000)
					? e.toString().substring(0, 5000) + " [...]"
					: e.toString();
			System.out.println(
					"[ERROR] Test scenario has failed. " + "Cause: " + message);
			System.out.println("[ERROR] See the JUnit test result for a more "
					+ "detailed description of the error.\n");
			System.out.flush();
		}

		@Override
		protected void succeeded(final Description description) {
			System.out.println();
			System.out.flush();
		}
	};

	/**
	 * Initializes all lists with certain values.
	 *
	 * @param size
	 *            The size of the lists.
	 * @param numberType
	 *            This parameter will determine which values the list will
	 *            contain.
	 */
	private void initializeLists(final ListSize size,
			final ValueTypes valueType) {
		final long startTime = System.nanoTime();

		final int elementsSize = size.getValue();
		integerElements = new ArrayList<>(elementsSize);
		doubleElements = new ArrayList<>(elementsSize);
		stringElements = new ArrayList<>(elementsSize);
		objectElements = new ArrayList<>(elementsSize);

		switch (valueType) {
		/**
		 * This case generates lists with the same values. If the lists are
		 * numeric, positive values are used (i.e. greater than 0). Since the
		 * <code>ValueTypes.IDENTITY</code> covers this scenario for objects,
		 * that list is not initialized.
		 */
		case SAME_POSITIVE: {
			objectElements = null;
			for (int i = 0; i < elementsSize; i++) {
				integerElements.add(GenericSortTest.POSITIVE_INT);
				doubleElements.add(GenericSortTest.POSITIVE_DOUBLE);
				stringElements.add(GenericSortTest.POSITIVE_STRING);
			}
			break;
		}
		/**
		 * This case generates lists with the same values. If the lists are
		 * numeric, negative values are used (i.e. less than 0). This scenario
		 * does not have sense for Strings and Objects, so those lists are not
		 * initialized.
		 */
		case SAME_NEGATIVE: {
			stringElements = null;
			objectElements = null;
			for (int i = 0; i < elementsSize; i++) {
				integerElements.add(GenericSortTest.NEGATIVE_INT);
				doubleElements.add(GenericSortTest.NEGATIVE_DOUBLE);
			}
			break;
		}
		/**
		 * This case generates lists with the random values. If the lists are
		 * numeric, positive values are used (i.e. greater than 0). Since the
		 * <code>ValueTypes.RANDOM</code> covers this scenario for objects, that
		 * list is not initialized.
		 */
		case RANDOM_POSITIVE: {
			objectElements = null;
			for (int i = 0; i < elementsSize; i++) {
				integerElements.add(random.nextInt(Integer.MAX_VALUE));
				doubleElements.add(random.nextDouble() * Double.MAX_VALUE);
				stringElements.add(generateRandomString(true));
			}
			break;
		}
		/**
		 * This case generates lists with the random values. If the lists are
		 * numeric, negative values are used (i.e. less than 0). This scenario
		 * does not have sense for Strings and Objects, so those lists are not
		 * initialized.
		 */
		case RANDOM_NEGATIVE: {
			stringElements = null;
			objectElements = null;
			for (int i = 0; i < elementsSize; i++) {
				integerElements.add(random.nextInt(Integer.MAX_VALUE) * -1);
				doubleElements.add(random.nextDouble() * Double.MIN_VALUE);
			}
			break;
		}
		/**
		 * This case generates lists with the random values. If the lists are
		 * numeric, both positive and negative values are used. For
		 * <code>String</code> values, random strings with variable length are
		 * used. For <code>ExamResult</code> values, random objects are created,
		 * using a random generator to fill its attributes with random values.
		 */
		case RANDOM: {
			for (int i = 0; i < elementsSize; i++) {
				integerElements.add(random.nextInt(Integer.MAX_VALUE)
						* (random.nextBoolean() ? 1 : -1));
				doubleElements.add(random.nextDouble() * Double.MAX_VALUE
						* (random.nextBoolean() ? 1 : -1));
				stringElements.add(generateRandomString(false));
				objectElements.add(new ExamResult(random.nextDouble() * 10.0,
						generateRandomString(false), random.nextBoolean()));
			}
			break;
		}
		/**
		 * This case generates lists with the same value. The selected value is
		 * called <code>IDENTITY</code>, and equals <code>0</code> for numeric
		 * lists, the empty String (i.e. <code>""</code>) for the String list,
		 * and a default <code>ExamResult</code> for the Object list. Since the
		 * <code>IDENTITY</code> value for <code>ExamResult</code> is arbitrary,
		 * this scenario covers the <code>SAME_POSITIVE<code> scenario for
		 * objects.
		 */
		default: { // case IDENTITY
			for (int i = 0; i < elementsSize; i++) {
				integerElements.add(GenericSortTest.IDENTITY_INT);
				doubleElements.add(GenericSortTest.IDENTITY_DOUBLE);
				stringElements.add(GenericSortTest.IDENTITY_STRING);
				objectElements.add(GenericSortTest.IDENTITY_OBJECT.clone());
			}
			break;
		}
		}
		integerElementsCopy = (integerElements == null) ? null
				: new ArrayList<>(integerElements);
		doubleElementsCopy = (doubleElements == null) ? null
				: new ArrayList<>(doubleElements);
		stringElementsCopy = (stringElements == null) ? null
				: new ArrayList<>(stringElements);
		objectElementsCopy = (objectElements == null) ? null
				: new ArrayList<>(objectElements);

		System.out.println("[INFO] Data initialization for size: " + size
				+ " and scenario: " + valueType + " performed in "
				+ ((System.nanoTime() - startTime) / 1000000) + " ms.");
	}

	/**
	 * Performs sort operations for the list that do have been initialized.
	 */
	private void performSortOperations() {
		long startTime;
		long collectionsSortTime;
		if ((sortingAlgorithmForIntegers != null)
				&& (integerElements != null)) {
			startTime = System.nanoTime();
			Collections.sort(integerElementsCopy);
			collectionsSortTime = (System.nanoTime() - startTime) / 1000000;
			startTime = System.nanoTime();
			sortingAlgorithmForIntegers.sort(integerElements);
			System.out.println("[INFO] [Integer]  Collections.sort: "
					+ collectionsSortTime + " ms    Tested algorithm: "
					+ ((System.nanoTime() - startTime) / 1000000) + " ms");
		}
		if ((sortingAlgorithmForDoubles != null) && (doubleElements != null)) {
			startTime = System.nanoTime();
			Collections.sort(doubleElementsCopy);
			collectionsSortTime = (System.nanoTime() - startTime) / 1000000;
			startTime = System.nanoTime();
			sortingAlgorithmForDoubles.sort(doubleElements);
			System.out.println("[INFO] [Double]   Collections.sort: "
					+ collectionsSortTime + " ms    Tested algorithm: "
					+ ((System.nanoTime() - startTime) / 1000000) + " ms");
		}
		if ((sortingAlgorithmForStrings != null) && (stringElements != null)) {
			startTime = System.nanoTime();
			Collections.sort(stringElementsCopy);
			collectionsSortTime = (System.nanoTime() - startTime) / 1000000;
			startTime = System.nanoTime();
			sortingAlgorithmForStrings.sort(stringElements);
			System.out.println("[INFO] [String]   Collections.sort: "
					+ collectionsSortTime + " ms    Tested algorithm: "
					+ ((System.nanoTime() - startTime) / 1000000) + " ms");
		}
		if ((sortingAlgorithmForObjects != null) && (objectElements != null)) {
			startTime = System.nanoTime();
			Collections.sort(objectElementsCopy);
			collectionsSortTime = (System.nanoTime() - startTime) / 1000000;
			startTime = System.nanoTime();
			sortingAlgorithmForObjects.sort(objectElements);
			System.out.println("[INFO] [Object]   Collections.sort: "
					+ collectionsSortTime + " ms    Tested algorithm: "
					+ ((System.nanoTime() - startTime) / 1000000) + " ms");
		}
	}

	/**
	 * Performs sort operations for all lists, assuming that equality
	 * comparisons of <code>null</code> against <code>null</code> are
	 * <code>true</code>.
	 */
	private void performAssertions() {
		final long startTime = System.nanoTime();
		Assert.assertEquals(integerElementsCopy, integerElements);
		Assert.assertEquals(doubleElementsCopy, doubleElements);
		Assert.assertEquals(stringElementsCopy, stringElements);
		Assert.assertEquals(objectElementsCopy, objectElements);
		System.out.println("[INFO] Assertions were performed in "
				+ ((System.nanoTime() - startTime) / 1000000) + " ms.");
	}

	/**
	 * Sets the Sorting Algorithm for this tester class. Such algorithm must
	 * implement the <code>Sorteable</code> interface.
	 *
	 * @param sortingAlgorithm
	 *            A <code>Class</code> object.
	 * @throws IllegalArgumentException
	 *             If <code>sortingAlgorithm</code> class does not implement the
	 *             <code>Sorteable</code> interface.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setSortingAlgorithm(final Class sortingAlgorithm,
			final TestClasses[] cls) {
		if (!(Sorteable.class.isAssignableFrom(sortingAlgorithm)))
			throw new IllegalArgumentException(
					"Sorting algorithm: " + sortingAlgorithm.getName()
							+ " does not implement the Sorteable interface.");
		else {
			final List<TestClasses> classes = Arrays.asList(cls);
			try {
				System.out.println("[INFO] Testing sorting algorithm: "
						+ sortingAlgorithm.getName());
				if (classes.contains(TestClasses.INTEGER)
						|| classes.contains(TestClasses.ALL))
					sortingAlgorithmForIntegers = (Sorteable<Integer>) sortingAlgorithm
							.newInstance();
				if (classes.contains(TestClasses.DOUBLE)
						|| classes.contains(TestClasses.ALL))
					sortingAlgorithmForDoubles = (Sorteable<Double>) sortingAlgorithm
							.newInstance();
				if (classes.contains(TestClasses.STRING)
						|| classes.contains(TestClasses.ALL))
					sortingAlgorithmForStrings = (Sorteable<String>) sortingAlgorithm
							.newInstance();
				if (classes.contains(TestClasses.OBJECT)
						|| classes.contains(TestClasses.ALL))
					sortingAlgorithmForObjects = (Sorteable<ExamResult>) sortingAlgorithm
							.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(
						"Test intitialization could not be performed.", e);
			}
		}
	}

	/**
	 * Generates a random <code>String</code> with variable length.
	 *
	 * @param fixedLength
	 *            If <code>true</code>, <code>String</code> length will be fixed
	 *            to <code>MAX_STRING_SIZE</code>. Otherwise,
	 *            <code>String</code> length will be between 0 and
	 *            <code>MAX_STRING_SIZE</code>.
	 * @return The randomly generated <code>String</code>.
	 */
	private String generateRandomString(final boolean fixedLength) {

		final StringBuffer randStr = new StringBuffer();
		final int length = (fixedLength) ? GenericSortTest.MAX_STRING_SIZE
				: random.nextInt(GenericSortTest.MAX_STRING_SIZE);
		for (int i = 0; i < length; i++) {
			final int number = random
					.nextInt(GenericSortTest.CHARACTER_SET.length());
			final char ch = GenericSortTest.CHARACTER_SET.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnEmptyLists() {
		initializeLists(ListSize.EMPTY, ValueTypes.IDENTITY);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnShortListsFilledWithEqualPositives() {
		initializeLists(ListSize.SHORT, ValueTypes.SAME_POSITIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnShortListsFilledWithEqualNegatives() {
		initializeLists(ListSize.SHORT, ValueTypes.SAME_NEGATIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnShortListsFilledWithRandomPositives() {
		initializeLists(ListSize.SHORT, ValueTypes.RANDOM_POSITIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnShortListsFilledWithRandomNegatives() {
		initializeLists(ListSize.SHORT, ValueTypes.RANDOM_NEGATIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnShortListsFilledWithRandomValues() {
		initializeLists(ListSize.SHORT, ValueTypes.RANDOM);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnShortListsFilledWithIdentityValues() {
		initializeLists(ListSize.SHORT, ValueTypes.IDENTITY);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnMediumListsFilledWithEqualPositives() {
		initializeLists(ListSize.MEDIUM, ValueTypes.SAME_POSITIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnMediumListsFilledWithEqualNegatives() {
		initializeLists(ListSize.MEDIUM, ValueTypes.SAME_NEGATIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnMediumListsFilledWithRandomPositives() {
		initializeLists(ListSize.MEDIUM, ValueTypes.RANDOM_POSITIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnMediumListsFilledWithRandomNegatives() {
		initializeLists(ListSize.MEDIUM, ValueTypes.RANDOM_NEGATIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnMediumListsFilledWithRandomValues() {
		initializeLists(ListSize.MEDIUM, ValueTypes.RANDOM);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnMediumListsFilledWithIdentityValues() {
		initializeLists(ListSize.MEDIUM, ValueTypes.IDENTITY);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnLargeListsFilledWithEqualPositives() {
		initializeLists(ListSize.LARGE, ValueTypes.SAME_POSITIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnLargeListsFilledWithEqualNegatives() {
		initializeLists(ListSize.LARGE, ValueTypes.SAME_NEGATIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnLargeListsFilledWithRandomPositives() {
		initializeLists(ListSize.LARGE, ValueTypes.RANDOM_POSITIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnLargeListsFilledWithRandomNegatives() {
		initializeLists(ListSize.LARGE, ValueTypes.RANDOM_NEGATIVE);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnLargeListsFilledWithRandomValues() {
		initializeLists(ListSize.LARGE, ValueTypes.RANDOM);
		performSortOperations();
		performAssertions();
	}

	@Test(timeout = GenericSortTest.TEST_TIMEOUT)
	public void testSortingAlgorithmOnLargeListsFilledWithIdentityValues() {
		initializeLists(ListSize.LARGE, ValueTypes.IDENTITY);
		performSortOperations();
		performAssertions();
	}
}
