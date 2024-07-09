package br.com.ryan.lista;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ListImpTest {

	private ListImp fixedQueue;
	
	@BeforeEach
	void instance() {
		 fixedQueue = new ListImp();
	}
	
	@Test
	@DisplayName("New instance to array")
	void init() {
		assertEquals(0, fixedQueue.size());
		
		final int COUNT = 10;
		for (byte i=0; i<COUNT; i++) {
			fixedQueue.add(i);
			assertEquals(i, fixedQueue.get(i));
		}
	}
	
	@Test
	@DisplayName("Add one value to array")
	void add() {
		fixedQueue.add("0");

		assertEquals(1, fixedQueue.size());
		assertEquals("0", fixedQueue.get(0));
	}
	
	@Test
	@DisplayName("Add max (10) values to array, duplicate vector")
	void addMax() {
		final int COUNT = 11;
		for (byte i=1; i<COUNT; i++) {
			fixedQueue.add(Integer.toString(i));
		}
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> fixedQueue.add("11"));
	}
	
	@Test
	@DisplayName("Add with negative index")
	void addWithNegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> fixedQueue.add(-1, null));
	}
	
	@Test
	@DisplayName("Add with index zero")
	void addWithIndexZero() {
		assertThrows(IndexOutOfBoundsException.class, () -> fixedQueue.add(0, null));
	}
	
	@Test
	@DisplayName("Add with index")
	void addWithIndex() {
		final String expected = "test";

		fixedQueue.add("0");
		fixedQueue.add(0, expected);
		
		assertEquals(expected, fixedQueue.get(0));
	}
	
	@Test
	@DisplayName("Get element in get index negative")
	void getIndexNegative() {
		fixedQueue.add(null);
		assertThrows(IndexOutOfBoundsException.class, () -> fixedQueue.get(-1));
	}
	
	@Test
	@DisplayName("Get element in get index zero without elements")
	void getIndexZeroWithoutElements() {
		assertThrows(IndexOutOfBoundsException.class, () -> fixedQueue.get(0));
	}
	
	@Test
	@DisplayName("Get element in get index without elements")
	void getIndexWithoutElements() {
		fixedQueue.add(null);
		assertThrows(IndexOutOfBoundsException.class, () -> fixedQueue.get(1));
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
	@DisplayName("Contains element in new instance param false")
	void containsWithInstanceFalse() {
		Object param = new Object();
		assertFalse(fixedQueue.contains(param));
	}
	
	@Test
	@DisplayName("Contains for nullable")
	void containsForNullable() {
		fixedQueue.add("0");
		fixedQueue.add(null);
		fixedQueue.add("2");
		
		assertTrue(fixedQueue.contains(null));
	}
	
	@Test
	@DisplayName("Contains")
	void contains() {
		fixedQueue.add(null);
		fixedQueue.add("1");
		fixedQueue.add("2");
		
		assertTrue(fixedQueue.contains("2"));
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