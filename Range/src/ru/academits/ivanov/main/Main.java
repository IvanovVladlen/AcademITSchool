package ru.academits.ivanov.main;

import ru.academits.ivanov.range.Range;

public class Main {
    private static void getOperationsWithRangesResults(Range rangeA, Range rangeB) {
        Range intersectionRanges = rangeA.getIntersection(rangeB);

        if(intersectionRanges == null){
            System.out.println("Интервалы не пересекаются");
        }
        System.out.println("Интервал пересечения двух интервалов: " + intersectionRanges);

        Range[] unionRanges = rangeA.getUnion(rangeB);
        System.out.print("Интервал(ы) объединения двух интервалов: ");
        for (Range e : unionRanges) {
            System.out.print(e + " ");
        }
        System.out.println();

        Range[] differenceRanges = rangeA.getDifference(rangeB);

        if (differenceRanges.length < 1) {
            System.out.println("Интервал полностью вычтен.");
        } else {
            System.out.print("Интервал(ы) разности двух интервалов: ");
            for (Range e : differenceRanges) {
                System.out.print(e + " ");
            }
        }
    }

    public static void main(String[] args) {
        Range range = new Range(5, 16);
        System.out.println("Дан диапазон " + range + ": ");

        double rangeLength = range.getLength();
        System.out.println("Длина заданного диапазона равна: " + rangeLength);

        double checkNumber = 10.5;
        boolean isInsideCheckNumber = range.isInside(checkNumber);

        if (isInsideCheckNumber) {
            System.out.println("Число " + checkNumber + " входит в диапазон заданых чисел.");
        } else {
            System.out.println("Число " + checkNumber + " не входит в диапазон заданых чисел.");
        }

        System.out.println("----------------------------------------------------------");

        Range rangeA = new Range(4, 15);
        Range rangeB = new Range(10, 30);
        System.out.println("Проведем ряд математических операций для диапазонов: " + rangeA + " и " + rangeB + ".");

        System.out.println("Результат:");
        getOperationsWithRangesResults(rangeA, rangeB);
    }
}