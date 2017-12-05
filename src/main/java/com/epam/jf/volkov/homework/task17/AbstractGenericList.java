package com.epam.jf.volkov.homework.task17;

import com.epam.jf.volkov.homework.task16.GenericList;
import java.util.Iterator;
import java.util.Arrays;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {

    private int listPointer;

    @Override
    public boolean add(E value) {
        return add(value, pointer);
    }

    public abstract boolean add(E value, int index);

    public boolean addAll(GenericList<? extends E> list) {

    }

    public abstract E get(int index);

    public abstract boolean contains(E value);

    public abstract boolean containsAll(GenericList<? extends E> list);

    public abstract E remove(int index);

    public abstract boolean removeB(int index); //Решил добавить также реализации с return bool

    public abstract E remove(E value);

    public abstract boolean removeB(Object value);

    public abstract boolean removeAll(GenericList<? extends E> list);

    public abstract E set(E value, int index);

    public abstract void clear();

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract int indexOf(E value);

    public abstract int lastIndexOf(E value);

    public abstract GenericList<E> subList(int from, int to);

    public abstract Object[] toArray();

    private class GenericListIterator implements Iterator<E> { //Честно украдено у Oracle

        int iterPointer;
        int prevIterPointer;

        GenericListIterator(int index) {
            iterPointer = index;
            prevIterPointer = -1;
        }

        public E next() {
            try {
                int index = iterPointer;
                E value = get(index);
                prevIterPointer = index++;
            } catch () {

            }
        }

        public boolean hasNext() {

        }
    }
}
