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
      System.out.println(i + " - " + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription());
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

    System.out.print("Enter a description for the todo: ");
    String todoDescription = scanner.nextLine();

    task.setTitle(todoTitle);
    task.setDescription(todoDescription);
    tasks.add(task);

    System.out.println("New todo created successfully!");

    return tasks;
  }

  public List<Todolist.Task> deleteTodoWithIndex(List<Todolist.Task> tasks) {
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
          System.out.println("Deleting a new Todo has been cancelled!");
          return tasks;
      }
    }

    tasks.remove(index);

    System.out.println("Todo deleted successfully!");

    return tasks;
  }
  
  public List<Todolist.Task> deleteTodos(List<Todolist.Task> tasks) {
    if (tasks == null || tasks.isEmpty()) {
      util.printToAlertEmpty();
      return tasks;
    }

    util.printALine();
    System.out.println("Which way you want to delete?");
    int userChoice = util.userChoice( "Delete with index:", "Delete all todos");

    switch (userChoice) {
      case 1:
        tasks = deleteTodoWithIndex(tasks);
        return tasks;
      case 2:
        tasks.clear();
        System.out.println("All todos deleted.");
        break;
      default:
        int userItemChoice = util.userChoice("You entered number! Would you like to re-enter it?");

        switch (userItemChoice) {
          case 1:
            deleteTodos(tasks);
            break;
          default:
            System.out.println("Deleting a Todo has been cancelled!");
            break;
        }
        break;
    }

    return tasks;
  }

  public List<Todolist.Task> editTodoName(List<Todolist.Task> tasks) {
    viewTodoList(tasks);
    util.printALine();
    System.out.print("Type the Todo index you want to edit: ");

    Scanner scanner = new Scanner(System.in);
    int index = scanner.nextInt();
    scanner.nextLine();

    if(tasks.size() - 1 < index || index < 0){
      int userChoice = util.userChoice("Invalid Index! Would you like to re-enter it?");

      switch (userChoice) {
        case 1:
          editTodoName(tasks);
          return tasks;
        default:
          System.out.println("Editing a new Todo has been cancelled!");
          return tasks;
      }
    }

    util.printALine();
    System.out.print("Enter a new name for the todo: ");
    String todoTitle = scanner.nextLine();
    tasks.get(index).setTitle(todoTitle);
    return tasks;
  }

  public List<Todolist.Task> editTodoDescription(List<Todolist.Task> tasks) {
    viewTodoList(tasks);
    util.printALine();
    System.out.print("Type the Todo index you want to edit: ");

    Scanner scanner = new Scanner(System.in);
    int index = scanner.nextInt();
    scanner.nextLine();

    if(tasks.size() - 1 < index || index < 0){
      int userChoice = util.userChoice("Invalid Index! Would you like to re-enter it?");

      switch (userChoice) {
        case 1:
          editTodoName(tasks);
          return tasks;
        default:
          System.out.println("Editing a new Todo has been cancelled!");
          return tasks;
      }
    }

    util.printALine();
    System.out.print("Enter a new description for the todo: ");
    String todoDescription = scanner.nextLine();
    tasks.get(index).setDescription(todoDescription);

    return tasks;
  }

  public List<Todolist.Task> editTodos(List<Todolist.Task> tasks) {
    if (tasks == null || tasks.isEmpty()) {
      util.printToAlertEmpty();
      return tasks;
    }

    util.printALine();
    System.out.println("What would you like to edit?");
    int userChoice = util.userChoice( "Edit todo name", "Edit todo description");

    switch (userChoice) {
      case 1:
        tasks = editTodoName(tasks);
        return tasks;
      case 2:
        tasks = editTodoDescription(tasks);
        return tasks;
      default:
        int userItemChoice = util.userChoice("You entered number! Would you like to re-enter it?");

        switch (userItemChoice) {
          case 1:
            editTodos(tasks);
            break;
          default:
            System.out.println("Editing a Todo has been cancelled!");
            break;
        }
        break;
    }

    return tasks;
  }

}
