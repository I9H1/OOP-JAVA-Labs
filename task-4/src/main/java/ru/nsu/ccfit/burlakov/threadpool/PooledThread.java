package ru.nsu.ccfit.burlakov.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class PooledThread extends Thread {
    private final LinkedBlockingQueue<ThreadPoolTask> taskQueue;

    public PooledThread(String name, LinkedBlockingQueue<ThreadPoolTask> taskQueue){
        super(name);
        this.taskQueue = taskQueue;
    }

    private void performTask(ThreadPoolTask t) {
        t.prepare();
        try {
            t.go();
            t.finish();
        } catch (InterruptedException e){
            t.interrupted();
            Thread.currentThread().interrupt();
        }
    }

    public void run(){
        while (true) {
            try {
                ThreadPoolTask toExecute = taskQueue.take();
                performTask(toExecute);
            } catch (InterruptedException e) {
                // Logger
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stopRunning() {
        interrupt();
    }
}
