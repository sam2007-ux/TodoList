import java.util.ArrayList;

public class TodoList {
  private ArrayList<String> tasks;

  public TodoList() {
    this.tasks = new ArrayList<>();
  }

  // add Task ---
  public void addTasks(String task) {
    tasks.add(task);
    System.out.println("Task \"" + task + "\" added.");
  }

  // remove Task ---
  public void removeTasks(String task) {
    if (tasks.contains(task)) {
      tasks.remove(task);
      System.out.println("Task \"" + task + "\" removed.");
    } else {
      System.out.println("Task \"" + task + "\" not found in the list.");
    }
  }

  // view Task ---
  public void ViewTasks(String task) {
    if (tasks.isEmpty()) {
      System.out.println("No tasks in the list.");
    } else {
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println((i + 1) + "." + tasks.get(i));
      }
    }
  }

  // dummy print
  public void print() {
    System.out.println("Greetings!!");
  }
}
