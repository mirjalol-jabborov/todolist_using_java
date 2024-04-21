package org.todolist.db;

import java.util.List;

public class Todolist {
  private List<Task> tasks;

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public static class Task {
//    private static int last_id = 0;
//    private int task_id;
    private String title;

//    public Task() {
//      last_id++;
//    }

//    public int getTask_id() {
//      return task_id;
//    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getTitle() {
      return title;
    }

  }

  @Override
  public String toString() {
    return "Todolist{" +
            "tasks=" + tasks +
            '}';
  }
}
