package org.todolist.util;

import java.util.Scanner;

public class Util {
  public String getALine() {
    return "------------------------------------------------------------";
  }

  public void printALine() {
    System.out.println(getALine());
  }

  public void printToAlertEmpty() {
    System.out.println("Your TodoList is empty!");
  }

  public int userChoice(String choiceDisc) {
    System.out.println(choiceDisc);
    System.out.println("1. Yes, I want to!");
    System.out.println("2. No, thanks");
    System.out.print("Choice one: ");

    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public int userChoice(String... choices) {
    for (int i = 0; i < choices.length; i++) {
      System.out.println(i + 1 + ". " + choices[i]);
    }

    System.out.print("Choice one: ");

    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }
}