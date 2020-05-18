package com.chensee.thread.线程的调度串行和并行;


/**
 * @author gaohang
 * 任务
 */
public interface Task {

    void execute();

    TaskGroup getTaskGroup();

    void setTaskGroup(TaskGroup taskGroup);
}
