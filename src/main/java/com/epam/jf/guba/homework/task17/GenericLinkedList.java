package com.epam.jf.guba.homework.task17;

import com.epam.jf.guba.homework.GenericList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 *
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public E[] toArray() {
        return (E[]) new Object[0];
    }

    @Override
    public boolean add(E element) {
        return false;
    }

    @Override
    public boolean add(int index, E element) {
        return false;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> elements) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> elements) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object element) {
        return 0;
    }

    @Override
    public GenericList<E> sublist(int fromIndex, int toIndex) {
        return null;
    }
}
