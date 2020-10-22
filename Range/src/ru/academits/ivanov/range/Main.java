package ru.academits.ivanov.range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало диапазона чисел: ");
        double rangeFrom = scanner.nextDouble();

        System.out.println("Введите конец диапазона чисел: ");
        double rangeTo = scanner.nextDouble();

        Range range = new Range(rangeFrom, rangeTo);

        double rangeLength = range.getLength();
        System.out.println("Длина заданного диапазона равна: " + rangeLength);

        System.out.println("Введите число для проверки на принадлежность к диапазону чисел: ");
        double checkNumber = scanner.nextDouble();

        boolean isInsideCheckNumber = range.isInside(checkNumber);

        if (isInsideCheckNumber) {
            System.out.println("Число " + checkNumber + " входит в диапазон заданых чисел");
        } else {
            System.out.println("Число " + checkNumber + " не входит в диапазон заданых чисел");
        }
    }
}