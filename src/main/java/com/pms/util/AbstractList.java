package com.pms.util;

public abstract class AbstractList<E> {
	protected int size;

	// 오버라이딩할 필요 없음 - 추상 메서드로 사용하지 않음
	public int size() {
		return this.size;
	}

	// 서브클래스에 공통적으로 갖고 있으므로 오버라이딩하게 만든다
	// 서브클레스에게 반드시 갖춰야할 기능을 강제적으로 부여

	// 추상 메서드
	// - 서브클래스에서 구체적인 실행을 구현하라는 의미
	// - 서브클래스마다 구현 내용이 다를 수 있다면 추상메서드로 선언
	//	  또는 서브클래스에게 구현하라고 강제하고 싶을 때도 추상메서드로 전환
	public abstract boolean add(E e);

	public abstract void add(int index, E element);

	public abstract E set(int index, E element);

	public abstract E get(int index);

	public abstract E remove(int index);

	public abstract Object[] toArray();

	public abstract E[] toArray(E[] arr);

}
