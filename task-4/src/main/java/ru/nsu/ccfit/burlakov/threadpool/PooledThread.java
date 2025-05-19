package ru.nsu.ccfit.burlakov.threadpool;

import java.util.ArrayDeque;

public class PooledThread extends Thread {
    private final ArrayDeque<Task> taskQueue;

    public PooledThread(String name, ArrayDeque<Task> taskQueue) {
        super(name);
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            Task task;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                task = taskQueue.removeFirst();
            }
            try {
                task.performWork();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}