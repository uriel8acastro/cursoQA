package cursoQA.fuentes;

public class Main {
	

	public static void main(String[] args) {
		Clave miClave = new Clave();
		Entrada miEntrada = new Entrada();
		String opcionesIngresadasConsola [] = {"L","N","U","F"};
		Boolean entradaEsValida = miEntrada.validarOpcionesIngresadas(opcionesIngresadasConsola);		
		
		char opciones [] = {'U','L','N','S'};
		System.out.println("La entrada se valido: " + entradaEsValida);
		System.out.println(miClave.generarClave(opciones, 5));
	}

}
