package com.chensee.thread.线程的调度串行和并行.a;


public class Test {
    public static void main(String[] args) {
        TaskGroup root = new SimpleTaskGroup("root");
        TaskGroup taskGroup1 = new SimpleTaskGroup("taskGroup1");
        TaskGroup taskGroup11 = new SimpleTaskGroup("taskGroup11");
        TaskGroup taskGroup112 = new SimpleTaskGroup("taskGroup112");
        TaskGroup taskGroup2 = new SimpleTaskGroup("taskGroup2");
        TaskGroup taskGroup3 = new SimpleTaskGroup("taskGroup3");
        root.addTask(taskGroup1);
        Task taska = new SImpleTask("taska");
        root.addTask(taska);
        root.addTask(taskGroup11);
        Task taskb = new SImpleTask("taskb");
        root.addTask(taskb);

        taskGroup11.addTask(taskGroup112);
        taskGroup1.addTask(taskGroup2);
        taskGroup2.addTask(taskGroup3);
        Task task = new SImpleTask("task");
        Task task11 = new SImpleTask("task11");
        Task task111 = new SImpleTask("task111");
        Task task22 = new SImpleTask("task22");
        Task task33 = new SImpleTask("task33");
        Task task112 = new SImpleTask("task112");
        root.addTask(task);
        taskGroup1.addTask(task11);
        taskGroup1.addTask(task111);
        taskGroup2.addTask(task22);
        taskGroup3.addTask(task33);
        taskGroup112.addTask(task112);
        ThreadManager threadManager = new ThreadManager();
        threadManager.execute(root);
    }
}
