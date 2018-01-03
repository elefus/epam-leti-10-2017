package com.epam.jf.Shabashov.homework.task12;


public class ObjectArrayList extends AbstractObjectArrayList {
    private int size = 0;


    public ObjectArrayList() {
        values = new Object[10];
    }

    public ObjectArrayList(Object[] arr) {
        values = arr;
        size = values.length;
    }


    ObjectArrayList(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        values = new Object[capacity];
    }

    ObjectArrayList(ObjectArrayList list) {
        size = list.size;
        values = new Object[size];
        System.arraycopy(list.values, 0, values, 0, size);
    }


    @Override
    public boolean add(Object value) {
        if (size + 1 >= values.length) increaseSize();
        values[size++] = value;
        return true;
    }

    private String IndexOutException(int index) {
        return "Index : " + index + " size : " + size;
    }

    @Override
    public boolean add(Object value, int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
        System.arraycopy(values, index, values, index + 1, size - index);
        size++;
        values[index] = value;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.values[i])) return false;
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
        Object previous = values[index];
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        return previous;
    }

    @Override
    public Object remove(Object value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.get(i));
        }
        return true;
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
        Object previous = values[index];
        values[index] = value;
        return previous;
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        while (size + 1 >= values.length) increaseSize();
        System.arraycopy(list.values, 0, values, size, list.size());
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
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i].equals(value)) return i;
        }
        return -1;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        Object[] arr = new Object[toInclusive - fromInclusive + 1];
        System.arraycopy(values, fromInclusive, arr, 0, toInclusive - fromInclusive + 1);
        return new ObjectArrayList(arr);
    }

    @Override
    public void trimToSize() {
        Object[] arr = new Object[size];
        System.arraycopy(values, 0, arr, 0, size);
        values = arr;
    }

    private void increaseSize() {
        Object[] arr = new Object[values.length + (values.length >> 1)];
        System.arraycopy(values, 0, arr, 0, values.length);
        values = arr;
    }

}
