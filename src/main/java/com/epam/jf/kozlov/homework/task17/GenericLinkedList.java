package com.epam.jf.kozlov.homework.task17;

import com.epam.jf.kozlov.homework.task16.GenericList;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {

    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> previous;

        Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public GenericLinkedList() {}

    public GenericLinkedList(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == size - 1) {
            return tail.data;
        }
        Node<E> current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.data;
    }

    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == size - 1) {
            E temp = tail.data;
            tail.data = e;
            return temp;
        }
        Node<E> current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        E temp = current.data;
        current.data = e;
        return temp;
    }

    @Override
    public boolean add(E e) {
        if (head == null) {
            head = new Node<>(e, null, null);
            tail = head;
            size++;
        } else {
            Node<E> newNode = new Node<>(e, tail, null);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
        return true;
    }

    @Override
    public boolean add(E e, int index) {
        if (index == 0 && size == 0 || index == size - 1) {
            add(e);
        } else if (index < 0 || index >= size) {
            return false;
        }
        Node<E> current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        Node<E> currentPrev = current.previous;
        Node<E> newNode = new Node<>(e, currentPrev, current);
        currentPrev.next = newNode;
        current.previous = newNode;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        if (current == null) {
            return null;
        } else if (size == 1) {
            head = null;
            tail = null;
        } else if (current == head) {
            head = head.next;
            head.previous = null;
        } else if (current == tail) {
            tail = tail.previous;
            tail.next = null;
        } else {
            current.next.previous = current.previous;
            current.previous.next = current.next;
        }
        size--;
        return current.data;
    }

    @Override
    public E remove(E e) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(e)) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            return null;
        } else if (size == 1) {
            head = null;
            tail = null;
        } else if (current == head) {
            head = head.next;
            head.previous = null;
        } else if (current == tail) {
            tail = tail.previous;
            tail.next = null;
        } else {
            current.next.previous = current.previous;
            current.previous.next = current.next;
        }
        size--;
        return current.data;
    }

    @Override
    public boolean removeAll(E e) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(e)) {
                if (size == 1) {
                    head = null;
                    tail = null;
                    break;
                } else if (current == head) {
                    head = head.next;
                    head.previous = null;
                    continue;
                } else if (current == tail) {
                    tail = tail.previous;
                    tail.next = null;
                    break;
                } else {
                    current.next.previous = current.previous;
                    current.previous.next = current.next;
                }
                size--;
            }
            current = current.next;
        }
        return true;
    }

    @Override
    public boolean removeAll(GenericList<? extends E> fromList) {
        for (int i = 0; i < fromList.size(); i++) {
            remove(fromList.get(i));
        }
        return true;
    }

    @Override
    public boolean addAll(GenericList<? extends E> fromList) {
        for (int i = 0; i < fromList.size(); i++) {
            add(fromList.get(i));
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(e)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(e)) {
                return i;
            }
            current = current.previous;
        }
        return -1;
    }

    @Override
    public GenericLinkedList<E> sublist(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= size) {
            fromIndex = 0;
        }
        if (toIndex >= size || toIndex < 0) {
            toIndex = size - 1;
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
        GenericLinkedList<E> newList = new GenericLinkedList<>();
        Node<E> current = head;
        for (int i = 0; i < fromIndex; i++) {
            current = current.next;
        }
        for (int i = fromIndex; i <= toIndex; i++) {
            newList.add(current.data);
            current = current.next;
        }
        return newList;
    }
}
