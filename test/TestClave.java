/**
 * 
 */


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cursoQA.source.Clave;
import cursoQA.source.Entrada;
import cursoQA.source.PwdGen;

/**
 * 
 * @author cesar Pruebas unitarias para clase Clave y la Clase Entrada
 *
 */
public class TestClave {

	Clave miClaveTest;
	Entrada miEntradaTest;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		miClaveTest = new Clave();
		miEntradaTest = new Entrada();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidarOpcionInformacion() {
		String opciones[] = { "-?" };
		miEntradaTest.setListaOpcionesIngresadas(opciones);
		Boolean esValida = miEntradaTest.validarOpcionesIngresadas();
		assertEquals(false, esValida);

	}

	@Test
	public void testValidarOpcionesInclusion() {
		String opciones[] = { "-U", "-L", "-N", "-S" };
		miEntradaTest.setListaOpcionesIngresadas(opciones);
		Boolean esValida = miEntradaTest.validarOpcionesIngresadas();
		assertEquals(true, esValida);

	}

	@Test
	public void testValidarOpcionNoValida() {
		String opciones[] = { "-U", "-L", "-N", "-S", "-Z" };
		miEntradaTest.setListaOpcionesIngresadas(opciones);
		Boolean esValida = miEntradaTest.validarOpcionesIngresadas();
		assertEquals(false, esValida);

	}

	@Test
	public void testValidarModificadoresNoValidos() {
		String opciones[] = { "-U:55", "-L", "-S" };
		miEntradaTest.setListaOpcionesIngresadas(opciones);
		Boolean esValida = miEntradaTest.validarOpcionesIngresadas();
		assertEquals(false, esValida);

	}

	@Test
	public void testValidarOpcionsModificadores() {
		String opcionesModificadas[] = { "-T:3", "-Size:10", "-E:%$#" };
		miEntradaTest.setListaOpcionesIngresadas(opcionesModificadas);
		assertEquals(true, miEntradaTest.validarOpcionesIngresadas());

	}

	@Test
	public void testValidarClaveMayusculas() {
		String opciones[] = { "-U" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[A-Z]*"));

	}

	@Test
	public void testValidarClaveMinusculas() {
		String opciones[] = { "-L" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[a-z]*"));

	}

	@Test
	public void testValidarClaveNumeros() {
		String opciones[] = { "-N" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[0-9]*"));

	}

	@Test
	public void testValidarClaveSimbolos() {
		String opciones[] = { "-S" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[$|#|&|@|%]*"));

	}

	@Test
	public void testClaveMayusculasMinusculas() {
		String opciones[] = { "-L", "-U" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[a-z|A-Z]*"));

	}

	@Test
	public void testClaveMayusculasNumeros() {
		String opciones[] = { "-U", "-N" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[A-Z|0-9]*"));

	}

	@Test
	public void testClaveMinusculasNumeros() {
		String opciones[] = { "-L", "-N" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[a-z|0-9]*"));

	}

	@Test
	public void testClaveMayusculasSimbolos() {
		String opciones[] = { "-U", "-S" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[A-Z|$|#|&|@|%]*"));

	}

	@Test
	public void testClaveMinusculasSimbolos() {
		String opciones[] = { "-L", "-S" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[a-z|$|#|&|@|%]*"));

	}

	@Test
	public void testClaveMinusculasMayusculasSimbolos() {
		String opciones[] = { "-L", "-S", "-U" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[a-z|$|#|&|@|%|A-Z]*"));

	}

	@Test
	public void testMinusculasMayusculasSimbolosNumeros() {
		String opciones[] = { "-L", "-S", "-U", "-N" };
		miClaveTest.setListaOpciones(opciones);
		String claveTest = miClaveTest.generarClave();
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[a-z|$|#|&|@|%|A-Z|0-9]*"));

	}

	@Test
	public void testValidarLongituClave() {
		String opciones[] = { "-Size:10", "-U" };
		miClaveTest.setListaOpciones(opciones);
		assertEquals(10, miClaveTest.generarClave().length());

	}

	@Test
	public void testValidarCantidadClaves() {
		String opciones[] = { "-T:3", "-U", "-S" };
		miClaveTest.setListaOpciones(opciones);
		ArrayList<String> listaClaves = miClaveTest.mostrarArregloClaves();
		for (String string : listaClaves) {
			System.out.println(string);
		}
		assertEquals(3, miClaveTest.mostrarArregloClaves().size());

	}

}
