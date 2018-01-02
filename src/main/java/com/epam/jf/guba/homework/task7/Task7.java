package com.epam.jf.guba.homework.task7;

import com.epam.jf.common.homework.task7.AbstractIntArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Task7 extends AbstractIntArrayList {

    protected int size;


    public Task7() {
    }

    public Task7(int capacity) {
        super(capacity);
    }

    public Task7(AbstractIntArrayList list) {
        super(list);
    }

    @Override
    public boolean add(int value) {
        return add(value, size);
    }


    @Override
    public boolean add(int value, int index) {
        checkBounds(index, "Exception from add(). Index " + index + " actual size " + size);
        int oldSize = size;
        expandIfNeed(size + 1);
        if (index == size) {
            values[index] = value;
        } else {
            shiftRight(index);
            values[index] = value;
        }
        size++;
        return size > oldSize;
    }


    @Override
    public int get(int index) {
        checkBounds(index, "Exception from get(). Index " + index + " actual size " + size);
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) {
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
        checkBounds(index, "Exception from remove(). Index " + index + " actual size " + size);
        int oldValue = values[index];
        if (index != size - 1) {
            shiftLeft(index + 1);
        }
        size--;
        return oldValue;
    }

    @Override
    public int set(int value, int index) {
        checkBounds(index, "Exception from set(). Index " + index + " actual size " + size);
        int oldValue = values[index];
        values[index] = value;
        return oldValue;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        int oldSize = size;
        for (int i = 0; i < list.size(); i++) {

            add(list.get(i));

        }

        return size > oldSize;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) {
                return i;
            }
        }
        throw new NoSuchElementException("Exception from indexOf(). There is not such element in collection: " + value);
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i] == value) {
                return i;
            }
        }
        throw new NoSuchElementException("Exception from lastIndexOf(). There is not such element in collection: " + value);
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        Task7 newList = new Task7();

        for (int i = fromInclusive; i <= toInclusive; i++) {

            newList.add(get(i));

        }

        return newList;
    }

    private void shiftRight(int fromInclusive) {
        checkBounds(fromInclusive - 1, "Right shift till: " + (fromInclusive - 1));
        System.arraycopy(values, fromInclusive, values, fromInclusive + 1, size - fromInclusive);
    }

    private void shiftLeft(int fromInclusive) {
        checkBounds(fromInclusive - 1, "Left shift till: " + (fromInclusive - 1));
        System.arraycopy(values, fromInclusive, values, fromInclusive - 1, size - fromInclusive);
    }

    private void checkBounds(int index, String s) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(s);
        }
    }

    private void expandIfNeed(int newSize) {
        if (newSize > values.length) {
            if (values.length == 0) {
                values = new int[1];
            }
            values = Arrays.copyOf(values, values.length * 2);
        }
    }
}
