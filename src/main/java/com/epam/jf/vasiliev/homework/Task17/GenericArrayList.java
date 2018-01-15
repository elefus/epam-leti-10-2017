package com.epam.jf.vasiliev.homework.Task17;

import java.util.Arrays;
import java.util.Comparator;

public class GenericArrayList<E> implements GenericList<E> {
    public static final int DEFAULT_CAPACITY = 10;
    public static final int NOT_FOUND = -1;

    private Object[] values;
    private int size;

    GenericArrayList() {
        values = new Object[DEFAULT_CAPACITY];
    }

    GenericArrayList(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("Capacity is < 0");
        }
        values = new Object[capacity];
    }

    GenericArrayList(GenericArrayList<? super E> list) {
        size = list.size;
        values = new Object[size];
        System.arraycopy(list.values, 0, values,0,size);
    }

    @Override
    public boolean add(E value) {
        if(size + 1 > values.length) {
            increaseCapacity();
        }
        values[size++] = value;
        return true;
    }

    @Override
    public boolean add(E value, int index) {
        checkBounds(index);

        if(index > values.length) {
            increaseCapacity();
        }
        System.arraycopy(values,index,values,index + 1,size - index);
        values[index] = value;
        size++;
        return true;
    }

    @Override
    public boolean addAll(GenericList<? extends E> list) {
        boolean wasListChanged = false;
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
            wasListChanged = true;
        }
        return wasListChanged;
    }

    @Override
    public E get(int index) {
        checkBounds(index);
        return (E) values[index];
    }

    @Override
    public boolean contains(E value) {
        if(isEmpty()) {
            return false;
        }

        for (int i = 0; i < size; ++i) {
            if(values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            if(!this.contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E remove(int index) {
        checkBounds(index);

        Object tmp = values[index];
        size--;
        System.arraycopy(values,index + 1,values,index,size - index);
        return (E)tmp;
    }

    @Override
    public E remove(E value) {
        int index = indexOf(value);
        return index == NOT_FOUND ? null : remove(index);
    }

    @Override
    public boolean removeAll(GenericList<? extends E> list) {
        boolean wasListChanged = false;
        for (int i = 0; i < list.size(); i++) {
            int indexToDel = indexOf(list.get(i));
            if(indexToDel != NOT_FOUND) {
                wasListChanged = true;
                remove(indexToDel);
            }
        }
        return wasListChanged;
    }

    @Override
    public E set(E value, int index) {
        checkBounds(index);
        Object tmp = values[index];
        values[index] = value;
        return (E) tmp;
    }

    @Override
    public void clear() {
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
            if(values[i].equals(value)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if(values[i].equals(value)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private static void subListCheckBounds(int fromIndex, int toIndex, int size) {
        if(!(fromIndex >= 0 && toIndex < size + 1)) {
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public GenericList<E> subList(int fromInclusive, int toExclusive) {
        subListCheckBounds(fromInclusive, toExclusive, size);
        return new Sublist(this, fromInclusive, toExclusive);
    }

    private class Sublist implements GenericList<E> {
        private final GenericList<E> parent;
        private final int offset;
        private int size;

        private Sublist(GenericList<E> parent, int fromIndex, int toIndex) {
            this.parent = parent;
            this.offset = fromIndex;
            this.size = toIndex - fromIndex;
        }


        @Override
        public boolean add(E value) {
            parent.add(value, offset + size);
            size++;
            return true;
        }

        @Override
        public boolean add(E value, int index) {
            checkBounds(index);
            parent.add(value, offset + index);
            size++;
            return false;
        }

        @Override
        public boolean addAll(GenericList<? extends E> list) {
            boolean wasListChanged = false;
            for (int i = 0; i < list.size(); i++) {
                parent.add(list.get(i), offset + size);
                size++;
                wasListChanged = true;
            }
            return wasListChanged;
        }

        @Override
        public E get(int index) {
            checkBounds(index);
            return parent.get(offset + index);
        }

        @Override
        public boolean contains(E value) {
            for(int i = offset; i < offset + size; ++i) {
                if(parent.get(i).equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(GenericList<? extends E> list) {
            for(int i = 0; i < list.size();++i) {
                if(!this.contains(list.get(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public E remove(int index) {
            checkBounds(index);
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
            checkBounds(index);
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
            return new Sublist(this,fromInclusive, toExclusive);
        }

        @Override
        public Object[] toArray() {
            //todo test toArray sublist
            Object[] newArray = new Object[this.size];
            for (int i = 0; i < size; i++) {
                newArray[i] = parent.get(i + offset);
            }
            return newArray;
        }

        public void trimToSize() {
            throw new UnsupportedOperationException();
        }

        private void checkBounds(int index) {
            if(!(index >= 0 && index < size)) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override
    public Object[] toArray() {
        //todo test toArray
        return Arrays.copyOf(values,values.length);
    }

    public void trimToSize() {
        values = Arrays.copyOf(values,size);
    }

    public int getCapacity() {
        return values.length;
    }

    private void increaseCapacity() {
        Object[] tmp = new Object[values.length + (values.length == 1 ? 1 : (values.length >> 1))];
        System.arraycopy(values,0,tmp,0,size);
        values = tmp;
    }

    private void checkBounds(int index) {
        if(!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }
}
