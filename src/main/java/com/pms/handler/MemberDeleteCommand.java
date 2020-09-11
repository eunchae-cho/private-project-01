package com.pms.handler;

import java.util.List;

import com.pms.domain.Member;
import com.pms.util.Prompt;

public class MemberDeleteCommand implements Command {

	private List<Member> memberList;

	public MemberDeleteCommand(List<Member> list) {
		this.memberList = list;
	}

	@Override
	public void execute() {
		System.out.println("[회원 삭제]");
		int num = Prompt.inputInt("번호: ");
		int index = indexOf(num);

		if (index == -1) {
			System.out.println("해당 번호의 회원이 없습니다.");
			return;
		}

		String reponse = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
		if (!reponse.equalsIgnoreCase("y")) {
			System.out.println("회원 삭제를 취소하였습니다.");
			return;
		}

		memberList.remove(index);
		System.out.println("회원을 삭제하였습니다.");

	}

	private int indexOf(int num) {
		for (int i = 0; i < memberList.size(); i++) {
			Member member = memberList.get(i);
			if (member.getNum() == num) {
				return i;
			}
		}
		return -1;
	}
}
