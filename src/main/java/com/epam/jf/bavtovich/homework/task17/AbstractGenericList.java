package com.epam.jf.bavtovich.homework.task17;

import com.epam.jf.bavtovich.homework.task16.GenericList;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {

    protected int size;

    AbstractGenericList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E elem) {
        add(size - 1, elem);
        return true;
    }

    @Override
    public boolean containsAll(GenericList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(GenericList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.get(i));
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }
}