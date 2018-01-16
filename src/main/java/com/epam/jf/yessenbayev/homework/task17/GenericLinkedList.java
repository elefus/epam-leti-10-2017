package com.epam.jf.yessenbayev.homework.task17;

import com.epam.jf.yessenbayev.homework.task16.GenericList;

import java.util.Objects;

/**
 * Реализация двунаправленного связного не-кольцевого списка.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericLinkedList<E> extends AbstractGenericList<E> {

    protected Item head;
    protected Item tail;

    public GenericLinkedList() {
    }

    public GenericLinkedList(GenericList<? extends E> list) {
        super();
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public boolean add(E value, int index) {
        if (index < 0 || size < index) {
            return false;
        }
        if (index == 0) {
            Item firstItem = new Item(value, head, null);
            if (head != null) {
                head.prev = firstItem;
                head = firstItem;
            } else {
                head = firstItem;
                tail = head;
            }
        } else if (index == size) {
            Item lastItem = new Item(value, null, tail);
            tail.next = lastItem;
            tail = lastItem;
        } else {
            Item nextItem = getItemByIndex(index);
            Item temp = new Item(value, nextItem, nextItem.prev);
            temp.next.prev = temp;
            temp.prev.next = temp;
        }
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
        return getItemByIndex(index).value;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Item del;
        if (index == 0) {
            del = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (index == size - 1) {
            del = tail;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            del = getItemByIndex(index);
            if (del.prev != null) {
                del.prev.next = del.next;
            }
            if (del.next != null) {
                del.next.prev = del.prev;
            }
        }
        size--;
        return del.value;
    }

    @Override
    public E set(E value, int index) {
        checkIndex(index);
        Item repl = getItemByIndex(index);
        E temp = repl.value;
        repl.value = value;
        return temp;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(E value) {
        Item item = head;
        int index = 0;
        while (item != null) {
            if (Objects.equals(item.value, value)) {
                return index;
            }
            index++;
            item = item.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        Item item = tail;
        int index = size - 1;
        while (item != null) {
            if (Objects.equals(item.value, value)) {
                return index;
            }
            index--;
            item = item.prev;
        }
        return -1;
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toInclusive) {
        if (fromInclusive > toInclusive) {
            throw new IllegalArgumentException();
        }
        checkIndex(fromInclusive);
        checkIndex(toInclusive);
        GenericLinkedList<E> obj = new GenericLinkedList<>();
        Item item = getItemByIndex(fromInclusive);
        while (fromInclusive <= toInclusive) {
            obj.add(item.value);
            item = item.next;
            fromInclusive++;
        }
        return obj;
    }

    private Item getItemByIndex(int index) {
        Item result;
        if (size / 2 > index) {
            result = head;
            for (int i = 1; i <= index; i++) {
                result = result.next;
            }
        } else {
            result = tail;
            for (int i = size - 2; i >= index; i--) {
                result = result.prev;
            }
        }
        return result;
    }

    private void checkIndex(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }
    }

    private class Item {

        private E value;
        private Item next;
        private Item prev;

        private Item(E value, Item next, Item prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
