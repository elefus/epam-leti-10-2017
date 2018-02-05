package com.epam.jf.volkov.homework.task17;

import com.epam.jf.volkov.homework.task16.GenericList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {

    private int size;

    AbstractGenericList() {
        size = 0;
    }

    @Override
    public boolean add(E value) {
        return add(value, size);
    }

    public abstract boolean add(E value, int index);

    @Override
    public boolean addAll(GenericList<E> list) {
        Iterator<E> iter = list.iterator();
        while (iter.hasNext()) {
            if (!add(iter.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract E get(int index);

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public boolean containsAll(GenericList<E> list) {
        Iterator<E> iter = list.iterator();
        while (iter.hasNext()) {
            if (!contains(iter.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract E remove(int index);

    @Override
    public E remove(E value) {
        return remove(indexOf(value));
    }

    @Override
    public boolean removeAll(GenericList<E> list) {
        try {
            Iterator<E> iter = list.iterator();
            while (iter.hasNext()) {
                remove(iter.next());
            }
            return true;
        } catch (Exception ex) {
            //TODO backup mech
            return false;
        }
    }

    public abstract E set(E value, int index);

    @Override
    public void clear() {
        size = 0;
    }

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
        GenericListIterator<E> iter = listIterator();
        while (iter.hasNext()) {
            if (iter.next().equals(value)) {
                return iter.getLastRet();
            }
        }
        return -1;
    }

    public abstract int lastIndexOf(E value);

    public abstract GenericList<E> subList(int from, int to);

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Iterator<E> iter = iterator();
        for (int i = 0; i < array.length; i++) {
            if (iter.hasNext()) {
                array[i] = iter.next();
            }
        }
        return array;
    }

    protected boolean isCorrectIndex(int index) {
        return (index < size && index >= 0);
    }

    /////////////////////////////////////

    public GenericListIterator<E> listIterator() {
        return listIterator(0);
    }

    public GenericListIterator<E> listIterator(int startIndex) {
        return new GenericListIterator<E>(startIndex);
    }

    public Iterator<E> iterator() {
        return iterator(0);
    }

    public Iterator<E> iterator(int startIindex) {
        return new GenericListIterator<E>(startIindex);
    }

    private class GenericListIterator<E> implements Iterator<E> { //Затенение параметризации, костыль ниже

        int cursor;
        int lastRet;

        final int STEP;

        GenericListIterator (int startIndex) {
            cursor = startIndex;
            lastRet = -1;
            STEP = 1;
        }

        public E next() {
            try {
                int index = cursor;
                Object value = get(index); //Костыль
                lastRet = index;
                index += STEP;
                return (E) value; //Костыль
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public int getCursor() {
            return cursor;
        }

        public int getLastRet() {
            return lastRet;
        }

        public boolean hasNext() {
            return cursor < size;
        }
    }
}
