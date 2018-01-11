package com.epam.jf.polovinkin.homework.task16;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericList<E> {

    int size();

    boolean add(E element);

    boolean add(int index, E element);

    boolean addAll(GenericList<? extends E> list);

    E remove(int index);

    boolean remove(E element);

    boolean removeAll(GenericList<E> list);

    void clear();

    boolean contains(E element);

    boolean containsAll(GenericList<E> list);

    boolean isEmpty();

    E get(int index);

    E set(int index, E element);

    int indexOf(E element);

    int lastIndexOf(E element);

    GenericList<? extends E> subList(int fromIndex, int toIndex);
}