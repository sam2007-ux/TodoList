import java.util.ArrayList;
import java.util.Collections;

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

  // Imporved View All Tasks

  public ArrayList<String> viewAllTasks() {
    ArrayList<String> allTasks = new ArrayList<>();
    if (tasks.isEmpty()) {
      System.out.println("No tasks in the list");
    } else {
      System.out.println("----- All Tasks -----");
      for (int i = 0; i < tasks.size(); i++) {
        String task = (i + 1) + "." + tasks.get(i);
        allTasks.add(task);
        System.out.println(task);
      }
    }

    return allTasks;
  }

  public ArrayList<String> getCompletedList() {
    ArrayList<String> completedTasks = new ArrayList<>();
    for (String task : tasks) {
      if (task.endsWith("[Completed]")) {
        completedTasks.add(task);
      }
    }

    return completedTasks;
  }

  // View Completed Tasks
  public ArrayList<String> viewCompletedTasks() {
    ArrayList<String> completedTasks = getCompletedList();

    if (completedTasks == null) {
      System.out.println("Error retrieving completed tasks.");
      return new ArrayList<>(); // Return an empty list or handle it appropriately
    }

    if (completedTasks.isEmpty()) {
      System.out.println("No completed tasks in the list.");
    } else {
      System.out.println("----- Completed Tasks -----");
      for (int i = 0; i < completedTasks.size(); i++) {
        String completedTask = (i + 1) + "." + completedTasks.get(i);
        System.out.println(completedTask);
      }
    }

    return completedTasks;
  }

  // Mark Task as completed
  public void markTaskAsCompleted(String task) {
    if (tasks.contains(task)) {
      tasks.set(tasks.indexOf(task), task + "[Completed]");
      System.out.println("Task \"" + task + "\" marked as completed.");
    } else {
      System.out.println("Task \"" + task + "\" not found in the list.");
    }
  }

  // Sort Tasks
  public void sortTasks() {
    Collections.sort(tasks);
    System.out.println("Tasks sorted Alphabetically");
  }

}
