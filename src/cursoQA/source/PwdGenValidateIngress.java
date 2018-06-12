package cursoQA.source;

/**
 * 
 * @author cesar Esta clase se crea para encargarle la validacion de las
 *         opciones ingresadas por el usuario
 */

public class PwdGenValidateIngress {
	public static String OPCIONES_INFORMACION[] = { "-?" };
	public static String OPCIONES_INCLUSION[] = { "-U", "-L", "-N", "-S" };
	public static String OPCIONES_EXCLUSION[] = { "-A", "-E" };
	public static String OPCIONES_GENERACION[] = { "-Size", "-T" };
	public static String OPCIONES_COPIA[] = { "-c" };
	public static String INFORMACION[] = { "BigBanKey -? ---> Informacion de general de la herramienta",
			"-U ---> Crear clave con letras Mayusculas (*)", "-L ---> Crear clave con letras Minusculas (*)",
			"-S ---> Crear Clave con numeros (*)", "-A ---> Excluir caracteres Ambiguos (*)",
			"-E ---> Excluir caracteres Especilaes (*)", "-T: ---> Total de claves a crear (*)",
			"-c ---> Opcion de copiar al portapales (*)", "(*)---> Indica si es opcional",
			"-Size: ---> Indica la logitud deseada, por defecto 16 (*) " };

	private String[] listaOpcionesIngresadas;

	public String[] getListaOpcionesIngresadas() {
		return listaOpcionesIngresadas;
	}

	public void setListaOpcionesIngresadas(String[] listaOpcionesIngresadas) {
		this.listaOpcionesIngresadas = listaOpcionesIngresadas;
	}

	/**
	 * Constructor sin parametros
	 */

	public PwdGenValidateIngress() {

	}

	/**
	 * Contructor con una lista de opciones de entrada
	 * 
	 * @param listaOpcionAValidar
	 */
	public PwdGenValidateIngress(String[] listaOpcionAValidar) {
		this.listaOpcionesIngresadas = listaOpcionAValidar;
	}

	/**
	 * 
	 * @param listaOpcionesIngresadas
	 * @return retornara true si es valido el arreglo de opciones o false si no
	 *         cumple cualquiera de las caracteristicas
	 */
	public boolean validarOpcionesIngresadas() {

		int contadorOpcionesValidas = 0;

		// Validar si la opcion ingresada es ayuda
		if (listaOpcionesIngresadas.length == 1) {
			if (listaOpcionesIngresadas[0].equals("-?")) {
				for (String string : INFORMACION) {
					System.out.println(string);
				}
				return false;
			}
		}

		for (int i = 0; i < listaOpcionesIngresadas.length; i++) {

			String opcion = listaOpcionesIngresadas[i];

			// esta validacion se realiza para detectar una opcion repetida
			if (validarAparacionesOpcion(listaOpcionesIngresadas, opcion) > 1) {
				System.err.println("La siguiente opcion esta repetida " + opcion);
				return false;
			}

			// Valida que la opcion contine : luego es compuesta extrae solo la primera
			// parte
			if (opcion.contains(":")) {
				if (optenerOpcion(opcion).equals("-Size") || optenerOpcion(opcion).equals("-E")
						|| optenerOpcion(opcion).equals("-T")) {
					opcion = optenerOpcion(opcion);
				} else {
					System.err.println(opcion + " No tiene modificadores o no es una opcion valida");
					return false;
				}

			}

			// esta validacion se usa para detecta opciones no validas

			if (validarAparacionesOpcion(OPCIONES_INCLUSION, opcion) == 0) {

				contadorOpcionesValidas++;
			}

			if (validarAparacionesOpcion(OPCIONES_EXCLUSION, opcion) == 0) {

				contadorOpcionesValidas++;
			}

			if (validarAparacionesOpcion(OPCIONES_GENERACION, opcion) == 0) {

				contadorOpcionesValidas++;
			}

			if (validarAparacionesOpcion(OPCIONES_COPIA, opcion) == 0) {

				contadorOpcionesValidas++;
			}

			if (contadorOpcionesValidas == 4) {
				System.err.println(opcion + " No es una opcion valida");
				return false;
			} else {
				contadorOpcionesValidas = 0;
			}

		}

		return true;

	}

	/**
	 * 
	 * @param listaOpciones:
	 *            Cada arreglo estatico de opciones
	 * @param opcion:
	 *            La opcion que se quiere validar para el arreglo.
	 * @return
	 */
	public int validarAparacionesOpcion(String[] listaOpciones, String opcionCandidata) {
		int contador = 0;
		for (int i = 0; i < listaOpciones.length; i++) {

			if (listaOpciones[i].equals(opcionCandidata))
				contador++;
		}
		return contador;
	}

	/**
	 * 
	 * @return retornara la cantida de opciones disponibles
	 */
	public int mostrarCantidadOpciones() {
		int numeroDeOpcionesPosibles = OPCIONES_INFORMACION.length + OPCIONES_INCLUSION.length
				+ OPCIONES_EXCLUSION.length + OPCIONES_GENERACION.length + OPCIONES_COPIA.length;
		return numeroDeOpcionesPosibles;
	}

	/**
	 * 
	 * @param listaOpciones
	 *            Las opciones de ayuda es una pero podrian llegar a ser mas
	 * @param opcioAyuda
	 *            se estable el caracter de ayuda que debe existir previamente
	 */

	public void mostrarAyuda(String[] listaOpciones, String opcioAyuda) {
		for (int i = 0; i < listaOpciones.length; i++) {
			if (listaOpciones[i].equals(opcioAyuda)) {
				for (int j = 0; j < INFORMACION.length; j++) {
					System.out.println(INFORMACION[j]);
				}
			}
		}
	}

	/**
	 * 
	 * @return Falso si los numeros que acompanan a la opcion Size no estan el rango
	 *         permitido
	 */
	public Boolean validarTamanoClave() {
		for (int i = 0; i < listaOpcionesIngresadas.length; i++) {
			if (listaOpcionesIngresadas[i].contains("-Size")) {
				int longituClave = Integer.parseInt(listaOpcionesIngresadas[i].split(":")[1]);
				if ((longituClave >= 1) && (longituClave <= 16)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param opcionConMoficadores:
	 *            ingresa como una opcion con modificaores ejemplo E:3, Size:16
	 * @return retorna la cadena o caracter que representa la opcion principal
	 */
	public String optenerOpcion(String opcionConMoficadores) {
		String opcionPrincipal;
		opcionPrincipal = opcionConMoficadores.split(":")[0];
		return opcionPrincipal;
	}

}
