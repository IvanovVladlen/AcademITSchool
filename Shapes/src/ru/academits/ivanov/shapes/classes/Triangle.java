package ru.academits.ivanov.shapes.classes;

import ru.academits.ivanov.shapes.shape_interface.Shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;

    private double x2;
    private double y2;

    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return getMaxMin(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return getMaxMin(y1, y2, y3);
    }

    private double getMaxMin(double n1, double n2, double n3) {
        double max = Math.max(n1, n2);
        double resultMax = Math.max(max, n3);

        double min = Math.min(n1, n2);
        double resultMin = Math.min(min, n3);

        return resultMax - resultMin;
    }

    private double getSideLength(double n1, double n2, double w1, double w2) {
        return Math.sqrt((w2 - w1) * (w2 - w1) + (n2 - n1) * (n2 - n1));
    }

    @Override
    public double getArea() {
        return Math.sqrt((getPerimeter() / 2) * ((getPerimeter() / 2) - getSideLength(x1, x2, y1, y2)) *
                ((getPerimeter() / 2) - getSideLength(x2, x3, y2, y3)) *
                ((getPerimeter() / 2) - getSideLength(x3, x1, y3, y1)));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, x2, y1, y2) + getSideLength(x2, x3, y2, y3) + getSideLength(x3, x1, y3, y1);
    }

    @Override
    public String toString() {
        return "Треугольник ABC " + "A : [" + x1 + " ; " + y1 + "], B : [" + x2 + " ; " + y2 + "], " +
                "C : [" + x3 + " ; " + y3 + "], Имеет следующие характеристики: Ширина = " + getWidth() +
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

        Triangle t = (Triangle) o;
        return x1 == t.x1 && x2 == t.x2 && x3 == t.x3 && y1 == t.y1 && y2 == t.y2 && y3 == t.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }
}