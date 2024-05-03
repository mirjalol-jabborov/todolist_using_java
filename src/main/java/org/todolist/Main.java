package org.todolist;

import org.todolist.actions.Actions;
import org.todolist.db.Todolist;
import org.todolist.util.Util;

import java.io.*;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> todolist = new ArrayList<>(); 
    
    boolean running = true; //added variable that keeps program running when true
    Util util = new Util();
    Actions actions = new Actions();

    while (running) {
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
        case 4: //sets boolean to false, terminating the program
        running = false;
        break;
          }
    }
  }
}
