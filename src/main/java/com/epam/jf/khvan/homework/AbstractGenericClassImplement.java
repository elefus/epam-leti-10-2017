package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.task16.GenericList;

import java.util.Arrays;
import java.util.Comparator;

public class AbstractGenericClassImplement<E> implements GenericListImplementation<E> {

    private int size;

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
    public boolean contains(E value) {
        return false;
    }

    @Override
    public boolean containsAll(GenericListImplementation<? extends E> list) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E value) {
        return false;
    }

    @Override
    public boolean removeAll(GenericListImplementation<? extends E> list) {
        return false;
    }

    @Override
    public E set(E value, int index) {
        return null;
    }

    @Override
    public boolean addAll(GenericListImplementation<? extends E> list) {
        return false;
    }

    @Override
    public void clear() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(E value) {
        return 0;
    }

    @Override
    public int lastIndexOf(E value) {
        return 0;
    }

}

