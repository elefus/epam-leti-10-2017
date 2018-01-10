package com.epam.jf.polovinkin.homework.task17;

import com.epam.jf.polovinkin.homework.task16.GenericList;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {
    public GenericLinkedList() {
        super();
    }

    public GenericLinkedList(GenericList<? extends E> list) {
        this();
        addAll(list);
    }

    @Override
    public boolean add(E value) {
        Node node = null;
        if (head == null) {
            head = new Node(value);
            node = head;
        } else {
            node = head;
            while (node.right != null) {
                node = node.right;
            }
            node.right = new Node(value, node);
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E value) {
        Node node = getNode(index);

        Node left = node.left;
        left.right = node.left = new Node(value, left, node);
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.right;
        }

        return node.data;
    }

    @Override
    public E set(int index, E value) {
        Node node = getNode(index);
        return node.data;
    }

    @Override
    public E remove(int index) {
        Node node = getNode(index);
        E data = node.data;

        node.right.left = node.left;
        node.left.right = node.right;

        size--;
        return data;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    private Node head;

    private Node getNode(int index) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.right;
        }

        return node;
    }

    private boolean stepLeft(Node node) {
        if (node.left == null) {
            return false;
        } else {
            node = node.left;
            return true;
        }
    }

    private final class Node {
        E data;
        Node left = null;
        Node right = null;

        Node() {
            data = null;
        }

        Node(E data) {
            this.data = data;
        }

        Node(E data, Node left) {
            this.data = data;
            this.left = left;
        }

        Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
