package br.com.ryan.lista;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ListaTest {

	private Lista fixedQueue;
	
	@BeforeEach
	void instance() {
		 fixedQueue = new Lista();
	}
	
	@Test
	@DisplayName("New instance to array")
	void init() {
		Assertions.assertEquals(0, fixedQueue.size());

		final int COUNT = 10;
		for (byte i=0; i<COUNT; i++) {
			assertNull(fixedQueue.get(i));
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
		final int COUNT = 11;
		for (byte i=1; i<COUNT; i++) {
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
	void getIndexWithoutElements() {
		assertNull(fixedQueue.get(1));
	}
	
	@Test
	@DisplayName("Contains element index negative false")
	void containsIndexNegativeFalse() {
		assertFalse(fixedQueue.contains(-1));
	}
	
	@Test
	@DisplayName("Contains element index zero false")
	void containsIndexZeroFalse() {
		assertFalse(fixedQueue.contains(0));
	}
	
	@Test
	@DisplayName("Contains element index false")
	void containsIndexPositiveFalse() {
		assertFalse(fixedQueue.contains(1));
	}
	
	@Test
	@DisplayName("Contains element with value null false")
	void containsWithNullFalse() {
		assertFalse(fixedQueue.contains(null));
	}
	
	@Test
	@DisplayName("Contains element in new instance false")
	void containsWithNewInstanceFalse() {
		assertFalse(fixedQueue.contains(new Object()));
	}
	
	@Test
	@DisplayName("Contains element in new instance paramFalse")
	void containsWithInstanceFalse() {
		Object param = new Object();
		assertFalse(fixedQueue.contains(param));
	}
	
	@Test
	@DisplayName("Remove element in index negative false")
	void removeIndexNegativeFalse() {
		assertFalse(fixedQueue.remove(-1));
	}
	
	@Test
	@DisplayName("Remove element in index zero false")
	void removeIndexZeroFalse() {
		assertFalse(fixedQueue.remove(0));
	}
	
	@Test
	@DisplayName("Remove element in index false")
	void removeIndexPositiveFalse() {
		assertFalse(fixedQueue.remove(1));
	}
	
	@Test
	@DisplayName("Remove element in object null false")
	void removeObjWithNullFalse() {
		assertFalse(fixedQueue.remove(null));
	}
	
	@Test
	@DisplayName("Remove element in object new instance false")
	void removeObjWithNewInstanceFalse() {
		assertFalse(fixedQueue.remove(new Object()));
	}
	
	@Test
	@DisplayName("Remove element in object null param false")
	void removeObjWithInstanceFalse() {
		Object param = new Object();
		assertFalse(fixedQueue.remove(param));
	}
}