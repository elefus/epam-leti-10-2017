package com.epam.jf.burachenko.homework.task7;

import com.sun.istack.internal.NotNull;

class IntArrayList extends AbstractIntArrayList {
    public IntArrayList() {}

    public IntArrayList(int capacity) {
        super(capacity);
    }

    public IntArrayList(AbstractIntArrayList list) {
        super(list);
    }

    @Override
    public boolean add(int value) {
        int[] newValues = new int[size()+1];
        if(values != null) {
            System.arraycopy(values, 0, newValues, 0, size());
        }
        newValues[newValues.length-1] = value;
        values = newValues;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int[] newValues = new int[size()+1];
        System.arraycopy(values, 0, newValues, 0, index);
        System.arraycopy(values, index, newValues, index+1, size()-index);
        newValues[index] = value;
        values = newValues;
        return true;
    }

    @Override
    public int get(int index) {
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for(int digit: values) {
            if(digit == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        for(int digit : list.values) {
            if(!contains(digit)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int remove(int index) {
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int copy = values[index];
        int[] newValues = new int[size()-1];
        System.arraycopy(values, 0, newValues, 0, index);
        System.arraycopy(values, index + 1, newValues, index, newValues.length - index);
        values = newValues;
        return copy;
    }

    @Override
    public int set(int value, int index) {
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int copy = values[index];
        values[index] = value;
        return copy;
    }

    @Override
    public boolean addAll(@NotNull AbstractIntArrayList list) {
        int[] newValues = new int[size()+list.size()];
        if(values != null) {
            System.arraycopy(values, 0, newValues, 0, size());
        }
        System.arraycopy(list.values, 0, newValues, size(), list.size());
        values = newValues;
        return true;
    }

    @Override
    public void clear() {
        values = null;
    }

    @Override
    public int size() {
        if(values != null) {
            return values.length;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int indexOf(int value) {
        for(int i = 0; i < size(); i++) {
            if(values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for(int i = size()-1; i >= 0; i--) {
            if(values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        if(fromInclusive < 0 || fromInclusive >= size() || toInclusive < 0 || toInclusive >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(fromInclusive > toInclusive) {
            throw new IllegalArgumentException("Left border must be less or equal than right border");
        }

        AbstractIntArrayList newList = new IntArrayList(toInclusive - fromInclusive + 1);
        System.arraycopy(values, fromInclusive, newList.values, 0, toInclusive - fromInclusive + 1);
        return newList;
    }
}
