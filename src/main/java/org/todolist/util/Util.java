package org.todolist.util;

import java.util.Scanner;

public class Util {

  public static void printALine() {
    System.out.println("------------------------------------------------------------");
  }

  public static void printToAlertEmpty() {
    System.out.println("Your TodoList is empty!");
  }

  public static int userChoice(String choiceDisc) {
    System.out.println(choiceDisc);
    System.out.println("1. Yes, I want to!");
    System.out.println("2. No, thanks");
    System.out.print("Choice one: ");

    Scanner scanner = new Scanner(System.in);

    return intScanner(scanner);
  }

  public static int userChoice(String... choices) {
    for (int i = 0; i < choices.length; i++) {
      System.out.println(i + 1 + ". " + choices[i]);
    }

    System.out.print("Choice one: ");

    Scanner scanner = new Scanner(System.in);

    return intScanner(scanner);
  }

  // This looks for a valid input until one is received, that way it doesn't crash
  // when a letter is used
  public static int intScanner(Scanner scanner) {
    while (true) {
      try {
        return scanner.nextInt();
      } catch (Exception e) {
        System.out.println("That wasn't a valid input, please select a valid input");
        scanner.next();
      }
    }
  }
}