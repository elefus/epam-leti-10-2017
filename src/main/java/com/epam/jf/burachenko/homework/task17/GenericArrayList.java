package com.epam.jf.burachenko.homework.task17;

import com.epam.jf.burachenko.homework.task16.GenericList;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {
    private Object[] values;

    public GenericArrayList() {
        values = new Object[10];
    }

    public GenericArrayList(int capacity) {
        values = new Object[capacity];
    }

    public GenericArrayList(GenericList<? extends E> c) {
        super(c);
    }

    @Override
    public boolean add(E value) {
        checkCapacityAndResize(size + 1);
        values[size - 1] = value;
        return true;
    }

    @Override
    public boolean add(E value, int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        checkCapacityAndResize(size + 1);

        System.arraycopy(values, index, values, index + 1, values.length - index - 1);
        values[index] = value;
        return true;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) values[index];
    }

    @Override
    public E set(E value, int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        values[index] = value;
        return value;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(values, size);
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        E copy = (E) values[index];
        System.arraycopy(values, index + 1, values, index, values.length - index - 1);
        size--;
        return copy;
    }

    @Override
    public void clear() {
        values = new Object[10];
        size = 0;
    }

    @Override
    public int indexOf(@NotNull E value) {
        for (int i = 0; i < size; i++) {
            if(value.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(@NotNull E value) {
        for (int i = size - 1; i >= 0; i--) {
            if(value.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toInclusive) {
        if(fromInclusive < 0 || fromInclusive >= size || toInclusive < 0 || toInclusive >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(fromInclusive > toInclusive) {
            throw new IllegalArgumentException("Left border must be less or equal than right border");
        }

        GenericList<E> subList = new GenericArrayList<>(toInclusive - fromInclusive + 1);
        for (int i = fromInclusive; i <= toInclusive; i++) {
            subList.add((E) values[i]);
        }
        return subList;
    }

    public void trimToSize() {
        Object[] trimmedValues = new Object[size];
        System.arraycopy(values, 0, trimmedValues, 0, size);
        values = trimmedValues;
    }

    private void checkCapacityAndResize(int newSize) {
        if(newSize > values.length) {
            Object[] newValues = new Object[(newSize/values.length+1)*values.length];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
        size = newSize;
    }
}
