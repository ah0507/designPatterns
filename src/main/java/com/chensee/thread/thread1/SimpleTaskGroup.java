package com.chensee.thread.thread1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleTaskGroup implements TaskGroup{

    private String TaskGroupName;

    private TaskGroup taskGroup;

    private List<Task> tasks = new ArrayList<>();

    public SimpleTaskGroup(String name){
        this.TaskGroupName = name;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        task.setTaskGroup(this);
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public List<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public void setTaskName(String name) {
        this.TaskGroupName = name;
    }

    @Override
    public String getTaskName() {
        return this.TaskGroupName;
    }

    @Override
    public void init() {

    }

    @Override
    public void execute() {
        try {
            Thread.sleep(1000);
            System.out.println(this.TaskGroupName + "执行...");
            System.out.println(Thread.currentThread().getName() + this.TaskGroupName + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finish() {

    }

    @Override
    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }

    @Override
    public TaskGroup getTaskGroup() {
        return this.taskGroup;
    }
}
