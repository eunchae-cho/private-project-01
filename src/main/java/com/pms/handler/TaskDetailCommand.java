package com.pms.handler;

import java.util.List;

import com.pms.domain.Task;
import com.pms.util.Prompt;


public class TaskDetailCommand implements Command {

	private List<Task> taskList;

	public TaskDetailCommand(List<Task> list) {
		this.taskList = list;
	}

	@Override
	public void execute() {
		System.out.println("[작업 상세보기]");
		int num = Prompt.inputInt("번호? ");
		Task task = findByNum(num);

		if (task == null) {
			System.out.println("해당 번호의 작업이 없습니다.");
			return;
		}

		System.out.printf("내용: %s\n", task.getContent());
		System.out.printf("마감일: %s\n", task.getDeadline());
		String stateLabel = null;
		switch (task.getStatus()) {
		case 1:
			stateLabel = "진행중";
			break;
		case 2:
			stateLabel = "완료";
			break;
		default:
			stateLabel = "신규";
		}
		System.out.printf("상태: %s\n", stateLabel);
		System.out.printf("담당자: %s\n", task.getManager());
	}

	private Task findByNum(int num) {
		for (int i = 0; i < taskList.size(); i++) {
			Task task = taskList.get(i);
			if (task.getNum() == num) {
				return task;
			}
		}
		return null;
	}
}
