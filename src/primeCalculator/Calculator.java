package primeCalculator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Clase principal donde se busca, y se ordenan numeros primos
 * 
 * @author cesar8a
 * 
 */

public class Calculator {

	public Hashtable<String, String> hastablePrimes = new Hashtable<String, String>();
	public ArrayList<Integer> arrayPrimes = new ArrayList<>();
	public ArrayList<Integer> arrayPrimesResults = new ArrayList<>();
	public Hashtable<String, String> hastablePrimesResults = new Hashtable<String, String>();

	/**
	 * Metodo para determinar si un numero es o no primo implementa las mejoras de
	 * la criba de eratostenes y el iterar solo la mitad del numero
	 * 
	 * @param number
	 *            es un numero entre 1 y un millon
	 * @return false si no es primo y verdadero si lo es.
	 */

	public boolean searchPrimeNumberOne(int number) {
		int countDivisor = 0;
		if (number == 0)
			return false;
		if (number == 1)
			return false;
		if (number == 2 || number == 3 || number == 5 || number == 7) {
			return true;
		}
		// Criba de eratostenes
		if (number % 2 == 0)
			countDivisor++;
		if (number % 3 == 0)
			countDivisor++;
		if (number % 5 == 0)
			countDivisor++;
		if (number % 7 == 0)
			countDivisor++;
		if (countDivisor >= 1) {
			return false;
		}
		// Mejora que permite solo iterar la mitan mas uno del numero
		// reduciendo asi el tiempo.
		for (int i = 1; i <= number; i++) {
			/*
			 * Si el numero esta en la mitad y no se encuentra divisor aumenta el contador y
			 * rompe el ciclo
			 */
			if (i > (number / 2)) {
				countDivisor++;
				break;
			}

			if (number % i == 0) {

				countDivisor++;
				if (countDivisor > 2)
					break;
			}
		}
		if (countDivisor > 2)
			return false;
		else {
			return true;
		}

	}

	/**
	 * Metodo que determina si un numero es o no primo bajo la regla de tener solo
	 * dos divisores exactos el 1 y el mismo
	 * 
	 * @param number
	 *            es un entero entre 1 y un millon
	 * @return verdadero si el numero es primo y falso si no lo es.
	 */

	public boolean searchPrimeNumberTwo(int number) {
		int countDivisor = 0;

		if (number == 1)
			return false;

		if (number == 2 || number == 3 || number == 5 || number == 7) {
			return true;
		}
		// Criba de Eratostenes
		if (number % 2 == 0)
			countDivisor++;
		if (number % 3 == 0)
			countDivisor++;
		if (number % 5 == 0)
			countDivisor++;
		if (number % 7 == 0)
			countDivisor++;
		if (countDivisor >= 1) {
			return false;
		}

		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				countDivisor++;
			}
		}
		if (countDivisor > 2)
			return false;
		else {
			return true;
		}

	}

	/**
	 * Metodo que permite guardar un numero primo como una tabla hash
	 * 
	 * @param number
	 *            Entero primo entre 1 y 1000000
	 */

	public void storeListCousinsHash(int number) {
		hastablePrimes.put(" " + hastablePrimes.size(), " " + number);
	}

	/**
	 * Metodo que permite guardar un numero primo como un array de Integers
	 * 
	 * @param number
	 *            Entero primo entre 1 y un millon
	 */
	public void storeListCousinsArray(int number) {
		arrayPrimes.add(number);
	}

	/**
	 * Metodo para imprimir el contenido de una tabla Hash
	 * 
	 * @param hastable
	 *            Una tabla hash de primos entre 1 y un millon
	 */
	public void showPrimesInHash(Hashtable<String, String> hastable) {
		Enumeration<String> enumeration = hastable.elements();
		int count = 1;
		while (enumeration.hasMoreElements()) {
			System.out.println(count + " " + enumeration.nextElement());
			count++;
		}
	}

	/**
	 * Metodo para imprimir el contenido de un array de integers
	 * 
	 * @param arrayPrimes
	 *            un array de numero primos comprendifosd entre 1 y un millon
	 */
	public void showPrimesInArray(ArrayList<Integer> arrayPrimes) {
		int count = 1;
		for (Integer integer : arrayPrimes) {
			System.out.println(count + " " + integer.intValue());
			count++;
		}
	}

	/**
	 * Metodo que muestra el arreglo final de primos que cumplen la propiedad de ser
	 * parientes
	 * 
	 * @param arrayOriginal
	 *            Arreglo con todos los numero primos exitentes entre 1 y un millon
	 */
	public void showPrimesResults(ArrayList<Integer> arrayOriginal) {

		for (Integer integerOri : arrayPrimes) {
			for (Integer integerParent : arrayOriginal) {
				if (isNumberBrother(integerOri, integerParent)) {
					if (validateNumerExist(arrayPrimesResults, integerParent.intValue())) {

					} else {
						arrayPrimesResults.add(integerParent);
					}

				}

			}
		}

		for (Integer integer : arrayPrimesResults) {
			System.out.println(integer.intValue());
		}
	}

	/**
	 * 
	 * @param arrInteger
	 *            Array List of Integers
	 * @param numberWanted
	 *            A Integer
	 * @return True if the number exist in the array List
	 */
	public boolean validateNumerExist(ArrayList<Integer> arrInteger, int numberWanted) {
		for (Integer integer : arrInteger) {
			if (numberWanted == integer.intValue()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determina si un numero de la misma cantidad de cifras es un pariente osea que
	 * compartan las misma cifras en diferente orden (197 es pariente de 917)
	 * 
	 * @param original
	 *            es el numero primero al que se validara un pariente
	 * @param parent
	 *            es el numero primo posible pariente
	 * @return
	 */
	public boolean isNumberBrother(Integer original, Integer parent) {
		int count = 0;

		if (original.intValue() <= 11 || parent.intValue() <= 11)
			return false;

		if (original.intValue() == parent.intValue()) {
			return false;
		}

		if (original.toString().length() != parent.toString().length()) {
			return false;
		} else {

			String strParent = parent.toString();
			String strOriginal = original.toString();
			for (int i = 0; i < strParent.length(); i++) {
				for (int j = 0; j < strOriginal.length(); j++) {
					if (strParent.charAt(i) == strOriginal.charAt(j))
						count++;
				}

			}
		}
		if (count == original.toString().length()) {
			return true;
		} else {
			return false;
		}

	}
	
	public Hashtable<String, String> hashCircularPrime(Hashtable<String, String> hashPrimes) {
		Hashtable<String, String> outHash = new Hashtable<String, String>();
		Enumeration<String> enumeration = hashPrimes.elements();
		
		 while(enumeration.hasMoreElements()) {	
			    String oriNumber = enumeration.nextElement();
			    
				char lastNumber = oriNumber.charAt(oriNumber.length()-1);
				String firstNumbers = oriNumber.substring(0, oriNumber.length()-2);
				String tempNumber = lastNumber+firstNumbers;
				if(hashPrimes.containsValue(tempNumber)) {
					outHash.put(""+outHash.size(), tempNumber);
					outHash.put(""+outHash.size(), oriNumber);
				}
		 }
		 
		 return outHash;
	}

	/**
	 * Metodo usado en las prubas unitarias
	 * 
	 * @param limit
	 *            cuanto primos se dese buscar
	 * @return listado de primos hast el limite dado.
	 */
	public ArrayList<Integer> getListPrimes(int limit) {
		for (int i = 1; i <= limit; i++) {
			if (searchPrimeNumberOne(i)) {
				// storeListCousinsHash(i);
				storeListCousinsArray(i);

			}
		}
		return arrayPrimes;
	}

	public void firstSolution(int upperLimit) {
		for (int i = 1; i < upperLimit; i++) {
			if (searchPrimeNumberOne(i)) {
				storeListCousinsArray(i);

			}

		}
		showPrimesResults(arrayPrimes);

	}

	public void secondSolution(int upperLimit) {
		for (int i = 1; i < upperLimit; i++) {
			if (searchPrimeNumberTwo(i)) {
				storeListCousinsArray(i);

			}
		}
		showPrimesResults(arrayPrimes);
	}

	public void thirdSolution(int upperLimit) {
		for (int i = 1; i < upperLimit; i++) {
			if (searchPrimeNumberOne(i)) {
				storeListCousinsHash(i);

			}
		}
		hastablePrimesResults = hashCircularPrime(hastablePrimes);
		showPrimesInHash(hastablePrimesResults);

	}

}
