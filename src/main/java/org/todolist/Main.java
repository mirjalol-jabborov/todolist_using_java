package org.todolist;

import org.todolist.actions.Actions;
import org.todolist.util.Util;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> todolist = new ArrayList<>();

    Util util = new Util();
    Actions actions = new Actions();

    while (true) {
      util.printALine();
      int userChoice = util.userChoice( "see the TodoList:", "create a new todo:", "delete a todo:");

      switch (userChoice) {
        case 1:
          actions.viewTodoList(todolist);
          break;
        case 2:
          todolist = actions.addNewTodo(todolist);
          break;
        case 3:
          todolist = actions.deleteTodoWithIndex(todolist);
          break;
      }
    }
  }
}