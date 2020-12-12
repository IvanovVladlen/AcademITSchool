package ru.academits.ivanov.shapes.comparators;

import ru.academits.ivanov.shapes.shapes.Shape;

import java.util.Comparator;

public class PerimeterComparator {
    public static Comparator<Shape> perimeterComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return Double.compare(o1.getPerimeter(), o2.getPerimeter());
        }
    };
}