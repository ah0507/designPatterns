package com.chensee.thread.thread1;

public interface Task {

    void setTaskName(String name);

    String getTaskName();

    void init();

    void execute();

    void finish();

    void setTaskGroup(TaskGroup taskGroup);

    TaskGroup getTaskGroup();
}
