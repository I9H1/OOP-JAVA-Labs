package ru.nsu.ccfit.burlakov.factory.tasks;

import ru.nsu.ccfit.burlakov.factory.Car;
import ru.nsu.ccfit.burlakov.factory.utils.IDGenerator;
import ru.nsu.ccfit.burlakov.factory.Storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dealer implements Runnable {
    private final String ID;
    private final Storage<Car> carStorage;
    private int workTime;
    private final boolean isLogging;
    private final Logger logger;

    public Dealer(Storage<Car> carStorage, int workTime, boolean isLogging) {
        this.carStorage = carStorage;
        this.workTime = workTime;
        this.isLogging = isLogging;
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.ID = IDGenerator.getID();
    }

    public String getName() {
        return "DealerTask_" + ID;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Car soldCar = carStorage.get();
                if (isLogging) {
                    logger.info("!!!SOLD CAR {}", String.format("Dealer: %s Car: %s (Body: %s; Engine: %s; Accessory: %s)!!!",
                            ID, soldCar.getID(), soldCar.getBodyID(), soldCar.getEngineID(), soldCar.getAccessoryID()));
                }
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void updateWorkTime(int workTime) {
        this.workTime = workTime;
    }
}
