package br.com.ryan.fila.estatica;

public interface FilaEstaticaInterface {
	
	public void add(Object value);
	public void add(int size, Object value);
	public int size();
	public String print();
	public Object get(int index);
	public boolean contains(int index);
	public boolean contains(Object reference);
	public boolean remove(int index);
	public boolean remove(Object reference);
}