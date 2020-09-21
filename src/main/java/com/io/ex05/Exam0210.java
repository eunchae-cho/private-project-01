package com.io.ex05;

public class Exam0210 {
	public static void main(String[] args) throws Exception {
		DataOutputStream out = new DataOutputStream("temp/test4.data");
		Member member = new Member();
		member.name = "AB가각간";
		member.age = 27;
		member.gender = true;

		out.writeUTF(member.name);
		out.writeInt(member.age);
		out.writeBoolean(member.gender);
		out.close();
		System.out.println("데이터 출력 완료");
	}
}
