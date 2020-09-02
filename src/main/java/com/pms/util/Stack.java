package com.pms.util;

import java.util.EmptyStackException;

// 1) Stack 을 구현하기 위해 기존에 작성한 MyLinkedList를 상속 받는다.
// 2) 스택에 값을 추가하는 push() 메서드를 정의한다.
// 3) 스택에서 제일 마지막에 추가한 값을 꺼내는 pop() 메서드를 정의한다.
// 4) 스택에서 제일 마지막에 입력한 값을 조회하는 peek()을 정의한다.
// 5) empty() 추가
// 6) clone() 오버라이딩 - deep copy
public class Stack<E> extends LinkedList<E> implements Cloneable{

	public E push(E item) {
		add(item);
		return item;
	}

	public E pop() {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		return remove(size() - 1);
	}

	public E peek() {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		return get(size() - 1);
	}

	public boolean empty() {
		return this.size() == 0;
	}

	// deep copy - 기존 스택의 값을 새 스택에 넣는다.
	@SuppressWarnings ("unchecked")
	@Override 
	public Stack<E> clone() throws CloneNotSupportedException {
		Stack<E> newStack = new Stack<>();
		Object[] values = this.toArray();

		for(Object value : values) {
			newStack.push((E) value);
		}
		return newStack;
	}
}
