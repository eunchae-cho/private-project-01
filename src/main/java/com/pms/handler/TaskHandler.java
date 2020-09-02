package com.pms.handler;

import com.pms.domain.Task;
import com.pms.util.LinkedList;
import com.pms.util.Prompt;


public class TaskHandler {
	LinkedList<Task> taskList = new LinkedList<>();

	MemberHandler memberHandler;

	public TaskHandler(MemberHandler memberHandler) {
		this.memberHandler = memberHandler;
	}

	public void add() {
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
			} else if (memberHandler.findByName(name) != null){
				t.setManager(name);
				break;
			}
			System.out.println("등록된 회원이 아닙니다.");
		}
		taskList.add(t);
	}

	public void list() {
		System.out.println("[작업 목록]");
		String stateLabel = null ;
		for (int i = 0; i < taskList.size(); i++) {
			Task t = taskList.get(i);
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
