package br.com.ryan.list;

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
class MyArrayListTest {
	private MyArrayList array;
	
	@BeforeEach
	void instance() {
		 array = new MyArrayList();
	}
	
	@Test
	@DisplayName("New instance to array")
	void inicialize() {
		assertEquals(0, array.size());
		
		for (byte i=0; i<10; i++) {
			assertEquals(null, array.get(i));
		}
		
		assertNull(array.print());
	}
	
	@Test
	void add() {
		array.add("0");
		assertEquals(1, array.size());
		assertEquals("0", array.get(0));
		
		assertEquals("[0]", array.print());
	}
	
	@Test
	void addMax() {
		for (byte i=1; i<11; i++) {
			array.add(Integer.toString(i));
		}
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.add("11"));
		assertEquals("[1,2,3,4,5,6,7,8,9,10]", array.print());
	}
	
	@Test
	void getIndexNegative() {
		assertThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
	}
	
	@Test
	void getIndexZero() {
		assertNull(array.get(0));
	}
	
	@Test
	void getIndexPositive() {
		assertNull(array.get(1));
	}
	
	@Test
	void containsIndexNegative() {
		assertFalse(array.contains(-1));
	}
	
	@Test
	void containsIndexZero() {
		assertFalse(array.contains(0));
	}
	
	@Test
	void containsIndexPositive() {
		assertFalse(array.contains(1));
	}
	
	@Test
	void containsWithNull() {
		assertFalse(array.contains(null));
	}
	
	@Test
	void containsWithNewInstance() {
		assertFalse(array.contains(new Object()));
	}
	
	@Test
	void containsWithInstance() {
		Object param = new Object();
		assertFalse(array.contains(param));
	}
	
	@Test
	void removeIndexNegative() {
		assertFalse(array.remove(-1));
	}
	
	@Test
	void removeIndexZero() {
		assertFalse(array.remove(0));
	}
	
	@Test
	void removeIndexPositive() {
		assertFalse(array.remove(1));
	}
	
	@Test
	void removeObjWithNull() {
		assertFalse(array.remove(null));
	}
	
	@Test
	void removeObjWithNewInstance() {
		assertFalse(array.remove(new Object()));
	}
	
	@Test
	void removeObjWithInstance() {
		Object param = new Object();
		assertFalse(array.remove(param));
	}
}