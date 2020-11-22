package ru.academits.ivanov.list_main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> readLine(String url) {
        ArrayList<String> strings = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader(url))) {
            while (s.hasNext()) {
                strings.add(s.nextLine());
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
        ArrayList<Integer> newList = new ArrayList<>();

        for (Integer i : list) {
            if (!newList.contains(i)) {
                newList.add(i);
            }
        }

        return newList;
    }

    public static void main(String[] args) {
        String url = "C:\\Users\\User\\IdeaProjects\\AcademITSchool5\\ArrayListHome\\src\\ru\\academits\\ivanov\\Strings.txt";
        ArrayList<String> strings = readLine(url);
        System.out.println(strings);

        System.out.println("------------------------------------------------------------");

        ArrayList<Integer> numbers1 = new ArrayList<>();
        numbers1.add(3);
        numbers1.add(5);
        numbers1.add(12);
        numbers1.add(48);
        numbers1.add(7);
        numbers1.add(11);

        System.out.println(numbers1);

        deleteEvenNumbers(numbers1);
        System.out.println(numbers1);

        System.out.println("------------------------------------------------------------");

        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 5, 2, 5, 2, 2, 3, 1, 3, 5));
        System.out.println(numbers2);

        ArrayList<Integer> numbers3 = getListWithoutRepetitions(numbers2);
        System.out.println(numbers3);
    }
}