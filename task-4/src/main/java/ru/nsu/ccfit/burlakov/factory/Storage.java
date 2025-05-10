package ru.nsu.ccfit.burlakov.factory;

import java.util.ArrayDeque;


public class Storage<T> {
    private final ArrayDeque<T> storage;
    private final int size;
    private final String name;
    private final Object monitor = new Object();

    public Storage(int size, String name) {
        this.size = size;
        this.name = name;
        this.storage = new ArrayDeque<>(size);
    }

    public int getItemsAmount() {
        synchronized (monitor) {
            return storage.size();
        }
    }

    public int getCapacity() {
        return size;
    }

    public void put(T item) throws InterruptedException {
        synchronized (monitor) {
            while (storage.size() >= size) {
                monitor.wait();
            }
            storage.add(item);
            monitor.notifyAll();
        }
    }

    public T get() throws InterruptedException {
        synchronized (monitor) {
            while (storage.isEmpty()) {
                monitor.wait();
            }
            T item = storage.removeFirst();
            monitor.notifyAll();
            return item;
        }
    }

    public String getName() {
        return name;
    }
}
