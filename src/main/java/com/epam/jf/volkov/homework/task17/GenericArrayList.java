package com.epam.jf.volkov.homework.task17;

import com.epam.jf.volkov.homework.task17.AbstractGenericList;
import com.epam.jf.volkov.homework.task16.GenericList;

import java.util.Iterator;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    protected Object[] values;
    private int size;

    GenericArrayList() {
        values = new Object[10];
    }

    GenericArrayList(int length) {
        values = new Object[length];
    }

    GenericArrayList(GenericList<E> list) {
        addAll(list);
    }

    public boolean add(E value, int index){

    }

    public E get(int index) {
        return (E) values[index];
    }

    public E remove(int index) {

    }

    public E set(E value, int index) {
        E temp = (E) values[index];
        values[index] = value;
        return temp;
    }

    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public GenericList<E> subList(int from, int to) {

    }
}
