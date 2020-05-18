package com.chensee.thread.线程的调度串行和并行.a;

/**
 * @author ah
 * @title: SImpleTask
 * @date 2020/3/18 10:44
 */
public class SImpleTask implements Task {

    private TaskGroup taskGroup;

    private String name;

    public SImpleTask(String name) {
        this.name = name;
    }

    @Override
    public String getName(String name) {
        return this.name;
    }

    @Override
    public void init() {
        System.out.println(name+"..任务执行前");
    }

    @Override
    public void execute() {
        System.out.println(Thread.currentThread().getName() + "..." + name);
    }

    @Override
    public void finish() {
        System.out.println(name+"..任务执行后");
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
