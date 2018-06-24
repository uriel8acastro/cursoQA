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

    public int getCircular(int originalNumber){
        int circularNumber=0;
        int lasNumber = getLastNumber(originalNumber,1000000);
        originalNumber = originalNumber - lasNumber;
        for (int i = 1000000; i >= 10 ; i= i/10 ) {
            if (originalNumber/i > 0){
                if(i<100){
                    circularNumber= (lasNumber*i)+(originalNumber/i);
                    return circularNumber;
                }
                if (i>=100 && i<1000){
                    circularNumber= (lasNumber*i)+(originalNumber/(i/10));
                    return circularNumber;
                }
                if (i>=1000 && i<10000){
                    circularNumber= (lasNumber*i)+(originalNumber/(i/100));
                    return circularNumber;
                }
                if (i>=10000 && i<100000){
                    circularNumber= (lasNumber*i)+(originalNumber/(i/1000));
                    return circularNumber;
                }
                if (i>=100000 && i<1000000){
                    circularNumber= (lasNumber*i)+(originalNumber/(i/10000));
                    return circularNumber;
                }

            }
        }
        return circularNumber;
    }

    /**
     * Recursive method for get last number.
     * @param number
     * @param limit
     * @return
     */
    public int getLastNumber(Integer number, int limit){
        if (number < 10){
            return number;
        }
        else{
            if(number/limit > 0){
                number = number % limit;
                number = getLastNumber(number,limit);

            }
            else{
                limit = limit/10;
                number = getLastNumber(number,limit);

            }
        }
        return number;
    }

    /**
     * Method to show circular primes numbers founds
     * @param arraynumbers Array of Primes Numbers
     */
    public void showCircularPrimesIn(ArrayList<Integer> arraynumbers){
        for (int i = 0; i <arraynumbers.size() ; i++) {
            int temNumber = arraynumbers.get(i);
            int circularNumber = getCircular(temNumber);
            if (arraynumbers.contains(circularNumber)){
                System.err.println("Circular "+circularNumber+" Original "+temNumber);
            }
        }

    }


}