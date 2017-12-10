package com.epam.jf.bavtovich.homework.task17;

import com.epam.jf.bavtovich.homework.task16.GenericList;

public class GenericLinkedList<E> extends AbstractGenericList<E> {

    private Node<E> first;
    private Node<E> last;

    public GenericLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    public GenericLinkedList(GenericList<? extends E> c) {
        this();
        addAll(c);
    }

    private Node<E> node(int index) {
        isValidIndex(index);
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> x = this.first;

        for (int i = 0; i < size; i++) {
            if (element.equals(x.item)) {
                return true;
            }
            x = x.next;
        }
        return false;
    }

    @Override
    public boolean add(int index, E element) {
        if (size == 0) {
            first = new Node<>(null, element, null);
            last = first;
        } else if (index == size - 1) {
            last = new Node<>(last, element, null);
            last.prev.next = last;
        } else if (index == 0) {
            first = new Node<>(null, element, first);
            first.next.prev = first;
        } else {
            isValidIndex(index);
            Node<E> oldNode = node(index);
            Node<E> newNode = new Node<>(oldNode.prev, element, oldNode);
            newNode.next.prev = newNode;
        }
        size++;

        return true;
    }

    @Override
    public E remove(E element) {
        Node<E> x = first;
        for (int i = 0; i < size; i++) {
            if (x.item.equals(element)) {
                if (i == 0) {
                    first = x.next;
                    first.prev = null;
                } else if (i == size - 1) {
                    last = x.prev;
                    last.next = null;
                } else {
                    x.next.prev = x.prev;
                }
                size--;
                return element;
            }
            x = x.next;
        }
        return null;
    }

    @Override
    public E remove(int index) {
        isValidIndex(index);
        Node<E> forRemoving = node(index);
        if (index == 0) {
            first = forRemoving.next;
            first.prev = null;
        } else if (index == size - 1) {
            last = forRemoving.prev;
            last.next = null;
        } else {
            forRemoving.prev.next = forRemoving.next;
            forRemoving.next.prev = forRemoving.prev;
        }
        size--;
        return forRemoving.item;
    }

    @Override
    public boolean addAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
        return true;
    }

    @Override
    public E get(int index) {
        isValidIndex(index);
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        isValidIndex(index);
        E temp = node(index).item;
        node(index).item = element;
        return temp;
    }

    @Override
    public GenericList<? extends E> subList(int fromIndex, int toIndex) {
        GenericLinkedList<E> newList = new GenericLinkedList<>();
        Node<E> x = node(fromIndex);
        for (int i = 0; i < toIndex - fromIndex; i++) {
            newList.add(x.item);
            x = x.next;
        }
        return newList;
    }

    void addFirst(E elem) {
        add(0, elem);
    }


    void addLast(E elem) {
        add(elem);
    }

    E getFirst() {
        return first.item;
    }

    E getLast() {
        return last.item;
    }

    E removeFirst() {
        return remove(0);
    }

    E removeLast() {
        return remove(size-1);
    }

    private static class Node<E> {

        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private void isValidIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

}
