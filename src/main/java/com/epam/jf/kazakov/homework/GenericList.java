package com.epam.jf.kazakov.homework;

public interface GenericList<E> {

    int size();

    boolean isEmpty();

    boolean contains(E value);

    boolean add(E value);

    boolean add(E value, int index);

    boolean remove(E value);

    boolean containsAll(GenericList<?> list);

    void clear();

    E get(int index);

    E set(E value, int index);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);
}
