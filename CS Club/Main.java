import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                    taskManager.addTask(new Task(title, description, dueDate));
                    break;

                case 2:
                    for (int i = 0; i < taskManager.getTasks().size(); i++) {
                        System.out.println(i + ": " + taskManager.getTasks().get(i));
                    }
                    break;

                case 3:
                    System.out.print("Enter task index to complete: ");
                    int index = scanner.nextInt();
                    taskManager.completeTask(index);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}