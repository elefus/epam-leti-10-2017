package com.epam.jf.Shabashov.homework.task17;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 *
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericList<E> {

    void add(E element);

    void add(int index, E element);

    boolean addAll(GenericList<? extends E> list);

    boolean addAll(int index, GenericList<? extends E> list);

    boolean contains(E item);

    boolean containsAll(GenericList<? extends E> list);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    boolean remove(E item);

    boolean removeAll(GenericList<? extends E> list);

    E[] toArray();

    AbstractGenericList<E> subList(int fromIndex, int toIndex);

    int size();

    boolean isEmpty();

    void clear();

}