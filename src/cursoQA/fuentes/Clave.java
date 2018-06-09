package cursoQA.fuentes;

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

	public static char LETRAS_MAYUSCULAS[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	public static char LETRAS_MINUSCULAS[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static char LETRAS_AMBIGUAS[] = { 'i', 'I', 'L', 'l', '1', 'o', 'O', '0' };
	public static char SIMBOLOS[] = { '@', '#', '$', '%', '&' };
	public static char CARACTERES_INDESEADOS[] = { '<', '>', '{', '}', '[', ']' };
	public static int TAMANO_CLAVE_DEFECTO = 16;
	public static char NUMEROS[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	// Almacena le tamaño de la clave
	private int tamanoClave = TAMANO_CLAVE_DEFECTO;
	// Almacena la combinacion de caracteres que llamaremos clave
	private String claveGenerada;

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

	public String generarClave(String[] listaOpciones, int longitudClave) {
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
