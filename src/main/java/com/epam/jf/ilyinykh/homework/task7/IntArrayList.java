package com.epam.jf.ilyinykh.homework.task7;

import java.util.ArrayList;

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
        int[] newValues = new int[values.length + 1];

        newValues[values.length + 1] = value;
        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }

        values = newValues;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        checkIndexes(index);
        int[] newValues = new int[values.length + 1];

        newValues[index] = value;
        for (int i = 0; i < index; i++) {
            newValues[i] = values[i];
        }
        for (int i = index; i < values.length; i++) {
            newValues[i + 1] = values[i];
        }

        values = newValues;
        return true;
    }

    @Override
    public int get(int index) {
        checkIndexes(index);
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for (int i : values) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        for (int i : list.values) {
            if (!contains(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int remove(int index) {
        checkIndexes(index);
        int oldValue = values[index];
        int[] newValues = new int[values.length - 1];

        for (int i = 0; i < index; i++) {
            newValues[i] = values[i];
        }
        for (int i = index + 1; i < values.length; i++) {
            newValues[i - 1] = values[i];
        }

        values = newValues;
        return oldValue;
    }

    @Override
    public int set(int value, int index) {
        checkIndexes(index);
        int oldValue = values[index];
        values[index] = value;
        return oldValue;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        for (int i : list.values) {
            add(i);
        }
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
            if (value == values[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        int result = -1;
        for (int i = 0; i < values.length; i++) {
            if (value == values[i]) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        IntArrayList toReturn = null;
        checkIndexes(fromInclusive, toInclusive);
        if (toInclusive < fromInclusive) {
            throw  new IllegalArgumentException("to must be >= from");
        }
        if (toInclusive == fromInclusive) {
            return new IntArrayList(0);
        }
        toReturn = new IntArrayList(toInclusive - fromInclusive);
        for (int i = fromInclusive; i < toInclusive; i++) {
            toReturn.add(values[i]);
        }
        return toReturn;
    }

    private void checkIndexes(int...indexes) {
        for (int index : indexes) {
            if (index > values.length || index < 0) {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}
