package edu.iua.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaTest {

	public PruebaTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	@Disabled
	void prueba() {
		assertEquals(1, 1);
	}
	
	int suma(int a, int b) {
		return a+b;
	}
	
	@Test
	@Disabled
	void testSuma() {
		// 1) Definir valor esperado
		int expectedResult = 5;
		
		// 2) Llamar al metodo y guardarlo en la variable resultado
		int result = suma(2,3);

		// 3) Probar la igualdad de los dos valores
		assertEquals(result, expectedResult);
	}
	
}