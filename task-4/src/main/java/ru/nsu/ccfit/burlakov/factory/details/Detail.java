package ru.nsu.ccfit.burlakov.factory.details;

import ru.nsu.ccfit.burlakov.factory.utils.IDGenerator;

public class Detail {
    private String ID;

    public Detail() {
        this.ID = IDGenerator.getID();
    }

    public String getID() {
        return ID;
    }
}
