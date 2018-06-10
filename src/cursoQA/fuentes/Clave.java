package cursoQA.fuentes;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author cesar
 * 
 *         Esta clase contiene los atributos y metodos de una clave Los
 *         caracteres que puede contener la clave seran de tipo estatico
 * 
 */

public class Clave {

	public static char LETRAS_MAYUSCULAS[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	public static char LETRAS_MINUSCULAS[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static char LETRAS_AMBIGUAS[] = { 'i', 'I', 'L', 'l', '1', 'o', 'O', '0' };
	public static char SIMBOLOS[] = { '@', '#', '$', '%', '&' };
	public static char CARACTERES_INDESEADOS[] = { '<', '>', '{', '}', '[', ']' };
	public static int TAMANO_CLAVE_DEFECTO = 16;
	public static char NUMEROS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static String OPCIONES_DEFECTO[]= {"U","L","N"};
	// Almacena le tamaño de la clave
	private int tamanoClave = TAMANO_CLAVE_DEFECTO;
	// Almacena la combinacion de caracteres que llamaremos clave
	private String claveGenerada;

	private String listaOpciones[];

	public String[] getListaOpciones() {
		return listaOpciones;
	}

	public void setListaOpciones(String[] listaOpciones) {
		this.listaOpciones = listaOpciones;
	}

	/**
	 * 
	 * @param longitudArreglo:
	 *            es la longitud del arreglo del cual se desea extraer un caracter
	 * @return Caracter selecionado al azar.
	 */

	public char obtenerCaracterAleatorio(char[] arregloDeCaracteres) {
		int indice = generarIndiceAleatorio(arregloDeCaracteres.length);
		return arregloDeCaracteres[indice];
	}

	/**
	 * 
	 * @param limiteSuperior:
	 *            es el tamaño del arreglo
	 * @return entero que corresponde a un indice del arreglo
	 */
	public int generarIndiceAleatorio(int limiteSuperior) {
		Random indiceRandom = new Random();
		return indiceRandom.nextInt((limiteSuperior - 1));
	}

	/**
	 * Para obtener el tamaño de la clave
	 * 
	 * @param listaOpciones
	 * @return el tamoño segun la opcion o el tamaño por defecto
	 */
	public int mostrarLongitudClave(String[] listaOpciones) {
		int longitudClave = tamanoClave;
		boolean flagSize = false;
		for (int i = 0; i < listaOpciones.length; i++) {
			if (listaOpciones[i].contains("Size:")) {
				longitudClave = Integer.parseInt(listaOpciones[i].split(":")[1]);
				// validar tañamo mayor a cero
				if (longitudClave > 0) {
					return longitudClave;
				} else {
					return tamanoClave;
				}
			}
		}

		return tamanoClave;

	}
	
	public int mostrarCantidadClaves(String[] listaOpciones) {
		int cantidadClaves = 1;
		for (int i = 0; i < listaOpciones.length; i++) {
			if(listaOpciones[i].contains("T:")) {
				cantidadClaves = Integer.parseInt(listaOpciones[i].split(":")[1]);
				if(cantidadClaves > 1) {
					return cantidadClaves;
				}
				else {
					return 1;
				}
			}
		}
		
		return 1;
		
	}
	
	/**
	 * Este metodo alacena la cantidad de claves
	 * que se especifiquen en la opcion
	 * @return
	 */
	
	public ArrayList<String> mostrarArregloClaves(){
		int cantidadClaves = mostrarCantidadClaves(listaOpciones);
		ArrayList<String> listaClaves = new ArrayList<String>();
		for (int cont = 0; cont < cantidadClaves; cont++) {
			String claveTemporal = generarClave();
			listaClaves.add(claveTemporal);
		}
		return listaClaves;
	}

	/**
	 * Metodo encargado de generar la clave deacuerdo ala lista de opciones ingresada
	 * @param listaOpciones
	 * @return
	 */

	public String generarClave() {
		int longitudClave = mostrarLongitudClave(listaOpciones);		
		String clave = "";		
			int j = 0;
			while (j < longitudClave) {
				for (int i = 0; i < listaOpciones.length && (j < longitudClave); i++) {
					switch (listaOpciones[i]) {

					case "U":
						clave += obtenerCaracterAleatorio(LETRAS_MAYUSCULAS);
						j++;
						break;
					case "L":
						clave += obtenerCaracterAleatorio(LETRAS_MINUSCULAS);
						j++;
						break;

					case "N":
						clave += obtenerCaracterAleatorio(NUMEROS);
						j++;
						break;
					case "S":
						clave += obtenerCaracterAleatorio(SIMBOLOS);
						j++;
						break;

					}

				}
			}			

		return clave;
	}

}
