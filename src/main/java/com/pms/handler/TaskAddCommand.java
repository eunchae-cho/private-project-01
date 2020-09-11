package com.pms.handler;

import java.util.List;

import com.pms.domain.Task;
import com.pms.util.Prompt;

public class TaskAddCommand implements Command {

	private List<Task> taskList;
	private MemberListCommand memberListCommand;

	public TaskAddCommand(List<Task> list, MemberListCommand memberListCommand) {
		this.taskList = list;
		this.memberListCommand = memberListCommand;
	}

	@Override
	public void execute() {
		Task t = new Task();
		System.out.println("[작업 등록]");
		t.setNum(Prompt.inputInt("번호: "));
		t.setContent(Prompt.inputString("내용: "));
		t.setDeadline(Prompt.inputDate("완료일: "));
		t.setStatus(Prompt.inputInt("상태: \n0: 신규\n1: 진행중\n2: 완료\n> "));
		while (true) {
			String name = Prompt.inputString("담당자:(취소: 빈문자열) ");
			if (name.length() == 0) {
				System.out.println("작업 등록을 취소하셨습니다.");
				return;
			} else if (memberListCommand.findByName(name) != null){
				t.setManager(name);
				break;
			}
			System.out.println("등록된 회원이 아닙니다.");
		}
		taskList.add(t);
	}

}
