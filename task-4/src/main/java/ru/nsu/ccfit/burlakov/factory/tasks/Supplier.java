package ru.nsu.ccfit.burlakov.factory.tasks;

import ru.nsu.ccfit.burlakov.factory.utils.IDGenerator;
import ru.nsu.ccfit.burlakov.factory.Storage;

public class Supplier<T> implements Runnable {
    private final String ID;
    private final Storage<T> storage;
    private final Class<T> detailClass;
    private int workTime;

    public Supplier(Storage<T> storage, Class<T> detailClass, int workTime) {
        this.storage = storage;
        this.detailClass = detailClass;
        this.workTime = workTime;
        this.ID = IDGenerator.getID();
    }

    public String getName() {
        return "SupplierTask_" + ID;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                T item = createDetailObj();
                storage.put(item);
                Thread.sleep(workTime);
            } catch (InterruptedException | RuntimeException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void updateWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public T createDetailObj() throws InterruptedException {
        try {
            return detailClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Couldn't create detail: " + e.getMessage());
        }
    }
}
