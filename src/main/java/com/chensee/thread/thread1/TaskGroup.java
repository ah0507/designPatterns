package com.chensee.thread.thread1;

import java.util.List;

public interface TaskGroup extends Task{

    void addTask(Task task);

    void removeTask(Task task);

    List<Task> getTasks();
}
