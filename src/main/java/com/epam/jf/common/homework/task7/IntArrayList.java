package com.epam.jf.common.homework.task7;

public abstract class IntArrayList {

    protected int[] values;

    public IntArrayList() {
        // TODO values (на 10 элементов)
    }

    public IntArrayList(int capacity) {
        // TODO value[capacity]
    }

    public IntArrayList(IntArrayList list) {
        // TODO конструктор копирования
    }

    public abstract boolean add(int value);

    public abstract boolean add(int value, int index);

    public abstract int get(int index);

    public abstract boolean contains(int value);

    public abstract boolean containsAll(IntArrayList list);

    public abstract int remove(int index);

    public abstract int set(int value, int index);

    public abstract boolean addAll(IntArrayList list);

    public abstract void clear();

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract int indexOf(int value);

    public abstract int lastIndexOf(int value);

    public abstract IntArrayList subList(int fromInclusive, int toInclusive);
}
