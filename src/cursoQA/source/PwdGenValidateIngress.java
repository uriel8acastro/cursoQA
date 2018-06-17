package cursoQA.source;

/**
 * this class is responsible for the validation of the entry options
 * 
 * @author cesar
 */

public class PwdGenValidateIngress {
	public static String INFORMATION_OPTIONS[] = { "-?" };
	public static String INCLUSION_OPTIONS[] = { "-U", "-L", "-N", "-S" };
	public static String EXCLUSION_OPTIONS[] = { "-A", "-E" };
	public static String GENERATION_OPTIONS[] = { "-Size", "-T" };
	public static String COPY_OPTIONS[] = { "-c" };
	public static String INFORMATION[] = { "BigBanKey -? --->PwdGen tool options",
			"-U ---> create key with uppercase letters (*)", "-L ---> create key with lowercase letters (*)",
			"-N ---> create key with numbers (*)", "-S ---> create key with symbols (*)",
			"-A ---> exclude ambiguous characters example -A:l (*)", "-E ---> exclude special characters (*)",
			"-T: ---> number of keys to create example -T:3 (*)", "-c ---> option to copy to clipboard (*)",
			"-Size: ---> indicates the length the key, by default it is  16 (*) ",
			"(*)---> Indicate if it is optional" };

	private String[] listOptionsEntered;

	public String[] getListOptionsEntered() {
		return listOptionsEntered;
	}

	public void setListOptionsEntered(String[] optionsEntered) {
		this.listOptionsEntered = optionsEntered;
	}

	/**
	 * Constructor without parameters
	 */

	public PwdGenValidateIngress() {

	}

	/**
	 * Constructor with list of parameters
	 * 
	 * @param optionsToProcess
	 */
	public PwdGenValidateIngress(String[] optionsToProcess) {
		this.listOptionsEntered = optionsToProcess;
	}

	/**
	 * 
	 * @param listOptionsEntered
	 * @return true if the options are valid or false if they are not
	 */
	public boolean validateEnteredOptions() {

		int validationCounter = 0;

		// Validar si la opcion ingresada es ayuda
		if (listOptionsEntered.length == 1) {
			if (listOptionsEntered[0].equals("-?")) {
				for (String string : INFORMATION) {
					System.out.println(string);
				}
				return false;
			}
		}

		for (int i = 0; i < listOptionsEntered.length; i++) {

			String option = listOptionsEntered[i];

			// esta validacion se realiza para detectar una opcion repetida
			if (validateAppearanceOption(listOptionsEntered, option) > 1) {
				System.err.println("the option is repeated: " + option);
				return false;
			}

			// Valida que la opcion contine : luego es compuesta extrae solo la primera
			// parte
			if (option.contains(":")) {
				if (obtainOption(option).equals("-Size") || obtainOption(option).equals("-E")
						|| obtainOption(option).equals("-T")) {
					option = obtainOption(option);
				} else {
					System.err.println(option + " it has no modifiers or is not a valid option");
					return false;
				}

			}

			// esta validacion se usa para detecta opciones no validas

			if (validateAppearanceOption(INCLUSION_OPTIONS, option) == 0) {

				validationCounter++;
			}

			if (validateAppearanceOption(EXCLUSION_OPTIONS, option) == 0) {

				validationCounter++;
			}

			if (validateAppearanceOption(GENERATION_OPTIONS, option) == 0) {

				validationCounter++;
			}

			if (validateAppearanceOption(COPY_OPTIONS, option) == 0) {

				validationCounter++;
			}

			if (validationCounter == 4) {
				System.err.println(option + " it is not a valid option");
				return false;
			} else {
				validationCounter = 0;
			}

		}

		return true;

	}

	/**
	 * 
	 * @param listaOpciones:
	 *            arrangement of program options
	 * @param opcion:
	 *            option that you want to validate
	 * @return
	 */
	public int validateAppearanceOption(String[] optionList, String candidateOption) {
		int count = 0;
		for (int i = 0; i < optionList.length; i++) {

			if (optionList[i].equals(candidateOption))
				count++;
		}
		return count;
	}

	/**
	 * 
	 * @return the amount of options available
	 */
	public int showAmountOptions() {
		int numeroDeOpcionesPosibles = INFORMATION_OPTIONS.length + INCLUSION_OPTIONS.length
				+ EXCLUSION_OPTIONS.length + GENERATION_OPTIONS.length + COPY_OPTIONS.length;
		return numeroDeOpcionesPosibles;
	}

	/**
	 * Print the options that the program has
	 * 
	 * @param optionsList
	 *            List of options
	 * @param helpOption
	 *            help character
	 */

	public void helpDisplay(String[] optionsList, String helpOption) {
		for (int i = 0; i < optionsList.length; i++) {
			if (optionsList[i].equals(helpOption)) {
				for (int j = 0; j < INFORMATION.length; j++) {
					System.out.println(INFORMATION[j]);
				}
			}
		}
	}

	/**
	 * Valid that the maximum size of a key size
	 * 
	 * @return returns false if the modifier does not meet the range of the option
	 */
	public Boolean validateKeySize() {
		for (int i = 0; i < listOptionsEntered.length; i++) {
			if (listOptionsEntered[i].contains("-Size")) {
				int keyLength = Integer.parseInt(listOptionsEntered[i].split(":")[1]);
				if ((keyLength >= 1) && (keyLength <= 16)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * this method is responsible for taking the option without its modifiers
	 * 
	 * @param opcionConMoficadores:
	 *            Option to validate
	 * 
	 * @return returns option without modifiers
	 */
	public String obtainOption(String modifierOptions) {
		String principalOption;
		principalOption = modifierOptions.split(":")[0];
		return principalOption;
	}

}
