package search;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import search.util.SearchUtil;

public class LinearSearchTest extends SearchUtil{

	@Test
	public void linearSearchTenIntsAscendingTest() {
		Integer[] arrayToSearch = initIntegerList(TEN, Ordenation.ASCENDING);
		for(int i = 0; i < TEN; i++) {
			Integer searchNumber = random.nextInt(TEN - 1);
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);

		}
	}

	@Test
	public void linearSearchOneThousandIntsAscendingTest() {
		Integer[] arrayToSearch = initIntegerList(ONETHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Integer searchNumber = random.nextInt(ONETHOUSAND - 1);
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchHundredThousandIntsAscendingTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchTenIntsDescendingTest() {
		Integer[] arrayToSearch = initIntegerList(TEN, Ordenation.DESCENDING);
		for(int i = 0; i < TEN; i++) {
			Integer searchNumber = random.nextInt(TEN - 1);
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchOneThousandIntsDescendingTest() {
		Integer[] arrayToSearch = initIntegerList(ONETHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Integer searchNumber = random.nextInt(ONETHOUSAND - 1);
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchHundredThousandIntsDescendingTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchTenDoublesAscendingTest() {
		Double[] arrayToSearch = initDoubleList(TEN, Ordenation.ASCENDING);
		for(int i = 0; i < TEN; i++) {
			Double searchNumber = random.nextInt(TEN) / (double) TEN;
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchOneThousandDoublesAscendingTest() {
		Double[] arrayToSearch = initDoubleList(ONETHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Double searchNumber = random.nextInt(ONETHOUSAND) / (double) ONETHOUSAND;
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchHundredThousandDoublesAscendingTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Double searchNumber = random.nextInt(HUNDREDTHOUSAND) / (double) HUNDREDTHOUSAND;
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchTenDoublesDescendingTest() {
		Double[] arrayToSearch = initDoubleList(TEN, Ordenation.DESCENDING);
		for(int i = 0; i < TEN; i++) {
			Double searchNumber = random.nextInt(TEN) / (double) TEN;
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchOneThousandDoublesDescendingTest() {
		Double[] arrayToSearch = initDoubleList(ONETHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Double searchNumber = random.nextInt(ONETHOUSAND) / (double) ONETHOUSAND;
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchHundredThousandDoublesDescendingTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Double searchNumber = random.nextInt(HUNDREDTHOUSAND) / (double) HUNDREDTHOUSAND;
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	//	for(int j = 0;j < (TEN); j++)
	//		System.out.println(arrayToSearch[j]);
	//	System.out.println("  " + searchPosition + "   " + searchNumber +" y el index " + index);

	@Test
	public void linearSearchTenIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(TEN, Ordenation.RANDOM);
		for(int i = 0; i < TEN; i++) {
			int searchPosition = random.nextInt(TEN - 1);
			Integer searchNumber = arrayToSearch[searchPosition];
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchOneThousandIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(ONETHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < ONETHOUSAND; i++) {
			int searchPosition = random.nextInt(ONETHOUSAND - 1);
			Integer searchNumber = arrayToSearch[searchPosition];
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchHundredThousandIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			int searchPosition = random.nextInt(HUNDREDTHOUSAND - 1);
			Integer searchNumber = arrayToSearch[searchPosition];
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchTenDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(TEN, Ordenation.RANDOM);
		for(int i = 0; i < TEN; i++) {
			int searchPosition = random.nextInt(TEN - 1);
			Double searchNumber = arrayToSearch[searchPosition];
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchOneThousandDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(ONETHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < ONETHOUSAND; i++) {
			int searchPosition = random.nextInt(ONETHOUSAND - 1);
			Double searchNumber = arrayToSearch[searchPosition];
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchHundredThousandDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			int searchPosition = random.nextInt(HUNDREDTHOUSAND - 1);
			Double searchNumber = arrayToSearch[searchPosition];
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchUnkwonwHundredThousandIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchUnkwonwHundredThousandDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Double searchNumber = random.nextDouble();
			int index = LinearSearch.linearSearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void linearSearchStringTest() {
		String[] stringToSearch = initStringList();
		Arrays.sort(stringToSearch);
		assertEquals(Arrays.binarySearch(stringToSearch, "abcdefghijklmnñopqrstuvwxyz"),
				LinearSearch.linearSearch(stringToSearch, "abcdefghijklmnñopqrstuvwxyz"));
		assertEquals(Arrays.binarySearch(stringToSearch, ""),
				LinearSearch.linearSearch(stringToSearch, ""));

		assertEquals(Arrays.binarySearch(stringToSearch, " "),
				LinearSearch.linearSearch(stringToSearch, " "));

		assertEquals(Arrays.binarySearch(stringToSearch, "12"),
				LinearSearch.linearSearch(stringToSearch, "12"));

		assertEquals(Arrays.binarySearch(stringToSearch, "#"),
				LinearSearch.linearSearch(stringToSearch, "#"));

		assertEquals(Arrays.binarySearch(stringToSearch, "ñÑñÑñÑ"),
				LinearSearch.linearSearch(stringToSearch, "ñÑñÑñÑ"));

		assertEquals(Arrays.binarySearch(stringToSearch, "palabra"),
				LinearSearch.linearSearch(stringToSearch, "palabra"));

		assertEquals(Arrays.binarySearch(stringToSearch, "si estoy"),
				LinearSearch.linearSearch(stringToSearch, "si estoy"));
	}


}
