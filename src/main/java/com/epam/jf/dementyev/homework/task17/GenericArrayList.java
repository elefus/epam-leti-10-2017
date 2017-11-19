package com.epam.jf.dementyev.homework.task17;

import com.epam.jf.dementyev.homework.task16.GenericList;
import java.util.Objects;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    protected E[] values;

    public GenericArrayList() {
        values = (E[]) new Object[10];
    }

    public GenericArrayList(int capacity) {
        super();
        values = (E[]) new Object[capacity];
    }

    public GenericArrayList(GenericList<? extends E> list) {
        super();
        size = list.size();
        values = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            values[i] = list.get(i);
        }
    }

    @Override
    public boolean add(E value, int index) {
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
    public boolean addAll(GenericList<? extends E> list) {
        checkSize(size + list.size());
        for (int i = 0; i < list.size(); i++) {
            values[size + i] = list.get(i);
        }
        size += list.size();
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return values[index];
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E item = values[index];
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        values[size] = null;
        return item;
    }

    @Override
    public E set(E value, int index) {
        checkIndex(index);
        E item = values[index];
        values[index] = value;
        return item;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(values[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(values[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toInclusive) {
        if (fromInclusive > toInclusive) {
            throw new IllegalArgumentException();
        }
        checkIndex(fromInclusive);
        checkIndex(toInclusive);
        GenericArrayList<E> obj = new GenericArrayList<>(toInclusive - fromInclusive + 1);
        System.arraycopy(values, fromInclusive, obj.values, 0, toInclusive - fromInclusive + 1);
        obj.size = toInclusive - fromInclusive + 1;
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
        Object[] temp = values;
        values = (E[]) new Object[len];
        size = Math.min(size, len);
        System.arraycopy(temp, 0, values, 0, size);
    }

    private void checkIndex(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }
    }
}
