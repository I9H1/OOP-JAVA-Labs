package ru.nsu.ccfit.burlakov.factory.utils;

import java.util.UUID;

public class IDGenerator {
    public static String getID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
