package ru.nsu.ccfit.burlakov.factory;

import javax.swing.*;
import java.awt.*;

public class Interface {

    private final JLabel totalLabel = new JLabel();
    private final JLabel storedLabel = new JLabel();

    public void activate() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Color textColor = new Color(98, 34, 2);
        Color backgroundColor = new Color(249, 239, 176);
        Font font = new Font("Arial", Font.BOLD, 18);
        JLabel label1 = new JLabel("Скорость работы поставщика кузовов:");
        label1.setForeground(textColor);
        JLabel label2 = new JLabel("Скорость работы поставщика двигателей:");
        label2.setForeground(textColor);
        JLabel label3 = new JLabel("Скорость работы поставщика аксессуаров:");
        label3.setForeground(textColor);
        JLabel label4 = new JLabel("Скорость запроса новых машин:");
        label4.setForeground(textColor);

        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        label4.setFont(font);

        JSlider bodyCreationslider = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);
        JSlider engineCreationSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);
        JSlider accsCreeationSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);
        JSlider requestSpeedSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(backgroundColor);

        panel.add(label1);
        panel.add(bodyCreationslider);
        panel.add(label2);
        panel.add(engineCreationSlider);
        panel.add(label3);
        panel.add(accsCreeationSlider);
        panel.add(label4);
        panel.add(requestSpeedSlider);

        JLabel label5 = new JLabel("Произведено машин: ");
        label5.setForeground(textColor);
        label5.setFont(font);

        totalLabel.setFont(font);
        totalLabel.setForeground(textColor);
        totalLabel.setText("0");
        
        panel.add(label5);
        panel.add(totalLabel);

        JLabel label6 = new JLabel("Машин на складе: ");
        label6.setForeground(textColor);
        label6.setFont(font);

        storedLabel.setFont(font);
        storedLabel.setForeground(textColor);
        storedLabel.setText("0");

        panel.add(label6);
        panel.add(storedLabel);

        frame.add(panel);

        frame.setVisible(true);
    }

    public void update(int totalNum, int storedNum) {
        totalLabel.setText(String.valueOf(totalNum));
        storedLabel.setText(String.valueOf(storedNum));
    };
}
