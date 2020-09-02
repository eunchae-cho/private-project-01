package com.pms.util;

import java.util.Arrays;

public class ArrayList<E> {

	private static final int DEFAULT_CAPACITY = 100;
	private Object[] list;
	private int size;

	public ArrayList() {
		list = new Object[DEFAULT_CAPACITY];
	}

	public ArrayList(int initialCapacity) {
		if (initialCapacity <= DEFAULT_CAPACITY) {
			list = new Object[DEFAULT_CAPACITY];
		} else {
			list = new Object[initialCapacity];
		}
	}

	public void add(E e) {
		if (size == list.length) {
			int oldCapacity = list.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			list = Arrays.copyOf(list, newCapacity);
			System.out.printf("새 배열 %d 생성!\n",newCapacity);
		}
		list[size++] = e;
	}

	private void grow() {
		int newCapacity = list.length + (list.length >> 1);
		list = Arrays.copyOf(list, newCapacity);
	}

	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("인덱스초과");
		}
		if (size == list.length) {
			grow();
		}
		for (int i = size; i > index; i--) {
			list[i] = list[i-1];
		}
		list[index] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("인덱스초과");
		}
		return (E) list[index];
	}

	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("인덱스초과");
		}
		Object old = list[index];
		list[index] = element;
		return (E) old;
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("인덱스초과");
		}

		Object old = list[index];
		System.arraycopy(list, index+1, list, index, this.size-(index+1));
		size--;
		list[size] = null;
		return (E) old;
	}

	public int size() {
		return this.size;
	}

	@SuppressWarnings("unchecked")
	public E[] toArray(E[] arrayType) {
		if (arrayType.length < this.size) {
			return (E[]) Arrays.copyOf(this.list, this.size, arrayType.getClass());
		}
		System.arraycopy(this.list, 0, arrayType, 0, this.size);
		return arrayType;
	}

}
