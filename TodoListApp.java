import java.util.Scanner;

public class TodoListApp {
  public static Scanner scanner = new Scanner(System.in);
  public static TodoList todoList = new TodoList();

  public static void main(String[] args) {
    Menu();

  }

  public static void Menu() {
    while (true) {
      System.out.println("\n--- To-Do List Application --- \n");
      System.out.println("     > Add Task");
      System.out.println("     > Remove Task");
      System.out.println("     > View Tasks");
      System.out.println("     > Exit" + "\n");

      System.out.print("Enter your choice: ");
      String choice = scanner.nextLine().toLowerCase();

      switch (choice.toLowerCase()) {
        case "add task":
        case "at":
        case "1":
          System.out.println();
          System.out.print("Enter the Task: ");
          String taskToAdd = scanner.nextLine();
          System.out.println();
          todoList.addTasks(taskToAdd);
          break;
        case "remove task":
        case "rt":
        case "2":
          System.out.println();
          System.out.print("Enter the Task to Remove: ");
          String taskToRemove = scanner.nextLine();
          System.out.println();
          todoList.removeTasks(taskToRemove);
          break;
        case "view task":
        case "vt":
        case "3":
          System.out.println();
          System.out.print("Enter the Task to View : ");
          String taskToView = scanner.nextLine();
          System.out.println();
          todoList.ViewTasks(taskToView);
          break;
        case "exit":
        case "e":
        case "4":
          System.out.println();
          System.out.println("Exiting the To-Do List Application. Goodbye!");
          scanner.close();
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice, Please Try again");
      }
    }
  }
}
