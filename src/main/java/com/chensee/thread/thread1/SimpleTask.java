package com.chensee.thread.thread1;

import java.util.Date;

public class SimpleTask implements Task {

    private TaskGroup taskGroup;

    private String taskName;

    public SimpleTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void setTaskName(String name) {
        this.taskName = name;
    }

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    @Override
    public void init() {

    }

    @Override
    public void execute() {
        try {
            Thread.sleep(1000);
            System.out.println(this.taskName + "执行...");
            System.out.println(Thread.currentThread().getName() + this.taskName + new Date());
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
