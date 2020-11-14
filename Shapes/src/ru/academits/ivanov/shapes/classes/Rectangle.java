package ru.academits.ivanov.shapes.classes;

import ru.academits.ivanov.shapes.shape_interface.Shape;

public class Rectangle implements Shape {
    private double x;
    private double y;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getWidth() {
        return x;
    }

    @Override
    public double getHeight() {
        return y;
    }

    @Override
    public double getArea() {
        return x * y;
    }

    @Override
    public double getPerimeter() {
        return 2 * (x + y);
    }

    @Override
    public String toString() {
        return "Прямоугольника со сторонами a = " + x + " и b = " + y + ". Ширина = " + getWidth() +
                "; Высота = " + getHeight() + "; Площадь равна = " + getArea() +
                "; Периметр равен = " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Rectangle r = (Rectangle) o;
        return x == r.x && y == r.y;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x);
        hash = prime * hash + Double.hashCode(y);
        return hash;
    }
}