package search;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import search.util.SearchUtil;

public class TernarySearchTest extends SearchUtil{

	@Test
	public void ternarySearchTenIntsAscendingTest() {
		Integer[] arrayToSearch = initIntegerList(TEN, Ordenation.ASCENDING);
		for(int i = 0; i < TEN; i++) {
			Integer searchNumber = random.nextInt(TEN - 1);
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);


		}
	}

	@Test
	public void ternarySearchOneThousandIntsAscendingTest() {
		Integer[] arrayToSearch = initIntegerList(ONETHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Integer searchNumber = random.nextInt(ONETHOUSAND - 1);
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchHundredThousandIntsAscendingTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchTenIntsDescendingTest() {
		Integer[] arrayToSearch = initIntegerList(TEN, Ordenation.DESCENDING);
		for(int i = 0; i < TEN; i++) {
			Integer searchNumber = random.nextInt(TEN - 1);
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchOneThousandIntsDescendingTest() {
		Integer[] arrayToSearch = initIntegerList(ONETHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Integer searchNumber = random.nextInt(ONETHOUSAND - 1);
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchHundredThousandIntsDescendingTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchTenDoublesAscendingTest() {
		Double[] arrayToSearch = initDoubleList(TEN, Ordenation.ASCENDING);
		for(int i = 0; i < TEN; i++) {
			Double searchNumber = random.nextInt(TEN) / (double) TEN;
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchOneThousandDoublesAscendingTest() {
		Double[] arrayToSearch = initDoubleList(ONETHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Double searchNumber = random.nextInt(ONETHOUSAND) / (double) ONETHOUSAND;
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchHundredThousandDoublesAscendingTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Double searchNumber = random.nextInt(HUNDREDTHOUSAND) / (double) HUNDREDTHOUSAND;
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchTenDoublesDescendingTest() {
		Double[] arrayToSearch = initDoubleList(TEN, Ordenation.DESCENDING);
		for(int i = 0; i < TEN; i++) {
			Double searchNumber = random.nextInt(TEN) / (double) TEN;
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchOneThousandDoublesDescendingTest() {
		Double[] arrayToSearch = initDoubleList(ONETHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Double searchNumber = random.nextInt(ONETHOUSAND) / (double) ONETHOUSAND;
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchHundredThousandDoublesDescendingTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Double searchNumber = random.nextInt(HUNDREDTHOUSAND) / (double) HUNDREDTHOUSAND;
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	//	for(int j = 0;j < (TEN); j++)
	//		System.out.println(arrayToSearch[j]);
	//	System.out.println("  " + searchPosition + "   " + searchNumber +" y el index " + index);

	@Test
	public void ternarySearchTenIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(TEN, Ordenation.RANDOM);
		for(int i = 0; i < TEN; i++) {
			int searchPosition = random.nextInt(TEN - 1);
			Integer searchNumber = arrayToSearch[searchPosition];
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchOneThousandIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(ONETHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < ONETHOUSAND; i++) {
			int searchPosition = random.nextInt(ONETHOUSAND - 1);
			Integer searchNumber = arrayToSearch[searchPosition];
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchHundredThousandIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			int searchPosition = random.nextInt(HUNDREDTHOUSAND - 1);
			Integer searchNumber = arrayToSearch[searchPosition];
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchTenDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(TEN, Ordenation.RANDOM);
		for(int i = 0; i < TEN; i++) {
			int searchPosition = random.nextInt(TEN - 1);
			Double searchNumber = arrayToSearch[searchPosition];
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchOneThousandDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(ONETHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < ONETHOUSAND; i++) {
			int searchPosition = random.nextInt(ONETHOUSAND - 1);
			Double searchNumber = arrayToSearch[searchPosition];
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchHundredThousandDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			int searchPosition = random.nextInt(HUNDREDTHOUSAND - 1);
			Double searchNumber = arrayToSearch[searchPosition];
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchUnkwonwHundredThousandIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchUnkwonwHundredThousandDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Double searchNumber = random.nextDouble();
			int index = TernarySearch.ternarySearch(arrayToSearch, searchNumber);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void ternarySearchStringTest() {
		String[] stringToSearch = initStringList();
		Arrays.sort(stringToSearch);
		assertEquals(Arrays.binarySearch(stringToSearch, "abcdefghijklmnñopqrstuvwxyz"),
				TernarySearch.ternarySearch(stringToSearch, "abcdefghijklmnñopqrstuvwxyz"));
		assertEquals(Arrays.binarySearch(stringToSearch, ""),
				TernarySearch.ternarySearch(stringToSearch, ""));

		assertEquals(Arrays.binarySearch(stringToSearch, " "),
				TernarySearch.ternarySearch(stringToSearch, " "));

		assertEquals(Arrays.binarySearch(stringToSearch, "12"),
				TernarySearch.ternarySearch(stringToSearch, "12"));

		assertEquals(Arrays.binarySearch(stringToSearch, "#"),
				TernarySearch.ternarySearch(stringToSearch, "#"));

		assertEquals(Arrays.binarySearch(stringToSearch, "ñÑñÑñÑ"),
				TernarySearch.ternarySearch(stringToSearch, "ñÑñÑñÑ"));

		assertEquals(Arrays.binarySearch(stringToSearch, "palabra"),
				TernarySearch.ternarySearch(stringToSearch, "palabra"));

		assertEquals(Arrays.binarySearch(stringToSearch, "si estoy"),
				TernarySearch.ternarySearch(stringToSearch, "si estoy"));
	}
}
