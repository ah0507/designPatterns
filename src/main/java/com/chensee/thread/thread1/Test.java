package com.chensee.thread.thread1;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        init();
    }

    public static void init(){
        TaskGroup root = new SimpleTaskGroup("root");
        TaskGroup taskGroup1 = new SimpleTaskGroup("任务组1");
        TaskGroup taskGroup2 = new SimpleTaskGroup("任务组2");
        TaskGroup taskGroup3 = new SimpleTaskGroup("任务组3");
        Task task11 = new SimpleTask("任务组1中任务1");
        Task rootTask = new SimpleTask("小任务");
        Task task22 = new SimpleTask("任务组2中任务1");
        Task task33 = new SimpleTask("任务组3中任务1");
        taskGroup1.addTask(task11);
        taskGroup2.addTask(task22);
        taskGroup3.addTask(task33);
        taskGroup2.addTask(taskGroup3);
        root.addTask(taskGroup1);
        root.addTask(rootTask);
        root.addTask(taskGroup2);
        ThreadManeger threadManeger = new ThreadManeger();
        threadManeger.execute(root);
    }
}
