package ru.nsu.ccfit.burlakov;

import ru.nsu.ccfit.burlakov.factory.CarFactory;
import ru.nsu.ccfit.burlakov.factory.Interface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory;
        try {
            carFactory = new CarFactory();
        } catch (Exception e) {
            return;
        }
        Interface gui = new Interface(carFactory);
        carFactory.start();
        SwingUtilities.invokeLater(() -> {
            gui.activate();
            Runtime.getRuntime().addShutdownHook(new Thread(carFactory::stop));
        });
    }
}
