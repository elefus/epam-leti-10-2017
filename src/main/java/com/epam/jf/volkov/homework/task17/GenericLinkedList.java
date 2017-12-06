package com.epam.jf.volkov.homework.task17;

import com.epam.jf.volkov.homework.task16.GenericList;

import java.util.Iterator;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> { //मुझे डर है कि मेरा हिंदू कोड असाध्य है

    private int size;
    private LinkedElement<E> first = null;
    private LinkedElement<E> last = null;

    GenericLinkedList() {}

    GenericLinkedList(GenericList<E> list) {
        addAll(list);
        last = first.getNext();
    }

    @Override
    public boolean add(E value, int index) {
        if (index == size || isCorrectIndex(index)) {
            if (index == 0) {
                LinkedElement<E> temp = first;
                first = new LinkedElement<E>(value, null, temp);
                temp.setPrev(first);
            } else if (index == size) {
                LinkedElement<E> temp = last;
                last = new LinkedElement<E>(value, temp, null);
                temp.setNext(last);
            } else {
                LinkedElement<E> temp = getElement(index);
                LinkedElement<E> newElement = new LinkedElement<E>(value, temp.getPrev(), temp);
                newElement.getPrev().setNext(newElement);
                temp.setPrev(newElement);
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        return getElement(index).getValue();
    }

    private LinkedElement<E> getElement(int index) {
        if (isCorrectIndex(index)) {
            return getElement(first, index);
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    private LinkedElement<E> getElement(LinkedElement<E> start, int step) {
        if (step == 0) {
            return start;
        } else {
            return getElement(start.getNext(), step - 1);
        }
    }

    @Override
    public E remove(int index) {
        if (isCorrectIndex(index)) {
            LinkedElement<E> temp = getElement(index);
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            return temp.getValue();
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    @Override
    public E set(E value, int index) {
        LinkedElement<E> temp = getElement(index);
        LinkedElement<E> newElement = new LinkedElement<E>(value, temp.getPrev(), temp.getNext());
        newElement.getPrev().setNext(newElement);
        newElement.getNext().setPrev(newElement);
        return temp.getValue();
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public GenericList<E> subList(int from, int to) {
        if (to > from && isCorrectIndex(from) && isCorrectIndex(to)) {
            Iterator<E> iter = iterator(from);
            GenericList<E> sub = new GenericLinkedList<E>();
            for (int i = from; i < to; i++) {
                sub.add(iter.next());
            }
            return sub;
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    ///////////////////////////////////////////////////

    private class LinkedElement<T> {

        private T value;
        private LinkedElement<T> prev;
        private LinkedElement<T> next;

        LinkedElement(T newValue) {
            value = newValue;
        }

        LinkedElement(T newValue, LinkedElement<T> prev, LinkedElement<T> next) {
            value = newValue;
            this.next = next;
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }

        public LinkedElement<T> getPrev() {
            return prev;
        }

        public void setPrev(LinkedElement<T> prev) {
            this.prev = prev;
        }

        public LinkedElement<T> getNext() {
            return next;
        }

        public void setNext(LinkedElement<T> next) {
            this.next = next;
        }
    }
}


