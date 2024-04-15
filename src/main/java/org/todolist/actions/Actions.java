package org.todolist.actions;

import org.todolist.util.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class Actions {
  Util util = new Util();

  public void viewTodoList(ArrayList<String> todolist) {
    if (todolist.isEmpty()) {
      util.printToAlertEmpty();
      return;
    }

    util.printALine();
    System.out.println("Here are your todos:");
    util.printALine();

    for (int i = 0; i < todolist.size(); i++) {
      System.out.println(i + " - " + todolist.get(i));
    }
  }

  public ArrayList<String> addNewTodo(ArrayList todolist) {
    util.printALine();
    System.out.print("Enter a name for the new todo: ");

    Scanner scanner = new Scanner(System.in);
    String todoName = scanner.nextLine();

    if (todoName.trim().isEmpty()) {
      int userChoice = util.userChoice("The new todo name is empty, would you like to re-enter it?");

      switch (userChoice) {
        case 1:
          addNewTodo(todolist);
          return todolist;
        default:
          System.out.println("Creating a new Todo has been cancelled!");
          return todolist;
      }
    }

    todolist.add(todoName);

    System.out.println("new todo created successfully!");

    return todolist;
  }

  public ArrayList<String> deleteTodoWithIndex(ArrayList<String> todolist) {
    if (todolist.isEmpty()) {
      util.printToAlertEmpty();
      return todolist;
    }

    viewTodoList(todolist);
    util.printALine();
    System.out.print("Type the Todo index you want to delete: ");

    Scanner scanner = new Scanner(System.in);
    int index = scanner.nextInt();

    if(todolist.size() - 1 < index || index < 0){
      int userChoice = util.userChoice("You entered the wrong index! Would you like to re-enter it?");

      switch (userChoice) {
        case 1:
          deleteTodoWithIndex(todolist);
          return todolist;
        default:
          System.out.println("Creating a new Todo has been cancelled!");
          return todolist;
      }
    }

    todolist.remove(index);

    System.out.println("Todo deleted successfully!");

    return todolist;
  }
}
