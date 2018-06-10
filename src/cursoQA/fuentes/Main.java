package cursoQA.fuentes;

import java.util.ArrayList;

/**
 * Esta es una herramienta para generacion de claves
 * automatica que usa parametros para controlar
 * la creacion y la seguridad de las claves.
 * @author cesar
 *
 */

public class Main {

	public static void main(String[] args) {
		System.out.println("::::::::BIGBANKEY:::::::::");
		System.out.println(":::::Power By Cesar8a:::::");
		System.out.println(":::::     |||||      :::::");
		System.out.println(":::::     {0_0}      :::::");
		System.out.println(":::::      ***       :::::");
		System.out.println("::::::::::::::::::::::::::");

		Entrada validaciones = new Entrada();
		//se valida no habian argumentos de entrada para generar clave por defecto
		if (args.length == 0) {
			Clave clave = new Clave();
			clave.setListaOpciones(clave.OPCIONES_DEFECTO);
			System.out.println(clave.generarClave());
		} 
		else {

			validaciones.setListaOpcionesIngresadas(args);
			
			for (String string : args) {
				System.out.println(string);
			}
			
			if (validaciones.validarOpcionesIngresadas()) {
				Clave clave = new Clave();
				clave.setListaOpciones(args);
				if (clave.mostrarCantidadClaves(args) <= 1) {
					clave.generarClave();
					System.out.println(clave.generarClave());
				} else {
					ArrayList<String> listaClaves = new ArrayList<>();
					for (String string : listaClaves) {
						System.out.println(listaClaves);
					}
				}
			} else {

				System.out.println("Intentalo nuevamente o pide ayuda con ?");
			}

		}

	}

}
