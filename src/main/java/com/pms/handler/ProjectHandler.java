package com.pms.handler;

import com.pms.domain.Project;
import com.pms.util.LinkedList;
import com.pms.util.Prompt;

public class ProjectHandler {
	LinkedList<Project> projectList = new LinkedList<>();

	MemberHandler memberHandler;

	public ProjectHandler(MemberHandler memberHandler) {
		this.memberHandler = memberHandler;
	}


	public void add() {
		Project p = new Project();
		System.out.println("[프로젝트 등록]");
		p.setNum(Prompt.inputInt("번호: "));
		p.setTitel(Prompt.inputString("프로젝트명: "));
		p.setContent(Prompt.inputString("내용: "));
		p.setStart(Prompt.inputDate("시작일: "));
		p.setEnd(Prompt.inputDate("종료일: "));

		while (true) {
			String name = Prompt.inputString("만든이: ");
			if (name.length() == 0) {
				System.out.println("프로젝트 등록을 취소합니다.");
				return;
			} else if (memberHandler.findByName(name) != null) {
				p.setOwner(name);
				break;
			}
			System.out.println("등록된 회원이 아닙니다.");
		}

		StringBuilder members = new StringBuilder();
		while (true) {
			String name = Prompt.inputString("팀원: ");
			if (name.length()  == 0) {
				break;
			} else if (memberHandler.findByName(name) != null) {
				if (members.length() > 0) {
					members.append(",");
				}
				members.append(name);
			} else {
				System.out.println("등록된 회원이 아닙니다.");
			}
		}
		p.setMembers(members.toString());
		projectList.add(p);
	}


	public void list() {
		System.out.println("[프로젝트 목록]");
		for (int i = 0; i < projectList.size(); i++) {
			Project p = projectList.get(i);
			System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
					p.getNum(),p.getTitel(),p.getContent(),p.getStart(),
					p.getEnd(),p.getOwner(),p.getMembers());
		}

	}

}
