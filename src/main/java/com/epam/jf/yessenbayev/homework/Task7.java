package com.epam.jf.yessenbayev.homework;

import com.epam.jf.yessenbayev.homework.task7.AbstractIntArrayList;

public class Task7 extends com.epam.jf.yessenbayev.homework.task7.AbstractIntArrayList {
    public Task7() {
        super();
    }

    public Task7(int capacity) {
        super(capacity);
    }

    public Task7(Task7 list) {
        super(list);
    }

    public void isValidIndex(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
    @Override
    public boolean add(int value) {

        int[] extendValues = new int[values.length + 1];
        extendValues[values.length] = value;
        System.arraycopy(values, 0, extendValues,0, values.length);
        values = extendValues;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        isValidIndex(index);
        int[] extendValues = new int[values.length + 1];
        System.arraycopy(values,0, extendValues, 0, index);
        extendValues[index] = value;
        System.arraycopy(values, index, extendValues, index + 1, values.length - index);
        values = extendValues;
        return true;
    }

    @Override
    public int get(int index) {
        isValidIndex(index);
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for (int element: values) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int remove(int index) {
        isValidIndex(index);
        int[] tempo = new int[values.length-1];
        int changedValues = values[index];
        System.arraycopy(values,0, tempo, 0, index);
        System.arraycopy(values, index + 1, tempo, index, values.length - index - 1);
        values = tempo;
        return changedValues;
    }

    @Override
    public int set(int value, int index) {
        isValidIndex(index);
        values[index] = value;
        return values[index];
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        int[] extendValues = new int[values.length + list.size()];
        System.arraycopy(values,0, extendValues, 0, values.length);
        for (int i = 0; i < list.size(); i++) {
            extendValues[values.length + i] = list.get(i);
        }
        values = extendValues;
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
        return values.length == 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = values.length - 1; i >= 0; i--) {
            if (values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        if (fromInclusive < toInclusive) {
            AbstractIntArrayList obj = new Task7(toInclusive - fromInclusive + 1);
            for (int i = fromInclusive; i <= toInclusive; i++) {
                obj.set(values[i], i - fromInclusive);
            }
            return obj;
        } else {
            throw new IllegalArgumentException("toInclusive must be higher then fromInclusive");
        }
    }
}
