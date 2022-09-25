package br.com.ryan.fila.dinamica;

public interface FilaDinamicaInterface<E> {
	
	boolean isEmpty();
	void insert(E e);
	E remove();
	int size();
}