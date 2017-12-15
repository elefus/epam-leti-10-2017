package com.epam.jf.guba.homework;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public interface GenericList<E> {


    int size();

    boolean isEmpty();

    boolean contains(E element);

    Iterator<E> iterator();

    E[] toArray();

    boolean add(E element);

    boolean add(int index, E element);

    E remove(E element);

    E remove(int index);

    boolean removeAll(GenericList<? extends E> list);

    boolean containsAll(GenericList<? extends E> collection);

    boolean addAll(GenericList<? extends E> elements);

    boolean addAll(int index, GenericList<? extends E> elements);

    void clear();

    E get(int index);

    E set(int index, E element);

    int indexOf(E element);

    int lastIndexOf(E element);

    GenericList<E> sublist(int fromIndex, int toIndex);

    void sort(Comparator<? super E> list);


}
