package ru.nsu.ccfit.burlakov.factory.utils;

import ru.nsu.ccfit.burlakov.factory.FactoryData;

public class Validator {
    private static String message = "valid";

    static public boolean validate(FactoryData data) {
        boolean isValid = true;
        if (data.dealersAmount() <= 0) {
            isValid = false;
            message = "dealersAmount must be greater than 0";
        } else if (data.suppliersAmount() <= 0) {
            isValid = false;
            message = "suppliersAmount must be greater than 0";
        } else if (data.workersAmount() <= 0) {
            isValid = false;
            message = "workerAmount must be greater than 0";
        } else if (data.bodyStorageSize() <= 0) {
            isValid = false;
            message = "bodyStorageSize must be greater than 0";
        } else if (data.engineStorageSize() <= 0) {
            isValid = false;
            message = "engineStorageSize must be greater than 0";
        } else if (data.accessoryStorageSize() <= 0) {
            isValid = false;
            message = "accessoryStorageSize must be greater than 0";
        } else if (data.carStorageSize() <= 0) {
            isValid = false;
            message = "carStorageSize must be greater than 0";
        } else if (data.supplierWorkTime() < 50 || data.supplierWorkTime() > 1450) {
            isValid = false;
            message = "supplierWorkTime must be between 50 and 1450";
        } else if (data.dealerWorkTime() < 50 || data.dealerWorkTime() > 1450) {
            isValid = false;
            message = "dealerWorkTime must be between 50 and 1450";
        }
        return isValid;
    }

    static public String getMessage() {
        return message;
    }
}
