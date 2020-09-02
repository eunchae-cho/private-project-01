package com.pms.util;

public class StackTest {
	public static void main(String[] args) throws Exception{
		Stack<String> stack = new Stack<>();


		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		stack.push("ddd");
		stack.push("eee");
		print(stack);

		Stack<String> stack2 = stack.clone();
		print(stack2);

	}

	static void print(Stack<?> stack) {
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i) + ",");
		}
		System.out.println();
	}
}
