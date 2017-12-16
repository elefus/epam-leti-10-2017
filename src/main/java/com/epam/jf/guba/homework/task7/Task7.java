package com.epam.jf.guba.homework.task7;

import com.epam.jf.common.homework.task7.AbstractIntArrayList;

public class Task7 extends AbstractIntArrayList {

    protected int size;
    protected int capacity;

    public Task7() {
        super();
        this.size = 0;
        capacity = values.length;
    }

    public Task7(int capacity) {
        super(capacity);
        this.size = 0;
        this.capacity = values.length;
    }

    public Task7(AbstractIntArrayList list) {
        super(list);
        this.size = 0;
        capacity = values.length;
    }

    @Override
    public boolean add(int value) {
        int olldSize = size;
        add(value, size);
        return size > olldSize;
    }


    @Override
    public boolean add(int value, int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from add(). Index " + index + " actual size " + size);
        }
        int oldSize = size;
        if (size == 0) {
            values[0] = value;
            size++;
        } else if (index == size) {
            if (isNeedExpand(size + 1)) {
                expand();
            }
            values[index] = value;
            size++;
        } else {
            shifftRight(index, 1);
            values[index] = value;
        }
        capacity = values.length;
        return size > oldSize;
    }


    @Override
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from get(). Index " + index + " actual size " + size);
        }
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
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from remove(). Index " + index + " actual size " + size);
        }
        int oldValue = values[index];
        if (index == size - 1) {
            values[index] = 0;
            size--;
        } else {
            shiftLeft(index + 1, 1);
        }
        return oldValue;
    }

    @Override
    public int set(int value, int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from set(). Index " + index + " actual size " + size);
        }
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
        for (int element : values) {
            element = 0;
        }
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

    private void shifftRight(int fromInclusive, int positions) {
        while (isNeedExpand(size + positions)) {
            expand();
        }
        for (int i = size - 1; i >= fromInclusive; i--) {
            values[i + positions] = values[i];
        }
        for (int i = fromInclusive; i < (fromInclusive + positions); i++) {
            values[i] = 0;
        }
        capacity = values.length;
        size += positions;
    }

    private void shiftLeft(int fromInclusive, int position) {
        if (fromInclusive - position < 0) {
            throw new ArrayIndexOutOfBoundsException("Left shift till: " + (fromInclusive - position));
        }
        for (int i = fromInclusive; i < size; i++) {
            values[i - position] = values[i];
        }
        for (int i = size - position; i < size; i++) {
            values[i] = 0;
        }
        capacity = values.length;
        size -= position;
    }

    private void expand() {
        int[] newValues = new int[(int) (capacity * 1.5)];
        for (int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }

    private boolean isNeedExpand(int newSize) {
        return newSize > capacity * 0.75;
    }

    public int getCapacity() {
        return capacity;
    }


}
