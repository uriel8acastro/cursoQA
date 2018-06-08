package cursoQA.fuentes;

public class Entrada {
	public static String OPCIONES_INFORMACION [] = {"?"};
	public static String OPCIONES_INCLUSION [] = {"U","L","N","S"};
	public static String OPCIONES_EXCLUSION [] = {"A","E:"};
	public static String OPCIONES_GENERACION [] = {"Size:","T:"};
	public static String OPCIONES_COPIA [] = {"c"};
	public static String INFORMACION [] = {"BigBanKey -? ---> Informacion de general de la herramienta",
			"-U ---> Crear clave con letras Mayusculas (*)",
			"-L ---> Crear clave con letras Minusculas (*)",
			"-S ---> Crear Clave con numeros (*)",
			"-A ---> Excluir caracteres Ambiguos (*)",
			"-E ---> Excluir caracteres Especilaes (*)",
			"-T: ---> Total de claves a crear (*)",
			"-c ---> Opcion de copiar al portapales (*)",
			"(*)---> Indica si es opcional",
	"-Size: ---> Indica la logitud deseada, por defecto 16 (*) "};


	/**
	 * 
	 * @param listaOpcionesIngresadas
	 * @return retornara true si es valido el arreglo de opciones
	 * o false si no cumple cualquiera de las caracteristicas
	 */
	public boolean validarOpcionesIngresadas(String[] listaOpcionesIngresadas) {


		int contadorOpcionesValidas = 0;

		for (int i = 0; i < listaOpcionesIngresadas.length; i++) {

			//esta validacion se realiza para detectar una opcion repetida
			if(validarOpcion(listaOpcionesIngresadas, listaOpcionesIngresadas[i]) > 1) {
				System.out.println("La siguiente opcion esta repetida "+listaOpcionesIngresadas[i]);
				return false;
			}

			//esta validacion se usa para detecta opciones no validas

			if(validarOpcion(OPCIONES_INFORMACION, listaOpcionesIngresadas[i])== 0) {
				contadorOpcionesValidas++;
			}

			if(validarOpcion(OPCIONES_INCLUSION, listaOpcionesIngresadas[i])== 0) {

				contadorOpcionesValidas++;
			}

			if(validarOpcion(OPCIONES_EXCLUSION, listaOpcionesIngresadas[i])== 0) {

				contadorOpcionesValidas++;
			}

			if(validarOpcion(OPCIONES_GENERACION, listaOpcionesIngresadas[i])== 0) {

				contadorOpcionesValidas++;
			}

			if(validarOpcion(OPCIONES_COPIA, listaOpcionesIngresadas[i])== 0) {

				contadorOpcionesValidas++;
			}
			
			if (contadorOpcionesValidas == 5) {
				System.out.println(listaOpcionesIngresadas[i]+ " No es una opcion valida");
				return false;
			}
			else {
				contadorOpcionesValidas = 0;
			}

		}

		return true;

	}

	/**
	 * 
	 * @param listaOpciones: Cada arreglo estatico de opciones
	 * @param opcion: La opcion que se quiere validar para el arreglo.
	 * @return
	 */
	public int validarOpcion(String [] listaOpciones,String opcion) {
		int contador = 0;
		for (int i = 0; i < listaOpciones.length; i++) {
			if (listaOpciones[i].equals(opcion)) contador++;
		}
		return contador;
	}

	/**
	 * 
	 * @return retornara la cantida de opciones disponibles
	 */
	public int mostrarCantidadOpciones () {
		int numeroDeOpcionesPosibles = OPCIONES_INFORMACION.length + OPCIONES_INCLUSION.length +
				OPCIONES_EXCLUSION.length + OPCIONES_GENERACION.length +
				OPCIONES_COPIA.length;
		return numeroDeOpcionesPosibles;
	}

	/**
	 * 
	 * @param listaOpciones Las opciones de ayuda es una pero podrian llegar a ser mas
	 * @param opcioAyuda se estable el caracter de ayuda que debe existir previamente
	 */

	public void mostrarAyuda(String [] listaOpciones,String opcioAyuda) {
		for (int i = 0; i < listaOpciones.length; i++) {
			if(listaOpciones[i].equals(opcioAyuda)) {
				for (int j = 0; j < INFORMACION.length; j++) {
					System.out.println(INFORMACION[j]);
				}
			}
		}
	}

}
