package com.epam.jf.volkov.homework.task16;

import java.util.Iterator;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericList<E> /*extends com.epam.jf.common.homework.task16.GenericList*/ {

    boolean add(E value);

    boolean add(E value, int index);

    boolean addAll(GenericList<E> list);

    E get(int index);

    boolean contains(E value);

    boolean containsAll(GenericList<E> list);

    E remove(int index);

    E remove(E value);

    boolean removeAll(GenericList<E> list);

    E set(E value, int index);

    void clear();

    int size();

    boolean isEmpty();

    int indexOf(E value);

    int lastIndexOf(E value);

    GenericList<E> subList(int from, int to);

    Object[] toArray();

    Iterator<E> iterator();

    Iterator<E> iterator(int startIindex);
}