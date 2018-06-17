package primeCalculatorTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import primeCalculator.Calculator;

public class PrimeClaculationTest2 {

	Calculator miCalculator;
	ArrayList<Integer> miArray;

	@Before
	public void setUp() throws Exception {
		miCalculator = new Calculator();
		miArray = new ArrayList<>();
	}

	@Test
	public void validateParentsNumbers2() {
		miArray.add(31);
		miArray.add(13);
		assertTrue(miCalculator.isNumberBrother(miArray.get(0), miArray.get(1)));

	}
	
	@Test
	public void validateParentsNumbers3() {
		miArray.add(917);
		miArray.add(197);
		assertTrue(miCalculator.isNumberBrother(miArray.get(0), miArray.get(1)));

	}

	@Test
	public void validateSearchPrimes() {
		miArray.add(2);
		miArray.add(3);
		miArray.add(5);
		miArray.add(7);
		assertEquals(miArray, miCalculator.getListPrimes(7));

	}

	@Test
	public void SearchCircularPrimes() {
        miArray = miCalculator.getListPrimes(1000);
        miCalculator.showPrimesResults(miArray);
		
	}
}
