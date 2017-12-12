package com.epam.jf.zakomornyy.homework.task7;

public class IntArrayList extends AbstractIntArrayList {
    public IntArrayList() {
    }

    public IntArrayList(int capacity) {
        super(capacity);
    }

    public IntArrayList(AbstractIntArrayList list) {
        super(list);
    }

    @Override
    public boolean add(int value) {
        int[] buffArray = new int[this.size() + 1];
        System.arraycopy(this.values, 0, buffArray, 0, this.size());
        buffArray[this.size()] = value;
        this.values = buffArray;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        int[] buffArray = new int[this.size() + 1];
        System.arraycopy(this.values, 0, buffArray, 0, index);
        System.arraycopy(this.values, index, buffArray, index + 1, buffArray.length - index - 1);
        buffArray[index] = value;
        this.values = buffArray;
        return true;
    }

    @Override
    public int get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for (int val: this.values) {
            if(val == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        int numOfCoincidences = 0;
        for (int value: list.values) {
            for (int val: this.values) {
                if(val == value) {
                    numOfCoincidences++;
                    break;
                }
            }
        }
        return numOfCoincidences == list.size();
    }

    @Override
    public int remove(int index) {
        int value = this.values[index];
        int[] buffArray = new int[this.size() - 1];
        System.arraycopy(this.values, 0, buffArray, 0, index);
        System.arraycopy(this.values, index + 1, buffArray, index, buffArray.length - index);
        this.values = buffArray;
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
        System.arraycopy(this.values, 0, buffArray, 0, this.size());
        System.arraycopy(list.values, 0, buffArray, this.size(), list.size());
        this.values = buffArray;
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
        return this.size() == 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < this.size(); i++) {
            if(this.values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = this.size() - 1; i >= 0; i--) {
            if(this.values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        AbstractIntArrayList abstractIntArrayListrrayList = new IntArrayList(toInclusive - fromInclusive + 1);
        System.arraycopy(this.values, fromInclusive,
                abstractIntArrayListrrayList.values, 0,
                abstractIntArrayListrrayList.size());

        return abstractIntArrayListrrayList;
    }
}
