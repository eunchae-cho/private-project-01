package com.io.ex05;

public class Exam0220 {
	public static void main(String[] args) throws Exception {
		DataInputStream in = new DataInputStream("temp/test4.data");

		Member member = new Member();
		member.name = in.readUTF();
		member.age = in.readInt();
		member.gender = in.readBoolean();
		in.close();
		System.out.printf("%s\n", member);
	}
}
