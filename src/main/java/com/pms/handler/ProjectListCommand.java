package com.pms.handler;

import java.util.Iterator;
import java.util.List;

import com.pms.domain.Project;

public class ProjectListCommand implements Command {

	private List<Project> projectList;

	public ProjectListCommand(List<Project> list) {
		this.projectList = list;
	}

	@Override
	public void execute() {
		System.out.println("[프로젝트 목록]");
		Iterator<Project> iterator = projectList.iterator();
		while (iterator.hasNext()) {
			Project p = iterator.next();
			System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
					p.getNum(),p.getTitel(),p.getContent(),p.getStart(),
					p.getEnd(),p.getOwner(),p.getMembers());
		}

	}


}
