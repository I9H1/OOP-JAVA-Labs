package ru.nsu.ccfit.burlakov.threadpool;

public class ThreadPoolTask {
    private TaskListener listener;
    private Task task;

    public ThreadPoolTask(Task t, TaskListener l) {
        listener = l;
        task = t;
    }
    void prepare() {
        listener.taskStarted(task);
    }
    void finish() {
        listener.taskFinished(task);
    }
    void interrupted() {
        listener.taskInterrupted(task);
    }
    void go() throws InterruptedException {
        task.performWork();
    }
    String getName() {
        return task.getName();
    }
}
