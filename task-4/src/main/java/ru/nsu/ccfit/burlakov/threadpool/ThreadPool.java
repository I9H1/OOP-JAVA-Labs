package ru.nsu.ccfit.burlakov.threadpool;

import java.util.ArrayDeque;

public class ThreadPool {
    private final ArrayDeque<Task> taskQueue = new ArrayDeque<>();
    private final ArrayDeque<PooledThread> threads = new ArrayDeque<>();

    public ThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            PooledThread thread = new PooledThread("PoolThread-" + i, taskQueue);
            threads.add(thread);
            thread.start();
        }
    }

    public void addTask(Task task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notifyAll();
        }
    }

    public void shutdown() {
        threads.forEach(Thread::interrupt);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}