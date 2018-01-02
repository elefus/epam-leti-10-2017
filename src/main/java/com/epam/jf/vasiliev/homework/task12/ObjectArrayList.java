package com.epam.jf.vasiliev.homework.task12;

import com.epam.jf.common.homework.task12.AbstractObjectArrayList;
import java.util.Arrays;


public class ObjectArrayList extends com.epam.jf.common.homework.task12.AbstractObjectArrayList {

    public static final int DEFAULT_CAPACITY = 10;
    public static final int NOT_FOUND = -1;

    private int size;

    ObjectArrayList() {
        values = new Object[DEFAULT_CAPACITY];
    }

    ObjectArrayList(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("Capacity is < 0");
        }
        values = new Object[capacity];
    }

    ObjectArrayList(ObjectArrayList list) {
        size = list.size;
        values = new Object[size];
        System.arraycopy(list.values, 0, values,0,size);
    }

    @Override
    public boolean add(Object value) {
        if(size + 1 > values.length) {
            increaseCapacity();
        }
        values[size++] = value;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
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
    public Object get(int index) {
        checkBounds(index);
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
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
    public boolean containsAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if(!this.contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        checkBounds(index);

        Object tmp = values[index];
        size--;
        System.arraycopy(values,index + 1,values,index,size - index);
        return tmp;
    }

    @Override
    public Object remove(Object value) {
        int index = indexOf(value);
        return index == NOT_FOUND ? null : remove(index);
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
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
    public Object set(Object value, int index) {
        checkBounds(index);
        Object tmp = values[index];
        values[index] = value;
        return tmp;
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        boolean wasListChanged = false;
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
            wasListChanged = true;
        }
        return wasListChanged;
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
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if(values[i].equals(value)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if(values[i].equals(value)) {
                return i;
            }
        }
        return NOT_FOUND;
    }


    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toExclusive) {
        subListCheckBounds(fromInclusive, toExclusive, size);
        return new SubList(this, fromInclusive, toExclusive);
    }

    @Override
    public void trimToSize() {
        values = Arrays.copyOf(values,size);
    }

    private void checkBounds(int index) {
        if(!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseCapacity() {
        Object[] tmp = new Object[values.length + (values.length == 1 ? 1 : (values.length >> 1))];
        System.arraycopy(values,0,tmp,0,size);
        values = tmp;
    }

    public int getCapacity() {
        return values.length;
    }

    private static void subListCheckBounds(int fromIndex, int toIndex, int size) {
        if(!(fromIndex >= 0 && toIndex < size + 1)) {
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
    }



    private class SubList extends AbstractObjectArrayList {
        private final AbstractObjectArrayList parent;
        private final int offset;
        private int size;

        SubList(AbstractObjectArrayList parent, int fromIndex, int toIndex) {
            this.parent = parent;
            this.offset = fromIndex;
            this.size = toIndex - fromIndex;
        }

        @Override
        public boolean add(Object value) {
            parent.add(value, offset + size);
            size++;
            return true;
        }

        @Override
        public boolean add(Object value, int index) {
            checkBounds(index);
            parent.add(value, offset + index);
            size++;
            return false;
        }

        @Override
        public Object get(int index) {
            checkBounds(index);
            return parent.get(offset + index);
        }

        @Override
        public boolean contains(Object value) {
            for(int i = offset; i < offset + size; ++i) {
                if(parent.get(i).equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(AbstractObjectArrayList list) {
            for(int i = 0; i < list.size();++i) {
                if(!this.contains(list.get(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object remove(int index) {
            checkBounds(index);
            size--;
            return parent.remove(offset + index);
        }

        @Override
        public Object remove(Object value) {
            int indexToDel = indexOf(value);
            if(indexToDel != NOT_FOUND) {
                size--;
                return parent.remove(offset + indexToDel);
            }

            return null;
        }

        @Override
        public boolean removeAll(AbstractObjectArrayList list) {
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
        public Object set(Object value, int index) {
            checkBounds(index);
            return parent.set(value, offset + index);
        }

        @Override
        public boolean addAll(AbstractObjectArrayList list) {
            boolean wasListChanged = false;
            for (int i = 0; i < list.size(); i++) {
                parent.add(list.get(i), offset + size);
                size++;
                wasListChanged = true;
            }
            return wasListChanged;
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
        public int indexOf(Object value) {
            for (int i = 0; i < size; i++) {
                if(parent.get(offset + i).equals(value)) {
                    return i;
                }
            }
            return NOT_FOUND;
        }

        @Override
        public int lastIndexOf(Object value) {
            for (int i = size - 1; i >= 0; i--) {
                if(parent.get(offset + i).equals(value)) {
                    return i;
                }
            }
            return NOT_FOUND;
        }

        @Override
        public AbstractObjectArrayList subList(int fromInclusive, int toExclusive) {
            subListCheckBounds(fromInclusive, toExclusive, size);
            return new SubList(this,fromInclusive, toExclusive);
        }

        @Override
        public void trimToSize() {
            throw new UnsupportedOperationException();
        }

        private void checkBounds(int index) {
            if(!(index >= 0 && index < size)) {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}
