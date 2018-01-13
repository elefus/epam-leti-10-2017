package com.epam.jf.savchenkov.homework;

public interface GenericList<E> {

    boolean add(E value);

    boolean add(E value, int index);

    int get(int index);

    boolean contains(E value);

    boolean containsAll(GenericList<E> list);

    E remove(int index);

    E set(E value, int index);

    boolean addAll(GenericList<E> list);

    void clear();

    int size();

    boolean isEmpty();

    int indexOf(E value);

    int lastIndexOf(E value);

    GenericList<E> subList(int fromInclusive, int toInclusive);
}