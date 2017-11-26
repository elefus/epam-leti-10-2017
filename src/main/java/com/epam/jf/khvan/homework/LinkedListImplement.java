package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.task16.GenericList;

import java.util.Comparator;

public class LinkedListImplement<E> extends AbstractGenericClassImplement<E> {

    Node<E> first;
    Node<E> last;
    private int size = 0;

    public boolean add(E e){
        linkLast(e);
        return true;
    }

    public E get(int index){
        checkElementIndex(index);
        return nodeAtIndex(index).item;
    }

    public E remove(int index){
        checkElementIndex(index);
        return unlink(nodeAtIndex(index));
    }

    public E set(int index, E element){
        checkElementIndex(index);
        E oldElement = nodeAtIndex(index).item;
        nodeAtIndex(index).item = element;
        return oldElement;
    }

    public void add(int index,E element){
        checkPositionIndex(index);
        if(index == size){
            linkLast(element);
        } else {
            Node<E> oldNode = nodeAtIndex(index);
            Node<E> newNode = new Node<>(oldNode.prev, element, oldNode);
            oldNode.prev = newNode;

        }
        size++;
    }

    public boolean addAll(GenericListImplementation<? extends E> list){
        for (int i = 0; i < list.size() ; i++) {
            add(size + i, list.get(i));

        }
        Comparator.comparing()
        return true;
    }

    public void clear() {
      for (int i = 0; i < size; i++){
          nodeAtIndex(i).prev = null;
          nodeAtIndex(i).item = null;
          nodeAtIndex(i).next = null;
      }
      size = 0;
    }

    public int indexOf(E element){
        int index = 0;
        if (element == null){
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == element)
                    return index;
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(E element){
        int index = size - 1;
        if (element == null){
            for (Node<E> x = last; x != null; x = x.prev) {
                if (x.item == null)
                    return index;
                index--;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (x.item == element)
                    return index;
                index--;
            }
        }
        return -1;

    }


    private void linkFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }


    void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    E unlink(Node<E> node){
      E deletedElement = node.item;
      Node<E> prev = node.prev;
      Node<E> next = node.next;

      if(next == null){
          last = prev;
      } else {
          next.prev = prev;
          node.prev = null;
      }

      if(prev == null){
          first = next;
      } else {
          prev.next = next;
          node.next = null;
      }

      node.item = null;
      size--;
        return deletedElement;
    }

    Node<E> nodeAtIndex(int index) {
        if (index < (size / 2)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
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




    boolean isElementIndex(int index){
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }


    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }
}


