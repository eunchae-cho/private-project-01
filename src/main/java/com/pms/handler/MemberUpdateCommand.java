package com.pms.handler;

import java.util.List;

import com.pms.domain.Member;
import com.pms.util.Prompt;

public class MemberUpdateCommand implements Command {

	private List<Member> memberList;

	public MemberUpdateCommand(List<Member> list) {
		this.memberList = list;
	}

	@Override
	public void execute() {
		System.out.println("[회원 변경]");
		int num = Prompt.inputInt("번호: ");
		Member member = findByNum(num);

		if (member == null) {
			System.out.println("해당 번호의 회원이 없습니다.");
			return;
		}

		String name = Prompt.inputString(String.format("이름(%s): ",member.getName()));
		String email = Prompt.inputString(String.format("이메일(%s): ",member.getEmail()));
		String password = Prompt.inputString("암호: ");
		String photo = Prompt.inputString(String.format("사진(%s): ",member.getPhoto()));
		String tel = Prompt.inputString(String.format("전화(%s): ",member.getTel()));
		String reponse = Prompt.inputString("정말 변경하겠습니까?(y/N)");
		if (!reponse.equalsIgnoreCase("y")){
			System.out.println("회원 변경을 취소했습니다.");
			return;
		}


		member.setName(name);
		member.setEmail(email);
		member.setPassword(password);
		member.setPhoto(photo);
		member.setTel(tel);
		System.out.println("회원 정보를 변경하였습니다.");

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
