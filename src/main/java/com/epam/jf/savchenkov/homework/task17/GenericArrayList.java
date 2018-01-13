package com.epam.jf.savchenkov.homework.task17;

import java.util.Arrays;

/**
 * Реализация динамически расширяемого списка на основе массива.
 *
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    private E[] values;
    private int capacity;

    public GenericArrayList() {
        this.values = (E[]) new Object[10];
        this.capacity = 10;
    }

    public GenericArrayList(int capacity) {
        this.values = (E[]) new Object[10];
        this.capacity = capacity;
    }

    public GenericArrayList(AbstractGenericList<? extends E> list) {
        values = (E[]) new Object[list.size()];
        this.capacity = list.size() - 1;
        this.size = list.size();
        for (int i = 0; i < list.size(); i++) {
            values[i] = this.get(i);
        }
    }

    @Override
    public boolean add(E value) {
        ensureCapacity(this.size + 1);
        this.values[this.size++] = value;
        return true;
    }

    @Override
    public boolean add(E value, int index) {
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            ensureCapacity(this.size + 1);
            System.arraycopy(this.values, index, this.values, index + 1, size - index);
            this.values[index] = value;
            this.size++;
            return true;
        }
    }

    @Override
    public E get(int index) {
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.values[index];
        }
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public E remove(int index) {
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            E returnValue = this.get(index);
            System.arraycopy(this.values, index + 1, this.values, index, size - index);
            size--;
            return returnValue;
        }
    }

    @Override
    public E remove(E value) {
        return remove(indexOf(value));
    }

    @Override
    public boolean removeAll(GenericArrayList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.get(i));
        }
        return true;
    }

    @Override
    public E set(E value, int index) {
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            this.values[index] = value;
            return this.values[index];
        }
    }

    @Override
    public boolean addAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            ensureCapacity(this.size + 1);
            add(list.get(i));
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            this.values[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toInclusive) {
        AbstractGenericList<E> list = new GenericArrayList<>((toInclusive - fromInclusive) + 1);
        for (int i = fromInclusive; i <= toInclusive; i++) {
            list.add(this.values[i]);
        }
        return list;
    }

    private void ensureCapacity(int size) {
        if (size >= capacity) {
            this.capacity <<= 1;
            increaseCapacity(this.capacity);
        }
    }

    private void increaseCapacity(int capacity) {
        this.values = Arrays.copyOf(this.values, capacity);
    }
}
