package com.pms;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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

	static List<Board> boardList = new ArrayList<>();
	static List<Member> memberList = new ArrayList<>();
	static List<Project> projectList = new LinkedList<>();
	static List<Task> taskList = new LinkedList<>();
	static File boardFile = new File("./board.data"); 
	static File memberFile = new File("./member.data");
	static File projectFile = new File("./project.data");
	static File taskFile = new File("./task.data");

	public static void main(String[] args) {

		loadObjects(boardList, boardFile);
		loadObjects(memberList, memberFile);
		loadObjects(projectList, projectFile);
		loadObjects(taskList, taskFile);

		Map<String,Command> commandMap = new HashMap<>();

		commandMap.put("/board/add", new BoardAddCommand(boardList));
		commandMap.put("/board/list", new BoardListCommand(boardList));
		commandMap.put("/board/detail", new BoardDetailCommand(boardList));
		commandMap.put("/board/update", new BoardUpdateCommand(boardList));
		commandMap.put("/board/delete", new BoardDeleteCommand(boardList));

		MemberListCommand memberListCommand = new MemberListCommand(memberList);
		commandMap.put("/member/add",new MemberAddCommand(memberList));
		commandMap.put("/member/list", memberListCommand);
		commandMap.put("/member/detail", new MemberDetailCommand(memberList));
		commandMap.put("/member/update", new MemberUpdateCommand(memberList));
		commandMap.put("/member/delete", new MemberDeleteCommand(memberList));

		commandMap.put("/project/add", new ProjectAddCommand(projectList,memberListCommand));
		commandMap.put("/project/list", new ProjectListCommand(projectList));
		commandMap.put("/project/detail", new ProjectDetailCommand(projectList));
		commandMap.put("/project/update", new ProjectUpdateCommand(projectList,memberListCommand));
		commandMap.put("/project/delete", new ProjectDeleteCommand(projectList));

		commandMap.put("/task/add", new TaskAddCommand(taskList,memberListCommand));
		commandMap.put("/task/list", new TaskListCommand(taskList));
		commandMap.put("/task/detail", new TaskDetailCommand(taskList));
		commandMap.put("/task/update", new TaskUpdateCommand(taskList,memberListCommand));
		commandMap.put("/task/delete", new TaskDeleteCommand(taskList));

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
						try {
							command.execute();							
						} catch (Exception e) {
							System.out.printf("명령 처리 중 오류 발생 : %s\n%s\n",
									e.getClass().getName(), e.getMessage());
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

	private static <E extends Serializable> void saveObjects(Collection<E> list, File file) {
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(file)));

			out.writeInt(list.size());

			for (E obj : list) {
				out.writeObject(obj);
			}
			out.flush();
			System.out.printf("총 %d개의  객체를 '%s' 파일에 저장했습니다.\n",
					list.size(),file.getName());
		} catch (IOException e) {
			System.out.printf("객체를 '%s' 파일에 쓰는 중에 오류 발생 - %s\n", 
					file.getName(), e.getMessage());
		} finally {
			try {
				out.close();
			} catch (Exception e) {}
		}
	}


	@SuppressWarnings("unchecked")
	private static <E extends Serializable> void loadObjects(Collection<E> list, File file) {
		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(file)));

			int size = in.readInt();
			for (int i = 0; i < size; i++) {
				list.add((E)in.readObject());
			}
			System.out.printf("'%s' 파일에서 총 %d개의 객체를 로딩했습니다.\n",
					file.getName(),list.size());
		} catch (Exception e) {
			System.out.printf("'%s' 파일 읽기 작업 중 오류가 발생 - %s\n",
					file.getName(),e.getMessage());
		} finally {
			try {
				in.close();
			} catch (Exception e) {}
		}
	}

}
