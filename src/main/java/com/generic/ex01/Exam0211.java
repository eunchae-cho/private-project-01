package com.generic.ex01;

import java.util.ArrayList;

public class Exam0211 {
	public static void main(String[] args) {

		// 이렇게 하지 말자
		ArrayList list1;
		list1 = new ArrayList();
		list1 = new ArrayList<>();
		list1 = new ArrayList<Object>();
		list1 = new ArrayList<String>();
		list1 = new ArrayList<Member>();

		// 타입에 상관없이 하려면 이렇게 하자
		ArrayList<?> list2;
		list2 = new ArrayList();
		list2 = new ArrayList<>();
		list2 = new ArrayList<Object>();
		list2 = new ArrayList<String>();
		list2 = new ArrayList<Member>();
	}
}
