package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.task16.GenericList;

import java.util.Comparator;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericListImplementation<E> {

     boolean add(E value);

     boolean add(E value, int index);

     E get(int index);

     boolean contains(E value);

     boolean containsAll(GenericListImplementation< ? extends E> list);

     E remove(int index);

     E remove(E value);

     boolean removeAll(GenericListImplementation< ? extends E> list);

     E set(E value, int index);

     boolean addAll(GenericListImplementation< ? extends E> list);

     void clear();

     int size();

     boolean isEmpty();

     int indexOf(E value);

     int lastIndexOf(E value);

     GenericList<E> subList(int fromInclusive, int toInclusive);

     Object[] toArray();

     void sort(Comparator<? super E> c);
}