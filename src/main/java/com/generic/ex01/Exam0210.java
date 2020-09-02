package com.generic.ex01;

import java.util.ArrayList;

// Generic - 레퍼런스와 인스턴스 생성
public class Exam0210 {
	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<>();
		ArrayList<Member> list2 = new ArrayList<Member>();
		ArrayList<Member> list3;
		list3 = new ArrayList<>();
		// ArrayList<> list4 => 생략불가
	}

}
