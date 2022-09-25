package br.com.ryan.fila.dinamica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class FilaDinamicaTeste {
	
	private FilaDinamicaInterface<Object> filaDinamica;
	
	@BeforeEach
	void newInstance() {
		filaDinamica = new FilaDinamica<Object>();
	}
	
	@Test
	void emptyNew() {
		assertTrue(filaDinamica.isEmpty());
	}
	
	@Test
	void emptyWithAddItem() {
		filaDinamica.insert("A");
		assertFalse(filaDinamica.isEmpty());
	}
	
	@Test
	void emptyReset() {
		filaDinamica.insert("A");
		filaDinamica.remove();
		
		assertTrue(filaDinamica.isEmpty());
	}
	
	@Test
	void emptyRemoveDouble() {
		filaDinamica.insert("A");
		filaDinamica.remove();
		filaDinamica.remove();
		
		assertTrue(filaDinamica.isEmpty());
	}
	
	@Test
	void addValueFixed(Object e) {
		final String valor = "A";
		filaDinamica.insert(valor);
		
		assertEquals(valor, filaDinamica.remove());
	}
	
	@Test
	void addNull(Object e) {
		filaDinamica.insert(null);
		assertNull(filaDinamica.remove());
	}
	
	@Test
	void removeIndexOff() {
		assertThrows(IndexOutOfBoundsException.class, () -> filaDinamica.remove());
	}
	
	@Test
	void sizeZero() {
		assertEquals(0, filaDinamica.size());
	}
}