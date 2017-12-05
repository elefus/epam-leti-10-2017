package com.epam.jf.volkov.homework.task17;

import com.epam.jf.volkov.homework.task16.GenericList;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {

    public abstract boolean add(E value);

    public abstract boolean add(E value, int index);

    public abstract boolean addAll(GenericList<? extends E> list);

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

    public abstract GenericList<? super E> subList(int from, int to);

    public abstract E[] toArray();
}
