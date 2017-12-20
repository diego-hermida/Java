package search;

import org.junit.Test;

import search.util.SearchUtil;

public class InterpolationSearchTest extends SearchUtil{

	public int[] converIntegerToInt(Integer[] integers) {
		int[] arrayToSearch = new int[integers.length];
		int j=0;
		for (Integer i: integers) {
			arrayToSearch[j] = i;
			j++;
		}
		return arrayToSearch;
	}

	@Test
	public void interpolationSearchTenIntsAscendingTest() {
		Integer[] integers =  initIntegerList(TEN, Ordenation.ASCENDING);
		int[]arrayToSearch = converIntegerToInt(integers);
		for(int i = 0; i < TEN; i++) {
			int searchNumber = random.nextInt(TEN - 1);
			int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
			comprobation(index, new Integer(searchNumber), integers);
		}
	}

	@Test
	public void interpolationSearchOneThousandIntsAscendingTest() {
		Integer[] integers = initIntegerList(ONETHOUSAND, Ordenation.ASCENDING);
		int[]arrayToSearch = converIntegerToInt(integers);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Integer searchNumber = random.nextInt(ONETHOUSAND - 1);
			int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
			comprobation(index, new Integer(searchNumber), integers);
		}
	}

	@Test
	public void interpolationSearchHundredThousandIntsAscendingTest() {
		Integer[] integers = initIntegerList(HUNDREDTHOUSAND, Ordenation.ASCENDING);
		int[]arrayToSearch = converIntegerToInt(integers);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
			comprobation(index, new Integer(searchNumber), integers);
		}
	}

	@Test
	public void interpolationSearchTenIntsDescendingTest() {
		Integer[] integers = initIntegerList(TEN, Ordenation.DESCENDING);
		int[]arrayToSearch = converIntegerToInt(integers);
		for(int i = 0; i < TEN; i++) {
			Integer searchNumber = random.nextInt(TEN - 1);
			int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
			comprobation(index, new Integer(searchNumber), integers);
		}
	}

	@Test
	public void interpolationSearchOneThousandIntsDescendingTest() {
		Integer[] integers = initIntegerList(ONETHOUSAND, Ordenation.DESCENDING);
		int[]arrayToSearch = converIntegerToInt(integers);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Integer searchNumber = random.nextInt(ONETHOUSAND - 1);
			int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
			comprobation(index, new Integer(searchNumber), integers);
		}
	}

	@Test
	public void interpolationSearchHundredThousandIntsDescendingTest() {
		Integer[] integers = initIntegerList(HUNDREDTHOUSAND, Ordenation.DESCENDING);
		int[]arrayToSearch = converIntegerToInt(integers);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
			comprobation(index, new Integer(searchNumber), integers);
		}
	}

	@Test
	public void interpolationSearchTenIntsRandomTest() {
		Integer[] integers = initIntegerList(TEN, Ordenation.RANDOM);
		int[]arrayToSearch = converIntegerToInt(integers);
		for(int i = 0; i < TEN; i++) {
			Integer searchNumber = random.nextInt(TEN - 1);
			int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
			comprobation(index, new Integer(searchNumber), integers);
		}
	}

	@Test
	public void interpolationSearchOneThousandIntsRandomTest() {
		Integer[] integers = initIntegerList(ONETHOUSAND, Ordenation.RANDOM);
		int[]arrayToSearch = converIntegerToInt(integers);
		for(int i = 0; i < ONETHOUSAND; i++) {
			Integer searchNumber = random.nextInt(ONETHOUSAND - 1);
			int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
			comprobation(index, new Integer(searchNumber), integers);
		}
	}

	@Test
	public void interpolationSearchHundredThousandIntsRandomTest() {
		Integer[] integers = initIntegerList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		int[]arrayToSearch = converIntegerToInt(integers);
		for(int i = 0; i < HUNDREDTHOUSAND; i++) {
			Integer searchNumber = random.nextInt(HUNDREDTHOUSAND - 1);
			int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
			comprobation(index, new Integer(searchNumber), integers);
		}
	}

	@Test
	public void nonExistingNumberInterpolationSearchHundredTest() {
		Integer[] integers = initIntegerList(HUNDREDTHOUSAND, Ordenation.RANDOM);
		int[]arrayToSearch = converIntegerToInt(integers);
		Integer searchNumber = -10;
		int index = InterpolationSearch.interpolationSearch(searchNumber, arrayToSearch);
		comprobation(index, new Integer(searchNumber), integers);
	}

}
