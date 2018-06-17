package cursoQA.source;

import java.util.ArrayList;

/**
 * PwdGen is a tool for the automatic generation of keys
 * 
 * @author cesar
 *
 */

public class PwdGen {

	public static void main(String[] args) {
		/**
		 * Welcome message
		 */
		System.out.println(":::::::::WELCOME::::::::::");
		System.out.println("::::::::BIGBANKEY:::::::::");
		System.out.println(":::::Power By Cesar8a:::::");
		System.out.println(":::::     |||||      :::::");
		System.out.println(":::::     {0_0}      :::::");
		System.out.println(":::::      ***       :::::");
		System.out.println("::::::::::::::::::::::::::");

		PwdGenValidateIngress validations = new PwdGenValidateIngress();
		// Valid if the entry list is empty
		if (args.length == 0) {
			PwdGenKey myKey = new PwdGenKey();
			myKey.setOptionsList(myKey.DEFAULT_OPTIONS);
			System.out.println(myKey.generatePassword());
		} else {

			validations.setListOptionsEntered(args);
			if (validations.validateEnteredOptions()) {
				PwdGenKey myOutKey = new PwdGenKey();
				myOutKey.setOptionsList(args);

				if (myOutKey.showAmountKeys(args) <= 1) {
					myOutKey.generatePassword();
					System.out.println(myOutKey.generatePassword());
				} else {
					ArrayList<String> listaClaves;
					listaClaves = myOutKey.showArrayOfKeys();
					for (int i = 0; i < listaClaves.size(); i++) {
						System.out.println(listaClaves.get(i));
					}
				}
			} else {

				System.out.println("Try again or ask for help -?");
			}

		}

	}

}
