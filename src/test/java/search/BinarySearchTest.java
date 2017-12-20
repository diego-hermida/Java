package search;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import search.util.SearchUtil;



public class BinarySearchTest extends SearchUtil{

	@Test
	public void binarySearchTenIntsAscendingTest() {
		Integer[] arrayToSearch = initIntegerList(TEN, Ordenation.ASCENDING);
		for(int i = 0; i < TEN; i++) {
			Integer searchNumber = random.nextInt(TEN - 1);
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, TEN - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchOneThousandIntsAscendingTest() {
		Integer[] arrayToSearch = initIntegerList(ONETHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Integer searchNumber = random.nextInt(ONETHOUSAND - 1);
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, ONETHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchHundredThousandIntsAscendingTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, HUNDREDTHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchTenIntsDescendingTest() {
		Integer[] arrayToSearch = initIntegerList(TEN, Ordenation.DESCENDING);
		for(int i = 0; i < TEN; i++) {
			Integer searchNumber = random.nextInt(TEN - 1);
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, TEN - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchOneThousandIntsDescendingTest() {
		Integer[] arrayToSearch = initIntegerList(ONETHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Integer searchNumber = random.nextInt(ONETHOUSAND - 1);
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, ONETHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchHundredThousandIntsDescendingTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, HUNDREDTHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchTenDoublesAscendingTest() {
		Double[] arrayToSearch = initDoubleList(TEN, Ordenation.ASCENDING);
		for(int i = 0; i < TEN; i++) {
			Double searchNumber = random.nextInt(TEN) / (double) TEN;
			int index = BinarySearch.BS(arrayToSearch, searchNumber,
					0, TEN - 1);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchOneThousandDoublesAscendingTest() {
		Double[] arrayToSearch = initDoubleList(ONETHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Double searchNumber = random.nextInt(ONETHOUSAND) / (double) ONETHOUSAND;
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, ONETHOUSAND - 1);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchHundredThousandDoublesAscendingTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.ASCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Double searchNumber = random.nextInt(HUNDREDTHOUSAND) / (double) HUNDREDTHOUSAND;
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, HUNDREDTHOUSAND - 1);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchTenDoublesDescendingTest() {
		Double[] arrayToSearch = initDoubleList(TEN, Ordenation.DESCENDING);
		for(int i = 0; i < TEN; i++) {
			Double searchNumber = random.nextInt(TEN) / (double) TEN;
			int index = BinarySearch.BS(arrayToSearch, searchNumber,
					0, TEN - 1);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchOneThousandDoublesDescendingTest() {
		Double[] arrayToSearch = initDoubleList(ONETHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Double searchNumber = random.nextInt(ONETHOUSAND) / (double) ONETHOUSAND;
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, ONETHOUSAND - 1);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchHundredThousandDoublesDescendingTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.DESCENDING);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Double searchNumber = random.nextInt(HUNDREDTHOUSAND) / (double) HUNDREDTHOUSAND;
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, HUNDREDTHOUSAND - 1);
			comprobationForDouble(index, searchNumber, arrayToSearch);
		}
	}

	//	for(int j = 0;j < (TEN); j++)
	//		System.out.println(arrayToSearch[j]);
	//	System.out.println("  " + searchPosition + "   " + searchNumber +" y el index " + index);

	@Test
	public void binarySearchTenIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(TEN, Ordenation.RANDOM);
		for(int i = 0; i < TEN; i++) {
			int searchPosition = random.nextInt(TEN - 1);
			Integer searchNumber = arrayToSearch[searchPosition];
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, TEN - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchOneThousandIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(ONETHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < ONETHOUSAND; i++) {
			int searchPosition = random.nextInt(ONETHOUSAND - 1);
			Integer searchNumber = arrayToSearch[searchPosition];
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, ONETHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchHundredThousandIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			int searchPosition = random.nextInt(HUNDREDTHOUSAND - 1);
			Integer searchNumber = arrayToSearch[searchPosition];
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, HUNDREDTHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchTenDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(TEN, Ordenation.RANDOM);
		for(int i = 0; i < TEN; i++) {
			int searchPosition = random.nextInt(TEN - 1);
			Double searchNumber = arrayToSearch[searchPosition];
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, TEN - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchOneThousandDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(ONETHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < ONETHOUSAND; i++) {
			int searchPosition = random.nextInt(ONETHOUSAND - 1);
			Double searchNumber = arrayToSearch[searchPosition];
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, ONETHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchHundredThousandDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			int searchPosition = random.nextInt(HUNDREDTHOUSAND - 1);
			Double searchNumber = arrayToSearch[searchPosition];
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, HUNDREDTHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchUnkwonwHundredThousandIntsRandomTest() {
		Integer[] arrayToSearch = initIntegerList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, HUNDREDTHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchUnkwonwHundredThousandDoublesRandomTest() {
		Double[] arrayToSearch = initDoubleList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Double searchNumber = random.nextDouble();
			int index = BinarySearch.BS(arrayToSearch, searchNumber, 0, HUNDREDTHOUSAND - 1);
			comprobation(index, searchNumber, arrayToSearch);
		}
	}

	@Test
	public void binarySearchStringTest() {
		String[] stringToSearch = initStringList();
		assertEquals(Arrays.binarySearch(stringToSearch, "abcdefghijklmnñopqrstuvwxyz"),
				BinarySearch.BS(stringToSearch, "abcdefghijklmnñopqrstuvwxyz", 0, stringToSearch.length - 1));
		Arrays.sort(stringToSearch);
		assertEquals(Arrays.binarySearch(stringToSearch, ""),
				BinarySearch.BS(stringToSearch, "", 0, stringToSearch.length - 1));

		assertEquals(Arrays.binarySearch(stringToSearch, " "),
				BinarySearch.BS(stringToSearch, " ", 0, stringToSearch.length - 1));

		assertEquals(Arrays.binarySearch(stringToSearch, "12"),
				BinarySearch.BS(stringToSearch, "12", 0, stringToSearch.length - 1));

		assertEquals(Arrays.binarySearch(stringToSearch, "#"),
				BinarySearch.BS(stringToSearch, "#", 0, stringToSearch.length - 1));

		assertEquals(Arrays.binarySearch(stringToSearch, "ñÑñÑñÑ"),
				BinarySearch.BS(stringToSearch, "ñÑñÑñÑ", 0, stringToSearch.length - 1));

		assertEquals(Arrays.binarySearch(stringToSearch, "palabra"),
				BinarySearch.BS(stringToSearch, "palabra", 0, stringToSearch.length - 1));

		assertEquals(Arrays.binarySearch(stringToSearch, "si estoy"),
				BinarySearch.BS(stringToSearch, "si estoy", 0, stringToSearch.length - 1));
	}
}
