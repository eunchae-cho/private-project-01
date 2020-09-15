package com.pms;



import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

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
	static File boardFile = new File("./board.csv"); 
	static File memberFile = new File("./member.csv");
	static File projectFile = new File("./project.csv");
	static File taskFile = new File("./task.csv");

	public static void main(String[] args) {

		loadBoards();
		loadMembers();
		loadProjects();
		loadTasks();

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
		saveBoards();
		saveMembers();
		saveProjects();
		saveTasks();
	}

	static void printCommandHistory(Iterator<String> iterator) {
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

	static void saveBoards() {
		System.out.println("[게시글 저장]");

		FileWriter out = null;
		try {
			out = new FileWriter(boardFile);

			for (Board board : boardList) {

				out.write(board.toCsvString()); 
			}
		} catch (IOException e) {
			System.out.println("파일 출력 작업 중 오류가 발생!");
		} finally {
			try {
				out.close();
			} catch (Exception e) {}
		}
	}

	static void loadBoards() {
		System.out.println("[게시글 파일 로딩]");

		FileReader out = null;
		Scanner scanner = null;
		try {
			out = new FileReader(boardFile);
			scanner = new Scanner(out);

			while (true) {
				try {
					boardList.add(Board.valueOfCsv(scanner.nextLine()));
				} catch (NoSuchElementException e) {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("파일 읽기 작업 중 오류가 발생!");
		} finally {
			try {scanner.close();} catch (Exception e) {}
			try {out.close();} catch (Exception e) {}
		}
	}





	static void saveMembers() {
		System.out.println("[회원 저장]");

		FileWriter out = null;
		try {
			out = new FileWriter(memberFile);

			for (Member member : memberList) {
				out.write(member.toCsvString()); 
			}
		} catch (IOException e) {
			System.out.println("파일 출력 작업 중 오류가 발생!");
			System.out.println(e.getMessage());
		} finally {
			try {
				out.close();
			} catch (Exception e) {}
		}
	}

	static void loadMembers() {
		System.out.println("[회원 파일 로딩]");

		FileReader out = null;
		Scanner scanner = null;
		try {
			out = new FileReader(memberFile);
			scanner = new Scanner(out);

			while (true) {
				try {
					memberList.add(Member.valueOfCsv(scanner.nextLine()));
				} catch (NoSuchElementException e) {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("파일 읽기 작업 중 오류가 발생!");
		} finally {
			try {scanner.close();} catch (Exception e) {}
			try {out.close();} catch (Exception e) {}
		}
	}

	static void saveProjects() {
		System.out.println("[프로젝트 저장]");

		FileWriter out = null;
		try {
			out = new FileWriter(projectFile);

			for (Project project : projectList) {
				out.write(project.toCsvString()); 
			}
		} catch (IOException e) {
			System.out.println("파일 출력 작업 중 오류가 발생!");
		} finally {
			try {
				out.close();
			} catch (Exception e) {}
		}
	}

	static void loadProjects() {
		System.out.println("[프로젝트 파일 로딩]");

		FileReader out = null;
		Scanner scanner = null;
		try {
			out = new FileReader(projectFile);
			scanner = new Scanner(out);

			while (true) {
				try {
					projectList.add(Project.valueOfCsv(scanner.nextLine()));
				} catch (NoSuchElementException e) {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("파일 읽기 작업 중 오류가 발생!");
		} finally {
			try {scanner.close();} catch (Exception e) {}
			try {out.close();} catch (Exception e) {}
		}
	}

	static void saveTasks() {
		System.out.println("[임무 저장]");

		FileWriter out = null;
		try {
			out = new FileWriter(taskFile);

			for (Task task : taskList) {
				out.write(task.toCsvString()); 
			}
		} catch (IOException e) {
			System.out.println("파일 출력 작업 중 오류가 발생!");
		} finally {
			try {
				out.close();
			} catch (Exception e) {}
		}
	}

	static void loadTasks() {
		System.out.println("[임무 저장]");

		FileReader out = null;
		Scanner scanner = null;
		try {
			out = new FileReader(taskFile);
			scanner = new Scanner(out);

			while (true) {
				try {
					taskList.add(Task.valueOfCsv(scanner.nextLine()));
				} catch (NoSuchElementException e) {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("파일 읽기 작업 중 오류가 발생!");
		} finally {
			try {scanner.close();} catch (Exception e) {}
			try {out.close();} catch (Exception e) {}
		}
	}

}
