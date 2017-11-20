package com.epam.jf.bavtovich.homework;

import com.epam.jf.bavtovich.homework.task12.AbstractObjectArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Task12 extends AbstractObjectArrayList {

    private int size;
    int capacity;

    public Task12() {
        super();
        capacity = values.length;
        size = 0;
    }

    public Task12(int capacity) {
        super(capacity);
        capacity = capacity;
        size = 0;
    }

    public Task12(AbstractObjectArrayList list) {
        super(list);
        capacity = values.length;
        size = values.length;
    }

    @Override
    public boolean add(Object value) {
        checkSizeAndResize(1);
        values[size++] = value;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
        isValidIndex(index);
        checkSizeAndResize(1);
        System.arraycopy(values, index, values, index + 1, size - index + 1);
        values[index] = value;
        size++;
        return false;
    }

    @Override
    public Object get(int index) {
        isValidIndex(index);
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (Object elem: values) {
            if (value.equals(elem)) {
                return true;
            }
        }
        return false;
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
        isValidIndex(index);
        Object elem = values[index];
        System.arraycopy(values,index + 1, values, index, size - index);
        size--;
        return elem;
    }

    @Override
    public Object remove(Object value) {
        while (contains(value)) {
            remove(indexOf(value));
        }
        return value;
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            Object removedElem = remove(list.get(i));
        }
        return true;
    }

    @Override
    public Object set(Object value, int index) {
        isValidIndex(index);
        values[index] = value;
        return value;
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        checkSizeAndResize(4);
        for (int i = 0; i < list.size(); i++) {
            values[size + i] = list.get(i);
            size++;
        }
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
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0 ; i--) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        if (fromInclusive > toInclusive) {
            throw new IllegalArgumentException("First index must be less of equal second index");
        }
        isValidIndex(fromInclusive);
        isValidIndex(toInclusive);
        AbstractObjectArrayList obj = new Task12();
        for (int i = fromInclusive; i <= toInclusive; i++) {
            obj.add(values[i]);
        }
        return obj;
    }

    @Override
    public void trimToSize() {
        Object[] buf = new Object[size];
        System.arraycopy(values,0, buf,0, size);
        values = buf;
        capacity = values.length;
    }

    private void isValidIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private void checkSizeAndResize(int numAddElements) {
        if (size + numAddElements > capacity) {
            int temp = (size + numAddElements > (int) (1.5 * capacity))
                        ? size + numAddElements
                        : (int) (1.5 * capacity);
            Object[] buff = new Object[temp];
            System.arraycopy(values, 0, buff,0, size);
            values = buff;
        }
    }
}
