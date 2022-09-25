package br.com.ryan.dynamic.queue;

/** 
 * @author Ryan Castro Ferreira
 */
public class DynamicQueue<E> implements DynamicQueueInterface<E> {
	
	private Node<E> end = null;
	private Node<E> start = null;
	
	@Override
	public boolean isEmpty() {
		return (end == null && start == null);
	}
	
	@Override
	public void insert(E e) {
		Node<E> element = new Node<E>();
		element.data = e;
		
		if (start == null) {
			end = element;
			start = element;
			element.data = null;
		} else {
			if (start == end) {
				end = element;
				start.next = end;
				end.next = null;
			} else {
				end.next = element;
				element.data = null;
				end = element;
			}
		}
	}
	
	@Override
	public E remove() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Position do not exist");
		}
		
		Node<E> temporary = start;
		if (start != null && start == end) {
			start = null;
			end = null;
		} else {
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
		Node<E> temporary = start;
		while (temporary != null) {
			count++;
			temporary = temporary.next;
		}
		
		return count;
	}
}