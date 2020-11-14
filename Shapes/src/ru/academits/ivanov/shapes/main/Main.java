package ru.academits.ivanov.shapes.main;

import ru.academits.ivanov.shapes.classes.Circle;
import ru.academits.ivanov.shapes.classes.Rectangle;
import ru.academits.ivanov.shapes.classes.Square;
import ru.academits.ivanov.shapes.classes.Triangle;
import ru.academits.ivanov.shapes.shape_interface.Shape;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static Comparator<Shape> areaComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return Double.compare(o1.getArea(), o2.getArea());
        }
    };

    private static Comparator<Shape> perimeterComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return Double.compare(o1.getPerimeter(), o2.getPerimeter());
        }
    };

    private static Shape getMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, areaComparator);

        return shapes[shapes.length - 1];
    }

    private static Shape getSecondPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, perimeterComparator);

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{new Square(2), new Triangle(1, 1, 2, 2, 3, 1), new Rectangle(1, 2),
                new Square(5), new Square(10), new Circle(1), new Square(3), new Circle(1), new Square(8),
                new Triangle(8, 1, 2, 4, 3, 2), new Rectangle(4, 5), new Circle(15),};

        System.out.println("Фигура с максимальной площадью:");
        System.out.println(getMaxArea(shapes));

        System.out.println("Фигура со вторым по величине периметром:");
        System.out.println(getSecondPerimeter(shapes));
    }
}