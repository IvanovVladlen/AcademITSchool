package ru.academits.ivanov.view;

import ru.academits.ivanov.controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DesktopView implements View {
    private final Controller controller;

    private JLabel result;
    private JComboBox<String> fromType;
    private JComboBox<String> toType;

    public String getFromType() {
        return (String) fromType.getSelectedItem();
    }

    public String getToType() {
        return (String) toType.getSelectedItem();
    }

    public DesktopView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void init() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(320, 120);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new BorderLayout());
            frame.add(panel);

            JPanel inputPanel = new JPanel();
            inputPanel.getPreferredSize();
            JPanel functionalPanel = new JPanel();
            functionalPanel.getPreferredSize();
            JPanel outputPanel = new JPanel();
            outputPanel.getPreferredSize();

            JLabel inputLabel = new JLabel("Введите значение");
            JTextField inputField = new JTextField(6);
            inputPanel.add(inputLabel);
            inputPanel.add(inputField);

            String[] temperatureType = {"Цельсий", "Фаренгейт", "Кельвин"};
            JLabel fromLabel = new JLabel("из");
            fromType = new JComboBox<>(temperatureType);
            JLabel toLabel = new JLabel("в");
            toType = new JComboBox<>(temperatureType);
            JButton calculationButton = new JButton("Перевести");

            functionalPanel.add(fromLabel);
            functionalPanel.add(fromType);
            functionalPanel.add(toLabel);
            functionalPanel.add(toType);
            functionalPanel.add(calculationButton);

            JLabel outputLabel = new JLabel("Результат: ");
            result = new JLabel();
            outputPanel.add(outputLabel);
            outputPanel.add(result);

            panel.add(inputPanel, BorderLayout.NORTH);
            panel.add(functionalPanel, BorderLayout.CENTER);
            panel.add(outputPanel, BorderLayout.SOUTH);

            calculationButton.addActionListener(e -> {
                try {
                    double temperature = Double.parseDouble(inputField.getText());
                    controller.convert(temperature);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Температура должна быть числом");
                }
            });

            frame.setVisible(true);
            frame.requestFocus();
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        });
    }

    @Override
    public void setResultTemperature(double temperature) {
        result.setText(Double.toString(temperature));
    }
}