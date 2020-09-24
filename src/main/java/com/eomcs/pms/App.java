package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;
import com.eomcs.pms.handler.BoardAddCommand;
import com.eomcs.pms.handler.BoardDeleteCommand;
import com.eomcs.pms.handler.BoardDetailCommand;
import com.eomcs.pms.handler.BoardListCommand;
import com.eomcs.pms.handler.BoardUpdateCommand;
import com.eomcs.pms.handler.Command;
import com.eomcs.pms.handler.HelloCommand;
import com.eomcs.pms.handler.MemberAddCommand;
import com.eomcs.pms.handler.MemberDeleteCommand;
import com.eomcs.pms.handler.MemberDetailCommand;
import com.eomcs.pms.handler.MemberListCommand;
import com.eomcs.pms.handler.MemberUpdateCommand;
import com.eomcs.pms.handler.ProjectAddCommand;
import com.eomcs.pms.handler.ProjectDeleteCommand;
import com.eomcs.pms.handler.ProjectDetailCommand;
import com.eomcs.pms.handler.ProjectListCommand;
import com.eomcs.pms.handler.ProjectUpdateCommand;
import com.eomcs.pms.handler.TaskAddCommand;
import com.eomcs.pms.handler.TaskDeleteCommand;
import com.eomcs.pms.handler.TaskDetailCommand;
import com.eomcs.pms.handler.TaskListCommand;
import com.eomcs.pms.handler.TaskUpdateCommand;
import com.eomcs.util.CsvObject;
import com.eomcs.util.ObjectFactory;
import com.eomcs.util.Prompt;

public class App {


	public static void main(String[] args) {

		List<Board> boardList = new ArrayList<>();
		File boardFile = new File("./board.csv"); 

		List<Member> memberList = new LinkedList<>();
		File memberFile = new File("./member.csv");  

		List<Project> projectList = new LinkedList<>();
		File projectFile = new File("./project.csv"); 

		List<Task> taskList = new ArrayList<>();
		File taskFile = new File("./task.csv"); 

		loadObjects(boardList, boardFile, Board::new);
		loadObjects(memberList, memberFile, Member::new);
		loadObjects(projectList, projectFile, Project::new);
		loadObjects(taskList, taskFile, Task::new);

		Map<String,Command> commandMap = new HashMap<>();

		commandMap.put("/board/add", new BoardAddCommand(boardList));
		commandMap.put("/board/list", new BoardListCommand(boardList));
		commandMap.put("/board/detail", new BoardDetailCommand(boardList));
		commandMap.put("/board/update", new BoardUpdateCommand(boardList));
		commandMap.put("/board/delete", new BoardDeleteCommand(boardList));

		MemberListCommand memberListCommand = new MemberListCommand(memberList);
		commandMap.put("/member/add", new MemberAddCommand(memberList));
		commandMap.put("/member/list", memberListCommand);
		commandMap.put("/member/detail", new MemberDetailCommand(memberList));
		commandMap.put("/member/update", new MemberUpdateCommand(memberList));
		commandMap.put("/member/delete", new MemberDeleteCommand(memberList));

		commandMap.put("/project/add", new ProjectAddCommand(projectList, memberListCommand));
		commandMap.put("/project/list", new ProjectListCommand(projectList));
		commandMap.put("/project/detail", new ProjectDetailCommand(projectList));
		commandMap.put("/project/update", new ProjectUpdateCommand(projectList, memberListCommand));
		commandMap.put("/project/delete", new ProjectDeleteCommand(projectList));

		commandMap.put("/task/add", new TaskAddCommand(taskList, memberListCommand));
		commandMap.put("/task/list", new TaskListCommand(taskList));
		commandMap.put("/task/detail", new TaskDetailCommand(taskList));
		commandMap.put("/task/update", new TaskUpdateCommand(taskList, memberListCommand));
		commandMap.put("/task/delete", new TaskDeleteCommand(taskList));

		commandMap.put("/hello", new HelloCommand());

		Deque<String> commandStack = new ArrayDeque<>();
		Queue<String> commandQueue = new LinkedList<>();

		loop:
			while (true) {
				String inputStr = Prompt.inputString("명령> ");

				if (inputStr.length() == 0) {
					continue;
				}

				commandStack.push(inputStr);
				commandQueue.offer(inputStr);

				switch (inputStr) {
				case "history": printCommandHistory(commandStack.iterator()); break;
				case "history2": printCommandHistory(commandQueue.iterator()); break;
				case "quit":
				case "exit":
					System.out.println("안녕!");
					break loop;
				default:
					Command command = commandMap.get(inputStr);
					if (command != null) {
						try {

							command.execute();
						} catch (Exception e) {
							// 오류가 발생하면 그 정보를 갖고 있는 객체의 클래스 이름을 출력한다.
							System.out.println("--------------------------------------------------------------");
							System.out.printf("명령어 실행 중 오류 발생: %s\n", e);
							System.out.println("--------------------------------------------------------------");
						}
					} else {
						System.out.println("실행할 수 없는 명령입니다.");
					}
				}
				System.out.println();
			}

		Prompt.close();

		saveObjects(boardList, boardFile);
		saveObjects(memberList, memberFile);
		saveObjects(projectList, projectFile);
		saveObjects(taskList, taskFile);
	}

	static void printCommandHistory(Iterator<String> iterator) {
		try {
			int count = 0;
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
				count++;
				if ((count % 5) == 0 && Prompt.inputString(":").equalsIgnoreCase("q")) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("history 명령 처리 중 오류 발생!");
		}
	}

	private static <T extends CsvObject> void saveObjects(Collection<T> list, File file) {
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter(file));

			for (T csvObject : list) {
				out.write(csvObject.toCsvString());
				out.write("\n");
			}
			out.flush();
			System.out.printf("총 %d 개의 객체를 '%s' 파일에 저장했습니다.\n",
					list.size(), file.getName());

		} catch (IOException e) {
			System.out.printf("객체를 '%s' 파일에 쓰기 중 오류 발생! - %s\n",
					file.getName(), e.getMessage());

		} finally {
			try {
				out.close();
			} catch (IOException e) {}
		}
	}

	private static <T> void loadObjects(
			Collection<T> list,
			File file,
			ObjectFactory<T> factory) {
		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader(file));

			while (true) {
				String record = in.readLine();
				if (record == null) {
					break;
				}
				list.add(factory.create(record));
			}
			System.out.printf("총 %d개의 객체를 '%s' 파일에 저장했습니다.\n",
					list.size(), file.getName());
		} catch (Exception e) {
			System.out.printf("객체를 '%s' 파일에 읽기 중 오류 발생! - %s\n",
					file.getName(), e.getMessage());
		} finally {
			try {
				in.close();
			} catch (Exception e) {}
		}
	}

}
