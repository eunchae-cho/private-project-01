package com.pms.util;

import java.util.Arrays;

public class ArrayList<E> {

	private static final int DEFAULT_CAPACITY = 100;
	private Object[] elementData;
	private int size;

	public ArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	public ArrayList(int initialCapacity) {
		if (initialCapacity <= DEFAULT_CAPACITY) {
			elementData = new Object[DEFAULT_CAPACITY];
		} else {
			elementData = new Object[initialCapacity];
		}
	}

	public void add(E e) {
		if (size == elementData.length) {
			int oldCapacity = elementData.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			elementData = Arrays.copyOf(elementData, newCapacity);
			System.out.printf("새 배열 %d 생성!\n",newCapacity);
		}
		elementData[size++] = e;
	}

	private void grow() {
		int newCapacity = elementData.length + (elementData.length >> 1);
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	public void add(int index, E element) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("인덱스초과");
		}
		if (size == elementData.length) {
			grow();
		}
		for (int i = size; i > index; i--) {
			elementData[i] = elementData[i-1];
		}
		elementData[index] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("인덱스초과");
		}
		return (E) elementData[index];
	}

	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("인덱스초과");
		}
		Object old = elementData[index];
		elementData[index] = element;
		return (E) old;
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("인덱스초과");
		}

		Object old = elementData[index];
		System.arraycopy(elementData, index+1, elementData, index, this.size-(index+1));
		size--;
		elementData[size] = null;
		return (E) old;
	}

	public int size() {
		return this.size;
	}

	@SuppressWarnings("unchecked")
	public E[] toArray(E[] arrayType) {
		if (arrayType.length < this.size) {
			return (E[]) Arrays.copyOf(this.elementData, this.size, arrayType.getClass());
		}
		System.arraycopy(this.elementData, 0, arrayType, 0, this.size);
		return arrayType;
	}

	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

}
