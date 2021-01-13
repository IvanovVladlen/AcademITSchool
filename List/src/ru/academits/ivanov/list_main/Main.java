package ru.academits.ivanov.list_main;

import ru.academits.ivanov.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(50);

        list.add(5);
        list.add(1);
        list.add(8);
        list.addFirst(12);
        list.addByIndex(4, 1);
        list.addByIndex(1, 3);
        list.addFirst(6);
        list.add(1);
        list.add(8);
        list.add(25);
        list.add(8);
        list.add(11);

        System.out.println("Односвязный список: " + list);
        System.out.println("Размер списка: " + list.getSize());
        System.out.println();

        System.out.println("Удаление первого элемента");
        int deletedData1 = list.deleteFirst();
        System.out.println("Значение удаленного элемента: " + deletedData1);

        System.out.println("Итоговый список: " + list);
        System.out.println();

        System.out.println("Удаление элемента по индексу 2");
        int deletedData2 = list.deleteByIndex(2);
        System.out.println("Значение удаленного элемента: " + deletedData2);

        System.out.println("Итоговый список: " + list);
        System.out.println();

        System.out.println("Удаление элемента по значению 8");
        boolean checkDeleted = list.delete(8);
        System.out.println("Элемент был удален: " + checkDeleted);

        System.out.println("Итоговый список: " + list);
        System.out.println();

        System.out.println("Установка нового значения по индексу 2");
        int oldData = list.setData(2, 33);
        System.out.println("Старое значение элемента: " + oldData);

        System.out.println("Итоговый список: " + list);
        System.out.println();

        System.out.println("Получение значения первого элемента");
        int data = list.getFirst();
        System.out.println("Значение элемента: " + data);
        System.out.println();

        System.out.println("Разворот списка: " + list);
        list.reverse();
        System.out.println("Итоговый список: " + list);
        System.out.println();

        System.out.println("Копирование списка");
        SinglyLinkedList<Integer> copyList = list.copy();
        System.out.println("Скопированный список: " + copyList);
    }
}