package com.chensee.thread.线程的调度串行和并行.a;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ah
 * @title: SimpleTaskGroup
 * @date 2020/3/18 10:48
 */
public class SimpleTaskGroup implements TaskGroup {

    private TaskGroup taskGroup;

    private String name;

    private List<Task> taskList;

    public SimpleTaskGroup(String name) {
        this.name = name;
        taskList = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        taskList.add(task);
        task.setTaskGroup(this);
    }

    @Override
    public List<Task> getTasks() {
        return this.taskList;
    }

    @Override
    public void removeTask(Task task) {
        taskList.remove(task);
    }

    @Override
    public String getName(String name) {
        return name;
    }

    @Override
    public void init() {
        System.out.println(name+"..任务组执行前");
    }

    @Override
    public void execute() {
        System.out.println(Thread.currentThread().getName() + "..." + name);
        this.finish();
    }

    @Override
    public void finish() {
        System.out.println(name+"..任务组执行后");
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
