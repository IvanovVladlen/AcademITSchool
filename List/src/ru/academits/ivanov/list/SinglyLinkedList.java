package ru.academits.ivanov.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T data) {
        head = new ListItem<>(data);
        count = 1;
    }

    public int getSize() {
        return count;
    }

    public T getFirstData() {
        if (head == null) {
            throw new NoSuchElementException("Односвязный список пуст.");
        }

        return head.getData();
    }

    public ListItem<T> getItem(int index) {
        indexCheck(index);

        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        return currentItem;
    }

    public T setItem(int index, T data) {
        indexCheck(index);

        ListItem<T> item = getItem(index);
        T oldData = item.getData();

        item.setData(data);

        return oldData;
    }

    public T deleteOnIndex(int index) {
        indexCheck(index);

        if (index == 0) {
            return deleteFirst();
        }

        ListItem<T> previousItem = getItem(index - 1);
        ListItem<T> currentItem = getItem(index);

        previousItem.setNext(currentItem.getNext());

        count--;

        return currentItem.getData();
    }

    public void addAtFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void addByIndex(T data, int index) {
        if (index != count) {
            indexCheck(index);
        }

        if (index == 0) {
            addAtFirst(data);

            return;
        }

        ListItem<T> previousItem = getItem(index - 1);
        ListItem<T> currentItem = previousItem.getNext();

        ListItem<T> item = new ListItem<>(data, currentItem);
        previousItem.setNext(item);

        count++;
    }

    public void add(T data) {
        addByIndex(data, count);
    }

    public boolean delete(T data) {
        if (head == null) {
            throw new NoSuchElementException("Односвязный список пуст.");
        }

        boolean check = false;

        for (int i = 0; i < count; i++) {
            if (data.equals(getItem(i).getData())) {
                deleteOnIndex(i);
                check = true;
            }
        }

        return check;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("Односвязный список пуст.");
        }

        T deleteData = head.getData();
        head = head.getNext();

        count--;

        return deleteData;
    }

    public void reverse() {
        if (head == null) {
            throw new NoSuchElementException("Односвязный список пуст.");
        }

        if (head.getNext() == null) {
            return;
        }

        ListItem<T> previous = head.getNext();
        ListItem<T> current = previous.getNext();
        ListItem<T> next;

        head.setNext(null);
        previous.setNext(head);

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);

            if (next == null) {
                head = current;
            }

            previous = current;
            current = next;
        }
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();

        if (head == null) {
            return copy;
        }

        copy.head = new ListItem<>(head.getData());
        copy.count = count;

        ListItem<T> previousItem = copy.head;

        ListItem<T> currentItem = head.getNext();

        for (int i = 1; i < count; i++) {
            ListItem<T> copyItem = new ListItem<>(currentItem.getData());

            previousItem.setNext(copyItem);
            previousItem = copyItem;

            currentItem = currentItem.getNext();
        }

        return copy;
    }

    private void indexCheck(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Индекс " + index + " за пределами допустимого значения (от 0, до " + (count - 1) + ")");
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        ListItem<T> item = head;

        for (int i = 0; i < count; i++) {
            stringBuilder.append(item.getData());
            item = item.getNext();

            if (i != count - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}