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
    private String title;

    private String description;

    public void setTitle(String title) {
      this.title = title;
    }

    public String getTitle() {
      return title;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getDescription() {
      return description;
    }
    }

  @Override
  public String toString() {
    return "Todolist{" +
            "tasks=" + tasks +
            '}';
  }
}
