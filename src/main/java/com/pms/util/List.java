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

	// 컬렉션의 값을 조회해주는 Iterator 구현체를 제공해주는 메서드
	Iterator<E> iterator();
}
