package com.epam.jf.kruglik.homework.task17;

import java.util.NoSuchElementException;

public class GenericLinkedList<E> extends AbstractGenericList<E> {
    private GenericLinkedList.Node<E> head;
    private GenericLinkedList.Node<E> tail;

    public GenericLinkedList(){
        this.size = 0;
    }

    @Override
    public E set(int index, E element){
        GenericLinkedList.Node<E> node = searchNode(index);
        node.item = element;
        return  node.item;
    }

    @Override
    public void add(E element) {
        Node<E> node = null;
        if (this.head == null) {
            node = new Node<>(element, this.head, this.tail);
            createLinkedList(node);
        } else {
            node = new Node<>(element, this.head, this.head.prev);
            swapPointers(node);
            this.tail = node;
        }
        ++size;
    }

    @Override
    public void add(int index, E element){
        Node<E> iter = this.head;
        for (int i = 0;i< index;++i)
            iter = iter.next;
        Node<E> node = new Node<>(element,iter,iter.prev);
        swapPointers(node);
        if (index == 0){
            this.head = node;
        }
        if (index == (size - 1)){
            this.tail = node;
        }
        ++size;
    }

    public void addLast(E element){
        add(element);
    }

    public void addFirst(E element){
        Node<E> node = new Node<>(element, this.head, this.tail);
        if (this.head == null) {
            createLinkedList(node);
        } else {
            swapPointers(node);
            this.head = node;
        }
        ++size;
    }

    @Override
    public void clear(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public boolean contains(E element){
        GenericLinkedList.Node<E> node = this.head;
        for (int i = 0; i<this.size; ++i){
            if (node.item.equals(element)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object element){
        GenericLinkedList.Node<E> node = this.head;
        for (int i = 0; i<this.size; ++i){
            if (node.item.equals(element)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element){
        GenericLinkedList.Node<E> node = this.tail;
        for (int i = (this.size - 1); i>=0; --i){
            if (node.item.equals(element)){
                return i;
            }
            node = node.prev;
        }
        return -1;
    }


    public E entry(int index){
        GenericLinkedList.Node<E> node = searchNode(index);
        return node.item;
    }

    @Override
    public E get(int index){
        return entry(index);
    }

    public E getLast(){
        return this.tail.item;
    }

    public E getFirst(){
        return this.head.item;
    }

    public E removeFirst(){
        E nodeItem = this.head.item;
        if (this.size > 1){
            this.head = this.head.next;
            --this.size;
        } else {
            clear();
        }
        return nodeItem;
    }

    public E removeLast(){
        E nodeItem = this.head.item;
        if (this.size > 1){
            this.tail = this.tail.prev;
            --this.size;
        } else {
            clear();
        }
        return nodeItem;
    }

    @Override
    public E remove(int index){
        GenericLinkedList.Node<E> node = searchNode(index);
        E nodeItem = node.item;
        if (this.size > 1){
            node.prev.next = node.next;
            --this.size;
        } else {
            clear();
        }
        return nodeItem;
    }

    @Override
    public E remove(E element){
        GenericLinkedList.Node<E> node = this.head;
        do{
          if (node.item.equals(element)){
              E nodeItem = node.item;
              if (this.size > 1) {
                  node.prev.next = node.next;
                  if (node == this.head){
                      this.head = node.next;
                  }
                  if (node == this.tail){
                      this.tail = node.prev;
                  }
              } else {
                  clear();
              }
              return nodeItem;
          }
        } while (!node.equals(this.tail));
        throw new NoSuchElementException();
    }

    private void swapPointers(GenericLinkedList.Node<E> node){
        node.prev.next = node;
        node.next.prev = node;
    }

    private void createLinkedList(GenericLinkedList.Node<E> node){
        this.head = node;
        this.head.next = this.head;
        this.head.prev = this.head;
        this.tail = this.head;
    }

    private GenericLinkedList.Node<E> searchNode (int index){
        GenericLinkedList.Node<E> node = null;
        if (index < (this.size / 2)){
            node = this.head;
            for (int i = 0; i<index; ++i){
                node = node.next;
            }
        } else {
            node = this.tail;
            for (int i = this.size; i>(index + 1); --i){
                node = node.prev;
            }
        }
        return node;
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element, GenericLinkedList.Node<E> next, GenericLinkedList.Node<E> prev)
        {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
