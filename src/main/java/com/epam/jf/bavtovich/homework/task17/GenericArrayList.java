package com.epam.jf.bavtovich.homework.task17;

import com.epam.jf.bavtovich.homework.task16.GenericList;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {


    private int capacity;
    private E[] values;

    public GenericArrayList() {
        super();
        values = (E[]) new Object[16];
        capacity = values.length;
        size = 0;
    }

    public GenericArrayList(int capacity) {
        super();
        values = (E[]) new Object[capacity];
        size = 0;
    }

    public GenericArrayList(GenericArrayList<? extends E> list) {
        super();
        values = list.values.clone();
        capacity = values.length;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        for (E elem: values) {
            if (element.equals(elem)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || size < index) {
            return false;
        }
        checkSizeAndResize(1);
        System.arraycopy(values, index, values, index + 1, size - index + 1);
        values[index] = element;
        size++;
        return true;
    }

    @Override
    public boolean addAll(GenericList<? extends E> list) {
        checkSizeAndResize(list.size());
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
        return true;
    }

    @Override
    public E remove(E element) {
        while (contains(element)) {
            remove(indexOf(element));
        }
        return element;
    }

    @Override
    public E remove(int index) {
        isValidIndex(index);
        E value = values[index];
        System.arraycopy(values, index + 1, values, index, size - index + 1);
        size--;
        return value;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public E set(int index, E element) {
        isValidIndex(index);
        values[index] = element;
        return element;
    }

    @Override
    public GenericList<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < toIndex) {
            isValidIndex(fromIndex);
            isValidIndex(toIndex);
        }
        GenericArrayList<E> list = new GenericArrayList<E>();
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(get(i));
        }
        return list;
    }

    private void checkSizeAndResize(int numAddElements) {
        if (size + numAddElements > capacity) {
            int temp = (size + numAddElements > (int) (1.5 * capacity))
                    ? size + numAddElements
                    : (int) (2 * capacity);
            E[] buff = (E[]) new Object[temp];
            System.arraycopy(values, 0, buff,0, size);
            values = buff;
        }
    }

    private void isValidIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
}