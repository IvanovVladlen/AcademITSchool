package ru.academits.ivanov.array_list;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] items;
    private int size;
    private int modCount;

    public ArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(T[] items) {
        checkItems(items);

        this.items = Arrays.copyOf(items, items.length);
        size = items.length;
    }

    public ArrayList(int capacity) {
        checkCapacity(capacity);

        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    public ArrayList(int capacity, T[] items) {
        checkCapacity(capacity);
        checkItems(items);

        this.items = Arrays.copyOf(items, Math.max(items.length, capacity));
        size = items.length;
    }

    public ArrayList(Collection<? extends T> collection) {
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

    public void ensureCapacity(int newCapacity) {
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
        return new listIterator();
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

    public boolean add(T item) {
        add(size, item);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    private void checkIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index =" + index + ", index не может быть < 0");
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("index =" + index + ", не может быть >= size (" + size + ")");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index =" + index + ", не может быть < 0");
        }

        if (index > size) {
            throw new IndexOutOfBoundsException("index =" + index + ", не может быть > size (" + size + ")");
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
        ensureCapacity(size + collectionSize);

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

        int initialModCount = modCount;

        for (int i = 0; i < size; i++) {
            if (c.contains(items[i])) {
                remove(i);

                --i;
            }
        }

        return initialModCount != modCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int initialModCount = modCount;

        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);

                --i;
            }
        }

        return initialModCount != modCount;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
        modCount++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        return items[index];
    }

    @Override
    public T set(int index, T item) {
        checkIndex(index);

        T oldItem = items[index];
        items[index] = item;

        return oldItem;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);

        if (size >= items.length) {
            increaseCapacity();
        }
        if (index < size) {
            System.arraycopy(items, index, items, index + 1, size - index);
        }

        items[index] = item;
        size++;
        modCount++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        T removedItem = items[index];

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        size--;
        items[size] = null;
        modCount++;

        return removedItem;
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

    private class listIterator implements Iterator<T> {
        int currentIndex = -1;
        final int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Current index = " + currentIndex + ", что больше размера списка = " + size);
            }

            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("В коллекции произошли изменения, currentModCount = " + initialModCount + " < чем motCount = " + modCount);
            }

            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        //noinspection unchecked
        ArrayList<T> list = (ArrayList<T>) o;

        if (size != list.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!Objects.equals(items[i], list.items[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        for (int i = 0; i < size; i++) {
            hash = prime * hash + (items[i] != null ? items[i].hashCode() : 0);
        }

        return hash;
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