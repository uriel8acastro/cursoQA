package primeCalculatorTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import primeCalculator.SearchPrimeFast;


public class SearchPrimeFastTest {
    SearchPrimeFast mySearchPrimeFast ;
    ArrayList<Integer> myArrayPrimes;
    ArrayList<Integer> myCircularArrayPrimes;
    @Before
    public void setUp() throws Exception {
        myArrayPrimes = new ArrayList<>();
        myCircularArrayPrimes = new ArrayList<>();
        mySearchPrimeFast = new SearchPrimeFast(myArrayPrimes,myCircularArrayPrimes);
    }


    @Test
    public  void searchCircularFastTest1() {
        int circular = mySearchPrimeFast.getCircular(999995);
        System.err.println(circular);
    }
/*
    @Test
    public  void searchPrimeFastTest1() {
        mySearchPrimeFast.savePrimesList(1000000);
        System.out.println("time in millis " + mySearchPrimeFast.getFinalTime());
        mySearchPrimeFast.showPrimes();
    }
*/

@Test
    public  void lastNumerTest(){
    int number = mySearchPrimeFast.getLastNumber(197,100000);
    System.out.println(number);
}

    @After
    public void tearDown() throws Exception {
    }

}