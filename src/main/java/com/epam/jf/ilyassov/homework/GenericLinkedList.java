package com.epam.jf.ilyassov.homework;



/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {

    Node<E> head=null;
    Node<E> tail=null;


    public GenericLinkedList() {
    }

    public GenericLinkedList(GenericLinkedList<? extends E> anotherList) {
        this();
        addAll(anotherList);
    }


    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;


        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    protected void print(){
        if(head==null){
            System.out.println("Список пуст");
        }
       Node<E>temp=head;
       while(temp!=null){
           System.out.print(temp.item + " ");
           temp=temp.next;
       }
    }



    @Override
    public boolean add(E value) {
        if(head==null){
            head=new Node<>(value,null,null);
            tail=head;
            size++;
        }
        else{
            Node<E>temp = new Node<>(value,null,tail);
            tail.next=temp;
            tail=temp;
            size++;
        }
       return true;
    }

    @Override
    public boolean add(E value, int index) {
        if(head==null){
            head=new Node<>(value,null,null);
            tail=head;
            size++;
        }
        else {
            CheckIndex(index);
            if (index == 0) {
                Node<E> temp = new Node<E>(value, head, null);
                head.prev = temp;
                head = temp;
                size++;
            } else {
                Node<E> temp = head;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                Node<E> tempPrev = temp.prev;

                Node<E> newNode = new Node<>(value, temp, tempPrev);
                tempPrev.next = newNode;
                temp.prev = newNode;
                size++;
            }
        }
        return true;
    }

    @Override
    public E get(int index) {
        CheckIndex(index);
        Node<E>temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp.item;
    }

    @Override
    public E set(int index, E value) {
        CheckIndex(index);

        Node<E> temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        E lastValue=temp.item;
        temp.item=value;
        return lastValue;
    }

    @Override
    public E remove(int index) {
        CheckIndex(index);
        if(index==size-1){
            Node<E> temp=head;
            int j=0;
            for (int i = 0; i < index; i++) {
                temp=temp.next;
                j++;
            }

            E lastValue=temp.item;
            if(j==0){
                head=null;
            }
            else
            {
                Node<E> tempPrev=temp.prev;
                tempPrev.next=null;
            }

            size--;
            return lastValue;
        }
        else if(index==0){
            E lastValue=head.item;
            head=head.next;
            head.prev=null;
            size--;
            return lastValue;
        }
        Node<E> temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        E lastValue=temp.item;

        Node<E> tempNext=temp.next;
        Node<E> tempPrev=temp.prev;
        tempPrev.next=tempNext;
        tempNext.prev=tempPrev;
        size--;
        return lastValue;
    }

    @Override
    public void clear() {
        head=null;
        size=0;
    }

    @Override
    public GenericList<E> sublist(int fromIndex, int toIndex) {
        CheckIndex(fromIndex);
        CheckIndex(toIndex);
        Node<E> temp=head;
        for (int i = 0; i < fromIndex; i++) {
            temp=temp.next;
        }

        GenericLinkedList<E> newSublist=new GenericLinkedList<>();
        for (int i = 0; i < toIndex - fromIndex+1; i++) {
            newSublist.add(temp.item);
            temp=temp.next;
        }
        return newSublist;
    }
}
