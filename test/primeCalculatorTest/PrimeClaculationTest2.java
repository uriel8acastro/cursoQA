package primeCalculatorTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import primeCalculator.Calculator;

public class PrimeClaculationTest2 {

	Calculator myCalculator;
	ArrayList<Integer> myArray;
	Hashtable myHash ;
	@Before
	public void setUp() throws Exception {
		myCalculator = new Calculator();
		myArray = new ArrayList<>();
		myHash = new Hashtable<Integer,Integer>();
	}
/*
	@Test
	public void firtsSolutionTest() {
		myCalculator.firstSolution(1000);
	}

	@Test
	public void secondSolutionTest() {
		myCalculator.secondSolution(100);
	}

	@Test
	public void validateParentsNumbers2() {
		myArray.add(31);
		myArray.add(13);
		assertTrue(myCalculator.isNumberBrother(myArray.get(0), myArray.get(1)));

	}

	@Test
	public void validateParentsNumbers3() {
		myArray.add(917);
		myArray.add(197);
		assertTrue(myCalculator.isNumberBrother(myArray.get(0), myArray.get(1)));

	}

	@Test
	public void validateSearchPrimes() {
		myArray.add(2);
		myArray.add(3);
		myArray.add(5);
		myArray.add(7);
		assertEquals(myArray, myCalculator.getListPrimes(7));

	}

	@Test
	public void searchParentPrimesTest() {
		myArray = myCalculator.getListPrimesArray(40);
		myCalculator.showPrimesResults(myArray);

	}
	*/
	@Test
	public void searchCircularPrimesHashTest() {
		myHash = myCalculator.getListPrimesHash(40);
		myCalculator.hashCircularPrime(myHash);
		myCalculator.showPrimesInHash(myCalculator.hastablePrimesResults);

	}
	
	/*
	@Test 
	public  void thirdSolutionTest() {
		myCalculator.thirdSolution(100);
	}
	*/

}
