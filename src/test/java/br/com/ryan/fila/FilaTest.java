package br.com.ryan.fila;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Fila")
class FilaTest {
	
	private FilaInterface<Object> dynamicQueue;
	
	@BeforeEach
	void setUp() {
		dynamicQueue = new Fila<>();
	}
	
	@Test
	@DisplayName("Empty true in new queue")
	void emptyNew() {
		assertTrue(dynamicQueue.isEmpty());
	}
	
	@Test
	@DisplayName("Empty false in add item queue")
	void emptyWithAddItem() {
		dynamicQueue.insert("A");
		assertFalse(dynamicQueue.isEmpty());
	}
	
	@Test
	@DisplayName("Empty true with add and remove order method")
	void emptyReset() {
		dynamicQueue.insert("A");
		dynamicQueue.remove();
		
		assertTrue(dynamicQueue.isEmpty());
	}
	
	@Test
	@DisplayName("Remove index without element in throw exception")
	void removeIndexOut() {
		assertThrows(IndexOutOfBoundsException.class, () -> dynamicQueue.remove());
	}
	
	@Test
	@DisplayName("Queue size 0")
	void sizeZero() {
		assertEquals(0, dynamicQueue.size());
	}
	
	@Test
	@DisplayName("Size add items")
	void sizeItems() {
		final int SIZE_LOOP = 12;
		
		for (int i=0; i<SIZE_LOOP; i++) {
			dynamicQueue.insert(i);
		}
		
		assertEquals(SIZE_LOOP, dynamicQueue.size());
	}
	
	@Test
	@DisplayName("Size 0 items add - remove")
	void sizeZeroAddAndRemoveItems() {
		final int SIZE_LOOP = 20;
		
		for (int i=0; i<SIZE_LOOP; i++) {
			dynamicQueue.insert(i);
		}
		
		for (int i=0; i<SIZE_LOOP; i++) {
			dynamicQueue.remove();
		}
		
		assertEquals(0, dynamicQueue.size());
	}
	
	@Test
	@DisplayName("Remove get")
	void removeGetValue() {
		Object value = "A";
		dynamicQueue.insert(value);
		
		assertEquals(value, dynamicQueue.remove());
	}
	
	@Test
	@DisplayName("Table test")
	void tableTest() {
		final List<Integer> LIST = Arrays.asList(36,28,146,14,-65,117,-40,24,138,116);
		
		for (final Integer VALUE : LIST) {
			ruleLoop(VALUE);
		}
		
		assertEquals(8, dynamicQueue.size());
		
		final List<Integer> LIST_RESULT = Arrays.asList(156,24,-65,127,-40,34,148,126);
		for (final Integer VALUE : LIST_RESULT) {
			assertEquals(VALUE, dynamicQueue.remove());
		}
	}

	private void ruleLoop(final Integer VALUE) {
		if (dynamicQueue.isEmpty()) {
			dynamicQueue.insert(VALUE * 10);
		}
		else if (VALUE >= 10) {
			dynamicQueue.insert(VALUE + 10);	
		}
		else if (VALUE < 0) {
			dynamicQueue.remove();
			dynamicQueue.insert(VALUE);
		}
	}
}