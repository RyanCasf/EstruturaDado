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

@TestInstance(Lifecycle.PER_CLASS)
class FixedQueueTest {
	private FixedQueue fixedQueue;
	
	@BeforeEach
	void instance() {
		 fixedQueue = new FixedQueue();
	}
	
	@Test
	@DisplayName("New instance to array")
	void inicialize() {
		assertEquals(0, fixedQueue.size());
		
		for (byte i=0; i<10; i++) {
			assertEquals(null, fixedQueue.get(i));
		}
		
		assertNull(fixedQueue.print());
	}
	
	@Test
	@DisplayName("Add one value to array")
	void add() {
		fixedQueue.add("0");
		assertEquals(1, fixedQueue.size());
		assertEquals("0", fixedQueue.get(0));
		
		assertEquals("[0]", fixedQueue.print());
	}
	
	@Test
	@DisplayName("Add max (10) values to array, duplicate vector")
	void addMax() {
		for (byte i=1; i<11; i++) {
			fixedQueue.add(Integer.toString(i));
		}
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> fixedQueue.add("11"));
		assertEquals("[1,2,3,4,5,6,7,8,9,10]", fixedQueue.print());
	}
	
	@Test
	@DisplayName("Get element in get index negative")
	void getIndexNegative() {
		assertThrows(IndexOutOfBoundsException.class, () -> fixedQueue.get(-1));
	}
	
	@Test
	@DisplayName("Get element in get index zero")
	void getIndexZero() {
		assertNull(fixedQueue.get(0));
	}
	
	@Test
	@DisplayName("Get element in get index without elements")
	void getIndexPositive() {
		assertNull(fixedQueue.get(1));
	}
	
	@Test
	@DisplayName("Contains element index negative")
	void containsIndexNegative() {
		assertFalse(fixedQueue.contains(-1));
	}
	
	@Test
	@DisplayName("Contains element index zero")
	void containsIndexZero() {
		assertFalse(fixedQueue.contains(0));
	}
	
	@Test
	@DisplayName("Contains element index")
	void containsIndexPositive() {
		assertFalse(fixedQueue.contains(1));
	}
	
	@Test
	@DisplayName("Contains element with value null")
	void containsWithNull() {
		assertFalse(fixedQueue.contains(null));
	}
	
	@Test
	@DisplayName("Contains element in new instance")
	void containsWithNewInstance() {
		assertFalse(fixedQueue.contains(new Object()));
	}
	
	@Test
	@DisplayName("Contains element in new instance param")
	void containsWithInstance() {
		Object param = new Object();
		assertFalse(fixedQueue.contains(param));
	}
	
	@Test
	@DisplayName("Remove element in index negative")
	void removeIndexNegative() {
		assertFalse(fixedQueue.remove(-1));
	}
	
	@Test
	@DisplayName("Remove element in index zero")
	void removeIndexZero() {
		assertFalse(fixedQueue.remove(0));
	}
	
	@Test
	@DisplayName("Remove element in index")
	void removeIndexPositive() {
		assertFalse(fixedQueue.remove(1));
	}
	
	@Test
	@DisplayName("Remove element in object null")
	void removeObjWithNull() {
		assertFalse(fixedQueue.remove(null));
	}
	
	@Test
	@DisplayName("Remove element in object new instance")
	void removeObjWithNewInstance() {
		assertFalse(fixedQueue.remove(new Object()));
	}
	
	@Test
	@DisplayName("Remove element in object null param")
	void removeObjWithInstance() {
		Object param = new Object();
		assertFalse(fixedQueue.remove(param));
	}
}