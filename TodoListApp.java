import java.util.Scanner;

//things to add, google like checks,(ex. if person types add tasks, it will think user was trying to type "add task" and will ask confimation if yes - proceed, no - try again)
//incorporate menu function
//make a setting (SortTaskA / sortTasksByDate)
public class TodoListApp {
  public static Scanner scanner = new Scanner(System.in);
  public static TodoList todoList = new TodoList();

  public static void main(String[] args) {
    TodoListAppGUI.launch(TodoListAppGUI.class, args);

  }

  /*
   * public static void Menu() {
   * while (true) {
   * System.out.println("\n--- To-Do List Application --- \n");
   * System.out.println("     > Add Task");
   * System.out.println("     > Remove Task");
   * System.out.println("     > View All Tasks");
   * System.out.println("     > View Completed Tasks");
   * System.out.println("     > Mark Tasks as Completed");
   * System.out.println("     > Sort Tasks");
   * System.out.println("     > Exit" + "\n");
   * 
   * System.out.print("Enter your choice: ");
   * String choice = scanner.nextLine().toLowerCase();
   * 
   * switch (choice.toLowerCase()) {
   * case "add task":
   * case "at":
   * case "1":
   * System.out.println();
   * System.out.print("Enter the Task: ");
   * String taskToAdd = scanner.nextLine();
   * System.out.println();
   * todoList.addTasks(taskToAdd);
   * break;
   * case "remove task":
   * case "rt":
   * case "2":
   * System.out.println();
   * System.out.print("Enter the Task to Remove: ");
   * String taskToRemove = scanner.nextLine();
   * System.out.println();
   * todoList.removeTasks(taskToRemove);
   * // things to add: for remove function, make tasks to remove visible
   * // TODO: implement making tasks to remove visible
   * break;
   * case "view all tasks":
   * case "vat":
   * case "3":
   * todoList.viewAllTasks();
   * break;
   * case "view completed tasks":
   * case "vct":
   * case "4":
   * todoList.viewCompletedTasks();
   * break;
   * case "mark task as completed":
   * case "mtac":
   * case "5":
   * System.out.println();
   * System.out.print("Enter the Task to Mark as Completed: ");
   * String taskToMark = scanner.nextLine();
   * System.out.println();
   * todoList.markTaskAsCompleted(taskToMark);
   * break;
   * case "sort tasks":
   * case "st":
   * case "6":
   * todoList.sortTasks();
   * break;
   * case "exit":
   * case "e":
   * case "7":
   * System.out.println();
   * System.out.println("Exiting the To-Do List Application. Goodbye!");
   * scanner.close();
   * System.exit(0);
   * break;
   * default:
   * System.out.println("Invalid choice, Please Try again");
   * }
   * }
   * }
   * 
   */
}
