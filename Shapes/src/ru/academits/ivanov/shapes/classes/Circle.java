package ru.academits.ivanov.shapes.classes;

import ru.academits.ivanov.shapes.shape_interface.Shape;

public class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getWidth() {
        return 2 * r;
    }

    @Override
    public double getHeight() {
        return 2 * r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public String toString() {
        return "Окружность с радиусом " + r + ". Ширина = " + getWidth() + "; Высота = " + getHeight() +
                "; Площадь равна = " + getArea() + "; Периметр (длинна окружности) равен = " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Circle c = (Circle) o;
        return r == c.r;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(r);
    }
}