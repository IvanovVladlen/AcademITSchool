package ru.academits.ivanov.array_list_home;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> getStringsFromFile(String filePath) {
        ArrayList<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        return strings;
    }

    private static void deleteEvenNumbers(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }

    private static ArrayList<Integer> getListWithoutRepetitions(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>(list.size());

        for (Integer e : list) {
            if (!newList.contains(e)) {
                newList.add(e);
            }
        }

        return newList;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\User\\IdeaProjects\\AcademITSchool5\\ArrayListHome\\src\\ru\\academits\\ivanov\\Strings.txt";
        ArrayList<String> strings = getStringsFromFile(filePath);
        System.out.println(strings);

        System.out.println("------------------------------------------------------------");

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(3, 5, 12, 48, 7, 11, 3));

        System.out.println("Список элементов: " + numbersList);

        deleteEvenNumbers(numbersList);
        System.out.println("Список без чётных элементов: " + numbersList);

        System.out.println("------------------------------------------------------------");

        ArrayList<Integer> numbersListWithRepeated = new ArrayList<>(Arrays.asList(1, 5, 2, 5, 2, 2, 3, 1, 3, 5));
        System.out.println("Список с повторяющимися элементами: " + numbersListWithRepeated);

        ArrayList<Integer> numbersListWithoutRepeated = getListWithoutRepetitions(numbersListWithRepeated);
        System.out.println("Список без повторяющихся элементов: " + numbersListWithoutRepeated);
    }
}