package com.epam.jf.dementyev.homework.task12;

import java.util.Objects;

public class ObjectArrayList extends AbstractObjectArrayList {

    private int size = 0;

    public ObjectArrayList() {
        super();
    }

    public ObjectArrayList(int capacity) {
        super(capacity);
    }

    public ObjectArrayList(AbstractObjectArrayList list) {
        super(list);
        size = list.size();
    }

    @Override
    public boolean add(Object value) {
        checkSize(size + 1);
        values[size++] = value;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
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
    public Object get(int index) {
        checkIndex(index);
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Object item = values[index];
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        values[size] = null;
        return item;
    }

    @Override
    public Object remove(Object value) {
        int index = indexOf(value);
        if (index < 0) {
            return null;
        }
        return remove(index);
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            int index = indexOf(list.get(i));
            if (index >= 0) {
                remove(index);
            }
        }
        return true;
    }

    @Override
    public Object set(Object value, int index) {
        checkIndex(index);
        Object item = values[index];
        values[index] = value;
        return item;
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        checkSize(size + list.size());
        System.arraycopy(list.values, 0, values, size, list.size());
        size += list.size();
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
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
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(values[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(values[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        if (fromInclusive > toInclusive) {
            throw new IllegalArgumentException();
        }
        checkIndex(fromInclusive);
        checkIndex(toInclusive);
        ObjectArrayList obj = new ObjectArrayList(toInclusive - fromInclusive);
        System.arraycopy(values, fromInclusive, obj.values, 0, toInclusive - fromInclusive);
        obj.size = toInclusive - fromInclusive;
        return obj;
    }

    @Override
    public void trimToSize() {
        if (size != values.length) {
            Object[] newArray = new Object[size];
            System.arraycopy(values, 0, newArray, 0, size);
            values = newArray;
        }
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
        Object[] temp = values;
        values = new Object[len];
        size = Math.min(size, len);
        System.arraycopy(temp, 0, values, 0, size);
    }

    private void checkIndex(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }
    }
}
