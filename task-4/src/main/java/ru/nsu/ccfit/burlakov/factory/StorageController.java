package ru.nsu.ccfit.burlakov.factory;

import ru.nsu.ccfit.burlakov.factory.tasks.WorkerTask;
import ru.nsu.ccfit.burlakov.threadpool.ThreadPool;

public class StorageController implements Listener {
    private final ThreadPool threadpool;
    private final CarFactory factory;

    public StorageController(CarFactory factory, ThreadPool threadpool, int initialTasks) {
        this.factory = factory;
        this.threadpool = threadpool;
        for (int i = 0; i < initialTasks; ++i) {
            threadpool.addTask(new WorkerTask(factory));
        }
    }

    @Override
    public void update() {
        threadpool.addTask(new WorkerTask(factory));
    }
}
