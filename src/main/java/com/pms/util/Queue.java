package com.pms.util;


// 1) Queue 를 구현하기 위해 기존에 작성한 MyLinkedList를 상속 받는다.
// 2) Queue에 값을 추가하는 offer(Object)를 정의한다.
// 3) Queue에서 값을 꺼내는 poll()을 정의한다.
// 4) Queue에서 제일 앞에 있는 값을 조회하는 peek()을 정의한다.
// 5) clone() - deep copy
// 6) 제네릭 적용

public class Queue<E> extends LinkedList<E> implements Cloneable{

	public boolean offer(E e) {
		return add(e);
	}

	public E poll() {
		if (size() == 0) {
			return null;
		}
		return remove(0);
	}

	public E peek() {
		if (size() == 0) {
			return null;
		}
		return get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Queue<E>clone() throws CloneNotSupportedException {
		Queue<E> newQueue = new Queue<>();
		Object[] values = this.toArray();
		for (Object value : values) {
			newQueue.offer((E) value);
		}
		return newQueue;
	}

}
