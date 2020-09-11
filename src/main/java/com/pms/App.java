package com.pms;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.pms.domain.Board;
import com.pms.domain.Member;
import com.pms.domain.Project;
import com.pms.domain.Task;
import com.pms.handler.BoardAddCommand;
import com.pms.handler.BoardDeleteCommand;
import com.pms.handler.BoardDetailCommand;
import com.pms.handler.BoardListCommand;
import com.pms.handler.BoardUpdateCommand;
import com.pms.handler.Command;
import com.pms.handler.HelloCommand;
import com.pms.handler.MemberAddCommand;
import com.pms.handler.MemberDeleteCommand;
import com.pms.handler.MemberDetailCommand;
import com.pms.handler.MemberListCommand;
import com.pms.handler.MemberUpdateCommand;
import com.pms.handler.ProjectAddCommand;
import com.pms.handler.ProjectDeleteCommand;
import com.pms.handler.ProjectDetailCommand;
import com.pms.handler.ProjectListCommand;
import com.pms.handler.ProjectUpdateCommand;
import com.pms.handler.TaskAddCommand;
import com.pms.handler.TaskDeleteCommand;
import com.pms.handler.TaskDetailCommand;
import com.pms.handler.TaskListCommand;
import com.pms.handler.TaskUpdateCommand;
import com.pms.util.Prompt;





public class App {
	public static void main(String[] args) {

		Map<String,Command> commandMap = new HashMap<>();

		List<Board> boardList = new ArrayList<>();
		commandMap.put("/board/add", new BoardAddCommand(boardList));
		commandMap.put("/board/list", new BoardListCommand(boardList));
		commandMap.put("/board/detail", new BoardDetailCommand(boardList));
		commandMap.put("/board/update", new BoardUpdateCommand(boardList));
		commandMap.put("/board/delete", new BoardDeleteCommand(boardList));

		List<Member> memberList = new ArrayList<>();
		MemberListCommand memberListCommand = new MemberListCommand(memberList);
		commandMap.put("/member/add",new MemberAddCommand(memberList));
		commandMap.put("/member/list", memberListCommand);
		commandMap.put("/member/detail", new MemberDetailCommand(memberList));
		commandMap.put("/member/update", new MemberUpdateCommand(memberList));
		commandMap.put("/member/delete", new MemberDeleteCommand(memberList));

		List<Project> projectList = new LinkedList<>();
		commandMap.put("/prject/add", new ProjectAddCommand(projectList,memberListCommand));
		commandMap.put("/prject/list", new ProjectListCommand(projectList));
		commandMap.put("/prject/detail", new ProjectDetailCommand(projectList));
		commandMap.put("/prject/update", new ProjectUpdateCommand(projectList,memberListCommand));
		commandMap.put("/prject/delete", new ProjectDeleteCommand(projectList));

		List<Task> taskList = new LinkedList<>();
		commandMap.put("/taks/add", new TaskAddCommand(taskList,memberListCommand));
		commandMap.put("/taks/list", new TaskListCommand(taskList));
		commandMap.put("/taks/detail", new TaskDetailCommand(taskList));
		commandMap.put("/taks/update", new TaskUpdateCommand(taskList,memberListCommand));
		commandMap.put("/taks/delete", new TaskDeleteCommand(taskList));

		commandMap.put("hello", new HelloCommand());


		Deque<String> commandList = new ArrayDeque<>();
		Queue<String> commandList2 = new LinkedList<>();

		loop:
			while (true) {
				String inputStr = Prompt.inputString("명령> ");

				commandList.push(inputStr);
				commandList2.offer(inputStr);

				switch (inputStr) {

				case "history":printCommandHistory(commandList.iterator());break;
				case "history2":printCommandHistory(commandList2.iterator());break;
				case "quit":
				case "exit":
					System.out.println("안녕!");
					break loop;
				default:
					Command command = commandMap.get(inputStr);
					if (command != null) {
						command.execute();
					} else {
						System.out.println("실행할 수 없는 명령입니다.");

					}
				}
				System.out.println();
			}
		Prompt.close();
	}

	private static void printCommandHistory(Iterator<String> iterator) {
		try {
			int count = 1;
			while (iterator.hasNext()) {
				System.out.println(iterator.next());

				if ((count++ % 5) == 0) {
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
}
