package com.epam.jf.common.homework.task7;

public abstract class AbstractIntArrayList {

    private static final int DEFAULT_SIZE = 10;

    protected int[] values;

    public AbstractIntArrayList() {
        this.values = new int[DEFAULT_SIZE];
    }

    public AbstractIntArrayList(int capacity) {
        this.values = new int[capacity];
    }

    public AbstractIntArrayList(AbstractIntArrayList list) {
        values = new int[(int) (list.values.length)];
        System.arraycopy(list.values, 0, values, 0, list.size());
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
