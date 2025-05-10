package ru.nsu.ccfit.burlakov.factory.tasks;

import ru.nsu.ccfit.burlakov.factory.Car;
import ru.nsu.ccfit.burlakov.factory.CarFactory;
import ru.nsu.ccfit.burlakov.factory.utils.IDGenerator;
import ru.nsu.ccfit.burlakov.factory.details.Accessory;
import ru.nsu.ccfit.burlakov.factory.details.Body;
import ru.nsu.ccfit.burlakov.factory.details.Engine;
import ru.nsu.ccfit.burlakov.threadpool.Task;

public class WorkerTask implements Task {
    private final String ID;
    private final CarFactory factory;

    public WorkerTask(CarFactory factory) {
        this.factory = factory;
        this.ID = IDGenerator.getID();
    }

    @Override
    public String getName() {
        return "WorkerTask_" + ID;
    }

    @Override
    public void performWork() throws InterruptedException {
        Body body = factory.getBodyStorage().get();
        Engine engine = factory.getEngineStorage().get();
        Accessory accessory = factory.getAccessoryStorage().get();
        Car newCar = new Car(engine, body, accessory);
        factory.getCarStorage().put(newCar);
        factory.incrementTotalCars();
    }
}
