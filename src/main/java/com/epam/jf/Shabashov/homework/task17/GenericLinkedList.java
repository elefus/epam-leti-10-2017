package com.epam.jf.Shabashov.homework.task17;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {

    Node<E> first;
    Node<E> last;

    public GenericLinkedList() {
    }

    public GenericLinkedList(E[] array) {
        for (E e : array) {
            add(e);
        }
        size+=array.length;
    }

    @Override
    public void add(E element) {
        Node<E> node = new Node<>(element,last,null);
        if (last==null){
            last=node;
            first=node;
        }else {
            last.next=node;
            last=node;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = getElement(index);
        Node<E> elem = new Node<>(element,node.prev,node);
        node.prev=elem;
        if (elem.prev!=null){
            elem.prev.next=elem;
        }
        size++;
    }

    @Override
    public boolean addAll(GenericList<? extends E> list) {
        Object[] arr = list.toArray();
        for (Object o : arr) {
            add((E) o);
        }
        size+=list.size();
        return true;
    }

    @Override
    public boolean addAll(int index,GenericList<? extends E> list) {
        Node<E> node = getElement(index);
        Object[] arr = list.toArray();
        if (arr.length==0) return true;
        Node<E> firstElem = new Node<E>((E) arr[0], node.prev, null);
        Node<E> lastElem = firstElem;
        for (int i = 1; i < arr.length; i++) {
            lastElem.next = new Node<E>((E) arr[i], lastElem, null);
            lastElem = lastElem.next;
        }
        lastElem.next = node;
        node.prev=lastElem;
        if (firstElem.prev!=null){
            firstElem.prev.next=firstElem;
        }
        size+=arr.length;
        return true;
    }

    @Override
    public boolean contains(E item) {
        Node<E> elem = first;
        for (int i = 0; i < size; i++) {
            if (elem.item.equals(item)){
                return true;
            }
            elem=elem.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(GenericList<? extends E> list) {
        Object[] arr = list.toArray();
        Node<E> elem = first;
        for (int i = 0; i < arr.length; i++) {
            if (!contains((E) arr[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public E get(int index) {
        return getElement(index).item;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getElement(index);
        E prev = node.item;
        node.item=element;
        return prev;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getElement(index);
        if (first==node) first=first.next;
        if (last==node) last=last.prev;
        E prev = node.item;
        if (node.prev!=null){
            node.prev.next=node.next;
        }
        if (node.next!=null){
            node.next.prev=node.prev;
        }
        size--;
        return prev;
    }

    @Override
    public boolean remove(E item) {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(item)){
                if (node.prev!=null){
                    node.prev.next=node.next;
                }
                if (node.next!=null){
                    node.next.prev=node.prev;
                }
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAll(GenericList<? extends E> list) {
        Object[] arr = list.toArray();
        Node<E> elem = first;
        for (int i = 0; i < arr.length; i++) {
            remove((E) arr[i]);
        }
        return true;
    }

    @Override
    public E[] toArray() {
        Object[] arr = new Object[size];
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            arr[i]=node.item;
            node=node.next;
        }
        return (E[]) arr;
    }

    @Override
    public AbstractGenericList<E> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        if (fromIndex>=toIndex) throw new IllegalArgumentException();
        Node<E> node = getElement(fromIndex);
        Object[] arr =new Object[toIndex-fromIndex+1];
        for (int i = fromIndex; i <= toIndex; i++) {
            arr[i-fromIndex]=node.item;
            node=node.next;
        }
        return new GenericLinkedList<E>((E[]) arr);
    }

    @Override
    public void clear() {
        first=null;
        last=null;
        size=0;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
    }

    private String IndexOutException(int index) {
        return "Index : " + index + " size : " + size;
    }


    private Node<E> getElement(int index){
        checkIndex(index);
        Node<E> element;
        if (index*2>size){
            element = last;
            for (int i = 0; i < size-index-1; i++) {
                element=element.prev;
            }
        }else{
            element = first;
            for (int i = 0; i < index; i++) {
                element=element.next;
            }
        }
        return element;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element,Node<E> prev, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
