package com.epam.jf.ilyinykh.homework.task17;

import com.epam.jf.ilyinykh.homework.task16.GenericList;

import javax.naming.OperationNotSupportedException;
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
    public GenericList<E> subList(int fromInclusive, int toInclusive) throws OperationNotSupportedException {
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
        public boolean add(E value) {
            return AbstractGenericList.this.add(value, to);
        }

        @Override
        public boolean add(E value, int index) {
            return AbstractGenericList.this.add(value, index + from);
        }

        @Override
        public E get(int index) {
            return AbstractGenericList.this.get(index + from);
        }

        @Override
        public E set(E value, int index) {
            return AbstractGenericList.this.set(value, index + from);
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

        @Override
        public boolean addAll(GenericList<? extends E> list) {
            for (int i = 0; i < list.size(); i++) {
                AbstractGenericList.this.add(list.get(i), to + i);
            }
            return true;
        }

        @Override
        public int indexOf(E value) {
            int index = AbstractGenericList.this.indexOf(value) - from;
            return index < 0 || index >= size() ? -1 : index;
        }

        @Override
        public boolean contains(E value) {
            for (int i = from; i < to; i++) {
                if (AbstractGenericList.this.get(i).equals(value)) {
                    return true;
                }
            }
            return false;
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
            for (int i = from; i < to; i++) {
                if (AbstractGenericList.this.get(i).equals(value)) {
                    index = i;
                }
            }
            return index;
        }

        @Override
        public E remove(E value) {
            return AbstractGenericList.this.remove(from + indexOf(value));
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
            return to - from;
        }

        @Override
        public boolean isEmpty() {
            return to - from == 0;
        }

        @Override
        protected void checkIndex(int index) {
            super.checkIndex(index);
        }

        @Override
        protected void checkIndexes(int... indexes) {
            super.checkIndexes(indexes);
        }

        @Override
        public GenericList<E> subList(int fromInclusive, int toInclusive) throws OperationNotSupportedException {
            throw new OperationNotSupportedException();
        }
    }
}
