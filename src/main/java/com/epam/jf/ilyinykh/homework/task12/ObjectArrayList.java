package com.epam.jf.ilyinykh.homework.task12;

import java.util.Objects;

public class ObjectArrayList extends AbstractObjectArrayList {
    public ObjectArrayList() {
        super();
    }

    public ObjectArrayList(int capacity) {
        super(capacity);
    }

    public ObjectArrayList(AbstractObjectArrayList list) {
        super(list);
    }

    @Override
    public boolean add(Object value) {
        ensureCapacity(size + 1);
        values[size] = value;
        size++;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
        add(value);

        for (int i = size - 1; i > index; i--) {
            Object temp = values[i];
            values[i] = values[i - 1];
            values[i - 1] = temp;
        }

        size++;
        return true;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(values[i], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size; i++) {
            if (!contains(list.values[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Object val = values[index];
        Object[] vals = new Object[size - 1];
        System.arraycopy(values, 0, vals, 0, index);
        System.arraycopy(values, index + 1, vals, index, size - index - 1);
        size--;
        values = vals;
        return val;
    }

    @Override
    public Object remove(Object value) {
        return remove(indexOf(value));
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size; i++) {
            remove(list.values[i]);
        }
        return true;
    }

    @Override
    public Object set(Object value, int index) {
        checkIndex(index);
        Object o = values[index];
        values[index] = value;
        return o;
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size; i++) {
            if (!add(list.values[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        values = new Object[10];
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
    public int indexOf(Object value) {
        int i;
        i = 0;
        while (i < size && !Objects.equals(value, values[i])) {
            i++;
        }
        return (i == size) ? -1 : i;
    }

    @Override
    public int lastIndexOf(Object value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, values[i])) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        AbstractObjectArrayList list = new ObjectArrayList();
        checkIndex(fromInclusive);
        checkIndex(toInclusive);
        for (int i = fromInclusive; i <= toInclusive; i++) {
            list.add(values[i]);
        }
        return list;
    }

    @Override
    public void trimToSize() {
        Object[] objects = new Object[size];
        System.arraycopy(values, 0, objects, 0, size);
        values = objects;
    }
}
