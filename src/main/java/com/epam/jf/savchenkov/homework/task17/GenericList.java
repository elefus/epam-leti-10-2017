package com.epam.jf.savchenkov.homework.task17;

public interface GenericList<E> {

    boolean add(E value);

    boolean add(E value, int index);

    E get(int index);

    boolean contains(E value);

    E remove(int index);

    E remove(E value);

    boolean removeAll(GenericArrayList<? extends E> list);

    E set(E value, int index);

    boolean addAll(GenericList<? extends  E> list);

    void clear();

    int size();

    boolean isEmpty();

    int indexOf(E value);

    int lastIndexOf(E value);

    GenericList<E> subList(int fromInclusive, int toInclusive);
}
