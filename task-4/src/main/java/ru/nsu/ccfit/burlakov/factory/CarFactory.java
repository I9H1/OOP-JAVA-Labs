package ru.nsu.ccfit.burlakov.factory;

import ru.nsu.ccfit.burlakov.factory.details.*;
import ru.nsu.ccfit.burlakov.factory.tasks.Dealer;
import ru.nsu.ccfit.burlakov.factory.tasks.Supplier;
import ru.nsu.ccfit.burlakov.factory.utils.Validator;
import ru.nsu.ccfit.burlakov.threadpool.*;

import java.util.LinkedList;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarFactory {
    private final FactoryData data;

    private final Storage<Engine> engineStorage;
    private final Storage<Body> bodyStorage;
    private final Storage<Accessory> accessoryStorage;
    private final Storage<Car> carStorage;

    private final ThreadPool workersThreadPool;
    private final LinkedList<Dealer> dealers = new LinkedList<>();
    private final LinkedList<Supplier<Accessory>> accsSuppliers = new LinkedList<>();
    private  final LinkedList<Thread> threads = new LinkedList<>();
    private final Supplier<Engine> engineSupplier;
    private final Supplier<Body> bodySupplier;
    private final StorageController controller;

    private final Logger logger;

    private int totalCarsCreated = 0;

    public CarFactory() {
        logger = LoggerFactory.getLogger(CarFactory.class);
        try {
            Properties properties = new Properties();
            properties.load(CarFactory.class.getClassLoader().getResourceAsStream("config.properties"));
            data = FactoryData.parse(properties);
        } catch (Exception e) {
            logger.error("Error loading config.properties: " + e);
            throw new RuntimeException(e);
        }
        if (!Validator.validate(data)) {
            logger.error("Invalid config file: {}", Validator.getMessage());
            throw new IllegalArgumentException();
        }
        engineStorage = new Storage<>(data.engineStorageSize(), "EngineStorage");
        bodyStorage = new Storage<>(data.bodyStorageSize(), "BodyStorage");
        accessoryStorage = new Storage<>(data.accessoryStorageSize(), "AccessoryStorage");
        carStorage = new Storage<>(data.carStorageSize(), "CarStorage");
        workersThreadPool = new ThreadPool(data.workersAmount());
        engineSupplier = new Supplier<>(engineStorage, Engine.class, data.supplierWorkTime());
        bodySupplier = new Supplier<>(bodyStorage, Body.class, data.supplierWorkTime());
        controller = new StorageController(this, carStorage, workersThreadPool);
    }

    public void start() {
        logger.info("--- FABRIC STARTED WORKING ---");
        Thread controllerThread = new Thread(controller);
        threads.add(controllerThread);
        controllerThread.start();

        for (int i = 0; i < data.suppliersAmount(); ++i) {
            Supplier<Accessory> supplier = new Supplier<>(accessoryStorage, Accessory.class, data.supplierWorkTime());
            accsSuppliers.add(supplier);
            Thread thread = new Thread(supplier);
            threads.add(thread);
            thread.start();
        }

        for (int i = 0; i < data.dealersAmount(); ++i) {
            Dealer dealer = new Dealer(carStorage, data.dealerWorkTime(), data.logging());
            dealers.add(dealer);
            Thread thread = new Thread(dealer);
            threads.add(thread);
            thread.start();
        }
        Thread bodySupplierThread = new Thread(bodySupplier);
        threads.add(bodySupplierThread);
        bodySupplierThread.start();
        Thread engineSupplierThread = new Thread(engineSupplier);
        threads.add(engineSupplierThread);
        engineSupplierThread.start();
    }

    public void stop() {
        workersThreadPool.shutdown();
        for (Thread thread : threads) {
            thread.interrupt();
        }
        logger.info("--- FABRIC STOPPED WORKING ---");
    }

    public void incrementTotalCars() {
        ++totalCarsCreated;
    }

    public void updateEngineSupplier(int workTime) {
        engineSupplier.updateWorkTime(workTime);
    }

    public void updateBodySupplier(int workTime) {
        bodySupplier.updateWorkTime(workTime);
    }

    public void updateAccessorySuppliers(int workTime) {
        for (Supplier<Accessory> supplier : accsSuppliers) {
            supplier.updateWorkTime(workTime);
        }
    }

    public void updateDealers(int workTime) {
        for (Dealer dealer : dealers) {
            dealer.updateWorkTime(workTime);
        }
    }

    public Storage<Engine> getEngineStorage() {
        return engineStorage;
    }

    public Storage<Body> getBodyStorage() {
        return bodyStorage;
    }

    public Storage<Accessory> getAccessoryStorage() {
        return accessoryStorage;
    }

    public Storage<Car> getCarStorage() {
        return carStorage;
    }

    public int getTotalCarsCreated() {
        return totalCarsCreated;
    }
}
