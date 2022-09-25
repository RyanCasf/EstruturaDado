package br.com.ryan.dynamic.queue;

/** 
 * @author Ryan Castro Ferreira
 */
public class DynamicQueue<E> implements DynamicQueueInterface<E> {
	
	private Node<E> previous = null;
	private Node<E> next = null;
	
	@Override
	public boolean isEmpty() {
		return (previous == null && next == null);
	}
	
	@Override
	public void insert(Object e) {
		
	}
	
	@Override
	public E remove() {
		return null;
	}
	
	@Override
	public int size() {
		return 0;
	}
}