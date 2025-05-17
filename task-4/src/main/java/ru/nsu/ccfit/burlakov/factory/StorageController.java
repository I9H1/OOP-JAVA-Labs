package ru.nsu.ccfit.burlakov.factory;

import ru.nsu.ccfit.burlakov.factory.tasks.WorkerTask;
import ru.nsu.ccfit.burlakov.threadpool.ThreadPool;

public class StorageController implements Listener {
    private final Storage<Car> storage;
    private final ThreadPool threadpool;
    private final CarFactory factory;

    public StorageController(CarFactory factory, Storage<Car> storage, ThreadPool threadpool) {
        this.factory = factory;
        this.storage = storage;
        this.threadpool = threadpool;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                synchronized (storage) {
                    while (storage.getItemsAmount() == storage.getCapacity()) {
                        System.out.println("Storage is full");
                        storage.wait();
                    }
                    threadpool.addTask(new WorkerTask(factory));
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    public void update() {

    }
}
