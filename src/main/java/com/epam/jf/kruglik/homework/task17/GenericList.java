package com.epam.jf.kruglik.homework.task17;

public interface GenericList<E> {
    int size();
    boolean isEmpty();
    E get(int index);
    int indexOf(Object value);
    int lastIndexOf(Object value);
    E set (int index, E element);
    void add(E element);
    void add(int index, E value);
    void clear();
    E remove(int index);
    E remove(E value);
}

