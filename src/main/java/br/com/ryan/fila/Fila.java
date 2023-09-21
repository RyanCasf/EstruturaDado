package br.com.ryan.fila;

public class Fila<E> implements FilaInterface<E> {
	
	private No<E> end = null;
	private No<E> start = null;
	
	@Override
	public boolean isEmpty() {
		return (end == null && start == null);
	}
	
	@Override
	public void insert(E e) {
		No<E> element = new No<>();
		element.data = e;
		
		if (start == null) {
			end = element;
			start = element;
			element.next = null;
		} 
		else {
			if (start == end) {
				end = element;
				start.next = end;
				end.next = null;
			} 
			else {
				end.next = element;
				element.next = null;
				end = element;
			}
		}
	}
	
	@Override
	public E remove() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Position do not exist");
		}
		
		No<E> temporary = start;
		if (start != null && start == end) {
			start = null;
			end = null;
		} 
		else {
			start = start.next;
		}
		
		return temporary.data;
	}
	
	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		
		int count = 0;
		No<E> temporary = start;
		while (temporary != null) {
			count++;
			temporary = temporary.next;
		}
		
		return count;
	}
}