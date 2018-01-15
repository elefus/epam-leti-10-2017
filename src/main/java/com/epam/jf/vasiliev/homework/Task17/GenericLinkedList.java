package com.epam.jf.vasiliev.homework.Task17;

//todo check imports
public class GenericLinkedList<E> implements GenericList <E> {

    public static final int NOT_FOUND = -1;

    private Node<E> first;
    private Node<E> last;
    private int size;


    private static class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.value = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public GenericLinkedList () {};

    public GenericLinkedList (GenericList<? extends E> list) {
        addAll(list);
    }

    private void checkIndex(int index) {
        if(!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(E value) {
        linkAfter(last,value);
        size++;
        return true;
    }

    @Override
    public boolean add(E value, int index) {
        linkBefore(getNodeByIndex(index), value);
        size++;
        return true;
    }

    private Node<E> getNodeByIndex(int index) {
        checkIndex(index);
        Node<E> crt = first;
        for (int i = 0; i < size; i++, crt = crt.next) {
            if(i == index) {
                return crt;
            }
        }
        return null;
    }

    private Node<E> getNodeByValue(E value) {
        for (Node<E> crt = first; crt != null; crt = crt.next) {
            if(crt.value.equals(value)) {
                return crt;
            }
        }
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
    public E get(int index) {
        return getNodeByIndex(index).value;
    }

    @Override
    public boolean contains(E value) {
        for (Node<E> crt = first; crt != null; crt = crt.next) {
            if(crt.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            if(!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E remove(int index) {
        final Node<E> toDel = getNodeByIndex(index);
        if(toDel != null) {
            unlinkNode(toDel);
            size--;
            return toDel.value;
        }
        return null;
    }

    @Override
    public E remove(E value) {
        final Node<E> toDel = getNodeByValue(value);
        if(toDel != null) {
            unlinkNode(toDel);
            size--;
            return toDel.value;
        }
        return null;
    }

    @Override
    public boolean removeAll(GenericList<? extends E> list) {
        boolean wasListChanged = false;
        for (int i = 0; i < list.size(); i++) {
            if(remove(list.get(i)) != null) {
                wasListChanged = true;
            }
        }
        return wasListChanged;
    }

    @Override
    public E set(E value, int index) {
        final Node<E> crt = getNodeByIndex(index);
        E oldValue = crt.value;
        crt.value = value;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            unlinkNode(first);
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(E value) {
        int index = 0;
        for (Node<E> crt = first; crt != null; crt = crt.next, index++) {
            if(crt.value.equals(value)) {
                return index;
            }
        }

        return NOT_FOUND;
    }

    @Override
    public int lastIndexOf(E value) {
        int index = size-1;
        for (Node<E> crt = last; crt != null; crt = crt.prev, index--) {
            if(crt.value.equals(value)) {
                return index;
            }
        }

        return NOT_FOUND;
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toExclusive) {
        subListCheckBounds(fromInclusive, toExclusive, size);
        return new SubList(this, fromInclusive, toExclusive);
    }

    private static void subListCheckBounds(int fromIndex, int toIndex, int size) {
        if(!(fromIndex >= 0 && toIndex < size + 1)) {
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
    }

    private class SubList<E> implements GenericList<E> {
        private final GenericList<E> parent;
        private final int offset;
        private int size;

        public SubList(GenericList<E> parent, int fromIndex, int toIndex) {
            this.parent = parent;
            this.offset = fromIndex;
            this.size = toIndex - fromIndex;
        }

        private void checkIndex(int index) {
            if(!(index >= 0 && index < size)) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override
        public boolean add(E value) {
            parent.add(value, offset + size);
            size++;
            return true;
        }

        @Override
        public boolean add(E value, int index) {
            checkIndex(index);
            parent.add(value, offset + index);
            size++;
            return true;
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
            checkIndex(index);
            return parent.get(offset + index);
        }

        @Override
        public boolean contains(E value) {
            for (int i = 0; i < size; i++) {
                if(parent.get(offset + i).equals(value)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean containsAll(GenericList<? extends E> list) {
            for (int i = 0; i < list.size(); i++) {
                if(!contains(list.get(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public E remove(int index) {
            checkIndex(index);
            size--;
            return parent.remove(offset + index);
        }

        @Override
        public E remove(E value) {
            int indexToDel = indexOf(value);
            if(indexToDel != NOT_FOUND) {
                size--;
                return parent.remove(offset + indexToDel);
            }
            return null;
        }

        @Override
        public boolean removeAll(GenericList<? extends E> list) {
            boolean wasListChanged = false;
            for(int i = 0; i < list.size(); i++) {
                int indexToDel = indexOf(list.get(i));
                if(indexToDel != NOT_FOUND) {
                    parent.remove(offset + indexToDel);
                    size--;
                    wasListChanged = true;
                }
            }
            return wasListChanged;
        }

        @Override
        public E set(E value, int index) {
            checkIndex(index);
            return parent.set(value, offset + index);
        }

        @Override
        public void clear() {
            for (int i = 0; i < size; i++) {
                parent.remove(offset);
            }
            size = 0;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int indexOf(E value) {
            for (int i = 0; i < size; i++) {
                if(parent.get(offset + i).equals(value)) {
                    return i;
                }
            }
            return NOT_FOUND;
        }

        @Override
        public int lastIndexOf(E value) {
            for (int i = size - 1; i >= 0; i--) {
                if(parent.get(offset + i).equals(value)) {
                    return i;
                }
            }
            return NOT_FOUND;
        }

        @Override
        public GenericList<E> subList(int fromInclusive, int toExclusive) {
            subListCheckBounds(fromInclusive, toExclusive, size);
            return new SubList(this,fromInclusive, toExclusive);
        }

        @Override
        public Object[] toArray() {
            Object[] result  = new Object[size];
            for(int i = 0; i < size;i++) {
                result[i] = parent.get(offset + i);
            }
            return result;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] result  = new Object[size];
        int i = 0;
        for(Node<E> crt = first; crt != null; crt = crt.next) {
            result[i++] = crt.value;
        }
        return result;
    }

    private void linkAfter(Node<E> crtNode, E value) {
        if(linkIfListEmpty(value)) {
            return;
        }
        if(crtNode == null) {
            throw new IllegalArgumentException();
        }

        final Node<E> nextNode = crtNode.next;
        final Node<E> newNode = new Node<>(crtNode, value, nextNode);
        crtNode.next = newNode;
        if(nextNode != null) {
            nextNode.prev = newNode;
        }
        if(crtNode == last) {
            last = newNode;
        }
    }

    private void linkBefore(Node<E> crtNode, E value) {
        if(linkIfListEmpty(value)) {
            return;
        }
        if(crtNode == null) {
            throw new IllegalArgumentException();
        }

        final Node<E> prevNode = crtNode.prev;
        final Node<E> newNode = new Node<>(prevNode, value,crtNode);
        crtNode.prev = newNode;
        if(prevNode != null) {
            prevNode.next = newNode;
        }
        if(crtNode == first) {
            first = newNode;
        }
    }

    private boolean linkIfListEmpty(E value) {
        if(size != 0) {
            return false;
        }

        first = new Node<>(null, value, null);
        last = first;
        return true;
    }

    private void unlinkNode(Node<E> crt) {
        final Node<E> prevNode = crt.prev;
        final Node<E> nextNode = crt.next;

        if(prevNode != null) {
            prevNode.next = nextNode;
        }
        if(nextNode != null) {
            nextNode.prev = prevNode;
        }

        if(crt == first) {
            first = nextNode;
        }
        if(crt == last) {
            last = prevNode;
        }
    }
}


















