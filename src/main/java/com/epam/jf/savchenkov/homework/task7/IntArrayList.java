package com.epam.jf.savchenkov.homework.task7;

import java.util.Arrays;

public class IntArrayList extends AbstractIntArrayList {

    protected int size;

    public IntArrayList() {
        super();
        this.size = 0;
    }

    public IntArrayList(int initialCapacity) {
        super(initialCapacity);
        this.size = 0;
    }

    public IntArrayList(IntArrayList list) {
        super(list);
        this.size = list.size;
    }

    public IntArrayList(int[] list) {
        this.values = list.clone();
        this.size = list.length;
    }

    @Override
    public boolean add(int value) {
        add(value, this.size);
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from add(). Index " + index + " actual size " + size);
        } else {
            int[] temp = new int[this.size() + 1];
            System.arraycopy(this.values, 0, temp, 0, index);
            temp[index] = value;
            System.arraycopy(this.values, index, temp, index + 1, this.size() - index);
            this.values = temp;
            this.size++;
            return true;
        }
    }

    @Override
    public int get(int index) {
        return this.values[index];
    }


    @Override
    public boolean contains(int value) {
        for (int val : this.values) {
            if (value == val) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.values[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int remove(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from remove(). Index " + index + " actual size " + size);
        } else {
            int value = this.values[index];
            int[] temp = new int[this.size() - 1];
            System.arraycopy(this.values, 0, temp, 0, index);
            System.arraycopy(this.values, index + 1, temp, index, temp.length - index);
            this.values = temp;
            this.size--;
            return value;
        }
    }

    @Override
    public int set(int value, int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from set(). Index " + index + " actual size " + size);
        } else {
            int old = this.values[index];
            this.values[index] = value;
            return old;
        }
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        int[] buffArray = new int[this.size() + list.size()];

        int[] copyArrayList = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            copyArrayList[i] = list.get(i);
        }

        System.arraycopy(this.values, 0, buffArray, 0, this.size());
        System.arraycopy(copyArrayList, 0, buffArray, this.size(), list.size());
        this.values = buffArray;
        this.size += list.size();
        return true;
    }

    @Override
    public void clear() {
        this.values = new int[0];
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
        if (fromInclusive > toInclusive || fromInclusive < 0 || toInclusive < 0 || fromInclusive >= size || toInclusive >= size) {
            throw new IllegalArgumentException("Illegal interval");
        }
        return new IntArrayList(Arrays.copyOfRange(values, fromInclusive, toInclusive));
    }

    @Override
    public String toString() {
        return "IntArrayList{" +
                "\nsize=" + size +
                ", \nvalues=" + Arrays.toString(values) +
                '}';
    }
}
