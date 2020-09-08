package com.pms.util;

import java.util.NoSuchElementException;

public abstract class AbstractList<E> implements List<E> {
	protected int size;

	@Override
	public int size() {
		return this.size;
	}

	// 컬렉션에서 목록 조회를 담당할 Iterator 구현체를 리턴
	@Override
	public Iterator<E> iterator() {
		class ListIterator<T> implements Iterator<T>{
			int cursor;

			@Override
			public boolean hasNext() {
				return cursor < size();
			}

			@SuppressWarnings("unchecked")
			@Override
			public T next() {
				if (cursor == size())
					throw new NoSuchElementException();

				return (T) get(cursor++);
			}
		}
		return new ListIterator<E>();
	}

}
