package ru.academits.ivanov.range_main;

import ru.academits.ivanov.range.Range;

public class Main {
    private static void testOperationsWithRanges(Range rangeA, Range rangeB) {
        Range intersection = rangeA.getIntersection(rangeB);

        if (intersection == null) {
            System.out.println("Интервалы не пересекаются");
        } else {
            System.out.println("Интервал пересечения двух интервалов: " + intersection);
        }

        Range[] union = rangeA.getUnion(rangeB);
        System.out.print("Интервал(ы) объединения двух интервалов: ");
        for (Range e : union) {
            System.out.print(e + " ");
        }
        System.out.println();

        Range[] difference = rangeA.getDifference(rangeB);

        if (difference.length < 1) {
            System.out.println("Интервал полностью вычтен.");
        } else {
            System.out.print("Интервал(ы) разности двух интервалов: ");
            for (Range e : difference) {
                System.out.print(e + " ");
            }
        }
    }

    public static void main(String[] args) {
        Range range = new Range(5, 16);
        System.out.println("Дан диапазон " + range + ": ");

        double rangeLength = range.getLength();
        System.out.println("Длина заданного диапазона равна: " + rangeLength);

        double number = 10.5;

        if (range.isInside(number)) {
            System.out.println("Число " + number + " входит в диапазон заданых чисел.");
        } else {
            System.out.println("Число " + number + " не входит в диапазон заданых чисел.");
        }

        System.out.println("----------------------------------------------------------");

        Range rangeA = new Range(4, 15);
        Range rangeB = new Range(10, 30);
        System.out.println("Проведем ряд математических операций для диапазонов: " + rangeA + " и " + rangeB + ".");

        System.out.println("Результат: ");
        testOperationsWithRanges(rangeA, rangeB);
    }
}