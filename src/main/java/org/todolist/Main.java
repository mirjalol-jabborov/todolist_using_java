package org.todolist;

import org.todolist.actions.Actions;
import org.todolist.util.Util;
import java.util.ArrayList; 
//import necessary packages

public class Main {
  public static void main(String[] args) {
    ArrayList<String> todolist = new ArrayList<>(); 
    //create an array list of strings

    Util util = new Util();
    Actions actions = new Actions();
    //creating objects of uil and action classes, for main menu

    while (true) {
      util.printALine();
      int userChoice = util.userChoice( "see the TodoList:", "create a new todo:", "delete a todo:");
        //prompt user for choice
      
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
