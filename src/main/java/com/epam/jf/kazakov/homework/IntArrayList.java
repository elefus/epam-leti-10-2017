package com.epam.jf.kazakov.homework;

import com.epam.jf.common.homework.task7.AbstractIntArrayList;

public class IntArrayList extends AbstractIntArrayList {

    public IntArrayList() {
        super();
    }

    public IntArrayList(int capacity) {
        super(capacity);
    }

    public IntArrayList(AbstractIntArrayList list) {
        super(list);
    }

    @Override
    public boolean add(int value) {
        int[] tempArray = new int[this.size() + 1];
        System.arraycopy(this.values, 0, tempArray, 0, this.size());
        tempArray[this.size()] = value;
        this.values = tempArray;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        int[] tempArray = new int[this.size() + 1];
        System.arraycopy(this.values, 0, tempArray, 0, index);
        System.arraycopy(this.values, index, tempArray, index + 1, this.size() - index);
        tempArray[index] = value;
        this.values = tempArray;
        return true;
    }

    @Override
    public int get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for (int values : this.values) {
            if(values == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        int similarValues = 0;
        for(int i = 0; i < list.size(); ++i) {
            for(int values : this.values) {
                if(values == list.get(i)) {
                    ++similarValues;
                    break;
                }
            }
        }
        return similarValues == list.size();
    }

    @Override
    public int remove(int index) {
        int value = this.values[index];
        int[] tempArray = new int[this.size() - 1];
        System.arraycopy(this.values, 0, tempArray, 0, index);
        System.arraycopy(this.values, index + 1, tempArray, index, tempArray.length - index);
        this.values = tempArray;
        return value;
    }

    @Override
    public int set(int value, int index) {
        int oldValue = this.values[index];
        this.values[index] = value;
        return oldValue;
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
        return true;
    }

    @Override
    public void clear() {
        this.values = new int[0];
    }

    @Override
    public int size() {
        return this.values.length;
    }

    @Override
    public boolean isEmpty() {
        return this.values.length == 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < this.size(); ++i) {
            if(this.values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = this.size() - 1; i >= 0; --i) {
            if(this.values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public IntArrayList subList(int fromInclusive, int toInclusive) {
        IntArrayList subArrayList = new IntArrayList(toInclusive - fromInclusive + 1);

        for (int i = 0; i < subArrayList.size(); ++i) {
            subArrayList.set(this.values[fromInclusive + i], i);
        }
        return subArrayList;
    }
}
