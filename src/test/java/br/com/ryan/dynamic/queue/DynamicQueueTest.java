package br.com.ryan.dynamic.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class DynamicQueueTest {
	
	private DynamicQueueInterface<Object> dynamicQueue;
	
	@BeforeEach
	void newInstance() {
		dynamicQueue = new DynamicQueue<Object>();
	}
	
	@Test
	@DisplayName("Empty true in new queue")
	@Order(value = 0)
	void emptyNew() {
		assertTrue(dynamicQueue.isEmpty());
	}
	
	@Test
	@DisplayName("Empty false in add item queue")
	@Order(value = 1)
	void emptyWithAddItem() {
		dynamicQueue.insert("A");
		assertFalse(dynamicQueue.isEmpty());
	}
	
	@Test
	@DisplayName("Empty true with add and remove order method")
	@Order(value = 2)
	void emptyReset() {
		dynamicQueue.insert("A");
		dynamicQueue.remove();
		
		assertTrue(dynamicQueue.isEmpty());
	}
	
	@Test
	@DisplayName("Remove index without element in throw exception")
	@Order(value = 3)
	void removeIndexOut() {
		assertThrows(IndexOutOfBoundsException.class, () -> dynamicQueue.remove());
	}
	
	@Test
	@DisplayName("Queue size 0")
	@Order(value = 4)
	void sizeZero() {
		assertEquals(0, dynamicQueue.size());
	}
}