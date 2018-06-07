package cursoQA.fuentes;

public class Main {
	

	public static void main(String[] args) {
		Clave miClave = new Clave();
		char opciones [] = {'L','U','N'};
		System.out.println(miClave.generarClave(opciones, 5));
	}

}
