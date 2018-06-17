package cursoQA.source;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * 
 * 
 * This class contains the attributes and methods of a key, the characters that
 * the key can contain will be of a static type
 * 
 * @author cesar
 */

public class PwdGenKey {

	public static char UPPER_CASE[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	public static char LOWER_CASE[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static char AMBIGUOUS_LETTERS[] = { 'i', 'I', 'L', 'l', '1', 'o', 'O', '0' };
	public static char SYMBOLS[] = { '@', '#', '$', '%', '&' };
	public static char UNWANTED_LETTERS[] = { '<', '>', '{', '}', '[', ']' };
	public static int DEFAULT_KEY_SIZE = 16;
	public static char NUMBERS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static String DEFAULT_OPTIONS[] = { "-U", "-L", "-N" };
	// Almacena le tamano de la clave
	private int sizeOfKey = DEFAULT_KEY_SIZE;
	private String desiredOptions[];

	public String[] getOptionsList() {
		return desiredOptions;
	}

	public void setOptionsList(String[] optionsList) {
		this.desiredOptions = optionsList;
	}

	/**
	 * 
	 * @param characterArray
	 *            Array of characters
	 * @return character random
	 */

	public char searchRandomCharacter(char[] characterArray) {
		int index = generateRandomIndex(characterArray.length);
		return characterArray[index];
	}

	/**
	 * 
	 * @param upperLimit
	 *            is de length of an Array
	 * @return a integer Number
	 */
	public int generateRandomIndex(int upperLimit) {
		Random randomIndex = new Random();
		return randomIndex.nextInt((upperLimit - 1));
	}

	/**
	 * 
	 * @param optionsList a Array of characters
	 * @return a Integer (length of the Password)
	 */
	
	public int showKeySize(String[] optionsList) {
		int keySize = sizeOfKey;
		boolean flagSize = false;
		for (int i = 0; i < optionsList.length; i++) {
			if (optionsList[i].contains("-Size:")) {
				keySize = Integer.parseInt(optionsList[i].split(":")[1]);
				// validar tanamo mayor a cero
				if (keySize > 0) {
					return keySize;
				} else {
					return sizeOfKey;
				}
			}
		}

		return sizeOfKey;

	}
	
	/**
	 * 
	 * @param optionsList a Array of Characters
	 * @return a Integer
	 */

	public int showAmountKeys(String[] optionsList) {
		int numberOfKeys = 1;
		for (int i = 0; i < optionsList.length; i++) {
			if (optionsList[i].contains("-T:")) {
				numberOfKeys = Integer.parseInt(optionsList[i].split(":")[1]);
				if (numberOfKeys > 1) {
					return numberOfKeys;
				} else {
					return 1;
				}
			}
		}

		return 1;

	}
/**
 * 
 * @return a arraylist with amount of the generated passwords
 */
	public ArrayList<String> showArrayOfKeys() {
		int amountOfKey = showAmountKeys(desiredOptions);
		ArrayList<String> listOfKeys = new ArrayList<String>();
		for (int cont = 0; cont < amountOfKey; cont++) {
			String tempKey = generatePassword();
			listOfKeys.add(tempKey);
		}
		return listOfKeys;
	}

/**
 * This is de Main method 
 * @return a String that is the Key 
 */

	public String generatePassword() {
		int keyLength = showKeySize(desiredOptions);
		String outKey = "";
		int j = 0;
		while (j < keyLength) {
			for (int i = 0; i < desiredOptions.length && (j < keyLength); i++) {
				switch (desiredOptions[i]) {

				case "-U":
					outKey += searchRandomCharacter(UPPER_CASE);
					j++;
					break;
				case "-L":
					outKey += searchRandomCharacter(LOWER_CASE);
					j++;
					break;

				case "-N":
					outKey += searchRandomCharacter(NUMBERS);
					j++;
					break;
				case "-S":
					outKey += searchRandomCharacter(SYMBOLS);
					j++;
					break;

				}

			}
		}

		return outKey;
	}

}
