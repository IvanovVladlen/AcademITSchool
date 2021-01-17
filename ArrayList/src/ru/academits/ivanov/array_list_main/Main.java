package ru.academits.ivanov.array_list_main;

import ru.academits.ivanov.array_list.ArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // тест конструкторов MyArrayList
        System.out.println("Создание коллекции с помощью конструктора без аргументов, и добавление экземпляров коллекции с помощью метода add.");
        System.out.println("Можно передать конструктору всестимость коллекции, по умолчанию вместимость равна 10");

        ArrayList<Integer> numbers1 = new ArrayList<>();
        numbers1.add(5);
        numbers1.add(1, 4);

        System.out.println(numbers1);
        System.out.println();

        System.out.println("Создание коллекции с помощью конструктора принимающего массив");
        Integer[] array1 = {6, 8, 12, 5, 14, 66, 6};
        ArrayList<Integer> numbers2 = new ArrayList<>(array1);
        System.out.println(numbers2);
        System.out.println();

        System.out.println("Создание коллекции с помощью конструктора принимающего вместимость и массив");

        Integer[] array2 = {10, 0, 4, 6};
        ArrayList<Integer> numbers3 = new ArrayList<>(100, array2);
        System.out.println(numbers3);
        System.out.println();

        System.out.println("Создание коллекции с помощью конструктора принимающего коллекцию + добавление в полученную коллекцию другой коллекции");

        ArrayList<Integer> numbers4 = new ArrayList<>(numbers3);
        numbers4.addAll(numbers2);

        System.out.println(numbers4);
        System.out.println();

        // тест методов MyArrayList
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Егор", "Кирилл", "Ирина", "Анатолий", "Арсений"));
        System.out.println("Коллекция имен: " + names);
        System.out.println();

        System.out.println("Методы size и isEmpty:");
        boolean isEmptyCollection = names.isEmpty();
        System.out.println("Пуста ли коллекция: " + isEmptyCollection);
        System.out.println();

        int namesCount = names.size();
        System.out.println("Колличество (размер коллекции) имён в коллекции: " + namesCount);
        System.out.println();

        System.out.println("Метод contains:");
        System.out.println("Коллекция names содержит имя \"Егор\": " + names.contains("Егор"));
        System.out.println("Коллекция names содержит имя \"Матвей\": " + names.contains("Матвей"));
        System.out.println();

        System.out.println("Метод iterator:");
        System.out.println("Вывод элементов коллекции names с помощью итератора:");

        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
        System.out.println("Метод toArray():");

        Object[] namesArray = names.toArray();
        System.out.println(Arrays.toString(namesArray));
        System.out.println();

        System.out.println("Метод toArray(T1[] array):");

        String[] array = new String[]{"Иван", "Арем", "Кирилл", "Арем", "Кирилл", "Арем", "Кирилл", "Арем", "Кирилл", "Арем", "Кирилл"};

        String[] namesArray2 = names.toArray(array);
        System.out.println(Arrays.toString(namesArray2));
        System.out.println();

        System.out.println("Метод add():");

        names.add("Иван");
        names.add("Владимир");

        System.out.println("После добавления элементов коллекция имен: " + names);
        System.out.println();

        System.out.println("Метод remove(Object o):");

        names.remove("Анатолий");
        names.remove("Ирина");

        System.out.println("После удаления элементов:");
        System.out.println("Коллекция имен: " + names);
        System.out.println();


        System.out.println("Метод containsAll()");

        ArrayList<String> names2 = new ArrayList<>(Arrays.asList("Иван", "Владимир"));
        ArrayList<String> names3 = new ArrayList<>(Arrays.asList("Вадим", "Анна"));

        System.out.println("Коллекция имен names2 = " + names2);
        System.out.println("Коллекция имен names3 = " + names3);
        System.out.println();

        System.out.println("Коллекция имен names содержит все элементы списка names2: " + names.containsAll(names2));
        System.out.println("Коллекция имен names содержит все элементы списка names3: " + names.containsAll(names3));
        System.out.println();

        System.out.println("Метод addAll(int index, Collection<? extends T> c)");

        ArrayList<String> names4 = new ArrayList<>(Arrays.asList("Иван", "Владимир", "Александр", "Анна"));
        ArrayList<String> names5 = new ArrayList<>(Arrays.asList("Вадим", "Анна"));

        System.out.println("Коллекция имен names4 = " + names4);
        System.out.println("Коллекция имен names5 = " + names5);

        names4.addAll(3, names5);

        System.out.println("После добавления к списку names4 списка names5 по индексу 3");
        System.out.println("Коллекция имен names4 = " + names4);
        System.out.println();

        System.out.println("Метод removeAll(Collection<?> c)");

        names4.removeAll(names5);

        System.out.println("После удаления из списка names4 элементов списка names5");
        System.out.println("Коллекция имен names4: " + names4);
        System.out.println();

        System.out.println("Метод retainAll(Collection<?> c)");

        Integer[] integers1 = {6, 8, 12, 5, 5, 88, 160, 15, 14, 66, 6};
        List<Integer> list1 = new ArrayList<>(integers1);
        System.out.println(list1);

        Integer[] integers2 = {6, 8, 12, 5, 88};
        List<Integer> list2 = new ArrayList<>(integers2);
        System.out.println(list2);

        list1.retainAll(list2);

        System.out.println("После list1.retainAll(list2) в list1 останется:");
        System.out.println("Коллекция list1" + list1);
        System.out.println();

        System.out.println("Метод clear()");

        list1.clear();
        System.out.println("Коллекция list1 после clear():" + list1);
        System.out.println();

        System.out.println("Методы T get(int index) и T set(int index, T element)");

        System.out.println("Коллекция list2" + list2);

        int item5 = list2.get(1);
        System.out.println("Элемент под 1 индексом из коллекции list2: " + item5);
        System.out.println();

        System.out.println("Установка значение \"28\" по индексу 2 в list2:");
        list2.set(2, 28);
        System.out.println();

        System.out.println("Метод remove(int index)");

        Integer[] integers3 = {6, 8, 12, 5, 5, 88, 160, 15, 14, 66, 6};
        List<Integer> list3 = new ArrayList<>(integers3);
        System.out.println("Коллекция list3: " + list3);

        int removedData = list3.remove(1);

        System.out.println("Элемент под индексом 1: " + removedData);
        System.out.println("Коллекция list3 после удаления элемента под индексом 1: " + list3);
        System.out.println();

        System.out.println("Методы indexOf(Object o), lastIndexOf(Object o)");

        System.out.println("Коллекция list3 = " + list3);

        System.out.println("Индекс первого вхождения элемента 5 в список list3: " + list3.indexOf(5));
        System.out.println("Индекс последнего вхождения элемента 5 в список list3: " + list3.lastIndexOf(5));
        System.out.println("Индекс первого вхождения элемента 4 в список list3: " + list3.indexOf(4));
    }
}