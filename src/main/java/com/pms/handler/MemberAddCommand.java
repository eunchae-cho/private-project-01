package com.pms.handler;

import java.sql.Date;
import java.util.List;

import com.pms.domain.Member;
import com.pms.util.Prompt;

public class MemberAddCommand implements Command{

	private List<Member> memberList;

	public MemberAddCommand(List<Member> list) {
		this.memberList = list;
	}

	@Override
	public void execute() {
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

}
