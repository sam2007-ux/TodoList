import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TodoListAppGUI extends Application implements EventHandler<ActionEvent> {
  private final TodoList todoList = new TodoList();
  private final ObservableList<String> tasks = FXCollections.observableArrayList();
  private final ListView<String> tasksListView = new ListView<>(tasks);
  private final TextField taskInput = new TextField();

  public static void main(String[] args) {
    launch(TodoListAppGUI.class, args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("ToDoList App");

    /*
     * // Set up the Menu
     * Menu todoMenu = new Menu("TodoList");
     * 
     * MenuItem continueMenuItem = new MenuItem("Continue");
     * continueMenuItem.setOnAction(e -> showTodoList(primaryStage));
     * 
     * MenuItem settingsMenuItem = new MenuItem("Settings");
     * settingsMenuItem.setOnAction(e -> showSettings(primaryStage));
     * 
     * MenuItem exitMenuItem = new MenuItem("Exit");
     * exitMenuItem.setOnAction(e -> System.exit(0));
     * 
     * todoMenu.getItems().addAll(continueMenuItem, settingsMenuItem, exitMenuItem);
     * 
     * MenuBar menuBar = new MenuBar();
     * menuBar.getMenus().addAll(todoMenu);
     * 
     * Will need commented code later
     */

    Text titleText = new Text("TodoList Application");
    // titleText.setFont(Font.font(20));
    titleText.setFont(Font.font(20));
    titleText.getStyleClass().add("text");

    Button continueButton = new Button("Continue");
    Button settingsButton = new Button("Settings");
    Button exiButton = new Button("Exit");

    continueButton.getStyleClass().add("starting-button");
    settingsButton.getStyleClass().add("starting-button");
    exiButton.getStyleClass().add("starting-button");

    continueButton.setOnAction(e -> showTodoList(primaryStage));
    settingsButton.setOnAction(e -> showSettings(primaryStage));
    exiButton.setOnAction(e -> System.exit(0));

    VBox startLayout = new VBox(10);
    startLayout.setPadding(new Insets(10));
    startLayout.getChildren().addAll(titleText, continueButton, settingsButton, exiButton);

    Scene startScene = new Scene(startLayout, 300, 200);

    startScene.getStylesheets().add("style.css");

    primaryStage.setScene(startScene);

    primaryStage.show();
  }

  private void showTodoList(Stage primaryStage) {
    // Set up the GUI components
    Button addButton = new Button("Add Task");
    addButton.getStyleClass().add("todo-button");
    Button removeButton = new Button("Remove Task");
    removeButton.getStyleClass().add("todo-button");
    Button viewAllButton = new Button("View All Tasks");
    viewAllButton.getStyleClass().add("todo-button");
    Button viewCompletedButton = new Button("View Completed Tasks");
    viewCompletedButton.getStyleClass().add("todo-button");
    Button markCompletedButton = new Button("Mark Task as Completed");
    markCompletedButton.getStyleClass().add("todo-button");
    Button sortTasksButton = new Button("Sort Tasks");
    sortTasksButton.getStyleClass().add("todo-button");

    // Set up blinking cursor animation for taskInput
    Text cursor = new Text("|");
    cursor.setFill(Color.BLUE);

    Timeline blinkCursor = new Timeline(
        new KeyFrame(Duration.seconds(0.5), event -> cursor.setVisible(!cursor.isVisible())));
    blinkCursor.setCycleCount(Timeline.INDEFINITE);
    blinkCursor.play();

    taskInput.textProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue.isEmpty()) {
        blinkCursor.play();
      } else {
        blinkCursor.pause();
        cursor.setVisible(true);
      }
    });

    // Set up the layout
    VBox layout = new VBox(10);
    layout.setPadding(new Insets(10));
    layout.getChildren().addAll(taskInput, tasksListView, addButton, removeButton, viewAllButton,
        viewCompletedButton,
        markCompletedButton, sortTasksButton);

    // Set up event handlers
    addButton.setOnAction(e -> addTask());
    removeButton.setOnAction(e -> removeTask());
    viewAllButton.setOnAction(e -> viewAllTasks());
    viewCompletedButton.setOnAction(e -> viewCompletedTasks());
    markCompletedButton.setOnAction(e -> markTaskAsCompleted());
    sortTasksButton.setOnAction(e -> sortTasks());

    Scene scene = new Scene(layout, 600, 400);
    scene.getStylesheets().add("style.css");
    primaryStage.setScene(scene);

    primaryStage.show();

  }

  private void showSettings(Stage primaryStage) {
    System.out.println("Showing Settings...");
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
