package br.com.ryan.fixed.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.ryan.fixed.queue.FixedQueue;

@TestInstance(Lifecycle.PER_CLASS)
class FixedQueueTest {
	private FixedQueue filaEstatica;
	
	@BeforeEach
	void instance() {
		 filaEstatica = new FixedQueue();
	}
	
	@Test
	@DisplayName("New instance to array")
	void inicialize() {
		assertEquals(0, filaEstatica.size());
		
		for (byte i=0; i<10; i++) {
			assertEquals(null, filaEstatica.get(i));
		}
		
		assertNull(filaEstatica.print());
	}
	
	@Test
	void add() {
		filaEstatica.add("0");
		assertEquals(1, filaEstatica.size());
		assertEquals("0", filaEstatica.get(0));
		
		assertEquals("[0]", filaEstatica.print());
	}
	
	@Test
	void addMax() {
		for (byte i=1; i<11; i++) {
			filaEstatica.add(Integer.toString(i));
		}
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> filaEstatica.add("11"));
		assertEquals("[1,2,3,4,5,6,7,8,9,10]", filaEstatica.print());
	}
	
	@Test
	void getIndexNegative() {
		assertThrows(IndexOutOfBoundsException.class, () -> filaEstatica.get(-1));
	}
	
	@Test
	void getIndexZero() {
		assertNull(filaEstatica.get(0));
	}
	
	@Test
	void getIndexPositive() {
		assertNull(filaEstatica.get(1));
	}
	
	@Test
	void containsIndexNegative() {
		assertFalse(filaEstatica.contains(-1));
	}
	
	@Test
	void containsIndexZero() {
		assertFalse(filaEstatica.contains(0));
	}
	
	@Test
	void containsIndexPositive() {
		assertFalse(filaEstatica.contains(1));
	}
	
	@Test
	void containsWithNull() {
		assertFalse(filaEstatica.contains(null));
	}
	
	@Test
	void containsWithNewInstance() {
		assertFalse(filaEstatica.contains(new Object()));
	}
	
	@Test
	void containsWithInstance() {
		Object param = new Object();
		assertFalse(filaEstatica.contains(param));
	}
	
	@Test
	void removeIndexNegative() {
		assertFalse(filaEstatica.remove(-1));
	}
	
	@Test
	void removeIndexZero() {
		assertFalse(filaEstatica.remove(0));
	}
	
	@Test
	void removeIndexPositive() {
		assertFalse(filaEstatica.remove(1));
	}
	
	@Test
	void removeObjWithNull() {
		assertFalse(filaEstatica.remove(null));
	}
	
	@Test
	void removeObjWithNewInstance() {
		assertFalse(filaEstatica.remove(new Object()));
	}
	
	@Test
	void removeObjWithInstance() {
		Object param = new Object();
		assertFalse(filaEstatica.remove(param));
	}
}