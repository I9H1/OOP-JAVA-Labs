package ru.nsu.ccfit.burlakov.threadpool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool implements TaskListener {
    private final LinkedBlockingQueue<ThreadPoolTask> taskQueue = new LinkedBlockingQueue<>();
    private final Set<PooledThread> readyThreads = new HashSet<>();

    public ThreadPool(int threadAmount){
        for (int i = 0; i < threadAmount; ++i){
            readyThreads.add(new PooledThread("Thread_" + i, taskQueue));
        }
        for (PooledThread thread : readyThreads){
            thread.start();
        }
    }

    @Override
    public void taskInterrupted(Task t) {

    }

    @Override
    public void taskFinished(Task t) {

    }

    @Override
    public void taskStarted(Task t) {

    }

    public void addTask(Task t) {
        addTask(t, this);
    }

    public void addTask(Task t, TaskListener l) {
        taskQueue.offer(new ThreadPoolTask(t, l));
    }

    public void shutdown() {
        for (PooledThread thread : readyThreads) {
            thread.stopRunning();
        }
        for (PooledThread thread: readyThreads){
            try {
                thread.join();
                //logger (?)
            } catch (InterruptedException e){
                //logger
            }
        }
    }
}
