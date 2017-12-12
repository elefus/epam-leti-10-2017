package com.epam.jf.polovinkin.homework.task7;

import java.util.Arrays;

public class AbstractIntArrayList {

    protected int[] values;
    protected int pointer;

    public AbstractIntArrayList() {
        values = new int[10];
    }

    public AbstractIntArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity is below zero");
        values = new int[capacity];
    }

    public AbstractIntArrayList(AbstractIntArrayList list) {
        values = list.values.clone();
        pointer = list.pointer;
    }

    public AbstractIntArrayList(int[] list) {
        values = list.clone();
        pointer = list.length;
    }

    public boolean add(int value) {
        if (pointer >= values.length) {
            increaseCapacity();
        }
        values[++pointer] = value;
        return true;
    }

    public boolean add(int value, int index) {
        if (index < 0 || index > pointer) {
            throw new IllegalArgumentException("index is out of range");
        }
        if (pointer >= values.length) {
            increaseCapacity();
        }
        System.arraycopy(values, index, values, index + 1, pointer - index );
        values[index] = value;
        pointer++;
        return true;
    }

    public int get(int index) {
        if (index < 0 || index >= pointer) {
            throw new IllegalArgumentException("index is out of range");
        }
        return values[index];
    }

    public boolean contains(int value) {
        for (int i = 0; i < pointer; i++) {
            if (values[i] == value) return true;
        }
        return false;
    }

    public boolean containsAll(AbstractIntArrayList list) {
        for (int i = 0; i < list.pointer; i++) {
            if (!contains(list.values[i])) return false;
        }
        return true;
    }

    public int remove(int index) {
        if (index < 0 || index >= pointer) {
            throw new IllegalArgumentException("index is out of range");
        }
        int value = values[index];
        System.arraycopy(values, index + 1, values, index, pointer - index - 1);
        pointer--;
        return value;
    }

    public int set(int value, int index) {
        if (index < 0 || index >= pointer) {
            throw new IllegalArgumentException("index is out of range");
        }
        int temp = values[index];
        values[index] = value;
        return temp;
    }

    public boolean addAll(AbstractIntArrayList list) {
        int freeSpace = values.length - pointer;
        int spaceRequired = list.pointer;
        if (freeSpace < spaceRequired) {
            int[] temp = new int[(int)((values.length + spaceRequired)*1.2) + 1];
            System.arraycopy(values, 0, temp, 0, pointer);
            values = temp;
        }
        System.arraycopy(list.values, 0, values, pointer, list.pointer);
        pointer += list.pointer;
        return true;
    }

    public void clear() {
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public int indexOf(int value) {
        for (int i = 0; i < pointer; i++) {
            if (values[i] == value) return i;
        }
        return -1;
    }

    public int lastIndexOf(int value) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (values[i] == value) return i;
        }
        return -1;
    }

    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        if (fromInclusive > toInclusive || fromInclusive < 0 || toInclusive < 0 || fromInclusive >= pointer || toInclusive >= pointer) {
            throw new IllegalArgumentException("Illegal interval");
        }
        return new AbstractIntArrayList(Arrays.copyOfRange(values, fromInclusive, toInclusive));

    }

    private void increaseCapacity() {
        int[] temp = new int[values.length*2 + 1];
        System.arraycopy(values, 0, temp, 0, pointer);
        values = temp;
    }
}
