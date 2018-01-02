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
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
        System.arraycopy(values,index,values,index + 1,size - index);
        size++;
        values[index] = value;
        return true;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
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

    private String IndexOutException(int index){
        return "Index : "+index+" size : "+size;
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
        int previous = values[index];
        System.arraycopy(values, index+1, values, index, size - index-1);
        size--;
        return previous;
    }

    @Override
    public int set(int value, int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(IndexOutException(index));
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
        int[] arr = new int[toInclusive-fromInclusive + 1];
        System.arraycopy(values,fromInclusive,arr,0,toInclusive-fromInclusive+1);
        return new ArrayList(arr);
    }


    private void increaseSize() {
        int[] arr = new int[values.length + (values.length >> 1)];
        System.arraycopy(values, 0, arr, 0, values.length);
        values = arr;
    }
}
