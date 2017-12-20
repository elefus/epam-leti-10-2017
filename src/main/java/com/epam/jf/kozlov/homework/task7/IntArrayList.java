package com.epam.jf.kozlov.homework.task7;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class IntArrayList extends AbstractIntArrayList {

    IntArrayList(){}

    IntArrayList(int capacity) {
        super(capacity);
    }

    IntArrayList(IntArrayList list) {
        super(list);
    }

    @Override
    public boolean add(int value) {
        int[] newArray = Arrays.copyOf(values, size() + 1);
        newArray[newArray.length - 1] = value;
        values = newArray;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        int[] newArray = new int[size() + 1];
        System.arraycopy(values, 0, newArray, 0, index - 1);
        newArray[index - 1] = value;
        System.arraycopy(values, index - 1, newArray, index - 1 + 1, size() - (index - 1));
        values = newArray;
        return true;
    }

    @Override
    public int get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for (int val:values) {
            if(val == value) {
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        for (int value: list.values) {
            if(!contains(value)) {
                return false;
            }
        };
        return true;
    }

    @Override
    public int remove(int index) {
        int result = values[index];
        int[] newArray = new int[size() + 1];
        System.arraycopy(values, 0, newArray, 0, index - 1);
        System.arraycopy(values, index, newArray, index - 1, size() - index);
        values = newArray;
        return result;
    }

    @Override
    public int set(int value, int index) {
        int result = values[index];
        values[index] = value;
        return result;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        for (int value: list.values) {
            add(value);
        };
        return true;
    }

    @Override
    public void clear() {
        values = new int[0];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < size() ; i++) {
            if(values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        int result = -1;
        for (int i = 0; i < size() ; i++) {
            if(values[i] == value) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        IntArrayList subArrayList = new IntArrayList(toInclusive - fromInclusive + 1);
        subArrayList.values = Arrays.copyOfRange(values, fromInclusive, toInclusive);
        return subArrayList;
    }
}
