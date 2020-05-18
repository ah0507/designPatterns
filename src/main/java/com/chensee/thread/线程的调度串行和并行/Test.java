package com.chensee.thread.线程的调度串行和并行;

public class Test {
    public static void main(String[] args) {
        TaskGroup root = new SimpleTaskGroup("root");
        TaskGroup taskGroup1 = new SimpleTaskGroup("taskGroup1");
        TaskGroup taskGroup2 = new SimpleTaskGroup("taskGroup2");
        TaskGroup taskGroup3 = new SimpleTaskGroup("taskGroup3");
        root.addTask(taskGroup1);
        taskGroup1.addTask(taskGroup2);
        taskGroup2.addTask(taskGroup3);
        Task task = new SimpleTask("task");
        Task task11 = new SimpleTask("task11");
        Task task111 = new SimpleTask("task111");
        Task task22 = new SimpleTask("task22");
        Task task33 = new SimpleTask("task33");
        root.addTask(task);
        taskGroup1.addTask(task11);
        taskGroup1.addTask(task111);
        taskGroup2.addTask(task22);
        taskGroup3.addTask(task33);
        ThreadManager threadManager = new ThreadManager();
        threadManager.execute(root);
    }
}
