package ru.nsu.ccfit.burlakov.factory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Interface {
    private final CarFactory factory;
    private final JLabel totalLabel = new JLabel("0");
    private final JLabel storedLabel = new JLabel("0");
    private final JLabel bodyStorageLabel = new JLabel("0");
    private final JLabel engineStorageLabel = new JLabel("0");
    private final JLabel accessoryStorageLabel = new JLabel("0");
    private JSlider bodyCreationSlider;
    private JSlider engineCreationSlider;
    private JSlider accessoryCreationSlider;
    private JSlider requestSpeedSlider;

    private final int MIN = 50;
    private final int MAX = 1500;

    public Interface(CarFactory factory) {
        this.factory = factory;
        Timer updateTimer = new Timer(100, e -> update(factory.getTotalCarsCreated())); // Обновление каждые 100 мс
        updateTimer.start();
    }

    public void activate() {
        JFrame frame = new JFrame("Car Factory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        bodyCreationSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, (MAX + MIN) / 2);
        engineCreationSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, (MAX + MIN) / 2);
        accessoryCreationSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, (MAX + MIN) / 2);
        requestSpeedSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, (MAX + MIN) / 2);

        bodyCreationSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                factory.updateBodySupplier((MAX + MIN) - bodyCreationSlider.getValue());
            }
        });

        engineCreationSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                factory.updateEngineSupplier((MAX + MIN) - engineCreationSlider.getValue());
            }
        });

        accessoryCreationSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                factory.updateAccessorySuppliers((MAX + MIN) - accessoryCreationSlider.getValue());
            }
        });

        requestSpeedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                factory.updateDealers((MAX + MIN) - requestSpeedSlider.getValue());
            }
        });

        Color textColor = new Color(98, 34, 2);
        Color backgroundColor = new Color(249, 239, 176);
        Font font = new Font("Arial", Font.BOLD, 16);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1, 5, 5, 5);

        // Панель для слайдеров
        JPanel slidersPanel = new JPanel(new GridBagLayout());
        slidersPanel.setBackground(backgroundColor);
        slidersPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(textColor), "Speed Controls",
                TitledBorder.LEFT, TitledBorder.TOP, font, textColor));

        JLabel label1 = new JLabel("Body Supplier Speed:");
        label1.setForeground(textColor);
        label1.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        slidersPanel.add(label1, gbc);

        bodyCreationSlider.setBackground(backgroundColor);
        gbc.gridy = 1;
        slidersPanel.add(bodyCreationSlider, gbc);

        JLabel label2 = new JLabel("Engine Supplier Speed:");
        label2.setForeground(textColor);
        label2.setFont(font);
        gbc.gridy = 2;
        slidersPanel.add(label2, gbc);

        engineCreationSlider.setBackground(backgroundColor);
        gbc.gridy = 3;
        slidersPanel.add(engineCreationSlider, gbc);

        JLabel label3 = new JLabel("Accessory Supplier Speed:");
        label3.setForeground(textColor);
        label3.setFont(font);
        gbc.gridy = 4;
        slidersPanel.add(label3, gbc);

        accessoryCreationSlider.setBackground(backgroundColor);
        gbc.gridy = 5;
        slidersPanel.add(accessoryCreationSlider, gbc);

        JLabel label4 = new JLabel("Dealer Request Speed:");
        label4.setForeground(textColor);
        label4.setFont(font);
        gbc.gridy = 6;
        slidersPanel.add(label4, gbc);

        requestSpeedSlider.setBackground(backgroundColor);
        gbc.gridy = 7;
        slidersPanel.add(requestSpeedSlider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.7;
        mainPanel.add(slidersPanel, gbc);

        // Панель для статистики
        JPanel statsPanel = new JPanel(new GridBagLayout());
        statsPanel.setBackground(backgroundColor);
        statsPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(textColor), "Factory Statistics",
                TitledBorder.LEFT, TitledBorder.TOP, font, textColor));

        JLabel label5 = new JLabel("Total Cars Produced:");
        label5.setForeground(textColor);
        label5.setFont(font);
        gbc.gridy = 0;
        statsPanel.add(label5, gbc);

        totalLabel.setFont(font);
        totalLabel.setForeground(textColor);
        gbc.gridy = 1;
        statsPanel.add(totalLabel, gbc);

        JLabel label6 = new JLabel("Cars in Storage:");
        label6.setForeground(textColor);
        label6.setFont(font);
        gbc.gridy = 2;
        statsPanel.add(label6, gbc);

        storedLabel.setFont(font);
        storedLabel.setForeground(textColor);
        gbc.gridy = 3;
        statsPanel.add(storedLabel, gbc);

        JLabel label7 = new JLabel("Bodies in Storage:");
        label7.setForeground(textColor);
        label7.setFont(font);
        gbc.gridy = 4;
        statsPanel.add(label7, gbc);

        bodyStorageLabel.setFont(font);
        bodyStorageLabel.setForeground(textColor);
        gbc.gridy = 5;
        statsPanel.add(bodyStorageLabel, gbc);

        JLabel label8 = new JLabel("Engines in Storage:");
        label8.setForeground(textColor);
        label8.setFont(font);
        gbc.gridy = 6;
        statsPanel.add(label8, gbc);

        engineStorageLabel.setFont(font);
        engineStorageLabel.setForeground(textColor);
        gbc.gridy = 7;
        statsPanel.add(engineStorageLabel, gbc);

        JLabel label9 = new JLabel("Accessories in Storage:");
        label9.setForeground(textColor);
        label9.setFont(font);
        gbc.gridy = 8;
        statsPanel.add(label9, gbc);

        accessoryStorageLabel.setFont(font);
        accessoryStorageLabel.setForeground(textColor);
        gbc.gridy = 9;
        statsPanel.add(accessoryStorageLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.3;
        mainPanel.add(statsPanel, gbc);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void update(int totalNum) {
        SwingUtilities.invokeLater(() -> {
            totalLabel.setText(String.valueOf(totalNum));
            storedLabel.setText(String.valueOf(factory.getCarStorage().getItemsAmount()));
            bodyStorageLabel.setText(String.valueOf(factory.getBodyStorage().getItemsAmount()));
            engineStorageLabel.setText(String.valueOf(factory.getEngineStorage().getItemsAmount()));
            accessoryStorageLabel.setText(String.valueOf(factory.getAccessoryStorage().getItemsAmount()));
        });
    }
}