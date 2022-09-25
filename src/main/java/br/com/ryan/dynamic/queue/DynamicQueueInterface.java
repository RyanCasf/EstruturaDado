package br.com.ryan.dynamic.queue;

public interface DynamicQueueInterface<E> {
	
	boolean isEmpty();
	void insert(E e);
	E remove();
	int size();
}