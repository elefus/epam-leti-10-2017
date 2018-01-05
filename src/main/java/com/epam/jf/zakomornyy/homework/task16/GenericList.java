package com.epam.jf.zakomornyy.homework.task16;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericList<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Object[] toArray();

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(GenericList<?> c);

    boolean addAll(GenericList<? extends E> c);

    boolean addAll(int index, GenericList<? extends E> c);

    boolean removeAll(GenericList<?> c);

    boolean retainAll(GenericList<?> c);

    void clear();

    boolean equals(Object o);

    int hashCode();

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    GenericList<E> subList(int fromIndex, int toIndex);

}