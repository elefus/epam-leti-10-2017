package com.epam.jf.polovinkin.homework.task17;

import com.epam.jf.polovinkin.homework.task16.GenericList;

import javax.naming.OperationNotSupportedException;
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
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index == -1) {
            throw new IllegalArgumentException("No object was found.");
        }
        return true;
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
            AbstractGenericList.this.add(to, value);
            to++;
            return true;
        }

        @Override
        public boolean add(int index, E value) {
            AbstractGenericList.this.add(index + from, value);
            to++;
            return true;
        }

        @Override
        public E get(int index) {
            return AbstractGenericList.this.get(index + from);
        }

        @Override
        public E set(int index, E value) {
            return AbstractGenericList.this.set(index + from, value);
        }

        @Override
        public E remove(int index) {
            E item = AbstractGenericList.this.remove(index + from);
            to--;
            return item;
        }

        @Override
        public void clear() {
            for (int i = from; i < to; to--) {
                AbstractGenericList.this.remove(from);
            }
        }

        @Override
        public boolean addAll(GenericList<? extends E> list) {
            for (int i = 0; i < list.size(); i++, to++) {
                AbstractGenericList.this.add(to + i, list.get(i));
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
        public boolean remove(E value) {
            E remove = AbstractGenericList.this.remove(from + indexOf(value));
            to--;
            return true;
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
            if (index < 0 || index >= from - to) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override
        protected void checkIndexes(int... indexes) {
            for (int index : indexes) {
                checkIndex(index);
            }
        }

        @Override
        public GenericList<E> subList(int fromInclusive, int toInclusive) throws OperationNotSupportedException {
            throw new OperationNotSupportedException();
        }
    }
}
