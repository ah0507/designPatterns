package com.chensee.thread.线程的调度串行和并行;

public class SimpleTask implements Task {

    private TaskGroup taskGroup;

    private String name;

    public SimpleTask(String name) {
        this.name = name;
    }
    @Override
    public void execute() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"   "+name);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
