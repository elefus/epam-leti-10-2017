package com.epam.jf.burachenko.homework.task7;

import com.sun.istack.internal.NotNull;

public abstract class AbstractIntArrayList {

    protected int[] values;

    public AbstractIntArrayList() {
        // TODO values (на 10 элементов)
        values = new int[10];
    }

    public AbstractIntArrayList(int capacity) {
        // TODO value[capacity]
        if(capacity < 0) {
            throw new Error("Размер массива не может быть отрицательным");
        }
        values = new int[capacity];
    }

    public AbstractIntArrayList(AbstractIntArrayList list) {
        // TODO конструктор копирования
        addAll(list);
    }

    public abstract boolean add(int value);

    public abstract boolean add(int value, int index);

    public abstract int get(int index);

    public abstract boolean contains(int value);

    public abstract boolean containsAll(AbstractIntArrayList list);

    public abstract int remove(int index);

    public abstract int set(int value, int index);

    public abstract boolean addAll(AbstractIntArrayList list);

    public abstract void clear();

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract int indexOf(int value);

    public abstract int lastIndexOf(int value);

    public abstract AbstractIntArrayList subList(int fromInclusive, int toInclusive);
}

