package com.chensee.thread.线程的调度串行和并行;

import java.util.ArrayList;
import java.util.List;

public class SimpleTaskGroup implements TaskGroup {

    private TaskGroup taskGroup;

    private String name;

    private List<Task> tasks = new ArrayList<>();

    public SimpleTaskGroup(String name) {
        this.name = name;
    }
    @Override
    public void addTask(Task task) {
        tasks.add(task);
        this.taskGroup = this;
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public void execute() {
        System.out.println(this.name+" is complete");
    }

    @Override
    public TaskGroup getTaskGroup() {
        return taskGroup;
    }

    @Override
    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }
}
