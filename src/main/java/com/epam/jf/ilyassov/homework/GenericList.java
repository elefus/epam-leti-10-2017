package com.epam.jf.ilyassov.homework;


public interface GenericList<E> {

    boolean add(E value);

    boolean add(E value,int index);

    E get(int index);

    E set(int index,E value);

    boolean isEmpty();

    int size();

    boolean contains();

    boolean containsAll(GenericList<?extends E> anotherList);

    E remove(int index);

    E remove(E value);

    boolean removeAll(E value);

    boolean removeAll(GenericList<?extends E> anotherList);

    boolean addAll(GenericList<? extends E> anotherList);

    void clear();

    int indexOf(E value);

    int lastIndexOf(E value);

    GenericList<? extends E> sublist(int fromIndex,int toIndex);

}