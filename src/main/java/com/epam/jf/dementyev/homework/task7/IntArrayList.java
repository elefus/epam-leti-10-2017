package com.epam.jf.dementyev.homework.task7;

public class IntArrayList extends AbstractIntArrayList {

    private int size = 0;

    public IntArrayList() {
        super();
    }

    public IntArrayList(int capacity) {
        super(capacity);
    }

    public IntArrayList(AbstractIntArrayList list) {
        super(list);
        size = list.size();
    }

    @Override
    public boolean add(int value) {
        checkSize(size + 1);
        values[size++] = value;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        if (index < 0 || size < index) {
            return false;
        }
        checkSize(size + 1);
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        return indexOf(value) != -1;
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
        checkIndex(index);
        int item = values[index];
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        return item;
    }

    @Override
    public int set(int value, int index) {
        checkIndex(index);
        int item = values[index];
        values[index] = value;
        return item;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        checkSize(size + list.size());
        System.arraycopy(list.values, 0, values, size, list.size());
        size += list.size();
        return true;
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
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        if (fromInclusive > toInclusive) {
            throw new IllegalArgumentException();
        }
        checkIndex(fromInclusive);
        checkIndex(toInclusive);
        IntArrayList obj = new IntArrayList(toInclusive - fromInclusive);
        System.arraycopy(values, fromInclusive, obj.values, 0, toInclusive - fromInclusive);
        obj.size = toInclusive - fromInclusive;
        return obj;
    }

    private void checkSize(int newSize) {
        if (newSize > values.length) {
            int capacity = values.length;
            while (capacity < newSize) {
                capacity = (int) (capacity * 1.5) + 1;
            }
            resize(capacity);
        }
    }

    private void resize(int len) {
        int[] temp = values;
        values = new int[len];
        size = Math.min(size, len);
        System.arraycopy(temp, 0, values, 0, size);
    }

    private void checkIndex(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }
    }
}