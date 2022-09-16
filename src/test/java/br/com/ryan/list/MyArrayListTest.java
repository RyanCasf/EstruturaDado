package br.com.ryan.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class MyArrayListTest {
	MyArrayList array;
	
	@BeforeEach
	void instance() {
		 array = new MyArrayList();
	}
	
	@Test
	@DisplayName("New instance to array")
	@Order(value = 0)
	void inicialize() {
		assertEquals(0, array.size());
		
		for (byte i=0; i<10; i++) {
			assertEquals(null, array.get(i));
		}
		
		assertNull(array.print());
	}
	
	@Test
	@Order(value = 1)
	void add() {
		array.add("0");
		assertEquals(1, array.size());
		assertEquals("0", array.get(0));
		
		assertEquals("[0]", array.print());
	}
	
	@Test
	@Order(value = 2)
	void addMax() {
		for (byte i=1; i<11; i++) {
			array.add(Integer.toString(i));
		}
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.add("11"));
		assertEquals("[1,2,3,4,5,6,7,8,9,10]", array.print());
	}
}