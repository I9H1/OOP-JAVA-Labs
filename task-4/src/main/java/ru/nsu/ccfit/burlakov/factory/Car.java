package ru.nsu.ccfit.burlakov.factory;

import ru.nsu.ccfit.burlakov.factory.details.Accessory;
import ru.nsu.ccfit.burlakov.factory.details.Body;
import ru.nsu.ccfit.burlakov.factory.details.Engine;
import ru.nsu.ccfit.burlakov.factory.utils.IDGenerator;

public class Car {
    private Engine engine;
    private Body body;
    private Accessory accessory;
    private String ID;

    public Car(Engine engine, Body body, Accessory accessory) {
        this.engine = engine;
        this.body = body;
        this.accessory = accessory;
        this.ID = IDGenerator.getID();
    }

    public String getID() {
        return ID;
    }

    public String getEngineID() {
        return engine.getID();
    }

    public String getBodyID() {
        return body.getID();
    }

    public String getAccessoryID() {
        return accessory.getID();
    }
}
