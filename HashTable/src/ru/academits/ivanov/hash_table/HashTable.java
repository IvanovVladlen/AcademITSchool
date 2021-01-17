package ru.academits.ivanov.hash_table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class HashTable<T> implements Collection<T> {
    private static final int DEFAULT_LENGTH = 10;

    private final ArrayList<T>[] lists;
    private int size;
    private int modCount;

    public HashTable() {
        //noinspection unchecked
        this.lists = (ArrayList<T>[]) new ArrayList<?>[DEFAULT_LENGTH];
    }

    public HashTable(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("capacity (" + length + ") < 0");
        }

        //noinspection unchecked
        this.lists = (ArrayList<T>[]) new ArrayList<?>[length];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(15);

        set.add(15);
        set.add(2);

        System.out.println(set);
    }
}