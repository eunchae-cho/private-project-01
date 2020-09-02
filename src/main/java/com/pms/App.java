package com.pms;

import com.pms.handler.BoardHandler;
import com.pms.handler.MemberHandler;
import com.pms.handler.ProjectHandler;
import com.pms.handler.TaskHandler;
import com.pms.util.Prompt;


public class App {
	public static void main(String[] args) {

		BoardHandler boardHandler = new BoardHandler();
		MemberHandler memberHandler = new MemberHandler();
		ProjectHandler projectHandler = new ProjectHandler(memberHandler);
		TaskHandler taskHandler = new TaskHandler(memberHandler);

		loop:
			while (true) {
				String command = Prompt.inputString("명령> ");
				switch (command) {
				case "/member/add":memberHandler.add();break;
				case "/member/list":memberHandler.list();break;
				case "/project/add":projectHandler.add();break;
				case "/project/list":projectHandler.list();break;
				case "/task/add":taskHandler.add();break;
				case "/task/list":taskHandler.list();break;
				case "/board/add":boardHandler.add();break;
				case "/board/list":boardHandler.list();break;
				case "/board/detail":boardHandler.detail();break;
				case "quit":
				case "exit":
					System.out.println("안녕!");
					break loop;
				default:
					System.out.println("실행할 수 없는 명령입니다.");
				}
				System.out.println();
			}
		Prompt.close();
	}



}
