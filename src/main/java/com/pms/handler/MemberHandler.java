package com.pms.handler;

import java.sql.Date;

import com.pms.domain.Member;
import com.pms.util.AbstractList;
import com.pms.util.Prompt;



public class MemberHandler {

	AbstractList<Member> memberList = new AbstractList<>();

	public MemberHandler(AbstractList<Member> list) {
		this.memberList = list;
	}

	public void add() {
		Member m = new Member();
		System.out.println("[회원 등록]");
		m.setNum(Prompt.inputInt("번호: "));
		m.setName(Prompt.inputString("이름: "));
		m.setEmail(Prompt.inputString("이메일: "));
		m.setPassword(Prompt.inputString("암호: "));
		m.setPhoto(Prompt.inputString("사진: "));
		m.setTel(Prompt.inputString("전화: "));
		m.setRegisteredDate(new Date(System.currentTimeMillis()));
		memberList.add(m);
	}	


	public void list() {
		System.out.println("[회원 목록]");
		for (int i = 0; i < memberList.size(); i++) {
			Member m = memberList.get(i);
			System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
					m.getNum(),m.getName(),m.getEmail(),m.getPassword(),
					m.getPhoto(),m.getTel(),m.getRegisteredDate());
		}
	}

	public Member findByName(String name) {
		for (int i = 0; i < memberList.size(); i++) {
			Member m = memberList.get(i);
			if (m.getName().equals(name)) {
				return m;				
			}
		}
		return null;
	}
}
