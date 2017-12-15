package com.epam.jf.guba.homework;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public interface GenericList<E> {


    int size();

    boolean isEmpty();

    boolean contains(Object element);

    Iterator<E> iterator();

    E[] toArray();

    boolean add(E element);

    boolean add(int index, E element);

    boolean remove(Object element);

    E remove(int index);

    boolean containsAll(Collection<?> collection);

    boolean addAll(Collection<? extends E> elements);

    boolean addAll(int index, Collection<? extends E> elements);

    void clear();

    E get(int index);

    E set(int index, E element);

    int indexOf(Object element);

    int lastIndexOf(Object element);

    GenericList<E> sublist(int fromIndex, int toIndex);

}
