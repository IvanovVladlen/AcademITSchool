package ru.academits.ivanov.myarraylist;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int size = 0;
    private int motCount = 0;

    public MyArrayList() {
        //noinspection unchecked
        this.items = (T[]) new Object[10];
    }

    public MyArrayList(int capacity) {
        checkCapacity(capacity);

        //noinspection unchecked
        this.items = (T[]) new Object[capacity];
    }

    public MyArrayList(T[] items) {
        checkItems(items);

        this.items = Arrays.copyOf(items, items.length);
        this.size = items.length;
    }

    public MyArrayList(int capacity, T[] items) {
        checkCapacity(capacity);
        checkItems(items);

        this.items = Arrays.copyOf(items, Math.max(items.length, capacity));
        this.size = items.length;
    }

    private void checkCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity = " + capacity + ". Вместимость не может быть меньше или равна 0");
        }
    }

    private void checkItems(T[] items) {
        if (items == null) {
            throw new NoSuchElementException("Items = null");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private class MyListIterator implements Iterator<T> {
        int currentIndex = -1;
        final int currentModCount = motCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (currentIndex == size) {
                throw new NoSuchElementException("Current Index = " + currentIndex + ", что больше размера списка = " + size);
            }

            if (currentModCount != motCount) {
                throw new ConcurrentModificationException("В коллекции произошли изменения, currentModCount = " + currentModCount + " < чем motCount = " + motCount);
            }

            return items[++currentIndex];
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}