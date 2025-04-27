package ru.nsu.ccfit.burlakov.factory;

import ru.nsu.ccfit.burlakov.factory.details.*;
import ru.nsu.ccfit.burlakov.factory.products.*;
import ru.nsu.ccfit.burlakov.threadpool.*;

import java.io.IOException;
import java.util.Properties;

public class CarFactory {
    private Properties properties;

    private final Storage<Engine> engineStorage;
    private final Storage<Body> bodyStorage;
    private final Storage<Accessory> accessoryStorage;
    private final Storage<Car> carStorage;

    ThreadPool workersThreadPool;
    ThreadPool dealersThreadPool;
    ThreadPool suppliersThreadPool;

    CarFactory() {
        try {
            properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            //logger
        }
        engineStorage = new Storage<>(Integer.parseInt(properties.getProperty("EngineStorageSize")), "EngineStorage");
        bodyStorage = new Storage<>(Integer.parseInt(properties.getProperty("BodyStorageSize")), "BodyStorage");
        accessoryStorage = new Storage<>(Integer.parseInt(properties.getProperty("AccessoryStorageSize")), "AccsStorage");
        carStorage = new Storage<>(Integer.parseInt(properties.getProperty("CarStorageSize")), "CarStorage");
        workersThreadPool = new ThreadPool(Integer.parseInt(properties.getProperty("WorkersAmount")));
        dealersThreadPool = new ThreadPool(Integer.parseInt(properties.getProperty("DealersAmount")));
        suppliersThreadPool = new ThreadPool(Integer.parseInt(properties.getProperty("SuppliersAmount")) + 2);
    }

}
