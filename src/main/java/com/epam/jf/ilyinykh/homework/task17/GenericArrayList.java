package com.epam.jf.ilyinykh.homework.task17;

import com.epam.jf.ilyinykh.homework.task16.GenericList;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {
    public GenericArrayList() {
        super();
        data = allocate(DEFAULT_CAPACITY);
    }

    public GenericArrayList(GenericList<? extends E> list) {
        this();
        addAll(list);
    }

    @Override
    public boolean add(E value) {
        ensureCapacity(size + 1);

        data[size] = value;
        size++;

        return true;
    }

    @Override
    public boolean add(E value, int index) {
        ensureCapacity(size + 1);
        checkIndex(index);

        E[] newData = allocate(size + 1);
        newData[index] = value;

        System.arraycopy(data, 0, newData, 0, index);
        System.arraycopy(data, index, newData, index + 1, size - index);

        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public E set(E value, int index) {
        checkIndex(index);
        E current = data[index];
        data[index] = value;
        return current;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E old = data[index];

        E[] newData = allocate(size - 1);

        System.arraycopy(data, 0, newData, 0, index);
        System.arraycopy(data, index + 1, newData, index, size - index);

        return old;
    }

    @Override
    public void clear() {
        size = 0;
        data = allocate(DEFAULT_CAPACITY);
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toInclusive) {
        checkIndexes(fromInclusive, toInclusive);
        if (toInclusive < fromInclusive) {
            throw new IllegalArgumentException("to greater than from");
        }

        GenericArrayList<E> list = new GenericArrayList<>();
        for (int i = fromInclusive; i <= toInclusive; i++) {
            list.add(get(i));
        }

        return list;
    }

    public void trimToSize() {
        E[] newData = allocate(size);

        System.arraycopy(data, 0, newData, 0, size);

        data = newData;
    }

    private final int DEFAULT_CAPACITY = 4;

    private E[] data;

    @SuppressWarnings("unchecked")
    private E[] allocate(int n) {
        return (E[]) new Object[n];
    }

    private void ensureCapacity(int n) {
        if (data.length < n) {
            int newSize = data.length;
            while (newSize < n) {
                newSize *= 2;
            }

            E[] newData = allocate(newSize);

            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
}
