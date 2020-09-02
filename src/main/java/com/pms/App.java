package com.pms;


import com.pms.handler.BoardHandler;
import com.pms.handler.MemberHandler;
import com.pms.handler.ProjectHandler;
import com.pms.handler.TaskHandler;
import com.pms.util.Prompt;
import com.pms.util.Queue;
import com.pms.util.Stack;


public class App {
	public static void main(String[] args) {

		BoardHandler boardHandler = new BoardHandler();
		MemberHandler memberHandler = new MemberHandler();
		ProjectHandler projectHandler = new ProjectHandler(memberHandler);
		TaskHandler taskHandler = new TaskHandler(memberHandler);

		Stack<String> commandList = new Stack<>();
		Queue<String> commandList2 = new Queue<>();

		loop:
			while (true) {
				String command = Prompt.inputString("명령> ");

				commandList.push(command);
				commandList2.offer(command);

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
				case "history":printCommandHistory(commandList);break;
				case "history2":printCommandHistory2(commandList2);break;
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

	private static void printCommandHistory(Stack<String> commandList) {
		try {
			Stack<String> commandStack = commandList.clone();
			for (int count = 1; !commandStack.empty(); count++) {
				System.out.println(commandStack.pop());

				if ((count % 5) == 0) {
					String response = Prompt.inputString(":");
					if (response.equalsIgnoreCase("q")) {
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("history중 오류발생!");
		}
	}

	private static void printCommandHistory2(Queue<String> commandList2) {
		try {
			Queue<String> commandQueue = commandList2.clone();
			for (int count = 1; commandQueue.size() > 0; count++) {
				System.out.println(commandQueue.poll());

				if ((count % 5) == 0) {
					String response = Prompt.inputString(":");
					if (response.equalsIgnoreCase("q")) {
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("history2중 오류 발생!");
		}
	}
}
