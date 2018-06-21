package primeCalculator;

import java.util.ArrayList;

/**
 * @author Cesar8a
 */

public class SearchPrimeFast {
    public ArrayList<Integer> primesArray;
    public ArrayList<Integer> circularPrimesArray;
    public long initTime=0;
    public long finalTime=0;

    public SearchPrimeFast(ArrayList<Integer> primesArray, ArrayList<Integer> circularprimesArray) {
        this.primesArray = primesArray;
        this.circularPrimesArray = circularprimesArray;

    }

    /**
     * Method to determine if a number is prime
     * @param number Whole number greater than 2
     * @return true if number is prime
     */
    public boolean isPrime(int number){
        int limitDivisions = 0;
        int countDivisors = 0;

        if (number % 2 == 0) {
            return false;
        }
        limitDivisions = (int) Math.sqrt(number);
        for (int i = 1 ; i <= limitDivisions;i++){
            if (number % i == 0){
                countDivisors++;
            }
        }
        if (countDivisors > 1){
            return false;
        }else{
            return true;
        }

    }

    /**
     * Method that stores the prime numbers in an array
     * @param limit limit number to where primes ​​will be searched
     *
     */
    public void savePrimesList(int limit){
        initTime = System.currentTimeMillis();
        primesArray.add(2);
        for (int i = 3; i < limit ; i++) {
            if (isPrime(i)){
                primesArray.add(i);
            }
        }
        finalTime = (System.currentTimeMillis()-initTime);
      }

    /**
     * Method to show the primes ​​found
     */
    public void showPrimes(){
          for (int i = 0; i < primesArray.size(); i++) {
              System.out.println(i+" "+primesArray.get(i));
          }
      }

    /**
     * Method to show the time of processing
     * @return The number of milliseconds used in processing
     */
    public long getFinalTime() {
        return finalTime;
    }


}