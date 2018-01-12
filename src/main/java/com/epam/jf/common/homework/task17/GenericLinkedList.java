package com.epam.jf.common.homework.task17;

import com.epam.jf.khvan.homework.AbstractGenericClassImplement;
import com.epam.jf.khvan.homework.GenericListImplementation;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericClassImplement<E> {

    private int size;

    @Override
    public boolean add(E value) {
        return super.add(value);
    }

    @Override
    public boolean add(E value, int index) {
        return super.add(value, index);
    }

    @Override
    public E get(int index) {
        return super.get(index);
    }

    @Override
    public boolean contains(E value) {
        return super.contains(value);
    }

    @Override
    public boolean containsAll(GenericListImplementation<? extends E> list) {
        return super.containsAll(list);
    }

    @Override
    public E remove(int index) {
        return super.remove(index);
    }

    @Override
    public boolean remove(E value) {
        return super.remove(value);
    }

    @Override
    public boolean removeAll(GenericListImplementation<? extends E> list) {
        return super.removeAll(list);
    }

    @Override
    public E set(E value, int index) {
        return super.set(value, index);
    }

    @Override
    public boolean addAll(GenericListImplementation<? extends E> list) {
        return super.addAll(list);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int indexOf(E value) {
        return super.indexOf(value);
    }

    @Override
    public int lastIndexOf(E value) {
        return super.lastIndexOf(value);
    }
}
