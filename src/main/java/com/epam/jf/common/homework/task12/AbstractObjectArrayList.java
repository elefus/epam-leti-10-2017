package com.epam.jf.common.homework.task12;

/**
 * Список, построенный на основе массива.
 * Позволяет хранить значения любых ссылочных типов.
 */
public abstract class AbstractObjectArrayList {

    protected Object[] values;

    public AbstractObjectArrayList() {
        // TODO values (на 10 элементов)
    }

    public AbstractObjectArrayList(int capacity) {
        // TODO value[capacity]
    }

    public AbstractObjectArrayList(AbstractObjectArrayList list) {
        // TODO конструктор копирования
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
