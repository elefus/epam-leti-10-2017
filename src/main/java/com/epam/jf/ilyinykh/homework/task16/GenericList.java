package com.epam.jf.ilyinykh.homework.task16;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericList<E> {
    boolean add(E value);

    boolean add(E value, int index);

    boolean addAll(GenericList<? extends E> list);

    E get(int index);

    E set(E value, int index);

    boolean contains(E value);

    boolean containsAll(GenericList<? extends E> list);

    E remove(int index);

    E remove(E value);

    boolean removeAll(GenericList<? extends E> list);

    void clear();

    int size();

    boolean isEmpty();

    int indexOf(E value);

    int lastIndexOf(E value);

    GenericList<E> subList(int fromInclusive, int toInclusive);
}