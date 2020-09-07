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
		return new ListIterator<E>(this);
	}

	private static class ListIterator<E> implements Iterator<E>{

		List<E> list;
		int cursor;

		public ListIterator(List<E> list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			return cursor < list.size();
		}

		@Override
		public E next() {
			if (cursor == list.size())
				throw new NoSuchElementException();

			return list.get(cursor++);
		}
	}

}
