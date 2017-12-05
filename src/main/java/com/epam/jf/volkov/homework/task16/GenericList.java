package com.epam.jf.volkov.homework.task16;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericList<E> /*extends com.epam.jf.common.homework.task16.GenericList*/ {

    boolean add(E value);

    boolean add(E value, int index);

    boolean addAll(GenericList<? extends E> list);

    E get(int index);

    boolean contains(E value);

    boolean containsAll(GenericList<? extends E> list);

    E remove(int index);

    boolean removeB(int index); //Решил добавить также реализации с return bool

    E remove(E value);

    boolean removeB(Object value);

    boolean removeAll(GenericList<? extends E> list);

    E set(E value, int index);

    void clear();

    int size();

    boolean isEmpty();

    int indexOf(E value);

    int lastIndexOf(E value);

    GenericList<? super E> subList(int from, int to);

    E[] toArray();
}