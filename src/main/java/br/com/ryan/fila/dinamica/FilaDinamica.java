package br.com.ryan.fila.dinamica;

/** 
 * @author Ryan Castro Ferreira
 */
public class FilaDinamica<E> implements FilaDinamicaInterface<E> {
	
	private No<E> previous = null;
	private No<E> next = null;
	
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