package com.pms.util;

public interface List<E> {
	int size();
	boolean add(E e);
	void add(int index, E element);
	E set(int index, E element);
	E get(int index);
	E remove(int index);
	Object[] toArray();
	E[] toArray(E[] arr);

}
