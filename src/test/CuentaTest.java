package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;
import pkg.Movimiento;

class CuentaTest {
/*
	private static Cuenta cuenta, cuenta12345, cuenta67890;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cuenta = new Cuenta(0);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cuenta.setSaldo(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIngresar() {
		cuenta.ingresar(500.0);
		assertEquals(500.0, cuenta.getSaldo());
	}
	
	@Test
	void testRetirar() {
		cuenta.retirar(500.0);
		assertEquals(-500.0, cuenta.getSaldo());
	}
	
	// Todo en un mismo test.
	@Test
	void test0014() {
		cuenta12345 = new Cuenta(50);
		cuenta67890 = new Cuenta(0);
		
		cuenta12345.retirar(200.0);
		cuenta67890.retirar(350.0);
		cuenta12345.ingresar(100.0);
		cuenta67890.retirar(200.0);
		cuenta67890.retirar(150.0);
		cuenta12345.retirar(200.0);
		cuenta67890.ingresar(50);
		cuenta67890.retirar(100.0);
		
	}
*/
	
	private Cuenta cuenta12345;
    private Cuenta cuenta67890;

    @BeforeEach
    void setUp() {
        // Inicialización según el test case
        // 1. Crear la cuenta 12345 con un saldo inicial de 50€
        cuenta12345 = new Cuenta("12345", "Titular 12345", 50.0);
        
        // 2. Crear la cuenta 67890 con un saldo inicial de 0€
        cuenta67890 = new Cuenta("67890", "Titular 67890", 0.0);
    }

    @Test
    void testTDD0014() {
        System.out.println("=== INICIANDO TEST TDD0014 ===");
        
        // Verificar inicialización
        System.out.println("Estado inicial:");
        System.out.println("Cuenta 12345 - Saldo: " + cuenta12345.getSaldo() + "€");
        System.out.println("Cuenta 67890 - Saldo: " + cuenta67890.getSaldo() + "€");
        
        assertEquals(50.0, cuenta12345.getSaldo(), 0.001, "Saldo inicial cuenta 12345");
        assertEquals(0.0, cuenta67890.getSaldo(), 0.001, "Saldo inicial cuenta 67890");

        // 1. Reintegro de 200€ de la cuenta 12345
        System.out.println("\n1. Reintegro de 200€ de la cuenta 12345");
        cuenta12345.retirar(200.0);
        assertEquals(-150.0, cuenta12345.getSaldo(), 0.001, "Saldo después de reintegro 200€");
        System.out.println("Cuenta 12345 - Saldo: " + cuenta12345.getSaldo() + "€");

        // 2. Reintegro de 350€ de la cuenta 67890
        System.out.println("\n2. Reintegro de 350€ de la cuenta 67890");
        cuenta67890.retirar(350.0);
        assertEquals(-350.0, cuenta67890.getSaldo(), 0.001, "Saldo después de reintegro 350€");
        System.out.println("Cuenta 67890 - Saldo: " + cuenta67890.getSaldo() + "€");

        // 3. Ingreso de 100€ en la cuenta 12345
        System.out.println("\n3. Ingreso de 100€ en la cuenta 12345");
        cuenta12345.ingresar(100.0);
        assertEquals(-50.0, cuenta12345.getSaldo(), 0.001, "Saldo después de ingreso 100€");
        System.out.println("Cuenta 12345 - Saldo: " + cuenta12345.getSaldo() + "€");

        // 4. Reintegro de 200€ de la cuenta 67890 - DEBE FALLAR
        System.out.println("\n4. Reintegro de 200€ de la cuenta 67890 - DEBE FALLAR");
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            cuenta67890.retirar(200.0);
        }, "Debe fallar por fondos insuficientes (saldo: -350€)");
        
        assertTrue(exception1.getMessage().contains("Fondos insuficientes"), 
                  "Mensaje de error debe indicar fondos insuficientes");
        assertEquals(-350.0, cuenta67890.getSaldo(), 0.001, "Saldo no debe cambiar después de reintegro fallido");
        System.out.println("ERROR: " + exception1.getMessage());
        System.out.println("Cuenta 67890 - Saldo: " + cuenta67890.getSaldo() + "€");

        // 5. Reintegro de 150€ de la cuenta 67890
        System.out.println("\n5. Reintegro de 150€ de la cuenta 67890");
        cuenta67890.retirar(150.0);
        assertEquals(-500.0, cuenta67890.getSaldo(), 0.001, "Saldo después de reintegro 150€");
        System.out.println("Cuenta 67890 - Saldo: " + cuenta67890.getSaldo() + "€");

        // 6. Reintegro de 200€ de la cuenta 12345
        System.out.println("\n6. Reintegro de 200€ de la cuenta 12345");
        cuenta12345.retirar(200.0);
        assertEquals(-250.0, cuenta12345.getSaldo(), 0.001, "Saldo después de reintegro 200€");
        System.out.println("Cuenta 12345 - Saldo: " + cuenta12345.getSaldo() + "€");

        // 7. Ingreso de 50€ en la cuenta 67890
        System.out.println("\n7. Ingreso de 50€ en la cuenta 67890");
        cuenta67890.ingresar(50.0);
        assertEquals(-450.0, cuenta67890.getSaldo(), 0.001, "Saldo después de ingreso 50€");
        System.out.println("Cuenta 67890 - Saldo: " + cuenta67890.getSaldo() + "€");

        // 8. Reintegro de 100€ de la cuenta 67890 - DEBE FALLAR
        System.out.println("\n8. Reintegro de 100€ de la cuenta 67890 - DEBE FALLAR");
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            cuenta67890.retirar(100.0);
        }, "Debe fallar por fondos insuficientes (saldo: -450€)");
        
        assertTrue(exception2.getMessage().contains("Fondos insuficientes"), 
                  "Mensaje de error debe indicar fondos insuficientes");
        assertEquals(-450.0, cuenta67890.getSaldo(), 0.001, "Saldo no debe cambiar después de reintegro fallido");
        System.out.println("ERROR: " + exception2.getMessage());
        System.out.println("Cuenta 67890 - Saldo: " + cuenta67890.getSaldo() + "€");

        // VERIFICACIÓN FINAL DE RESULTADOS ESPERADOS
        System.out.println("\n=== VERIFICACIÓN FINAL ===");
        
        // Cuenta 12345: Saldo final: -250€
        System.out.println("Cuenta 12345 - Saldo final esperado: -250€, Actual: " + cuenta12345.getSaldo() + "€");
        assertEquals(-250.0, cuenta12345.getSaldo(), 0.001, 
                    "Cuenta 12345: Saldo final debe ser -250€");
        
        // Cuenta 67890: Saldo final: -450€
        System.out.println("Cuenta 67890 - Saldo final esperado: -450€, Actual: " + cuenta67890.getSaldo() + "€");
        assertEquals(-450.0, cuenta67890.getSaldo(), 0.001, 
                    "Cuenta 67890: Saldo final debe ser -450€");
        
        // Verificar movimientos - CON BUCLE TRADICIONAL
        System.out.println("\nMovimientos Cuenta 12345:");
        for (int i = 0; i < cuenta12345.getMovimientos().size(); i++) {
            Movimiento mov = cuenta12345.getMovimientos().get(i);
            String signo = (mov.getSigno() == Movimiento.Signo.H ? "+" : "-");
            System.out.println("- " + mov.getDetalle() + ": " + signo + mov.getImporte() + "€");
        }
        
        System.out.println("\nMovimientos Cuenta 67890:");
        for (int i = 0; i < cuenta67890.getMovimientos().size(); i++) {
            Movimiento mov = cuenta67890.getMovimientos().get(i);
            String signo = (mov.getSigno() == Movimiento.Signo.H ? "+" : "-");
            System.out.println("- " + mov.getDetalle() + ": " + signo + mov.getImporte() + "€");
        }

        System.out.println("\n=== TEST TDD0014 COMPLETADO EXITOSAMENTE ===");
    }
	
}
