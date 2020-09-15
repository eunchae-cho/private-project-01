package com.pms.handler;

import java.util.List;

import com.pms.domain.Project;
import com.pms.util.Prompt;

public class ProjectAddCommand implements Command{

	private List<Project> projectList;
	private MemberListCommand memberListCommand;

	public ProjectAddCommand(List<Project> list, MemberListCommand memberListCommand) {
		this.projectList = list;
		this.memberListCommand = memberListCommand;
	}

	@Override
	public void execute() {
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
			} else if (memberListCommand.findByName(name) != null) {
				p.setOwner(name);
				break;
			}
			System.out.println("등록된 회원이 아닙니다.");
		}

		StringBuilder members = new StringBuilder();
		while (true) {
			String name = Prompt.inputString("팀원:(완료: 빈문자열) ");
			if (name.length()  == 0) {
				break;
			} else if (memberListCommand.findByName(name) != null) {
				if (members.length() > 0) {
					members.append(":");
				}
				members.append(name);
			} else {
				System.out.println("등록된 회원이 아닙니다.");
			}
		}
		p.setMembers(members.toString());
		projectList.add(p);
	}

}
