package com.epam.jf.kozlov.homework.task12;

import java.util.Arrays;

public class ObjectArrayList extends AbstractObjectArrayList {

    public ObjectArrayList() {}

    public ObjectArrayList(int capacity) {
        super(capacity);
    }

    public ObjectArrayList(ObjectArrayList list) {
        super(list);
    }

    @Override
    public boolean add(Object value) {
        ensureCapacity(size + 1);
        values[size++] = value;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
        if (index < 0 || index > values.length) {
            return false;
        }
        ensureCapacity(size + 1);
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        size++;
        return true;
    }

    @Override
    public Object get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size; i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Object oldValue = values[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(values, index + 1, values, index, numMoved);
        }
        values[--size] = null; // clear to let GC do its work
        return oldValue;
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
        if (index < 0 || index >= size) {
            return null;
        }
        Object oldObject = values[index];
        values[index] = value;
        return oldObject;
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        int numNew = list.size;
        ensureCapacity(size + numNew);  // Increments modCount
        System.arraycopy(list.values, 0, values, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
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
    public int indexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (values[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (values[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (value.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ObjectArrayList subList(int fromInclusive, int toInclusive) {
        if (fromInclusive < 0 || fromInclusive >= size) {
            fromInclusive = 0;
        }
        if (toInclusive >= size || toInclusive < 0) {
            toInclusive = size - 1;
        }
        if (fromInclusive > toInclusive) {
            throw new IllegalArgumentException();
        }
        ObjectArrayList list = new ObjectArrayList(toInclusive - fromInclusive + 1);
        list.size = toInclusive - fromInclusive + 1;
        System.arraycopy(values,fromInclusive,list.values,0,list.size());
        return list;
    }

    @Override
    public void trimToSize() {
        if (size < values.length) {
            values = Arrays.copyOf(values, size);
        }
    }

    public boolean equeals(Object o) {
        return o == this || o instanceof AbstractObjectArrayList
                && ((AbstractObjectArrayList) o).size == size
                && containsAll((AbstractObjectArrayList) o);
    }

    private void ensureCapacity(int minCapacity) {
        int newCapacity = values.length * 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (values.length < minCapacity) {
            values = Arrays.copyOf(values, newCapacity);
        }
    }
}
