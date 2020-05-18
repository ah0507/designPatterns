package com.chensee.thread.线程的调度串行和并行.a;

/**
 * @author ah
 * @title: 任务
 * @date 2020/3/16 17:05
 */
public interface Task {

    String getName(String name);

    /**
     * 认为执行前
     */
    void init();

    /**
     * 任务需要执行
     */
    void execute();

    /**
     * 任务执行后
     */
    void finish();

    /**
     * 任务中可能包含任务组
     * @return
     */
    TaskGroup getTaskGroup();

    void setTaskGroup(TaskGroup taskGroup);
}
