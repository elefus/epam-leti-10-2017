package com.epam.jf.ilyinykh.homework.task17;

import com.epam.jf.ilyinykh.homework.task16.GenericList;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {
    @Override
    public boolean addAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
        return true;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(value, get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean containsAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int lastIndexOf(E value) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(value, get(i))) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public E remove(E value) {
        int index = indexOf(value);
        if (index == -1) {
            throw new IllegalArgumentException("No object was found.");
        }
        return remove(index);
    }

    @Override
    public boolean removeAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.get(i));
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected int size = 0;

    protected void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    protected void checkIndexes(int... indexes) {
        for (int index : indexes) {
            checkIndex(index);
        }
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toInclusive) {
        return new SubList(fromInclusive,toInclusive);
    }

    private class SubList extends AbstractGenericList<E> {
        private int from;
        private int to;

        SubList(int fromInclusive, int toInclusive) {
            AbstractGenericList.this.checkIndex(fromInclusive);
            AbstractGenericList.this.checkIndex(toInclusive);
            if (fromInclusive > toInclusive) {
                throw new IllegalArgumentException("To cannot be less than from.");
            }

            from = fromInclusive;
            to = toInclusive;
        }

        @Override
        public boolean add(Object value) {
            return AbstractGenericList.this.add((E) value, to);
        }

        @Override
        public boolean add(Object value, int index) {
            return AbstractGenericList.this.add((E) value, index + from);
        }

        @Override
        public E get(int index) {
            return AbstractGenericList.this.get(index + from);
        }

        @Override
        public E set(Object value, int index) {
            return AbstractGenericList.this.set((E) value, index + from);
        }

        @Override
        public E remove(int index) {
            return AbstractGenericList.this.remove(index + from);
        }

        @Override
        public void clear() {
            for (int i = from; i < to; i++) {
                AbstractGenericList.this.remove(i);
            }
        }
    }
}
