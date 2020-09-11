package com.pms.handler;

import java.util.Iterator;
import java.util.List;

import com.pms.domain.Task;

public class TaskListCommand implements Command{

	private List<Task> taskList;

	public TaskListCommand(List<Task> list) {
		this.taskList = list;
	}

	@Override
	public void execute() {
		System.out.println("[작업 목록]");
		String stateLabel = null ;

		Iterator<Task> iterator = taskList.iterator();
		while (iterator.hasNext()) {
			Task t = iterator.next();
			switch (t.getStatus()) {
			case 1:
				stateLabel = "진행중"; break;
			case 2:
				stateLabel = "완료"; break;
			default:
				stateLabel = "신규"; break;
			}
			System.out.printf("%d, %s, %s, %s, %s\n",
					t.getNum(),t.getContent(),t.getDeadline(),stateLabel,t.getManager());
		}
	}

}
