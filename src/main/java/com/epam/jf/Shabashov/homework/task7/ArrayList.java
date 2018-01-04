package com.epam.jf.Shabashov.homework.task7;

public class ArrayList extends AbstractIntArrayList {
    private int size = 0;

    public ArrayList() {
    }


    public ArrayList(int capacity) {
        super(capacity);
    }

    private ArrayList(int[] array) {
        values = array;
        size = values.length;
    }

    public ArrayList(AbstractIntArrayList list) {
        super(list);
    }

    @Override
    public boolean add(int value) {
        if (size + 1 >= values.length) increaseSize();
        values[size++] = value;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        checkIndex(index);
        System.arraycopy(values, index, values, index + 1, size - index);
        size++;
        values[index] = value;
        return true;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.values[i])) return false;
        }
        return true;
    }

    private String IndexOutException(int index) {
        return "Index : " + index + " size : " + size;
    }

    @Override
    public int remove(int index) {
        checkIndex(index);
        int previous = values[index];
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        return previous;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
    }

    @Override
    public int set(int value, int index) {
        checkIndex(index);
        int previous = values[index];
        values[index] = value;
        return previous;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        while (size + 1 >= values.length) increaseSize();
        System.arraycopy(list.values, 0, values, size, list.size());
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
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i] == value) return i;
        }
        return -1;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        checkIndex(fromInclusive);
        checkIndex(toInclusive);
        if (fromInclusive>=toInclusive) throw new IllegalArgumentException();
        return new SubList(this,0,fromInclusive,toInclusive);
    }


    private void increaseSize() {
        int[] arr = new int[values.length + (values.length >> 1)];
        System.arraycopy(values, 0, arr, 0, values.length);
        values = arr;
    }
    @Override
    public boolean addAll(int index,AbstractIntArrayList list){
        checkIndex(index);
        while (size + 1 + list.size() >= values.length) increaseSize();
        Object[] helpArray = new Object[size - index];
        System.arraycopy(values, index, helpArray, 0, size() - index);
        System.arraycopy(list.values, 0, values, index, list.size());
        System.arraycopy(helpArray, 0, values, index + list.size(), helpArray.length);
        size += list.size();
        return true;
    }

    private class SubList extends AbstractIntArrayList {
        private final AbstractIntArrayList parent;
        private final int parentOffset;
        private final int offset;
        int size;

        SubList(AbstractIntArrayList parent, int offset, int fromIndex, int toIndex) {
            this.parent = parent;
            this.parentOffset = fromIndex;
            this.offset = offset + fromIndex;
            this.size = toIndex - fromIndex;
        }


        @Override
        public boolean add(int value) {
            parent.add(offset,value);
            return false;
        }

        @Override
        public boolean add(int value, int index) {
            checkIndex(index);
            parent.add(value,index+offset);
            size++;
            return true;
        }

        @Override
        public int get(int index) {
            checkIndex(index);
            return parent.get(index+offset);
        }

        @Override
        public boolean contains(int value) {
            for (int i = 0; i < size; i++) {
                if (value==parent.get(i+offset)) return true;
            }
            return false;
        }

        @Override
        public boolean containsAll(AbstractIntArrayList list) {
            for (int i = 0; i < list.size(); i++) {
                if (!contains(list.get(i))) return false;
            }
            return true;
        }

        @Override
        public int remove(int index) {
            checkIndex(index);
            size--;
            return parent.remove(index+offset);
        }

        @Override
        public int set(int value, int index) {
            checkIndex(index);
            return parent.set(value,index+offset);
        }

        @Override
        public boolean addAll(AbstractIntArrayList list) {
            size+=list.size();
            return parent.addAll(offset+size+1,list);
        }

        @Override
        public boolean addAll(int index, AbstractIntArrayList list) {
            checkIndex(index);
            size+=list.size();
            return parent.addAll(index+offset,list);
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size==0;
        }

        @Override
        public int indexOf(int value) {
            for (int i = 0; i < size; i++) {
                if (parent.get(i+offset)==value) return i;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(int value) {
            for (int i = size-1; i >= 0; i--) {
                if (parent.get(i+offset)==value) return i;
            }
            return -1;
        }

        @Override
        public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
            return new SubList(parent,fromInclusive,offset,toInclusive);
        }

        private void checkIndex(int index) {
            if (index < 0 || index > size) throw new IndexOutOfBoundsException(IndexOutException(index));
        }

        private String IndexOutException(int index) {
            return "Index : " + index + " size : " + size;
        }
    }
}
