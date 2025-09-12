import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ToDoListCLI {
	private final List<String> tasks = new ArrayList<>();

	// UI elements
	private static final String SEPARATOR = "----------------------------------------------";
	private static final String BORDER = "+--------------------------------------------+";
	private static final String CHECK = "[✓] ";
	private static final String CROSS = "[x] ";
	private static final String INFO = "[i] ";

	private void printBanner() {
		System.out.println(BORDER);
		System.out.println("|              To-Do List CLI               |");
		System.out.println("|        พิมพ์ 'help' เพื่อดูคำสั่ง        |");
		System.out.println(BORDER);
	}

	private void printHelp() {
		System.out.println(BORDER);
		System.out.println("|                วิธีใช้งาน                 |");
		System.out.println(BORDER);
		System.out.println("  add <งาน>       - เพิ่มงานใหม่ เช่น: add อ่านหนังสือบทที่ 5");
		System.out.println("  list            - แสดงรายการงานทั้งหมดที่ยังไม่ได้ทำ");
		System.out.println("  remove <ลำดับ>  - ลบงานตามหมายเลขลำดับ เช่น: remove 2");
		System.out.println("  help            - แสดงวิธีใช้");
		System.out.println("  exit            - ออกจากโปรแกรม");
		System.out.println(SEPARATOR);
	}

	private void addTask(String task) {
		if (task == null || task.trim().isEmpty()) {
			System.out.println(CROSS + "โปรดระบุรายละเอียดงานหลังคำสั่ง add");
			return;
		}
		tasks.add(task.trim());
		System.out.println(CHECK + "เพิ่มงานแล้ว: " + task.trim());
	}

	private void listTasks() {
		if (tasks.isEmpty()) {
			System.out.println(INFO + "ยังไม่มีงานในลิสต์");
			return;
		}
		System.out.println(BORDER);
		String header = String.format("|   รายการงานทั้งหมด (%d งาน)%s|", tasks.size(), spacesForRightEdge( tasks.size() ));
		System.out.println(header);
		System.out.println(BORDER);
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println(String.format("  %2d. %s", i + 1, tasks.get(i)));
		}
		System.out.println(SEPARATOR);
	}

	// Provide simple right padding to keep the top border aligned (no ANSI width calc)
	private String spacesForRightEdge(int count) {
		// "|   รายการงานทั้งหมด (X งาน)" is variable width with X
		// We aim total inner width 44 chars. Compute rough padding.
		String sample = "|   รายการงานทั้งหมด (" + count + " งาน)";
		int innerWidth = 44; // matches BORDER length minus 2
		int current = sample.length();
		int pad = Math.max(0, innerWidth - current);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pad; i++) sb.append(' ');
		return sb.toString();
	}

	private void removeTask(String indexText) {
		if (indexText == null || indexText.trim().isEmpty()) {
			System.out.println(INFO + "โปรดระบุหมายเลขลำดับของงานที่ต้องการลบ เช่น: remove 1");
			return;
		}
		try {
			int idx = Integer.parseInt(indexText.trim());
			if (idx < 1 || idx > tasks.size()) {
				System.out.println(CROSS + "หมายเลขลำดับไม่ถูกต้อง (ช่วงที่ถูกต้อง: 1-" + tasks.size() + ")");
				return;
			}
			String removed = tasks.remove(idx - 1);
			System.out.println(CHECK + "ลบงานแล้ว: " + removed);
		} catch (NumberFormatException e) {
			System.out.println(CROSS + "โปรดระบุหมายเลขลำดับเป็นตัวเลข เช่น: remove 2");
		}
	}

	public void run() {
		Scanner scanner = new Scanner(System.in, "UTF-8");
		printBanner();
		printHelp();
		while (true) {
			System.out.print("\n> ");
			if (!scanner.hasNextLine()) {
				break;
			}
			String line = scanner.nextLine();
			if (line == null) {
				continue;
			}
			line = line.trim();
			if (line.isEmpty()) {
				continue;
			}

			String command;
			String args = "";
			int space = line.indexOf(' ');
			if (space == -1) {
				command = line;
			} else {
				command = line.substring(0, space);
				args = line.substring(space + 1);
			}

			switch (command.toLowerCase()) {
				case "add":
					addTask(args);
					break;
				case "list":
					listTasks();
					break;
				case "remove":
					removeTask(args);
					break;
				case "help":
					printHelp();
					break;
				case "exit":
					System.out.println("ลาก่อน");
					scanner.close();
					return;
				default:
					System.out.println(INFO + "ไม่รู้จักคำสั่ง: " + command + " (พิมพ์ help เพื่อดูคำสั่ง)");
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		new ToDoListCLI().run();
	}
}
