package ru.nsu.ccfit.burlakov.factory;

import java.util.ArrayDeque;

public class Storage<T> {
    private ArrayDeque<T> storage;
    private final int size;
    private final String name;

    public Storage(int size, String name) {
        this.size = size;
        this.name = name;
        this.storage = new ArrayDeque<>(size);
    }

    public int getItemsAmount() {
        return storage.size();
    }

    public synchronized void put(T item) throws InterruptedException {
        if (getItemsAmount() >= size) {
            wait();
        }
        storage.add(item);
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        if (getItemsAmount() <= 0) {
            wait();
        }
        T item = storage.removeFirst();
        notifyAll();
        return item;
    }

}
