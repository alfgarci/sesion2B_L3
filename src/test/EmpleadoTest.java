package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;

class EmpleadoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	void testCalculoNominaBrutaVendedor() {
	    float expected = 2000;
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 0, 0);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaEncargado() {
	    float expected = 2500; // Salario base para Encargado con 0 ventas y 0 horas extra
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 0, 0);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaVendedorPrimas100() {
	    float expected = 2100; // Salario base 2000 + 100 de prima por ventas entre 1000 y 1500
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1345, 0);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaVendedorPrimas200() {
	    float expected = 2200; // Salario base 2000 + 200 de prima por ventas superiores a 1500
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1501, 0);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaEncargadoPrimas100() {
	    float expected = 2600; // Salario base 2500 + 100 de prima por ventas entre 1000 y 1500
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 1345, 0);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaEncargadoPrimas200() {
	    float expected = 2700; // Salario base 2500 + 200 de prima por ventas superiores a 1500
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 1501, 0);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaVendedorExtras() {
	    float expected = 2460; // Salario base 2000 + 100 de prima + 260 por 12 horas extra (12 * 30)
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1345, 12);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaEncargadoExtra() {
	    float expected = 3210; // Salario base 2500 + 200 de prima + 510 por 17 horas extra (17 * 30)
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 2300, 17);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaEncargadoExtraNegativo() {
	    float expected = 1990; // Salario base 2500, sin prima ni extras (ventas y horas negativas)
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, -2300, -17);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaNetaRetencion0() {
	    float expected = 2000; // Salario bruto de 2000, sin retención (bruto <= 2000)
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaNeta(2000);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaNetaRetencion15() {
	    float expected = 2091; // Salario bruto de 2460, retención del 15% (bruto entre 2000 y 2500)
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaNeta(2460);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaNetaRetencion18() {
	    float expected = 2665; // Salario bruto de 3250, retención del 18% (bruto > 2500)
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaNeta(3250);
	    
	    assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaNetaRetencionNegativa() {
	    float expected = -2050; // Salario negativo, no hay retención
	    Empleado e = new Empleado();
	    float actual = e.calculoNominaNeta(-2050);
	    
	    assertEquals(expected, actual);
	}


}
