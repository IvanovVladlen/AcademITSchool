package ru.academits.ivanov.shapes.classes;

import ru.academits.ivanov.shapes.shape_interface.Shape;

public class Square implements Shape {
    private double x;

    public Square(double x) {
        this.x = x;
    }

    @Override
    public double getWidth() {
        return x;
    }

    @Override
    public double getHeight() {
        return x;
    }

    @Override
    public double getArea() {
        return x * x;
    }

    @Override
    public double getPerimeter() {
        return 4 * x;
    }

    @Override
    public String toString() {
        return "Квадрат со стороной a = " + x + ". Ширина = " + getWidth() + "; Высота = " + getHeight() +
                "; Площадь равна = " + getArea() + "; Периметр равен = " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Square s = (Square) o;
        return x == s.x;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(x);
    }
}