package com.epam.jf.common.homework.task17;

import java.util.Arrays;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    E[] values;
    int capacity;

    public GenericArrayList() {
        capacity = 10;
        values =  (E[])new Object[capacity];
    }

    public GenericArrayList(int capacity){
        values =  (E[])new Object[capacity];
        this.capacity = capacity;
    }

    public GenericArrayList(AbstractGenericList<? extends E> list){
        values =  (E[])new Object[list.size()];
        capacity = list.size() - 1;
        size = list.size();

        for (int i = 0; i < list.size(); i++) {
           values[i] = list.get(i);
        }
    }

    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    public boolean add(E value) {
        ensureCapacity(size + 1);
        values[size++] = value;
        return true;
    }

    private void ensureCapacity(int i) {
        if (size >= capacity){
            capacity <<= 1;
            increaseCapacity(capacity);
        }
    }

    private void increaseCapacity(int capacity) {
        values = Arrays.copyOf(values,capacity);
    }

    public boolean add(E value, int index) {
        ensureCapacity(size + 1);
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        ++size;
        return true;
    }

    public E remove(E value) {
        return remove(indexOf(value));
    }

    public E remove(int index) {
        E returnValue = this.get(index);
        System.arraycopy(values, index + 1, values, index, size - index);
        size--;
        return returnValue;
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            values[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        return values[index];
    }

    public E set(E value, int index) {
        values[index] = value;
        return values[index];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

}
