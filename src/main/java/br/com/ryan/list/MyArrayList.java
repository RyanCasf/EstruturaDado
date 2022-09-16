package br.com.ryan.list;

/** 
 * @author Ryan Castro Ferreira
 */
public class MyArrayList implements MyList {
	
	private Object[] elements;
	private int size;
	
	private static final int SIZE_INITIALIZE = 10;
	
	public MyArrayList() {
		super();
		
		size = 0;
		elements = new Object[SIZE_INITIALIZE];
	}

	@Override
	public void add(Object value) throws ArrayIndexOutOfBoundsException {
		if (size > 10) {
			throw new ArrayIndexOutOfBoundsException("Position do not exist!");
		}
		
		elements[size] = value;
		size++;
	}
	
	@Override
	public void add(int size, Object value) throws ArrayIndexOutOfBoundsException {
		if (size > this.size) {
			throw new ArrayIndexOutOfBoundsException("Position do not exist!");
		}
		
		elements[size] = value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String print() {
		if (size == 0) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder("");
		sb.append("[" + elements[0]);
		
		for (int i=1; i<size; i++) {
			sb.append("," + elements[i]);
		}
		
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index negative!");
		}
		
		return elements[index];
	}

	@Override
	public boolean contains(int index) {
		return false;
	}

	@Override
	public boolean contains(Object reference) {
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