package com.pms.handler;

import java.util.List;

import com.pms.domain.Project;
import com.pms.util.Prompt;

public class ProjectDetailCommand implements Command {

	private List<Project> projectList;

	public ProjectDetailCommand(List<Project> list) {
		this.projectList = list;
	}

	@Override
	public void execute() {
		System.out.println("[프로젝트 상세보기]");
		int num = Prompt.inputInt("번호:  ");
		Project project = findByNum(num);

		if (project == null) {
			System.out.println("해당 번호의 프로젝트가 없습니다.");
			return;
		}

		System.out.printf("프로젝트명: %s\n", project.getTitel());
		System.out.printf("내용: %s\n", project.getContent());
		System.out.printf("기간: %s ~ %s\n", project.getStart(), project.getEnd());
		System.out.printf("만든이: %s\n", project.getOwner());
		System.out.printf("팀원: %s\n", project.getMembers());

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
