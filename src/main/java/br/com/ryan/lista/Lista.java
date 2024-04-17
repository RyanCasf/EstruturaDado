package br.com.ryan.lista;

public class Lista implements ListaInterface {
	
	private Object[] elements;
	private int size;
	
	private static final int SIZE_INITIALIZE = 10;
	
	public Lista() {
		size = 0;
		elements = new Object[SIZE_INITIALIZE];
	}

	@Override
	public void add(Object value) throws ArrayIndexOutOfBoundsException {
		if (size >= SIZE_INITIALIZE) {
			throw new ArrayIndexOutOfBoundsException("Position do not exist!");
		}
		
		elements[size] = value;
		size++;
	}
	
	@Override
	public void add(int index, Object value) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index do not exist!");
		}
		
		elements[index] = value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index do not exist!");
		}
		
		return elements[index];
	}

	@Override
	public boolean contains(Object reference) {
		for (int i=0; i<size; i++) {
			if (elements[i] == null || reference == null) {
				if (elements[i] == null && reference == null) {
					return true;
				}
				
				continue;
			}
			
			if (elements[i].equals(reference)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean remove(int index) {
		return false;
	}

	@Override
	public boolean remove(Object reference) {
		return false;
	}
}