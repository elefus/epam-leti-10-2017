package com.epam.jf.burachenko.homework.task17;

import com.epam.jf.burachenko.homework.task16.GenericList;

import java.util.Comparator;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {
    E[] values;

    @Override
    public boolean add(E value) {
        return false;
    }

    @Override
    public boolean add(E value, int index) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(E value, int index) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(E value) {
        return 0;
    }

    @Override
    public int lastIndexOf(E value) {
        return 0;
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toInclusive) {
        return null;
    }

    @Override
    public void sort(Comparator<? super E> c) {

    }
}
