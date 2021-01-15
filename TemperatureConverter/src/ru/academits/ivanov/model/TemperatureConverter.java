package ru.academits.ivanov.model;

public class TemperatureConverter {
    public double convertCelsiusToKelvin(Double temperature) {
        return temperature + 273.15;
    }

    public double convertCelsiusToFahrenheit(Double temperature) {
        return 1.8 * temperature + 32;
    }

    public double convertKelvinToCelsius(Double temperature) {
        return temperature - 273.15;
    }

    public double convertKelvinToFahrenheit(Double temperature) {
        return 1.8 * temperature - 459.67;
    }

    public double convertFahrenheitToCelsius(Double temperature) {
        return (temperature - 32) / 1.8;
    }

    public double convertFahrenheitToKelvin(Double temperature) {
        return (temperature + 459.67) / 1.8;
    }
}