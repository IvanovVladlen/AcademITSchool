package ru.academits.ivanov.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T data) {
        head = new ListItem<>(data);
        size = 1;
    }

    public int getSize() {
        return size;
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Односвязный список пуст.");
        }

        return head.getData();
    }

    private ListItem<T> getItem(int index) {
        checkIndex(index);

        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        return currentItem;
    }

    public T getData(int index) {
        checkIndex(index);

        return getItem(index).getData();
    }

    public T setData(int index, T data) {
        checkIndex(index);

        ListItem<T> item = getItem(index);
        T oldData = item.getData();

        item.setData(data);

        return oldData;
    }

    public T deleteByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return deleteFirst();
        }

        ListItem<T> item = getItem(index - 1);
        T deleteData = item.getNext().getData();
        item.setNext(item.getNext().getNext());

        size--;

        return deleteData;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        size++;
    }

    public void addByIndex(int index, T data) {
        if (index != size) {
            checkIndex(index);
        }

        if (index == 0) {
            addFirst(data);

            return;
        }

        ListItem<T> previousItem = getItem(index - 1);
        ListItem<T> currentItem = previousItem.getNext();

        previousItem.setNext(new ListItem<>(data, currentItem));

        size++;
    }

    public void add(T data) {
        addByIndex(size, data);
    }

    public boolean delete(T data) {
        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (data.equals(getItem(i).getData())) {
                deleteByIndex(i);

                return true;
            }
        }

        return false;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("Односвязный список пуст.");
        }

        T deletedData = head.getData();
        head = head.getNext();

        size--;

        return deletedData;
    }

    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }

        ListItem<T> previous = head;
        ListItem<T> current = previous.getNext();

        previous.setNext(null);

        while (current != null) {
            ListItem<T> next = current.getNext();
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
        copy.size = size;

        ListItem<T> previousItem = copy.head;

        ListItem<T> currentItem = head.getNext();

        for (int i = 1; i < size; i++) {
            ListItem<T> copyItem = new ListItem<>(currentItem.getData());

            previousItem.setNext(copyItem);
            previousItem = copyItem;

            currentItem = currentItem.getNext();
        }

        return copy;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " за пределами допустимого значения (от 0, до " + (size - 1) + ")");
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

        for (int i = 0; i < size; i++) {
            stringBuilder.append(item.getData());
            item = item.getNext();

            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}