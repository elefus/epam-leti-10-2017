package com.epam.jf.bavtovich.homework.task16;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericList<E> {

    int size();

    boolean isEmpty();

    boolean contains(E element);

    boolean add(E element);

    boolean add(int index, E element);

    E remove(E element);

    E remove(int index);

    boolean containsAll(GenericList<E> list);

    boolean addAll(GenericList<? extends E> list);

    boolean removeAll(GenericList<E> list);

    void clear();

    E get(int index);

    E set(int index, E element);

    int indexOf(E element);

    int lastIndexOf(E element);

    GenericList<? extends E> subList(int fromIndex, int toIndex);
}
