package com.chensee.thread.线程的调度串行和并行.a;

import java.util.List;

/**
 * @author ah
 * @title: 任务组也属于任务
 * @date 2020/3/16 17:06
 */
public interface TaskGroup extends Task{

    /**
     * 添加一个任务
     * @param task
     */
    void addTask(Task task);

    /**
     * 任务组中获得所有的任务
     * @return
     */
    List<Task> getTasks();

    /**
     * 移除某一个任务
     * @param task
     */
    void removeTask(Task task);
}
