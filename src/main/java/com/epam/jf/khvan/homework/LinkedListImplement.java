package task17;

import java.util.Objects;

public class LinkedListImplement<E> extends AbstractGenericClassImplement<E> {
    Node<E> first;
    Node<E> last;

    public LinkedListImplement() {}

    public LinkedListImplement(GenericListImplementation<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    public boolean add(int index, E element){

        checkPositionIndex(index);
        if(index == size){
            linkLast(element);
        } else {
            if (index == 0) {
                Node<E> firstItem = new Node<>(null, element, first);
                if (first != null) {
                    first.prev = firstItem;
                    first = firstItem;
                } else {
                    first = firstItem;
                    last = first;
                }
            } else {
                Node<E> oldItem = nodeAtIndex(index);
                Node<E> newItem = new Node<>( oldItem.prev, element, oldItem);
                newItem.prev.next = newItem;
                oldItem.prev = newItem;

            }

        }
        size++;
        return true;
    }

    public boolean addAll(GenericListImplementation<? extends E> list){
        for (int i = 0; i < list.size() ; i++) {
            add( list.get(i));
        }
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

    public boolean remove(E element){
        for (int i = 0; i < size ; i++) {
            if (Objects.equals(get(i),element)){
                remove(i);
                return true;
            }
        }
        return false;
    }


    public E set( E element, int index){
        checkElementIndex(index);
        E oldElement = nodeAtIndex(index).item;
        nodeAtIndex(index).item = element;
        return oldElement;
    }


    public void clear() {
      for (int i = 0; i < size; i++){
          nodeAtIndex(i).prev = null;
          nodeAtIndex(i).item = null;
          nodeAtIndex(i).next = null;
      }
      size = 0;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public Object[] toArray() {
        Object[] object = new Object[size];
        for (int i = 0; i < size; i++) {
             object[i] = get(i);
        }
        return object;
    }


    public LinkedListImplement<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size);
        return new Sublist<E>(this, fromIndex, toIndex);
    }

    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
    }


    private class Sublist<E> extends LinkedListImplement<E>{
        LinkedListImplement<E> parent;
        int size;
        int offset;
        int fromIndex;
        int toIndex;

        public Sublist (LinkedListImplement<E> parent, int fromIndex, int toIndex) {

            size = toIndex - fromIndex;
            this.parent = parent;
            this.offset = fromIndex;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        public boolean add(E value) {
            parent.add(offset + size, value);
            this.size++;
            return true;
        }

        @Override
        public boolean add(int index, E value) {
            parent.add(offset + index, value);
            this.size++;
            return true;
        }

        @Override
        public E get(int index) {
            if (index > size - 1){throw new ArrayIndexOutOfBoundsException();}
            return parent.get(offset + index);
        }

        @Override
        public boolean contains(E value) {
            for(int i = fromIndex; i < toIndex; i++){
                if ( Objects.equals(parent.get(i),value)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(GenericListImplementation<? extends E> list) {
            boolean flag = true;
            for (int i = 0; i < list.size(); i++){
                if ( this.contains( list.get(i))){
                    continue;
                } else {
                    return false;
                }
            }
            return flag;
        }

        @Override
        public E remove(int index) {
            E result = parent.remove(offset + index);
            size--;
            return result;
        }

        @Override
        public E set(E value, int index) {
            E oldValue = parent.get(offset + index);
            parent.set(value, offset + index);
            return oldValue;
        }


        @Override
        public boolean addAll(GenericListImplementation<? extends E> list){
            for (int i = 0; i < list.size() ; i++) {
                add(fromIndex + i, list.get(i));
            }
            size = size + list.size();
            parent.size = parent.size + list.size();
            return true;
        }


        public void clear() {
            if( fromIndex < toIndex) {
                for (int i = fromIndex; i < toIndex; i++){
                  nodeAtIndex(i).prev = null;
                  nodeAtIndex(i).item = null;
                  nodeAtIndex(i).next = null;
                }
            }
            parent.size = parent.size - (toIndex - fromIndex);
            size = 0;
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override
        public int indexOf(E value) {
            for ( int i = fromIndex; i < toIndex; i++){
                if (Objects.equals(parent.get(i),value)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(E value) {
            for ( int i = toIndex - 1; i >= fromIndex; i--){
                if (Objects.equals(parent.get(i),value)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public Object[] toArray() {
            Object[] object = new Object[size];
            for (int i = 0; i < size; i++) {
                object[i] = get(i);
            }
            return object;
        }
    }



    void linkLast(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        }


    E unlink(Node<E> node){
        size--;
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

        return deletedElement;
    }

    public Node<E> nodeAtIndex(int index) {
        Node<E> x;
        if (index < (size / 2)) {
            x = first;
            for (int i = 0; i < index ; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }


    public static class Node<E> {
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
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
}

