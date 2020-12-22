package ru.academits.ivanov.shapes_main;

import ru.academits.ivanov.shapes.Circle;
import ru.academits.ivanov.shapes.Rectangle;
import ru.academits.ivanov.shapes.Square;
import ru.academits.ivanov.shapes.Triangle;
import ru.academits.ivanov.shapes.Shape;

import java.util.Arrays;

public class Main {

    private static Shape getMaxAreaShape(Shape[] shapes) {
        if (shapes.length == 0) {
            return null;
        }

        if (shapes.length == 1) {
            return shapes[0];
        }

        Arrays.sort(shapes, new AreaComparator());

        return shapes[shapes.length - 1];
    }

    private static Shape getSecondPerimeterShape(Shape[] shapes) {
        if (shapes.length == 0 || shapes.length == 1) {
            return null;
        }

        Arrays.sort(shapes, new PerimeterComparator());

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(2),
                new Triangle(1, 1, 2, 2, 3, 1),
                new Rectangle(1, 2),
                new Square(5), new Square(10),
                new Circle(1),
                new Square(3),
                new Circle(1),
                new Square(8),
                new Triangle(8, 1, 2, 4, 3, 2),
                new Rectangle(4, 5),
                new Circle(15)
        };

        System.out.println("Фигура с максимальной площадью:");
        System.out.println(getMaxAreaShape(shapes));

        System.out.println("Фигура со вторым по величине периметром:");
        System.out.println(getSecondPerimeterShape(shapes));
    }
}