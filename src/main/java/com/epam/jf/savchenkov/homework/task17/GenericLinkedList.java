package com.epam.jf.savchenkov.homework.task17;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {

    private Node head;
    private Node tail;

    public GenericLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public boolean add(E value) {
        return add(value, size);
    }

    @Override
    public boolean add(E value, int index) {
        checkIndex(index);
        if (index == 0) {
            Node firstNode = new Node(value, head, null);
            if (head == null) {
                head = firstNode;
                tail = head;
            } else {
                head.prev = firstNode;
                head = firstNode;
            }
        } else if (index == size) {
            Node lastNode = new Node(value, null, tail);
            tail.next = lastNode;
            tail = lastNode;
        } else {
            Node nextNode = getNodeByIndex(index);
            Node temp = new Node(value, nextNode, nextNode.prev);
            temp.next.prev = temp;
            temp.prev.next = temp;
        }
        size++;
        return true;
    }


    @Override
    public E get(int index) {
        checkIndex(index);
        return getNodeByIndex(index).data;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node node;
        if (index == 0) {
            node = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (index == size - 1) {
            node = tail;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node = getNodeByIndex(index);
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
        size--;
        return node.data;
    }

    @Override
    public E remove(E value) {
        return remove(indexOf(value));
    }

    @Override
    public boolean removeAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.get(i));
        }
        return true;
    }

    @Override
    public E set(E value, int index) {
        return null;
    }

    @Override
    public boolean addAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int indexOf(E value) {
        Node node = head;
        int index = 0;
        while (node != null) {
            if (node.data.equals(value)) {
                return index;
            }
            index++;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        Node node = tail;
        int index = size - 1;
        while (node != null) {
            if (node.data.equals(value)) {
                return index;
            }
            index--;
            node = node.prev;
        }
        return -1;
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toInclusive) {
        checkIndex(fromInclusive);
        checkIndex(toInclusive);
        if (fromInclusive > toInclusive) {
            throw new IllegalArgumentException();
        }
        GenericLinkedList<E> list = new GenericLinkedList<>();
        Node node = getNodeByIndex(fromInclusive);
        for (int i = fromInclusive; i <= toInclusive; i++) {
            list.add(node.data);
            node = node.next;
        }
        return list;
    }

    private void checkIndex(int index) {
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getNodeByIndex(int index) {
        Node node;
        if (size / 2 < index) {
            node = tail;
            for (int i = size - 2; i >= index; i--) {
                node = node.prev;
            }
        } else {
            node = head;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }
        }
        return node;
    }
    private class Node {

        E data;
        Node next;
        Node prev;

        Node(E data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
