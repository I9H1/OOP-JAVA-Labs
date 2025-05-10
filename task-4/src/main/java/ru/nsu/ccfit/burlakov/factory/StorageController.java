package ru.nsu.ccfit.burlakov.factory;

import ru.nsu.ccfit.burlakov.factory.tasks.WorkerTask;
import ru.nsu.ccfit.burlakov.threadpool.ThreadPool;

public class StorageController implements Runnable {
    private final Storage<Car> storage;
    private final ThreadPool threadpool;
    private final CarFactory factory;

    public StorageController(CarFactory factory, Storage<Car> storage, ThreadPool threadpool) {
        this.factory = factory;
        this.storage = storage;
        this.threadpool = threadpool;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                synchronized (storage) {
                    while (storage.getItemsAmount() == storage.getCapacity()) {
                        storage.wait();
                    }
                    threadpool.addTask(new WorkerTask(factory));
                }
                Thread.sleep(10); // Пауза перед следующей проверкой
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
