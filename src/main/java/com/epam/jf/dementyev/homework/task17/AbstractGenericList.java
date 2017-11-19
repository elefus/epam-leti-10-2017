package com.epam.jf.dementyev.homework.task17;

import com.epam.jf.dementyev.homework.task16.GenericList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {

    protected int size = 0;

    @Override
    public boolean add(E value) {
        return add(value, size);
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
    public E remove(E value) {
        int index = indexOf(value);
        if (index < 0) {
            return null;
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
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        if (size == 0) {
            return new Object[0];
        }
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        for (int i = 0; i < size; i++) {
            set((E) a[i], i);
        }
    }
}
