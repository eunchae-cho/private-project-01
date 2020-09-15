package com.pms.handler;

import java.sql.Date;
import java.util.List;

import com.pms.domain.Project;
import com.pms.util.Prompt;


public class ProjectUpdateCommand implements Command {

	private List<Project> projectList;
	private MemberListCommand memberListCommand;

	public ProjectUpdateCommand(List<Project> list, MemberListCommand memberListCommand) {
		this.projectList = list;
		this.memberListCommand = memberListCommand;
	}

	@Override
	public void execute() {
		System.out.println("[프로젝트 변경]");
		int num = Prompt.inputInt("번호? ");
		Project project = findByNum(num);

		if (project == null) {
			System.out.println("해당 번호의 프로젝트가 없습니다.");
			return;
		}

		String title = Prompt.inputString(
				String.format("프로젝트명(%s)? ", project.getTitel()));
		String content = Prompt.inputString(
				String.format("내용(%s)? ", project.getContent()));
		Date startDate = Prompt.inputDate(
				String.format("시작일(%s)? ", project.getStart()));
		Date endDate = Prompt.inputDate(
				String.format("종료일(%s)? ", project.getEnd()));

		String owner = null;
		while (true) {
			String name = Prompt.inputString(
					String.format("만든이(%s)?(취소: 빈 문자열) ", project.getOwner()));
			if (name.length() == 0) {
				System.out.println("프로젝트 등록을 취소합니다.");
				return;
			} else if (memberListCommand.findByName(name) != null) {
				owner = name;
				break;
			}
			System.out.println("등록된 회원이 아닙니다.");
		}

		StringBuilder members = new StringBuilder();
		while (true) {
			String name = Prompt.inputString(
					String.format("팀원(%s)?(완료: 빈 문자열) ", project.getMembers()));
			if (name.length() == 0) {
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

		String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("프로젝트 변경을 취소하였습니다.");
			return;
		}

		project.setTitel(title);
		project.setContent(content);
		project.setStart(startDate);
		project.setEnd(endDate);
		project.setOwner(owner);
		project.setMembers(members.toString());

		System.out.println("프로젝트를 변경하였습니다.");

	}

	private Project findByNum(int num) {
		for (int i = 0; i < projectList.size(); i++) {
			Project project = projectList.get(i);
			if (project.getNum() == num) {
				return project;
			}
		}
		return null;
	}
}
