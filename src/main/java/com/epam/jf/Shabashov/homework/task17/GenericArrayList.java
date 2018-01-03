package com.epam.jf.Shabashov.homework.task17;


import java.util.*;

/**
 * Реализация динамически расширяемого списка на основе массива.
 *
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {
    private Object[] values;
    private final int INITIAL_CAPACITY = 10;

    public GenericArrayList() {
        values = new Object[INITIAL_CAPACITY];
    }


    public GenericArrayList(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        values = new Object[capacity];
    }

    public GenericArrayList(E[] array) {
        if (array.length == 0) throw new IllegalArgumentException("Illegal array capacity: " + array.length);
        values = new Object[array.length];
        System.arraycopy(array, 0, values, 0, array.length);
        size+=array.length;
    }

    @Override
    public void add(E element) {
        if (size + 1 >= values.length) increaseSize();
        values[size++] = element;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        System.arraycopy(values, index, values, index + 1, size - index);
        size++;
        values[index] = element;
    }

    @Override
    public boolean addAll(GenericList<? extends E> list) {
        while (size + 1 + list.size() >= values.length) increaseSize();
        System.arraycopy(list.toArray(), 0, values, size, list.size());
        return true;
    }

    @Override
    public boolean addAll(int index, GenericList<? extends E> list) {
        checkIndex(index);
        while (size + 1 + list.size() >= values.length) increaseSize();
        Object[] helpArray = new Object[size - index];
        System.arraycopy(values, index, helpArray, 0, size() - index);
        System.arraycopy(list.toArray(), 0, values, index, list.size());
        System.arraycopy(helpArray, 0, values, index + list.size(), helpArray.length);
        size += list.size();
        return true;
    }

    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) return false;
        }
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) values[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E previous = (E) values[index];
        values[index] = element;
        return previous;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E previous = (E) values[index];
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        return previous;
    }

    @Override
    public boolean remove(E item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (values[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index < 0) return false;
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        return false;
    }

    @Override
    public boolean removeAll(GenericList<? extends E> list) {
        for (E e : list.toArray()) {
            remove(e);
        }
        return true;
    }

    @Override
    public E[] toArray() {
        return (E[]) Arrays.copyOf(values, size);
    }

    @Override
    public AbstractGenericList<E> subList(int fromIndex, int toIndex) {
        Object[] arr = new Object[toIndex-fromIndex+1];
        System.arraycopy(values,fromIndex,arr,0,toIndex-fromIndex+1);
        return new GenericArrayList<E>((E[]) arr);
    }

    @Override
    public void clear() {
        size=0;
    }

    private void increaseSize() {
        Object[] arr = new Object[values.length + (values.length >> 1)];
        System.arraycopy(values, 0, arr, 0, values.length);
        values = arr;
    }

    private String IndexOutException(int index) {
        return "Index : " + index + " size : " + size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
    }
}
