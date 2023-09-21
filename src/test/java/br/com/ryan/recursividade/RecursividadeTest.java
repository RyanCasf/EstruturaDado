package br.com.ryan.recursividade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Recursividade")
class RecursividadeTest {
	
	private Recursividade recursividade;
	
	@BeforeEach
	void novo() {
		recursividade = new Recursividade();
	}
	
	@Test
	@DisplayName("Fatorial sobre 1 passando zero.")
	void fatorialSobreZerado() {
		assertEquals(0.0, recursividade.fatorialSobre(0));
	}
	
	@Test
	@DisplayName("Fatorial sobre 1 passando negativo.")
	void fatorialSobreNegativo() {
		assertThrows(IllegalArgumentException.class, () -> recursividade.fatorialSobre(-1));
	}
	
	@Test
	@DisplayName("Fatorial sobre 1 passando positivo.")
	void fatorialSobrePositivo() {
		assertEquals(1.0, recursividade.fatorialSobre(1));
	}
	
	@Test
	@DisplayName("Fatorial zerado.")
	void fatorialZerado() {
		assertEquals(1, recursividade.fatorial(0));
	}
	
	@Test
	@DisplayName("Fatorial negativo.")
	void fatorialNegativo() {
		assertThrows(IllegalArgumentException.class, () -> recursividade.fatorial(-1));
	}
	
	@Test
	@DisplayName("Fatorial positivo.")
	void fatorialPositivo() {
		assertEquals(1, recursividade.fatorial(1));
	}
	
	@Test
	@DisplayName("Fibonacci zerado.")
	void fibonacciZerado() {
		assertEquals(0, recursividade.fibonacci(0));
	}
	
	@Test
	@DisplayName("Fibonacci negativo.")
	void fibonacciNegativo() {
		assertThrows(IllegalArgumentException.class, () -> recursividade.fibonacci(-1));
	}
	
	@Test
	@DisplayName("Fibonacci positivo.")
	void fibonacciPositivo() {
		assertEquals(1, recursividade.fibonacci(1));
		assertEquals(1, recursividade.fibonacci(2));
	}
	
	@Test
	@DisplayName("Somar positivo passando zero.")
	void somarPositivoComZero() {
		assertEquals(0, recursividade.somar(0));
	}
	
	@Test
	@DisplayName("Somar positivo passando negativo.")
	void somarPositivoComNegativo() {
		assertEquals(-1, recursividade.somar(-1));
		assertEquals(-55, recursividade.somar(-10));
	}
	
	@Test
	@DisplayName("Somar positivo passando positivo.")
	void somarPositivoComPositivo() {
		assertEquals(1, recursividade.somar(1));
		assertEquals(55, recursividade.somar(10));
	}
	
	@Test
	@DisplayName("Somar sobre zerado.")
	void somarSobreZerado() {
		assertEquals(0, recursividade.somarSobre(0));
	}
	
	@Test
	@DisplayName("Somar sobre negativo.")
	void somarSobreNegativo() {
		assertEquals(-1, recursividade.somarSobre(-1));
	}
	
	@Test
	@DisplayName("Somar sobre positivo.")
	void somarSobrePositivo() {
		assertEquals(1, recursividade.somarSobre(1));
	}
}