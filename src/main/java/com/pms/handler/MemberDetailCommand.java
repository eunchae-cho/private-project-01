package com.pms.handler;

import java.util.List;

import com.pms.domain.Member;
import com.pms.util.Prompt;

public class MemberDetailCommand implements Command{

	private List<Member> memberList;

	public MemberDetailCommand(List<Member> list) {
		this.memberList = list;
	}

	@Override
	public void execute() {
		System.out.println("[회원 상세보기]");
		int num = Prompt.inputInt("번호: ");
		Member member = findByNum(num);

		if (member == null) {
			System.out.println("해당 번호의 회원이 없습니다.");
			return;
		}

		System.out.printf("이름: %s\n",member.getName());
		System.out.printf("이메일: %s\n",member.getEmail());
		System.out.printf("사진: %s\n",member.getPhoto());
		System.out.printf("전화: %s\n",member.getTel());
		System.out.printf("등록일: %s\n",member.getRegisteredDate());
	}

	private Member findByNum(int num) {
		for (int i = 0; i < memberList.size(); i++) {
			Member member = memberList.get(i);
			if (member.getNum() == num) {
				return member;
			}
		}
		return null;
	}
}
