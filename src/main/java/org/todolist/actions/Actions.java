package org.todolist.actions;

import org.todolist.db.Todolist;
import org.todolist.util.Util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actions {
  Util util = new Util();

  public List<Todolist.Task> viewTodoList(List<Todolist.Task> tasks) {
    if (tasks == null || tasks.isEmpty()) {
      util.printToAlertEmpty();
      return tasks;
    }

    util.printALine();
    System.out.println("Here are your todos:");
    util.printALine();

    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(i + " - " + tasks.get(i).getTitle());
    }

    return tasks;
  }

  public List<Todolist.Task> addNewTodo(List<Todolist.Task> tasks) {
    if (tasks == null) {
      tasks = new ArrayList<>();
    }

    Todolist.Task task = new Todolist.Task();

    util.printALine();
    System.out.print("Enter a name for the new todo: ");

    Scanner scanner = new Scanner(System.in);
    String todoTitle = scanner.nextLine();

    if (todoTitle.trim().isEmpty()) {
      int userChoice = util.userChoice("The new todo name is empty, would you like to re-enter it?");

      switch (userChoice) {
        case 1:
          addNewTodo(tasks);
          return tasks;
        default:
          System.out.println("Creating a new Todo has been cancelled!");
          return tasks;
      }
    }

    task.setTitle(todoTitle);
    tasks.add(task);

    System.out.println("new todo created successfully!");

    return tasks;
  }

  public List<Todolist.Task> deleteTodoWithIndex(List<Todolist.Task> tasks) throws FileNotFoundException {
    if (tasks.isEmpty()) {
      util.printToAlertEmpty();
      return tasks;
    }

    viewTodoList(tasks);
    util.printALine();
    System.out.print("Type the Todo index you want to delete: ");

    Scanner scanner = new Scanner(System.in);
    int index = scanner.nextInt();

    if(tasks.size() - 1 < index || index < 0){
      int userChoice = util.userChoice("You entered the wrong index! Would you like to re-enter it?");

      switch (userChoice) {
        case 1:
          deleteTodoWithIndex(tasks);
          return tasks;
        default:
          System.out.println("Creating a new Todo has been cancelled!");
          return tasks;
      }
    }

    tasks.remove(index);

    System.out.println("Todo deleted successfully!");

    return tasks;
  }
}
