package com.epam.jf.burachenko.homework.task17;

import com.epam.jf.burachenko.homework.task16.GenericList;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {
    class Element<E> {
        private Element<E> prev;
        private E data;
        private Element<E> next;

        Element(Element<E> prev, E data, Element<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    private Element<E> head;
    private Element<E> tail;

    public GenericLinkedList() {}

    public GenericLinkedList(GenericList<? extends E> c) {
        super(c);
    }

    @Override
    public boolean add(E value) {
        if(size == 0) {
            head = new Element<>(null, value, null);
            tail = head;
        }
        else {
            Element<E> newElement = new Element<>(tail, value, null);
            tail.next = newElement;
            tail = newElement;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(E value, int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            head.prev = new Element<>(null, value, head);
            head = head.prev;
            return true;
        }

        Element<E> pointer = seekElement(index);
        Element<E> newElement = new Element<>(pointer.prev, value, pointer);
        pointer.prev.next = newElement;
        pointer.prev = newElement;
        return true;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return seekElement(index).data;
    }

    @Override
    public E set(E value, int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> pointer = seekElement(index);
        E copy = pointer.data;
        pointer.data = value;
        return copy;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Element<E> pointer = head;
        for (int i = 0; i < size; i++) {
            array[i] = pointer.data;
            pointer = pointer.next;
        }
        return array;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(size == 1) {
            E copy = head.data;

            head.data = null;
            head = null;
            tail = null;

            size = 0;
            return copy;
        }

        E copy;
        if(index == 0) {
            copy = head.data;
            head = head.next;
            head.prev.next = null;
        }
        else {
            if(index == size - 1) {
                copy = tail.data;
                tail = tail.prev;
                tail.next.prev = null;
            }
            else {
                Element<E> pointer = seekElement(index);
                copy = pointer.data;

                pointer.prev.next = pointer.next;
                pointer.next.prev = pointer.prev;

                pointer.prev = null;
                pointer.data = null;
                pointer.next = null;
            }
        }
        size--;
        return copy;
    }

    @Override
    public void clear() {
        while (size > 0) {
            remove(0);
        }
    }

    @Override
    public int indexOf(@NotNull E value) {
        Element<E> pointer = head;
        for (int i = 0; i < size; i++) {
            if(value.equals(pointer.data)) {
                return i;
            }
            pointer = pointer.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(@NotNull E value) {
        Element<E> pointer = tail;
        for (int i = size - 1; i >= 0; i--) {
            if(value.equals(pointer.data)) {
                return i;
            }
            pointer = pointer.prev;
        }
        return -1;
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toInclusive) {
        if(fromInclusive < 0 || fromInclusive >= size || toInclusive < 0 || toInclusive >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(fromInclusive > toInclusive) {
            throw new IllegalArgumentException("Left border must be less or equal right border");
        }

        GenericList<E> subList = new GenericLinkedList<>();
        Element<E> pointer = seekElement(fromInclusive);
        for (int i = fromInclusive; i <= toInclusive; i++) {
            subList.add(pointer.data);
            pointer = pointer.next;
        }

        return subList;
    }

    private Element<E> seekElement(int index) {
        Element<E> pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }
}
