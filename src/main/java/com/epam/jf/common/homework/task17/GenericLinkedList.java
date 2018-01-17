package com.epam.jf.common.homework.task17;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value, GenericLinkedList.Node<E> next, GenericLinkedList.Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private GenericLinkedList.Node<E> head;
    private GenericLinkedList.Node<E> tail;

    @Override
    public boolean contains(E value) {
        GenericLinkedList.Node<E> node = this.head;
        for (int i = 0; i<this.size; ++i){
            if (node.value.equals(value)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean add(E value) {
        return add(value, size);
    }

    @Override
    public boolean add(E value, int index) {
        if (index == 0) {
            Node<E> firstNode = new Node<>(value, head, null);
            if (head == null) {
                head = firstNode;
                tail = head;
            } else {
                head.prev = firstNode;
                head = firstNode;
            }
        } else if (index == size) {
            Node<E> lastNode = new Node<>(value, null, tail);
            tail.next = lastNode;
            tail = lastNode;
        } else {
            Node<E> nextNode = getNode(index);
            Node<E> temp = new Node<>(value, nextNode, nextNode.prev);
            temp.next.prev = temp;
            temp.prev.next = temp;
        }
        ++size;
        return true;
    }

    private Node<E> getNode(int index) {
        Node<E> node;
        if (size / 2 < index) {
            node = tail;
            for (int i = size - 2; i >= index; i++) {
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

    @Override
    public E remove(E value) {
        GenericLinkedList.Node<E> node = head;
        do{
            if (node.value.equals(value)){
                E nodeItem = node.value;
                if (size > 1) {
                    node.prev.next = node.next;
                    if (node == head){
                        head = node.next;
                    }
                    if (node == tail){
                        tail = node.prev;
                    }
                } else {
                    clear();
                }
                return nodeItem;
            }
        } while (!node.equals(tail));
        return node.value;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public E get(int index) {
        return getNode(index).value;
    }

    @Override
    public E set(E value, int index) {
        GenericLinkedList.Node<E> node = getNode(index);
        node.value = value;
        return node.value;
    }

    @Override
    public E remove(int index) {
        GenericLinkedList.Node<E> node = getNode(index);
        E nodeItem = node.value;
        if (size > 1){
            node.prev.next = node.next;
            --size;
        } else {
            clear();
        }
        return nodeItem;
    }

    @Override
    public int indexOf(Object o) {
        GenericLinkedList.Node<E> node = head;
        for (int i = 0; i < size; i++){
            if (node.value.equals(o)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        GenericLinkedList.Node<E> node = this.tail;
        for (int i = (size - 1); i >= 0; i--){
            if (node.value.equals(o)){
                return i;
            }
            node = node.prev;
        }
        return -1;
    }
}
