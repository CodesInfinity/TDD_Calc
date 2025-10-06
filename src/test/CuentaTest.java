package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {

	Cuenta cuenta;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		this.cuenta = new Cuenta(0);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIngresar() {
		cuenta.ingresar(500);
		assertEquals(500, cuenta.getSaldo());
	}
	
	@Test
	void testRetirar() {
		cuenta.retirar(500);
		assertEquals(-500, cuenta.getSaldo());
	}


}
