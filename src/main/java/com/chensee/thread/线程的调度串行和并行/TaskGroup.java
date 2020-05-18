package com.chensee.thread.线程的调度串行和并行;

import java.util.List;

public interface TaskGroup extends Task {

    void addTask(Task task);

    List<Task> getTasks();

    void removeTask(Task task);
}
