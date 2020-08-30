package com.justExercise;

public class MyArrayListTest {
	public static void main(String[] args) {
		MyArrayList list1 = new MyArrayList();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		list1.add("f");
		print(list1);
		
		System.out.println("-------------------");
		
		MyArrayList list2 = new MyArrayList(10);
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list2.add("d");
		list2.add("e");
		list2.add("f");
		list2.add("g");
		list2.add("h");
		print(list2);
		
	}
	
	static void print(MyArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			String str = (String) list.get(i);
			System.out.print(str + ",");
		}
		System.out.println();
	}
}
