package com.epam.jf.zakomornyy.homework.task17;

import com.epam.jf.zakomornyy.homework.task16.GenericList;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {
    protected int size = 0;

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    public int size() {
        return size;
    }

    public boolean containsAll(GenericList<?> c) {
        for (int i = 0; i < c.size(); i++) {
            if (!contains(c.get(i)))
                return false;
        }
        return true;
    }

    public boolean addAll(GenericList<? extends E> c) {
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
        return true;
    }

    public boolean addAll(int index, GenericList<? extends E> c) {
        for (int i = 0; i < c.size(); i++) {
            add(index++, c.get(i));
        }
        return true;
    }

    public boolean removeAll(GenericList<?> c) {
        for (int i = 0; i < c.size(); i++) {
            remove(c.get(i));
        }
        return true;
    }

    public boolean retainAll(GenericList<?> c) {
        for (int i = 0; i < size(); i++) {
            if (!c.contains(this.get(i))) {
                remove(this.get(i));
            }
        }
        return true;
    }

    public void clear() {
        for (int i = size() - 1; i >= 0; i--) {
            remove(i);
        }
    }






}


