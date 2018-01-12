package com.epam.jf.savchenkov.homework;

import com.epam.jf.common.homework.task12.AbstractObjectArrayList;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    public ObjectArrayList(Object[] list) {
        this.values = list.clone();
        this.size = list.length;
    }

    @Override
    public boolean add(Object value) {
        add(value, this.size());
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
        if (index > size() || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from add(). Index " + index + " actual size " + size);
        } else {
            Object[] temp = new Object[this.size() + 1];
            System.arraycopy(this.values, 0, temp, 0, index);
            temp[index] = value;
            System.arraycopy(this.values, index, temp, index + 1, this.size() - index);
            this.values = temp;
            this.size++;
            return true;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound. Size = " + size + " Index = " + index);
        }
        return this.values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (Object obj : this.values) {
            if (obj.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        for (Object obj : values) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from remove(). Index " + index + " actual size " + size);
        } else {
            Object value = this.values[index];
            Object[] temp = new Object[this.size() - 1];
            System.arraycopy(this.values, 0, temp, 0, index);
            System.arraycopy(this.values, index + 1, temp, index, temp.length - index);
            this.values = temp;
            this.size--;
            return value;
        }
    }

    @Override
    public Object remove(Object value) {
        if (contains(value)) {
            return remove(indexOf(value));
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        if (containsAll(list)) {
            for (int i = 0; i < list.size(); i++) {
                remove(list.get(i));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object set(Object value, int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Exception from set(). Index " + index + " actual size " + size);
        } else {
            Object old = this.values[index];
            this.values[index] = value;
            return old;
        }
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        Object[] buffArray = new Object[this.size() + list.size()];

        Object[] copyArrayList = new Object[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            copyArrayList[i] = list.get(i);
        }

        System.arraycopy(this.values, 0, buffArray, 0, this.size());
        System.arraycopy(copyArrayList, 0, buffArray, this.size(), list.size());
        this.values = buffArray;
        this.size += list.size();
        return true;
    }

    @Override
    public void clear() {
        this.values = new Object[0];
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
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        if (fromInclusive > toInclusive || fromInclusive < 0 || toInclusive < 0 || fromInclusive >= size || toInclusive >= size) {
            throw new IllegalArgumentException("Illegal interval");
        }
        return new ObjectArrayList(Arrays.copyOfRange(values, fromInclusive, toInclusive));
    }

    @Override
    public void trimToSize() {
        if (size < values.length) {
            values = (size == 0) ? new Object[0] : Arrays.copyOf(values, size);
        }
    }
}
