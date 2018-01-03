package com.epam.jf.guba.homework.task17;


import com.epam.jf.guba.homework.GenericList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 *
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;


    public GenericLinkedList() {
    }


    public GenericLinkedList(GenericArrayList<? extends E> list) {
        this();
        addAll(list);
    }


    private void linkFirst(E el) {
        Node<E> old = first;
        Node<E> node = new Node<>(null, old, el);
        first = node;
        if (old == null) {
            last = node;
        } else {
            old.prev = node;
        }
        size++;

    }


    private void linkLast(E el) {
        Node<E> old = last;
        Node<E> node = new Node<>(old, null, el);
        last = node;
        if (old == null) {
            first = node;
        } else {
            old.next = node;
        }
        size++;
    }

    private void linkBefore(E el, Node<E> before) {
        if (before == null) {
            throw new NullPointerException();
        }
        Node<E> previous = before.prev;
        Node<E> node = new Node<>(previous, before, el);
        before.prev = node;
        if (previous == null) {
            first = node;
        } else {
            previous.next = node;
        }
        size++;
    }


    private E unlinkFirst(Node<E> curr) {
        if (curr == null) {
            throw new NullPointerException();
        }

        if (curr != first) {
            throw new IllegalArgumentException("Node isn't first");
        }
        E old = curr.value;
        Node<E> next = curr.next;
        curr.value = null;
        curr.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;

        return old;
    }


    private E unlinkLast(Node<E> curr) {
        if (curr == null) {
            throw new NullPointerException();
        }

        if (curr != last) {
            throw new IllegalArgumentException("Node isn't last");
        }
        E old = curr.value;
        Node<E> prev = curr.prev;

        curr.value = null;
        curr.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
        return old;
    }

    private E unlinkNode(Node<E> curr) {
        if (curr == null) {
            throw new NullPointerException();
        }
        E old = curr.value;
        Node<E> prev = curr.prev;
        Node<E> next = curr.next;
        curr.value = null;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            curr.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            curr.next = null;
        }

        size--;
        return old;
    }

    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();

        }
        return first.value;
    }

    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();

        }
        return last.value;
    }

    public E removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(first);
    }

    public E removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return unlinkLast(last);
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
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
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter(0);
    }

    public Iterator<E> iterator(int index) {
        return new Iter(index);
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> el = first; el != null; el = el.next) {
            result[i++] = el.value;
        }
        return result;
    }

    @Override
    public void add(E element) {
        linkLast(element);
    }

    @Override
    public void add(int index, E element) {
        checkBoarders(index);
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, getNode(index));
        }
    }

    @Override
    public boolean remove(Object element) {
        int i = 0;
        if (element == null) {
            for (Node<E> el = first; el != null; ) {
                Node<E> next = el.next;
                if (el.value == null) {
                    remove(i);
                    return true;
                }
                i++;
                el = next;
            }
        } else {
            for (Node<E> el = first; el != null; ) {
                Node<E> next = el.next;
                if (element.equals(el.value)) {
                    remove(i);
                    return true;
                }
                i++;
                el = next;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        checkBoarders(index);
        E old = get(index);
        unlinkNode(getNode(index));
        return old;
    }

    @Override
    public boolean removeAll(GenericList<? extends E> collection) {
        int oldSize = size;
        for (int i = 0; i < collection.size(); i++) {
            E elem = collection.get(i);
            if (contains(elem)) {
                remove(elem);
            }
        }
        return oldSize > size;
    }

    @Override
    public boolean containsAll(GenericList<? extends E> collection) {
        for (int i = 0; i < collection.size(); i++) {
            if (!contains(collection.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(GenericList<? extends E> elements) {
        return addAll(size, elements);
    }

    @Override
    public boolean addAll(int index, GenericList<? extends E> elements) {
        Object[] elems = elements.toArray();
        int total = elems.length;
        if (total == 0) {
            return false;
        }
        Node<E> prev;
        Node<E> curr;

        if (index == size) {
            curr = null;
            prev = last;
        } else {
            curr = getNode(index);
            prev = curr.prev;
        }

        for (Object obj : elems) {
            E newEl = (E) obj;
            Node<E> newNode = new Node<>(prev, null, newEl);
            if (prev == null) {
                first = newNode;
            } else {
                prev.next = newNode;
            }
            prev = newNode;

        }

        if (curr == null) {
            last = prev;
        } else {
            prev.next = curr;
            curr.prev = prev;
        }

        size += total;
        return true;
    }

    @Override
    public void clear() {
        for (Node<E> el = first; el != null; ) {
            Node<E> next = el.next;
            el.prev = null;
            el.next = null;
            el.value = null;
            el = next;
        }

        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        checkBoarders(index);
        return getNode(index).value;
    }

    @Override
    public E set(int index, E element) {
        checkBoarders(index);
        Node<E> node = getNode(index);
        E old = node.value;
        node.value = element;
        return old;
    }

    @Override
    public int indexOf(Object element) {
        int i = 0;
        if (element == null) {
            for (Node<E> el = first; el != null; el = el.next) {
                if (el.value == null) {
                    return i;
                }
                i++;
            }
        } else {
            for (Node<E> el = first; el != null; el = el.next) {
                if (element.equals(el.value)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        int i = size - 1;
        if (element == null) {
            for (Node<E> el = last; el != null; el = el.prev) {
                if (el.value == null) {
                    return i;
                }
                i++;
            }
        } else {
            for (Node<E> el = last; el != null; el = el.prev) {
                if (element.equals(el.value)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override
    public GenericList<E> sublist(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super E> list) {
        throw new UnsupportedOperationException();
    }


    private void checkBoarders(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }

    private Node<E> getNode(int index) {
        if (index < (size >> 1)) {
            Node<E> el = first;
            for (int i = 0; i < index; i++) {
                el = el.next;
            }
            return el;
        } else {
            Node<E> el = last;
            for (int i = size - 1; i > index; i--) {
                el = el.prev;
            }
            return el;
        }
    }


    private class Iter implements Iterator<E> {

        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        Iter(int index) {
            checkBoarders(index);
            next = (index == size) ? null : getNode(index);
            nextIndex = index;

        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.value;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            Node<E> next = lastReturned.next;
            unlinkNode(lastReturned);
            if (next == lastReturned) {
                this.next = next;
            } else {
                nextIndex--;
            }
            lastReturned = null;
        }
    }

    private class Node<E> {

        private Node<E> prev;
        private Node<E> next;
        private E value;

        Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }


}
