package br.com.ryan.fila;

public interface FilaInterface<E> {
	
	boolean isEmpty();
	void insert(E e);
	E remove();
	int size();
}