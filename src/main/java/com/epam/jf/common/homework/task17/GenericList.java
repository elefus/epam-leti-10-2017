package com.epam.jf.common.homework.task17;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 *
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericList<E> {

    int size();

    boolean isEmpty();

    boolean contains(E value);

    boolean add(E value);

    boolean add(E value, int index);

    E remove(E value);

    void clear();

    E get(int index);

    E set(E value, int index);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);


}