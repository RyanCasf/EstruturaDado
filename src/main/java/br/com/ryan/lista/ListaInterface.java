package br.com.ryan.lista;

interface ListaInterface {
	
	void add(Object value);
	void add(int index, Object value);
	int size();
	Object get(int index);
	boolean contains(Object reference);
	boolean remove(int index);
	boolean remove(Object reference);
}