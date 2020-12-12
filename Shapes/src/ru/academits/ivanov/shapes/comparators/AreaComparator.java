package ru.academits.ivanov.shapes.comparators;

import ru.academits.ivanov.shapes.shapes.Shape;

import java.util.Comparator;

public class AreaComparator {
    public static Comparator<Shape> areaComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return Double.compare(o1.getArea(), o2.getArea());
        }
    };
}