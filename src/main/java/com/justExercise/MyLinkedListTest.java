package com.justExercise;

public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		print(list);
		System.out.println("-----------");
		
		
		System.out.println(list.set(0, "x"));
		
	}
	
	static void print(MyLinkedList list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + ",");
		}
		System.out.println();
	}
	
	static void print2(Object[] arr) {
		for (Object obj : arr) {
			System.out.println(obj + ",");
		}
		System.out.println();
	}
}
