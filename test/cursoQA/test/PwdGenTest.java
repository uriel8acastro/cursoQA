package cursoQA.test;
/**
 * 
 */


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cursoQA.source.PwdGenKey;
import cursoQA.source.PwdGenValidateIngress;

/**
 * unit tests
 * @author cesar 
 * 
 *
 */
public class PwdGenTest {

	PwdGenKey myKeyTest;
	PwdGenValidateIngress myInTest;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myKeyTest = new PwdGenKey();
		myInTest = new PwdGenValidateIngress();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validateInformationOptionTest() {
		String options[] = { "-?" };
		myInTest.setListOptionsEntered(options);
		Boolean isOk = myInTest.validateEnteredOptions();
		assertEquals(false, isOk);

	}

	@Test
	public void validateInclusionOptionTest() {
		String options[] = { "-U", "-L", "-N", "-S" };
		myInTest.setListOptionsEntered(options);
		Boolean isOK = myInTest.validateEnteredOptions();
		assertEquals(true, isOK);

	}

	@Test
	public void validateInvalidOptionTest() {
		String options[] = { "-U", "-L", "-N", "-S", "-Z" };
		myInTest.setListOptionsEntered(options);
		Boolean isOK = myInTest.validateEnteredOptions();
		assertEquals(false, isOK);

	}

	@Test
	public void validateInvalidModifiersTest() {
		String options[] = { "-U:55", "-L", "-S" };
		myInTest.setListOptionsEntered(options);
		Boolean isOK = myInTest.validateEnteredOptions();
		assertEquals(false, isOK);

	}

	@Test
	public void validateModifiersOfOptionsTest() {
		String modifiersOptions[] = { "-T:3", "-Size:10", "-E:%$#" };
		myInTest.setListOptionsEntered(modifiersOptions);
		assertEquals(true, myInTest.validateEnteredOptions());

	}

	@Test
	public void validateKeyWithUpperCaseTest() {
		String options[] = { "-U" };
		myKeyTest.setOptionsList(options);
		String keyTest = myKeyTest.generatePassword();
		System.out.println(keyTest);
		assertEquals(true, keyTest.matches("[A-Z]*"));

	}

	@Test
	public void testValidarClaveMinusculas() {
		String options[] = { "-L" };
		myKeyTest.setOptionsList(options);
		String keyTest = myKeyTest.generatePassword();
		System.out.println(keyTest);
		assertEquals(true, keyTest.matches("[a-z]*"));

	}

	@Test
	public void validateKeyWithNumbersTest() {
		String options[] = { "-N" };
		myKeyTest.setOptionsList(options);
		String keyTes = myKeyTest.generatePassword();
		System.out.println(keyTes);
		assertEquals(true, keyTes.matches("[0-9]*"));

	}

	@Test
	public void validateKeyWithSymbolsTest() {
		String options[] = { "-S" };
		myKeyTest.setOptionsList(options);
		String keyTes = myKeyTest.generatePassword();
		System.out.println(keyTes);
		assertEquals(true, keyTes.matches("[$|#|&|@|%]*"));

	}

	@Test
	public void validateKeyWithLowerCaseTest() {
		String options[] = { "-L", "-U" };
		myKeyTest.setOptionsList(options);
		String keyTes = myKeyTest.generatePassword();
		System.out.println(keyTes);
		assertEquals(true, keyTes.matches("[a-z|A-Z]*"));

	}

	@Test
	public void validateKeyUpperAndLowerCaseTest() {
		String options[] = { "-U", "-N" };
		myKeyTest.setOptionsList(options);
		String keyTes = myKeyTest.generatePassword();
		System.out.println(keyTes);
		assertEquals(true, keyTes.matches("[A-Z|0-9]*"));

	}

	@Test
	public void validateKeyNumberAndLowerCaseTest() {
		String options[] = { "-L", "-N" };
		myKeyTest.setOptionsList(options);
		String keyTes = myKeyTest.generatePassword();
		System.out.println(keyTes);
		assertEquals(true, keyTes.matches("[a-z|0-9]*"));

	}

	@Test
	public void validateKeyUpperCaseAndSymbolsTest() {
		String options[] = { "-U", "-S" };
		myKeyTest.setOptionsList(options);
		String keyTes = myKeyTest.generatePassword();
		System.out.println(keyTes);
		assertEquals(true, keyTes.matches("[A-Z|$|#|&|@|%]*"));

	}

	@Test
	public void validateKeySymbolsAndLowerCaseTest() {
		String options[] = { "-L", "-S" };
		myKeyTest.setOptionsList(options);
		String keyTes = myKeyTest.generatePassword();
		System.out.println(keyTes);
		assertEquals(true, keyTes.matches("[a-z|$|#|&|@|%]*"));

	}

	@Test
	public void validateKeyUpperLowerSymbolsTest() {
		String options[] = { "-L", "-S", "-U" };
		myKeyTest.setOptionsList(options);
		String keyTes = myKeyTest.generatePassword();
		System.out.println(keyTes);
		assertEquals(true, keyTes.matches("[a-z|$|#|&|@|%|A-Z]*"));

	}

	@Test
	public void validateKeyUpperSymbolsNumbersTest() {
		String options[] = { "-L", "-S", "-U", "-N" };
		myKeyTest.setOptionsList(options);
		String keyTes = myKeyTest.generatePassword();
		System.out.println(keyTes);
		assertEquals(true, keyTes.matches("[a-z|$|#|&|@|%|A-Z|0-9]*"));

	}

	@Test
	public void validateKeySizeTest() {
		String options[] = { "-Size:10", "-U" };
		myKeyTest.setOptionsList(options);
		assertEquals(10, myKeyTest.generatePassword().length());

	}

	@Test
	public void validateAmountKeysTest() {
		String options[] = { "-T:3", "-U", "-S" };
		myKeyTest.setOptionsList(options);
		ArrayList<String> keysList = myKeyTest.showArrayOfKeys();
		for (String string : keysList) {
			System.out.println(string);
		}
		assertEquals(3, myKeyTest.showArrayOfKeys().size());

	}

}
