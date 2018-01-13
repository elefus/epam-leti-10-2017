package com.epam.jf.zakomornyy.homework.task17;

import com.epam.jf.zakomornyy.homework.task16.GenericList;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {

    private Node<E> first;

    private Node<E> last ;

    public GenericLinkedList() {
    }

    public GenericLinkedList(GenericList<? extends E> c) {
        addAll(c);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<E> elem = first;
        for(int i = 0; i < size(); i++) {
            array[i] = elem.item;
            elem = elem.next;
        }
        return array;
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(last, e , null);
        if(last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for(Node<E> elem = first; elem != null; elem = elem.next) {
            if(elem.item.equals(o)) {
                if(elem.prev == null){
                    first = elem.next;
                    elem.next.prev = null;
                } else if(elem.next == null) {
                    last.prev = last;
                    last.next = null;
                } else {
                    (elem.prev).next = elem.next;
                    (elem.next).prev = elem.prev;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        Node<E> elem = first;
        for(int i = 0; i < size(); i++) {
            if(i == index) {
                return elem.item;
            }
            elem = elem.next;
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        Node<E> elem = first;
        for(int i = 0; i < size; i++) {
            if(i == index) {
                E prevElement = elem.item;
                elem.item = element;
                return prevElement;
            }
            elem = elem.next;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        Node<E> elem = first;
        for(int i = 0; i < size; i++) {
            if(i == index) {
                Node<E> newNode = new Node<>(elem.prev, element, elem);
                if(index == 0) {
                    first.prev = newNode;
                    first = newNode;
                } else {
                    (elem.prev).next = newNode;
                    elem.prev = newNode;
                }
                size++;
                return;
            }
            elem = elem.next;
        }
    }

    @Override
    public E remove(int index) {
        Node<E> elem = first;
        for(int i = 0; i < size; i++) {
            if(i == index) {
                if(index == 0) {
                    first = first.next;
                    first.prev = null;
                } else if(index == size - 1) {
                    last = last.prev;
                    last.next = null;
                } else {
                    (elem.prev).next = elem.next;
                    (elem.next).prev = elem.prev;
                }
                size--;
                return elem.item;
            }
            elem = elem.next;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> elem = first;
        for(int i = 0; i < size; i++) {
            if(elem.item.equals(o)) {
                return i;
            }
            elem = elem.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> elem = last;
        for(int i = size - 1; i >= 0; i--) {
            if(elem.item.equals(o)) {
                return i;
            }
            elem = elem.prev;
        }
        return -1;
    }

    @Override
    public GenericList<E> subList(int fromIndex, int toIndex) {
        Node<E> elem = first;
        GenericArrayList<E> list = new GenericArrayList<>();
        for(int i = 0; i <= toIndex; i++) {
            if(i >= fromIndex) {
                list.add(elem.item);
            }
            elem = elem.next;
        }
        return list;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
