package ru.nsu.ccfit.burlakov.threadpool;

public interface Task {
    String getName();
    void performWork() throws InterruptedException;
}
