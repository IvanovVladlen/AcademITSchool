package ru.academits.ivanov.rangeModified;

public class Main {
    public static void main(String[] args) {

        Range rangeA = new Range(5, 16);
        Range rangeB = new Range(10, 30);

        Range rangeC = rangeA.getRangeCrossing(rangeB);
        System.out.println("Интервал пересечения двух интервалов: " + rangeC.toString());

        Range[] rangeD = rangeA.getRangeMerging(rangeB);
        System.out.print("Интервал(ы) объединения двух интервалов: ");
        for (Range e : rangeD) {
            System.out.print(e.toString() + " ");
        }

        Range[] rangeI = rangeA.getRangeDifference(rangeB);
        System.out.print(System.lineSeparator() + "Интервал(ы) разности двух интервалов: ");
        for (Range e : rangeI) {
            System.out.print(e.toString() + " ");
        }
    }
}