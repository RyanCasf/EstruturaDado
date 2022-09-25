package br.com.ryan.dynamic.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
	
	@Test
	@DisplayName("Size with random add itens")
	@Order(value = 5)
	void sizeRandomItens() {
		Random random = new Random();
		
		final int SIZE_LOOP = (Math.abs(random.nextInt(10)) + 1) * 3;
		for (int i=0; i<SIZE_LOOP; i++) {
			dynamicQueue.insert(i);
		}
		
		assertEquals(SIZE_LOOP, dynamicQueue.size());
	}
	
	@Test
	@DisplayName("Size 0 with random itens add - remove")
	@Order(value = 6)
	void sizeZeroRandomAddAndRemoveItens() {
		Random random = new Random();
		
		final int SIZE_LOOP = Math.abs(random.nextInt(10)) + 1;
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
	@Order(value = 7)
	void removeGetValue() {
		final Object PARAM = "A";
		dynamicQueue.insert(PARAM);
		Object RETURN = dynamicQueue.remove();
		
		assertEquals(RETURN, PARAM);
	}
	
	@Test
	@DisplayName("Table test")
	@Order(value = 8)
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