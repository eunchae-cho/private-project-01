package com.pms.handler;

import java.util.Iterator;
import java.util.List;

import com.pms.domain.Member;

public class MemberListCommand implements Command{

	private List<Member> memberList;

	public MemberListCommand(List<Member> list) {
		this.memberList = list;
	}

	@Override
	public void execute() {
		System.out.println("[회원 목록]");

		Iterator<Member> iterator = memberList.iterator();
		while (iterator.hasNext()) {
			Member m = iterator.next();
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
