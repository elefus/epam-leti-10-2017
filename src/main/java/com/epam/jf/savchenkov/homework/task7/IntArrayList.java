package com.epam.jf.savchenkov.homework.task7;

import java.util.Arrays;

public class IntArrayList extends AbstractIntArrayList {

    protected int size;
    protected int capacity;

    public IntArrayList() {
        super();
        this.size = 0;
        this.capacity = values.length;
    }

    public IntArrayList(int initialCapacity) {
        super(initialCapacity);
        this.size = 0;
        this.capacity = values.length;
    }

    public IntArrayList(IntArrayList list) {
        super(list);
        this.size = list.size;
        this.capacity = list.capacity;
    }

    private void grow(int minCapacity) {
        int oldCapacity = this.capacity;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        this.values = Arrays.copyOf(this.values, newCapacity);
        this.capacity = newCapacity;
    }

    private boolean isNeedGrow(int wantToAdd) {
        return this.capacity < this.size + wantToAdd;
    }

    @Override
    public boolean add(int value) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from add(). Index " + index + " actual size " + size);
        }

        return true;
    }

    @Override
    public boolean add(int value, int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from add(). Index " + index + " actual size " + size);
        }

        return false;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        return false;
    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public int set(int value, int index) {
        return 0;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        return false;
    }

    @Override
    public void clear() {
        for (int val : values) {
            val = 0;
        }
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (value == values[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0; i--) {
            if (value == values[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        return null;
    }

    @Override
    public String toString() {
        return "IntArrayList{" +
                "\nsize=" + size +
                ", \ncapacity=" + capacity +
                ", \nvalues=" + Arrays.toString(values) +
                '}';
    }
}
