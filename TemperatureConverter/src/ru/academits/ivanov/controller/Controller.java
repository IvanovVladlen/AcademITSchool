package ru.academits.ivanov.controller;

import ru.academits.ivanov.model.TemperatureConverter;
import ru.academits.ivanov.view.DesktopView;

public class Controller {
    private final TemperatureConverter temperatureConverter;
    private DesktopView view;

    public Controller(TemperatureConverter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    public void setView(DesktopView view) {
        this.view = view;
    }

    public void convert(Double temperature) {
        if (view.getFromType().equals(view.getToType())) {
            view.setResultTemperature(temperature);
        }

        if (view.getFromType().equals("Цельсий") && view.getToType().equals("Кельвин")) {
            double result = temperatureConverter.convertCelsiusToKelvin(temperature);
            view.setResultTemperature(result);
        }

        if (view.getFromType().equals("Цельсий") && view.getToType().equals("Фаренгейт")) {
            double result = temperatureConverter.convertCelsiusToFahrenheit(temperature);
            view.setResultTemperature(result);
        }

        if (view.getFromType().equals("Кельвин") && view.getToType().equals("Цельсий")) {
            double result = temperatureConverter.convertKelvinToCelsius(temperature);
            view.setResultTemperature(result);
        }

        if (view.getFromType().equals("Кельвин") && view.getToType().equals("Фаренгейт")) {
            double result = temperatureConverter.convertKelvinToFahrenheit(temperature);
            view.setResultTemperature(result);
        }

        if (view.getFromType().equals("Фаренгейт") && view.getToType().equals("Цельсий")) {
            double result = temperatureConverter.convertFahrenheitToCelsius(temperature);
            view.setResultTemperature(result);
        }

        if (view.getFromType().equals("Фаренгейт") && view.getToType().equals("Кельвин")) {
            double result = temperatureConverter.convertFahrenheitToKelvin(temperature);
            view.setResultTemperature(result);
        }
    }
}