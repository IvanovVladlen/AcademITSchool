package ru.academits.ivanov.temperature_main;

import ru.academits.ivanov.controller.Controller;
import ru.academits.ivanov.model.TemperatureConverter;
import ru.academits.ivanov.view.DesktopView;

public class Main {
    public static void main(String[] args) {
        TemperatureConverter temperatureConverter = new TemperatureConverter();
        Controller controller = new Controller(temperatureConverter);

        DesktopView desktopView = new DesktopView(controller);
        controller.setView(desktopView);

        desktopView.init();
    }
}