package com.epam.jf.guba.homework.task12;

/**
 * Список, построенный на основе массива. Позволяет хранить значения любых ссылочных типов.
 */
public abstract class AbstractObjectArrayList {

    protected Object[] values;
    protected int size;

    public AbstractObjectArrayList() {
        values = new Object[10];
        size = 0;
    }

    public AbstractObjectArrayList(int capacity) {
        values = new Object[capacity];
        size = 0;
    }

    public AbstractObjectArrayList(AbstractObjectArrayList list) {
        values = new Object[list.size() + (list.size >> 1)];
        System.arraycopy(list.values, 0, this.values, 0, list.size());
        size = list.size;
    }

    public abstract boolean add(Object value);

    public abstract boolean add(Object value, int index);

    public abstract Object get(int index);

    public abstract boolean contains(Object value);

    public abstract boolean containsAll(AbstractObjectArrayList list);

    public abstract Object remove(int index);

    public abstract Object remove(Object value);

    public abstract boolean removeAll(AbstractObjectArrayList list);

    public abstract Object set(Object value, int index);

    public abstract boolean addAll(AbstractObjectArrayList list);

    public abstract void clear();

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract int indexOf(Object value);

    public abstract int lastIndexOf(Object value);

    public abstract AbstractObjectArrayList subList(int fromInclusive, int toInclusive);

    public abstract void trimToSize();
}
