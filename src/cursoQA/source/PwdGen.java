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

		PwdGenValidateIngress validaciones = new PwdGenValidateIngress();
		// Valid if the entry list is empty
		if (args.length == 0) {
			PwdGenKey clave = new PwdGenKey();
			clave.setListaOpciones(clave.OPCIONES_DEFECTO);
			System.out.println(clave.generarClave());
		} else {

			validaciones.setListaOpcionesIngresadas(args);
			if (validaciones.validarOpcionesIngresadas()) {
				PwdGenKey clave = new PwdGenKey();
				clave.setListaOpciones(args);

				if (clave.mostrarCantidadClaves(args) <= 1) {
					clave.generarClave();
					System.out.println(clave.generarClave());
				} else {
					ArrayList<String> listaClaves;
					listaClaves = clave.mostrarArregloClaves();
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
