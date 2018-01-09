package com.epam.jf.kozlov.homework.task17;

import com.epam.jf.kozlov.homework.task16.GenericList;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {

    protected int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public boolean containsAll(GenericList<? extends E> fromList) {
        for (int i = 0; i < fromList.size(); i++) {
            if (!this.contains(fromList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean equeals(GenericList<? extends E> list) {
        if (this == list) {
            return true;
        }
        if (this.size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

}
