/**
 * 
 */
package cursoQA.testUnitarios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cursoQA.fuentes.Clave;
import cursoQA.fuentes.Entrada;
import junit.framework.Assert;

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
	public void testValidarClaveMayusculas() {
		String opciones[] = { "U" };
		int longitudClave = 16;
		String claveTest = miClaveTest.generarClave(opciones, longitudClave);
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[A-Z]*"));

	}

	@Test
	public void testValidarClaveMinusculas() {
		String opciones[] = { "L" };
		int longitudClave = 16;
		String claveTest = miClaveTest.generarClave(opciones, longitudClave);
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[a-z]*"));

	}

	@Test
	public void testValidarClaveNumeros() {
		String opciones[] = { "N" };
		int longitudClave = 16;
		String claveTest = miClaveTest.generarClave(opciones, longitudClave);
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[0-9]*"));

	}

	@Test
	public void testValidarClaveSimbolos() {
		String opciones[] = { "S" };
		int longitudClave = 16;
		String claveTest = miClaveTest.generarClave(opciones, longitudClave);
		System.out.println(claveTest);
		assertEquals(true, claveTest.matches("[$|#|&|@|%]*"));

	}

	@Test
	public void testValidarLongituClave() {
		String opciones[] = { "U" };
		int longitudClave = 1;
		assertEquals(1, miClaveTest.generarClave(opciones, longitudClave).length());
		longitudClave = 8;
		assertEquals(8, miClaveTest.generarClave(opciones, longitudClave).length());
		longitudClave = 16;
		assertEquals(16, miClaveTest.generarClave(opciones, longitudClave).length());
	}

	@Test
	public void testValidarOpcionsModificadores() {
		String opcionesModificadas[] = { "T:3", "Size:10", "E:3" };
		miEntradaTest.setListaOpcionesIngresadas(opcionesModificadas);
		assertEquals(true, miEntradaTest.validarOpcionesIngresadas());

	}

}
