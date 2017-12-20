package search.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Random;

public class SearchUtil {


	public enum Ordenation{
		ASCENDING, DESCENDING, RANDOM
	}

	protected final int TEN = 10;
	protected final int ONETHOUSAND = 1000;
	protected final int HUNDREDTHOUSAND = 100000;

	protected final Random random = new Random();

	public Integer[] initIntegerList(int numberOfElements, Ordenation ordenation){
		Integer[] arrayToSearch = new Integer[numberOfElements];
		switch(ordenation) {
		case ASCENDING:{
			for (int i = 0; i < numberOfElements; i++)
				arrayToSearch[i] = i;
			break;
		}
		case DESCENDING: {
			int j = 0;
			for (int i = numberOfElements - 1; i >= 0; i--) {
				arrayToSearch[j] = i;
				j++;
			}
			break;
		}
		case RANDOM: {
			for (int i = 0; i < numberOfElements; i++)
				arrayToSearch[i] = random.nextInt(numberOfElements);
			break;
		}
		}

		return arrayToSearch;
	}

	public Double[] initDoubleList(int numberOfElements, Ordenation ordenation){
		Double[] arrayToSearch = new Double[numberOfElements];
		switch(ordenation) {
		case ASCENDING: {
			for (int i = 0; i < (numberOfElements); i++)
				arrayToSearch[i] = (double)i / (double) numberOfElements;//(Math.round(initDouble * numberOfElements) / (double) numberOfElements);
			//				initDouble = initDouble + (1.0 /numberOfElements);
			//System.out.println(initDouble + ((double) 1/(double) numberOfElements));
			break;
		}
		case DESCENDING: {
			int j = 0;
			for (int i = numberOfElements; i > 0; i--) {
				arrayToSearch[j] = (double) i / (double) numberOfElements;
				j++;
			}
			break;
		}
		case RANDOM: {
			for (int i = 0; i < numberOfElements; i++)
				arrayToSearch[i] = random.nextDouble();
			break;
		}
		}

		return arrayToSearch;
	}

	public String[] initStringList() {
		String[] stringToSearch = {"abcdefghijklmnñopqrstuvwxyz", "", "asdfgascaetqr","a", "s", "si estoy", " ", "12", "#", "ñÑñÑñÑ", "palabra"};
		return stringToSearch;
	}

	public <T> void comprobation(int index, T searchNumber, T[] arrayToSearch) {
		if (index != -1)
			assertEquals(arrayToSearch[index], searchNumber);
		else
			assertFalse(Arrays.asList(arrayToSearch).contains(searchNumber));
	}

	public void comprobationForDouble(int index, Double searchNumber, Double[] arrayToSearch) {
		int precision = 0;
		switch(arrayToSearch.length) {
		case (TEN): {
			precision = 1;
			break;
		}
		case (ONETHOUSAND): {
			precision = 3;
			break;
		}
		case (HUNDREDTHOUSAND): {
			precision = 5;
			break;
		}
		}
		if (index != -1)
			assertEquals(arrayToSearch[index], searchNumber, precision);
		else
			assertFalse(Arrays.asList(arrayToSearch).contains(searchNumber));
	}
}
