package br.com.ryan.fixed.queue;

public interface FixedQueueInterface {
	
	void add(Object value);
	void add(int size, Object value);
	int size();
	String print();
	Object get(int index);
	boolean contains(int index);
	boolean contains(Object reference);
	boolean remove(int index);
	boolean remove(Object reference);
}