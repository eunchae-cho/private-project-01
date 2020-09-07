package com.pms.util;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

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

	// 수퍼클래스의 iterator()는 ListIterator를 리턴한다.
	// 이 객체는 Stack으로 목록을 관리하는 방식과 다르게 데이터를 조회한다.
	// 따라서 Stack에 맞는 Iterator를 리턴할 필요가 있다.
	// 오버라이딩을 통하여 상속 받은 메서드를 서브 클래스에 맞게 재정의한다.
	@Override
	public Iterator<E> iterator() {

		try {
			return new StackIterator<E>(this.clone());
		} catch (Exception e) {
			throw new RuntimeException("스택 복제 중에 오류 발생!");
		}
	}


	private static class StackIterator<E> implements Iterator<E> {

		Stack<E> stack;
		public StackIterator(Stack<E> stack) {
			this.stack = stack;
		}

		@Override
		public boolean hasNext() {
			return !stack.empty();
		}

		@Override
		public E next() {
			if (stack.empty())
				throw new NoSuchElementException();

			return stack.pop();
		}
	}

}
