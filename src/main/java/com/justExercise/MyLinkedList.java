package com.justExercise;

// 1. LinkedList 클래스 정의
// 2. Node class 설계
// 3. first, last 노드 주소와 크기를 필드에 추가
// 4. add()
// 5. get()
// 6. add(int, Object), Node 생성자 추가
// 7. remove(int)
// 8. set(int, Object)
// 9. toArray()   
// 10. 캡슐화 적용

public class MyLinkedList {
	private Node first;
	private Node last;
	private int size;
	
	static class Node {
		Object value;
		Node next;
		
		public Node() {}
		
		public Node(Object value) {
			this.value = value;
		}
	}
	
	public boolean add(Object e) {
		Node node = new Node();
		node.value = e;
		
		if (first == null) {
			first = node;
		} else {
			last.next = node;
		}
		last = node;
		size++;
		return true;
	}
	
	public Object get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
		}
		Node cursor = this.first;
		for (int i = 1; i <= index; i++) {
			cursor = cursor.next;
		}
		return cursor.value;
	}
	
	public void add(int index, Object element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
		}
		
		Node node = new Node(element);
		size++;
		
		if (index == 0) {
			node.next = first;
			first = node;
			return;
		}
		
		Node cursor = this.first;
		for (int i = 1; i < index; i++) {
			cursor = cursor.next;
		}
		
		node.next = cursor.next;
		cursor.next = node;
		
		if (node.next == null) {
			last = node;
		}
	}
	
	public Object remove(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
		}
		size--;
		
		if(index == 0) {
			Node old = first;
			first = old.next;
			old.next = null;
			return old.value;
		}
		
		Node cursor = this.first;
		for (int i = 1; i < index; i++) {
			cursor = cursor.next;
		}
		
		Node old = cursor.next;
		cursor.next = old.next;
		old.next = null;
		
		if (cursor.next == null) {
			last = cursor;
		}
		
		return old.value;
	}
	
	public Object set(int index, Object element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
		}
		
		Node cursor = this.first;
		for (int i = 1; i <= index; i++) {
			cursor = cursor.next;
		}
		
		Object old = cursor.value;
		cursor.value = element;
		return old;
	}
	
	public Object[] toArray() {
		Object[] arr = new Object[this.size];
		int i = 0;
		Node cursor = first;
		
		while (cursor != null) {
			arr[i++] = cursor.value;
			cursor = cursor.next;
		}
		return arr;
	}
	
	public int size() {
		return this.size;
	}
		
}
