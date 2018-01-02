package com.epam.jf.burachenko.homework.task12;

public class ObjectArrayList extends AbstractObjectArrayList {
    private int size;

    public ObjectArrayList() {
        size = 0;
    }

    public ObjectArrayList(int capacity) {
        super(capacity);
        size = 0;
    }

    public ObjectArrayList(AbstractObjectArrayList list) {
        super(list);
        size = list.size();
    }

    @Override
    public boolean add(Object value) {
        checkCapacityAndResize(size + 1);
        values[size - 1] = value;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        checkCapacityAndResize(size + 1);

        System.arraycopy(values, index, values, index + 1, values.length - index - 1);
        values[index] = value;
        return true;
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if(value.equals(values[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if(!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Object copy = values[index];
        System.arraycopy(values, index + 1, values, index, values.length - index - 1);
        size--;
        return copy;
    }

    @Override
    public Object remove(Object value) {
        while(contains(value)) {
            remove(indexOf(value));
        }
        return value;
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.get(i));
        }
        return true;
    }

    @Override
    public Object set(Object value, int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        values[index] = value;
        return value;
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        int position = size;
        checkCapacityAndResize(size + list.size());
        System.arraycopy(list.values, 0, values, position, list.size());
        return true;
    }

    @Override
    public void clear() {
        values = new Object[10];
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
            if(value.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if(value.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        if(fromInclusive < 0 || fromInclusive >= size || toInclusive < 0 || toInclusive >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(fromInclusive > toInclusive) {
            throw new IllegalArgumentException("Left border must be less or equal than right border");
        }

        ObjectArrayList subList = new ObjectArrayList(toInclusive - fromInclusive + 1);
        for (int i = fromInclusive; i <= toInclusive; i++) {
            subList.add(values[i]);
        }
        return subList;
    }

    @Override
    public void trimToSize() {
        Object[] trimmedValues = new Object[size];
        System.arraycopy(values, 0, trimmedValues, 0, size);
        values = trimmedValues;
    }

    private void checkCapacityAndResize(int newSize) {
        if(newSize > values.length) {
            Object[] newValues = new Object[(newSize/values.length+1)*values.length];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
        size = newSize;
    }
}
