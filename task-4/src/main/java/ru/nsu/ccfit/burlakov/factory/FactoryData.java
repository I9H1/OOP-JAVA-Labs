package ru.nsu.ccfit.burlakov.factory;

import java.util.Properties;

public record FactoryData(int bodyStorageSize, int engineStorageSize, int accessoryStorageSize,
                          int carStorageSize, int suppliersAmount, int workersAmount, int dealersAmount,
                          int supplierWorkTime, int dealerWorkTime, boolean logging) {

    public static FactoryData parse(Properties properties) {
        FactoryData factoryData = null;
        try {
            factoryData = new FactoryData(Integer.parseInt(properties.getProperty("BodyStorageSize")),
                    Integer.parseInt(properties.getProperty("EngineStorageSize")),
                    Integer.parseInt(properties.getProperty("AccessoryStorageSize")),
                    Integer.parseInt(properties.getProperty("CarStorageSize")),
                    Integer.parseInt(properties.getProperty("SuppliersAmount")),
                    Integer.parseInt(properties.getProperty("WorkersAmount")),
                    Integer.parseInt(properties.getProperty("DealersAmount")),
                    Integer.parseInt(properties.getProperty("SupplierWorkTime")),
                    Integer.parseInt(properties.getProperty("DealerWorkTime")),
                    Boolean.parseBoolean(properties.getProperty("Logging")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return factoryData;
    }
}
