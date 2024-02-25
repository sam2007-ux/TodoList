import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodoListAppGUI extends Application implements EventHandler<ActionEvent> {
  private final TodoList todoList = new TodoList();
  private final ObservableList<String> tasks = FXCollections.observableArrayList();
  private final ListView<String> tasksListView = new ListView<>(tasks);
  private final TextField taskInput = new TextField();

  public static void main(String[] args) {
    launch(TodoListAppGUI.class, args);
  }

  @Override
  public void start(Stage primarStage) {
    primarStage.setTitle("ToDoList App");

    // Set up the GUI components
    Button addButton = new Button("Add Task");
    Button removeButton = new Button("Remove Task");
    Button viewAllButton = new Button("View All Tasks");
    Button viewCompletedButton = new Button("View Completed Tasks");
    Button markCompletedButton = new Button("Mark Task as Completed");
    Button sortTasksButton = new Button("Sort Tasks");

    // Set up the layout

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(10));
    layout.getChildren().addAll(taskInput, tasksListView, addButton, removeButton, viewAllButton, viewCompletedButton,
        markCompletedButton, sortTasksButton);

    // Set up event handlers

    addButton.setOnAction(e -> addTask());
    removeButton.setOnAction(e -> removeTask());
    viewAllButton.setOnAction(e -> viewAllTasks());
    viewCompletedButton.setOnAction(e -> viewCompletedTasks());
    markCompletedButton.setOnAction(e -> markTaskAsCompleted());
    sortTasksButton.setOnAction(e -> sortTasks());

    Scene scene = new Scene(layout, 600, 400);
    primarStage.setScene(scene);

    primarStage.show();
  }

  private void addTask() {
    String task = taskInput.getText();
    if (!task.isEmpty()) {
      todoList.addTasks(task);
      tasks.add(task);
      taskInput.clear();
    }
  }

  private void removeTask() {
    int selectedIndex = tasksListView.getSelectionModel().getSelectedIndex();
    if (selectedIndex != -1) {
      String taskToRemove = tasks.remove(selectedIndex);
      todoList.removeTasks(taskToRemove);
    }
  }

  private void viewAllTasks() {
    tasks.clear();
    tasks.addAll(todoList.viewAllTasks());
  }

  private void viewCompletedTasks() {
    tasks.clear();
    tasks.addAll(todoList.viewCompletedTasks());
  }

  private void markTaskAsCompleted() {
    int selectedIndex = tasksListView.getSelectionModel().getSelectedIndex();
    if (selectedIndex != -1) {
      String taskToMark = tasks.get(selectedIndex);
      todoList.markTaskAsCompleted(taskToMark);
      viewAllTasks();
    }
  }

  private void sortTasks() {
    todoList.sortTasks();
    viewAllTasks();
  }

}
