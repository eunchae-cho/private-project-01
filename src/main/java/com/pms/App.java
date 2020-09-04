package com.pms;


import com.pms.domain.Board;
import com.pms.domain.Member;
import com.pms.domain.Project;
import com.pms.domain.Task;
import com.pms.handler.BoardHandler;
import com.pms.handler.MemberHandler;
import com.pms.handler.ProjectHandler;
import com.pms.handler.TaskHandler;
import com.pms.util.AbstractList;
import com.pms.util.ArrayList;
import com.pms.util.LinkedList;
import com.pms.util.Prompt;
import com.pms.util.Queue;
import com.pms.util.Stack;




public class App {
	public static void main(String[] args) {

		// BoardHandler가 작업하는데 의존 객체를 이렇게 외부에서 생성자를 통해 주입(DI)
		// 이렇게 하면 의존 객체의 교체가 쉬워짐 - LinkedList를 쓸지 ArrayList를 쓸지 여기서 선택가능
		AbstractList<Board> boardList = new ArrayList<>();
		AbstractList<Member> memberList = new ArrayList<>();
		AbstractList<Project> projectList = new LinkedList<>();
		AbstractList<Task> taskList = new LinkedList<>();
		BoardHandler boardHandler = new BoardHandler(boardList);
		MemberHandler memberHandler = new MemberHandler(memberList);
		ProjectHandler projectHandler = new ProjectHandler(projectList,memberHandler);
		TaskHandler taskHandler = new TaskHandler(taskList,memberHandler);

		// 추상 클래스 - 인스턴스 생성 불가능
		// 			왜냐하면 추상클래스의 역할은 서브클래스를 위한 용도이기 때문
		// List<Board> list = new List<>(); 불가능
		// List<Board> list = new ArrayList<>(); 이건 가능!

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
