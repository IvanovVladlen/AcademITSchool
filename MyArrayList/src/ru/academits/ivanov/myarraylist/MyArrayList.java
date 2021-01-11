package ru.academits.ivanov.myarraylist;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] items;
    private int size;
    private int modCount;

    public MyArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(T[] items) {
        checkItems(items);

        this.items = Arrays.copyOf(items, items.length);
        size = items.length;
    }

    public MyArrayList(int capacity) {
        checkCapacity(capacity);

        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    public MyArrayList(int capacity, T[] items) {
        checkCapacity(capacity);
        checkItems(items);

        this.items = Arrays.copyOf(items, Math.max(items.length, capacity));
        size = items.length;
    }

    public MyArrayList(Collection<? extends T> collection) {
        //noinspection unchecked
        items = (T[]) collection.toArray();
        size = collection.size();
    }

    private void checkCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity (" + capacity + ") < 0");
        }
    }

    private void checkItems(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException("items не может быть равен null");
        }
    }

    private void installCapacity(int newCapacity) {
        if (items.length < newCapacity) {
            items = Arrays.copyOf(items, newCapacity);
        }
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length == 0 ? DEFAULT_CAPACITY : items.length * 2);
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
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] array) {
        if (array == null) {
            throw new NullPointerException("Массив равен null");
        }

        if (array.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size, array.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, array, 0, size);

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    public boolean add(T value) {
        add(size, value);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (indexOf(o) != -1) {
            remove(indexOf(o));
            return true;
        }

        return false;
    }

    private void checkIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index =" + index + ", index не может быть < 0");
        }

        if (index >= size) {
            throw new IllegalArgumentException("index =" + index + ", не может быть >= size (" + size + ")");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index =" + index + ", не может быть < 0");
        }

        if (index > size) {
            throw new IllegalArgumentException("index =" + index + ", не может быть > size (" + size + ")");
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }

        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndexForAdd(index);

        if (c.size() == 0) {
            return false;
        }

        int collectionSize = c.size();
        installCapacity(size + collectionSize);

        System.arraycopy(items, index, items, index + collectionSize, size - index);

        int i = index;

        for (T item : c) {
            items[i] = item;

            i++;
        }

        size += collectionSize;
        modCount++;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0) {
            return false;
        }

        int nowModCount = modCount;

        for (int i = 0; i < size; i++) {
            if (c.contains(items[i])) {
                remove(i);

                --i;
            }
        }

        return nowModCount != modCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int nowModCount = modCount;

        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);

                --i;
            }
        }

        return nowModCount != modCount;
    }

    @Override
    public void clear() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                items[i] = null;
            }
        }

        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        return items[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);

        T oldItem = items[index];
        items[index] = element;

        return oldItem;
    }

    @Override
    public void add(int index, T element) {
        checkIndexForAdd(index);

        if (size >= items.length) {
            increaseCapacity();
        }
        if (index < size) {
            System.arraycopy(items, index, items, index + 1, size - index);
        }

        items[index] = element;
        size++;
        modCount++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        T removedData = items[index];

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        size--;
        items[size] = null;
        modCount++;

        return removedData;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    private class MyListIterator implements Iterator<T> {
        int currentIndex = -1;
        final int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (currentIndex == size) {
                throw new NoSuchElementException("Current Index = " + currentIndex + ", что больше размера списка = " + size);
            }

            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("В коллекции произошли изменения, currentModCount = " + currentModCount + " < чем motCount = " + modCount);
            }

            return items[++currentIndex];
        }
    }

    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            listString.append(items[i]).append(", ");
        }

        if (listString.length() >= 2) {
            listString.delete(listString.length() - 2, listString.length());
        }

        listString.append("]");

        return listString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
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