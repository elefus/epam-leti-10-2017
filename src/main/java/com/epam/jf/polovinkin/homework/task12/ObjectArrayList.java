package com.epam.jf.polovinkin.homework.task12;

import com.epam.jf.common.homework.task12.AbstractObjectArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectArrayList extends AbstractObjectArrayList {
    protected Object[] values;
    protected int pointer;

    static class Lol {
        public static void main(String[] args) {
            ArrayList<Integer> lol = new ArrayList<>();
            lol.add(1);
            lol.add(2);
            lol.add(3);
            lol.add(4);
            lol.add(5);
            lol.add(6);

            List<Integer> temp = lol.subList(0, 5);
            temp.remove(new Integer(2));
            System.out.println(temp);
        }
    }

    public ObjectArrayList() {
        values = new Object[10];
    }

    public ObjectArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity is below zero");
        values = new Object[capacity];
    }

    public ObjectArrayList(ObjectArrayList list) {
        values = list.values.clone();
        pointer = list.pointer;
    }

    public ObjectArrayList(Object[] list) {
        values = list.clone();
        pointer = list.length;
    }

    @Override
    public boolean add(Object value) {
        if (pointer >= values.length) {
            increaseCapacity();
        }
        values[pointer++] = value;
        return true;

    }

    @Override
    public boolean add(Object value, int index) {
        if (index < 0 || index > pointer) {
            throw new IllegalArgumentException("index is out of range");
        }
        if (pointer >= values.length) {
            increaseCapacity();
        }
        System.arraycopy(values, index, values, index + 1, pointer - index );
        values[index] = value;
        pointer++;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= pointer) {
            throw new IllegalArgumentException("index is out of range");
        }
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < pointer; i++) {
            if (Objects.equals(values[i], value)) return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= pointer) {
            throw new IllegalArgumentException("index is out of range");
        }
        Object value = values[index];
        System.arraycopy(values, index + 1, values, index, pointer - index - 1);
        pointer--;
        return value;
    }

    @Override
    public Object remove(Object value) {
        for (int i = 0; i < pointer; i++) {
            if (Objects.equals(values[i], value)) {
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        return false;
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index >= pointer) {
            throw new IllegalArgumentException("index is out of range");
        }
        Object temp = values[index];
        values[index] = value;
        return temp;

    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        int freeSpace = values.length - pointer;
        int spaceRequired = list.size();
        if (freeSpace < spaceRequired) {
            Object[] temp = new Object[values.length + spaceRequired + 1];
            System.arraycopy(values, 0, temp, 0, pointer);
            values = temp;
        }
        for (int i = 0; i < list.size(); i++) {
            values[pointer + i] = list.get(i);
        }
        pointer += spaceRequired;
        return true;

    }

    @Override
    public void clear() {
        pointer = 0;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < pointer; i++) {
            if (Objects.equals(values[i], value)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (Objects.equals(values[i], value)) return i;
        }
        return -1;

    }

    @Override
    public void trimToSize() {
        Object[] temp = new Object[pointer];
        System.arraycopy(values, 0, temp, 0, pointer);
        values = temp;
    }

    private void increaseCapacity() {
        Object[] temp = new Object[values.length*2 + 1];
        System.arraycopy(values, 0, temp, 0, pointer);
        values = temp;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        if (fromInclusive < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromInclusive);
        if (toInclusive > pointer)
            throw new IndexOutOfBoundsException("toIndex = " + toInclusive);
        if (fromInclusive > toInclusive)
            throw new IllegalArgumentException("fromIndex(" + fromInclusive +
                    ") > toIndex(" + toInclusive + ")");
        return new SubList(this, 0, fromInclusive, toInclusive);
    }

    private class SubList extends AbstractObjectArrayList {
        private final AbstractObjectArrayList parent;
        private final int parentOffset;
        private final int offset;
        int size;


        SubList(AbstractObjectArrayList  parent, int offset, int fromIndex, int toIndex) {
            this.parent = parent;
            this.parentOffset = fromIndex;
            this.offset = offset + fromIndex;
            this.size = toIndex - fromIndex + 1;
        }

        @Override
        public boolean add(Object value) {
            parent.add(value);
            ++size;
            return true;

        }

        @Override
        public boolean add(Object value, int index) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("index is out of range");
            }
            parent.add(value, parentOffset + index);
            size++;
            return true;
        }

        @Override
        public Object get(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("index is out of range");
            }
            return ObjectArrayList.this.values[offset + index];
    }

        @Override
        public boolean contains(Object value) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(parent.get(i + offset), value)) return true;
            }
            return false;
        }

        @Override
        public boolean containsAll(AbstractObjectArrayList list) {
            for (int i = 0; i < list.size(); i++) {
                if (!contains(list.get(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object remove(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("index is out of range");
            }
            Object value = parent.remove(parentOffset + index);
            size--;
            return value;
        }

        @Override
        public Object remove(Object o) {
            if (o==null) {
                for (int i = 0; i < size; i++) {
                    if (get(i) == null) {
                        remove(i);
                        return true;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (o.equals(get(i))) {
                        remove(i);
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public boolean removeAll(AbstractObjectArrayList list) {
            return false;
        }

        @Override
        public Object set(Object value, int index) {
            if (index < 0 || index >= pointer) {
                throw new IllegalArgumentException("index is out of range");
            }
            Object temp = ObjectArrayList.this.values[offset + index];
            ObjectArrayList.this.values[offset + index] = value;
            return temp;

        }

        @Override
        public boolean addAll(AbstractObjectArrayList list) {
            parent.addAll(list);
            this.size += list.size();
            return true;
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
                if (Objects.equals(get(i), value)) return i;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object value) {
            for (int i = size - 1; i >= 0; i--) {
                if (Objects.equals(get(i), value)) return i;
            }
            return -1;

        }

        @Override
        public void trimToSize() {
            parent.trimToSize();
        }

        @Override
        public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
            if (fromInclusive < 0)
                throw new IndexOutOfBoundsException("fromIndex = " + fromInclusive);
            if (toInclusive > pointer)
                throw new IndexOutOfBoundsException("toIndex = " + toInclusive);
            if (fromInclusive > toInclusive)
                throw new IllegalArgumentException("fromIndex(" + fromInclusive +
                        ") > toIndex(" + toInclusive + ")");
            return new SubList(this, offset, fromInclusive, toInclusive);
        }
    }
}
